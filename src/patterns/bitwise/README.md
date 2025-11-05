# Bitwise Pattern 🔢

> **Master bitwise operations for efficient problem solving**

## 🎯 Learning Objectives

- Understand bitwise operations
- Master common bit manipulation patterns
- Learn when to use bitwise operations
- Apply bitwise patterns to solve problems

## 📚 Theory

### Bitwise Operations Basics

#### Properties
- **AND (&)**: Both bits must be 1
- **OR (|)**: At least one bit must be 1
- **XOR (^)**: Bits must be different
- **NOT (~)**: Flip all bits
- **Left shift (<<)**: Multiply by 2
- **Right shift (>>)**: Divide by 2

#### Common Patterns
- **XOR properties**: a ^ a = 0, a ^ 0 = a
- **Power of 2**: n & (n-1) == 0
- **Set bit**: n | (1 << i)
- **Clear bit**: n & ~(1 << i)
- **Toggle bit**: n ^ (1 << i)

### When to Use Bitwise Operations

#### Optimization Problems
- **Bit manipulation**: Direct bit operations
- **Set operations**: Union, intersection, difference
- **Counting**: Count set bits, parity
- **Swapping**: Swap without temporary variable
- **Arithmetic**: Add without plus operator

#### Common Bitwise Problems
- **Single number**: Find unique element
- **Missing number**: Find missing in sequence
- **Hamming distance**: Count different bits
- **Power of 2**: Check if number is power of 2
- **Bit counting**: Count set bits

## 🔧 Implementation

### Basic Bitwise Template

```java
// Check if bit is set
public boolean isBitSet(int n, int i) {
    return (n & (1 << i)) != 0;
}

// Set bit
public int setBit(int n, int i) {
    return n | (1 << i);
}

// Clear bit
public int clearBit(int n, int i) {
    return n & ~(1 << i);
}

// Toggle bit
public int toggleBit(int n, int i) {
    return n ^ (1 << i);
}
```

### Advanced Bitwise Patterns

```java
// Count set bits
public int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}

// Find single number using XOR
public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result ^= num;
    }
    return result;
}
```

## 📝 Practice Problems

### Easy
1. **Single Number** - O(n) time, O(1) space
2. **Missing Number** - O(n) time, O(1) space
3. **Hamming Distance** - O(1) time, O(1) space
4. **Power of Two** - O(1) time, O(1) space
5. **Number of 1 Bits** - O(1) time, O(1) space

### Medium
1. **Single Number II** - O(n) time, O(1) space
2. **Single Number III** - O(n) time, O(1) space
3. **Maximum XOR of Two Numbers** - O(n) time, O(n) space
4. **Subsets** - O(2^n) time, O(2^n) space
5. **Gray Code** - O(2^n) time, O(2^n) space

### Hard
1. **Maximum XOR of Two Numbers in Array** - O(n) time, O(n) space
2. **Repeated DNA Sequences** - O(n) time, O(n) space
3. **Bitwise AND of Numbers Range** - O(1) time, O(1) space
4. **UTF-8 Validation** - O(n) time, O(1) space
5. **Number of Islands II** - O(k) time, O(m*n) space

## 💡 Key Insights

- **XOR properties**: Use for finding unique elements
- **Bit masks**: Use for set operations
- **Power of 2**: Use n & (n-1) == 0
- **Set operations**: Use bitwise for union, intersection
- **Optimization**: Often faster than arithmetic operations

## ⚠️ Common Mistakes

### Operator Precedence
- **Problem**: Not using parentheses with bitwise operators
- **Solution**: Use parentheses to avoid precedence issues
- **Example**: `(n & 1) == 0` not `n & 1 == 0`

### Wrong XOR Properties
- **Problem**: Not understanding XOR properties
- **Solution**: Remember: a ^ a = 0, a ^ 0 = a, XOR is commutative
- **Example**: Use XOR to find single number: `result ^= nums[i];`

### Sign Extension Issues
- **Problem**: Not handling negative numbers correctly
- **Solution**: Consider two's complement representation
- **Example**: Right shift on negative numbers fills with 1s (sign extension)

### Bit Index Confusion
- **Problem**: Confusing 0-indexed vs 1-indexed bit positions
- **Solution**: Always use 0-indexed (LSB is bit 0)
- **Example**: Bit 0 is rightmost, bit 31 is leftmost for 32-bit integers

### Overflow in Bit Shifts
- **Problem**: Shifting beyond data type width
- **Solution**: Check shift amount is within valid range
- **Example**: For 32-bit int, shift amount should be 0-31

### Wrong Bit Mask
- **Problem**: Using wrong bit mask for operations
- **Solution**: Use correct mask: `1 << i` for set, `~(1 << i)` for clear
- **Example**: Set bit i: `n | (1 << i)`, clear bit i: `n & ~(1 << i)`

### Not Handling Edge Cases
- **Problem**: Not handling zero or negative numbers
- **Solution**: Always check edge cases first
- **Example**: `if (n == 0) return 0;` before bit operations

## 🎯 Interview Tips

- Always consider bitwise solutions for optimization
- Use XOR for finding unique elements
- Consider bit masks for set operations
- Think about space optimization
- Use bitwise for arithmetic operations

## 📚 Additional Resources

- [Bit Manipulation](https://www.geeksforgeeks.org/bit-manipulation/)
- [Bitwise Operations](https://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/)
- [XOR Properties](https://www.geeksforgeeks.org/xor-properties/)
- [Bit Counting](https://www.geeksforgeeks.org/count-set-bits-in-an-integer/)
