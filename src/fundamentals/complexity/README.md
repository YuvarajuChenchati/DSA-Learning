# Complexity Analysis 📊

> **Understanding time and space complexity is crucial for writing efficient algorithms**

## 🎯 Learning Objectives

- Master Big O notation
- Analyze time and space complexity
- Compare different algorithms
- Optimize code performance

## 📚 Theory

### Time Complexity

Time complexity describes how the runtime of an algorithm grows with input size.

#### Common Complexity Classes

| Complexity | Notation | Description | Example |
|------------|----------|-------------|---------|
| Constant | O(1) | Same time regardless of input | Array access |
| Logarithmic | O(log n) | Time grows logarithmically | Binary search |
| Linear | O(n) | Time grows linearly | Linear search |
| Linearithmic | O(n log n) | Time grows as n log n | Merge sort |
| Quadratic | O(n²) | Time grows quadratically | Bubble sort |
| Exponential | O(2ⁿ) | Time grows exponentially | Fibonacci (naive) |
| Factorial | O(n!) | Time grows factorially | Permutations |

### Space Complexity

Space complexity describes how much memory an algorithm uses relative to input size.

#### Common Space Complexities

- **O(1)**: Constant space (in-place algorithms)
- **O(n)**: Linear space (arrays, recursion stack)
- **O(log n)**: Logarithmic space (binary search recursion)
- **O(n²)**: Quadratic space (2D arrays)

## 🔧 Implementation

### Complexity Analysis Examples

```java
// O(1) - Constant time
public int getFirstElement(int[] arr) {
    return arr[0];
}

// O(n) - Linear time
public int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

// O(n²) - Quadratic time
public void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
    }
}
```

## 📝 Practice Problems

### Easy
1. **Array Sum** - O(n) time, O(1) space
2. **Find Maximum** - O(n) time, O(1) space
3. **Linear Search** - O(n) time, O(1) space

### Medium
1. **Two Sum** - O(n) time, O(n) space
2. **Merge Sorted Arrays** - O(n + m) time, O(n + m) space
3. **Remove Duplicates** - O(n) time, O(1) space

### Hard
1. **Three Sum** - O(n²) time, O(1) space
2. **Maximum Subarray** - O(n) time, O(1) space
3. **Product of Array Except Self** - O(n) time, O(1) space

## 💡 Key Insights

- **Best Case**: Minimum time/space required
- **Average Case**: Expected time/space for random input
- **Worst Case**: Maximum time/space required
- **Amortized**: Average time per operation over sequence

## 🎯 Interview Tips

- Always analyze worst-case complexity
- Consider both time and space complexity
- Explain your analysis clearly
- Discuss trade-offs between different approaches
- Mention when you can optimize further

## 📚 Additional Resources

- [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
- [Time Complexity Visualizer](https://www.cs.usfca.edu/~galles/visualization/)
- [Space Complexity Guide](https://www.geeksforgeeks.org/space-complexity/)
