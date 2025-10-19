package patterns.topkelements;

import java.util.*;

/**
 * Top K Elements Implementation
 * 
 * This class contains essential top K elements algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class TopKElements {
    
    /**
     * Find kth largest element
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * @param nums Array of numbers
     * @param k Kth largest
     * @return Kth largest element
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    /**
     * Find kth smallest element
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * @param nums Array of numbers
     * @param k Kth smallest
     * @return Kth smallest element
     */
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        return maxHeap.peek();
    }
    
    /**
     * Find top K frequent elements
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(n)
     * 
     * @param nums Array of numbers
     * @param k Number of frequent elements
     * @return List of top K frequent elements
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );
        
        for (int num : count.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        return new ArrayList<>(heap);
    }
    
    /**
     * Find top K frequent words
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(n)
     * 
     * @param words Array of words
     * @param k Number of frequent words
     * @return List of top K frequent words
     */
    public static List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> heap = new PriorityQueue<>(
            (a, b) -> {
                int freqA = count.get(a);
                int freqB = count.get(b);
                if (freqA == freqB) {
                    return b.compareTo(a); // Lexicographically smaller first
                }
                return freqA - freqB; // Less frequent first
            }
        );
        
        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }
    
    /**
     * Find K closest points to origin
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * @param points Array of points
     * @param k Number of closest points
     * @return List of K closest points
     */
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    
    /**
     * Find K closest elements to target
     * 
     * Time Complexity: O(log n + k)
     * Space Complexity: O(1)
     * 
     * @param arr Sorted array
     * @param k Number of closest elements
     * @param x Target value
     * @return List of K closest elements
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    
    /**
     * Kth largest element in stream
     * 
     * Time Complexity: O(log k) for add, O(1) for get
     * Space Complexity: O(k)
     */
    public static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;
        
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();
            
            for (int num : nums) {
                add(num);
            }
        }
        
        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }
    
    /**
     * Find K pairs with smallest sums
     * 
     * Time Complexity: O(k log k)
     * Space Complexity: O(k)
     * 
     * @param nums1 First array
     * @param nums2 Second array
     * @param k Number of pairs
     * @return List of K pairs with smallest sums
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );
        
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{i, 0});
        }
        
        while (k-- > 0 && !heap.isEmpty()) {
            int[] pair = heap.poll();
            result.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            
            if (pair[1] + 1 < nums2.length) {
                heap.offer(new int[]{pair[0], pair[1] + 1});
            }
        }
        
        return result;
    }
    
    /**
     * Find Kth smallest element in sorted matrix
     * 
     * Time Complexity: O(n log(max-min))
     * Space Complexity: O(1)
     * 
     * @param matrix Sorted matrix
     * @param k Kth smallest
     * @return Kth smallest element
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessOrEqual(matrix, mid);
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private static int countLessOrEqual(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        
        return count;
    }
    
    /**
     * Find Kth largest element in array (QuickSelect)
     * 
     * Time Complexity: O(n) average, O(n²) worst case
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @param k Kth largest
     * @return Kth largest element
     */
    public static int findKthLargestQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        
        int pivotIndex = partition(nums, left, right);
        
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }
    
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        
        swap(nums, i, right);
        return i;
    }
    
    /**
     * Merge K sorted lists
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * @param lists Array of sorted lists
     * @return Merged sorted list
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;
            
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
    
    /**
     * ListNode class for linked list
     */
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
     * Main method for testing top K elements algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Top K Elements Examples ===");
        
        // Test kth largest
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("3rd largest: " + findKthLargest(nums, 3));
        
        // Test kth smallest
        System.out.println("3rd smallest: " + findKthSmallest(nums, 3));
        
        // Test top K frequent
        int[] freqNums = {1, 1, 1, 2, 2, 3};
        System.out.println("Top 2 frequent: " + topKFrequent(freqNums, 2));
        
        // Test top K frequent words
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println("Top 2 frequent words: " + topKFrequentWords(words, 2));
        
        // Test K closest points
        int[][] points = {{1, 3}, {-2, 2}};
        System.out.println("K closest points: " + Arrays.deepToString(kClosest(points, 1)));
        
        // Test K closest elements
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("K closest elements: " + findClosestElements(arr, 4, 3));
        
        // Test Kth largest in stream
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("Kth largest in stream: " + kthLargest.add(3));
        System.out.println("Kth largest in stream: " + kthLargest.add(5));
        
        // Test K smallest pairs
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        System.out.println("K smallest pairs: " + kSmallestPairs(nums1, nums2, 3));
        
        // Test Kth smallest in sorted matrix
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println("Kth smallest in matrix: " + kthSmallest(matrix, 8));
        
        // Test Kth largest with QuickSelect
        System.out.println("3rd largest (QuickSelect): " + findKthLargestQuickSelect(nums, 3));
    }
}
