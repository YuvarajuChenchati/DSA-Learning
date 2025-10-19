# Two Pointers Pattern 👥

> **Master the two pointers technique for efficient array and string problems**

## 🎯 Learning Objectives

- Understand two pointers fundamentals
- Master two pointers patterns
- Learn when to use two pointers
- Apply two pointers to solve problems

## 📚 Theory

### Two Pointers Basics

#### Properties
- **Two indices**: Start and end of array/string
- **Opposite directions**: Move towards each other
- **Same direction**: Move in same direction
- **Fast and slow**: Different speeds
- **Efficient**: O(n) time complexity

#### Common Patterns
- **Opposite ends**: Start from both ends
- **Same direction**: Both start from beginning
- **Fast and slow**: Different speeds
- **Sliding window**: Fixed or variable size
- **Cycle detection**: Floyd's algorithm

### When to Use Two Pointers

#### Sorted Arrays
- **Two Sum**: Find pair with target sum
- **Three Sum**: Find triplet with target sum
- **Remove Duplicates**: Remove duplicates in-place
- **Container With Most Water**: Find maximum area

#### Strings
- **Valid Palindrome**: Check if string is palindrome
- **Reverse String**: Reverse string in-place
- **Longest Substring**: Find longest substring
- **Anagram**: Check if strings are anagrams

## 🔧 Implementation

### Basic Two Pointers Pattern

```java
// Two pointers from opposite ends
public static int[] twoSum(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            return new int[]{left, right};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[]{};
}

// Two pointers from same direction
public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int writeIndex = 1;
    for (int readIndex = 1; readIndex < nums.length; readIndex++) {
        if (nums[readIndex] != nums[readIndex - 1]) {
            nums[writeIndex] = nums[readIndex];
            writeIndex++;
        }
    }
    return writeIndex;
}
```

### Advanced Two Pointers Patterns

```java
// Fast and slow pointers
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

// Sliding window
public static int maxSumSubarray(int[] arr, int k) {
    int windowSum = 0, maxSum = 0;
    
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
```

## 📝 Practice Problems

### Easy
1. **Two Sum** - O(n) time, O(1) space
2. **Valid Palindrome** - O(n) time, O(1) space
3. **Remove Duplicates** - O(n) time, O(1) space
4. **Move Zeroes** - O(n) time, O(1) space
5. **Reverse String** - O(n) time, O(1) space

### Medium
1. **Three Sum** - O(n²) time, O(1) space
2. **Container With Most Water** - O(n) time, O(1) space
3. **Longest Substring Without Repeating Characters** - O(n) time, O(1) space
4. **Sort Colors** - O(n) time, O(1) space
5. **Remove Nth Node From End** - O(n) time, O(1) space

### Hard
1. **Trapping Rain Water** - O(n) time, O(1) space
2. **Minimum Window Substring** - O(n) time, O(1) space
3. **Sliding Window Maximum** - O(n) time, O(k) space
4. **Longest Substring with At Most K Distinct Characters** - O(n) time, O(k) space
5. **Fruit Into Baskets** - O(n) time, O(1) space

## 💡 Key Insights

- **Sorted arrays**: Use opposite ends pattern
- **Unsorted arrays**: Use same direction pattern
- **Linked lists**: Use fast and slow pointers
- **Strings**: Use for palindrome and substring problems
- **Sliding window**: Use for subarray problems

## 🎯 Interview Tips

- Identify if array is sorted
- Choose appropriate pointer movement
- Consider edge cases (empty array, single element)
- Think about space optimization
- Use two pointers for O(n) solutions

## 📚 Additional Resources

- [Two Pointers Technique](https://www.geeksforgeeks.org/two-pointers-technique/)
- [Sliding Window Technique](https://www.geeksforgeeks.org/window-sliding-technique/)
- [Fast and Slow Pointers](https://www.geeksforgeeks.org/detect-loop-in-linked-list/)
- [Two Pointers Problems](https://leetcode.com/tag/two-pointers/)
