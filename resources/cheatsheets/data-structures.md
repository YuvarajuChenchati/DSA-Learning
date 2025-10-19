# Data Structures Cheat Sheet 📚

> **Quick reference for data structures, operations, and complexity**

## 🎯 Overview

Data structures are ways of organizing and storing data for efficient access and modification.

## 📊 Basic Data Structures

### Arrays
- **Description**: Fixed-size collection of elements
- **Access**: O(1) - Direct access by index
- **Search**: O(n) - Linear search
- **Insertion**: O(n) - Shift elements
- **Deletion**: O(n) - Shift elements
- **Space**: O(n)

```java
// Array operations
int[] arr = new int[5];
arr[0] = 1;           // O(1)
int value = arr[0];    // O(1)
```

### Linked Lists
- **Description**: Dynamic collection of nodes
- **Access**: O(n) - Sequential access
- **Search**: O(n) - Linear search
- **Insertion**: O(1) - At head/tail
- **Deletion**: O(1) - At head/tail
- **Space**: O(n)

```java
// Linked list operations
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

### Stacks
- **Description**: LIFO (Last In, First Out) structure
- **Operations**: push, pop, peek, isEmpty
- **Time Complexity**: O(1) for all operations
- **Space**: O(n)

```java
// Stack operations
Stack<Integer> stack = new Stack<>();
stack.push(1);        // O(1)
int top = stack.pop(); // O(1)
boolean empty = stack.isEmpty(); // O(1)
```

### Queues
- **Description**: FIFO (First In, First Out) structure
- **Operations**: enqueue, dequeue, front, isEmpty
- **Time Complexity**: O(1) for all operations
- **Space**: O(n)

```java
// Queue operations
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);       // O(1)
int front = queue.poll(); // O(1)
boolean empty = queue.isEmpty(); // O(1)
```

## 🌳 Tree Data Structures

### Binary Trees
- **Description**: Tree with at most 2 children per node
- **Height**: O(log n) for balanced, O(n) for unbalanced
- **Operations**: Insert, Delete, Search
- **Space**: O(n)

```java
// Binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

### Binary Search Trees (BST)
- **Description**: Binary tree with ordering property
- **Search**: O(log n) average, O(n) worst
- **Insert**: O(log n) average, O(n) worst
- **Delete**: O(log n) average, O(n) worst
- **Space**: O(n)

```java
// BST operations
public TreeNode search(TreeNode root, int val) {
    if (root == null || root.val == val) return root;
    if (val < root.val) return search(root.left, val);
    return search(root.right, val);
}
```

### Heaps
- **Description**: Complete binary tree with heap property
- **Min Heap**: Parent ≤ children
- **Max Heap**: Parent ≥ children
- **Operations**: Insert, Extract, Heapify
- **Time Complexity**: O(log n) for insert/extract
- **Space**: O(n)

```java
// Heap operations
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(1);      // O(log n)
int min = minHeap.poll(); // O(log n)
```

## 🔗 Graph Data Structures

### Adjacency List
- **Description**: Array of lists for each vertex
- **Space**: O(V + E)
- **Traversal**: O(V + E)
- **Use cases**: Sparse graphs

```java
// Adjacency list representation
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < vertices; i++) {
    graph.add(new ArrayList<>());
}
```

### Adjacency Matrix
- **Description**: 2D array for edge weights
- **Space**: O(V²)
- **Traversal**: O(V²)
- **Use cases**: Dense graphs

```java
// Adjacency matrix representation
int[][] graph = new int[vertices][vertices];
```

## 🗂️ Hash-Based Data Structures

### Hash Tables
- **Description**: Key-value pairs with hash function
- **Operations**: Insert, Delete, Search
- **Time Complexity**: O(1) average, O(n) worst
- **Space**: O(n)

```java
// Hash table operations
Map<String, Integer> map = new HashMap<>();
map.put("key", 1);     // O(1)
int value = map.get("key"); // O(1)
map.remove("key");     // O(1)
```

### Hash Sets
- **Description**: Collection of unique elements
- **Operations**: Add, Remove, Contains
- **Time Complexity**: O(1) average, O(n) worst
- **Space**: O(n)

