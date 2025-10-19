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

## 🎯 Interview Tips

- Start with brute force, then optimize
- Consider two pointers for sorted arrays
- Use sliding window for subarray problems
- Think about in-place operations
- Consider sorting as a preprocessing step

## 📚 Additional Resources

- [Array Algorithms](https://www.geeksforgeeks.org/array-data-structure/)
- [Two Pointers Technique](https://www.geeksforgeeks.org/two-pointers-technique/)
- [Sliding Window Technique](https://www.geeksforgeeks.org/window-sliding-technique/)
- [Prefix Sum Array](https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/)
