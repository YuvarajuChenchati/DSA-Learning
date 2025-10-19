package datastructures.trie;

import java.util.*;

/**
 * Trie (Prefix Tree) Implementation
 * 
 * This class contains essential trie operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class TrieOperations {
    
    /**
     * Trie Node class
     */
    public static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        int count; // For counting occurrences
        
        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.count = 0;
        }
    }
    
    /**
     * Basic Trie implementation
     */
    public static class Trie {
        private TrieNode root;
        
        public Trie() {
            this.root = new TrieNode();
        }
        
        /**
         * Insert word into trie
         * 
         * Time Complexity: O(m) where m is length of word
         * Space Complexity: O(m)
         * 
         * @param word Word to insert
         */
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
                current.count++;
            }
            current.isEndOfWord = true;
        }
        
        /**
         * Search word in trie
         * 
         * Time Complexity: O(m) where m is length of word
         * Space Complexity: O(1)
         * 
         * @param word Word to search
         * @return True if word exists, false otherwise
         */
        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return false;
                }
                current = current.children.get(c);
            }
            return current.isEndOfWord;
        }
        
        /**
         * Check if prefix exists
         * 
         * Time Complexity: O(m) where m is length of prefix
         * Space Complexity: O(1)
         * 
         * @param prefix Prefix to check
         * @return True if prefix exists, false otherwise
         */
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return false;
                }
                current = current.children.get(c);
            }
            return true;
        }
        
        /**
         * Delete word from trie
         * 
         * Time Complexity: O(m) where m is length of word
         * Space Complexity: O(1)
         * 
         * @param word Word to delete
         * @return True if word was deleted, false if not found
         */
        public boolean delete(String word) {
            return deleteHelper(root, word, 0);
        }
        
        private boolean deleteHelper(TrieNode node, String word, int index) {
            if (index == word.length()) {
                if (!node.isEndOfWord) {
                    return false;
                }
                node.isEndOfWord = false;
                return node.children.isEmpty();
            }
            
            char c = word.charAt(index);
            TrieNode child = node.children.get(c);
            if (child == null) {
                return false;
            }
            
            boolean shouldDeleteChild = deleteHelper(child, word, index + 1);
            
            if (shouldDeleteChild) {
                node.children.remove(c);
                return node.children.isEmpty() && !node.isEndOfWord;
            }
            
            return false;
        }
        
        /**
         * Get all words with given prefix
         * 
         * Time Complexity: O(n) where n is number of words with prefix
         * Space Complexity: O(n)
         * 
         * @param prefix Prefix to search
         * @return List of words with prefix
         */
        public List<String> searchPrefix(String prefix) {
            List<String> result = new ArrayList<>();
            TrieNode current = root;
            
            // Navigate to prefix
            for (char c : prefix.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return result;
                }
                current = current.children.get(c);
            }
            
            // DFS to find all words with prefix
            dfs(current, prefix, result);
            return result;
        }
        
        private void dfs(TrieNode node, String current, List<String> result) {
            if (node.isEndOfWord) {
                result.add(current);
            }
            
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                dfs(entry.getValue(), current + entry.getKey(), result);
            }
        }
        
        /**
         * Get count of words with given prefix
         * 
         * Time Complexity: O(m) where m is length of prefix
         * Space Complexity: O(1)
         * 
         * @param prefix Prefix to count
         * @return Count of words with prefix
         */
        public int countWordsWithPrefix(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return 0;
                }
                current = current.children.get(c);
            }
            return current.count;
        }
        
        /**
         * Get all words in trie
         * 
         * Time Complexity: O(n) where n is total number of characters
         * Space Complexity: O(n)
         * 
         * @return List of all words
         */
        public List<String> getAllWords() {
            List<String> result = new ArrayList<>();
            dfs(root, "", result);
            return result;
        }
        
        /**
         * Get size of trie
         * 
         * @return Number of words in trie
         */
        public int size() {
            return countWords(root);
        }
        
        private int countWords(TrieNode node) {
            int count = 0;
            if (node.isEndOfWord) {
                count++;
            }
            for (TrieNode child : node.children.values()) {
                count += countWords(child);
            }
            return count;
        }
    }
    
    /**
     * Word Search II using Trie
     * 
     * Time Complexity: O(mn * 4^L)
     * Space Complexity: O(L)
     * 
     * @param board 2D character board
     * @param words Array of words to search
     * @return List of found words
     */
    public static List<String> wordSearchII(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) return result;
        
        // Build trie from words
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root, "", visited, result);
            }
        }
        
        return result;
    }
    
    private static void dfs(char[][] board, int row, int col, TrieNode node, String current, boolean[][] visited, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        
        char c = board[row][col];
        if (!node.children.containsKey(c)) {
            return;
        }
        
        node = node.children.get(c);
        current += c;
        visited[row][col] = true;
        
        if (node.isEndOfWord) {
            result.add(current);
            node.isEndOfWord = false; // Avoid duplicates
        }
        
        // Explore all directions
        dfs(board, row + 1, col, node, current, visited, result);
        dfs(board, row - 1, col, node, current, visited, result);
        dfs(board, row, col + 1, node, current, visited, result);
        dfs(board, row, col - 1, node, current, visited, result);
        
        visited[row][col] = false;
    }
    
    /**
     * Longest Common Prefix using Trie
     * 
     * Time Complexity: O(mn) where m is length of shortest string
     * Space Complexity: O(mn)
     * 
     * @param strs Array of strings
     * @return Longest common prefix
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        
        StringBuilder prefix = new StringBuilder();
        TrieNode current = trie.root;
        
        while (current.children.size() == 1 && !current.isEndOfWord) {
            Map.Entry<Character, TrieNode> entry = current.children.entrySet().iterator().next();
            prefix.append(entry.getKey());
            current = entry.getValue();
        }
        
        return prefix.toString();
    }
    
    /**
     * Replace words using Trie
     * 
     * Time Complexity: O(mn) where m is number of words, n is average length
     * Space Complexity: O(mn)
     * 
     * @param dictionary Array of dictionary words
     * @param sentence Input sentence
     * @return Sentence with replaced words
     */
    public static String replaceWords(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String replacement = findShortestPrefix(trie, word);
            result.append(replacement);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    private static String findShortestPrefix(Trie trie, String word) {
        TrieNode current = trie.root;
        StringBuilder prefix = new StringBuilder();
        
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return word;
            }
            current = current.children.get(c);
            prefix.append(c);
            if (current.isEndOfWord) {
                return prefix.toString();
            }
        }
        return word;
    }
    
    /**
     * Map Sum Pairs using Trie
     * 
     * Time Complexity: O(m) for insert/sum, O(mn) for sum
     * Space Complexity: O(mn)
     */
    public static class MapSum {
        private TrieNode root;
        
        public MapSum() {
            this.root = new TrieNode();
        }
        
        public void insert(String key, int val) {
            TrieNode current = root;
            for (char c : key.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isEndOfWord = true;
            current.count = val;
        }
        
        public int sum(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return 0;
                }
                current = current.children.get(c);
            }
            return sumHelper(current);
        }
        
        private int sumHelper(TrieNode node) {
            int sum = 0;
            if (node.isEndOfWord) {
                sum += node.count;
            }
            for (TrieNode child : node.children.values()) {
                sum += sumHelper(child);
            }
            return sum;
        }
    }
    
    /**
     * Main method for testing trie operations
     */
    public static void main(String[] args) {
        System.out.println("=== Trie Operations Examples ===");
        
        // Test basic trie operations
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("apply");
        
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Search 'apple': " + trie.search("apple"));
        System.out.println("Starts with 'app': " + trie.startsWith("app"));
        System.out.println("Words with prefix 'app': " + trie.searchPrefix("app"));
        System.out.println("Count words with prefix 'app': " + trie.countWordsWithPrefix("app"));
        System.out.println("All words: " + trie.getAllWords());
        System.out.println("Trie size: " + trie.size());
        
        // Test word search II
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println("Word search II: " + wordSearchII(board, words));
        
        // Test longest common prefix
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix: " + longestCommonPrefix(strs));
        
        // Test replace words
        String[] dictionary = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        System.out.println("Replace words: " + replaceWords(dictionary, sentence));
        
        // Test map sum
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.insert("app", 2);
        System.out.println("Sum for 'ap': " + mapSum.sum("ap"));
    }
}