```java
// Hash set operations
Set<Integer> set = new HashSet<>();
set.add(1);            // O(1)
boolean contains = set.contains(1); // O(1)
set.remove(1);        // O(1)
```

## 🔍 Advanced Data Structures

### Tries (Prefix Trees)
- **Description**: Tree for string operations
- **Operations**: Insert, Search, Delete
- **Time Complexity**: O(m) where m is string length
- **Space**: O(ALPHABET_SIZE * N * M)

```java
// Trie node
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}
```

### Segment Trees
- **Description**: Tree for range queries
- **Operations**: Query, Update
- **Time Complexity**: O(log n) for both
- **Space**: O(n)

```java
// Segment tree operations
class SegmentTree {
    int[] tree;
    int n;
    
    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }
}
```

### Fenwick Trees (Binary Indexed Trees)
- **Description**: Tree for prefix sums
- **Operations**: Update, Query
- **Time Complexity**: O(log n) for both
- **Space**: O(n)

```java
// Fenwick tree operations
class FenwickTree {
    int[] tree;
    int n;
    
    public void update(int index, int delta) {
        for (; index < n; index |= index + 1) {
            tree[index] += delta;
        }
    }
}
```

## 📊 Complexity Comparison

### Time Complexity
| Operation | Array | Linked List | Stack | Queue | BST | Heap | Hash Table |
|-----------|-------|-------------|-------|-------|-----|------|------------|
| Access | O(1) | O(n) | O(n) | O(n) | O(log n) | O(n) | O(1) |
| Search | O(n) | O(n) | O(n) | O(n) | O(log n) | O(n) | O(1) |
| Insert | O(n) | O(1) | O(1) | O(1) | O(log n) | O(log n) | O(1) |
| Delete | O(n) | O(1) | O(1) | O(1) | O(log n) | O(log n) | O(1) |

### Space Complexity
| Structure | Space | Notes |
|-----------|-------|-------|
| Array | O(n) | Fixed size |
| Linked List | O(n) | Dynamic size |
| Stack | O(n) | Maximum depth |
| Queue | O(n) | Maximum size |
| BST | O(n) | n nodes |
| Heap | O(n) | n nodes |
| Hash Table | O(n) | n key-value pairs |

## 🎯 When to Use Which Data Structure

### Arrays
- **Use when**: Fixed size, random access needed
- **Avoid when**: Dynamic size, frequent insertions/deletions

### Linked Lists
- **Use when**: Dynamic size, frequent insertions/deletions
- **Avoid when**: Random access needed

### Stacks
- **Use when**: LIFO operations, recursion simulation
- **Avoid when**: Random access needed

### Queues
- **Use when**: FIFO operations, BFS traversal
- **Avoid when**: Random access needed

### BSTs
- **Use when**: Sorted data, range queries
- **Avoid when**: Unbalanced trees

### Heaps
- **Use when**: Priority queues, kth largest/smallest
- **Avoid when**: Random access needed

### Hash Tables
- **Use when**: Fast lookups, key-value pairs
- **Avoid when**: Ordered data needed

## 💡 Implementation Tips

### Java Collections
- **ArrayList**: Dynamic array, O(1) access
- **LinkedList**: Doubly linked list, O(1) insert/delete
- **Stack**: LIFO structure
- **Queue**: FIFO structure
- **PriorityQueue**: Heap implementation
- **HashMap**: Hash table implementation
- **TreeMap**: Red-black tree implementation

### Best Practices
- **Choose appropriate structure**: Based on operations needed
- **Consider time vs space**: Balance complexity
- **Use generics**: Type safety
- **Handle edge cases**: Empty collections, null values
- **Optimize for common operations**: Most frequent operations

## 📚 Additional Resources

- [Data Structures](https://www.geeksforgeeks.org/data-structures/)
- [Java Collections](https://docs.oracle.com/javase/tutorial/collections/)
- [Algorithm Complexity](https://www.geeksforgeeks.org/analysis-of-algorithms/)
- [Data Structure Visualization](https://visualgo.net/)

---

**Remember**: Choose the right data structure for your use case. The best structure depends on the operations you need to perform! 🚀
