package algorithms.dynamicprogramming;

import java.util.*;

/**
 * Dynamic Programming Implementation
 * 
 * This class contains essential dynamic programming algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class DynamicProgrammingAlgorithms {
    
    /**
     * Fibonacci using memoization
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param n Number
     * @return Fibonacci number
     */
    public static int fibonacciMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibonacciMemoHelper(n, memo);
    }
    
    private static int fibonacciMemoHelper(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        
        memo[n] = fibonacciMemoHelper(n - 1, memo) + fibonacciMemoHelper(n - 2, memo);
        return memo[n];
    }
    
    /**
     * Fibonacci using tabulation
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Fibonacci number
     */
    public static int fibonacciTab(int n) {
        if (n <= 1) return n;
        
        int prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    
    /**
     * Climbing stairs
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param n Number of stairs
     * @return Number of ways to climb
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev2 = 1, prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    
    /**
     * House robber
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of money in each house
     * @return Maximum money that can be robbed
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    
    /**
     * Longest increasing subsequence
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     * 
     * @param nums Array of numbers
     * @return Length of longest increasing subsequence
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    
    /**
     * Coin change
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
     * Word break
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     * 
     * @param s Input string
     * @param wordDict Dictionary of words
     * @return True if string can be segmented, false otherwise
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
     * Unique paths
     * 
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     * 
     * @param m Number of rows
     * @param n Number of columns
     * @return Number of unique paths
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize first row and column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    
    /**
     * Longest common subsequence
     * 
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     * 
     * @param text1 First string
     * @param text2 Second string
     * @return Length of longest common subsequence
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    
    /**
     * Edit distance
     * 
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     * 
     * @param word1 First word
     * @param word2 Second word
     * @return Minimum edit distance
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
    
    /**
     * Regular expression matching
     * 
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     * 
     * @param s Input string
     * @param p Pattern string
     * @return True if string matches pattern, false otherwise
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, etc.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]; // Zero occurrences
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // One or more occurrences
                    }
                }
            }
        }
        return dp[m][n];
    }
    
    /**
     * Longest valid parentheses
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param s Input string
     * @return Length of longest valid parentheses
     */
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
    
    /**
     * Minimum insertions to make palindrome
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(n²)
     * 
     * @param s Input string
     * @return Minimum insertions needed
     */
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
    
    /**
     * Knapsack 0/1
     * 
     * Time Complexity: O(nW)
     * Space Complexity: O(nW)
     * 
     * @param weights Array of weights
     * @param values Array of values
     * @param capacity Knapsack capacity
     * @return Maximum value that can be obtained
     */
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }
    
    /**
     * Main method for testing dynamic programming algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Dynamic Programming Examples ===");
        
        // Test Fibonacci
        System.out.println("Fibonacci(10) memo: " + fibonacciMemo(10));
        System.out.println("Fibonacci(10) tab: " + fibonacciTab(10));
        
        // Test climbing stairs
        System.out.println("Climbing stairs(5): " + climbStairs(5));
        
        // Test house robber
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("House robber: " + rob(houses));
        
        // Test LIS
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Longest increasing subsequence: " + lengthOfLIS(nums));
        
        // Test coin change
        int[] coins = {1, 3, 4};
        System.out.println("Coin change: " + coinChange(coins, 6));
        
        // Test word break
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println("Word break: " + wordBreak("leetcode", wordDict));
        
        // Test unique paths
        System.out.println("Unique paths(3, 7): " + uniquePaths(3, 7));
        
        // Test LCS
        System.out.println("Longest common subsequence: " + longestCommonSubsequence("abcde", "ace"));
        
        // Test edit distance
        System.out.println("Edit distance: " + minDistance("horse", "ros"));
        
        // Test regex matching
        System.out.println("Regex matching: " + isMatch("aa", "a*"));
        
        // Test longest valid parentheses
        System.out.println("Longest valid parentheses: " + longestValidParentheses("(()"));
        
        // Test minimum insertions
        System.out.println("Minimum insertions: " + minInsertions("ab"));
        
        // Test knapsack
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        System.out.println("Knapsack: " + knapsack(weights, values, 7));
    }
}
