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

## ⚠️ Common Mistakes

### Right Shift vs Unsigned Right Shift
- **Problem**: Confusing `>>` (signed) with `>>>` (unsigned) right shift
- **Solution**: Use `>>` for signed numbers, `>>>` for unsigned
- **Example**: `-1 >> 1` gives -1, but `-1 >>> 1` gives a large positive number

### Operator Precedence
- **Problem**: Not using parentheses with bitwise operators
- **Solution**: Use parentheses to avoid precedence issues
- **Example**: `n & 1 == 0` is wrong, use `(n & 1) == 0`

### Sign Extension Issues
- **Problem**: Not handling negative numbers correctly
- **Solution**: Consider two's complement representation
- **Example**: Right shift on negative numbers fills with 1s (sign extension)

### Bit Index Confusion
- **Problem**: Confusing 0-indexed vs 1-indexed bit positions
- **Solution**: Always use 0-indexed (LSB is bit 0)
- **Example**: Bit 0 is rightmost, bit 31 is leftmost for 32-bit integers

### XOR Properties Misuse
- **Problem**: Not understanding XOR properties
- **Solution**: Remember: a ^ a = 0, a ^ 0 = a, XOR is commutative and associative
- **Example**: Use XOR to find single number in array of duplicates

### Overflow in Bit Shifts
- **Problem**: Shifting beyond data type width
- **Solution**: Check shift amount is within valid range
- **Example**: For 32-bit int, shift amount should be 0-31

### Not Clearing Bits Properly
- **Problem**: Using wrong mask to clear bits
- **Solution**: Use `n & ~(1 << i)` to clear bit, `n & (n - 1)` to clear rightmost set bit
- **Example**: Clear bit 3: `n & ~(1 << 3)`, not `n & (1 << 3)`

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
