# Top K Elements Pattern 🔝

> **Master top K elements for finding largest, smallest, or most frequent elements**

## 🎯 Learning Objectives

- Understand top K elements fundamentals
- Master heap-based solutions
- Learn when to use top K patterns
- Apply top K patterns to solve problems

## 📚 Theory

### Top K Elements Basics

#### Properties
- **Heap-based**: Use min/max heap for efficiency
- **Kth element**: Find kth largest/smallest element
- **Frequency-based**: Find most/least frequent elements
- **Efficient**: O(n log k) time complexity
- **Space optimization**: O(k) space complexity

#### Common Patterns
- **Kth largest**: Find kth largest element
- **Kth smallest**: Find kth smallest element
- **Top K frequent**: Find k most frequent elements
- **Top K closest**: Find k closest elements
- **Kth largest in stream**: Dynamic kth largest

### When to Use Top K Elements

#### Selection Problems
- **Kth element**: Find kth largest/smallest
- **Top K elements**: Find k largest/smallest
- **Frequency analysis**: Find most/least frequent
- **Distance problems**: Find closest/farthest elements
- **Stream processing**: Dynamic top K elements

#### Common Applications
- **Kth largest**: Find kth largest number
- **Top K frequent**: Find k most frequent words
- **K closest points**: Find k closest points to origin
- **Kth largest in stream**: Dynamic kth largest
- **Top K elements**: Find k largest elements

## 🔧 Implementation

### Basic Top K Template

```java
// Find kth largest element
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    return minHeap.peek();
}
```

### Advanced Top K Patterns

```java
// Find top K frequent elements
public List<Integer> topKFrequent(int[] nums, int k) {
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
```

## 📝 Practice Problems

### Easy
1. **Kth Largest Element** - O(n log k) time, O(k) space
2. **Kth Smallest Element** - O(n log k) time, O(k) space
3. **Top K Frequent Elements** - O(n log k) time, O(k) space
4. **K Closest Points to Origin** - O(n log k) time, O(k) space
5. **Kth Largest in Stream** - O(log k) time, O(k) space

### Medium
1. **Top K Frequent Words** - O(n log k) time, O(k) space
2. **Kth Largest Element in Array** - O(n log k) time, O(k) space
3. **Find K Closest Elements** - O(log n + k) time, O(1) space
4. **Kth Smallest Element in Sorted Matrix** - O(n log(max-min)) time, O(1) space
5. **Kth Largest Element in Stream** - O(log k) time, O(k) space

### Hard
1. **Merge k Sorted Lists** - O(n log k) time, O(k) space
2. **Kth Largest Element in Array** - O(n) time, O(1) space
3. **Find K Pairs with Smallest Sums** - O(k log k) time, O(k) space
4. **Kth Smallest Element in Sorted Matrix** - O(n log(max-min)) time, O(1) space
5. **Kth Largest Element in Stream** - O(log k) time, O(k) space

## 💡 Key Insights

- **Min heap**: For kth largest element
- **Max heap**: For kth smallest element
- **Frequency counting**: Use hash map for frequency
- **Space optimization**: Use heap of size k
- **Stream processing**: Maintain heap dynamically

## ⚠️ Common Mistakes

### Wrong Heap Type
- **Problem**: Using min heap when max heap is needed
- **Solution**: Use min heap for top K largest, max heap for top K smallest
- **Example**: `PriorityQueue<Integer> minHeap = new PriorityQueue<>();` for top K largest

### Not Limiting Heap Size
- **Problem**: Not limiting heap size causing O(n) space
- **Solution**: Maintain only K elements in heap
- **Example**: `if (heap.size() > k) heap.poll();` to maintain size k

### Wrong Comparator
- **Problem**: Wrong comparator for priority queue
- **Solution**: Use `(a, b) -> a - b` for min heap, `(a, b) -> b - a` for max heap
- **Example**: `PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);`

### Not Handling k > n
- **Problem**: Not checking if k exceeds array size
- **Solution**: Always check `k <= nums.length` first
- **Example**: `if (k > nums.length) return all elements;`

### Empty Heap Access
- **Problem**: Accessing top element from empty heap
- **Solution**: Always check `!heap.isEmpty()` before `heap.peek()`
- **Example**: `if (!heap.isEmpty()) { int top = heap.peek(); }`

### Not Using Frequency Map
- **Problem**: Not using frequency map for frequency-based problems
- **Solution**: Use HashMap to count frequencies first
- **Example**: `Map<Integer, Integer> freq = new HashMap<>();` for frequency counting

### Wrong Frequency Comparison
- **Problem**: Wrong comparison in frequency-based heap
- **Solution**: Compare by frequency, then by value if frequencies equal
- **Example**: `(a, b) -> freq.get(a) - freq.get(b)` for frequency comparison

## 🎯 Interview Tips

- Always consider heap-based solutions
- Think about space optimization
- Consider frequency-based problems
- Use appropriate data structures
- Consider edge cases (k > n)

## 📚 Additional Resources

- [Top K Elements](https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/)
- [Heap Data Structure](https://www.geeksforgeeks.org/heap-data-structure/)
- [Priority Queue](https://www.geeksforgeeks.org/priority-queue-in-java/)
- [Kth Largest Element](https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/)
