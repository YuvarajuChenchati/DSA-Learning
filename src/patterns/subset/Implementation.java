package patterns.subset;

import java.util.*;

/**
 * Subset Pattern Implementation
 * 
 * This class contains essential subset generation algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class SubsetPattern {
    
    /**
     * Generate all subsets
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param nums Array of numbers
     * @return List of all subsets
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Generate all subsets with duplicates
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param nums Array of numbers (may contain duplicates)
     * @return List of all subsets
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrackWithDup(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrackWithDup(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            backtrackWithDup(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Generate combinations of size k
     * 
     * Time Complexity: O(C(n,k))
     * Space Complexity: O(C(n,k))
     * 
     * @param n Range from 1 to n
     * @param k Size of combination
     * @return List of all combinations
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
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
    
    /**
     * Generate all permutations
     * 
     * Time Complexity: O(n!)
     * Space Complexity: O(n!)
     * 
     * @param nums Array of numbers
     * @return List of all permutations
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrackPermute(nums, new ArrayList<>(), used, result);
        return result;
    }
    
    private static void backtrackPermute(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrackPermute(nums, current, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
    
    /**
     * Generate all permutations with duplicates
     * 
     * Time Complexity: O(n!)
     * Space Complexity: O(n!)
     * 
     * @param nums Array of numbers (may contain duplicates)
     * @return List of all permutations
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrackPermuteUnique(nums, new ArrayList<>(), used, result);
        return result;
    }
    
    private static void backtrackPermuteUnique(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrackPermuteUnique(nums, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    
    /**
     * Generate letter combinations of phone number
     * 
     * Time Complexity: O(4^n)
     * Space Complexity: O(4^n)
     * 
     * @param digits Phone number digits
     * @return List of letter combinations
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrackLetters(digits, 0, "", mapping, result);
        return result;
    }
    
    private static void backtrackLetters(String digits, int index, String current, String[] mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            backtrackLetters(digits, index + 1, current + c, mapping, result);
        }
    }
    
    /**
     * Generate valid parentheses
     * 
     * Time Complexity: O(4^n / √n)
     * Space Complexity: O(4^n / √n)
     * 
     * @param n Number of pairs
     * @return List of valid parentheses
     */
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrackParentheses("", 0, 0, n, result);
        return result;
    }
    
    private static void backtrackParentheses(String current, int open, int close, int n, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            backtrackParentheses(current + "(", open + 1, close, n, result);
        }
        
        if (close < open) {
            backtrackParentheses(current + ")", open, close + 1, n, result);
        }
    }
    
    /**
     * Generate combination sum
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param candidates Array of candidates
     * @param target Target sum
     * @return List of combinations that sum to target
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackCombinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrackCombinationSum(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            current.add(candidates[i]);
            backtrackCombinationSum(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Generate combination sum II (no duplicates)
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param candidates Array of candidates (may contain duplicates)
     * @param target Target sum
     * @return List of combinations that sum to target
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackCombinationSum2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrackCombinationSum2(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            backtrackCombinationSum2(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    /**
     * Generate palindrome partitioning
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param s Input string
     * @return List of all palindrome partitions
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrackPartition(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrackPartition(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                backtrackPartition(s, i + 1, current, result);
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
     * Generate subsets using bit manipulation
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param nums Array of numbers
     * @return List of all subsets
     */
    public static List<List<Integer>> subsetsBitManipulation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
    
    /**
     * Generate combinations using iterative approach
     * 
     * Time Complexity: O(C(n,k))
     * Space Complexity: O(C(n,k))
     * 
     * @param n Range from 1 to n
     * @param k Size of combination
     * @return List of all combinations
     */
    public static List<List<Integer>> combineIterative(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        for (int i = 1; i <= k; i++) {
            current.add(i);
        }
        
        while (true) {
            result.add(new ArrayList<>(current));
            
            int j = k - 1;
            while (j >= 0 && current.get(j) == n - k + j + 1) {
                j--;
            }
            
            if (j < 0) break;
            
            current.set(j, current.get(j) + 1);
            for (int i = j + 1; i < k; i++) {
                current.set(i, current.get(i - 1) + 1);
            }
        }
        
        return result;
    }
    
    /**
     * Main method for testing subset pattern algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Subset Pattern Examples ===");
        
        // Test subsets
        int[] nums = {1, 2, 3};
        System.out.println("Subsets: " + subsets(nums));
        
        // Test subsets with duplicates
        int[] dupNums = {1, 2, 2};
        System.out.println("Subsets with duplicates: " + subsetsWithDup(dupNums));
        
        // Test combinations
        System.out.println("Combinations of 4 choose 2: " + combine(4, 2));
        
        // Test permutations
        System.out.println("Permutations: " + permute(nums));
        
        // Test permutations with duplicates
        int[] permDupNums = {1, 1, 2};
        System.out.println("Permutations with duplicates: " + permuteUnique(permDupNums));
        
        // Test letter combinations
        System.out.println("Letter combinations: " + letterCombinations("23"));
        
        // Test generate parentheses
        System.out.println("Generate parentheses: " + generateParentheses(3));
        
        // Test combination sum
        int[] candidates = {2, 3, 6, 7};
        System.out.println("Combination sum: " + combinationSum(candidates, 7));
        
        // Test combination sum II
        int[] candidates2 = {10, 1, 2, 7, 6, 1, 5};
        System.out.println("Combination sum II: " + combinationSum2(candidates2, 8));
        
        // Test palindrome partitioning
        System.out.println("Palindrome partitioning: " + partition("aab"));
        
        // Test subsets with bit manipulation
        System.out.println("Subsets (bit manipulation): " + subsetsBitManipulation(nums));
        
        // Test combinations iterative
        System.out.println("Combinations (iterative): " + combineIterative(4, 2));
    }
}
