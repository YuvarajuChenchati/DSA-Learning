package algorithms.backtracking;

import java.util.*;

/**
 * Backtracking Algorithms Implementation
 * 
 * This class contains essential backtracking algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class BacktrackingAlgorithms {
    
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
     * Time Complexity: O(C(n,k))
     * Space Complexity: O(k)
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
     * Generate all valid parentheses
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
     * Word search in 2D grid
     * 
     * Time Complexity: O(mn * 4^L)
     * Space Complexity: O(L)
     * 
     * @param board 2D character board
     * @param word Word to search
     * @return True if word exists, false otherwise
     */
    public static boolean wordSearch(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wordSearchHelper(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean wordSearchHelper(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index)) return false;
        
        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited
        
        boolean found = wordSearchHelper(board, word, index + 1, row + 1, col) ||
                       wordSearchHelper(board, word, index + 1, row - 1, col) ||
                       wordSearchHelper(board, word, index + 1, row, col + 1) ||
                       wordSearchHelper(board, word, index + 1, row, col - 1);
        
        board[row][col] = temp; // Restore
        return found;
    }
    
    /**
     * Combination sum
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
            if (candidates[i] > target) break;
            current.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Sudoku solver
     * 
     * Time Complexity: O(9^(n²))
     * Space Complexity: O(n²)
     * 
     * @param board Sudoku board
     * @return True if solvable, false otherwise
     */
    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
    
    /**
     * Palindrome partitioning
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * 
     * @param s Input string
     * @return List of all palindrome partitions
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        partitionHelper(s, 0, current, result);
        return result;
    }
    
    private static void partitionHelper(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                partitionHelper(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    /**
     * Letter combinations of phone number
     * 
     * Time Complexity: O(4^n)
     * Space Complexity: O(n)
     * 
     * @param digits Phone number digits
     * @return List of letter combinations
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsHelper(digits, 0, "", mapping, result);
        return result;
    }
    
    private static void letterCombinationsHelper(String digits, int index, String current, String[] mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            letterCombinationsHelper(digits, index + 1, current + c, mapping, result);
        }
    }
    
    /**
     * Main method for testing backtracking algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Backtracking Algorithms Examples ===");
        
        // Test permutations
        int[] nums = {1, 2, 3};
        System.out.println("Permutations of [1,2,3]: " + permute(nums));
        
        // Test combinations
        System.out.println("Combinations of 4 choose 2: " + combine(4, 2));
        
        // Test subsets
        System.out.println("Subsets of [1,2,3]: " + subsets(nums));
        
        // Test generate parentheses
        System.out.println("Generate parentheses for n=3: " + generateParentheses(3));
        
        // Test N-Queens
        System.out.println("N-Queens solutions for n=4: " + solveNQueens(4));
        
        // Test word search
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println("Word search for 'ABCCED': " + wordSearch(board, "ABCCED"));
        
        // Test combination sum
        int[] candidates = {2, 3, 6, 7};
        System.out.println("Combination sum for target 7: " + combinationSum(candidates, 7));
        
        // Test letter combinations
        System.out.println("Letter combinations for '23': " + letterCombinations("23"));
        
        // Test palindrome partitioning
        System.out.println("Palindrome partitioning for 'aab': " + partition("aab"));
    }
}
