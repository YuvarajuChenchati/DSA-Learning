package datastructures.heap;

import java.util.*;

/**
 * Heap Implementation
 * 
 * This class contains essential heap operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class HeapOperations {
    
    /**
     * Min Heap implementation
     */
    public static class MinHeap {
        private List<Integer> heap;
        
        public MinHeap() {
            this.heap = new ArrayList<>();
        }
        
        /**
         * Insert element into heap
         * 
         * Time Complexity: O(log n)
         * Space Complexity: O(1)
         * 
         * @param val Value to insert
         */
        public void insert(int val) {
            heap.add(val);
            heapifyUp(heap.size() - 1);
        }
        
        /**
         * Extract minimum element from heap
         * 
         * Time Complexity: O(log n)
         * Space Complexity: O(1)
         * 
         * @return Minimum element
         */
        public int extractMin() {
            if (heap.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            
            int min = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            
            if (!heap.isEmpty()) {
                heapifyDown(0);
            }
            return min;
        }
        
        /**
         * Get minimum element without removing
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Minimum element
         */
        public int peek() {
            if (heap.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            return heap.get(0);
        }
        
        /**
         * Check if heap is empty
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return heap.isEmpty();
        }
        
        /**
         * Get size of heap
         * 
         * @return Number of elements in heap
         */
        public int size() {
            return heap.size();
        }
        
        /**
         * Heapify up operation
         * 
         * @param index Index to heapify up
         */
        private void heapifyUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap.get(index) >= heap.get(parent)) {
                    break;
                }
                swap(index, parent);
                index = parent;
            }
        }
        
        /**
         * Heapify down operation
         * 
         * @param index Index to heapify down
         */
        private void heapifyDown(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;
                
                if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                    smallest = left;
                }
                if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                    smallest = right;
                }
                
                if (smallest == index) {
                    break;
                }
                
                swap(index, smallest);
                index = smallest;
            }
        }
        
        /**
         * Swap two elements in heap
         * 
         * @param i First index
         * @param j Second index
         */
        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
    
    /**
     * Max Heap implementation
     */
    public static class MaxHeap {
        private List<Integer> heap;
        
        public MaxHeap() {
            this.heap = new ArrayList<>();
        }
        
        /**
         * Insert element into heap
         * 
         * Time Complexity: O(log n)
         * Space Complexity: O(1)
         * 
         * @param val Value to insert
         */
        public void insert(int val) {
            heap.add(val);
            heapifyUp(heap.size() - 1);
        }
        
        /**
         * Extract maximum element from heap
         * 
         * Time Complexity: O(log n)
         * Space Complexity: O(1)
         * 
         * @return Maximum element
         */
        public int extractMax() {
            if (heap.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            
            int max = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            
            if (!heap.isEmpty()) {
                heapifyDown(0);
            }
            return max;
        }
        
        /**
         * Get maximum element without removing
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Maximum element
         */
        public int peek() {
            if (heap.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            return heap.get(0);
        }
        
        /**
         * Check if heap is empty
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return heap.isEmpty();
        }
        
        /**
         * Get size of heap
         * 
         * @return Number of elements in heap
         */
        public int size() {
            return heap.size();
        }
        
        /**
         * Heapify up operation
         * 
         * @param index Index to heapify up
         */
        private void heapifyUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap.get(index) <= heap.get(parent)) {
                    break;
                }
                swap(index, parent);
                index = parent;
            }
        }
        
        /**
         * Heapify down operation
         * 
         * @param index Index to heapify down
         */
        private void heapifyDown(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int largest = index;
                
                if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                    largest = left;
                }
                if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                    largest = right;
                }
                
                if (largest == index) {
                    break;
                }
                
                swap(index, largest);
                index = largest;
            }
        }
        
        /**
         * Swap two elements in heap
         * 
         * @param i First index
         * @param j Second index
         */
        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
    
    /**
     * Heap sort algorithm
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
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
            // Move current root to end
            swap(arr, 0, i);
            
            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }
    
    /**
     * Heapify operation for heap sort
     * 
     * @param arr Array
     * @param n Size of heap
     * @param i Index to heapify
     */
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
     * Find kth largest element using heap
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * @param nums Array of numbers
     * @param k Kth largest
     * @return Kth largest element
     */
    public static int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap();
        
        for (int num : nums) {
            minHeap.insert(num);
            if (minHeap.size() > k) {
                minHeap.extractMin();
            }
        }
        
        return minHeap.peek();
    }
    
    /**
     * Find kth smallest element using heap
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * @param nums Array of numbers
     * @param k Kth smallest
     * @return Kth smallest element
     */
    public static int findKthSmallest(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap();
        
        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.size() > k) {
                maxHeap.extractMax();
            }
        }
        
        return maxHeap.peek();
    }
    
    /**
     * Merge k sorted arrays using heap
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * @param arrays Array of sorted arrays
     * @return Merged sorted array
     */
    public static int[] mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Add first element of each array
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new int[]{arrays[i][0], i, 0});
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int arrayIndex = current[1];
            int elementIndex = current[2];
            
            result.add(value);
            
            if (elementIndex + 1 < arrays[arrayIndex].length) {
                minHeap.offer(new int[]{arrays[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    /**
     * Find median from data stream using two heaps
     * 
     * Time Complexity: O(log n) for add, O(1) for find median
     * Space Complexity: O(n)
     */
    public static class MedianFinder {
        private MaxHeap maxHeap; // For smaller half
        private MinHeap minHeap; // For larger half
        
        public MedianFinder() {
            this.maxHeap = new MaxHeap();
            this.minHeap = new MinHeap();
        }
        
        /**
         * Add number to data stream
         * 
         * @param num Number to add
         */
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.insert(num);
            } else {
                minHeap.insert(num);
            }
            
            // Balance heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.insert(maxHeap.extractMax());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.insert(minHeap.extractMin());
            }
        }
        
        /**
         * Find median of data stream
         * 
         * @return Median value
         */
        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }
    
    /**
     * Helper method to swap elements in array
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
     * Main method for testing heap operations
     */
    public static void main(String[] args) {
        System.out.println("=== Heap Operations Examples ===");
        
        // Test MinHeap
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(1);
        minHeap.insert(5);
        
        System.out.println("MinHeap elements:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }
        System.out.println();
        
        // Test MaxHeap
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(1);
        maxHeap.insert(5);
        
        System.out.println("MaxHeap elements:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.extractMax() + " ");
        }
        System.out.println();
        
        // Test heap sort
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        // Test kth largest
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("3rd largest: " + findKthLargest(nums, 3));
        
        // Test kth smallest
        System.out.println("3rd smallest: " + findKthSmallest(nums, 3));
        
        // Test merge k sorted arrays
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[] merged = mergeKSortedArrays(arrays);
        System.out.println("Merged arrays: " + Arrays.toString(merged));
        
        // Test median finder
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}
