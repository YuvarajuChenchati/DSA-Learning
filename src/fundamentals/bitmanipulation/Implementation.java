package fundamentals.bitmanipulation;

import java.util.*;

/**
 * Bit Manipulation Implementation
 * 
 * This class contains essential bit manipulation algorithms and techniques
 * commonly used in competitive programming and technical interviews.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class BitManipulation {
    
    /**
     * Check if a specific bit is set
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @param i Bit position (0-indexed)
     * @return True if bit is set, false otherwise
     */
    public static boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }
    
    /**
     * Set a specific bit
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to modify
     * @param i Bit position (0-indexed)
     * @return Number with bit set
     */
    public static int setBit(int n, int i) {
        return n | (1 << i);
    }
    
    /**
     * Clear a specific bit
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to modify
     * @param i Bit position (0-indexed)
     * @return Number with bit cleared
     */
    public static int clearBit(int n, int i) {
        return n & ~(1 << i);
    }
    
    /**
     * Toggle a specific bit
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to modify
     * @param i Bit position (0-indexed)
     * @return Number with bit toggled
     */
    public static int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }
    
    /**
     * Get the rightmost set bit
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Position of rightmost set bit (0-indexed)
     */
    public static int getRightmostSetBit(int n) {
        return n & -n;
    }
    
    /**
     * Clear the rightmost set bit
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to modify
     * @return Number with rightmost set bit cleared
     */
    public static int clearRightmostSetBit(int n) {
        return n & (n - 1);
    }
    
    /**
     * Count the number of set bits (Hamming weight)
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param n Number to count
     * @return Number of set bits
     */
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1); // Clear rightmost set bit
        }
        return count;
    }
    
    /**
     * Count set bits using built-in method
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to count
     * @return Number of set bits
     */
    public static int countSetBitsBuiltin(int n) {
        return Integer.bitCount(n);
    }
    
    /**
     * Check if a number is a power of 2
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @return True if power of 2, false otherwise
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    /**
     * Get the next power of 2
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Next power of 2 greater than or equal to n
     */
    public static int nextPowerOfTwo(int n) {
        if (n <= 0) return 1;
        if (isPowerOfTwo(n)) return n;
        
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n + 1;
    }
    
    /**
     * Reverse bits of a number
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to reverse
     * @return Number with reversed bits
     */
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
    
    /**
     * Find the single number in array where all others appear twice
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Single number
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    
    /**
     * Find the missing number in array containing n distinct numbers from 0 to n
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
     * Find the missing number using XOR
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Missing number
     */
    public static int missingNumberXOR(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }
    
    /**
     * Find two single numbers in array where all others appear twice
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Array containing the two single numbers
     */
    public static int[] singleNumberIII(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // Find the rightmost set bit
        int rightmostSetBit = xor & -xor;
        
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
    
    /**
     * Generate all subsets using bit manipulation
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param nums Array of numbers
     * @return List of all subsets
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
    
    /**
     * Generate Gray code
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param n Number of bits
     * @return List of Gray code numbers
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
    
    /**
     * Find the maximum XOR of two numbers in array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Maximum XOR value
     */
    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            
            for (int num : nums) {
                set.add(num & mask);
            }
            
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    max = temp;
                    break;
                }
            }
        }
        
        return max;
    }
    
    /**
     * Check if a number is even using bit manipulation
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @return True if even, false otherwise
     */
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }
    
    /**
     * Check if a number is odd using bit manipulation
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @return True if odd, false otherwise
     */
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
    
    /**
     * Multiply by 2 using left shift
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to multiply
     * @return Number multiplied by 2
     */
    public static int multiplyByTwo(int n) {
        return n << 1;
    }
    
    /**
     * Divide by 2 using right shift
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to divide
     * @return Number divided by 2
     */
    public static int divideByTwo(int n) {
        return n >> 1;
    }
    
    /**
     * Check if two numbers have opposite signs
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param a First number
     * @param b Second number
     * @return True if opposite signs, false otherwise
     */
    public static boolean hasOppositeSigns(int a, int b) {
        return (a ^ b) < 0;
    }
    
    /**
     * Get the absolute value without branching
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Absolute value
     */
    public static int abs(int n) {
        int mask = n >> 31;
        return (n + mask) ^ mask;
    }
    
    /**
     * Swap two numbers using XOR
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param a First number
     * @param b Second number
     * @return Array with swapped numbers
     */
    public static int[] swapNumbers(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a, b};
    }
    
    /**
     * Main method for testing bit manipulation functions
     */
    public static void main(String[] args) {
        System.out.println("=== Bit Manipulation Examples ===");
        
        int n = 42; // Binary: 101010
        System.out.println("Number: " + n + " (Binary: " + Integer.toBinaryString(n) + ")");
        
        // Basic operations
        System.out.println("Bit 0 is set: " + isBitSet(n, 0));
        System.out.println("Bit 1 is set: " + isBitSet(n, 1));
        System.out.println("Set bit 0: " + setBit(n, 0));
        System.out.println("Clear bit 1: " + clearBit(n, 1));
        System.out.println("Toggle bit 2: " + toggleBit(n, 2));
        
        // Bit tricks
        System.out.println("Rightmost set bit: " + getRightmostSetBit(n));
        System.out.println("Clear rightmost set bit: " + clearRightmostSetBit(n));
        System.out.println("Count set bits: " + countSetBits(n));
        System.out.println("Is power of 2: " + isPowerOfTwo(n));
        System.out.println("Next power of 2: " + nextPowerOfTwo(n));
        System.out.println("Reverse bits: " + reverseBits(n));
        
        // Number properties
        System.out.println("Is even: " + isEven(n));
        System.out.println("Is odd: " + isOdd(n));
        System.out.println("Multiply by 2: " + multiplyByTwo(n));
        System.out.println("Divide by 2: " + divideByTwo(n));
        
        // XOR examples
        int[] nums = {1, 2, 3, 2, 1};
        System.out.println("Single number in [1,2,3,2,1]: " + singleNumber(nums));
        
        int[] missing = {0, 1, 3, 4, 5};
        System.out.println("Missing number in [0,1,3,4,5]: " + missingNumber(missing));
        
        // Subsets
        int[] subsetNums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(subsetNums);
        System.out.println("Subsets of [1,2,3]: " + subsets);
        
        // Gray code
        List<Integer> gray = grayCode(3);
        System.out.println("Gray code for 3 bits: " + gray);
        
        // Advanced examples
        int[] xorNums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR in [3,10,5,25,2,8]: " + findMaximumXOR(xorNums));
        
        // Sign operations
        System.out.println("Has opposite signs (5, -3): " + hasOppositeSigns(5, -3));
        System.out.println("Absolute value of -42: " + abs(-42));
        
        // Swap
        int[] swapped = swapNumbers(10, 20);
        System.out.println("Swap 10 and 20: " + swapped[0] + ", " + swapped[1]);
    }
}
