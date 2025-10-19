# Mathematics for DSA 🧮

> **Essential mathematical concepts for competitive programming and technical interviews**

## 🎯 Learning Objectives

- Master number theory basics
- Understand modular arithmetic
- Learn prime number algorithms
- Apply mathematical concepts to DSA problems

## 📚 Theory

### Number Theory Basics

#### Divisibility
- **Divisor**: A number that divides another number without remainder
- **Multiple**: A number that is the product of another number
- **GCD**: Greatest Common Divisor of two numbers
- **LCM**: Least Common Multiple of two numbers

#### Prime Numbers
- **Prime**: A number greater than 1 that has no positive divisors other than 1 and itself
- **Composite**: A number that has more than two positive divisors
- **Sieve of Eratosthenes**: Algorithm to find all primes up to n

#### Modular Arithmetic
- **Modulo**: The remainder when one number is divided by another
- **Congruence**: Two numbers are congruent if they have the same remainder
- **Properties**: (a + b) mod m = ((a mod m) + (b mod m)) mod m

## 🔧 Implementation

### GCD and LCM

```java
// Euclidean Algorithm for GCD
public static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

// LCM using GCD
public static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}
```

### Prime Number Algorithms

```java
// Check if a number is prime
public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) {
            return false;
        }
    }
    return true;
}

// Sieve of Eratosthenes
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
```

### Modular Arithmetic

```java
// Modular exponentiation
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

// Modular inverse using extended Euclidean algorithm
public static long modInverse(long a, long m) {
    long[] result = extendedGcd(a, m);
    if (result[0] != 1) {
        throw new ArithmeticException("Modular inverse doesn't exist");
    }
    return (result[1] % m + m) % m;
}
```

## 📝 Practice Problems

### Easy
1. **Check Prime** - O(√n) time
2. **GCD of Two Numbers** - O(log min(a,b)) time
3. **LCM of Two Numbers** - O(log min(a,b)) time
4. **Sum of Digits** - O(log n) time
5. **Reverse Number** - O(log n) time

### Medium
1. **Prime Factorization** - O(√n) time
2. **Count Primes** - O(n log log n) time
3. **Power of Two** - O(1) time
4. **Perfect Square** - O(√n) time
5. **Factorial Trailing Zeros** - O(log n) time

### Hard
1. **Count Primes in Range** - O(n log log n) time
2. **Prime Factorization of Range** - O(n log n) time
3. **Modular Exponentiation** - O(log exp) time
4. **Chinese Remainder Theorem** - O(n log n) time
5. **Euler's Totient Function** - O(√n) time

## 💡 Key Insights

- **Prime checking**: Only check divisors up to √n
- **GCD**: Use Euclidean algorithm for efficiency
- **Modular arithmetic**: Useful for large numbers
- **Sieve**: Efficient for finding all primes up to n
- **Number theory**: Foundation for many advanced algorithms

## 🎯 Interview Tips

- Know basic number theory concepts
- Understand time complexity of mathematical operations
- Practice modular arithmetic
- Learn prime number algorithms
- Apply mathematical concepts to optimization problems

## 📚 Additional Resources

- [Number Theory for Competitive Programming](https://cp-algorithms.com/algebra/)
- [Prime Number Algorithms](https://www.geeksforgeeks.org/prime-numbers/)
- [Modular Arithmetic](https://brilliant.org/wiki/modular-arithmetic/)
- [Euclidean Algorithm](https://en.wikipedia.org/wiki/Euclidean_algorithm)
