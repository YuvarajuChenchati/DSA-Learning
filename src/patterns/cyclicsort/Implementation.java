package patterns.cyclicsort;

import java.util.*;

/**
 * Cyclic Sort Implementation
 * 
 * This class contains essential cyclic sort algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class CyclicSort {
    
    /**
     * Cyclic sort for numbers in range [1, n]
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers in range [1, n]
     */
    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
    }
    
    /**
     * Find missing number in range [1, n]
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Missing number
     */
    public static int findMissingNumber(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    /**
     * Find all missing numbers in range [1, n]
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return List of missing numbers
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Mark numbers as negative
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        // Find positive numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
    
    /**
     * Find duplicate number in range [1, n]
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Duplicate number
     */
    public static int findDuplicate(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }
    
    /**
     * Find all duplicate numbers
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return List of duplicate numbers
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
    
    /**
     * Set mismatch - find duplicate and missing number
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Array with duplicate and missing number
     */
    public static int[] findErrorNums(int[] nums) {
        cyclicSort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        
        return new int[]{};
    }
    
    /**
     * First missing positive number
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return First missing positive number
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Replace negative numbers, zeros, and numbers > n with n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        
        // Mark numbers as negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        
        // Find first positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
    
    /**
     * Find duplicate number using Floyd's cycle detection
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Duplicate number
     */
    public static int findDuplicateFloyd(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Find meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Find duplicate
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
    
    /**
     * Find all numbers disappeared in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return List of disappeared numbers
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Mark numbers as negative
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        // Find positive numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
    
    /**
     * Find all duplicates in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return List of duplicate numbers
     */
    public static List<Integer> findAllDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
    
    /**
     * Find the duplicate number (only one duplicate)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Duplicate number
     */
    public static int findTheDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Find meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Find duplicate
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
    
    /**
     * Find all numbers disappeared in array (alternative approach)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return List of disappeared numbers
     */
    public static List<Integer> findDisappearedNumbersAlt(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Add n to numbers at their correct positions
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }
        
        // Find numbers that are less than n
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                result.add(i + 1);
            }
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
     * Main method for testing cyclic sort algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Cyclic Sort Examples ===");
        
        // Test cyclic sort
        int[] nums = {3, 1, 4, 2, 5};
        System.out.println("Original array: " + Arrays.toString(nums));
        cyclicSort(nums);
        System.out.println("Cyclic sorted: " + Arrays.toString(nums));
        
        // Test find missing number
        int[] missingNums = {3, 0, 1};
        System.out.println("Missing number: " + findMissingNumber(missingNums));
        
        // Test find disappeared numbers
        int[] disappearedNums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Disappeared numbers: " + findDisappearedNumbers(disappearedNums));
        
        // Test find duplicate
        int[] duplicateNums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number: " + findDuplicate(duplicateNums));
        
        // Test find duplicates
        int[] duplicatesNums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicate numbers: " + findDuplicates(duplicatesNums));
        
        // Test set mismatch
        int[] errorNums = {1, 2, 2, 4};
        System.out.println("Set mismatch: " + Arrays.toString(findErrorNums(errorNums)));
        
        // Test first missing positive
        int[] positiveNums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(positiveNums));
        
        // Test find duplicate using Floyd's algorithm
        int[] floydNums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate using Floyd's: " + findDuplicateFloyd(floydNums));
        
        // Test find all duplicates
        int[] allDuplicates = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("All duplicates: " + findAllDuplicates(allDuplicates));
        
        // Test find the duplicate
        int[] theDuplicate = {1, 3, 4, 2, 2};
        System.out.println("The duplicate: " + findTheDuplicate(theDuplicate));
        
        // Test alternative approach for disappeared numbers
        int[] altDisappeared = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Disappeared numbers (alt): " + findDisappearedNumbersAlt(altDisappeared));
    }
}
