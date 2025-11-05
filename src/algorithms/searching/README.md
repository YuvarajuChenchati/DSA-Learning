# Searching Algorithms 🔍

> **Master searching algorithms and their applications**

## 🎯 Learning Objectives

- Understand searching fundamentals
- Master linear and binary search
- Learn advanced searching techniques
- Apply searching patterns to solve problems

## 📚 Theory

### Searching Basics

#### Properties
- **Linear Search**: O(n) time, O(1) space
- **Binary Search**: O(log n) time, O(1) space
- **Jump Search**: O(√n) time, O(1) space
- **Interpolation Search**: O(log log n) average, O(n) worst case
- **Exponential Search**: O(log n) time, O(1) space

#### Common Operations
- **Search**: Find element in collection
- **Insert**: Add element to collection
- **Delete**: Remove element from collection
- **Update**: Modify element in collection

### When to Use Each Algorithm

#### Linear Search
- **Unsorted arrays**: Only option for unsorted data
- **Small datasets**: Simple and straightforward
- **Linked lists**: Sequential access only

#### Binary Search
- **Sorted arrays**: Most efficient for sorted data
- **Large datasets**: Logarithmic time complexity
- **Range queries**: Find elements in range

#### Advanced Searches
- **Jump Search**: Sorted arrays, better than linear
- **Interpolation Search**: Uniformly distributed data
- **Exponential Search**: Unbounded arrays

## 🔧 Implementation

### Basic Searching Algorithms

```java
// Linear Search
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

// Binary Search (Iterative)
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

// Binary Search (Recursive)
public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
    if (left > right) return -1;
    
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
    else return binarySearchRecursive(arr, target, left, mid - 1);
}
```

### Advanced Searching Algorithms

```java
// Jump Search
public static int jumpSearch(int[] arr, int target) {
    int n = arr.length;
    int step = (int) Math.sqrt(n);
    int prev = 0;
    
    while (arr[Math.min(step, n) - 1] < target) {
        prev = step;
        step += (int) Math.sqrt(n);
        if (prev >= n) return -1;
    }
    
    while (arr[prev] < target) {
        prev++;
        if (prev == Math.min(step, n)) return -1;
    }
    
    return arr[prev] == target ? prev : -1;
}

// Interpolation Search
public static int interpolationSearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right && target >= arr[left] && target <= arr[right]) {
        int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);
        
        if (arr[pos] == target) return pos;
        else if (arr[pos] < target) left = pos + 1;
        else right = pos - 1;
    }
    return -1;
}
```

## 📝 Practice Problems

### Easy
1. **Binary Search** - O(log n) time, O(1) space
2. **Search Insert Position** - O(log n) time, O(1) space
3. **First Bad Version** - O(log n) time, O(1) space
4. **Sqrt(x)** - O(log x) time, O(1) space
5. **Guess Number Higher or Lower** - O(log n) time, O(1) space

### Medium
1. **Search in Rotated Sorted Array** - O(log n) time, O(1) space
2. **Find First and Last Position** - O(log n) time, O(1) space
3. **Search in 2D Matrix** - O(log(mn)) time, O(1) space
4. **Find Peak Element** - O(log n) time, O(1) space
5. **Search for Range** - O(log n) time, O(1) space

### Hard
1. **Median of Two Sorted Arrays** - O(log(min(m,n))) time, O(1) space
2. **Kth Smallest in Sorted Matrix** - O(n log(max-min)) time, O(1) space
3. **Find Minimum in Rotated Sorted Array** - O(log n) time, O(1) space
4. **Search in Rotated Sorted Array II** - O(log n) time, O(1) space
5. **Find K Closest Elements** - O(log n + k) time, O(1) space

## 💡 Key Insights

- **Binary search**: Most efficient for sorted arrays
- **Linear search**: Only option for unsorted data
- **Jump search**: Good compromise for sorted arrays
- **Interpolation search**: Best for uniformly distributed data
- **Exponential search**: Useful for unbounded arrays

## ⚠️ Common Mistakes

### Binary Search Off-by-One Errors
- **Problem**: Wrong boundary conditions in binary search
- **Solution**: Use consistent boundary conditions (`left <= right` or `left < right`)
- **Example**: 
  ```java
  // Wrong
  while (left < right) {
      if (arr[mid] < target) left = mid; // Should be mid + 1
  }
  
  // Correct
  while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < target) left = mid + 1;
      else right = mid - 1;
  }
  ```

### Integer Overflow
- **Problem**: `(left + right) / 2` can overflow
- **Solution**: Use `left + (right - left) / 2`
- **Example**: Always use safe midpoint calculation

### Not Checking Array Sorted
- **Problem**: Using binary search on unsorted array
- **Solution**: Always verify array is sorted first
- **Example**: Check if array is sorted before binary search

### Missing Base Case in Recursion
- **Problem**: No base case in recursive binary search
- **Solution**: Always check `left > right` first
- **Example**: 
  ```java
  if (left > right) return -1; // Base case
  ```

### Wrong Search Space
- **Problem**: Incorrectly defining search boundaries
- **Solution**: Clearly define what you're searching for
- **Example**: For rotated array, identify which half is sorted

## 🎯 Interview Tips

### Problem-Solving Approach
- **Check if sorted**: Always verify array is sorted for binary search
- **Identify pattern**: Look for search space reduction opportunities
- **Edge cases**: Empty array, single element, not found
- **Boundary conditions**: Be careful with `<=` vs `<`
- **Mid calculation**: Always use safe midpoint formula

### Coding Tips
- **Use iterative**: Often cleaner than recursive
- **Consistent boundaries**: Stick with one boundary style
- **Safe midpoint**: Always use `left + (right - left) / 2`
- **Test with examples**: Walk through with sample inputs
- **Handle not found**: Return -1 or appropriate value

### Common Patterns
- **Standard Binary Search**: For finding exact match
- **Modified Binary Search**: For rotated arrays, peak finding
- **Binary Search on Answer**: For optimization problems
- **Search Space Reduction**: Narrow down search space

## 📚 Additional Resources

### Practice Problems
- [Searching Problems](src/algorithms/searching/Problems.md) - Comprehensive problem list (to be created)
- [Easy Searching Problems](src/problems/easy/README.md) - Easy level problems
- [Medium Searching Problems](src/problems/medium/README.md) - Medium level problems
- [Hard Searching Problems](src/problems/hard/README.md) - Hard level problems

### External Resources
- [Searching Algorithms](https://www.geeksforgeeks.org/searching-algorithms/)
- [Binary Search](https://www.geeksforgeeks.org/binary-search/)
- [Jump Search](https://www.geeksforgeeks.org/jump-search/)
- [Interpolation Search](https://www.geeksforgeeks.org/interpolation-search/)

### Related Topics
- [Arrays](src/datastructures/arrays/README.md) - Array operations
- [Divide & Conquer](src/algorithms/divideconquer/README.md) - Divide and conquer
- [Binary Search Pattern](src/patterns/topkelements/README.md) - Binary search patterns
