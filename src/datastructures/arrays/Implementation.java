package datastructures.arrays;

import java.util.*;

/**
 * Array Implementation
 * 
 * This class contains essential array operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class ArrayOperations {
    
    /**
     * Linear search in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Input array
     * @param target Element to search
     * @return Index of target, or -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Binary search in sorted array
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Element to search
     * @return Index of target, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    /**
     * Find maximum element in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Input array
     * @return Maximum element
     */
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Find minimum element in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Input array
     * @return Minimum element
     */
    public static int findMin(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    /**
     * Reverse array in-place
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Array to reverse
     */
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    
    /**
     * Rotate array to the right by k positions
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Array to rotate
     * @param k Number of positions to rotate
     */
    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle k > n
        
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
    }
    
    /**
     * Helper method to reverse array from start to end
     * 
     * @param arr Array to reverse
     * @param start Start index
     * @param end End index
     */
    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
    /**
     * Remove duplicates from sorted array in-place
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted array
     * @return New length of array
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        
        int writeIndex = 1;
        for (int readIndex = 1; readIndex < arr.length; readIndex++) {
            if (arr[readIndex] != arr[readIndex - 1]) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
        }
        return writeIndex;
    }
    
    /**
     * Two sum problem - find two numbers that sum to target
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param nums Input array
     * @param target Target sum
     * @return Indices of two numbers that sum to target
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    
    /**
     * Two sum in sorted array using two pointers
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted array
     * @param target Target sum
     * @return Indices of two numbers that sum to target
     */
    public static int[] twoSumSorted(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
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
     * Three sum problem - find all unique triplets that sum to zero
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * @param nums Input array
     * @return List of unique triplets
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
     * Maximum subarray sum using Kadane's algorithm
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Input array
     * @return Maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
    /**
     * Product of array except self
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Input array
     * @return Array where each element is product of all other elements
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        // First pass: calculate left products
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Second pass: calculate right products and multiply
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
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
     * @return Maximum area of water
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
     * Trapping rain water
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param height Array of heights
     * @return Amount of trapped water
     */
    public static int trap(int[] height) {
        if (height.length < 3) return 0;
        
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
     * Find first missing positive integer
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Input array
     * @return First missing positive integer
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Mark numbers outside range as n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        
        // Mark present numbers as negative
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
     * Merge two sorted arrays
     * 
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     * 
     * @param nums1 First sorted array
     * @param m Length of first array
     * @param nums2 Second sorted array
     * @param n Length of second array
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    
    /**
     * Find median of two sorted arrays
     * 
     * Time Complexity: O(log(min(m, n)))
     * Space Complexity: O(1)
     * 
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return Median of combined arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        return -1;
    }
    
    /**
     * Helper method to swap two elements in array
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
     * Main method for testing array operations
     */
    public static void main(String[] args) {
        System.out.println("=== Array Operations Examples ===");
        
        // Test data
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};
        int[] duplicateArray = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        
        // Basic operations
        System.out.println("Linear search for 5: " + linearSearch(testArray, 5));
        System.out.println("Binary search for 5: " + binarySearch(testArray, 5));
        System.out.println("Maximum element: " + findMax(testArray));
        System.out.println("Minimum element: " + findMin(testArray));
        
        // Array manipulation
        int[] reverseArray = testArray.clone();
        reverseArray(reverseArray);
        System.out.println("Reversed array: " + Arrays.toString(reverseArray));
        
        int[] rotateArray = testArray.clone();
        rotateArray(rotateArray, 3);
        System.out.println("Rotated array by 3: " + Arrays.toString(rotateArray));
        
        // Remove duplicates
        int[] noDuplicates = duplicateArray.clone();
        int newLength = removeDuplicates(noDuplicates);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(noDuplicates, newLength)));
        
        // Two sum
        int[] twoSumResult = twoSum(testArray, 9);
        System.out.println("Two sum indices for target 9: " + Arrays.toString(twoSumResult));
        
        // Three sum
        int[] threeSumArray = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSumResult = threeSum(threeSumArray);
        System.out.println("Three sum result: " + threeSumResult);
        
        // Maximum subarray
        int[] maxSubArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubArray(maxSubArray));
        
        // Product except self
        int[] productArray = {1, 2, 3, 4};
        int[] productResult = productExceptSelf(productArray);
        System.out.println("Product except self: " + Arrays.toString(productResult));
        
        // Container with most water
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum area: " + maxArea(height));
        
        // Trapping rain water
        int[] trapHeight = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(trapHeight));
        
        // First missing positive
        int[] missingPositive = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(missingPositive));
        
        // Merge sorted arrays
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println("Merged sorted arrays: " + Arrays.toString(nums1));
        
        // Find median
        int[] median1 = {1, 3};
        int[] median2 = {2};
        System.out.println("Median of sorted arrays: " + findMedianSortedArrays(median1, median2));
    }
}
