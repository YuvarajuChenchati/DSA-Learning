# Hashing 🔐

> **Master hash tables and hash-based algorithms**

## 🎯 Learning Objectives

- Understand hashing fundamentals
- Master hash table operations
- Learn hash-based algorithms
- Apply hashing patterns to solve problems

## 📚 Theory

### Hashing Basics

#### Properties
- **Key-Value Storage**: Efficient key-value mapping
- **Average O(1) Access**: Constant time operations
- **Hash Function**: Maps keys to indices
- **Collision Handling**: Multiple keys to same index
- **Load Factor**: Ratio of elements to capacity

#### Common Operations
- **Insert**: O(1) average, O(n) worst case
- **Search**: O(1) average, O(n) worst case
- **Delete**: O(1) average, O(n) worst case
- **Size**: O(1) time - get number of elements

### Hash Table Implementations

#### Chaining
- **Collision Resolution**: Linked lists at each index
- **Space**: O(n + m) where m is table size
- **Time**: O(1 + α) where α is load factor

#### Open Addressing
- **Linear Probing**: Check next available slot
- **Quadratic Probing**: Check slots with quadratic sequence
- **Double Hashing**: Use second hash function

## 🔧 Implementation

### Basic Hash Table Operations

```java
// Hash table with chaining
class HashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    
    private List<Entry<K, V>>[] table;
    private int size;
    private int capacity;
    
    public HashTable() {
        this.capacity = INITIAL_CAPACITY;
        this.table = new List[capacity];
        this.size = 0;
    }
    
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }
        
        // Check if key already exists
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        table[index].add(new Entry<>(key, value));
        size++;
        
        if (size > capacity * LOAD_FACTOR) {
            resize();
        }
    }
    
    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) return null;
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
```

## 📝 Practice Problems

### Easy
1. **Two Sum** - O(n) time, O(n) space
2. **Valid Anagram** - O(n) time, O(1) space
3. **First Unique Character** - O(n) time, O(1) space
4. **Group Anagrams** - O(nk log k) time, O(nk) space
5. **Contains Duplicate** - O(n) time, O(n) space

### Medium
1. **Longest Substring Without Repeating Characters** - O(n) time, O(1) space
2. **Longest Consecutive Sequence** - O(n) time, O(n) space
3. **Copy List with Random Pointer** - O(n) time, O(n) space
4. **Insert Delete GetRandom O(1)** - O(1) time, O(n) space
5. **Design HashMap** - O(1) time, O(n) space

### Hard
1. **LRU Cache** - O(1) time, O(n) space
2. **LFU Cache** - O(1) time, O(n) space
3. **Design Twitter** - O(1) time, O(n) space
4. **Design Underground System** - O(1) time, O(n) space
5. **Design Browser History** - O(1) time, O(n) space

## 💡 Key Insights

- **Hash function**: Should distribute keys uniformly
- **Collision handling**: Choose appropriate strategy
- **Load factor**: Maintain for performance
- **Resizing**: Double capacity when needed
- **Hash codes**: Override equals and hashCode together

## 🎯 Interview Tips

- Consider collision resolution strategies
- Think about hash function quality
- Consider space-time tradeoffs
- Use hash tables for frequency counting
- Apply for O(1) lookup problems

## 📚 Additional Resources

- [Hash Table Data Structure](https://www.geeksforgeeks.org/hashing-data-structure/)
- [Hash Functions](https://www.geeksforgeeks.org/hash-functions/)
- [Collision Resolution](https://www.geeksforgeeks.org/hashing-set-2-separate-chaining/)
- [Load Factor](https://www.geeksforgeeks.org/load-factor-and-rehashing/)
