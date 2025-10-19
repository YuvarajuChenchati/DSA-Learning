package algorithms.divideconquer;

import java.util.*;

/**
 * Divide and Conquer Implementation
 * 
 * This class contains essential divide and conquer algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class DivideConquerAlgorithms {
    
    /**
     * Merge sort using divide and conquer
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * @param arr Array to sort
     */
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
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
     * Quick sort using divide and conquer
     * 
     * Time Complexity: O(n log n) average, O(n²) worst case
     * Space Complexity: O(log n)
     * 
     * @param arr Array to sort
     */
    public static void quickSort(int[] arr) {
        if (arr.length <= 1) return;
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSortHelper(arr, low, pivot - 1);
            quickSortHelper(arr, pivot + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    /**
     * Binary search using divide and conquer
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * 
     * @param arr Sorted array
     * @param target Target value
     * @param left Left boundary
     * @param right Right boundary
     * @return Index of target, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right);
        } else {
            return binarySearch(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Find peak element using divide and conquer
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * 
     * @param arr Array of numbers
     * @param left Left boundary
     * @param right Right boundary
     * @return Index of peak element
     */
    public static int findPeak(int[] arr, int left, int right) {
        if (left == right) return left;
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] > arr[mid + 1]) {
            return findPeak(arr, left, mid);
        } else {
            return findPeak(arr, mid + 1, right);
        }
    }
    
    /**
     * Find closest pair of points using divide and conquer
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * @param points Array of points
     * @return Minimum distance between any two points
     */
    public static double closestPair(Point[] points) {
        if (points.length < 2) return Double.MAX_VALUE;
        
        // Sort by x-coordinate
        Arrays.sort(points, (a, b) -> Double.compare(a.x, b.x));
        
        return closestPairHelper(points, 0, points.length - 1);
    }
    
    private static double closestPairHelper(Point[] points, int left, int right) {
        if (right - left <= 3) {
            return bruteForceClosest(points, left, right);
        }
        
        int mid = (left + right) / 2;
        double leftDist = closestPairHelper(points, left, mid);
        double rightDist = closestPairHelper(points, mid + 1, right);
        double minDist = Math.min(leftDist, rightDist);
        
        // Check points near the dividing line
        return Math.min(minDist, closestInStrip(points, left, right, mid, minDist));
    }
    
    private static double bruteForceClosest(Point[] points, int left, int right) {
        double minDist = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                minDist = Math.min(minDist, distance(points[i], points[j]));
            }
        }
        return minDist;
    }
    
    private static double closestInStrip(Point[] points, int left, int right, int mid, double minDist) {
        List<Point> strip = new ArrayList<>();
        double midX = points[mid].x;
        
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midX) < minDist) {
                strip.add(points[i]);
            }
        }
        
        // Sort by y-coordinate
        strip.sort((a, b) -> Double.compare(a.y, b.y));
        
        double minStripDist = minDist;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < minDist; j++) {
                minStripDist = Math.min(minStripDist, distance(strip.get(i), strip.get(j)));
            }
        }
        
        return minStripDist;
    }
    
    private static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
    
    /**
     * Point class for geometric algorithms
     */
    public static class Point {
        double x, y;
        
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
    /**
     * Fast exponentiation using divide and conquer
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * 
     * @param base Base number
     * @param exp Exponent
     * @return base^exp
     */
    public static long fastExponentiation(long base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        
        long half = fastExponentiation(base, exp / 2);
        if (exp % 2 == 0) {
            return half * half;
        } else {
            return half * half * base;
        }
    }
    
    /**
     * Modular exponentiation using divide and conquer
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * 
     * @param base Base number
     * @param exp Exponent
     * @param mod Modulus
     * @return (base^exp) % mod
     */
    public static long modularExponentiation(long base, long exp, long mod) {
        if (exp == 0) return 1;
        if (exp == 1) return base % mod;
        
        long half = modularExponentiation(base, exp / 2, mod);
        if (exp % 2 == 0) {
            return (half * half) % mod;
        } else {
            return (half * half * base) % mod;
        }
    }
    
    /**
     * Strassen's matrix multiplication using divide and conquer
     * 
     * Time Complexity: O(n^log7) ≈ O(n^2.81)
     * Space Complexity: O(n²)
     * 
     * @param A First matrix
     * @param B Second matrix
     * @return Result matrix
     */
    public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;
        if (n <= 2) {
            return standardMultiply(A, B);
        }
        
        int half = n / 2;
        
        // Divide matrices into quarters
        int[][] A11 = new int[half][half];
        int[][] A12 = new int[half][half];
        int[][] A21 = new int[half][half];
        int[][] A22 = new int[half][half];
        int[][] B11 = new int[half][half];
        int[][] B12 = new int[half][half];
        int[][] B21 = new int[half][half];
        int[][] B22 = new int[half][half];
        
        // Split matrices
        splitMatrix(A, A11, A12, A21, A22, half);
        splitMatrix(B, B11, B12, B21, B22, half);
        
        // Calculate Strassen's formulas
        int[][] P1 = strassenMultiply(addMatrices(A11, A22), addMatrices(B11, B22));
        int[][] P2 = strassenMultiply(addMatrices(A21, A22), B11);
        int[][] P3 = strassenMultiply(A11, subtractMatrices(B12, B22));
        int[][] P4 = strassenMultiply(A22, subtractMatrices(B21, B11));
        int[][] P5 = strassenMultiply(addMatrices(A11, A12), B22);
        int[][] P6 = strassenMultiply(subtractMatrices(A21, A11), addMatrices(B11, B12));
        int[][] P7 = strassenMultiply(subtractMatrices(A12, A22), addMatrices(B21, B22));
        
        // Calculate result quarters
        int[][] C11 = addMatrices(subtractMatrices(addMatrices(P1, P4), P5), P7);
        int[][] C12 = addMatrices(P3, P5);
        int[][] C21 = addMatrices(P2, P4);
        int[][] C22 = addMatrices(subtractMatrices(addMatrices(P1, P3), P2), P6);
        
        // Combine quarters
        return combineMatrices(C11, C12, C21, C22, n);
    }
    
    private static void splitMatrix(int[][] matrix, int[][] a11, int[][] a12, int[][] a21, int[][] a22, int half) {
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                a11[i][j] = matrix[i][j];
                a12[i][j] = matrix[i][j + half];
                a21[i][j] = matrix[i + half][j];
                a22[i][j] = matrix[i + half][j + half];
            }
        }
    }
    
    private static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
    
    private static int[][] subtractMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }
    
    private static int[][] combineMatrices(int[][] c11, int[][] c12, int[][] c21, int[][] c22, int n) {
        int[][] C = new int[n][n];
        int half = n / 2;
        
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                C[i][j] = c11[i][j];
                C[i][j + half] = c12[i][j];
                C[i + half][j] = c21[i][j];
                C[i + half][j + half] = c22[i][j];
            }
        }
        return C;
    }
    
    private static int[][] standardMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    
    /**
     * Find maximum subarray sum using divide and conquer
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(log n)
     * 
     * @param arr Array of numbers
     * @return Maximum subarray sum
     */
    public static int maxSubarraySum(int[] arr) {
        return maxSubarraySumHelper(arr, 0, arr.length - 1);
    }
    
    private static int maxSubarraySumHelper(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        
        int mid = (left + right) / 2;
        
        int leftSum = maxSubarraySumHelper(arr, left, mid);
        int rightSum = maxSubarraySumHelper(arr, mid + 1, right);
        int crossSum = maxCrossingSum(arr, left, mid, right);
        
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    
    private static int maxCrossingSum(int[] arr, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }
        
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }
        
        return leftSum + rightSum;
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
     * Main method for testing divide and conquer algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Divide and Conquer Examples ===");
        
        // Test merge sort
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Merge sorted: " + Arrays.toString(arr));
        
        // Test quick sort
        int[] quickArr = {64, 34, 25, 12, 22, 11, 90};
        quickSort(quickArr);
        System.out.println("Quick sorted: " + Arrays.toString(quickArr));
        
        // Test binary search
        int[] searchArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Binary search for 5: " + binarySearch(searchArr, 5, 0, searchArr.length - 1));
        
        // Test peak finding
        int[] peakArr = {1, 3, 20, 4, 1, 0};
        System.out.println("Peak element index: " + findPeak(peakArr, 0, peakArr.length - 1));
        
        // Test closest pair
        Point[] points = {
            new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3)
        };
        System.out.println("Closest pair distance: " + closestPair(points));
        
        // Test fast exponentiation
        System.out.println("2^10: " + fastExponentiation(2, 10));
        System.out.println("2^10 mod 7: " + modularExponentiation(2, 10, 7));
        
        // Test maximum subarray sum
        int[] subarrayArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubarraySum(subarrayArr));
    }
}
