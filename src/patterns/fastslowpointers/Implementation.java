package patterns.fastslowpointers;

import java.util.*;

/**
 * Fast & Slow Pointers Implementation
 * 
 * This class contains essential fast and slow pointer algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class FastSlowPointers {
    
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
     * Detect cycle in linked list using Floyd's algorithm
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
     * Find cycle start node using Floyd's algorithm
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
     * Reverse linked list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @return Reversed linked list
     */
    private static ListNode reverseList(ListNode head) {
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
     * Reorder linked list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
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
        
        // Merge two halves
        ListNode first = head;
        ListNode second = secondHalf;
        
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
    }
    
    /**
     * Find duplicate number in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Duplicate number
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Find meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Find duplicate
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    /**
     * Find intersection of two linked lists
     * 
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     * 
     * @param headA First linked list
     * @param headB Second linked list
     * @return Intersection node, or null if no intersection
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
    
    /**
     * Find start of cycle in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Start of cycle
     */
    public static int findCycleStart(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Find meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Find cycle start
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    /**
     * Check if array has cycle
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return True if cycle exists, false otherwise
     */
    public static boolean hasCycleInArray(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while (fast < nums.length && nums[fast] != 0) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Find middle element in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Middle element
     */
    public static int findMiddleElement(int[] nums) {
        if (nums.length == 0) return -1;
        
        int slow = 0;
        int fast = 0;
        
        while (fast < nums.length - 1) {
            slow++;
            fast += 2;
        }
        return nums[slow];
    }
    
    /**
     * Find kth node from end
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param head Head of linked list
     * @param k Position from end
     * @return Kth node from end
     */
    public static ListNode findKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    /**
     * Main method for testing fast and slow pointers
     */
    public static void main(String[] args) {
        System.out.println("=== Fast & Slow Pointers Examples ===");
        
        // Test cycle detection
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next; // Create cycle
        
        System.out.println("Has cycle: " + hasCycle(head));
        System.out.println("Cycle start: " + detectCycle(head).val);
        
        // Test middle finding
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        
        System.out.println("Middle node: " + findMiddle(list).val);
        
        // Test palindrome
        ListNode palindrome = new ListNode(1);
        palindrome.next = new ListNode(2);
        palindrome.next.next = new ListNode(2);
        palindrome.next.next.next = new ListNode(1);
        
        System.out.println("Is palindrome: " + isPalindrome(palindrome));
        
        // Test duplicate detection
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number: " + findDuplicate(nums));
        
        // Test cycle in array
        int[] cycleArray = {2, 6, 4, 1, 3, 1, 5};
        System.out.println("Has cycle in array: " + hasCycleInArray(cycleArray));
        System.out.println("Cycle start in array: " + findCycleStart(cycleArray));
        
        // Test middle element
        int[] middleArray = {1, 2, 3, 4, 5};
        System.out.println("Middle element: " + findMiddleElement(middleArray));
        
        // Test kth from end
        System.out.println("2nd from end: " + findKthFromEnd(list, 2).val);
    }
}
