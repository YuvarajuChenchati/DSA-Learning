# Time Complexity Cheat Sheet ⏱️

> **Quick reference for time complexities of common algorithms and data structures**

## 📊 Common Time Complexities

| Complexity | Notation | Description | Example |
|------------|----------|-------------|---------|
| Constant | O(1) | Same time regardless of input | Array access, hash table lookup |
| Logarithmic | O(log n) | Time grows logarithmically | Binary search, balanced tree operations |
| Linear | O(n) | Time grows linearly | Linear search, array traversal |
| Linearithmic | O(n log n) | Time grows as n log n | Merge sort, heap sort |
| Quadratic | O(n²) | Time grows quadratically | Bubble sort, nested loops |
| Cubic | O(n³) | Time grows cubically | Three nested loops |
| Exponential | O(2ⁿ) | Time grows exponentially | Recursive Fibonacci |
| Factorial | O(n!) | Time grows factorially | Permutations |

## 🔍 Searching Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space |
|-----------|-----------|--------------|------------|-------|
| Linear Search | O(1) | O(n) | O(n) | O(1) |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| Jump Search | O(1) | O(√n) | O(√n) | O(1) |
| Interpolation Search | O(1) | O(log log n) | O(n) | O(1) |
| Exponential Search | O(1) | O(log n) | O(log n) | O(1) |

## 🔄 Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable |
|-----------|-----------|--------------|------------|-------|--------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | No |
| Counting Sort | O(n + k) | O(n + k) | O(n + k) | O(k) | Yes |
| Radix Sort | O(d(n + k)) | O(d(n + k)) | O(d(n + k)) | O(n + k) | Yes |
| Bucket Sort | O(n + k) | O(n + k) | O(n²) | O(n + k) | Yes |

## 📚 Data Structures

### Arrays
| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Access | O(1) | O(1) |
| Search | O(n) | O(1) |
| Insertion | O(n) | O(1) |
| Deletion | O(n) | O(1) |

### Linked Lists
| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Access | O(n) | O(1) |
| Search | O(n) | O(1) |
| Insertion | O(1) | O(1) |
| Deletion | O(1) | O(1) |

### Stacks
| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Push | O(1) | O(1) |
| Pop | O(1) | O(1) |
| Peek | O(1) | O(1) |
| Search | O(n) | O(1) |

### Queues
| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Enqueue | O(1) | O(1) |
| Dequeue | O(1) | O(1) |
| Front | O(1) | O(1) |
| Search | O(n) | O(1) |

### Hash Tables
| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Insert | O(1) | O(1) |
| Delete | O(1) | O(1) |
| Search | O(1) | O(1) |
| Space | O(n) | O(n) |

### Trees
| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Access | O(log n) | O(log n) |
| Search | O(log n) | O(log n) |
| Insertion | O(log n) | O(log n) |
| Deletion | O(log n) | O(log n) |

### Graphs
| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| DFS | O(V + E) | O(V) |
| BFS | O(V + E) | O(V) |
| Dijkstra | O((V + E) log V) | O(V) |
| Bellman-Ford | O(VE) | O(V) |
| Floyd-Warshall | O(V³) | O(V²) |

## 🎯 Common Patterns

### Two Pointers
- **Time**: O(n)
- **Space**: O(1)
- **Use**: Sorted arrays, palindromes

### Sliding Window
- **Time**: O(n)
- **Space**: O(1)
- **Use**: Subarray problems

### Fast & Slow Pointers
- **Time**: O(n)
- **Space**: O(1)
- **Use**: Cycle detection, middle finding

### Merge Intervals
- **Time**: O(n log n)
- **Space**: O(1)
- **Use**: Overlapping intervals

### Cyclic Sort
- **Time**: O(n)
- **Space**: O(1)
- **Use**: Array with numbers in range [1, n]

### Top K Elements
- **Time**: O(n log k)
- **Space**: O(k)
- **Use**: K largest/smallest elements

## 💡 Optimization Tips

### Space-Time Tradeoffs
- **Hash tables**: O(1) time, O(n) space
- **Sorting**: O(n log n) time, O(1) space
- **Memoization**: O(n) time, O(n) space
- **Iterative**: O(n) time, O(1) space

### Common Optimizations
- **Two pointers**: Reduce O(n²) to O(n)
- **Sliding window**: Reduce O(n²) to O(n)
- **Hash map**: Reduce O(n) to O(1)
- **Sorting**: Enable binary search
- **Memoization**: Avoid recomputation

## 🎯 Interview Tips

1. **Always analyze worst-case complexity**
2. **Consider both time and space complexity**
3. **Explain your analysis clearly**
4. **Discuss trade-offs between approaches**
5. **Mention when you can optimize further**

## 📚 Additional Resources

- [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
- [Time Complexity Visualizer](https://www.cs.usfca.edu/~galles/visualization/)
- [Algorithm Complexity](https://www.geeksforgeeks.org/analysis-of-algorithms/)
- [Space Complexity](https://www.geeksforgeeks.org/space-complexity/)
