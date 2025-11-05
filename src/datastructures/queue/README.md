# Queues 🚶

> **Master queue operations and common queue-based algorithms**

## 🎯 Learning Objectives

- Understand queue fundamentals
- Master queue operations
- Learn queue-based algorithms
- Apply queue patterns to solve problems

## 📚 Theory

### Queue Basics

#### Properties
- **FIFO**: First In, First Out principle
- **Dynamic size**: Can grow and shrink during runtime
- **Sequential access**: Only access front and rear elements
- **Memory efficient**: Only stores necessary elements

#### Common Operations
- **Enqueue**: O(1) time - add element to rear
- **Dequeue**: O(1) time - remove element from front
- **Front**: O(1) time - view front element
- **Rear**: O(1) time - view rear element
- **IsEmpty**: O(1) time - check if queue is empty
- **Size**: O(1) time - get number of elements

### Queue Types

#### Simple Queue
- Basic FIFO queue
- Front and rear pointers
- Linear structure

#### Circular Queue
- Efficient memory usage
- Front and rear wrap around
- Fixed size

#### Priority Queue
- Elements have priority
- Highest priority served first
- Implemented using heap

#### Deque (Double-ended Queue)
- Can add/remove from both ends
- More flexible than simple queue
- Useful for sliding window problems

## 🔧 Implementation

### Basic Queue Operations

```java
// Queue using ArrayList
public class Queue<T> {
    private List<T> queue;
    
    public Queue() {
        this.queue = new ArrayList<>();
    }
    
    public void enqueue(T item) {
        queue.add(item);
    }
    
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.remove(0);
    }
    
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
}
```

### Circular Queue

```java
// Circular Queue implementation
public class CircularQueue {
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
    
    public boolean enqueue(int value) {
        if (isFull()) return false;
        
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }
    
    public boolean dequeue() {
        if (isEmpty()) return false;
        
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public int front() {
        return isEmpty() ? -1 : queue[front];
    }
    
    public int rear() {
        return isEmpty() ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}
```

## 📝 Practice Problems

### Easy
1. **Implement Queue using Stacks** - O(1) amortized time
2. **Implement Stack using Queues** - O(n) time for pop
3. **First Unique Character** - O(n) time, O(1) space
4. **Moving Average** - O(1) time, O(n) space
5. **Design Circular Queue** - O(1) time for all operations

### Medium
1. **Sliding Window Maximum** - O(n) time, O(k) space
2. **Task Scheduler** - O(n) time, O(1) space
3. **Reveal Cards In Increasing Order** - O(n log n) time, O(n) space
4. **Design Hit Counter** - O(1) time, O(n) space
5. **Design Snake Game** - O(1) time, O(n) space

### Hard
1. **Sliding Window Median** - O(n log k) time, O(k) space
2. **Design Twitter** - O(n) time, O(n) space
3. **Design Underground System** - O(1) time, O(n) space
4. **Design Browser History** - O(1) time, O(n) space
5. **Design Front Middle Back Queue** - O(1) time, O(n) space

## 💡 Key Insights

- **FIFO principle**: First in, first out
- **BFS**: Use queue for breadth-first search
- **Sliding window**: Use deque for efficient operations
- **Priority queue**: Use heap for priority-based operations
- **Circular queue**: Efficient memory usage

## ⚠️ Common Mistakes

### Empty Queue Access
- **Problem**: Polling from empty queue without checking
- **Solution**: Always check `!queue.isEmpty()` before `queue.poll()`
- **Example**: `if (!queue.isEmpty()) { int front = queue.poll(); }`

### Wrong Queue Order
- **Problem**: Adding/removing in wrong order
- **Solution**: Remember FIFO (First In First Out)
- **Example**: First added element is first removed

### Not Clearing Queue
- **Problem**: Not clearing queue between test cases
- **Solution**: Clear queue before each new problem
- **Example**: `queue.clear();` or create new queue

### Using Wrong Data Structure
- **Problem**: Using queue when stack is needed
- **Solution**: Understand difference: queue is FIFO, stack is LIFO
- **Example**: Use queue for BFS, stack for DFS

### ArrayDeque vs LinkedList
- **Problem**: Not choosing right queue implementation
- **Solution**: Use ArrayDeque for better performance, LinkedList for flexibility
- **Example**: `Queue<Integer> q = new ArrayDeque<>();` for better performance

### Circular Queue Index Errors
- **Problem**: Incorrect index calculation in circular queue
- **Solution**: Use modulo for wrapping: `(front + 1) % capacity`
- **Example**: `rear = (rear + 1) % capacity;` for circular queue

### Priority Queue Comparator
- **Problem**: Wrong comparator for priority queue
- **Solution**: Use correct comparator: `(a, b) -> a - b` for min heap
- **Example**: `PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);`

## 🎯 Interview Tips

- Think about FIFO when solving problems
- Use queue for BFS traversal
- Apply deque for sliding window problems
- Consider priority queue for scheduling problems
- Use circular queue for fixed-size buffers

## 📚 Additional Resources

- [Queue Data Structure](https://www.geeksforgeeks.org/queue-data-structure/)
- [Circular Queue](https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/)
- [Priority Queue](https://www.geeksforgeeks.org/priority-queue-set-1-introduction/)
- [Deque](https://www.geeksforgeeks.org/deque-set-1-introduction-applications/)
