# Heaps 🏗️

> **Master heap data structures and heap-based algorithms**

## 🎯 Learning Objectives

- Understand heap fundamentals
- Master heap operations
- Learn heap-based algorithms
- Apply heap patterns to solve problems

## 📚 Theory

### Heap Basics

#### Properties
- **Complete Binary Tree**: All levels filled except possibly last
- **Heap Property**: Parent-child relationship maintained
- **Min Heap**: Parent ≤ children
- **Max Heap**: Parent ≥ children
- **Array Representation**: Efficient storage

#### Common Operations
- **Insert**: O(log n) time - add element
- **Extract**: O(log n) time - remove root
- **Peek**: O(1) time - view root
- **Heapify**: O(n) time - build heap
- **Size**: O(1) time - get number of elements

### Heap Applications

#### Priority Queue
- **Task Scheduling**: Highest priority first
- **Dijkstra's Algorithm**: Shortest path
- **A* Search**: Pathfinding with heuristics

#### Sorting
- **Heap Sort**: O(n log n) time, O(1) space
- **In-place sorting**: No extra space needed

#### Selection
- **Top K Elements**: O(n log k) time
- **Median Finding**: Two heaps approach

## 🔧 Implementation

### Basic Heap Operations

```java
// Min Heap implementation
class MinHeap {
    private List<Integer> heap;
    
    public MinHeap() {
        this.heap = new ArrayList<>();
    }
    
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }
    
    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException();
        
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return min;
    }
    
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) >= heap.get(parent)) break;
            
            swap(index, parent);
            index = parent;
        }
    }
    
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
            
            if (smallest == index) break;
            
            swap(index, smallest);
            index = smallest;
        }
    }
}
```

## 📝 Practice Problems

### Easy
1. **Kth Largest Element** - O(n log k) time, O(k) space
2. **Last Stone Weight** - O(n log n) time, O(n) space
3. **Relative Ranks** - O(n log n) time, O(n) space
4. **K Closest Points to Origin** - O(n log k) time, O(k) space
5. **Find K Pairs with Smallest Sums** - O(k log k) time, O(k) space

### Medium
1. **Merge k Sorted Lists** - O(n log k) time, O(k) space
2. **Find Median from Data Stream** - O(log n) time, O(n) space
3. **Top K Frequent Elements** - O(n log k) time, O(n) space
4. **Reorganize String** - O(n log k) time, O(k) space
5. **Task Scheduler** - O(n) time, O(1) space

### Hard
1. **Sliding Window Median** - O(n log k) time, O(k) space
2. **Find Median from Data Stream** - O(log n) time, O(n) space
3. **IPO** - O(n log n) time, O(n) space
4. **Maximum Performance of a Team** - O(n log n) time, O(n) space
5. **Minimum Cost to Hire K Workers** - O(n log n) time, O(n) space

## 💡 Key Insights

- **Heap property**: Maintains order efficiently
- **Priority queue**: Natural heap application
- **Two heaps**: For median finding
- **Heap sort**: In-place sorting algorithm
- **Top K problems**: Use heap for efficiency

## ⚠️ Common Mistakes

### Wrong Heap Type
- **Problem**: Using min heap when max heap is needed
- **Solution**: Understand min heap (smallest at top) vs max heap (largest at top)
- **Example**: Use min heap for top K largest, max heap for top K smallest

### Incorrect Comparator
- **Problem**: Wrong comparator for priority queue
- **Solution**: Use `(a, b) -> a - b` for min heap, `(a, b) -> b - a` for max heap
- **Example**: `PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);`

### Not Maintaining Heap Property
- **Problem**: Not maintaining heap property after operations
- **Solution**: Always heapify after insert/delete operations
- **Example**: Call `heapifyUp()` after insert, `heapifyDown()` after delete

### Empty Heap Access
- **Problem**: Accessing top element from empty heap
- **Solution**: Always check `!heap.isEmpty()` before `heap.peek()` or `heap.poll()`
- **Example**: `if (!heap.isEmpty()) { int top = heap.peek(); }`

### Incorrect Heap Size
- **Problem**: Not limiting heap size for space optimization
- **Solution**: Maintain only K elements in heap for top K problems
- **Example**: Remove smallest when heap size > K for top K largest

### Wrong Heapify Direction
- **Problem**: Heapifying in wrong direction
- **Solution**: Heapify up after insert, heapify down after delete
- **Example**: After insert, compare with parent and swap up if needed

### Not Using Two Heaps
- **Problem**: Not using two heaps for median problems
- **Solution**: Use min heap for larger half, max heap for smaller half
- **Example**: Maintain size balance: maxHeap.size() - minHeap.size() <= 1

## 🎯 Interview Tips

- Choose min vs max heap based on problem
- Use two heaps for median problems
- Consider heap size for space optimization
- Think about heapify operations
- Apply heap for priority-based problems

## 📚 Additional Resources

- [Heap Data Structure](https://www.geeksforgeeks.org/heap-data-structure/)
- [Priority Queue](https://www.geeksforgeeks.org/priority-queue-in-java/)
- [Heap Sort](https://www.geeksforgeeks.org/heap-sort/)
- [Top K Elements](https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/)
