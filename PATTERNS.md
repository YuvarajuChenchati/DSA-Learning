# Coding Patterns for Technical Interviews 🎯

> **Master 20+ essential coding patterns that appear in 90% of technical interviews**

## 📋 Pattern Overview

| Pattern | Frequency | Difficulty | Key Concepts |
|---------|------------|------------|-------------|
| Two Pointers | ⭐⭐⭐⭐⭐ | Easy-Medium | Array traversal, palindrome |
| Sliding Window | ⭐⭐⭐⭐⭐ | Medium | Subarray problems, optimization |
| Fast & Slow Pointers | ⭐⭐⭐⭐ | Medium | Cycle detection, middle finding |
| Merge Intervals | ⭐⭐⭐⭐ | Medium | Overlapping intervals |
| Cyclic Sort | ⭐⭐⭐ | Easy-Medium | Array with numbers in range |
| Top K Elements | ⭐⭐⭐⭐⭐ | Medium-Hard | Heap, priority queue |
| Subset Generation | ⭐⭐⭐ | Medium | Backtracking, combinations |
| Bitwise Manipulation | ⭐⭐⭐ | Medium | Bit operations, optimization |
| Knapsack | ⭐⭐⭐⭐ | Hard | Dynamic programming |
| State Machine | ⭐⭐⭐ | Hard | Complex state transitions |

## 🔥 Core Patterns (Must Master)

### 1. Two Pointers Pattern

**When to Use:**
- Sorted array problems
- Palindrome checking
- Finding pairs with target sum
- Removing duplicates

**Template:**
```java
public int twoPointers(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            return /* result */;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return -1;
}
```

**Common Problems:**
- Two Sum (sorted array)
- Valid Palindrome
- Container With Most Water
- Remove Duplicates from Sorted Array

### 2. Sliding Window Pattern

**When to Use:**
- Subarray/substring problems
- Fixed or variable window size
- Optimization problems

**Template:**
```java
public int slidingWindow(int[] arr, int k) {
    int windowStart = 0, windowSum = 0, maxSum = 0;
    
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd];
        
        if (windowEnd >= k - 1) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= arr[windowStart];
            windowStart++;
        }
    }
    return maxSum;
}
```

**Common Problems:**
- Maximum Sum Subarray of Size K
- Longest Substring with K Distinct Characters
- Fruit Into Baskets
- Minimum Window Substring

### 3. Fast & Slow Pointers Pattern

**When to Use:**
- Cycle detection in linked lists
- Finding middle of linked list
- Palindrome checking in linked lists

**Template:**
```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) {
            return true; // Cycle detected
        }
    }
    return false;
}
```

**Common Problems:**
- Linked List Cycle
- Middle of the Linked List
- Palindrome Linked List
- Find the Duplicate Number

### 4. Merge Intervals Pattern

**When to Use:**
- Overlapping intervals
- Scheduling problems
- Time-based conflicts

**Template:**
```java
public int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> merged = new ArrayList<>();
    
    for (int[] interval : intervals) {
        if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
            merged.add(interval);
        } else {
            merged.get(merged.size() - 1)[1] = 
                Math.max(merged.get(merged.size() - 1)[1], interval[1]);
        }
    }
    return merged.toArray(new int[merged.size()][]);
}
```

**Common Problems:**
- Merge Intervals
- Insert Interval
- Meeting Rooms
- Employee Free Time

### 5. Cyclic Sort Pattern

**When to Use:**
- Array with numbers in range [1, n]
- Finding missing/duplicate numbers
- In-place sorting

**Template:**
```java
public void cyclicSort(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correctIndex = nums[i] - 1;
        if (nums[i] != nums[correctIndex]) {
            swap(nums, i, correctIndex);
        } else {
            i++;
        }
    }
}
```

**Common Problems:**
- Find All Numbers Disappeared in an Array
- Find the Duplicate Number
- First Missing Positive
- Set Mismatch

## 🚀 Advanced Patterns

### 6. Top K Elements Pattern

**When to Use:**
- Finding K largest/smallest elements
- Frequency-based problems
- Priority queue problems

**Template:**
```java
public int[] topKElements(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    return minHeap.stream().mapToInt(i -> i).toArray();
}
```

**Common Problems:**
- Kth Largest Element in an Array
- Top K Frequent Elements
- K Closest Points to Origin
- Reorganize String

### 7. Subset Generation Pattern

**When to Use:**
- Generating all subsets/combinations
- Permutation problems
- Backtracking problems

**Template:**
```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
}

private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    
    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        backtrack(nums, i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```

**Common Problems:**
- Subsets
- Subsets II
- Permutations
- Combination Sum

### 8. Bitwise Manipulation Pattern

**When to Use:**
- Bit manipulation problems
- Optimization problems
- XOR operations

**Template:**
```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result ^= num; // XOR operation
    }
    return result;
}
```

**Common Problems:**
- Single Number
- Missing Number
- Number of 1 Bits
- Reverse Bits

