# Trie (Prefix Tree) 🌳

> **Master trie data structure for efficient string operations**

## 🎯 Learning Objectives

- Understand trie fundamentals
- Master trie operations
- Learn when to use trie
- Apply trie to solve problems

## 📚 Theory

### Trie Basics

#### Properties
- **Tree structure**: Each node represents a character
- **Prefix storage**: Efficient for prefix-based operations
- **Path representation**: Each path represents a string
- **Space efficient**: Shared prefixes save space
- **Fast operations**: O(m) time for most operations

#### Common Operations
- **Insert**: Add string to trie
- **Search**: Check if string exists
- **Prefix search**: Find all strings with prefix
- **Delete**: Remove string from trie
- **Autocomplete**: Suggest completions

### When to Use Trie

#### String Operations
- **Autocomplete**: Suggest words as user types
- **Spell checker**: Check if word exists in dictionary
- **Prefix search**: Find all words with given prefix
- **Word games**: Scrabble, word search
- **IP routing**: Longest prefix matching

#### Pattern Matching
- **String matching**: Find patterns in text
- **Suffix trees**: Advanced string algorithms
- **Compression**: LZ78 algorithm
- **Bioinformatics**: DNA sequence analysis

## 🔧 Implementation

### Basic Trie Structure

```java
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    
    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;
    
    Trie() {
        root = new TrieNode();
    }
    
    // Insert word
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }
    
    // Search word
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
}
```

### Advanced Trie Operations

```java
// Prefix search
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
```

## 📝 Practice Problems

### Easy
1. **Implement Trie** - O(m) time, O(m) space
2. **Longest Common Prefix** - O(mn) time, O(m) space
3. **Word Search** - O(mn * 4^L) time, O(L) space
4. **Valid Word Square** - O(n²) time, O(n) space
5. **Add and Search Word** - O(m) time, O(m) space

### Medium
1. **Word Search II** - O(mn * 4^L) time, O(L) space
2. **Prefix and Suffix Search** - O(m) time, O(m) space
3. **Replace Words** - O(m) time, O(m) space
4. **Map Sum Pairs** - O(m) time, O(m) space
5. **Shortest Word Distance II** - O(m) time, O(m) space

### Hard
1. **Word Search II** - O(mn * 4^L) time, O(L) space
2. **Palindrome Pairs** - O(n² * m) time, O(n * m) space
3. **Word Squares** - O(n * m^n) time, O(n * m) space
4. **Maximum XOR of Two Numbers** - O(n * m) time, O(n * m) space
5. **Concatenated Words** - O(n * m²) time, O(n * m) space

## 💡 Key Insights

- **Space optimization**: Shared prefixes save space
- **Fast lookups**: O(m) time for most operations
- **Prefix operations**: Natural for prefix-based problems
- **Memory trade-off**: More memory for faster operations
- **Path representation**: Each path represents a string

## ⚠️ Common Mistakes

### Not Handling Empty Strings
- **Problem**: Not handling empty strings in trie
- **Solution**: Mark root as end of word for empty strings or handle separately
- **Example**: Check `word.isEmpty()` before inserting

### Memory Leaks
- **Problem**: Not cleaning up unused nodes
- **Solution**: Remove nodes when no longer needed or use weak references
- **Example**: Implement `delete()` method to remove nodes

### Not Marking End of Word
- **Problem**: Not marking which nodes represent end of words
- **Solution**: Use boolean flag `isEndOfWord` to mark word endings
- **Example**: `node.isEndOfWord = true;` when inserting complete word

### Incorrect Character Mapping
- **Problem**: Wrong character to index mapping
- **Solution**: Use `char - 'a'` for lowercase, handle different cases
- **Example**: `int index = ch - 'a';` for lowercase letters

### Not Handling Case Sensitivity
- **Problem**: Not handling case differences correctly
- **Solution**: Convert to lowercase/uppercase or use larger array
- **Example**: Convert all strings to lowercase before inserting

### Wrong Search Implementation
- **Problem**: Not distinguishing between prefix and word search
- **Solution**: Use separate methods for prefix search and exact word search
- **Example**: `searchPrefix()` returns true if prefix exists, `searchWord()` checks isEndOfWord

### Memory Inefficiency
- **Problem**: Using fixed-size array for all children
- **Solution**: Use HashMap for children or compressed trie for space optimization
- **Example**: `Map<Character, TrieNode> children = new HashMap<>();` for variable children

### Not Handling Special Characters
- **Problem**: Not handling Unicode or special characters
- **Solution**: Use HashMap for children or larger array for Unicode support
- **Example**: Use HashMap for characters beyond ASCII range

## 🎯 Interview Tips

- Always consider space complexity
- Use trie for prefix-based problems
- Consider compressed trie for space optimization
- Think about edge cases (empty strings, single characters)
- Use trie for autocomplete features

## 📚 Additional Resources

- [Trie Data Structure](https://www.geeksforgeeks.org/trie-insert-and-search/)
- [Prefix Tree](https://en.wikipedia.org/wiki/Trie)
- [Trie Applications](https://www.geeksforgeeks.org/applications-of-trie-data-structure/)
- [Compressed Trie](https://www.geeksforgeeks.org/compressed-tries/)
