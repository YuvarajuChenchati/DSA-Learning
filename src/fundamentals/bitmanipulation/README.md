# Bit Manipulation 🔢

> **Master bitwise operations for efficient algorithms and optimization**

## 🎯 Learning Objectives

- Understand bitwise operations
- Master common bit manipulation techniques
- Apply bit manipulation to solve problems
- Optimize algorithms using bit operations

## 📚 Theory

### Bitwise Operations

#### Basic Operations
- **AND (&)**: Both bits must be 1
- **OR (|)**: At least one bit must be 1
- **XOR (^)**: Bits must be different
- **NOT (~)**: Flip all bits
- **Left Shift (<<)**: Multiply by 2
- **Right Shift (>>)**: Divide by 2

#### Common Bit Tricks
- **Check if bit is set**: `n & (1 << i)`
- **Set bit**: `n | (1 << i)`
- **Clear bit**: `n & ~(1 << i)`
- **Toggle bit**: `n ^ (1 << i)`
- **Get rightmost set bit**: `n & -n`
- **Clear rightmost set bit**: `n & (n - 1)`

## 🔧 Implementation

### Basic Bit Operations

```java
// Check if bit is set
public static boolean isBitSet(int n, int i) {
    return (n & (1 << i)) != 0;
}

// Set bit
public static int setBit(int n, int i) {
    return n | (1 << i);
}

// Clear bit
public static int clearBit(int n, int i) {
    return n & ~(1 << i);
}

// Toggle bit
public static int toggleBit(int n, int i) {
    return n ^ (1 << i);
}
```

### Common Bit Tricks

```java
// Get rightmost set bit
public static int getRightmostSetBit(int n) {
    return n & -n;
}

// Clear rightmost set bit
public static int clearRightmostSetBit(int n) {
    return n & (n - 1);
}

// Count set bits
public static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        count++;
        n &= (n - 1);
    }
    return count;
}
```

## 📝 Practice Problems

### Easy
1. **Single Number** - O(n) time, O(1) space
2. **Missing Number** - O(n) time, O(1) space
3. **Number of 1 Bits** - O(1) time, O(1) space
4. **Reverse Bits** - O(1) time, O(1) space
5. **Power of Two** - O(1) time, O(1) space

### Medium
1. **Single Number II** - O(n) time, O(1) space
2. **Single Number III** - O(n) time, O(1) space
3. **Maximum XOR of Two Numbers** - O(n) time, O(1) space
4. **Subsets** - O(2^n) time, O(2^n) space
5. **Gray Code** - O(2^n) time, O(2^n) space

### Hard
1. **Maximum XOR of Two Numbers in Array** - O(n) time, O(n) space
2. **Repeated DNA Sequences** - O(n) time, O(n) space
3. **Bitwise AND of Numbers Range** - O(1) time, O(1) space
4. **UTF-8 Validation** - O(n) time, O(1) space
5. **Maximum Product of Word Lengths** - O(n²) time, O(n) space

## 💡 Key Insights

- **XOR properties**: a ^ a = 0, a ^ 0 = a
- **Bit manipulation**: Often more efficient than arithmetic
- **Masking**: Use bit masks to extract specific bits
- **Shifting**: Left shift multiplies by 2, right shift divides by 2
- **Two's complement**: Negative numbers in binary

## 🎯 Interview Tips

- Know basic bit operations
- Understand XOR properties
- Practice common bit tricks
- Use bit manipulation for optimization
- Consider space-time tradeoffs

## 📚 Additional Resources

- [Bit Manipulation Tutorial](https://www.geeksforgeeks.org/bit-manipulation/)
- [XOR Properties](https://en.wikipedia.org/wiki/Exclusive_or)
- [Two's Complement](https://en.wikipedia.org/wiki/Two%27s_complement)
- [Bit Manipulation Problems](https://leetcode.com/tag/bit-manipulation/)
