package fundamentals.complexity;

/**
 * Complexity Analysis Implementation
 * 
 * This class demonstrates various time and space complexity examples
 * with detailed analysis and Big O notation explanations.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class ComplexityAnalysis {
    
    /**
     * O(1) - Constant Time Complexity
     * 
     * Time: O(1) - Single operation regardless of input size
     * Space: O(1) - No additional space used
     * 
     * @param arr The input array
     * @return The first element of the array
     */
    public static int getFirstElement(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        return arr[0];
    }
    
    /**
     * O(1) - Constant Time Complexity
     * 
     * Time: O(1) - Single operation regardless of input size
     * Space: O(1) - No additional space used
     * 
     * @param arr The input array
     * @param index The index to access
     * @return The element at the specified index
     */
    public static int getElementAtIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return arr[index];
    }
    
    /**
     * O(n) - Linear Time Complexity
     * 
     * Time: O(n) - Must check each element once
     * Space: O(1) - Only using a constant amount of extra space
     * 
     * @param arr The input array
     * @return The maximum element in the array
     */
    public static int findMaximum(int[] arr) {
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
     * O(n) - Linear Time Complexity
     * 
     * Time: O(n) - Must check each element once
     * Space: O(1) - Only using a constant amount of extra space
     * 
     * @param arr The input array
     * @return The minimum element in the array
     */
    public static int findMinimum(int[] arr) {
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
     * O(n) - Linear Time Complexity
     * 
     * Time: O(n) - Must check each element once
     * Space: O(1) - Only using a constant amount of extra space
     * 
     * @param arr The input array
     * @param target The element to search for
     * @return The index of the target element, or -1 if not found
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
     * O(log n) - Logarithmic Time Complexity
     * 
     * Time: O(log n) - Eliminates half of the search space each iteration
     * Space: O(1) - Iterative approach uses constant space
     * 
     * @param arr The sorted input array
     * @param target The element to search for
     * @return The index of the target element, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
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
     * O(n²) - Quadratic Time Complexity
     * 
     * Time: O(n²) - Nested loops, each element compared with every other element
     * Space: O(1) - Only using a constant amount of extra space
     * 
     * @param arr The input array
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    
    /**
     * O(n log n) - Linearithmic Time Complexity
     * 
     * Time: O(n log n) - Divide and conquer approach
     * Space: O(n) - Additional space for temporary arrays
     * 
     * @param arr The input array
     */
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        mergeSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }
    
    /**
     * O(2ⁿ) - Exponential Time Complexity
     * 
     * Time: O(2ⁿ) - Each call makes two recursive calls
     * Space: O(n) - Maximum depth of recursion stack
     * 
     * @param n The input number
     * @return The nth Fibonacci number
     */
    public static int fibonacciNaive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
    }
    
    /**
     * O(n) - Linear Time Complexity (Optimized)
     * 
     * Time: O(n) - Each number calculated once
     * Space: O(1) - Only using a constant amount of extra space
     * 
     * @param n The input number
     * @return The nth Fibonacci number
     */
    public static int fibonacciOptimized(int n) {
        if (n <= 1) {
            return n;
        }
        
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    /**
     * O(n) - Linear Time Complexity
     * 
     * Time: O(n) - Must check each element once
     * Space: O(n) - Additional space for the result array
     * 
     * @param arr The input array
     * @return A new array with each element doubled
     */
    public static int[] doubleArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2;
        }
        return result;
    }
    
    /**
     * O(n) - Linear Time Complexity
     * 
     * Time: O(n) - Must check each element once
     * Space: O(1) - Modifying array in-place
     * 
     * @param arr The input array
     */
    public static void doubleArrayInPlace(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
    
    /**
     * O(n²) - Quadratic Time Complexity
     * 
     * Time: O(n²) - Nested loops, each element compared with every other element
     * Space: O(1) - Only using a constant amount of extra space
     * 
     * @param arr The input array
     * @return True if the array contains duplicates, false otherwise
     */
    public static boolean containsDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * O(n) - Linear Time Complexity
     * 
     * Time: O(n) - Must check each element once
     * Space: O(n) - Additional space for the hash set
     * 
     * @param arr The input array
     * @return True if the array contains duplicates, false otherwise
     */
    public static boolean containsDuplicatesOptimized(int[] arr) {
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    
    /**
     * Helper method to swap two elements in an array
     * 
     * Time: O(1) - Constant time operation
     * Space: O(1) - No additional space used
     * 
     * @param arr The array
     * @param i First index
     * @param j Second index
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Main method for testing complexity analysis examples
     */
    public static void main(String[] args) {
        // Test data
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("=== Complexity Analysis Examples ===");
        
        // O(1) examples
        System.out.println("O(1) - First element: " + getFirstElement(testArray));
        System.out.println("O(1) - Element at index 2: " + getElementAtIndex(testArray, 2));
        
        // O(n) examples
        System.out.println("O(n) - Maximum: " + findMaximum(testArray));
        System.out.println("O(n) - Minimum: " + findMinimum(testArray));
        System.out.println("O(n) - Linear search for 25: " + linearSearch(testArray, 25));
        
        // O(log n) examples
        System.out.println("O(log n) - Binary search for 5: " + binarySearch(sortedArray, 5));
        
        // O(n²) examples
        System.out.println("O(n²) - Contains duplicates: " + containsDuplicates(testArray));
        System.out.println("O(n) - Contains duplicates (optimized): " + containsDuplicatesOptimized(testArray));
        
        // O(2ⁿ) examples
        System.out.println("O(2ⁿ) - Fibonacci(10) naive: " + fibonacciNaive(10));
        System.out.println("O(n) - Fibonacci(10) optimized: " + fibonacciOptimized(10));
        
        // Array operations
        int[] doubled = doubleArray(testArray);
        System.out.println("O(n) - Doubled array: " + java.util.Arrays.toString(doubled));
        
        // In-place modification
        int[] testArrayCopy = testArray.clone();
        doubleArrayInPlace(testArrayCopy);
        System.out.println("O(n) - Doubled in-place: " + java.util.Arrays.toString(testArrayCopy));
    }
}
