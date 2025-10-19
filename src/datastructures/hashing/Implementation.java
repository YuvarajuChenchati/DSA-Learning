package datastructures.hashing;

import java.util.*;

/**
 * Hashing Implementation
 * 
 * This class contains essential hashing operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class HashingOperations {
    
    /**
     * Custom Hash Table implementation
     */
    public static class HashTable<K, V> {
        private static final int INITIAL_CAPACITY = 16;
        private static final double LOAD_FACTOR = 0.75;
        
        private Entry<K, V>[] table;
        private int size;
        private int capacity;
        
        @SuppressWarnings("unchecked")
        public HashTable() {
            this.capacity = INITIAL_CAPACITY;
            this.table = new Entry[capacity];
            this.size = 0;
        }
        
        /**
         * Put key-value pair in hash table
         * 
         * Time Complexity: O(1) average, O(n) worst case
         * Space Complexity: O(1)
         * 
         * @param key Key
         * @param value Value
         */
        public void put(K key, V value) {
            if (size >= capacity * LOAD_FACTOR) {
                resize();
            }
            
            int index = hash(key);
            Entry<K, V> entry = table[index];
            
            // Check if key already exists
            while (entry != null) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            
            // Add new entry
            Entry<K, V> newEntry = new Entry<>(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
            size++;
        }
        
        /**
         * Get value by key
         * 
         * Time Complexity: O(1) average, O(n) worst case
         * Space Complexity: O(1)
         * 
         * @param key Key
         * @return Value or null if not found
         */
        public V get(K key) {
            int index = hash(key);
            Entry<K, V> entry = table[index];
            
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
            return null;
        }
        
        /**
         * Remove key-value pair
         * 
         * Time Complexity: O(1) average, O(n) worst case
         * Space Complexity: O(1)
         * 
         * @param key Key
         * @return Value that was removed or null
         */
        public V remove(K key) {
            int index = hash(key);
            Entry<K, V> entry = table[index];
            Entry<K, V> prev = null;
            
            while (entry != null) {
                if (entry.key.equals(key)) {
                    if (prev == null) {
                        table[index] = entry.next;
                    } else {
                        prev.next = entry.next;
                    }
                    size--;
                    return entry.value;
                }
                prev = entry;
                entry = entry.next;
            }
            return null;
        }
        
        /**
         * Check if key exists
         * 
         * @param key Key
         * @return True if exists, false otherwise
         */
        public boolean containsKey(K key) {
            return get(key) != null;
        }
        
        /**
         * Get size of hash table
         * 
         * @return Number of key-value pairs
         */
        public int size() {
            return size;
        }
        
        /**
         * Check if hash table is empty
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return size == 0;
        }
        
        /**
         * Hash function
         * 
         * @param key Key
         * @return Hash code
         */
        private int hash(K key) {
            return Math.abs(key.hashCode()) % capacity;
        }
        
        /**
         * Resize hash table when load factor is exceeded
         */
        @SuppressWarnings("unchecked")
        private void resize() {
            Entry<K, V>[] oldTable = table;
            capacity *= 2;
            table = new Entry[capacity];
            size = 0;
            
            for (Entry<K, V> entry : oldTable) {
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }
        
        /**
         * Get all keys
         * 
         * @return Set of all keys
         */
        public Set<K> keySet() {
            Set<K> keys = new HashSet<>();
            for (Entry<K, V> entry : table) {
                while (entry != null) {
                    keys.add(entry.key);
                    entry = entry.next;
                }
            }
            return keys;
        }
        
        /**
         * Get all values
         * 
         * @return Collection of all values
         */
        public Collection<V> values() {
            List<V> values = new ArrayList<>();
            for (Entry<K, V> entry : table) {
                while (entry != null) {
                    values.add(entry.value);
                    entry = entry.next;
                }
            }
            return values;
        }
    }
    
    /**
     * Entry class for hash table
     */
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    /**
     * Find two numbers that sum to target
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param nums Array of numbers
     * @param target Target sum
     * @return Indices of two numbers that sum to target
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    
    /**
     * Find three numbers that sum to zero
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return List of triplets that sum to zero
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
    
    /**
     * Group anagrams together
     * 
     * Time Complexity: O(n * m log m)
     * Space Complexity: O(n * m)
     * 
     * @param strs Array of strings
     * @return List of grouped anagrams
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    /**
     * Find longest substring without repeating characters
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(min(m, n))
     * 
     * @param s Input string
     * @return Length of longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    
    /**
     * Find all anagrams in string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @param p Pattern string
     * @return List of starting indices of anagrams
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0, count = map.size();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            right++;
            
            while (count == 0) {
                if (right - left == p.length()) {
                    result.add(left);
                }
                
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }
                left++;
            }
        }
        return result;
    }
    
    /**
     * Find first non-repeating character
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return First non-repeating character or -1
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Check if two strings are anagrams
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s First string
     * @param t Second string
     * @return True if anagrams, false otherwise
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) return false;
        }
        return true;
    }
    
    /**
     * Find intersection of two arrays
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(min(n, m))
     * 
     * @param nums1 First array
     * @param nums2 Second array
     * @return Array of intersection
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        
        return set2.stream().mapToInt(i -> i).toArray();
    }
    
    /**
     * Find intersection of two arrays II (with duplicates)
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(min(n, m))
     * 
     * @param nums1 First array
     * @param nums2 Second array
     * @return Array of intersection with duplicates
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    /**
     * Find missing number in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Missing number
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    /**
     * Find duplicate number in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Duplicate number
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Find meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Find duplicate
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    /**
     * Main method for testing hashing operations
     */
    public static void main(String[] args) {
        System.out.println("=== Hashing Operations Examples ===");
        
        // Test custom hash table
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("cherry", 8);
        
        System.out.println("Hash table size: " + hashTable.size());
        System.out.println("Get apple: " + hashTable.get("apple"));
        System.out.println("Contains banana: " + hashTable.containsKey("banana"));
        
        // Test two sum
        int[] nums = {2, 7, 11, 15};
        int[] twoSumResult = twoSum(nums, 9);
        System.out.println("Two sum indices: " + Arrays.toString(twoSumResult));
        
        // Test three sum
        int[] threeSumNums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Three sum: " + threeSum(threeSumNums));
        
        // Test group anagrams
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Group anagrams: " + groupAnagrams(strs));
        
        // Test longest substring
        System.out.println("Longest substring length: " + lengthOfLongestSubstring("abcabcbb"));
        
        // Test find anagrams
        System.out.println("Find anagrams: " + findAnagrams("cbaebabacd", "abc"));
        
        // Test first unique character
        System.out.println("First unique character: " + firstUniqChar("leetcode"));
        
        // Test is anagram
        System.out.println("Is anagram: " + isAnagram("anagram", "nagaram"));
        
        // Test intersection
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("Intersection: " + Arrays.toString(intersection(nums1, nums2)));
        System.out.println("Intersect: " + Arrays.toString(intersect(nums1, nums2)));
        
        // Test missing number
        int[] missingNums = {3, 0, 1};
        System.out.println("Missing number: " + missingNumber(missingNums));
        
        // Test find duplicate
        int[] duplicateNums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number: " + findDuplicate(duplicateNums));
    }
}
