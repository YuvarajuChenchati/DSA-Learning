# Strings 🔤

> **Master string manipulation and common string algorithms**

## 🎯 Learning Objectives

- Understand string fundamentals
- Master string manipulation techniques
- Learn string-based algorithms
- Apply string patterns to solve problems

## 📚 Theory

### String Basics

#### Properties
- **Immutable**: Strings cannot be modified in-place
- **Character array**: Strings are essentially character arrays
- **Unicode support**: Modern strings support Unicode characters
- **Memory efficient**: String interning for memory optimization

#### Common Operations
- **Access**: O(1) time for character access
- **Search**: O(n) time for linear search
- **Substring**: O(k) time where k is substring length
- **Concatenation**: O(n + m) time for two strings

### String Patterns

#### Two Pointers
- **Palindrome checking**: Compare characters from both ends
- **String reversal**: Swap characters using two pointers
- **Anagram detection**: Use frequency counting

#### Sliding Window
- **Longest substring**: Find longest substring with unique characters
- **Pattern matching**: Find pattern in text
- **Minimum window**: Find minimum window containing all characters

## 🔧 Implementation

### Basic String Operations

```java
// Check if string is palindrome
public static boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

// Reverse string
public static String reverseString(String s) {
    char[] chars = s.toCharArray();
    int left = 0, right = chars.length - 1;
    while (left < right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
    }
    return new String(chars);
}
```

### String Algorithms

```java
// KMP algorithm for pattern matching
public static int kmpSearch(String text, String pattern) {
    int[] lps = computeLPS(pattern);
    int i = 0, j = 0;
    
    while (i < text.length()) {
        if (text.charAt(i) == pattern.charAt(j)) {
            i++;
            j++;
        }
        if (j == pattern.length()) {
            return i - j;
        } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
            if (j != 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }
    return -1;
}
```

## 📝 Practice Problems

### Easy
1. **Valid Palindrome** - O(n) time, O(1) space
2. **Reverse String** - O(n) time, O(1) space
3. **First Unique Character** - O(n) time, O(1) space
4. **Valid Anagram** - O(n) time, O(1) space
5. **String Compression** - O(n) time, O(1) space

### Medium
1. **Longest Substring Without Repeating Characters** - O(n) time, O(1) space
2. **Longest Palindromic Substring** - O(n²) time, O(1) space
3. **Group Anagrams** - O(nk log k) time, O(nk) space
4. **Minimum Window Substring** - O(n) time, O(1) space
5. **Find All Anagrams** - O(n) time, O(1) space

### Hard
1. **Edit Distance** - O(mn) time, O(mn) space
2. **Regular Expression Matching** - O(mn) time, O(mn) space
3. **Wildcard Matching** - O(mn) time, O(mn) space
4. **Longest Valid Parentheses** - O(n) time, O(n) space
5. **Minimum Insertions to Make Palindrome** - O(n²) time, O(n²) space

## 💡 Key Insights

- **Character frequency**: Use arrays or maps for frequency counting
- **Two pointers**: Efficient for palindrome and anagram problems
- **Sliding window**: Optimal for substring problems
- **Dynamic programming**: Useful for complex string problems
- **String interning**: Be aware of memory implications

## ⚠️ Common Mistakes

### String Immutability
- **Problem**: Trying to modify strings in-place
- **Solution**: Use StringBuilder or character array for modifications
- **Example**: `str.charAt(i) = 'a'` is wrong, use `StringBuilder sb = new StringBuilder(str);`

### Off-by-One Errors in Substring
- **Problem**: Incorrect substring indices
- **Solution**: Remember substring is inclusive start, exclusive end
- **Example**: `s.substring(0, 3)` gives characters at indices 0, 1, 2 (not 3)

### Case Sensitivity
- **Problem**: Not handling case differences correctly
- **Solution**: Convert to lowercase/uppercase before comparison
- **Example**: `s.toLowerCase().equals(t.toLowerCase())` for case-insensitive comparison

### Character vs String Comparison
- **Problem**: Comparing characters with == instead of equals
- **Solution**: Use == for characters, equals() for strings
- **Example**: `s.charAt(i) == 'a'` is correct, `s.charAt(i).equals("a")` is wrong

### Not Handling Empty Strings
- **Problem**: Not checking for empty strings
- **Solution**: Always check if string is null or empty first
- **Example**: `if (s == null || s.length() == 0) return result;`

### StringBuilder vs String Concatenation
- **Problem**: Using string concatenation in loops
- **Solution**: Use StringBuilder for multiple concatenations
- **Example**: `sb.append(str)` in loop, not `result += str` in loop

### Unicode and Special Characters
- **Problem**: Not handling Unicode characters correctly
- **Solution**: Use proper encoding and be aware of character ranges
- **Example**: Some characters take multiple bytes, use proper string methods

## 🎯 Interview Tips

- Consider case sensitivity and special characters
- Use two pointers for palindrome problems
- Apply sliding window for substring problems
- Think about edge cases (empty strings, single characters)
- Consider space-time tradeoffs

## 📚 Additional Resources

- [String Algorithms](https://www.geeksforgeeks.org/string-data-structure/)
- [KMP Algorithm](https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/)
- [Rabin-Karp Algorithm](https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/)
- [String Matching Algorithms](https://en.wikipedia.org/wiki/String_searching_algorithm)
