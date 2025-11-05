# Divide and Conquer 🔄

> **Master divide and conquer algorithms for efficient problem solving**

## 🎯 Learning Objectives

- Understand divide and conquer fundamentals
- Master the master theorem
- Learn common divide and conquer patterns
- Apply divide and conquer to solve problems

## 📚 Theory

### Divide and Conquer Basics

#### Properties
- **Divide**: Break problem into smaller subproblems
- **Conquer**: Solve subproblems recursively
- **Combine**: Merge solutions to get final result
- **Recursive**: Natural recursive structure
- **Efficient**: Often O(n log n) time complexity

#### Master Theorem
For recurrence relation: T(n) = aT(n/b) + f(n)
- If f(n) = O(n^c) where c < log_b(a): T(n) = Θ(n^(log_b(a)))
- If f(n) = Θ(n^c) where c = log_b(a): T(n) = Θ(n^c log n)
- If f(n) = Ω(n^c) where c > log_b(a): T(n) = Θ(f(n))

#### Common Patterns
- **Sorting**: Merge sort, quick sort
- **Searching**: Binary search
- **Mathematical**: Exponentiation, matrix multiplication
- **Geometric**: Closest pair of points
- **String**: Longest common subsequence

### When to Use Divide and Conquer

#### Problem Characteristics
- **Optimal substructure**: Problem can be broken into smaller subproblems
- **Overlapping subproblems**: Same subproblems appear multiple times
- **Independent subproblems**: Subproblems don't interfere with each other
- **Combine step**: Can efficiently combine solutions

#### Common Applications
- **Sorting algorithms**: Merge sort, quick sort
- **Search algorithms**: Binary search
- **Mathematical computations**: Fast exponentiation
- **Geometric algorithms**: Closest pair, convex hull
- **String algorithms**: Pattern matching

## 🔧 Implementation

### Basic Divide and Conquer Template

```java
public Result divideAndConquer(Problem problem) {
    // Base case
    if (isBaseCase(problem)) {
        return solveBaseCase(problem);
    }
    
    // Divide
    Problem[] subproblems = divide(problem);
    
    // Conquer
    Result[] subresults = new Result[subproblems.length];
    for (int i = 0; i < subproblems.length; i++) {
        subresults[i] = divideAndConquer(subproblems[i]);
    }
    
    // Combine
    return combine(subresults);
}
```

### Advanced Divide and Conquer Patterns

```java
// Merge sort
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

// Binary search
public int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1;
    
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, right);
    else return binarySearch(arr, target, left, mid - 1);
}
```

## 📝 Practice Problems

### Easy
1. **Binary Search** - O(log n) time, O(log n) space
2. **Search Insert Position** - O(log n) time, O(log n) space
3. **First Bad Version** - O(log n) time, O(log n) space
4. **Sqrt(x)** - O(log x) time, O(log x) space
5. **Guess Number Higher or Lower** - O(log n) time, O(log n) space

### Medium
1. **Search in Rotated Sorted Array** - O(log n) time, O(log n) space
2. **Find First and Last Position** - O(log n) time, O(log n) space
3. **Search in 2D Matrix** - O(log(mn)) time, O(log(mn)) space
4. **Find Peak Element** - O(log n) time, O(log n) space
5. **Search for Range** - O(log n) time, O(log n) space

### Hard
1. **Median of Two Sorted Arrays** - O(log(min(m,n))) time, O(log(min(m,n))) space
2. **Kth Smallest in Sorted Matrix** - O(n log(max-min)) time, O(log(max-min)) space
3. **Find Minimum in Rotated Sorted Array** - O(log n) time, O(log n) space
4. **Search in Rotated Sorted Array II** - O(log n) time, O(log n) space
5. **Find K Closest Elements** - O(log n + k) time, O(log n) space

## 💡 Key Insights

- **Base case**: Always define base case first
- **Divide strategy**: Choose how to split problem
- **Combine step**: Efficiently merge solutions
- **Time complexity**: Often O(n log n) due to divide step
- **Space complexity**: O(log n) due to recursion depth

## ⚠️ Common Mistakes

### Missing Base Case
- **Problem**: No base case for divide and conquer
- **Solution**: Always define base case for smallest problem
- **Example**: `if (left >= right) return;` for merge sort base case

### Incorrect Divide Step
- **Problem**: Not dividing problem correctly
- **Solution**: Divide problem into equal or balanced subproblems
- **Example**: Divide array into two halves: `mid = (left + right) / 2;`

### Wrong Combine Step
- **Problem**: Incorrectly combining solutions
- **Solution**: Correctly merge solutions from subproblems
- **Example**: Merge two sorted arrays in merge sort

### Not Handling Edge Cases
- **Problem**: Not handling empty or single element cases
- **Solution**: Always check edge cases first
- **Example**: `if (arr == null || arr.length <= 1) return;`

### Index Out of Bounds
- **Problem**: Array index out of bounds in divide step
- **Solution**: Check bounds before accessing: `left < right`
- **Example**: Check `mid >= 0 && mid < arr.length` before accessing arr[mid]

### Infinite Recursion
- **Problem**: Not reducing problem size in recursive call
- **Solution**: Ensure recursive calls work on smaller subproblems
- **Example**: `mergeSort(arr, left, mid);` not `mergeSort(arr, left, right);`

### Wrong Time Complexity
- **Problem**: Incorrectly analyzing time complexity
- **Solution**: Use master theorem for divide and conquer recurrences
- **Example**: Merge sort: T(n) = 2T(n/2) + O(n) = O(n log n)

### Not Optimizing Combine Step
- **Problem**: Inefficient combine step
- **Solution**: Optimize combine step for better performance
- **Example**: Merge two sorted arrays in O(n) time, not O(n²)

## 🎯 Interview Tips

- Always identify base case
- Consider how to divide problem
- Think about combine step
- Analyze time and space complexity
- Consider iterative vs recursive approaches

## 📚 Additional Resources

- [Divide and Conquer](https://www.geeksforgeeks.org/divide-and-conquer/)
- [Master Theorem](https://www.geeksforgeeks.org/analysis-algorithm-set-4-master-method-solving-recurrences/)
- [Merge Sort](https://www.geeksforgeeks.org/merge-sort/)
- [Binary Search](https://www.geeksforgeeks.org/binary-search/)
