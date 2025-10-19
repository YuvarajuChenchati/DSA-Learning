# Linked Lists 🔗

> **Master linked list operations and common patterns**

## 🎯 Learning Objectives

- Understand linked list fundamentals
- Master linked list operations
- Learn linked list-based algorithms
- Apply linked list patterns to solve problems

## 📚 Theory

### Linked List Basics

#### Properties
- **Dynamic size**: Can grow and shrink during runtime
- **Non-contiguous**: Elements stored in different memory locations
- **Sequential access**: Must traverse from head to access elements
- **Memory efficient**: Only allocates memory as needed

#### Common Operations
- **Access**: O(n) time for random access
- **Search**: O(n) time for linear search
- **Insertion**: O(1) time at head, O(n) time at specific position
- **Deletion**: O(1) time at head, O(n) time at specific position

### Linked List Types

#### Singly Linked List
- Each node has data and next pointer
- Can only traverse in one direction
- Memory efficient

#### Doubly Linked List
- Each node has data, next, and prev pointers
- Can traverse in both directions
- More memory overhead

#### Circular Linked List
- Last node points to first node
- Useful for round-robin algorithms

## 🔧 Implementation

### Basic Linked List Operations

```java
// Node class for singly linked list
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

// Insert at head
public ListNode insertAtHead(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    newNode.next = head;
    return newNode;
}

// Insert at tail
public ListNode insertAtTail(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    if (head == null) {
        return newNode;
    }
    
    ListNode current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = newNode;
    return head;
}
```

### Common Patterns

#### Two Pointers
- **Fast and slow pointers**: For cycle detection and middle finding
- **Two pointers**: For palindrome checking and merging

#### Recursion
- **Reverse linked list**: Using recursion
- **Merge linked lists**: Recursive approach

## 📝 Practice Problems

### Easy
1. **Reverse Linked List** - O(n) time, O(1) space
2. **Merge Two Sorted Lists** - O(n + m) time, O(1) space
3. **Remove Duplicates** - O(n) time, O(1) space
4. **Middle of Linked List** - O(n) time, O(1) space
5. **Delete Node** - O(1) time, O(1) space

### Medium
1. **Add Two Numbers** - O(n) time, O(1) space
2. **Remove Nth Node From End** - O(n) time, O(1) space
3. **Swap Nodes in Pairs** - O(n) time, O(1) space
4. **Rotate List** - O(n) time, O(1) space
5. **Partition List** - O(n) time, O(1) space

### Hard
1. **Reverse Nodes in k-Group** - O(n) time, O(1) space
2. **Copy List with Random Pointer** - O(n) time, O(1) space
3. **Reorder List** - O(n) time, O(1) space
4. **Sort List** - O(n log n) time, O(log n) space
5. **Merge k Sorted Lists** - O(n log k) time, O(1) space

## 💡 Key Insights

- **Dummy head**: Useful for edge cases
- **Two pointers**: Efficient for many problems
- **Recursion**: Natural for linked list problems
- **In-place operations**: Save space complexity
- **Cycle detection**: Use Floyd's algorithm

## 🎯 Interview Tips

- Always consider edge cases (empty list, single node)
- Use dummy head for insertion/deletion problems
- Apply two pointers for cycle detection
- Consider recursion for natural solutions
- Think about space-time tradeoffs

## 📚 Additional Resources

- [Linked List Data Structure](https://www.geeksforgeeks.org/linked-list-data-structure/)
- [Floyd's Cycle Detection](https://www.geeksforgeeks.org/detect-loop-in-linked-list/)
- [Linked List Algorithms](https://www.geeksforgeeks.org/linked-list-algorithms/)
- [Two Pointer Technique](https://www.geeksforgeeks.org/two-pointers-technique/)
