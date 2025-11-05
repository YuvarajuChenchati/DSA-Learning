# Arrays 📊

> **Master array operations and common patterns for technical interviews**

## 🎯 Learning Objectives

- Understand array fundamentals
- Master common array operations
- Learn array-based algorithms
- Apply array patterns to solve problems

## 📚 Theory

### Array Basics

#### Properties
- **Fixed size**: Arrays have a fixed size once created
- **Contiguous memory**: Elements are stored in contiguous memory locations
- **Random access**: O(1) access time for any element
- **Homogeneous**: All elements must be of the same type

#### Common Operations
- **Access**: O(1) time
- **Search**: O(n) time for linear search
- **Insertion**: O(n) time (shifting required)
- **Deletion**: O(n) time (shifting required)
- **Update**: O(1) time

### Array Patterns

#### Two Pointers
- **Left and right pointers**: For sorted arrays
- **Fast and slow pointers**: For cycle detection
- **Sliding window**: For subarray problems

#### Prefix Sum
- **Precompute sums**: For range sum queries
- **Cumulative arrays**: For optimization problems

## 🔧 Implementation

### Basic Array Operations

```java
// Linear search
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

// Binary search (for sorted arrays)
public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

### Two Pointers Pattern

```java
// Two sum in sorted array
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
```

### Sliding Window Pattern

```java
// Maximum sum of subarray of size k
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
1. **Two Sum** - O(n) time, O(n) space
2. **Remove Duplicates** - O(n) time, O(1) space
3. **Rotate Array** - O(n) time, O(1) space
4. **Contains Duplicate** - O(n) time, O(n) space
5. **Single Number** - O(n) time, O(1) space

### Medium
1. **Three Sum** - O(n²) time, O(1) space
2. **Container With Most Water** - O(n) time, O(1) space
3. **Product of Array Except Self** - O(n) time, O(1) space
4. **Maximum Subarray** - O(n) time, O(1) space
5. **Spiral Matrix** - O(mn) time, O(1) space

### Hard
1. **Trapping Rain Water** - O(n) time, O(1) space
2. **First Missing Positive** - O(n) time, O(1) space
3. **Merge Intervals** - O(n log n) time, O(1) space
4. **Insert Interval** - O(n) time, O(1) space
5. **Minimum Window Substring** - O(n) time, O(1) space

## 💡 Key Insights

- **Two pointers**: Efficient for sorted arrays
- **Sliding window**: Optimal for subarray problems
- **Prefix sum**: Useful for range queries
- **In-place operations**: Save space complexity
- **Sorting**: Often simplifies array problems

## ⚠️ Common Mistakes

### Off-by-One Errors
- **Problem**: Incorrect array bounds checking
- **Solution**: Always check `i < arr.length` not `i <= arr.length`
- **Example**: `for (int i = 0; i < arr.length; i++)` not `i <= arr.length`

### Array Index Out of Bounds
- **Problem**: Accessing array elements without bounds checking
- **Solution**: Always validate indices before accessing
- **Example**: Check `index >= 0 && index < arr.length` before accessing

### Memory Issues
- **Problem**: Creating unnecessary arrays when in-place operations are possible
- **Solution**: Use two pointers or in-place algorithms
- **Example**: Remove duplicates in-place instead of creating new array

### Edge Cases
- **Problem**: Not handling empty arrays, single element, or null inputs
- **Solution**: Always check for edge cases first
- **Example**: `if (arr == null || arr.length == 0) return result;`

### Two Pointers Mistakes
- **Problem**: Moving pointers incorrectly in two-pointer problems
- **Solution**: Understand when to move which pointer
- **Example**: In sorted array, move left if sum < target, right if sum > target

### Sliding Window Issues
- **Problem**: Not maintaining window size correctly
- **Solution**: Track window boundaries carefully
- **Example**: Shrink window when condition violated, expand when valid

## 🎯 Interview Tips

### Problem-Solving Approach
- **Start with brute force**: Get a working solution first
- **Identify patterns**: Look for two pointers, sliding window, prefix sum
- **Optimize step by step**: Improve time/space complexity gradually
- **Consider edge cases**: Empty arrays, single element, null inputs
- **Think about sorting**: Often simplifies array problems

### Coding Tips
- **Use descriptive variable names**: `left`, `right`, `windowSum`
- **Add comments**: Explain complex logic
- **Handle edge cases first**: Check for null, empty arrays
- **Test with examples**: Walk through with sample inputs
- **Optimize space**: Use in-place operations when possible

### Common Patterns
- **Two Pointers**: For sorted arrays, palindromes, pairs
- **Sliding Window**: For subarray problems, fixed/variable window
- **Prefix Sum**: For range sum queries, cumulative problems
- **Hash Map**: For lookups, frequency counting
- **Sorting**: When order matters, optimization

## 📚 Additional Resources

### Practice Problems
- [Array Problems](src/datastructures/arrays/Problems.md) - Comprehensive problem list
- [Easy Array Problems](src/problems/easy/README.md) - Easy level problems
- [Medium Array Problems](src/problems/medium/README.md) - Medium level problems
- [Hard Array Problems](src/problems/hard/README.md) - Hard level problems

### External Resources
- [Array Algorithms](https://www.geeksforgeeks.org/array-data-structure/)
- [Two Pointers Technique](https://www.geeksforgeeks.org/two-pointers-technique/)
- [Sliding Window Technique](https://www.geeksforgeeks.org/window-sliding-technique/)
- [Prefix Sum Array](https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/)

### Related Topics
- [Strings](src/datastructures/strings/README.md) - String manipulation
- [Two Pointers Pattern](src/patterns/twopointers/README.md) - Two pointers technique
- [Sliding Window Pattern](src/patterns/slidingwindow/README.md) - Sliding window pattern
