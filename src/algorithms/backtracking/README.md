# Backtracking Algorithms 🔄

> **Master backtracking algorithms for constraint satisfaction problems**

## 🎯 Learning Objectives

- Understand backtracking fundamentals
- Master constraint satisfaction problems
- Learn pruning techniques
- Apply backtracking to solve problems

## 📚 Theory

### Backtracking Basics

#### Properties
- **Systematic search**: Explore all possible solutions
- **Constraint satisfaction**: Find solutions that satisfy constraints
- **Pruning**: Eliminate invalid paths early
- **Recursive**: Natural recursive structure
- **Exponential**: Can be exponential in worst case

#### Common Patterns
- **Generate all permutations**: All arrangements
- **Generate all combinations**: All selections
- **Generate all subsets**: All possible subsets
- **N-Queens problem**: Place queens on chessboard
- **Sudoku solver**: Fill sudoku grid
- **Word search**: Find words in 2D grid

### When to Use Backtracking

#### Constraint Satisfaction
- **N-Queens**: Place queens without attacking
- **Sudoku**: Fill grid with constraints
- **Word search**: Find words in grid
- **Maze solving**: Find path through maze

#### Generation Problems
- **Permutations**: All arrangements
- **Combinations**: All selections
- **Subsets**: All possible subsets
- **Parentheses**: All valid parentheses

## 🔧 Implementation

### Basic Backtracking Template

```java
public void backtrack(parameters) {
    if (base_case) {
        // Process solution
        return;
    }
    
    for (choice in choices) {
        if (is_valid(choice)) {
            make_choice(choice);
            backtrack(updated_parameters);
            undo_choice(choice);
        }
    }
}
```

### Advanced Backtracking Patterns

```java
// Generate all permutations
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    permuteHelper(nums, current, used, result);
    return result;
}

private void permuteHelper(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
    if (current.size() == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    for (int i = 0; i < nums.length; i++) {
        if (!used[i]) {
            used[i] = true;
            current.add(nums[i]);
            permuteHelper(nums, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
```

## 📝 Practice Problems

### Easy
1. **Generate Parentheses** - O(4^n/√n) time, O(n) space
2. **Letter Combinations** - O(4^n) time, O(n) space
3. **Subsets** - O(2^n) time, O(n) space
4. **Combinations** - O(C(n,k)) time, O(k) space
5. **Permutations** - O(n!) time, O(n) space

### Medium
1. **N-Queens** - O(n!) time, O(n) space
2. **Word Search** - O(mn * 4^L) time, O(L) space
3. **Combination Sum** - O(2^n) time, O(n) space
4. **Sudoku Solver** - O(9^(n²)) time, O(n²) space
5. **Palindrome Partitioning** - O(2^n) time, O(n) space

### Hard
1. **N-Queens II** - O(n!) time, O(n) space
2. **Word Search II** - O(mn * 4^L) time, O(L) space
3. **Remove Invalid Parentheses** - O(2^n) time, O(n) space
4. **Expression Add Operators** - O(4^n) time, O(n) space
5. **Word Pattern II** - O(n!) time, O(n) space

## 💡 Key Insights

- **Base case**: Define when to stop recursion
- **Choices**: Define what choices to make at each step
- **Constraints**: Define what makes a choice valid
- **Pruning**: Eliminate invalid paths early
- **Undo**: Always undo choices when backtracking

## ⚠️ Common Mistakes

### Not Undoing Choices
- **Problem**: Not undoing choices when backtracking
- **Solution**: Always undo changes when backtracking
- **Example**: `path.remove(path.size() - 1);` after recursive call

### Missing Pruning
- **Problem**: Not pruning invalid paths early
- **Solution**: Check constraints before recursive call
- **Example**: `if (isValid(path, next)) { backtrack(path, next); }`

### Not Resetting State
- **Problem**: Not resetting state between recursive calls
- **Solution**: Ensure state is properly reset after backtracking
- **Example**: Mark visited as false after recursive call

### Incorrect Base Case
- **Problem**: Wrong base case condition
- **Solution**: Clearly define when solution is complete
- **Example**: `if (path.size() == n) { result.add(new ArrayList<>(path)); return; }`

### Wrong Choice Order
- **Problem**: Making choices in wrong order
- **Solution**: Consider order of choices for efficiency
- **Example**: Make choices in sorted order to avoid duplicates

### Not Copying State
- **Problem**: Modifying shared state instead of copying
- **Solution**: Create copy of state when adding to result
- **Example**: `result.add(new ArrayList<>(path));` not `result.add(path);`

### Missing Constraints
- **Problem**: Not checking all constraints
- **Solution**: Check all constraints before making choice
- **Example**: Check row, column, and diagonal for N-Queens

## 🎯 Interview Tips

- Always define base case first
- Consider pruning to improve efficiency
- Think about constraint propagation
- Use appropriate data structures
- Consider memoization for optimization

## 📚 Additional Resources

- [Backtracking Algorithms](https://www.geeksforgeeks.org/backtracking-algorithms/)
- [N-Queens Problem](https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/)
- [Sudoku Solver](https://www.geeksforgeeks.org/sudoku-backtracking-7/)
- [Word Search](https://www.geeksforgeeks.org/word-search-2d-grid/)
