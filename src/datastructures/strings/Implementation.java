package datastructures.strings;

import java.util.*;

/**
 * String Implementation
 * 
 * This class contains essential string operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class StringOperations {
    
    /**
     * Check if a string is a palindrome
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return True if palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * Check if a string is a palindrome (case insensitive, alphanumeric only)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return True if palindrome, false otherwise
     */
    public static boolean isPalindromeAlphanumeric(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * Reverse a string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return Reversed string
     */
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    
    /**
     * Find first unique character in string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - at most 26 characters
     * 
     * @param s Input string
     * @return Index of first unique character, or -1 if none
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Check if two strings are anagrams
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - at most 26 characters
     * 
     * @param s First string
     * @param t Second string
     * @return True if anagrams, false otherwise
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] charCount = new int[26];
        
        // Count characters in first string
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Subtract characters in second string
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        
        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) return false;
        }
        return true;
    }
    
    /**
     * Group anagrams together
     * 
     * Time Complexity: O(nk log k) where k is average string length
     * Space Complexity: O(nk)
     * 
     * @param strs Array of strings
     * @return List of grouped anagrams
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            anagramGroups.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
    
    /**
     * Find longest substring without repeating characters
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - at most 26 characters
     * 
     * @param s Input string
     * @return Length of longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    
    /**
     * Find longest palindromic substring
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return Longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    /**
     * Helper method to expand around center for palindrome
     * 
     * @param s String
     * @param left Left index
     * @param right Right index
     * @return Length of palindrome
     */
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    /**
     * Find minimum window substring
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @param t Target string
     * @return Minimum window substring
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
        
        int[] charCount = new int[26];
        for (char c : p.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        int left = 0, right = 0;
        int count = p.length();
        
        while (right < s.length()) {
            if (charCount[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            charCount[s.charAt(right) - 'a']--;
            right++;
            
            if (count == 0) {
                result.add(left);
            }
            
            if (right - left == p.length()) {
                if (charCount[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                charCount[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }
    
    /**
     * Compress string by counting consecutive characters
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param chars Character array
     * @return New length of compressed string
     */
    public static int compress(char[] chars) {
        int write = 0, read = 0;
        
        while (read < chars.length) {
            char current = chars[read];
            int count = 0;
            
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }
            
            chars[write++] = current;
            
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
    
    /**
     * Check if string is valid parentheses
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param s Input string
     * @return True if valid, false otherwise
     */
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    /**
     * Find longest valid parentheses
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param s Input string
     * @return Length of longest valid parentheses
     */
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
    
    /**
     * KMP algorithm for pattern searching
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(m)
     * 
     * @param text Text to search in
     * @param pattern Pattern to search for
     * @return Starting index of pattern, or -1 if not found
     */
    public static int kmpSearch(String text, String pattern) {
        if (pattern.length() == 0) return 0;
        
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return i - j;
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
    
    /**
     * Compute Longest Proper Prefix which is also Suffix
     * 
     * @param pattern Pattern string
     * @return LPS array
     */
    private static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    /**
     * Main method for testing string operations
     */
    public static void main(String[] args) {
        System.out.println("=== String Operations Examples ===");
        
        // Test palindrome
        System.out.println("Is 'racecar' palindrome? " + isPalindrome("racecar"));
        System.out.println("Is 'A man a plan a canal Panama' palindrome? " + isPalindromeAlphanumeric("A man a plan a canal Panama"));
        
        // Test reverse
        System.out.println("Reverse of 'hello': " + reverseString("hello"));
        
        // Test first unique character
        System.out.println("First unique character in 'leetcode': " + firstUniqChar("leetcode"));
        
        // Test anagram
        System.out.println("Are 'anagram' and 'nagaram' anagrams? " + isAnagram("anagram", "nagaram"));
        
        // Test group anagrams
        String[] anagramArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Grouped anagrams: " + groupAnagrams(anagramArray));
        
        // Test longest substring
        System.out.println("Longest substring without repeating characters in 'abcabcbb': " + lengthOfLongestSubstring("abcabcbb"));
        
        // Test longest palindrome
        System.out.println("Longest palindromic substring in 'babad': " + longestPalindrome("babad"));
        
        // Test minimum window
        System.out.println("Minimum window substring: " + minWindow("ADOBECODEBANC", "ABC"));
        
        // Test find anagrams
        System.out.println("Anagrams of 'cbaebabacd' with pattern 'abc': " + findAnagrams("cbaebabacd", "abc"));
        
        // Test compress
        char[] compressArray = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compress(compressArray);
        System.out.println("Compressed string length: " + newLength);
        
        // Test valid parentheses
        System.out.println("Is '()[]{}' valid? " + isValidParentheses("()[]{}"));
        System.out.println("Is '([)]' valid? " + isValidParentheses("([)]"));
        
        // Test longest valid parentheses
        System.out.println("Longest valid parentheses in '(()': " + longestValidParentheses("(()"));
        
        // Test KMP search
        System.out.println("KMP search for 'abc' in 'ababcabcab': " + kmpSearch("ababcabcab", "abc"));
    }
}
