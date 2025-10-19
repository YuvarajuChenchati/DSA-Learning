package fundamentals.mathematics;

import java.util.*;

/**
 * Mathematics Implementation for DSA
 * 
 * This class contains essential mathematical algorithms and concepts
 * commonly used in competitive programming and technical interviews.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class Mathematics {
    
    /**
     * Calculate Greatest Common Divisor using Euclidean Algorithm
     * 
     * Time Complexity: O(log min(a, b))
     * Space Complexity: O(log min(a, b)) - recursion depth
     * 
     * @param a First number
     * @param b Second number
     * @return GCD of a and b
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    /**
     * Calculate Greatest Common Divisor iteratively
     * 
     * Time Complexity: O(log min(a, b))
     * Space Complexity: O(1)
     * 
     * @param a First number
     * @param b Second number
     * @return GCD of a and b
     */
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Calculate Least Common Multiple
     * 
     * Time Complexity: O(log min(a, b))
     * Space Complexity: O(1)
     * 
     * @param a First number
     * @param b Second number
     * @return LCM of a and b
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    /**
     * Check if a number is prime
     * 
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @return True if prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        // Check divisors of form 6k ± 1
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Sieve of Eratosthenes - Find all primes up to n
     * 
     * Time Complexity: O(n log log n)
     * Space Complexity: O(n)
     * 
     * @param n Upper limit
     * @return Boolean array where isPrime[i] is true if i is prime
     */
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    
    /**
     * Count number of primes up to n using sieve
     * 
     * Time Complexity: O(n log log n)
     * Space Complexity: O(n)
     * 
     * @param n Upper limit
     * @return Count of primes up to n
     */
    public static int countPrimes(int n) {
        if (n < 2) return 0;
        
        boolean[] isPrime = sieveOfEratosthenes(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Prime factorization of a number
     * 
     * Time Complexity: O(√n)
     * Space Complexity: O(log n) - number of prime factors
     * 
     * @param n Number to factorize
     * @return Map of prime factors and their exponents
     */
    public static Map<Integer, Integer> primeFactorization(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        
        // Check for 2
        while (n % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            n /= 2;
        }
        
        // Check for odd divisors
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        
        // If n is still greater than 1, it's a prime factor
        if (n > 1) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }
        
        return factors;
    }
    
    /**
     * Calculate sum of digits
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Sum of digits
     */
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    /**
     * Reverse a number
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param n Number to reverse
     * @return Reversed number
     */
    public static int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
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
     * Check if a number is a perfect square
     * 
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @return True if perfect square, false otherwise
     */
    public static boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    
    /**
     * Calculate factorial
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Factorial of n
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Result too large for long");
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Count trailing zeros in factorial
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return Number of trailing zeros in n!
     */
    public static int countTrailingZeros(int n) {
        int count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
    
    /**
     * Modular exponentiation
     * 
     * Time Complexity: O(log exp)
     * Space Complexity: O(1)
     * 
     * @param base Base number
     * @param exp Exponent
     * @param mod Modulus
     * @return (base^exp) mod mod
     */
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        
        return result;
    }
    
    /**
     * Extended Euclidean Algorithm
     * 
     * Time Complexity: O(log min(a, b))
     * Space Complexity: O(log min(a, b))
     * 
     * @param a First number
     * @param b Second number
     * @return Array [gcd, x, y] where ax + by = gcd(a, b)
     */
    public static long[] extendedGcd(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0};
        }
        
        long[] result = extendedGcd(b, a % b);
        long gcd = result[0];
        long x = result[2];
        long y = result[1] - (a / b) * result[2];
        
        return new long[]{gcd, x, y};
    }
    
    /**
     * Modular inverse using extended Euclidean algorithm
     * 
     * Time Complexity: O(log a)
     * Space Complexity: O(log a)
     * 
     * @param a Number
     * @param m Modulus
     * @return Modular inverse of a mod m
     */
    public static long modInverse(long a, long m) {
        long[] result = extendedGcd(a, m);
        if (result[0] != 1) {
            throw new ArithmeticException("Modular inverse doesn't exist");
        }
        return (result[1] % m + m) % m;
    }
    
    /**
     * Check if two numbers are coprime
     * 
     * Time Complexity: O(log min(a, b))
     * Space Complexity: O(log min(a, b))
     * 
     * @param a First number
     * @param b Second number
     * @return True if coprime, false otherwise
     */
    public static boolean isCoprime(int a, int b) {
        return gcd(a, b) == 1;
    }
    
    /**
     * Calculate Euler's totient function
     * 
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     * 
     * @param n Number
     * @return φ(n) - count of numbers coprime to n
     */
    public static int eulerTotient(int n) {
        int result = n;
        
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        
        if (n > 1) {
            result -= result / n;
        }
        
        return result;
    }
    
    /**
     * Generate all divisors of a number
     * 
     * Time Complexity: O(√n)
     * Space Complexity: O(√n)
     * 
     * @param n Number
     * @return List of all divisors
     */
    public static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        
        Collections.sort(divisors);
        return divisors;
    }
    
    /**
     * Check if a number is a palindrome
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param n Number to check
     * @return True if palindrome, false otherwise
     */
    public static boolean isPalindrome(int n) {
        if (n < 0) return false;
        return n == reverseNumber(n);
    }
    
    /**
     * Main method for testing mathematical functions
     */
    public static void main(String[] args) {
        System.out.println("=== Mathematics for DSA ===");
        
        // Test GCD and LCM
        System.out.println("GCD(48, 18): " + gcd(48, 18));
        System.out.println("LCM(48, 18): " + lcm(48, 18));
        
        // Test prime checking
        System.out.println("Is 17 prime? " + isPrime(17));
        System.out.println("Is 25 prime? " + isPrime(25));
        
        // Test sieve
        boolean[] primes = sieveOfEratosthenes(30);
        System.out.print("Primes up to 30: ");
        for (int i = 2; i <= 30; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Test prime factorization
        Map<Integer, Integer> factors = primeFactorization(60);
        System.out.println("Prime factors of 60: " + factors);
        
        // Test other functions
        System.out.println("Sum of digits of 12345: " + sumOfDigits(12345));
        System.out.println("Reverse of 12345: " + reverseNumber(12345));
        System.out.println("Is 16 power of 2? " + isPowerOfTwo(16));
        System.out.println("Is 25 perfect square? " + isPerfectSquare(25));
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Trailing zeros in 100!: " + countTrailingZeros(100));
        System.out.println("Is 121 palindrome? " + isPalindrome(121));
        
        // Test modular arithmetic
        System.out.println("2^10 mod 7: " + modPow(2, 10, 7));
        System.out.println("Modular inverse of 3 mod 7: " + modInverse(3, 7));
        
        // Test divisors
        List<Integer> divisors = getDivisors(12);
        System.out.println("Divisors of 12: " + divisors);
        
        // Test Euler's totient
        System.out.println("φ(12): " + eulerTotient(12));
    }
}
