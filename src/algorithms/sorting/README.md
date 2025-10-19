# Sorting Algorithms 🔄

> **Master sorting algorithms and their applications**

## 🎯 Learning Objectives

- Understand sorting fundamentals
- Master comparison-based sorts
- Learn non-comparison sorts
- Apply sorting patterns to solve problems

## 📚 Theory

### Sorting Basics

#### Properties
- **Stable**: Equal elements maintain relative order
- **In-place**: Uses O(1) extra space
- **Adaptive**: Performance depends on input
- **Comparison-based**: Uses comparisons to sort
- **Non-comparison**: Uses other properties

#### Common Operations
- **Comparison**: O(1) time - compare two elements
- **Swap**: O(1) time - exchange two elements
- **Access**: O(1) time - access element by index
- **Move**: O(1) time - move element to position

### Sorting Algorithms

#### Comparison Sorts
- **Bubble Sort**: O(n²) time, O(1) space
- **Selection Sort**: O(n²) time, O(1) space
- **Insertion Sort**: O(n²) time, O(1) space
- **Merge Sort**: O(n log n) time, O(n) space
- **Quick Sort**: O(n log n) average, O(log n) space
- **Heap Sort**: O(n log n) time, O(1) space

#### Non-Comparison Sorts
- **Counting Sort**: O(n + k) time, O(k) space
- **Radix Sort**: O(d(n + k)) time, O(n + k) space
- **Bucket Sort**: O(n + k) time, O(n + k) space

## 🔧 Implementation

### Basic Sorting Algorithms

```java
// Bubble Sort
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                swapped = true;
            }
        }
        if (!swapped) break; // Optimized version
    }
}

// Selection Sort
public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        swap(arr, i, minIdx);
    }
}

// Insertion Sort
public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

### Advanced Sorting Algorithms

```java
// Merge Sort
public static void mergeSort(int[] arr) {
    if (arr.length <= 1) return;
    mergeSortHelper(arr, 0, arr.length - 1);
}

private static void mergeSortHelper(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

// Quick Sort
public static void quickSort(int[] arr) {
    if (arr.length <= 1) return;
    quickSortHelper(arr, 0, arr.length - 1);
}

private static void quickSortHelper(int[] arr, int low, int high) {
    if (low < high) {
        int pivot = partition(arr, low, high);
        quickSortHelper(arr, low, pivot - 1);
        quickSortHelper(arr, pivot + 1, high);
    }
}
```

## 📝 Practice Problems

### Easy
1. **Sort Array** - O(n log n) time, O(1) space
2. **Sort Colors** - O(n) time, O(1) space
3. **Valid Anagram** - O(n log n) time, O(1) space
4. **Intersection of Two Arrays** - O(n log n) time, O(1) space
5. **Merge Sorted Arrays** - O(n + m) time, O(1) space

### Medium
1. **Sort List** - O(n log n) time, O(log n) space
2. **Largest Number** - O(n log n) time, O(1) space
3. **H-Index** - O(n log n) time, O(1) space
4. **Wiggle Sort** - O(n log n) time, O(1) space
5. **Sort Characters By Frequency** - O(n log n) time, O(n) space

### Hard
1. **Merge k Sorted Lists** - O(n log k) time, O(1) space
2. **Sort an Array** - O(n log n) time, O(log n) space
3. **Count of Smaller Numbers After Self** - O(n log n) time, O(n) space
4. **Reverse Pairs** - O(n log n) time, O(n) space
5. **Maximum Gap** - O(n) time, O(n) space

## 💡 Key Insights

- **Stable sorts**: Merge sort, insertion sort
- **In-place sorts**: Quick sort, heap sort
- **Adaptive sorts**: Insertion sort, bubble sort
- **Non-comparison sorts**: Counting sort, radix sort
- **Hybrid sorts**: Tim sort, intro sort

## 🎯 Interview Tips

- Choose appropriate sorting algorithm
- Consider stability requirements
- Think about space constraints
- Consider input characteristics
- Use sorting as preprocessing step

## 📚 Additional Resources

- [Sorting Algorithms](https://www.geeksforgeeks.org/sorting-algorithms/)
- [Comparison of Sorting Algorithms](https://www.geeksforgeeks.org/stability-in-sorting-algorithms/)
- [Non-Comparison Sorts](https://www.geeksforgeeks.org/counting-sort/)
- [Sorting Visualizations](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