### 9. Knapsack Pattern

**When to Use:**
- Optimization problems
- Resource allocation
- Dynamic programming

**Template:**
```java
public int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= capacity; w++) {
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(
                    dp[i - 1][w],
                    dp[i - 1][w - weights[i - 1]] + values[i - 1]
                );
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }
    return dp[n][capacity];
}
```

**Common Problems:**
- 0/1 Knapsack
- Unbounded Knapsack
- Partition Equal Subset Sum
- Target Sum

### 10. State Machine Pattern

**When to Use:**
- Complex state transitions
- Finite state machines
- Multi-step processes

**Template:**
```java
public int maxProfit(int[] prices) {
    int hold = Integer.MIN_VALUE, sold = 0, rest = 0;
    
    for (int price : prices) {
        int prevSold = sold;
        sold = hold + price;
        hold = Math.max(hold, rest - price);
        rest = Math.max(rest, prevSold);
    }
    
    return Math.max(sold, rest);
}
```

**Common Problems:**
- Best Time to Buy and Sell Stock with Cooldown
- House Robber II
- Stock Buy and Sell with Transaction Fee
- Wiggle Subsequence

## 🎯 Pattern Recognition Guide

### How to Identify Patterns

1. **Two Pointers**: Sorted array, palindrome, pairs
2. **Sliding Window**: Subarray/substring, optimization
3. **Fast & Slow Pointers**: Linked list, cycle detection
4. **Merge Intervals**: Overlapping ranges, scheduling
5. **Cyclic Sort**: Array with numbers in range [1, n]
6. **Top K Elements**: K largest/smallest, frequency
7. **Subset Generation**: All combinations, backtracking
8. **Bitwise Manipulation**: Bit operations, XOR
9. **Knapsack**: Optimization, resource allocation
10. **State Machine**: Complex transitions, multi-step

### Pattern Selection Flowchart

```
Problem Type?
├── Array/List → Two Pointers, Sliding Window, Cyclic Sort
├── Linked List → Fast & Slow Pointers
├── Intervals → Merge Intervals
├── K Elements → Top K Elements
├── Subsets/Permutations → Subset Generation
├── Bit Operations → Bitwise Manipulation
├── Optimization → Knapsack, Greedy
└── Complex States → State Machine
```

## 📚 Practice Strategy

### Week 1-2: Core Patterns
- Two Pointers
- Sliding Window
- Fast & Slow Pointers

### Week 3-4: Intermediate Patterns
- Merge Intervals
- Cyclic Sort
- Top K Elements

### Week 5-6: Advanced Patterns
- Subset Generation
- Bitwise Manipulation
- Knapsack

### Week 7-8: Expert Patterns
- State Machine
- Advanced DP
- Complex Combinations

## 🎯 Interview Tips

### Pattern Recognition in Interviews

1. **Read the problem carefully**
2. **Identify the data structure**
3. **Look for keywords** (sorted, subarray, cycle, etc.)
4. **Consider time/space constraints**
5. **Choose the appropriate pattern**

### Common Interview Questions by Pattern

**Two Pointers:**
- "Find two numbers that sum to target"
- "Check if string is palindrome"
- "Remove duplicates from sorted array"

**Sliding Window:**
- "Find maximum sum of subarray of size k"
- "Longest substring with k distinct characters"
- "Minimum window substring"

**Fast & Slow Pointers:**
- "Detect cycle in linked list"
- "Find middle of linked list"
- "Find duplicate number"

## 🚀 Advanced Pattern Combinations

### Multi-Pattern Problems

1. **Two Pointers + Sliding Window**
   - Longest Substring Without Repeating Characters
   - Minimum Window Substring

2. **Fast & Slow Pointers + Two Pointers**
   - Palindrome Linked List
   - Reorder List

3. **Merge Intervals + Greedy**
   - Meeting Rooms II
   - Employee Free Time

4. **Top K Elements + Heap**
   - Merge k Sorted Lists
   - Find Median from Data Stream

## 📈 Progress Tracking

### Pattern Mastery Checklist

- [ ] Two Pointers (5+ problems)
- [ ] Sliding Window (5+ problems)
- [ ] Fast & Slow Pointers (5+ problems)
- [ ] Merge Intervals (5+ problems)
- [ ] Cyclic Sort (5+ problems)
- [ ] Top K Elements (5+ problems)
- [ ] Subset Generation (5+ problems)
- [ ] Bitwise Manipulation (5+ problems)
- [ ] Knapsack (5+ problems)
- [ ] State Machine (5+ problems)

### Mastery Indicators

- **Beginner**: Can implement pattern when given template
- **Intermediate**: Can recognize pattern in new problems
- **Advanced**: Can combine patterns for complex problems
- **Expert**: Can create new patterns for novel problems

---

**Remember**: Pattern recognition is a skill that improves with practice. Start with the core patterns and gradually work your way up to advanced combinations. You've got this! 💪
