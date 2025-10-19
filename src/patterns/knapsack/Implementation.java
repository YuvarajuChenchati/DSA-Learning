package patterns.knapsack;

import java.util.*;

/**
 * Knapsack Pattern Implementation
 * 
 * This class contains essential knapsack algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class KnapsackPattern {
    
    /**
     * 0/1 Knapsack problem
     * 
     * Time Complexity: O(n * capacity)
     * Space Complexity: O(n * capacity)
     * 
     * @param weights Array of weights
     * @param values Array of values
     * @param capacity Knapsack capacity
     * @return Maximum value that can be obtained
     */
    public static int knapsack01(int[] weights, int[] values, int capacity) {
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
    
    /**
     * 0/1 Knapsack with space optimization
     * 
     * Time Complexity: O(n * capacity)
     * Space Complexity: O(capacity)
     * 
     * @param weights Array of weights
     * @param values Array of values
     * @param capacity Knapsack capacity
     * @return Maximum value that can be obtained
     */
    public static int knapsack01Optimized(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity + 1];
        
        for (int i = 0; i < weights.length; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        return dp[capacity];
    }
    
    /**
     * Unbounded Knapsack problem
     * 
     * Time Complexity: O(n * capacity)
     * Space Complexity: O(capacity)
     * 
     * @param weights Array of weights
     * @param values Array of values
     * @param capacity Knapsack capacity
     * @return Maximum value that can be obtained
     */
    public static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
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
    
    /**
     * Fractional Knapsack (Greedy approach)
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param weights Array of weights
     * @param values Array of values
     * @param capacity Knapsack capacity
     * @return Maximum value that can be obtained
     */
    public static double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        double[][] items = new double[n][3];
        
        for (int i = 0; i < n; i++) {
            items[i][0] = weights[i];
            items[i][1] = values[i];
            items[i][2] = values[i] / (double) weights[i]; // value per unit weight
        }
        
        // Sort by value per unit weight in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));
        
        double totalValue = 0;
        int remainingCapacity = capacity;
        
        for (int i = 0; i < n && remainingCapacity > 0; i++) {
            if (items[i][0] <= remainingCapacity) {
                totalValue += items[i][1];
                remainingCapacity -= items[i][0];
            } else {
                totalValue += items[i][1] * (remainingCapacity / items[i][0]);
                remainingCapacity = 0;
            }
        }
        
        return totalValue;
    }
    
    /**
     * Coin Change - Minimum number of coins
     * 
     * Time Complexity: O(amount * coins)
     * Space Complexity: O(amount)
     * 
     * @param coins Array of coin denominations
     * @param amount Target amount
     * @return Minimum number of coins needed
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    /**
     * Coin Change II - Number of ways to make change
     * 
     * Time Complexity: O(amount * coins)
     * Space Complexity: O(amount)
     * 
     * @param coins Array of coin denominations
     * @param amount Target amount
     * @return Number of ways to make change
     */
    public static int coinChangeII(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
    
    /**
     * Partition Equal Subset Sum
     * 
     * Time Complexity: O(n * sum)
     * Space Complexity: O(sum)
     * 
     * @param nums Array of numbers
     * @return True if can be partitioned into equal sum subsets
     */
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
    
    /**
     * Target Sum
     * 
     * Time Complexity: O(n * sum)
     * Space Complexity: O(sum)
     * 
     * @param nums Array of numbers
     * @param target Target sum
     * @return Number of ways to reach target sum
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum || target < -sum || (target + sum) % 2 != 0) return 0;
        
        int subsetSum = (target + sum) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;
        
        for (int num : nums) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[subsetSum];
    }
    
    /**
     * Last Stone Weight II
     * 
     * Time Complexity: O(n * sum)
     * Space Complexity: O(sum)
     * 
     * @param stones Array of stone weights
     * @return Minimum possible weight difference
     */
    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
    
    /**
     * Word Break
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     * 
     * @param s Input string
     * @param wordDict Dictionary of words
     * @return True if string can be segmented
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    /**
     * Combination Sum IV
     * 
     * Time Complexity: O(target * n)
     * Space Complexity: O(target)
     * 
     * @param nums Array of numbers
     * @param target Target sum
     * @return Number of combinations that sum to target
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
    
    /**
     * Partition to K Equal Sum Subsets
     * 
     * Time Complexity: O(n * 2^n)
     * Space Complexity: O(2^n)
     * 
     * @param nums Array of numbers
     * @param k Number of subsets
     * @return True if can be partitioned into k equal sum subsets
     */
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) return false;
        
        return backtrack(nums, new boolean[nums.length], 0, k, 0, target);
    }
    
    private static boolean backtrack(int[] nums, boolean[] used, int start, int k, int currentSum, int target) {
        if (k == 1) return true;
        if (currentSum == target) {
            return backtrack(nums, used, 0, k - 1, 0, target);
        }
        
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && currentSum + nums[i] <= target) {
                used[i] = true;
                if (backtrack(nums, used, i + 1, k, currentSum + nums[i], target)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
    
    /**
     * Main method for testing knapsack algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Knapsack Pattern Examples ===");
        
        // Test 0/1 knapsack
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        System.out.println("0/1 Knapsack: " + knapsack01(weights, values, capacity));
        System.out.println("0/1 Knapsack (optimized): " + knapsack01Optimized(weights, values, capacity));
        
        // Test unbounded knapsack
        System.out.println("Unbounded Knapsack: " + unboundedKnapsack(weights, values, capacity));
        
        // Test fractional knapsack
        System.out.println("Fractional Knapsack: " + fractionalKnapsack(weights, values, capacity));
        
        // Test coin change
        int[] coins = {1, 3, 4};
        int amount = 6;
        System.out.println("Coin Change: " + coinChange(coins, amount));
        System.out.println("Coin Change II: " + coinChangeII(coins, amount));
        
        // Test partition equal subset sum
        int[] partitionNums = {1, 5, 11, 5};
        System.out.println("Can partition: " + canPartition(partitionNums));
        
        // Test target sum
        int[] targetNums = {1, 1, 1, 1, 1};
        System.out.println("Target sum ways: " + findTargetSumWays(targetNums, 3));
        
        // Test last stone weight II
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last stone weight II: " + lastStoneWeightII(stones));
        
        // Test word break
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println("Word break: " + wordBreak("leetcode", wordDict));
        
        // Test combination sum IV
        int[] comboNums = {1, 2, 3};
        System.out.println("Combination sum IV: " + combinationSum4(comboNums, 4));
        
        // Test partition to k equal sum subsets
        int[] kSubsetNums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println("Partition to k subsets: " + canPartitionKSubsets(kSubsetNums, 4));
    }
}
