package algorithms.recursion;

import java.util.*;

/**
 * Recursion Implementation
 * 
 * This class contains essential recursive algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class RecursionAlgorithms {
    
    /**
     * Calculate factorial recursively
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param n Number
     * @return Factorial of n
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    /**
     * Calculate factorial iteratively
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Factorial of n
     */
    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculate Fibonacci number recursively
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * 
     * @param n Number
     * @return Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * Calculate Fibonacci number with memoization
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
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibonacciMemoHelper(n - 1, memo) + fibonacciMemoHelper(n - 2, memo);
        return memo[n];
    }
    
    /**
     * Calculate Fibonacci number iteratively
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Fibonacci number
     */
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    /**
     * Calculate power recursively
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param base Base number
     * @param exp Exponent
     * @return base^exp
     */
    public static long power(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Negative exponent not supported");
        }
        if (exp == 0) {
            return 1;
        }
        return base * power(base, exp - 1);
    }
    
    /**
     * Calculate power efficiently
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * 
     * @param base Base number
     * @param exp Exponent
     * @return base^exp
     */
    public static long powerEfficient(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Negative exponent not supported");
        }
        if (exp == 0) {
            return 1;
        }
        if (exp % 2 == 0) {
            long half = powerEfficient(base, exp / 2);
            return half * half;
        } else {
            return base * powerEfficient(base, exp - 1);
        }
    }
    
    /**
     * Tower of Hanoi
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * 
     * @param n Number of disks
     * @param from Source rod
     * @param to Destination rod
     * @param aux Auxiliary rod
     */
    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }
    
    /**
     * Binary search recursively
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * 
     * @param arr Sorted array
     * @param target Target value
     * @param left Left boundary
     * @param right Right boundary
     * @return Index of target, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right);
        } else {
            return binarySearch(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Generate all permutations
     * 
     * Time Complexity: O(n!)
     * Space Complexity: O(n)
     * 
     * @param nums Array of numbers
     * @return List of all permutations
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, current, used, result);
        return result;
    }
    
    private static void permuteHelper(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
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
    
    /**
     * Generate all combinations
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * 
     * @param n Range from 1 to n
     * @param k Size of combination
     * @return List of all combinations
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combineHelper(1, n, k, current, result);
        return result;
    }
    
    private static void combineHelper(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            combineHelper(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Generate all subsets
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * 
     * @param nums Array of numbers
     * @return List of all subsets
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsetsHelper(nums, 0, current, result);
        return result;
    }
    
    private static void subsetsHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            subsetsHelper(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Find combination sum
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * 
     * @param candidates Array of candidates
     * @param target Target sum
     * @return List of combinations that sum to target
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, current, result);
        return result;
    }
    
    private static void combinationSumHelper(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Generate parentheses
     * 
     * Time Complexity: O(4^n / √n)
     * Space Complexity: O(n)
     * 
     * @param n Number of pairs
     * @return List of valid parentheses
     */
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesesHelper("", 0, 0, n, result);
        return result;
    }
    
    private static void generateParenthesesHelper(String current, int open, int close, int n, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            generateParenthesesHelper(current + "(", open + 1, close, n, result);
        }
        
        if (close < open) {
            generateParenthesesHelper(current + ")", open, close + 1, n, result);
        }
    }
    
    /**
     * Solve N-Queens problem
     * 
     * Time Complexity: O(n!)
     * Space Complexity: O(n)
     * 
     * @param n Size of board
     * @return List of solutions
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        solveNQueensHelper(queens, 0, result);
        return result;
    }
    
    private static void solveNQueensHelper(int[] queens, int row, List<List<String>> result) {
        if (row == queens.length) {
            result.add(constructBoard(queens));
            return;
        }
        
        for (int col = 0; col < queens.length; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                solveNQueensHelper(queens, row + 1, result);
            }
        }
    }
    
    private static boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    
    private static List<String> constructBoard(int[] queens) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                row.append(queens[i] == j ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
    }
    
    /**
     * Main method for testing recursion algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Recursion Algorithms Examples ===");
        
        // Test factorial
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 5 (iterative): " + factorialIterative(5));
        
        // Test Fibonacci
        System.out.println("Fibonacci of 10: " + fibonacci(10));
        System.out.println("Fibonacci of 10 (memo): " + fibonacciMemo(10));
        System.out.println("Fibonacci of 10 (iterative): " + fibonacciIterative(10));
        
        // Test power
        System.out.println("2^10: " + power(2, 10));
        System.out.println("2^10 (efficient): " + powerEfficient(2, 10));
        
        // Test Tower of Hanoi
        System.out.println("Tower of Hanoi for 3 disks:");
        towerOfHanoi(3, 'A', 'C', 'B');
        
        // Test binary search
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Binary search for 5: " + binarySearch(arr, 5, 0, arr.length - 1));
        
        // Test permutations
        int[] nums = {1, 2, 3};
        System.out.println("Permutations of [1,2,3]: " + permute(nums));
        
        // Test combinations
        System.out.println("Combinations of 4 choose 2: " + combine(4, 2));
        
        // Test subsets
        System.out.println("Subsets of [1,2,3]: " + subsets(nums));
        
        // Test combination sum
        int[] candidates = {2, 3, 6, 7};
        System.out.println("Combination sum for target 7: " + combinationSum(candidates, 7));
        
        // Test generate parentheses
        System.out.println("Generate parentheses for n=3: " + generateParentheses(3));
        
        // Test N-Queens
        System.out.println("N-Queens solutions for n=4: " + solveNQueens(4));
    }
}
