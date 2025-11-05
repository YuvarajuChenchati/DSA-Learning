# Dynamic Programming Problems 💡

> **Comprehensive collection of DP problems organized by difficulty**

## 🎯 Problem Categories

### Easy Problems (10+)

1. **Climbing Stairs** (LeetCode #70) - ⭐⭐⭐ Very Common
   - Number of ways to climb stairs
   - Time: O(n), Space: O(1)
   - Hint: Fibonacci pattern

2. **House Robber** (LeetCode #198) - ⭐⭐⭐ Very Common
   - Maximum money that can be robbed
   - Time: O(n), Space: O(1)
   - Hint: DP with two states

3. **Best Time to Buy and Sell Stock** (LeetCode #121) - ⭐⭐⭐ Very Common
   - Maximum profit from stock trading
   - Time: O(n), Space: O(1)
   - Hint: Track minimum price

4. **Fibonacci Number** (LeetCode #509) - ⭐ Common
   - Calculate nth Fibonacci number
   - Time: O(n), Space: O(1)
   - Hint: DP with memoization

5. **Pascal's Triangle** (LeetCode #118) - ⭐ Common
   - Generate Pascal's triangle
   - Time: O(n²), Space: O(n²)
   - Hint: Use previous row

6. **Min Cost Climbing Stairs** (LeetCode #746) - ⭐ Common
   - Minimum cost to climb stairs
   - Time: O(n), Space: O(1)
   - Hint: DP with cost consideration

7. **Maximum Subarray** (LeetCode #53) - ⭐⭐ Common
   - Find contiguous subarray with maximum sum
   - Time: O(n), Space: O(1)
   - Hint: Kadane's algorithm

8. **Counting Bits** (LeetCode #338) - ⭐ Common
   - Count 1 bits for each number
   - Time: O(n), Space: O(n)
   - Hint: Use previous results

9. **Divisor Game** (LeetCode #1025) - ⭐ Common
   - Determine if Alice can win divisor game
   - Time: O(n), Space: O(n)
   - Hint: DP with game theory

10. **N-th Tribonacci Number** (LeetCode #1137) - ⭐ Common
    - Calculate nth Tribonacci number
    - Time: O(n), Space: O(1)
    - Hint: DP with three states

### Medium Problems (20+)

1. **Longest Increasing Subsequence** (LeetCode #300) - ⭐⭐ Common
   - Length of longest increasing subsequence
   - Time: O(n log n), Space: O(n)
   - Hint: DP or binary search

2. **Coin Change** (LeetCode #322) - ⭐⭐⭐ Very Common
   - Minimum number of coins needed
   - Time: O(amount * coins), Space: O(amount)
   - Hint: DP with optimization

3. **Word Break** (LeetCode #139) - ⭐⭐⭐ Very Common
   - Check if string can be segmented
   - Time: O(n²), Space: O(n)
   - Hint: DP with substring check

4. **Unique Paths** (LeetCode #62) - ⭐⭐ Common
   - Number of unique paths
   - Time: O(mn), Space: O(n)
   - Hint: DP grid

5. **Longest Palindromic Substring** (LeetCode #5) - ⭐⭐ Common
   - Find longest palindromic substring
   - Time: O(n²), Space: O(1)
   - Hint: Expand around centers

6. **Partition Equal Subset Sum** (LeetCode #416) - ⭐⭐ Common
   - Check if can partition into equal sum
   - Time: O(n * sum), Space: O(sum)
   - Hint: 0/1 knapsack variant

7. **Decode Ways** (LeetCode #91) - ⭐⭐ Common
   - Number of ways to decode string
   - Time: O(n), Space: O(1)
   - Hint: DP with two states

8. **Edit Distance** (LeetCode #72) - ⭐⭐ Common
   - Minimum operations to convert string
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

9. **Maximum Product Subarray** (LeetCode #152) - ⭐⭐ Common
   - Maximum product of subarray
   - Time: O(n), Space: O(1)
   - Hint: Track min and max

10. **Best Time to Buy and Sell Stock with Cooldown** (LeetCode #309) - ⭐ Common
    - Maximum profit with cooldown
    - Time: O(n), Space: O(1)
    - Hint: State machine DP

11. **Longest Common Subsequence** (LeetCode #1143) - ⭐⭐ Common
    - Length of longest common subsequence
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D DP

12. **Target Sum** (LeetCode #494) - ⭐ Common
    - Number of ways to reach target sum
    - Time: O(n * sum), Space: O(sum)
    - Hint: DP or memoization

13. **Perfect Squares** (LeetCode #279) - ⭐ Common
    - Minimum number of perfect squares
    - Time: O(n * √n), Space: O(n)
    - Hint: DP with optimization

14. **Coin Change 2** (LeetCode #518) - ⭐ Common
    - Number of ways to make change
    - Time: O(amount * coins), Space: O(amount)
    - Hint: DP with order consideration

15. **Combination Sum IV** (LeetCode #377) - ⭐ Common
    - Number of combinations that sum to target
    - Time: O(target * n), Space: O(target)
    - Hint: DP with order

16. **House Robber II** (LeetCode #213) - ⭐ Common
    - Maximum money with circular houses
    - Time: O(n), Space: O(1)
    - Hint: Two DP passes

17. **Delete and Earn** (LeetCode #740) - ⭐ Common
    - Maximum points from deleting numbers
    - Time: O(n + max), Space: O(max)
    - Hint: Similar to House Robber

18. **Longest Arithmetic Subsequence** (LeetCode #1027) - ⭐ Common
    - Length of longest arithmetic subsequence
    - Time: O(n²), Space: O(n²)
    - Hint: 2D DP with difference

19. **Minimum Falling Path Sum** (LeetCode #931) - ⭐ Common
    - Minimum sum of falling path
    - Time: O(n²), Space: O(n)
    - Hint: 2D DP

20. **Unique Paths II** (LeetCode #63) - ⭐ Common
    - Unique paths with obstacles
    - Time: O(mn), Space: O(n)
    - Hint: DP grid with obstacle check

### Hard Problems (15+)

1. **Edit Distance** (LeetCode #72) - ⭐⭐⭐ Very Common
   - Minimum operations to convert string
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

2. **Regular Expression Matching** (LeetCode #10) - ⭐⭐⭐ Very Common
   - Match string with pattern
   - Time: O(mn), Space: O(mn)
   - Hint: 2D DP with state machine

3. **Wildcard Matching** (LeetCode #44) - ⭐⭐ Common
   - Match string with wildcard pattern
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

4. **Longest Valid Parentheses** (LeetCode #32) - ⭐⭐ Common
   - Length of longest valid parentheses
   - Time: O(n), Space: O(n)
   - Hint: Stack or DP

5. **Minimum Insertions to Make Palindrome** (LeetCode #1312) - ⭐ Common
   - Minimum insertions for palindrome
   - Time: O(n²), Space: O(n²)
   - Hint: LCS variant

6. **Burst Balloons** (LeetCode #312) - ⭐ Common
   - Maximum coins from bursting balloons
   - Time: O(n³), Space: O(n²)
   - Hint: Interval DP

7. **Palindrome Partitioning II** (LeetCode #132) - ⭐ Common
   - Minimum cuts for palindrome partitioning
   - Time: O(n²), Space: O(n²)
   - Hint: DP + palindrome check

8. **Scramble String** (LeetCode #87) - ⭐ Common
   - Check if strings are scrambled
   - Time: O(n⁴), Space: O(n³)
   - Hint: 3D DP

9. **Interleaving String** (LeetCode #97) - ⭐ Common
   - Check if string is interleaving
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

10. **Distinct Subsequences** (LeetCode #115) - ⭐ Common
    - Count distinct subsequences
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D DP

11. **Longest Increasing Path in a Matrix** (LeetCode #329) - ⭐ Common
    - Find longest increasing path
    - Time: O(mn), Space: O(mn)
    - Hint: DFS + memoization

12. **Maximum Profit in Job Scheduling** (LeetCode #1235) - ⭐ Common
    - Maximum profit from jobs
    - Time: O(n log n), Space: O(n)
    - Hint: DP + binary search

13. **Maximum Score from Performing Multiplication Operations** (LeetCode #1770) - ⭐ Common
    - Maximum score from multiplications
    - Time: O(m²), Space: O(m²)
    - Hint: 2D DP

14. **Count Different Palindromic Subsequences** (LeetCode #730) - ⭐ Common
    - Count different palindromic subsequences
    - Time: O(n²), Space: O(n²)
    - Hint: Interval DP

15. **Minimum Cost to Merge Stones** (LeetCode #1000) - ⭐ Common
    - Minimum cost to merge stones
    - Time: O(n³), Space: O(n²)
    - Hint: Interval DP

## 💡 DP Patterns

### 1D DP Problems
- **Linear DP**: Fibonacci, climbing stairs, house robber
- **State Machine**: Stock problems with states
- **Range DP**: Palindrome problems

### 2D DP Problems
- **Grid DP**: Unique paths, minimum path sum
- **String DP**: Edit distance, LCS, interleaving
- **Interval DP**: Burst balloons, merge stones

### Advanced DP Patterns
- **Bitmask DP**: Subset problems with state
- **Tree DP**: Tree-based problems
- **Probability DP**: Probability-based problems

## 🎯 Practice Recommendations

### For Beginners
- Start with Easy problems (Climbing Stairs, House Robber)
- Focus on 1D DP patterns
- Practice with 2-3 problems per day
- Time yourself (15-20 minutes per problem)

### For Intermediate
- Practice Medium problems (Coin Change, Word Break)
- Focus on 2D DP patterns
- Practice with 3-5 problems per day
- Time yourself (30-45 minutes per problem)

### For Advanced
- Practice Hard problems (Edit Distance, Regular Expression Matching)
- Focus on complex DP patterns
- Practice with 2-3 problems per day
- Time yourself (45-60 minutes per problem)

## 📚 Additional Resources

- [LeetCode DP Problems](https://leetcode.com/tag/dynamic-programming/)
- [GeeksforGeeks Dynamic Programming](https://www.geeksforgeeks.org/dynamic-programming/)
- [DP Patterns Guide](../patterns/knapsack/README.md)

---

**Remember**: Practice consistently, understand DP patterns, and master state transitions. Good luck! 🚀
