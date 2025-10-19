# Pattern Recognition Cheat Sheet 🔍

> **Quick reference for identifying and solving common algorithmic patterns**

## 🎯 Overview

Patterns are recurring solutions to common problems. Recognizing patterns helps solve problems faster and more efficiently.

## 🔄 Common Patterns

### 1. Two Pointers
- **When to use**: Sorted arrays, palindromes, pairs
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Examples**: Two sum, three sum, container with most water

```java
// Two pointers template
int left = 0, right = arr.length - 1;
while (left < right) {
    if (condition) {
        // process
        left++;
    } else {
        // process
        right--;
    }
}
```

### 2. Sliding Window
- **When to use**: Subarrays, substrings, fixed/variable window
- **Time Complexity**: O(n)
- **Space Complexity**: O(1) or O(k)
- **Examples**: Maximum sum subarray, longest substring

```java
// Sliding window template
int left = 0;
for (int right = 0; right < arr.length; right++) {
    // expand window
    while (windowInvalid) {
        // shrink window
        left++;
    }
    // update result
}
```

### 3. Fast and Slow Pointers
- **When to use**: Linked lists, cycle detection
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Examples**: Cycle detection, middle of linked list

```java
// Fast and slow pointers template
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    // process
}
```

### 4. Merge Intervals
- **When to use**: Overlapping intervals, scheduling
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(1)
- **Examples**: Meeting rooms, merge intervals

```java
// Merge intervals template
Arrays.sort(intervals, (a, b) -> a.start - b.start);
for (int i = 1; i < intervals.length; i++) {
    if (intervals[i].start <= intervals[i-1].end) {
        // merge intervals
    }
}
```

### 5. Cyclic Sort
- **When to use**: Numbers in range [1, n], missing/duplicate numbers
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Examples**: Find missing number, find duplicates

```java
// Cyclic sort template
int i = 0;
while (i < arr.length) {
    int correctIndex = arr[i] - 1;
    if (arr[i] != arr[correctIndex]) {
        swap(arr, i, correctIndex);
    } else {
        i++;
    }
}
```

### 6. Top K Elements
- **When to use**: Kth largest/smallest, frequent elements
- **Time Complexity**: O(n log k)
- **Space Complexity**: O(k)
- **Examples**: Kth largest element, top K frequent

```java
// Top K elements template
PriorityQueue<Integer> heap = new PriorityQueue<>();
for (int num : nums) {
    heap.offer(num);
    if (heap.size() > k) {
        heap.poll();
    }
}
```

### 7. Subsets
- **When to use**: All combinations, permutations
- **Time Complexity**: O(2^n)
- **Space Complexity**: O(2^n)
- **Examples**: Subsets, combinations, permutations

```java
// Subsets template
public void backtrack(int[] nums, int start, List<Integer> current) {
    result.add(new ArrayList<>(current));
    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        backtrack(nums, i + 1, current);
        current.remove(current.size() - 1);
    }
}
```

### 8. Bitwise XOR
- **When to use**: Single number, missing number
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Examples**: Single number, missing number

```java
// Bitwise XOR template
int result = 0;
for (int num : nums) {
    result ^= num;
}
```

### 9. Knapsack
- **When to use**: Optimization problems, resource allocation
- **Time Complexity**: O(n * capacity)
- **Space Complexity**: O(capacity)
- **Examples**: 0/1 knapsack, coin change

```java
// Knapsack template
int[] dp = new int[capacity + 1];
for (int i = 0; i < items.length; i++) {
    for (int w = capacity; w >= weights[i]; w--) {
        dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
    }
}
```

### 10. Tree BFS/DFS
- **When to use**: Tree traversal, level order
- **Time Complexity**: O(n)
- **Space Complexity**: O(h) for DFS, O(w) for BFS
- **Examples**: Level order traversal, path sum

```java
// Tree BFS template
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);
while (!queue.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        // process node
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

## 🔍 Pattern Recognition Guide

### Step 1: Analyze the Problem
1. **Input type**: Array, string, tree, graph
2. **Output type**: Single value, array, boolean
3. **Constraints**: Size, time, space limits
4. **Keywords**: "subarray", "substring", "kth", "missing", "duplicate"

### Step 2: Identify the Pattern
1. **Look for keywords**: "subarray" → sliding window
2. **Check data structure**: "linked list" → fast/slow pointers
3. **Consider operations**: "find kth" → top K elements
4. **Analyze complexity**: O(n) → two pointers, sliding window

### Step 3: Apply the Pattern
1. **Use template**: Start with known pattern template
2. **Modify for problem**: Adapt template to specific problem
3. **Handle edge cases**: Empty input, single element
4. **Optimize if needed**: Space optimization, time optimization

## 📊 Pattern Selection Matrix

| Problem Type | Pattern | Time | Space | Example |
|--------------|---------|------|-------|---------|
| Sorted array pairs | Two Pointers | O(n) | O(1) | Two sum |
| Subarray problems | Sliding Window | O(n) | O(1) | Max sum subarray |
| Linked list cycles | Fast/Slow Pointers | O(n) | O(1) | Cycle detection |
| Interval problems | Merge Intervals | O(n log n) | O(1) | Meeting rooms |
| Missing/duplicate | Cyclic Sort | O(n) | O(1) | Find missing |
| Kth element | Top K Elements | O(n log k) | O(k) | Kth largest |
| All combinations | Subsets | O(2^n) | O(2^n) | Subsets |
| Single number | Bitwise XOR | O(n) | O(1) | Single number |
| Optimization | Knapsack | O(n * W) | O(W) | 0/1 knapsack |
| Tree traversal | Tree BFS/DFS | O(n) | O(h) | Level order |

## 💡 Pattern Tips

### Recognition Strategies
1. **Read the problem carefully**: Look for keywords
2. **Consider data structure**: Array, string, tree, graph
3. **Think about operations**: Search, insert, delete, traverse
4. **Check constraints**: Time and space limits
5. **Look for patterns**: Common problem patterns

### Implementation Tips
1. **Start with template**: Use known pattern template
2. **Modify gradually**: Adapt template to problem
3. **Test edge cases**: Empty input, single element
4. **Optimize if needed**: Space or time optimization
5. **Verify correctness**: Check with examples

### Common Mistakes
1. **Wrong pattern**: Don't force a pattern that doesn't fit
2. **Incorrect template**: Use wrong template for pattern
3. **Edge cases**: Forgetting to handle edge cases
4. **Complexity**: Not considering time/space complexity
5. **Implementation**: Bugs in pattern implementation

## 🎯 Practice Strategy

### Pattern Practice
1. **Learn templates**: Memorize common pattern templates
2. **Practice variations**: Solve different problems with same pattern
3. **Time yourself**: Practice under time pressure
4. **Review solutions**: Understand why pattern works
5. **Build intuition**: Develop pattern recognition skills

### Problem Solving
1. **Read problem**: Understand what's being asked
2. **Identify pattern**: Look for keywords and hints
3. **Choose template**: Select appropriate pattern template
4. **Implement solution**: Code the solution
5. **Test and debug**: Verify correctness

## 📚 Additional Resources

- [Pattern Recognition](https://www.geeksforgeeks.org/pattern-recognition/)
- [Algorithm Patterns](https://www.geeksforgeeks.org/algorithm-patterns/)
- [Problem Solving](https://www.geeksforgeeks.org/problem-solving/)
- [Coding Patterns](https://www.geeksforgeeks.org/coding-patterns/)

---

**Remember**: Pattern recognition is a skill that improves with practice. The more patterns you recognize, the faster you'll solve problems! 🚀
