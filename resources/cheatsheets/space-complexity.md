# Space Complexity Cheat Sheet 📊

> **Quick reference for space complexity analysis and optimization**

## 🎯 Overview

Space complexity measures the amount of memory an algorithm uses relative to input size.

## 📊 Space Complexity Classes

### O(1) - Constant Space
- **Examples**: Variables, counters, simple calculations
- **Characteristics**: Memory usage doesn't grow with input
- **Use cases**: Simple algorithms, in-place operations

```java
// O(1) space
public int sum(int a, int b) {
    return a + b;
}
```

### O(log n) - Logarithmic Space
- **Examples**: Binary search, divide and conquer
- **Characteristics**: Memory grows logarithmically
- **Use cases**: Recursive algorithms, tree traversals

```java
// O(log n) space
public int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1;
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, right);
    else return binarySearch(arr, target, left, mid - 1);
}
```

### O(n) - Linear Space
- **Examples**: Arrays, hash tables, single recursion
- **Characteristics**: Memory grows linearly with input
- **Use cases**: Most common space complexity

```java
// O(n) space
public int[] createArray(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = i;
    }
    return arr;
}
```

### O(n log n) - Linearithmic Space
- **Examples**: Merge sort, heap sort
- **Characteristics**: Memory grows with n log n
- **Use cases**: Efficient sorting algorithms

```java
// O(n log n) space
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
```

### O(n²) - Quadratic Space
- **Examples**: 2D arrays, nested loops
- **Characteristics**: Memory grows quadratically
- **Use cases**: Matrix operations, dynamic programming

```java
// O(n²) space
public int[][] createMatrix(int n) {
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = i * j;
        }
    }
    return matrix;
}
```

### O(2^n) - Exponential Space
- **Examples**: Recursive algorithms, subset generation
- **Characteristics**: Memory grows exponentially
- **Use cases**: Backtracking, recursive problems

```java
// O(2^n) space
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
}
```

## 🔧 Space Optimization Techniques

### 1. In-Place Algorithms
- **Goal**: Modify input without extra space
- **Examples**: Quick sort, heap sort, in-place merge
- **Benefits**: O(1) extra space

```java
// In-place array reversal
public void reverse(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        swap(arr, left, right);
        left++;
        right--;
    }
}
```

### 2. Space-Time Tradeoffs
- **Goal**: Use more space to reduce time
- **Examples**: Memoization, precomputation
- **Benefits**: Faster execution

```java
// Memoization for Fibonacci
public int fibonacci(int n) {
    int[] memo = new int[n + 1];
    return fibonacciHelper(n, memo);
}

private int fibonacciHelper(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    memo[n] = fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo);
    return memo[n];
}
```

### 3. Iterative vs Recursive
- **Goal**: Reduce recursion stack space
- **Examples**: Convert recursive to iterative
- **Benefits**: O(1) space instead of O(n)

```java
// Iterative factorial (O(1) space)
public int factorial(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

// Recursive factorial (O(n) space)
public int factorialRecursive(int n) {
    if (n <= 1) return 1;
    return n * factorialRecursive(n - 1);
}
```

### 4. Data Structure Optimization
- **Goal**: Use space-efficient data structures
- **Examples**: BitSet instead of boolean array
- **Benefits**: Reduced memory footprint

```java
// BitSet for boolean flags
public void processFlags(int n) {
    BitSet flags = new BitSet(n);
    for (int i = 0; i < n; i++) {
        flags.set(i, i % 2 == 0);
    }
}
```

## 📊 Common Space Complexities

### Data Structures
| Structure | Space | Notes |
|-----------|-------|-------|
| Array | O(n) | Linear space |
| Hash Table | O(n) | Average case |
| Tree | O(n) | n nodes |
| Graph | O(V + E) | Vertices + Edges |
| Stack | O(n) | Maximum depth |
| Queue | O(n) | Maximum size |

### Algorithms
| Algorithm | Space | Notes |
|-----------|-------|-------|
| Bubble Sort | O(1) | In-place |
| Merge Sort | O(n) | Not in-place |
| Quick Sort | O(log n) | Average case |
| Heap Sort | O(1) | In-place |
| Binary Search | O(log n) | Recursive |
| DFS | O(h) | Height of tree |
| BFS | O(w) | Width of tree |

## 🎯 Space Complexity Analysis

### Step-by-Step Process
1. **Identify variables**: Count all variables and data structures
2. **Analyze recursion**: Count recursion depth
3. **Consider auxiliary space**: Extra space beyond input
4. **Account for data structures**: Size of collections
5. **Calculate total**: Sum all space requirements

### Common Patterns
- **Single variable**: O(1)
- **Array of size n**: O(n)
- **Recursion depth d**: O(d)
- **Hash table with n elements**: O(n)
- **Tree with n nodes**: O(n)

## 💡 Optimization Tips

### Memory Management
- **Reuse variables**: Don't create unnecessary variables
- **Clear references**: Set unused references to null
- **Use primitives**: Prefer int over Integer when possible
- **Avoid autoboxing**: Use primitive types when possible

### Algorithm Selection
- **Choose in-place**: When possible, use in-place algorithms
- **Consider tradeoffs**: Balance time vs space complexity
- **Use appropriate data structures**: Choose space-efficient structures
- **Optimize recursion**: Convert to iterative when possible

### Java-Specific Tips
- **StringBuilder**: Use for string concatenation
- **ArrayList vs LinkedList**: Choose based on access patterns
- **HashMap vs TreeMap**: Consider space vs time tradeoffs
- **Array vs Collection**: Use arrays for fixed-size data

## 📚 Additional Resources

- [Space Complexity](https://www.geeksforgeeks.org/space-complexity/)
- [Memory Management](https://www.geeksforgeeks.org/memory-management-in-java/)
- [Data Structure Space Complexity](https://www.geeksforgeeks.org/space-complexity-of-different-data-structures/)
- [Algorithm Space Complexity](https://www.geeksforgeeks.org/space-complexity-of-algorithms/)

---

**Remember**: Space complexity is just as important as time complexity. Always consider both when designing algorithms! 🚀
