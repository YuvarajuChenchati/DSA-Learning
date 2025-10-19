package datastructures.queue;

import java.util.*;

/**
 * Queue Implementation
 * 
 * This class contains essential queue operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class QueueOperations {
    
    /**
     * Generic Queue implementation using ArrayList
     * 
     * @param <T> Type of elements in queue
     */
    public static class Queue<T> {
        private List<T> queue;
        
        public Queue() {
            this.queue = new ArrayList<>();
        }
        
        /**
         * Add element to rear of queue
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @param item Element to add
         */
        public void enqueue(T item) {
            queue.add(item);
        }
        
        /**
         * Remove element from front of queue
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Front element
         * @throws NoSuchElementException if queue is empty
         */
        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return queue.remove(0);
        }
        
        /**
         * Get front element without removing
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Front element
         * @throws NoSuchElementException if queue is empty
         */
        public T front() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return queue.get(0);
        }
        
        /**
         * Get rear element without removing
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Rear element
         * @throws NoSuchElementException if queue is empty
         */
        public T rear() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return queue.get(queue.size() - 1);
        }
        
        /**
         * Check if queue is empty
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return queue.isEmpty();
        }
        
        /**
         * Get size of queue
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Number of elements in queue
         */
        public int size() {
            return queue.size();
        }
        
        /**
         * Convert queue to array
         * 
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         * 
         * @return Array representation of queue
         */
        public Object[] toArray() {
            return queue.toArray();
        }
    }
    
    /**
     * Circular Queue implementation
     */
    public static class CircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;
        
        public CircularQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
        
        /**
         * Add element to rear of circular queue
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @param value Value to add
         * @return True if successful, false if queue is full
         */
        public boolean enqueue(int value) {
            if (isFull()) return false;
            
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }
        
        /**
         * Remove element from front of circular queue
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return True if successful, false if queue is empty
         */
        public boolean dequeue() {
            if (isEmpty()) return false;
            
            front = (front + 1) % capacity;
            size--;
            return true;
        }
        
        /**
         * Get front element
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Front element, or -1 if empty
         */
        public int front() {
            return isEmpty() ? -1 : queue[front];
        }
        
        /**
         * Get rear element
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Rear element, or -1 if empty
         */
        public int rear() {
            return isEmpty() ? -1 : queue[rear];
        }
        
        /**
         * Check if queue is empty
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return size == 0;
        }
        
        /**
         * Check if queue is full
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return True if full, false otherwise
         */
        public boolean isFull() {
            return size == capacity;
        }
        
        /**
         * Get current size
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Current size
         */
        public int size() {
            return size;
        }
    }
    
    /**
     * Deque (Double-ended Queue) implementation
     */
    public static class Deque<T> {
        private List<T> deque;
        
        public Deque() {
            this.deque = new ArrayList<>();
        }
        
        /**
         * Add element to front
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @param item Element to add
         */
        public void addFirst(T item) {
            deque.add(0, item);
        }
        
        /**
         * Add element to rear
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @param item Element to add
         */
        public void addLast(T item) {
            deque.add(item);
        }
        
        /**
         * Remove element from front
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Front element
         * @throws NoSuchElementException if deque is empty
         */
        public T removeFirst() {
            if (isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return deque.remove(0);
        }
        
        /**
         * Remove element from rear
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Rear element
         * @throws NoSuchElementException if deque is empty
         */
        public T removeLast() {
            if (isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return deque.remove(deque.size() - 1);
        }
        
        /**
         * Get front element
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Front element
         * @throws NoSuchElementException if deque is empty
         */
        public T getFirst() {
            if (isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return deque.get(0);
        }
        
        /**
         * Get rear element
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Rear element
         * @throws NoSuchElementException if deque is empty
         */
        public T getLast() {
            if (isEmpty()) {
                throw new NoSuchElementException("Deque is empty");
            }
            return deque.get(deque.size() - 1);
        }
        
        /**
         * Check if deque is empty
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return deque.isEmpty();
        }
        
        /**
         * Get size of deque
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Number of elements in deque
         */
        public int size() {
            return deque.size();
        }
    }
    
    /**
     * Implement queue using two stacks
     */
    public static class QueueUsingStacks<T> {
        private Stack<T> stack1;
        private Stack<T> stack2;
        
        public QueueUsingStacks() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }
        
        /**
         * Add element to queue
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @param item Element to add
         */
        public void enqueue(T item) {
            stack1.push(item);
        }
        
        /**
         * Remove element from queue
         * 
         * Time Complexity: O(n) amortized
         * Space Complexity: O(1)
         * 
         * @return Front element
         */
        public T dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
        
        /**
         * Get front element
         * 
         * Time Complexity: O(n) amortized
         * Space Complexity: O(1)
         * 
         * @return Front element
         */
        public T front() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
        
        /**
         * Check if queue is empty
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
    
    /**
     * Sliding window maximum using deque
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     * 
     * @param nums Input array
     * @param k Window size
     * @return Array of maximum values in each window
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements outside current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements smaller than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add maximum to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
    
    /**
     * First unique character in stream
     * 
     * Time Complexity: O(1) for each operation
     * Space Complexity: O(n)
     * 
     * @param s Input string
     * @return First unique character
     */
    public static char firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            queue.offer(c);
            
            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
                queue.poll();
            }
        }
        
        return queue.isEmpty() ? '#' : queue.peek();
    }
    
    /**
     * Moving average from data stream
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     * 
     * @param size Window size
     */
    public static class MovingAverage {
        private Queue<Integer> queue;
        private int size;
        private double sum;
        
        public MovingAverage(int size) {
            this.queue = new LinkedList<>();
            this.size = size;
            this.sum = 0;
        }
        
        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        }
    }
    
    /**
     * Design hit counter
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     */
    public static class HitCounter {
        private Queue<Integer> hits;
        
        public HitCounter() {
            this.hits = new LinkedList<>();
        }
        
        public void hit(int timestamp) {
            hits.offer(timestamp);
        }
        
        public int getHits(int timestamp) {
            while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
                hits.poll();
            }
            return hits.size();
        }
    }
    
    /**
     * Task scheduler
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param tasks Array of tasks
     * @param n Cooldown period
     * @return Minimum time to complete all tasks
     */
    public static int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        
        Arrays.sort(taskCount);
        int maxCount = taskCount[25];
        int idleSlots = (maxCount - 1) * n;
        
        for (int i = 24; i >= 0 && taskCount[i] > 0; i--) {
            idleSlots -= Math.min(taskCount[i], maxCount - 1);
        }
        
        return tasks.length + Math.max(0, idleSlots);
    }
    
    /**
     * Reveal cards in increasing order
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * @param deck Input deck
     * @return Revealed deck
     */
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }
        
        int[] result = new int[deck.length];
        int index = 0;
        
        while (!queue.isEmpty()) {
            result[queue.poll()] = deck[index++];
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return result;
    }
    
    /**
     * Main method for testing queue operations
     */
    public static void main(String[] args) {
        System.out.println("=== Queue Operations Examples ===");
        
        // Test basic queue operations
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue: " + Arrays.toString(queue.toArray()));
        System.out.println("Front: " + queue.front());
        System.out.println("Rear: " + queue.rear());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
        
        // Test circular queue
        CircularQueue circularQueue = new CircularQueue(3);
        System.out.println("Circular queue enqueue 1: " + circularQueue.enqueue(1));
        System.out.println("Circular queue enqueue 2: " + circularQueue.enqueue(2));
        System.out.println("Circular queue enqueue 3: " + circularQueue.enqueue(3));
        System.out.println("Circular queue enqueue 4: " + circularQueue.enqueue(4));
        System.out.println("Front: " + circularQueue.front());
        System.out.println("Rear: " + circularQueue.rear());
        System.out.println("Dequeue: " + circularQueue.dequeue());
        System.out.println("Enqueue 4: " + circularQueue.enqueue(4));
        
        // Test deque
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("Deque size: " + deque.size());
        System.out.println("First: " + deque.getFirst());
        System.out.println("Last: " + deque.getLast());
        
        // Test queue using stacks
        QueueUsingStacks<Integer> queueUsingStacks = new QueueUsingStacks<>();
        queueUsingStacks.enqueue(1);
        queueUsingStacks.enqueue(2);
        queueUsingStacks.enqueue(3);
        System.out.println("Queue using stacks front: " + queueUsingStacks.front());
        System.out.println("Queue using stacks dequeue: " + queueUsingStacks.dequeue());
        
        // Test sliding window maximum
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] maxWindow = maxSlidingWindow(nums, 3);
        System.out.println("Sliding window maximum: " + Arrays.toString(maxWindow));
        
        // Test first unique character
        System.out.println("First unique character in 'leetcode': " + firstUniqChar("leetcode"));
        
        // Test moving average
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("Moving average (1): " + movingAverage.next(1));
        System.out.println("Moving average (10): " + movingAverage.next(10));
        System.out.println("Moving average (3): " + movingAverage.next(3));
        System.out.println("Moving average (5): " + movingAverage.next(5));
        
        // Test hit counter
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        System.out.println("Hits in last 300 seconds: " + hitCounter.getHits(4));
        
        // Test task scheduler
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("Task scheduler result: " + leastInterval(tasks, 2));
        
        // Test deck reveal
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] revealed = deckRevealedIncreasing(deck);
        System.out.println("Revealed deck: " + Arrays.toString(revealed));
    }
}
