package algorithms.sorting;

import java.util.*;

/**
 * Sorting Algorithms Implementation
 * 
 * This class contains essential sorting algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class SortingAlgorithms {
    
    /**
     * Bubble Sort
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * Stable: Yes
     * 
     * @param arr Array to sort
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimized version
        }
    }
    
    /**
     * Selection Sort
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * Stable: No
     * 
     * @param arr Array to sort
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }
    
    /**
     * Insertion Sort
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * Stable: Yes
     * 
     * @param arr Array to sort
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Merge Sort
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * Stable: Yes
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
     * Quick Sort
     * 
     * Time Complexity: O(n log n) average, O(n²) worst case
     * Space Complexity: O(log n)
     * Stable: No
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
     * Heap Sort
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * Stable: No
     * 
     * @param arr Array to sort
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    
    /**
     * Counting Sort
     * 
     * Time Complexity: O(n + k)
     * Space Complexity: O(k)
     * Stable: Yes
     * 
     * @param arr Array to sort
     */
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);
        int range = max - min + 1;
        
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Count occurrences
        for (int num : arr) {
            count[num - min]++;
        }
        
        // Modify count array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        // Copy output to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    
    /**
     * Radix Sort
     * 
     * Time Complexity: O(d(n + k))
     * Space Complexity: O(n + k)
     * Stable: Yes
     * 
     * @param arr Array to sort
     */
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        
        // Count occurrences
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }
        
        // Modify count array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        // Copy output to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    
    /**
     * Bucket Sort
     * 
     * Time Complexity: O(n + k) average, O(n²) worst case
     * Space Complexity: O(n + k)
     * Stable: Yes
     * 
     * @param arr Array to sort
     */
    public static void bucketSort(double[] arr) {
        int n = arr.length;
        if (n <= 0) return;
        
        // Create buckets
        List<List<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }
        
        // Put elements in buckets
        for (double num : arr) {
            int bucketIndex = (int) (n * num);
            buckets.get(bucketIndex).add(num);
        }
        
        // Sort individual buckets
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
        }
        
        // Concatenate buckets
        int index = 0;
        for (List<Double> bucket : buckets) {
            for (double num : bucket) {
                arr[index++] = num;
            }
        }
    }
    
    /**
     * Shell Sort
     * 
     * Time Complexity: O(n log n) to O(n²)
     * Space Complexity: O(1)
     * Stable: No
     * 
     * @param arr Array to sort
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
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
     * Main method for testing sorting algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Sorting Algorithms Examples ===");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        // Test bubble sort
        int[] bubbleArr = arr.clone();
        bubbleSort(bubbleArr);
        System.out.println("Bubble sort: " + Arrays.toString(bubbleArr));
        
        // Test selection sort
        int[] selectionArr = arr.clone();
        selectionSort(selectionArr);
        System.out.println("Selection sort: " + Arrays.toString(selectionArr));
        
        // Test insertion sort
        int[] insertionArr = arr.clone();
        insertionSort(insertionArr);
        System.out.println("Insertion sort: " + Arrays.toString(insertionArr));
        
        // Test merge sort
        int[] mergeArr = arr.clone();
        mergeSort(mergeArr);
        System.out.println("Merge sort: " + Arrays.toString(mergeArr));
        
        // Test quick sort
        int[] quickArr = arr.clone();
        quickSort(quickArr);
        System.out.println("Quick sort: " + Arrays.toString(quickArr));
        
        // Test heap sort
        int[] heapArr = arr.clone();
        heapSort(heapArr);
        System.out.println("Heap sort: " + Arrays.toString(heapArr));
        
        // Test counting sort
        int[] countingArr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(countingArr);
        System.out.println("Counting sort: " + Arrays.toString(countingArr));
        
        // Test radix sort
        int[] radixArr = {170, 45, 75, 90, 2, 802, 24, 66};
        radixSort(radixArr);
        System.out.println("Radix sort: " + Arrays.toString(radixArr));
        
        // Test bucket sort
        double[] bucketArr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        bucketSort(bucketArr);
        System.out.println("Bucket sort: " + Arrays.toString(bucketArr));
        
        // Test shell sort
        int[] shellArr = arr.clone();
        shellSort(shellArr);
        System.out.println("Shell sort: " + Arrays.toString(shellArr));
    }
}
