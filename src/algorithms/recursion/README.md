# Recursion 🔄

> **Master recursive thinking and recursive algorithms**

## 🎯 Learning Objectives

- Understand recursion fundamentals
- Master recursive problem solving
- Learn recursive patterns
- Apply recursion to solve problems

## 📚 Theory

### Recursion Basics

#### Properties
- **Base Case**: Stopping condition
- **Recursive Case**: Function calls itself
- **Stack**: Uses call stack for state
- **Memory**: Each call uses stack space
- **Backtracking**: Return to previous state

#### Common Patterns
- **Divide and Conquer**: Split problem into subproblems
- **Backtracking**: Try all possibilities
- **Tree Traversal**: Visit nodes recursively
- **Dynamic Programming**: Memoize recursive calls
- **Tail Recursion**: Optimize recursive calls

### Recursion Types

#### Direct Recursion
- Function calls itself directly
- Most common type
- Easy to understand

#### Indirect Recursion
- Function A calls function B, B calls A
- Less common
- More complex to trace

#### Tail Recursion
- Recursive call is last operation
- Can be optimized to iteration
- Saves stack space

## 🔧 Implementation

### Basic Recursion Patterns

```java
// Factorial
public static int factorial(int n) {
    if (n <= 1) return 1; // Base case
    return n * factorial(n - 1); // Recursive case
}

// Fibonacci
public static int fibonacci(int n) {
    if (n <= 1) return n; // Base case
    return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
}

// Power
public static int power(int base, int exp) {
    if (exp == 0) return 1; // Base case
    return base * power(base, exp - 1); // Recursive case
}
```

### Advanced Recursion Patterns

```java
// Tower of Hanoi
public static void towerOfHanoi(int n, char from, char to, char aux) {
    if (n == 1) {
        System.out.println("Move disk 1 from " + from + " to " + to);
        return;
    }
    
    towerOfHanoi(n - 1, from, aux, to);
    System.out.println("Move disk " + n + " from " + from + " to " + to);
    towerOfHanoi(n - 1, aux, to, from);
}

// Binary Search
public static int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1; // Base case
    
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid; // Base case
    
    if (arr[mid] > target) {
        return binarySearch(arr, target, left, mid - 1); // Recursive case
    } else {
        return binarySearch(arr, target, mid + 1, right); // Recursive case
    }
}
```

## 📝 Practice Problems

### Easy
1. **Climbing Stairs** - O(2^n) time, O(n) space
2. **Fibonacci Number** - O(2^n) time, O(n) space
3. **Power of Two** - O(log n) time, O(log n) space
4. **Reverse String** - O(n) time, O(n) space
5. **Binary Tree Inorder Traversal** - O(n) time, O(h) space

### Medium
1. **Generate Parentheses** - O(4^n/√n) time, O(4^n/√n) space
2. **Combination Sum** - O(2^n) time, O(target) space
3. **Permutations** - O(n!) time, O(n!) space
4. **Subsets** - O(2^n) time, O(2^n) space
5. **Word Search** - O(mn * 4^L) time, O(L) space

### Hard
1. **N-Queens** - O(n!) time, O(n²) space
2. **Sudoku Solver** - O(9^(n²)) time, O(n²) space
3. **Word Ladder II** - O(M²N) time, O(MN) space
4. **Regular Expression Matching** - O(mn) time, O(mn) space
5. **Wildcard Matching** - O(mn) time, O(mn) space

## 💡 Key Insights

- **Base case**: Always define stopping condition
- **Recursive case**: Make problem smaller
- **Stack overflow**: Consider depth of recursion
- **Memoization**: Cache results to avoid recomputation
- **Tail recursion**: Optimize for space efficiency

## 🎯 Interview Tips

- Always identify base case first
- Make sure recursive case reduces problem size
- Consider space complexity of recursion
- Think about memoization for optimization
- Consider iterative solutions for space efficiency

## 📚 Additional Resources

- [Recursion in Java](https://www.geeksforgeeks.org/recursion-in-java/)
- [Recursive Algorithms](https://www.geeksforgeeks.org/recursive-algorithms/)
- [Backtracking](https://www.geeksforgeeks.org/backtracking-algorithms/)
- [Dynamic Programming](https://www.geeksforgeeks.org/dynamic-programming/)
