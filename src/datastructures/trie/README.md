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
