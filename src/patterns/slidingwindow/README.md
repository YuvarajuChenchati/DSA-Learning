# Sliding Window Pattern 🪟

> **Master the sliding window technique for efficient subarray and substring problems**

## 🎯 Learning Objectives

- Understand sliding window fundamentals
- Master fixed and variable window patterns
- Learn when to use sliding window
- Apply sliding window to solve problems

## 📚 Theory

### Sliding Window Basics

#### Properties
- **Window**: Contiguous subarray/substring
- **Fixed size**: Window size is constant
- **Variable size**: Window size changes
- **Efficient**: O(n) time complexity
- **Optimization**: Avoid redundant calculations

#### Common Patterns
- **Fixed window**: Window size is given
- **Variable window**: Find optimal window size
- **Two pointers**: Left and right boundaries
- **Hash map**: Track window contents
- **Deque**: Maintain window properties

### When to Use Sliding Window

#### Subarray Problems
- **Maximum sum**: Find maximum sum subarray
- **Minimum sum**: Find minimum sum subarray
- **Average**: Find subarray with target average
- **Product**: Find subarray with target product

#### Substring Problems
- **Longest substring**: Find longest substring
- **Shortest substring**: Find shortest substring
- **Anagram**: Find anagram in string
- **Permutation**: Find permutation in string

## 🔧 Implementation

### Fixed Window Pattern

```java
// Maximum sum of subarray of size k
public static int maxSumSubarray(int[] arr, int k) {
    int windowSum = 0, maxSum = 0;
    
    // Calculate sum of first window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Slide window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}

// Average of subarrays of size k
public static double[] findAverages(int[] arr, int k) {
    double[] result = new double[arr.length - k + 1];
    int windowSum = 0;
    
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    for (int i = k; i < arr.length; i++) {
        result[i - k] = (double) windowSum / k;
        windowSum += arr[i] - arr[i - k];
    }
    result[arr.length - k] = (double) windowSum / k;
    
    return result;
}
```

### Variable Window Pattern

```java
// Longest substring with k distinct characters
public static int longestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> charCount = new HashMap<>();
    int left = 0, maxLength = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char rightChar = s.charAt(right);
        charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
        
        while (charCount.size() > k) {
            char leftChar = s.charAt(left);
            charCount.put(leftChar, charCount.get(leftChar) - 1);
            if (charCount.get(leftChar) == 0) {
                charCount.remove(leftChar);
            }
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
}

// Minimum window substring
public static String minWindow(String s, String t) {
    Map<Character, Integer> targetCount = new HashMap<>();
    for (char c : t.toCharArray()) {
        targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
    }
    
    int left = 0, right = 0;
    int minStart = 0, minLen = Integer.MAX_VALUE;
    int count = t.length();
    
    while (right < s.length()) {
        char rightChar = s.charAt(right);
        if (targetCount.containsKey(rightChar)) {
            if (targetCount.get(rightChar) > 0) {
                count--;
            }
            targetCount.put(rightChar, targetCount.get(rightChar) - 1);
        }
        right++;
        
        while (count == 0) {
            if (right - left < minLen) {
                minLen = right - left;
                minStart = left;
            }
            
            char leftChar = s.charAt(left);
            if (targetCount.containsKey(leftChar)) {
                targetCount.put(leftChar, targetCount.get(leftChar) + 1);
                if (targetCount.get(leftChar) > 0) {
                    count++;
                }
            }
            left++;
        }
    }
    
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}
```

## 📝 Practice Problems

### Easy
1. **Maximum Sum Subarray of Size K** - O(n) time, O(1) space
2. **Average of Subarrays of Size K** - O(n) time, O(1) space
3. **Maximum Sum of Any Sliding Window** - O(n) time, O(1) space
4. **Find All Anagrams in a String** - O(n) time, O(1) space
5. **Permutation in String** - O(n) time, O(1) space

### Medium
1. **Longest Substring with K Distinct Characters** - O(n) time, O(k) space
2. **Fruit Into Baskets** - O(n) time, O(1) space
3. **Longest Substring Without Repeating Characters** - O(n) time, O(1) space
4. **Longest Repeating Character Replacement** - O(n) time, O(1) space
5. **Subarray Product Less Than K** - O(n) time, O(1) space

### Hard
1. **Minimum Window Substring** - O(n) time, O(1) space
2. **Sliding Window Maximum** - O(n) time, O(k) space
3. **Longest Substring with At Most Two Distinct Characters** - O(n) time, O(1) space
4. **Substring with Concatenation of All Words** - O(n) time, O(m) space
5. **Minimum Size Subarray Sum** - O(n) time, O(1) space

## 💡 Key Insights

- **Fixed window**: Use for problems with given window size
- **Variable window**: Use for problems with optimal window size
- **Hash map**: Track window contents efficiently
- **Two pointers**: Maintain window boundaries
- **Optimization**: Avoid redundant calculations

## 🎯 Interview Tips

- Identify if problem needs fixed or variable window
- Use hash map for character/frequency tracking
- Consider edge cases (empty string, single character)
- Think about space optimization
- Use sliding window for O(n) solutions

## 📚 Additional Resources

- [Sliding Window Technique](https://www.geeksforgeeks.org/window-sliding-technique/)
- [Two Pointers Technique](https://www.geeksforgeeks.org/two-pointers-technique/)
- [Sliding Window Problems](https://leetcode.com/tag/sliding-window/)
- [Window Sliding Technique](https://www.geeksforgeeks.org/window-sliding-technique/)
