# Array Problems 📊

> **Comprehensive collection of array problems organized by difficulty**

## 🎯 Problem Categories

### Easy Problems (15+)

1. **Two Sum** (LeetCode #1) - ⭐ Very Common
   - Find two numbers that sum to target
   - Time: O(n), Space: O(n)
   - Hint: Use HashMap to store complements

2. **Remove Duplicates from Sorted Array** (LeetCode #26) - ⭐ Common
   - Remove duplicates in-place
   - Time: O(n), Space: O(1)
   - Hint: Two pointers technique

3. **Rotate Array** (LeetCode #189) - ⭐ Common
   - Rotate array to the right by k steps
   - Time: O(n), Space: O(1)
   - Hint: Reverse array in parts

4. **Contains Duplicate** (LeetCode #217) - ⭐ Very Common
   - Check if array contains duplicates
   - Time: O(n), Space: O(n)
   - Hint: Use HashSet

5. **Single Number** (LeetCode #136) - ⭐ Common
   - Find single number in array
   - Time: O(n), Space: O(1)
   - Hint: XOR operation

6. **Best Time to Buy and Sell Stock** (LeetCode #121) - ⭐ Very Common
   - Maximum profit from stock trading
   - Time: O(n), Space: O(1)
   - Hint: Track minimum price

7. **Plus One** (LeetCode #66) - ⭐ Common
   - Add one to number represented as array
   - Time: O(n), Space: O(1)
   - Hint: Handle carry-over

8. **Move Zeroes** (LeetCode #283) - ⭐ Common
   - Move all zeros to end
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

9. **Remove Element** (LeetCode #27) - ⭐ Common
   - Remove all instances of value
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

10. **Intersection of Two Arrays** (LeetCode #349) - ⭐ Common
    - Find intersection of two arrays
    - Time: O(n+m), Space: O(n)
    - Hint: Use HashSet

11. **Valid Anagram** (LeetCode #242) - ⭐ Common
    - Check if strings are anagrams
    - Time: O(n), Space: O(1)
    - Hint: Count characters

12. **Missing Number** (LeetCode #268) - ⭐ Common
    - Find missing number in range [0, n]
    - Time: O(n), Space: O(1)
    - Hint: XOR or sum formula

13. **First Missing Positive** (LeetCode #41) - ⭐ Common
    - Find first missing positive integer
    - Time: O(n), Space: O(1)
    - Hint: Use array indices

14. **Majority Element** (LeetCode #169) - ⭐ Common
    - Find element appearing more than n/2 times
    - Time: O(n), Space: O(1)
    - Hint: Boyer-Moore voting algorithm

15. **Squares of Sorted Array** (LeetCode #977) - ⭐ Common
    - Return squares in sorted order
    - Time: O(n), Space: O(n)
    - Hint: Two pointers from ends

### Medium Problems (15+)

1. **Three Sum** (LeetCode #15) - ⭐⭐⭐ Very Common
   - Find all unique triplets that sum to zero
   - Time: O(n²), Space: O(1)
   - Hint: Sort and use two pointers

2. **Container With Most Water** (LeetCode #11) - ⭐⭐⭐ Very Common
   - Find two lines that form container
   - Time: O(n), Space: O(1)
   - Hint: Two pointers from ends

3. **Product of Array Except Self** (LeetCode #238) - ⭐⭐⭐ Very Common
   - Return array with products
   - Time: O(n), Space: O(1)
   - Hint: Prefix and suffix products

4. **Maximum Subarray** (LeetCode #53) - ⭐⭐⭐ Very Common
   - Find contiguous subarray with maximum sum
   - Time: O(n), Space: O(1)
   - Hint: Kadane's algorithm

5. **Spiral Matrix** (LeetCode #54) - ⭐⭐ Common
   - Return elements in spiral order
   - Time: O(mn), Space: O(1)
   - Hint: Track boundaries

6. **Set Matrix Zeroes** (LeetCode #73) - ⭐⭐ Common
   - Set entire row/column to zero if element is zero
   - Time: O(mn), Space: O(1)
   - Hint: Use first row/column as markers

7. **Longest Consecutive Sequence** (LeetCode #128) - ⭐⭐ Common
   - Find longest consecutive sequence length
   - Time: O(n), Space: O(n)
   - Hint: Use HashSet and check neighbors

8. **Group Anagrams** (LeetCode #49) - ⭐⭐ Common
   - Group strings that are anagrams
   - Time: O(nk), Space: O(nk)
   - Hint: Sort strings or count characters

9. **Top K Frequent Elements** (LeetCode #347) - ⭐⭐ Common
   - Find k most frequent elements
   - Time: O(n log k), Space: O(n)
   - Hint: Use HashMap and PriorityQueue

10. **Find Peak Element** (LeetCode #162) - ⭐⭐ Common
    - Find peak element index
    - Time: O(log n), Space: O(1)
    - Hint: Binary search

11. **Search in Rotated Sorted Array** (LeetCode #33) - ⭐⭐⭐ Very Common
    - Search in rotated sorted array
    - Time: O(log n), Space: O(1)
    - Hint: Modified binary search

12. **Merge Intervals** (LeetCode #56) - ⭐⭐⭐ Very Common
    - Merge overlapping intervals
    - Time: O(n log n), Space: O(n)
    - Hint: Sort and merge

13. **Insert Interval** (LeetCode #57) - ⭐⭐ Common
    - Insert new interval
    - Time: O(n), Space: O(n)
    - Hint: Find insertion point

14. **Rotate Image** (LeetCode #48) - ⭐⭐ Common
    - Rotate 2D matrix 90 degrees clockwise
    - Time: O(n²), Space: O(1)
    - Hint: Transpose and reverse

15. **Jump Game** (LeetCode #55) - ⭐⭐ Common
    - Check if can reach last index
    - Time: O(n), Space: O(1)
    - Hint: Greedy approach

### Hard Problems (10+)

1. **Trapping Rain Water** (LeetCode #42) - ⭐⭐⭐ Very Common
   - Amount of water that can be trapped
   - Time: O(n), Space: O(1)
   - Hint: Two pointers or stack

2. **First Missing Positive** (LeetCode #41) - ⭐⭐ Common
   - First missing positive integer
   - Time: O(n), Space: O(1)
   - Hint: Use array indices

3. **Merge k Sorted Lists** (LeetCode #23) - ⭐⭐ Common
   - Merge k sorted linked lists
   - Time: O(n log k), Space: O(k)
   - Hint: PriorityQueue or divide and conquer

4. **Median of Two Sorted Arrays** (LeetCode #4) - ⭐⭐⭐ Very Common
   - Find median of two sorted arrays
   - Time: O(log(min(m,n))), Space: O(1)
   - Hint: Binary search on partition

5. **Longest Increasing Subsequence** (LeetCode #300) - ⭐⭐ Common
   - Length of longest increasing subsequence
   - Time: O(n log n), Space: O(n)
   - Hint: Dynamic programming or binary search

6. **Word Search II** (LeetCode #212) - ⭐⭐ Common
   - Find all words in 2D board
   - Time: O(mn * 4^L), Space: O(L)
   - Hint: Trie + backtracking

7. **Sliding Window Maximum** (LeetCode #239) - ⭐⭐ Common
   - Maximum in each sliding window
   - Time: O(n), Space: O(k)
   - Hint: Deque or monotonic queue

8. **Count of Smaller Numbers After Self** (LeetCode #315) - ⭐⭐ Common
   - Count smaller numbers after each element
   - Time: O(n log n), Space: O(n)
   - Hint: Merge sort or segment tree

9. **Maximum Profit in Job Scheduling** (LeetCode #1235) - ⭐⭐ Common
   - Maximum profit from jobs
   - Time: O(n log n), Space: O(n)
   - Hint: Dynamic programming + binary search

10. **Reverse Pairs** (LeetCode #493) - ⭐⭐ Common
    - Count reverse pairs
    - Time: O(n log n), Space: O(n)
    - Hint: Merge sort

## 💡 Problem-Solving Strategies

### Pattern Recognition
- **Two Pointers**: Sorted arrays, pairs, palindromes
- **Sliding Window**: Subarray problems, fixed/variable window
- **Prefix Sum**: Range sum queries, cumulative problems
- **Hash Map**: Frequency counting, lookups
- **Sorting**: When order matters, optimization

### Common Approaches
1. **Brute Force First**: Get working solution
2. **Optimize**: Improve time/space complexity
3. **Edge Cases**: Empty arrays, single element, duplicates
4. **Data Structures**: Choose appropriate structures
5. **Pattern Matching**: Identify common patterns

## 🎯 Practice Recommendations

### For Beginners
- Start with Easy problems (Two Sum, Contains Duplicate)
- Focus on understanding patterns
- Practice with 2-3 problems per day
- Time yourself (15-20 minutes per problem)

### For Intermediate
- Practice Medium problems (Three Sum, Container With Most Water)
- Focus on optimization
- Practice with 3-5 problems per day
- Time yourself (30-45 minutes per problem)

### For Advanced
- Practice Hard problems (Trapping Rain Water, Median of Two Sorted Arrays)
- Focus on complex algorithms
- Practice with 2-3 problems per day
- Time yourself (45-60 minutes per problem)

## 📚 Additional Resources

- [LeetCode Array Problems](https://leetcode.com/tag/array/)
- [GeeksforGeeks Array Problems](https://www.geeksforgeeks.org/array-data-structure/)
- [HackerRank Array Problems](https://www.hackerrank.com/domains/data-structures/arrays)

---

**Remember**: Practice consistently, understand patterns, and optimize your solutions. Good luck! 🚀
