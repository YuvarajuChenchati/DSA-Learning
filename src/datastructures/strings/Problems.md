# String Problems 📝

> **Comprehensive collection of string problems organized by difficulty**

## 🎯 Problem Categories

### Easy Problems (15+)

1. **Valid Palindrome** (LeetCode #125) - ⭐⭐⭐ Very Common
   - Check if string is palindrome
   - Time: O(n), Space: O(1)
   - Hint: Two pointers from both ends

2. **Reverse String** (LeetCode #344) - ⭐⭐ Common
   - Reverse string in-place
   - Time: O(n), Space: O(1)
   - Hint: Two pointers swap

3. **First Unique Character** (LeetCode #387) - ⭐⭐⭐ Very Common
   - Find first non-repeating character
   - Time: O(n), Space: O(1)
   - Hint: Count characters with HashMap

4. **Valid Anagram** (LeetCode #242) - ⭐⭐⭐ Very Common
   - Check if strings are anagrams
   - Time: O(n), Space: O(1)
   - Hint: Count characters or sort

5. **Longest Common Prefix** (LeetCode #14) - ⭐⭐ Common
   - Find longest common prefix
   - Time: O(nm), Space: O(1)
   - Hint: Compare character by character

6. **Reverse Words in String** (LeetCode #151) - ⭐ Common
   - Reverse order of words
   - Time: O(n), Space: O(n)
   - Hint: Split, reverse, join

7. **Implement strStr()** (LeetCode #28) - ⭐ Common
   - Find needle in haystack
   - Time: O(nm), Space: O(1)
   - Hint: Sliding window or KMP

8. **Isomorphic Strings** (LeetCode #205) - ⭐ Common
   - Check if strings are isomorphic
   - Time: O(n), Space: O(n)
   - Hint: Character mapping

9. **Reverse Vowels** (LeetCode #345) - ⭐ Common
   - Reverse vowels in string
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

10. **Add Binary** (LeetCode #67) - ⭐ Common
    - Add two binary strings
    - Time: O(n), Space: O(1)
    - Hint: Handle carry-over

11. **Roman to Integer** (LeetCode #13) - ⭐ Common
    - Convert Roman numeral to integer
    - Time: O(n), Space: O(1)
    - Hint: Check next character

12. **Count and Say** (LeetCode #38) - ⭐ Common
    - Generate count-and-say sequence
    - Time: O(n * 2^n), Space: O(2^n)
    - Hint: Build from previous

13. **Valid Parentheses** (LeetCode #20) - ⭐⭐⭐ Very Common
    - Check if parentheses are valid
    - Time: O(n), Space: O(n)
    - Hint: Use stack

14. **Longest Palindrome** (LeetCode #409) - ⭐ Common
    - Find longest palindrome length
    - Time: O(n), Space: O(1)
    - Hint: Count characters

15. **String Compression** (LeetCode #443) - ⭐ Common
    - Compress string using counts
    - Time: O(n), Space: O(1)
    - Hint: Two pointers

### Medium Problems (15+)

1. **Longest Palindromic Substring** (LeetCode #5) - ⭐⭐⭐ Very Common
   - Find longest palindromic substring
   - Time: O(n²), Space: O(1)
   - Hint: Expand around centers

2. **Longest Substring Without Repeating Characters** (LeetCode #3) - ⭐⭐⭐ Very Common
   - Find longest substring without repeating chars
   - Time: O(n), Space: O(min(m,n))
   - Hint: Sliding window with HashMap

3. **Minimum Window Substring** (LeetCode #76) - ⭐⭐⭐ Very Common
   - Minimum window substring
   - Time: O(n), Space: O(m)
   - Hint: Sliding window with HashMap

4. **Group Anagrams** (LeetCode #49) - ⭐⭐ Common
   - Group strings that are anagrams
   - Time: O(nk), Space: O(nk)
   - Hint: Sort strings or count characters

5. **Word Break** (LeetCode #139) - ⭐⭐ Common
   - Check if string can be segmented
   - Time: O(n²), Space: O(n)
   - Hint: Dynamic programming

6. **Decode Ways** (LeetCode #91) - ⭐⭐ Common
   - Number of ways to decode string
   - Time: O(n), Space: O(1)
   - Hint: Dynamic programming

7. **Edit Distance** (LeetCode #72) - ⭐⭐ Common
   - Minimum operations to convert string
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D dynamic programming

8. **Regular Expression Matching** (LeetCode #10) - ⭐⭐ Common
   - Match string with pattern
   - Time: O(mn), Space: O(mn)
   - Hint: Dynamic programming with state machine

9. **Wildcard Matching** (LeetCode #44) - ⭐ Common
   - Match string with wildcard pattern
   - Time: O(mn), Space: O(min(m,n))
   - Hint: Dynamic programming

10. **Longest Common Subsequence** (LeetCode #1143) - ⭐ Common
    - Length of longest common subsequence
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D dynamic programming

11. **Palindrome Partitioning** (LeetCode #131) - ⭐ Common
    - Partition string into palindromes
    - Time: O(2^n), Space: O(n)
    - Hint: Backtracking with palindrome check

12. **Simplify Path** (LeetCode #71) - ⭐ Common
    - Simplify Unix path
    - Time: O(n), Space: O(n)
    - Hint: Use stack

13. **Basic Calculator** (LeetCode #224) - ⭐ Common
    - Evaluate basic arithmetic expression
    - Time: O(n), Space: O(n)
    - Hint: Stack with sign handling

14. **Basic Calculator II** (LeetCode #227) - ⭐ Common
    - Evaluate expression with +, -, *, /
    - Time: O(n), Space: O(n)
    - Hint: Stack with operator precedence

15. **Longest Repeating Character Replacement** (LeetCode #424) - ⭐ Common
    - Longest substring with same character after k replacements
    - Time: O(n), Space: O(1)
    - Hint: Sliding window with frequency

### Hard Problems (10+)

1. **Edit Distance** (LeetCode #72) - ⭐⭐⭐ Very Common
   - Minimum operations to convert string
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D dynamic programming

2. **Regular Expression Matching** (LeetCode #10) - ⭐⭐⭐ Very Common
   - Match string with pattern
   - Time: O(mn), Space: O(mn)
   - Hint: Dynamic programming with state machine

3. **Wildcard Matching** (LeetCode #44) - ⭐⭐ Common
   - Match string with wildcard pattern
   - Time: O(mn), Space: O(min(m,n))
   - Hint: Dynamic programming

4. **Longest Valid Parentheses** (LeetCode #32) - ⭐⭐ Common
   - Length of longest valid parentheses
   - Time: O(n), Space: O(n)
   - Hint: Stack or dynamic programming

5. **Minimum Window Substring** (LeetCode #76) - ⭐⭐ Common
   - Minimum window substring (duplicate in medium)
   - Time: O(n), Space: O(m)
   - Hint: Sliding window with HashMap

6. **Distinct Subsequences** (LeetCode #115) - ⭐ Common
   - Count distinct subsequences
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D dynamic programming

7. **Scramble String** (LeetCode #87) - ⭐ Common
   - Check if strings are scrambled
   - Time: O(n⁴), Space: O(n³)
   - Hint: 3D dynamic programming

8. **Interleaving String** (LeetCode #97) - ⭐ Common
   - Check if string is interleaving
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D dynamic programming

9. **Palindrome Partitioning II** (LeetCode #132) - ⭐ Common
   - Minimum cuts for palindrome partitioning
   - Time: O(n²), Space: O(n²)
   - Hint: Dynamic programming + palindrome check

10. **Word Ladder II** (LeetCode #126) - ⭐ Common
    - All shortest transformation sequences
    - Time: O(M * N), Space: O(M * N)
    - Hint: BFS + backtracking

## 💡 Problem-Solving Strategies

### Pattern Recognition
- **Sliding Window**: Substring problems, longest/shortest
- **Two Pointers**: Palindrome checking, reversing
- **Dynamic Programming**: Edit distance, longest common subsequence
- **Stack**: Parentheses matching, expression evaluation
- **HashMap**: Character counting, anagram detection

### Common Approaches
1. **Character Counting**: Use HashMap for frequency
2. **Two Pointers**: For palindrome, reversing
3. **Sliding Window**: For substring problems
4. **Dynamic Programming**: For optimization problems
5. **Backtracking**: For generation problems

## 🎯 Practice Recommendations

### For Beginners
- Start with Easy problems (Valid Palindrome, Reverse String)
- Focus on basic string operations
- Practice with 2-3 problems per day
- Time yourself (15-20 minutes per problem)

### For Intermediate
- Practice Medium problems (Longest Palindromic Substring, Word Break)
- Focus on pattern recognition
- Practice with 3-5 problems per day
- Time yourself (30-45 minutes per problem)

### For Advanced
- Practice Hard problems (Edit Distance, Regular Expression Matching)
- Focus on complex algorithms
- Practice with 2-3 problems per day
- Time yourself (45-60 minutes per problem)

## 📚 Additional Resources

- [LeetCode String Problems](https://leetcode.com/tag/string/)
- [GeeksforGeeks String Algorithms](https://www.geeksforgeeks.org/string-data-structure/)
- [HackerRank String Problems](https://www.hackerrank.com/domains/algorithms/strings)

---

**Remember**: Practice consistently, understand patterns, and optimize your solutions. Good luck! 🚀
