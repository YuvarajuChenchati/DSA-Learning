package algorithms.searching;

import java.util.*;

/**
 * Searching Algorithms Implementation
 * 
 * This class contains essential searching algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class SearchingAlgorithms {
    
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
     * Binary search in sorted array (iterative)
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
     * Binary search in sorted array (recursive)
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * 
     * @param arr Sorted input array
     * @param target Element to search
     * @param left Left boundary
     * @param right Right boundary
     * @return Index of target, or -1 if not found
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Find first occurrence of target
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Element to search
     * @return Index of first occurrence, or -1 if not found
     */
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching in left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    /**
     * Find last occurrence of target
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Element to search
     * @return Index of last occurrence, or -1 if not found
     */
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching in right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    /**
     * Find count of target in sorted array
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Element to count
     * @return Count of target
     */
    public static int countOccurrences(int[] arr, int target) {
        int first = findFirst(arr, target);
        if (first == -1) return 0;
        
        int last = findLast(arr, target);
        return last - first + 1;
    }
    
    /**
     * Search in rotated sorted array
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Rotated sorted array
     * @param target Element to search
     * @return Index of target, or -1 if not found
     */
    public static int searchRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            // Check which half is sorted
            if (arr[left] <= arr[mid]) {
                // Left half is sorted
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
    /**
     * Find minimum in rotated sorted array
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Rotated sorted array
     * @return Minimum element
     */
    public static int findMinRotated(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }
    
    /**
     * Search in 2D matrix
     * 
     * Time Complexity: O(log(mn))
     * Space Complexity: O(1)
     * 
     * @param matrix 2D matrix
     * @param target Element to search
     * @return True if found, false otherwise
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    /**
     * Find peak element
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Input array
     * @return Index of peak element
     */
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    /**
     * Jump search in sorted array
     * 
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Element to search
     * @return Index of target, or -1 if not found
     */
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;
        
        // Find the block where target might be
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        }
        
        // Linear search in the block
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) return -1;
        }
        
        return arr[prev] == target ? prev : -1;
    }
    
    /**
     * Interpolation search
     * 
     * Time Complexity: O(log log n) average, O(n) worst case
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Element to search
     * @return Index of target, or -1 if not found
     */
    public static int interpolationSearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right && target >= arr[left] && target <= arr[right]) {
            if (left == right) {
                return arr[left] == target ? left : -1;
            }
            
            int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);
            
            if (arr[pos] == target) {
                return pos;
            } else if (arr[pos] < target) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return -1;
    }
    
    /**
     * Exponential search
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Element to search
     * @return Index of target, or -1 if not found
     */
    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) return 0;
        
        int bound = 1;
        while (bound < arr.length && arr[bound] < target) {
            bound *= 2;
        }
        
        return binarySearchRecursive(arr, target, bound / 2, Math.min(bound, arr.length - 1));
    }
    
    /**
     * Find square root using binary search
     * 
     * Time Complexity: O(log x)
     * Space Complexity: O(1)
     * 
     * @param x Number to find square root of
     * @return Square root
     */
    public static int sqrt(int x) {
        if (x < 2) return x;
        
        int left = 2, right = x / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    /**
     * Find k closest elements
     * 
     * Time Complexity: O(log n + k)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted input array
     * @param target Target element
     * @param k Number of closest elements
     * @return List of k closest elements
     */
    public static List<Integer> findKClosest(int[] arr, int target, int k) {
        List<Integer> result = new ArrayList<>();
        
        // Find the position of target or where it should be inserted
        int left = 0, right = arr.length - 1;
        int pos = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Use two pointers to find k closest elements
        int leftPtr = pos;
        int rightPtr = pos + 1;
        
        for (int i = 0; i < k; i++) {
            if (leftPtr < 0) {
                result.add(arr[rightPtr++]);
            } else if (rightPtr >= arr.length) {
                result.add(arr[leftPtr--]);
            } else if (Math.abs(arr[leftPtr] - target) <= Math.abs(arr[rightPtr] - target)) {
                result.add(arr[leftPtr--]);
            } else {
                result.add(arr[rightPtr++]);
            }
        }
        
        Collections.sort(result);
        return result;
    }
    
    /**
     * Main method for testing searching algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Searching Algorithms Examples ===");
        
        // Test data
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        int[] duplicateArray = {1, 2, 2, 2, 3, 4, 5};
        
        // Test linear search
        System.out.println("Linear search for 5: " + linearSearch(sortedArray, 5));
        System.out.println("Linear search for 11: " + linearSearch(sortedArray, 11));
        
        // Test binary search
        System.out.println("Binary search for 5: " + binarySearch(sortedArray, 5));
        System.out.println("Binary search for 11: " + binarySearch(sortedArray, 11));
        
        // Test first and last occurrence
        System.out.println("First occurrence of 2: " + findFirst(duplicateArray, 2));
        System.out.println("Last occurrence of 2: " + findLast(duplicateArray, 2));
        System.out.println("Count of 2: " + countOccurrences(duplicateArray, 2));
        
        // Test rotated array search
        System.out.println("Search in rotated array for 0: " + searchRotated(rotatedArray, 0));
        System.out.println("Minimum in rotated array: " + findMinRotated(rotatedArray));
        
        // Test 2D matrix search
        int[][] matrix = {{1, 4, 7, 11}, {2, 5, 8, 12}, {3, 6, 9, 16}};
        System.out.println("Search in 2D matrix for 5: " + searchMatrix(matrix, 5));
        
        // Test peak finding
        int[] peakArray = {1, 3, 20, 4, 1, 0};
        System.out.println("Peak element index: " + findPeak(peakArray));
        
        // Test advanced searches
        System.out.println("Jump search for 5: " + jumpSearch(sortedArray, 5));
        System.out.println("Interpolation search for 5: " + interpolationSearch(sortedArray, 5));
        System.out.println("Exponential search for 5: " + exponentialSearch(sortedArray, 5));
        
        // Test square root
        System.out.println("Square root of 8: " + sqrt(8));
        
        // Test k closest elements
        int[] kClosestArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("3 closest to 5: " + findKClosest(kClosestArray, 5, 3));
    }
}
