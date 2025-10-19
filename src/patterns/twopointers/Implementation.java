package patterns.twopointers;

import java.util.*;

/**
 * Two Pointers Implementation
 * 
 * This class contains essential two pointers algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class TwoPointers {
    
    /**
     * Two sum in sorted array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Sorted array
     * @param target Target sum
     * @return Indices of two numbers that sum to target
     */
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
    
    /**
     * Three sum
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return List of triplets that sum to zero
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
    
    /**
     * Container with most water
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param height Array of heights
     * @return Maximum area of water that can be contained
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
    /**
     * Remove duplicates from sorted array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Sorted array
     * @return Length of array after removing duplicates
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
    
    /**
     * Remove duplicates from sorted array (allow at most 2 duplicates)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Sorted array
     * @return Length of array after removing duplicates
     */
    public static int removeDuplicatesII(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    
    /**
     * Move zeros to end
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     */
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
    
    /**
     * Remove element
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @param val Value to remove
     * @return Length of array after removing val
     */
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    
    /**
     * Sort colors (Dutch flag problem)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of colors (0=red, 1=white, 2=blue)
     */
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int current = 0;
        
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }
    
    /**
     * Valid palindrome
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
     * Reverse string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     */
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    
    /**
     * Reverse vowels in string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return String with vowels reversed
     */
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
    
    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    
    /**
     * Trapping rain water
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param height Array of heights
     * @return Amount of water that can be trapped
     */
    public static int trap(int[] height) {
        if (height.length <= 2) return 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
    
    /**
     * Squares of sorted array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Sorted array
     * @return Array of squares in sorted order
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1;
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }
    
    /**
     * Helper method to swap elements
     * 
     * @param arr Array
     * @param i First index
     * @param j Second index
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Main method for testing two pointers algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Two Pointers Examples ===");
        
        // Test two sum
        int[] nums = {2, 7, 11, 15};
        System.out.println("Two sum indices: " + Arrays.toString(twoSum(nums, 9)));
        
        // Test three sum
        int[] threeSumNums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Three sum: " + threeSum(threeSumNums));
        
        // Test container with most water
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max area: " + maxArea(heights));
        
        // Test remove duplicates
        int[] duplicates = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(duplicates);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(duplicates, newLength)));
        
        // Test move zeros
        int[] zeros = {0, 1, 0, 3, 12};
        moveZeroes(zeros);
        System.out.println("Array after moving zeros: " + Arrays.toString(zeros));
        
        // Test sort colors
        int[] colors = {2, 0, 2, 1, 1, 0};
        sortColors(colors);
        System.out.println("Sorted colors: " + Arrays.toString(colors));
        
        // Test palindrome
        System.out.println("Is palindrome 'A man a plan a canal Panama': " + isPalindrome("A man a plan a canal Panama"));
        
        // Test reverse vowels
        System.out.println("Reverse vowels 'hello': " + reverseVowels("hello"));
        
        // Test trapping rain water
        int[] rainHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(rainHeights));
        
        // Test sorted squares
        int[] squares = {-4, -1, 0, 3, 10};
        System.out.println("Sorted squares: " + Arrays.toString(sortedSquares(squares)));
    }
}
