# Dynamic Programming 💡

> **Master dynamic programming for optimal problem solving**

## 🎯 Learning Objectives

- Understand DP fundamentals
- Master memoization and tabulation
- Learn common DP patterns
- Apply DP to solve problems

## 📚 Theory

### Dynamic Programming Basics

#### Properties
- **Overlapping subproblems**: Same subproblems appear multiple times
- **Optimal substructure**: Optimal solution contains optimal solutions to subproblems
- **Memoization**: Top-down approach with caching
- **Tabulation**: Bottom-up approach with table
- **State definition**: Define what each state represents

#### Common Patterns
- **1D DP**: Single dimension problems
- **2D DP**: Two dimension problems
- **Interval DP**: Problems on intervals
- **Tree DP**: Problems on trees
- **Bitmask DP**: Problems with subsets

### When to Use Dynamic Programming

#### Optimization Problems
- **Maximum/Minimum**: Find optimal value
- **Count**: Count number of ways
- **Decision**: Make optimal decisions
- **Path**: Find optimal path
- **Sequence**: Find optimal sequence

#### Common DP Problems
- **Fibonacci**: Classic DP example
- **Longest Common Subsequence**: String problems
- **Knapsack**: Optimization problems
- **Coin Change**: Counting problems
- **Edit Distance**: String transformation

## 🔧 Implementation

### Basic DP Template

```java
// Memoization (Top-down)
public int dp(int[] memo, int n) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    
    memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
    return memo[n];
}

// Tabulation (Bottom-up)
public int dp(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

### Advanced DP Patterns

```java
// 2D DP - Longest Common Subsequence
public int lcs(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[m][n];
}
```

## 📝 Practice Problems

### Easy
1. **Climbing Stairs** - O(n) time, O(1) space
2. **House Robber** - O(n) time, O(1) space
3. **Min Cost Climbing Stairs** - O(n) time, O(1) space
4. **Fibonacci Number** - O(n) time, O(1) space
5. **N-th Tribonacci Number** - O(n) time, O(1) space

### Medium
1. **Longest Increasing Subsequence** - O(n²) time, O(n) space
2. **Coin Change** - O(amount * coins) time, O(amount) space
3. **Word Break** - O(n²) time, O(n) space
4. **Unique Paths** - O(mn) time, O(mn) space
5. **Longest Common Subsequence** - O(mn) time, O(mn) space

### Hard
1. **Edit Distance** - O(mn) time, O(mn) space
2. **Regular Expression Matching** - O(mn) time, O(mn) space
3. **Longest Valid Parentheses** - O(n) time, O(n) space
4. **Minimum Insertions to Make Palindrome** - O(n²) time, O(n²) space
5. **Maximum Profit in Job Scheduling** - O(n log n) time, O(n) space

## 💡 Key Insights

- **State definition**: Clearly define what each state represents
- **Transition**: Define how to move from one state to another
- **Base cases**: Define initial states
- **Optimization**: Use space optimization when possible
- **Pattern recognition**: Identify common DP patterns

## 🎯 Interview Tips

- Start with recursive solution
- Identify overlapping subproblems
- Add memoization or tabulation
- Consider space optimization
- Think about state representation

## 📚 Additional Resources

- [Dynamic Programming](https://www.geeksforgeeks.org/dynamic-programming/)
- [Memoization](https://www.geeksforgeeks.org/memoization-1d-2d-and-3d/)
- [Tabulation](https://www.geeksforgeeks.org/tabulation-vs-memoization/)
- [DP Patterns](https://www.geeksforgeeks.org/dynamic-programming-patterns/)
