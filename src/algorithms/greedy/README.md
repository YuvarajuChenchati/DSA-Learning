# Greedy Algorithms 🎯

> **Master greedy algorithms for locally optimal solutions**

## 🎯 Learning Objectives

- Understand greedy algorithm fundamentals
- Master common greedy patterns
- Learn when to use greedy algorithms
- Apply greedy algorithms to solve problems

## 📚 Theory

### Greedy Algorithm Basics

#### Properties
- **Local optimization**: Make locally optimal choice at each step
- **No backtracking**: Once choice is made, never reconsider
- **Optimal substructure**: Optimal solution contains optimal solutions to subproblems
- **Greedy choice property**: Locally optimal choice leads to globally optimal solution
- **Efficient**: Often O(n log n) or O(n) time complexity

#### Common Patterns
- **Activity selection**: Select maximum number of non-overlapping activities
- **Huffman coding**: Optimal prefix-free encoding
- **Minimum spanning tree**: Kruskal's and Prim's algorithms
- **Shortest path**: Dijkstra's algorithm
- **Fractional knapsack**: Greedy approach for knapsack

### When to Use Greedy Algorithms

#### Optimization Problems
- **Scheduling**: Optimal resource allocation
- **Compression**: Data compression algorithms
- **Network**: Minimum spanning trees
- **Sorting**: Some sorting algorithms
- **Selection**: Finding kth largest/smallest

#### Common Greedy Problems
- **Activity selection**: Maximum activities
- **Huffman coding**: Data compression
- **Minimum spanning tree**: Network optimization
- **Shortest path**: Route optimization
- **Fractional knapsack**: Resource allocation

## 🔧 Implementation

### Basic Greedy Template

```java
// Activity selection problem
public int maxActivities(int[][] activities) {
    // Sort by finish time
    Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
    
    int count = 1;
    int lastFinish = activities[0][1];
    
    for (int i = 1; i < activities.length; i++) {
        if (activities[i][0] >= lastFinish) {
            count++;
            lastFinish = activities[i][1];
        }
    }
    
    return count;
}
```

### Advanced Greedy Patterns

```java
// Huffman coding
public class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left, right;
    
    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }
}

public HuffmanNode buildHuffmanTree(char[] data, int[] freq) {
    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
    
    for (int i = 0; i < data.length; i++) {
        pq.offer(new HuffmanNode(data[i], freq[i]));
    }
    
    while (pq.size() > 1) {
        HuffmanNode left = pq.poll();
        HuffmanNode right = pq.poll();
        
        HuffmanNode merged = new HuffmanNode('$', left.frequency + right.frequency);
        merged.left = left;
        merged.right = right;
        
        pq.offer(merged);
    }
    
    return pq.poll();
}
```

## 📝 Practice Problems

### Easy
1. **Assign Cookies** - O(n log n) time, O(1) space
2. **Lemonade Change** - O(n) time, O(1) space
3. **Valid Parentheses String** - O(n) time, O(1) space
4. **Minimum Add to Make Valid** - O(n) time, O(1) space
5. **Queue Reconstruction by Height** - O(n²) time, O(1) space

### Medium
1. **Gas Station** - O(n) time, O(1) space
2. **Jump Game** - O(n) time, O(1) space
3. **Jump Game II** - O(n) time, O(1) space
4. **Minimum Number of Arrows** - O(n log n) time, O(1) space
5. **Remove K Digits** - O(n) time, O(n) space

### Hard
1. **Candy** - O(n) time, O(1) space
2. **Create Maximum Number** - O(k * (m + n)) time, O(m + n) space
3. **Patching Array** - O(n) time, O(1) space
4. **Minimum Number of Refueling Stops** - O(n log n) time, O(n) space
5. **Course Schedule III** - O(n log n) time, O(n) space

## 💡 Key Insights

- **Sort first**: Often need to sort data before applying greedy
- **Local optimization**: Make best choice at each step
- **No backtracking**: Once choice is made, stick with it
- **Prove correctness**: Show that greedy choice leads to optimal solution
- **Consider alternatives**: Sometimes multiple greedy approaches exist

## ⚠️ Common Mistakes

### Not Proving Correctness
- **Problem**: Using greedy without proving it works
- **Solution**: Prove that greedy choice leads to optimal solution
- **Example**: Show that local optimal choice leads to global optimal

### Wrong Greedy Choice
- **Problem**: Making wrong greedy choice
- **Solution**: Consider all possible choices and choose best locally
- **Example**: For activity selection, choose activity with earliest finish time

### Not Sorting First
- **Problem**: Not sorting data before applying greedy
- **Solution**: Sort data based on greedy criteria first
- **Example**: Sort intervals by end time for interval scheduling

### Ignoring Edge Cases
- **Problem**: Not handling empty input or single element
- **Solution**: Always check edge cases first
- **Example**: `if (intervals == null || intervals.length == 0) return 0;`

### Not Considering Constraints
- **Problem**: Not checking if greedy choice violates constraints
- **Solution**: Validate greedy choice against constraints
- **Example**: Check if activity doesn't conflict with previous activities

### Wrong Data Structure
- **Problem**: Using wrong data structure for greedy
- **Solution**: Use appropriate structure: heap for priority, set for tracking
- **Example**: Use PriorityQueue for selecting best option at each step

### Not Backtracking When Needed
- **Problem**: Using greedy when backtracking is needed
- **Solution**: Recognize when greedy fails and backtracking is needed
- **Example**: Greedy works for interval scheduling, but not for all problems

## 🎯 Interview Tips

- Always prove correctness of greedy approach
- Consider sorting as first step
- Think about local vs global optimization
- Consider edge cases and constraints
- Use appropriate data structures (heaps, sets)

## 📚 Additional Resources

- [Greedy Algorithms](https://www.geeksforgeeks.org/greedy-algorithms/)
- [Activity Selection Problem](https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/)
- [Huffman Coding](https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/)
- [Minimum Spanning Tree](https://www.geeksforgeeks.org/minimum-spanning-tree-mst-greedy-algo-2/)
