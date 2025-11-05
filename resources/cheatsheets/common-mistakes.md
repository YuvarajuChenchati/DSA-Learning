# Common Mistakes Cheat Sheet ⚠️

> **Quick reference for common mistakes and how to avoid them**

## 🎯 Array Mistakes

### Off-by-One Errors
- **Mistake**: Using `i <= arr.length` instead of `i < arr.length`
- **Fix**: Always use `i < arr.length` for array iteration
- **Example**:
```java
// Wrong
for (int i = 0; i <= arr.length; i++)

// Correct
for (int i = 0; i < arr.length; i++)
```

### Array Index Out of Bounds
- **Mistake**: Accessing array elements without bounds checking
- **Fix**: Always validate indices before accessing
- **Example**:
```java
// Wrong
int value = arr[index];

// Correct
if (index >= 0 && index < arr.length) {
    int value = arr[index];
}
```

### Null Pointer Exception
- **Mistake**: Not checking for null arrays
- **Fix**: Always check for null before accessing
- **Example**:
```java
// Wrong
int length = arr.length;

// Correct
if (arr != null) {
    int length = arr.length;
}
```

## 🔗 Linked List Mistakes

### Lost References
- **Mistake**: Losing reference to head during iteration
- **Fix**: Use temporary variable for iteration
- **Example**:
```java
// Wrong
while (head != null) {
    head = head.next; // Lost original head
}

// Correct
ListNode current = head;
while (current != null) {
    current = current.next;
}
```

### Circular Reference
- **Mistake**: Creating cycles unintentionally
- **Fix**: Always set next pointers carefully
- **Example**:
```java
// Wrong
node1.next = node2;
node2.next = node1; // Creates cycle

// Correct
node1.next = node2;
node2.next = null; // Proper termination
```

## 🌳 Tree Mistakes

### Infinite Recursion
- **Mistake**: Not checking for null children
- **Fix**: Always check for null before recursive calls
- **Example**:
```java
// Wrong
public void traverse(TreeNode node) {
    traverse(node.left); // NullPointerException
    traverse(node.right);
}

// Correct
public void traverse(TreeNode node) {
    if (node == null) return;
    traverse(node.left);
    traverse(node.right);
}
```

### Incorrect Base Case
- **Mistake**: Wrong base case in recursion
- **Fix**: Define clear base case
- **Example**:
```java
// Wrong
if (node.left == null) return; // Too early

// Correct
if (node == null) return; // Proper base case
```

## 📊 Dynamic Programming Mistakes

### Missing Memoization
- **Mistake**: Not using memoization for overlapping subproblems
- **Fix**: Add memoization to avoid recomputation
- **Example**:
```java
// Wrong
public int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2); // Recomputes
}

// Correct
Map<Integer, Integer> memo = new HashMap<>();
public int fibonacci(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    int result = fibonacci(n-1) + fibonacci(n-2);
    memo.put(n, result);
    return result;
}
```

### Wrong State Definition
- **Mistake**: Incorrect DP state definition
- **Fix**: Clearly define what each state represents
- **Example**:
```java
// Wrong
dp[i] = ... // Unclear what dp[i] represents

// Correct
dp[i] = maximum profit up to day i // Clear definition
```

## 🔍 Search Mistakes

### Binary Search Off-by-One
- **Mistake**: Wrong boundary conditions in binary search
- **Fix**: Use consistent boundary conditions
- **Example**:
```java
// Wrong
while (left <= right) {
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid; // Should be mid + 1
    else right = mid; // Should be mid - 1
}

// Correct
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

## 🎯 Two Pointers Mistakes

### Moving Pointers Incorrectly
- **Mistake**: Moving wrong pointer in two-pointer problems
- **Fix**: Understand when to move which pointer
- **Example**:
```java
// Wrong
if (sum < target) right--; // Should move left

// Correct
if (sum < target) left++; // Move left for larger sum
else right--; // Move right for smaller sum
```

## 🪟 Sliding Window Mistakes

### Window Size Not Maintained
- **Mistake**: Not maintaining window size correctly
- **Fix**: Track window boundaries carefully
- **Example**:
```java
// Wrong
while (right < arr.length) {
    window.add(arr[right]);
    right++;
    // Window size not maintained
}

// Correct
while (right < arr.length) {
    window.add(arr[right]);
    while (window.size() > k) {
        window.remove(arr[left]);
        left++;
    }
    right++;
}
```

## 🔄 Recursion Mistakes

### Missing Base Case
- **Mistake**: No base case or incorrect base case
- **Fix**: Always define base case first
- **Example**:
```java
// Wrong
public int factorial(int n) {
    return n * factorial(n-1); // No base case
}

// Correct
public int factorial(int n) {
    if (n <= 1) return 1; // Base case
    return n * factorial(n-1);
}
```

### Stack Overflow
- **Mistake**: Deep recursion causing stack overflow
- **Fix**: Use iterative approach or tail recursion
- **Example**:
```java
// Wrong
public int sum(int[] arr, int index) {
    if (index == arr.length) return 0;
    return arr[index] + sum(arr, index + 1); // Deep recursion
}

// Correct
public int sum(int[] arr) {
    int sum = 0;
    for (int num : arr) {
        sum += num;
    }
    return sum; // Iterative
}
```

## 🎨 Code Quality Mistakes

### Magic Numbers
- **Mistake**: Using magic numbers without explanation
- **Fix**: Use named constants
- **Example**:
```java
// Wrong
if (arr.length > 10) { // What is 10?

// Correct
private static final int MAX_SIZE = 10;
if (arr.length > MAX_SIZE) {
```

### Poor Variable Names
- **Mistake**: Using unclear variable names
- **Fix**: Use descriptive names
- **Example**:
```java
// Wrong
int x = arr.length;
int y = 0;

// Correct
int arrayLength = arr.length;
int sum = 0;
```

## ⚡ Performance Mistakes

### Unnecessary Operations
- **Mistake**: Performing unnecessary operations in loops
- **Fix**: Move constant operations outside loops
- **Example**:
```java
// Wrong
for (int i = 0; i < arr.length; i++) {
    int length = arr.length; // Computed every iteration
}

// Correct
int length = arr.length;
for (int i = 0; i < length; i++) {
    // Use length
}
```

### Inefficient Data Structures
- **Mistake**: Using wrong data structure for the task
- **Fix**: Choose appropriate data structure
- **Example**:
```java
// Wrong
List<Integer> list = new ArrayList<>();
if (list.contains(value)) { // O(n) search

// Correct
Set<Integer> set = new HashSet<>();
if (set.contains(value)) { // O(1) search
```

## 🐛 Debugging Tips

### Common Debugging Strategies
1. **Print statements**: Add print statements to track execution
2. **Use debugger**: Step through code with debugger
3. **Test with small inputs**: Start with simple test cases
4. **Check edge cases**: Test with empty, single element, null
5. **Verify assumptions**: Check if assumptions are correct

### How to Avoid Mistakes
1. **Always check edge cases**: Empty, null, single element
2. **Use descriptive names**: Make code self-documenting
3. **Add comments**: Explain complex logic
4. **Test incrementally**: Test as you code
5. **Review code**: Review before submitting

---

**Remember**: Mistakes are learning opportunities. Review common mistakes regularly to avoid them in interviews! 🚀
