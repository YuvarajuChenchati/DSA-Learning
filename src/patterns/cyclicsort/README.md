# Cyclic Sort Pattern 🔄

> **Master cyclic sort for array problems with numbers in specific ranges**

## 🎯 Learning Objectives

- Understand cyclic sort fundamentals
- Master in-place sorting technique
- Learn when to use cyclic sort
- Apply cyclic sort to solve problems

## 📚 Theory

### Cyclic Sort Basics

#### Properties
- **In-place sorting**: O(1) extra space
- **Range-based**: Works with numbers in range [1, n]
- **Efficient**: O(n) time complexity
- **Simple**: Easy to understand and implement
- **Useful**: For finding missing/duplicate numbers

#### Common Patterns
- **Missing numbers**: Find missing numbers in range
- **Duplicate numbers**: Find duplicate numbers
- **First missing positive**: Find smallest missing positive
- **Set mismatch**: Find duplicate and missing number
- **Array sorting**: Sort array with numbers in range

### When to Use Cyclic Sort

#### Array Problems
- **Numbers in range [1, n]**: Perfect for cyclic sort
- **Missing numbers**: Find missing elements
- **Duplicate numbers**: Find duplicate elements
- **In-place sorting**: When space is limited
- **Range queries**: Problems involving ranges

#### Common Applications
- **Find missing number**: In sequence 1 to n
- **Find duplicate number**: In sequence 1 to n
- **First missing positive**: Smallest missing positive integer
- **Set mismatch**: Find duplicate and missing
- **Sort array**: Sort numbers in range [1, n]

## 🔧 Implementation

### Basic Cyclic Sort Template

```java
public void cyclicSort(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correctIndex = nums[i] - 1;
        if (nums[i] != nums[correctIndex]) {
            swap(nums, i, correctIndex);
        } else {
            i++;
        }
    }
}
```

### Advanced Cyclic Sort Patterns

```java
// Find missing number
public int findMissingNumber(int[] nums) {
    cyclicSort(nums);
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }
    return nums.length + 1;
}

// Find duplicate number
public int findDuplicate(int[] nums) {
    cyclicSort(nums);
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return nums[i];
        }
    }
    return -1;
}
```

## 📝 Practice Problems

### Easy
1. **Missing Number** - O(n) time, O(1) space
2. **Find All Numbers Disappeared** - O(n) time, O(1) space
3. **Set Mismatch** - O(n) time, O(1) space
4. **Find the Duplicate Number** - O(n) time, O(1) space
5. **First Missing Positive** - O(n) time, O(1) space

### Medium
1. **Find All Duplicates** - O(n) time, O(1) space
2. **Find the Duplicate Number** - O(n) time, O(1) space
3. **Set Mismatch** - O(n) time, O(1) space
4. **Find All Numbers Disappeared** - O(n) time, O(1) space
5. **First Missing Positive** - O(n) time, O(1) space

### Hard
1. **First Missing Positive** - O(n) time, O(1) space
2. **Find the Duplicate Number** - O(n) time, O(1) space
3. **Set Mismatch** - O(n) time, O(1) space
4. **Find All Duplicates** - O(n) time, O(1) space
5. **Find All Numbers Disappeared** - O(n) time, O(1) space

## 💡 Key Insights

- **Range requirement**: Numbers must be in range [1, n]
- **In-place sorting**: O(1) extra space
- **Efficient**: O(n) time complexity
- **Simple logic**: Easy to understand and implement
- **Useful for**: Finding missing/duplicate numbers

## 🎯 Interview Tips

- Always check if numbers are in range [1, n]
- Use cyclic sort for in-place sorting
- Consider edge cases (empty array, single element)
- Think about space optimization
- Use for finding missing/duplicate numbers

## 📚 Additional Resources

- [Cyclic Sort](https://www.geeksforgeeks.org/cyclic-sort/)
- [Missing Number](https://www.geeksforgeeks.org/find-the-missing-number/)
- [Duplicate Number](https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/)
- [First Missing Positive](https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/)
