# Complexity Analysis Problems 📊

> **Practice problems to master time and space complexity analysis**

## 🎯 Easy Problems

### 1. Array Sum
**Problem**: Calculate the sum of all elements in an array.

**Approach**: Iterate through the array once, adding each element to a running sum.

**Time Complexity**: O(n) - Must visit each element once
**Space Complexity**: O(1) - Only using a constant amount of extra space

```java
public int arraySum(int[] arr) {
    int sum = 0;
    for (int num : arr) {
        sum += num;
    }
    return sum;
}
```

### 2. Find Maximum Element
**Problem**: Find the maximum element in an array.

**Approach**: Iterate through the array once, keeping track of the maximum element seen so far.

**Time Complexity**: O(n) - Must check each element once
**Space Complexity**: O(1) - Only using a constant amount of extra space

```java
public int findMax(int[] arr) {
    if (arr.length == 0) return Integer.MIN_VALUE;
    
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
```

### 3. Linear Search
**Problem**: Search for a target element in an array.

**Approach**: Iterate through the array until the target is found or the end is reached.

**Time Complexity**: O(n) - Worst case must check each element
**Space Complexity**: O(1) - Only using a constant amount of extra space

```java
public int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

### 4. Count Occurrences
**Problem**: Count how many times a target element appears in an array.

**Approach**: Iterate through the array, incrementing a counter when the target is found.

**Time Complexity**: O(n) - Must check each element once
**Space Complexity**: O(1) - Only using a constant amount of extra space

```java
public int countOccurrences(int[] arr, int target) {
    int count = 0;
    for (int num : arr) {
        if (num == target) {
            count++;
        }
    }
    return count;
}
```

## 🎯 Medium Problems

### 5. Two Sum
**Problem**: Find two numbers in an array that sum to a target value.

**Approach**: Use a hash map to store complements, allowing O(1) lookup for each element.

**Time Complexity**: O(n) - Single pass through the array
**Space Complexity**: O(n) - Hash map can store up to n elements

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

### 6. Remove Duplicates
**Problem**: Remove duplicates from a sorted array in-place.

**Approach**: Use two pointers - one for reading, one for writing unique elements.

**Time Complexity**: O(n) - Single pass through the array
**Space Complexity**: O(1) - Modifying array in-place

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int writeIndex = 1;
    for (int readIndex = 1; readIndex < nums.length; readIndex++) {
        if (nums[readIndex] != nums[readIndex - 1]) {
            nums[writeIndex] = nums[readIndex];
            writeIndex++;
        }
    }
    return writeIndex;
}
```

### 7. Merge Sorted Arrays
**Problem**: Merge two sorted arrays into one sorted array.

**Approach**: Use two pointers to compare elements from both arrays, adding the smaller one to the result.

**Time Complexity**: O(n + m) - Must process all elements from both arrays
**Space Complexity**: O(n + m) - Additional space for the result array

```java
public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int i = 0, j = 0, k = 0;
    
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
            result[k++] = arr1[i++];
        } else {
            result[k++] = arr2[j++];
        }
    }
    
    while (i < arr1.length) {
        result[k++] = arr1[i++];
    }
    
    while (j < arr2.length) {
        result[k++] = arr2[j++];
    }
    
    return result;
}
```

### 8. Find Missing Number
**Problem**: Find the missing number in an array containing n distinct numbers from 0 to n.

**Approach**: Use mathematical formula to calculate expected sum and subtract actual sum.

**Time Complexity**: O(n) - Single pass to calculate sum
**Space Complexity**: O(1) - Only using a constant amount of extra space

```java
public int findMissingNumber(int[] nums) {
    int n = nums.length;
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    
    for (int num : nums) {
        actualSum += num;
    }
    
    return expectedSum - actualSum;
}
```

## 🎯 Hard Problems

### 9. Three Sum
**Problem**: Find all unique triplets that sum to zero.

**Approach**: Sort the array, then use two pointers for each element to find triplets.

**Time Complexity**: O(n²) - Nested loops with two pointers
**Space Complexity**: O(1) - Only using a constant amount of extra space (ignoring output)

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
    return result;
}
```

### 10. Maximum Subarray (Kadane's Algorithm)
**Problem**: Find the contiguous subarray with maximum sum.

**Approach**: Use Kadane's algorithm to track maximum sum ending at each position.

**Time Complexity**: O(n) - Single pass through the array
**Space Complexity**: O(1) - Only using a constant amount of extra space

```java
public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    
    return maxSoFar;
}
```

### 11. Product of Array Except Self
**Problem**: Return an array where each element is the product of all other elements.

**Approach**: Use two passes - one for left products, one for right products.

**Time Complexity**: O(n) - Two passes through the array
**Space Complexity**: O(1) - Only using a constant amount of extra space (ignoring output)

```java
public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    
    // First pass: calculate left products
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }
    
    // Second pass: calculate right products and multiply
    int rightProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        result[i] *= rightProduct;
        rightProduct *= nums[i];
    }
    
    return result;
}
```

### 12. Container With Most Water
**Problem**: Find two lines that together with the x-axis forms a container that holds the most water.

**Approach**: Use two pointers from both ends, moving the pointer with smaller height.

**Time Complexity**: O(n) - Single pass with two pointers
**Space Complexity**: O(1) - Only using a constant amount of extra space

```java
public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;
    
    while (left < right) {
        int area = Math.min(height[left], height[right]) * (right - left);
        maxArea = Math.max(maxArea, area);
        
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return maxArea;
}
```

## 🎯 Complexity Analysis Practice

### Analyze the following code snippets:

1. **Nested Loops**
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // O(1) operation
    }
}
```
**Answer**: O(n²) time, O(1) space

2. **Recursive Function**
```java
public int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```
**Answer**: O(2ⁿ) time, O(n) space

3. **Binary Search**
```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```
**Answer**: O(log n) time, O(1) space

## 💡 Tips for Complexity Analysis

1. **Count operations**: Count the number of basic operations
2. **Consider worst case**: Analyze the worst-case scenario
3. **Ignore constants**: Focus on the dominant term
4. **Consider space**: Don't forget about space complexity
5. **Practice regularly**: Complexity analysis improves with practice

## 🎯 Interview Questions

1. **What is the time complexity of this algorithm?**
2. **Can you optimize this algorithm?**
3. **What is the space complexity?**
4. **Is there a trade-off between time and space?**
5. **How would you improve this algorithm?**
