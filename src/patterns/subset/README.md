# Subset Pattern 📋

> **Master subset generation for combination and permutation problems**

## 🎯 Learning Objectives

- Understand subset generation fundamentals
- Master different subset patterns
- Learn when to use subset patterns
- Apply subset patterns to solve problems

## 📚 Theory

### Subset Pattern Basics

#### Properties
- **Exponential complexity**: O(2^n) time complexity
- **Backtracking**: Natural recursive approach
- **Bit manipulation**: Alternative approach using bits
- **Iterative**: Build subsets incrementally
- **Pruning**: Optimize by eliminating invalid paths

#### Common Patterns
- **Subsets**: All possible subsets
- **Combinations**: Subsets of specific size
- **Permutations**: All arrangements
- **Letter combinations**: Phone number combinations
- **Parentheses**: Valid parentheses combinations

### When to Use Subset Pattern

#### Generation Problems
- **Subset generation**: All possible subsets
- **Combination generation**: All combinations of size k
- **Permutation generation**: All arrangements
- **String combinations**: Letter combinations
- **Parentheses generation**: Valid parentheses

#### Common Applications
- **Subsets**: Power set generation
- **Combinations**: Choose k elements from n
- **Permutations**: Arrange n elements
- **Letter combinations**: Phone number dialing
- **Parentheses**: Generate valid parentheses

## 🔧 Implementation

### Basic Subset Template

```java
// Generate all subsets
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

### Advanced Subset Patterns

```java
// Generate combinations of size k
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(1, n, k, new ArrayList<>(), result);
    return result;
}

private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == k) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    for (int i = start; i <= n; i++) {
        current.add(i);
        backtrack(i + 1, n, k, current, result);
        current.remove(current.size() - 1);
    }
}
```

## 📝 Practice Problems

### Easy
1. **Subsets** - O(2^n) time, O(2^n) space
2. **Subsets II** - O(2^n) time, O(2^n) space
3. **Combinations** - O(C(n,k)) time, O(C(n,k)) space
4. **Letter Combinations** - O(4^n) time, O(4^n) space
5. **Generate Parentheses** - O(4^n/√n) time, O(4^n/√n) space

### Medium
1. **Permutations** - O(n!) time, O(n!) space
2. **Permutations II** - O(n!) time, O(n!) space
3. **Combination Sum** - O(2^n) time, O(2^n) space
4. **Combination Sum II** - O(2^n) time, O(2^n) space
5. **Palindrome Partitioning** - O(2^n) time, O(2^n) space

### Hard
1. **N-Queens** - O(n!) time, O(n!) space
2. **N-Queens II** - O(n!) time, O(n!) space
3. **Word Search II** - O(mn * 4^L) time, O(L) space
4. **Expression Add Operators** - O(4^n) time, O(4^n) space
5. **Word Pattern II** - O(n!) time, O(n!) space

## 💡 Key Insights

- **Backtracking**: Natural recursive approach
- **Bit manipulation**: Alternative for small sets
- **Pruning**: Eliminate invalid paths early
- **Base case**: Define when to stop recursion
- **State management**: Track current state

## ⚠️ Common Mistakes

### Not Undoing Choices
- **Problem**: Not removing element after backtracking
- **Solution**: Always remove element after recursive call
- **Example**: `path.remove(path.size() - 1);` after backtracking

### Not Copying State
- **Problem**: Modifying shared state instead of copying
- **Solution**: Create copy of state when adding to result
- **Example**: `result.add(new ArrayList<>(path));` not `result.add(path);`

### Wrong Base Case
- **Problem**: Wrong base case condition
- **Solution**: Define when subset is complete
- **Example**: `if (index == nums.length) { result.add(new ArrayList<>(path)); return; }`

### Duplicate Subsets
- **Problem**: Generating duplicate subsets
- **Solution**: Sort array first and skip duplicates
- **Example**: `if (i > start && nums[i] == nums[i - 1]) continue;` to skip duplicates

### Not Handling Empty Set
- **Problem**: Not including empty set in result
- **Solution**: Add empty set explicitly or include in backtracking
- **Example**: `result.add(new ArrayList<>());` for empty set

### Wrong Index Tracking
- **Problem**: Not tracking current index correctly
- **Solution**: Pass current index to recursive function
- **Example**: `backtrack(nums, i + 1, path, result);` not `backtrack(nums, index, path, result);`

### Not Sorting First
- **Problem**: Not sorting array before generating subsets
- **Solution**: Sort array to handle duplicates
- **Example**: `Arrays.sort(nums);` before generating subsets

## 🎯 Interview Tips

- Always define base case first
- Consider pruning to improve efficiency
- Think about state representation
- Use appropriate data structures
- Consider iterative vs recursive approaches

## 📚 Additional Resources

- [Subset Generation](https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/)
- [Combination Generation](https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/)
- [Permutation Generation](https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/)
- [Backtracking](https://www.geeksforgeeks.org/backtracking-algorithms/)
