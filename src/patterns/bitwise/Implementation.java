package patterns.bitwise;

import java.util.*;

/**
 * Bitwise Pattern Implementation
 * 
 * This class contains essential bitwise algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class BitwisePattern {
    
    /**
     * Single number using XOR
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Single number that appears once
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    
    /**
     * Missing number using XOR
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Missing number
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = 0;
        int actual = 0;
        
        for (int i = 0; i <= n; i++) {
            expected ^= i;
        }
        
        for (int num : nums) {
            actual ^= num;
        }
        
        return expected ^ actual;
    }
    
    /**
     * Hamming distance between two numbers
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param x First number
     * @param y Second number
     * @return Hamming distance
     */
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        
        while (xor > 0) {
            distance += xor & 1;
            xor >>= 1;
        }
        
        return distance;
    }
    
    /**
     * Check if number is power of 2
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
     * Count number of 1 bits
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Number of 1 bits
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1; // Use unsigned right shift
        }
        return count;
    }
    
    /**
     * Single number II (appears once, others appear 3 times)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Single number
     */
    public static int singleNumberII(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }
    
    /**
     * Single number III (two numbers appear once)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of numbers
     * @return Array of two single numbers
     */
    public static int[] singleNumberIII(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // Find rightmost set bit
        int rightmost = xor & -xor;
        
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmost) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
    
    /**
     * Maximum XOR of two numbers
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param x First number
     * @param y Second number
     * @return Maximum XOR
     */
    public static int findMaximumXOR(int x, int y) {
        int maxXor = 0;
        for (int i = x; i <= y; i++) {
            for (int j = i; j <= y; j++) {
                maxXor = Math.max(maxXor, i ^ j);
            }
        }
        return maxXor;
    }
    
    /**
     * Generate subsets using bit manipulation
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
     * Gray code generation
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     * 
     * @param n Number of bits
     * @return List of gray codes
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
    
    /**
     * Bitwise AND of numbers range
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param left Left boundary
     * @param right Right boundary
     * @return Bitwise AND of all numbers in range
     */
    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
    
    /**
     * UTF-8 validation
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param data Array of bytes
     * @return True if valid UTF-8, false otherwise
     */
    public static boolean validUtf8(int[] data) {
        int count = 0;
        for (int byte : data) {
            if (count == 0) {
                if ((byte >> 5) == 0b110) count = 1;
                else if ((byte >> 4) == 0b1110) count = 2;
                else if ((byte >> 3) == 0b11110) count = 3;
                else if ((byte >> 7) == 1) return false;
            } else {
                if ((byte >> 6) != 0b10) return false;
                count--;
            }
        }
        return count == 0;
    }
    
    /**
     * Add two numbers without using + operator
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    
    /**
     * Subtract two numbers without using - operator
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param a First number
     * @param b Second number
     * @return Difference of a and b
     */
    public static int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
    
    /**
     * Multiply two numbers without using * operator
     * 
     * Time Complexity: O(log b)
     * Space Complexity: O(1)
     * 
     * @param a First number
     * @param b Second number
     * @return Product of a and b
     */
    public static int multiply(int a, int b) {
        int result = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                result += a;
            }
            a <<= 1;
            b >>= 1;
        }
        return result;
    }
    
    /**
     * Divide two numbers without using / operator
     * 
     * Time Complexity: O(log a)
     * Space Complexity: O(1)
     * 
     * @param dividend Dividend
     * @param divisor Divisor
     * @return Quotient
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        
        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            result += multiple;
        }
        
        return negative ? -result : result;
    }
    
    /**
     * Check if number is power of 4
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @return True if power of 4, false otherwise
     */
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }
    
    /**
     * Reverse bits
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param n Number
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
     * Main method for testing bitwise algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Bitwise Pattern Examples ===");
        
        // Test single number
        int[] nums = {2, 2, 1};
        System.out.println("Single number: " + singleNumber(nums));
        
        // Test missing number
        int[] missingNums = {3, 0, 1};
        System.out.println("Missing number: " + missingNumber(missingNums));
        
        // Test hamming distance
        System.out.println("Hamming distance: " + hammingDistance(1, 4));
        
        // Test power of 2
        System.out.println("Is power of 2: " + isPowerOfTwo(8));
        
        // Test hamming weight
        System.out.println("Hamming weight: " + hammingWeight(11));
        
        // Test single number II
        int[] numsII = {2, 2, 3, 2};
        System.out.println("Single number II: " + singleNumberII(numsII));
        
        // Test single number III
        int[] numsIII = {1, 2, 1, 3, 2, 5};
        System.out.println("Single number III: " + Arrays.toString(singleNumberIII(numsIII)));
        
        // Test maximum XOR
        System.out.println("Maximum XOR: " + findMaximumXOR(3, 7));
        
        // Test subsets
        int[] subsetNums = {1, 2, 3};
        System.out.println("Subsets: " + subsets(subsetNums));
        
        // Test gray code
        System.out.println("Gray code: " + grayCode(3));
        
        // Test range bitwise AND
        System.out.println("Range bitwise AND: " + rangeBitwiseAnd(5, 7));
        
        // Test UTF-8 validation
        int[] utf8 = {197, 130, 1};
        System.out.println("Valid UTF-8: " + validUtf8(utf8));
        
        // Test arithmetic operations
        System.out.println("Add without +: " + getSum(3, 5));
        System.out.println("Subtract without -: " + getSubtract(7, 3));
        System.out.println("Multiply without *: " + multiply(4, 5));
        System.out.println("Divide without /: " + divide(15, 3));
        
        // Test power of 4
        System.out.println("Is power of 4: " + isPowerOfFour(16));
        
        // Test reverse bits
        System.out.println("Reverse bits: " + reverseBits(43261596));
    }
}
