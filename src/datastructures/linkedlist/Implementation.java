package datastructures.linkedlist;

import java.util.*;

/**
 * Linked List Implementation
 * 
 * This class contains essential linked list operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class LinkedListOperations {
    
    /**
     * ListNode class for singly linked list
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
     * Create a linked list from array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param values Array of values
     * @return Head of linked list
     */
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
    
    /**
     * Print linked list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     */
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    /**
     * Get length of linked list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return Length of linked list
     */
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    /**
     * Insert node at head
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param head Current head
     * @param val Value to insert
     * @return New head
     */
    public static ListNode insertAtHead(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }
    
    /**
     * Insert node at tail
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Current head
     * @param val Value to insert
     * @return Head of linked list
     */
    public static ListNode insertAtTail(ListNode head, int val) {
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
    
    /**
     * Insert node at specific position
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Current head
     * @param val Value to insert
     * @param position Position to insert at
     * @return Head of linked list
     */
    public static ListNode insertAtPosition(ListNode head, int val, int position) {
        ListNode newNode = new ListNode(val);
        
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        
        ListNode current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
        
        return head;
    }
    
    /**
     * Delete node at head
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param head Current head
     * @return New head
     */
    public static ListNode deleteAtHead(ListNode head) {
        if (head == null) return null;
        return head.next;
    }
    
    /**
     * Delete node at tail
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Current head
     * @return Head of linked list
     */
    public static ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }
    
    /**
     * Delete node with specific value
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Current head
     * @param val Value to delete
     * @return Head of linked list
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        
        if (head.val == val) {
            return head.next;
        }
        
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }
    
    /**
     * Search for a value in linked list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @param val Value to search for
     * @return True if found, false otherwise
     */
    public static boolean search(ListNode head, int val) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Reverse linked list iteratively
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return Reversed linked list head
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    /**
     * Reverse linked list recursively
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - recursion stack
     * 
     * @param head Head of linked list
     * @return Reversed linked list head
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    /**
     * Find middle node of linked list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return Middle node
     */
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
    
    /**
     * Check if linked list has cycle
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return True if cycle exists, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Find cycle start node
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return Cycle start node, or null if no cycle
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
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
    
    /**
     * Merge two sorted linked lists
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     * 
     * @param list1 First sorted list
     * @param list2 Second sorted list
     * @return Merged sorted list
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
    
    /**
     * Remove nth node from end
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @param n Position from end
     * @return Head of modified list
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
    
    /**
     * Swap nodes in pairs
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return Head of modified list
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = first;
        }
        return dummy.next;
    }
    
    /**
     * Rotate list to the right by k positions
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @param k Number of positions to rotate
     * @return Head of rotated list
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        // Find length and make list circular
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        
        // Find new head
        k = k % length;
        for (int i = 0; i < length - k; i++) {
            current = current.next;
        }
        
        head = current.next;
        current.next = null;
        return head;
    }
    
    /**
     * Partition list around a value
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @param x Partition value
     * @return Head of partitioned list
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
    
    /**
     * Check if linked list is palindrome
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return True if palindrome, false otherwise
     */
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
    
    /**
     * Main method for testing linked list operations
     */
    public static void main(String[] args) {
        System.out.println("=== Linked List Operations Examples ===");
        
        // Create linked list
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(values);
        System.out.print("Original list: ");
        printLinkedList(head);
        
        // Test basic operations
        System.out.println("Length: " + getLength(head));
        System.out.println("Search for 3: " + search(head, 3));
        System.out.println("Search for 6: " + search(head, 6));
        
        // Test insertion
        head = insertAtHead(head, 0);
        System.out.print("After inserting 0 at head: ");
        printLinkedList(head);
        
        head = insertAtTail(head, 6);
        System.out.print("After inserting 6 at tail: ");
        printLinkedList(head);
        
        // Test deletion
        head = deleteAtHead(head);
        System.out.print("After deleting head: ");
        printLinkedList(head);
        
        head = deleteNode(head, 3);
        System.out.print("After deleting 3: ");
        printLinkedList(head);
        
        // Test reverse
        head = reverseList(head);
        System.out.print("After reversing: ");
        printLinkedList(head);
        
        // Test middle
        ListNode middle = findMiddle(head);
        System.out.println("Middle node: " + (middle != null ? middle.val : "null"));
        
        // Test cycle detection
        System.out.println("Has cycle: " + hasCycle(head));
        
        // Test merge
        int[] values1 = {1, 3, 5};
        int[] values2 = {2, 4, 6};
        ListNode list1 = createLinkedList(values1);
        ListNode list2 = createLinkedList(values2);
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.print("Merged lists: ");
        printLinkedList(merged);
        
        // Test remove nth from end
        merged = removeNthFromEnd(merged, 2);
        System.out.print("After removing 2nd from end: ");
        printLinkedList(merged);
        
        // Test swap pairs
        merged = swapPairs(merged);
        System.out.print("After swapping pairs: ");
        printLinkedList(merged);
        
        // Test palindrome
        int[] palindromeValues = {1, 2, 3, 2, 1};
        ListNode palindromeList = createLinkedList(palindromeValues);
        System.out.println("Is palindrome: " + isPalindrome(palindromeList));
    }
}
