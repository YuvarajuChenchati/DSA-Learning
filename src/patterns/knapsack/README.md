# Knapsack Pattern 🎒

> **Master knapsack problems for optimization and resource allocation**

## 🎯 Learning Objectives

- Understand knapsack problem fundamentals
- Master different knapsack variants
- Learn when to use knapsack patterns
- Apply knapsack to solve problems

## 📚 Theory

### Knapsack Problem Basics

#### Properties
- **Optimization problem**: Find maximum value within constraints
- **Resource allocation**: Limited capacity/resources
- **Decision making**: Choose items to include/exclude
- **Dynamic programming**: Optimal substructure
- **Multiple variants**: 0/1, unbounded, fractional

#### Common Variants
- **0/1 Knapsack**: Each item can be used at most once
- **Unbounded Knapsack**: Each item can be used multiple times
- **Fractional Knapsack**: Items can be divided (greedy solution)
- **Multiple Knapsack**: Multiple knapsacks available
- **Group Knapsack**: Items belong to groups

### When to Use Knapsack Pattern

#### Optimization Problems
- **Resource allocation**: Limited resources, maximize value
- **Budget constraints**: Limited budget, maximize benefit
- **Capacity problems**: Limited capacity, maximize utility
- **Selection problems**: Choose optimal subset
- **Investment problems**: Portfolio optimization

#### Common Applications
- **0/1 Knapsack**: Items with weights and values
- **Unbounded Knapsack**: Unlimited supply of items
- **Fractional Knapsack**: Items can be divided
- **Coin Change**: Minimum coins needed
- **Subset Sum**: Check if subset exists with given sum

## 🔧 Implementation

### Basic Knapsack Template

```java
// 0/1 Knapsack
public int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= capacity; w++) {
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(dp[i - 1][w], 
                    dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }
    return dp[n][capacity];
}
```

### Advanced Knapsack Patterns

```java
// Unbounded Knapsack
public int unboundedKnapsack(int[] weights, int[] values, int capacity) {
    int[] dp = new int[capacity + 1];
    
    for (int w = 1; w <= capacity; w++) {
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] <= w) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
    }
    return dp[capacity];
}
```

## 📝 Practice Problems

### Easy
1. **Coin Change** - O(amount * coins) time, O(amount) space
2. **Coin Change II** - O(amount * coins) time, O(amount) space
3. **Partition Equal Subset Sum** - O(n * sum) time, O(sum) space
4. **Target Sum** - O(n * sum) time, O(sum) space
5. **Last Stone Weight II** - O(n * sum) time, O(sum) space

### Medium
1. **0/1 Knapsack** - O(n * capacity) time, O(capacity) space
2. **Unbounded Knapsack** - O(n * capacity) time, O(capacity) space
3. **Partition to K Equal Sum Subsets** - O(n * 2^n) time, O(2^n) space
4. **Word Break** - O(n²) time, O(n) space
5. **Combination Sum IV** - O(target * n) time, O(target) space

### Hard
1. **Minimum Cost to Cut a Stick** - O(n³) time, O(n²) space
2. **Maximum Profit in Job Scheduling** - O(n log n) time, O(n) space
3. **Maximum Sum of Non-Overlapping Subarrays** - O(n) time, O(1) space
4. **Maximum Points You Can Obtain from Cards** - O(k) time, O(1) space
5. **Maximum Score from Performing Multiplication Operations** - O(m²) time, O(m²) space

## 💡 Key Insights

- **0/1 Knapsack**: Each item used at most once
- **Unbounded Knapsack**: Each item can be used multiple times
- **Fractional Knapsack**: Greedy approach works
- **Space optimization**: Use 1D array for unbounded knapsack
- **Decision making**: Include or exclude each item

## 🎯 Interview Tips

- Identify if it's 0/1 or unbounded knapsack
- Consider space optimization
- Think about base cases
- Use appropriate data structures
- Consider edge cases (empty arrays, zero capacity)

## 📚 Additional Resources

- [Knapsack Problem](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
- [Unbounded Knapsack](https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/)
- [Fractional Knapsack](https://www.geeksforgeeks.org/fractional-knapsack-problem/)
- [Coin Change](https://www.geeksforgeeks.org/coin-change-dp-7/)
