# Fast & Slow Pointers Pattern 🏃‍♂️

> **Master the fast and slow pointers technique for cycle detection and middle finding**

## 🎯 Learning Objectives

- Understand fast and slow pointers fundamentals
- Master cycle detection algorithms
- Learn middle finding techniques
- Apply fast and slow pointers to solve problems

## 📚 Theory

### Fast & Slow Pointers Basics

#### Properties
- **Two pointers**: Move at different speeds
- **Fast pointer**: Moves 2 steps at a time
- **Slow pointer**: Moves 1 step at a time
- **Cycle detection**: Floyd's cycle detection algorithm
- **Middle finding**: Find middle of linked list

#### Common Patterns
- **Cycle detection**: Detect cycles in linked lists
- **Middle finding**: Find middle element
- **Palindrome checking**: Check if linked list is palindrome
- **Duplicate detection**: Find duplicate numbers
- **Intersection**: Find intersection of two linked lists

### When to Use Fast & Slow Pointers

#### Linked Lists
- **Cycle detection**: Detect if linked list has cycle
- **Middle finding**: Find middle node of linked list
- **Palindrome checking**: Check if linked list is palindrome
- **Intersection**: Find intersection point of two lists

#### Arrays
- **Duplicate detection**: Find duplicate number in array
- **Cycle detection**: Detect cycle in array
- **Middle finding**: Find middle element in array

## 🔧 Implementation

### Basic Fast & Slow Pointers Pattern

```java
// Cycle detection in linked list
public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) return true;
    }
    return false;
}

// Find middle of linked list
public static ListNode findMiddle(ListNode head) {
    if (head == null) return null;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

### Advanced Fast & Slow Pointers Patterns

```java
// Find cycle start node
public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;
    
    ListNode slow = head;
    ListNode fast = head;
    
    // Find meeting point
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) break;
    }
    
    if (fast == null || fast.next == null) return null;
    
    // Find cycle start
    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}

// Check if linked list is palindrome
public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    
    // Find middle
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    // Reverse second half
    ListNode secondHalf = reverseList(slow.next);
    slow.next = null;
    
    // Compare both halves
    ListNode first = head;
    ListNode second = secondHalf;
    boolean isPalindrome = true;
    
    while (second != null) {
        if (first.val != second.val) {
            isPalindrome = false;
            break;
        }
        first = first.next;
        second = second.next;
    }
    
    // Restore second half
    slow.next = reverseList(secondHalf);
    return isPalindrome;
}
```

## 📝 Practice Problems

### Easy
1. **Linked List Cycle** - O(n) time, O(1) space
2. **Middle of Linked List** - O(n) time, O(1) space
3. **Palindrome Linked List** - O(n) time, O(1) space
4. **Remove Nth Node From End** - O(n) time, O(1) space
5. **Find the Duplicate Number** - O(n) time, O(1) space

### Medium
1. **Linked List Cycle II** - O(n) time, O(1) space
2. **Reorder List** - O(n) time, O(1) space
3. **Sort List** - O(n log n) time, O(log n) space
4. **Partition List** - O(n) time, O(1) space
5. **Remove Duplicates from Sorted List II** - O(n) time, O(1) space

### Hard
1. **Copy List with Random Pointer** - O(n) time, O(1) space
2. **Reverse Nodes in k-Group** - O(n) time, O(1) space
3. **Merge k Sorted Lists** - O(n log k) time, O(1) space
4. **LRU Cache** - O(1) time, O(n) space
5. **LFU Cache** - O(1) time, O(n) space

## 💡 Key Insights

- **Cycle detection**: Use Floyd's algorithm
- **Middle finding**: Fast pointer moves 2x speed
- **Palindrome checking**: Reverse second half
- **Duplicate detection**: Treat array as linked list
- **Intersection**: Find common node

## ⚠️ Common Mistakes

### Null Pointer Exceptions
- **Problem**: Not checking for null before accessing
- **Solution**: Always check `node != null` before `node.next`
- **Example**: `if (fast != null && fast.next != null)` before accessing fast.next.next

### Wrong Pointer Speed
- **Problem**: Wrong speed ratio for fast and slow pointers
- **Solution**: Fast pointer moves 2x speed: `fast = fast.next.next; slow = slow.next;`
- **Example**: For cycle detection, fast moves 2 steps, slow moves 1 step

### Infinite Loops
- **Problem**: Not handling cycle causing infinite loop
- **Solution**: Check for cycle: `fast == slow` indicates cycle
- **Example**: `while (fast != null && fast.next != null && fast != slow)`

### Not Handling Empty List
- **Problem**: Not checking for empty list
- **Solution**: Always check `head == null || head.next == null` first
- **Example**: `if (head == null || head.next == null) return false;`

### Wrong Middle Calculation
- **Problem**: Incorrect middle node calculation
- **Solution**: When fast reaches end, slow is at middle
- **Example**: `while (fast != null && fast.next != null) { fast = fast.next.next; slow = slow.next; }`

### Not Resetting Pointers
- **Problem**: Not resetting pointers after cycle detection
- **Solution**: Reset pointers after finding cycle start
- **Example**: After finding cycle, reset slow to head and move both one step

### Wrong Cycle Start Detection
- **Problem**: Incorrectly finding cycle start node
- **Solution**: After detecting cycle, reset slow to head and move both one step
- **Example**: `slow = head; while (slow != fast) { slow = slow.next; fast = fast.next; }`

## 🎯 Interview Tips

- Always check for null pointers
- Use fast and slow pointers for cycle detection
- Consider space optimization
- Think about edge cases
- Use two pointers for middle finding

## 📚 Additional Resources

- [Floyd's Cycle Detection](https://www.geeksforgeeks.org/detect-loop-in-linked-list/)
- [Fast and Slow Pointers](https://www.geeksforgeeks.org/find-middle-of-linked-list/)
- [Cycle Detection Algorithm](https://en.wikipedia.org/wiki/Cycle_detection)
- [Two Pointer Technique](https://www.geeksforgeeks.org/two-pointers-technique/)
