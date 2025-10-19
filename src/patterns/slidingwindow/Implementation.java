package patterns.slidingwindow;

import java.util.*;

/**
 * Sliding Window Implementation
 * 
 * This class contains essential sliding window algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class SlidingWindow {
    
    /**
     * Maximum sum of subarray of size k
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Array of numbers
     * @param k Window size
     * @return Maximum sum of subarray of size k
     */
    public static int maxSumSubarray(int[] arr, int k) {
        if (arr.length < k) return -1;
        
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    /**
     * Average of subarrays of size k
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Array of numbers
     * @param k Window size
     * @return Array of averages
     */
    public static double[] findAverages(int[] arr, int k) {
        double[] result = new double[arr.length - k + 1];
        int windowSum = 0;
        
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        for (int i = k; i < arr.length; i++) {
            result[i - k] = (double) windowSum / k;
            windowSum += arr[i] - arr[i - k];
        }
        result[arr.length - k] = (double) windowSum / k;
        
        return result;
    }
    
    /**
     * Longest substring with k distinct characters
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     * 
     * @param s Input string
     * @param k Number of distinct characters
     * @return Length of longest substring with k distinct characters
     */
    public static int longestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    
    /**
     * Longest substring without repeating characters
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(min(m, n))
     * 
     * @param s Input string
     * @return Length of longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (charIndex.containsKey(c) && charIndex.get(c) >= left) {
                left = charIndex.get(c) + 1;
            }
            charIndex.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    
    /**
     * Minimum window substring
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @param t Target string
     * @return Minimum window substring containing all characters of t
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int count = t.length();
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (targetCount.containsKey(rightChar)) {
                if (targetCount.get(rightChar) > 0) {
                    count--;
                }
                targetCount.put(rightChar, targetCount.get(rightChar) - 1);
            }
            right++;
            
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                if (targetCount.containsKey(leftChar)) {
                    targetCount.put(leftChar, targetCount.get(leftChar) + 1);
                    if (targetCount.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    
    /**
     * Find all anagrams in string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @param p Pattern string
     * @return List of starting indices of anagrams
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        Map<Character, Integer> pCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int count = p.length();
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (pCount.containsKey(rightChar)) {
                if (pCount.get(rightChar) > 0) {
                    count--;
                }
                pCount.put(rightChar, pCount.get(rightChar) - 1);
            }
            right++;
            
            while (count == 0) {
                if (right - left == p.length()) {
                    result.add(left);
                }
                
                char leftChar = s.charAt(left);
                if (pCount.containsKey(leftChar)) {
                    pCount.put(leftChar, pCount.get(leftChar) + 1);
                    if (pCount.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }
    
    /**
     * Longest repeating character replacement
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @param k Maximum number of replacements
     * @return Length of longest substring with same character after k replacements
     */
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxCount = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, charCount.get(rightChar));
            
            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    
    /**
     * Subarray product less than k
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @param k Target product
     * @return Number of subarrays with product less than k
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        
        int left = 0, product = 1, count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            
            count += right - left + 1;
        }
        return count;
    }
    
    /**
     * Maximum sum of any contiguous subarray of size k
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @param k Window size
     * @return Maximum sum of any contiguous subarray of size k
     */
    public static int maxSumSubarrayK(int[] nums, int k) {
        if (nums.length < k) return -1;
        
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        int maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    /**
     * Fruit into baskets
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param fruits Array of fruit types
     * @return Maximum number of fruits that can be collected
     */
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxFruits = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }
            
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
    
    /**
     * Longest substring with at most two distinct characters
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return Length of longest substring with at most two distinct characters
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            while (charCount.size() > 2) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    
    /**
     * Main method for testing sliding window algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Sliding Window Examples ===");
        
        // Test maximum sum subarray
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println("Max sum subarray of size 3: " + maxSumSubarray(arr, 3));
        
        // Test averages
        int[] avgArr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        System.out.println("Averages of subarrays of size 5: " + Arrays.toString(findAverages(avgArr, 5)));
        
        // Test longest substring with k distinct characters
        System.out.println("Longest substring with 2 distinct chars: " + longestSubstringKDistinct("araaci", 2));
        
        // Test longest substring without repeating characters
        System.out.println("Longest substring without repeating chars: " + lengthOfLongestSubstring("abcabcbb"));
        
        // Test minimum window substring
        System.out.println("Minimum window substring: " + minWindow("ADOBECODEBANC", "ABC"));
        
        // Test find anagrams
        System.out.println("Find anagrams: " + findAnagrams("cbaebabacd", "abc"));
        
        // Test character replacement
        System.out.println("Longest repeating character replacement: " + characterReplacement("AABABBA", 1));
        
        // Test subarray product less than k
        int[] productArr = {10, 5, 2, 6};
        System.out.println("Subarrays with product less than 100: " + numSubarrayProductLessThanK(productArr, 100));
        
        // Test fruit into baskets
        int[] fruits = {1, 2, 1, 2, 3, 3, 3, 3};
        System.out.println("Maximum fruits: " + totalFruit(fruits));
        
        // Test longest substring with at most two distinct characters
        System.out.println("Longest substring with at most 2 distinct chars: " + lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
