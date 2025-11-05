# Hard Problems 📝

> **Collection of hard-level problems organized by topic**

## 🎯 Problem Categories

### Arrays (15+ problems)

1. **Trapping Rain Water** (LeetCode #42) - ⭐⭐⭐ Very Common
   - Amount of water that can be trapped
   - Time: O(n), Space: O(1)
   - Hint: Two pointers or stack

2. **First Missing Positive** (LeetCode #41) - ⭐⭐ Common
   - First missing positive integer
   - Time: O(n), Space: O(1)
   - Hint: Use array indices

3. **Median of Two Sorted Arrays** (LeetCode #4) - ⭐⭐⭐ Very Common
   - Find median of two sorted arrays
   - Time: O(log(min(m,n))), Space: O(1)
   - Hint: Binary search on partition

4. **Merge k Sorted Lists** (LeetCode #23) - ⭐⭐ Common
   - Merge k sorted linked lists
   - Time: O(n log k), Space: O(k)
   - Hint: PriorityQueue or divide and conquer

5. **Minimum Window Substring** (LeetCode #76) - ⭐⭐⭐ Very Common
   - Minimum window substring
   - Time: O(n), Space: O(m)
   - Hint: Sliding window with hash map

6. **Sliding Window Maximum** (LeetCode #239) - ⭐⭐ Common
   - Maximum in each sliding window
   - Time: O(n), Space: O(k)
   - Hint: Deque or monotonic queue

7. **Longest Consecutive Sequence** (LeetCode #128) - ⭐⭐ Common
   - Find longest consecutive sequence
   - Time: O(n), Space: O(n)
   - Hint: HashSet and check neighbors

8. **Count of Smaller Numbers After Self** (LeetCode #315) - ⭐ Common
   - Count smaller numbers after each element
   - Time: O(n log n), Space: O(n)
   - Hint: Merge sort or segment tree

9. **Reverse Pairs** (LeetCode #493) - ⭐ Common
   - Count reverse pairs
   - Time: O(n log n), Space: O(n)
   - Hint: Merge sort

10. **Maximum Gap** (LeetCode #164) - ⭐ Common
    - Maximum gap between sorted elements
    - Time: O(n), Space: O(n)
    - Hint: Bucket sort

11. **Candy** (LeetCode #135) - ⭐ Common
    - Distribute candy to children
    - Time: O(n), Space: O(n)
    - Hint: Two passes

12. **Insert Delete GetRandom O(1)** (LeetCode #380) - ⭐ Common
    - Design data structure with O(1) operations
    - Time: O(1) all operations, Space: O(n)
    - Hint: HashMap + ArrayList

13. **Find Median from Data Stream** (LeetCode #295) - ⭐⭐ Common
    - Find median from data stream
    - Time: O(log n) add, O(1) find, Space: O(n)
    - Hint: Two heaps

14. **Largest Rectangle in Histogram** (LeetCode #84) - ⭐⭐ Common
    - Find largest rectangle area
    - Time: O(n), Space: O(n)
    - Hint: Monotonic stack

15. **Maximum Sum of 3 Non-Overlapping Subarrays** (LeetCode #689) - ⭐ Common
    - Find maximum sum of 3 non-overlapping subarrays
    - Time: O(n), Space: O(n)
    - Hint: Prefix sum + DP

### Trees (12+ problems)

1. **Serialize and Deserialize Binary Tree** (LeetCode #297) - ⭐⭐ Common
   - Serialize and deserialize tree
   - Time: O(n), Space: O(n)
   - Hint: Preorder traversal

2. **Binary Tree Maximum Path Sum** (LeetCode #124) - ⭐⭐ Common
   - Maximum path sum
   - Time: O(n), Space: O(h)
   - Hint: DFS with max calculation

3. **Word Search II** (LeetCode #212) - ⭐⭐ Common
   - Find all words in board
   - Time: O(mn * 4^L), Space: O(L)
   - Hint: Trie + backtracking

4. **Count Complete Tree Nodes** (LeetCode #222) - ⭐ Common
   - Count nodes in complete tree
   - Time: O(log²n), Space: O(1)
   - Hint: Binary search on height

5. **Binary Tree Postorder Traversal** (LeetCode #145) - ⭐ Common
   - Postorder traversal iteratively
   - Time: O(n), Space: O(h)
   - Hint: Use two stacks or reverse

6. **Recover Binary Search Tree** (LeetCode #99) - ⭐ Common
   - Recover swapped nodes in BST
   - Time: O(n), Space: O(h)
   - Hint: Inorder traversal

7. **Binary Tree Maximum Path Sum** (LeetCode #124) - ⭐ Common
   - Maximum path sum (duplicate removed in actual list)
   - Time: O(n), Space: O(h)

8. **Binary Tree Vertical Order Traversal** (LeetCode #314) - ⭐ Common
   - Vertical order traversal
   - Time: O(n), Space: O(n)
   - Hint: BFS with column tracking

9. **Construct Binary Tree from Preorder and Postorder** (LeetCode #889) - ⭐ Common
   - Build tree from preorder and postorder
   - Time: O(n), Space: O(n)
   - Hint: Use hash map for indices

10. **Binary Tree Cameras** (LeetCode #968) - ⭐ Common
    - Minimum cameras needed
    - Time: O(n), Space: O(h)
    - Hint: Greedy DFS

11. **Serialize and Deserialize N-ary Tree** (LeetCode #428) - ⭐ Common
    - Serialize N-ary tree
    - Time: O(n), Space: O(n)
    - Hint: Preorder with child count

12. **All Nodes Distance K in Binary Tree** (LeetCode #863) - ⭐ Common
    - Find all nodes at distance k
    - Time: O(n), Space: O(n)
    - Hint: DFS + BFS

### Graphs (15+ problems)

1. **Critical Connections in a Network** (LeetCode #1192) - ⭐⭐ Common
   - Find critical connections
   - Time: O(V+E), Space: O(V+E)
   - Hint: Tarjan's algorithm

2. **Word Ladder** (LeetCode #127) - ⭐⭐ Common
   - Shortest transformation sequence
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS

3. **Word Ladder II** (LeetCode #126) - ⭐ Common
   - All shortest transformation sequences
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS + backtracking

4. **Reconstruct Itinerary** (LeetCode #332) - ⭐ Common
   - Reconstruct itinerary
   - Time: O(E log E), Space: O(E)
   - Hint: DFS with sorting

5. **Minimum Cost to Connect All Points** (LeetCode #1584) - ⭐ Common
   - Minimum cost to connect points
   - Time: O(n² log n), Space: O(n²)
   - Hint: Kruskal's algorithm

6. **Alien Dictionary** (LeetCode #269) - ⭐ Common
   - Find alien dictionary order
   - Time: O(C), Space: O(1)
   - Hint: Topological sort

7. **Course Schedule III** (LeetCode #630) - ⭐ Common
   - Maximum courses that can be taken
   - Time: O(n log n), Space: O(n)
   - Hint: Greedy + priority queue

8. **Network Delay Time** (LeetCode #743) - ⭐ Common
   - Find network delay time
   - Time: O(E log V), Space: O(V+E)
   - Hint: Dijkstra's algorithm

9. **Cheapest Flights Within K Stops** (LeetCode #787) - ⭐ Common
   - Find cheapest flight path
   - Time: O(E * K), Space: O(V)
   - Hint: Bellman-Ford variant

10. **Swim in Rising Water** (LeetCode #778) - ⭐ Common
    - Minimum time to reach bottom right
    - Time: O(n² log n), Space: O(n²)
    - Hint: Binary search + DFS

11. **Minimum Cost to Make at Least One Valid Path** (LeetCode #1368) - ⭐ Common
    - Minimum cost for valid path
    - Time: O(mn), Space: O(mn)
    - Hint: BFS with 0-1 weights

12. **Shortest Path in a Grid with Obstacles Elimination** (LeetCode #1293) - ⭐ Common
    - Shortest path with k obstacles
    - Time: O(mn*k), Space: O(mn*k)
    - Hint: BFS with state

13. **Critical Connections** (LeetCode #1192) - ⭐ Common
    - Find critical connections (duplicate)
    - Time: O(V+E), Space: O(V+E)

14. **Parallel Courses III** (LeetCode #2050) - ⭐ Common
    - Minimum time to complete courses
    - Time: O(V+E), Space: O(V+E)
    - Hint: Topological sort + DP

15. **Maximum Employees to Be Invited to a Meeting** (LeetCode #2127) - ⭐ Common
    - Maximum employees for meeting
    - Time: O(n), Space: O(n)
    - Hint: Cycle detection + DP

### Dynamic Programming (15+ problems)

1. **Edit Distance** (LeetCode #72) - ⭐⭐⭐ Very Common
   - Minimum operations to convert string
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

2. **Regular Expression Matching** (LeetCode #10) - ⭐⭐⭐ Very Common
   - Match string with pattern
   - Time: O(mn), Space: O(mn)
   - Hint: 2D DP with state machine

3. **Wildcard Matching** (LeetCode #44) - ⭐⭐ Common
   - Match string with wildcard pattern
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

4. **Longest Valid Parentheses** (LeetCode #32) - ⭐⭐ Common
   - Length of longest valid parentheses
   - Time: O(n), Space: O(n)
   - Hint: Stack or DP

5. **Minimum Insertions to Make Palindrome** (LeetCode #1312) - ⭐ Common
   - Minimum insertions for palindrome
   - Time: O(n²), Space: O(n²)
   - Hint: LCS variant

6. **Burst Balloons** (LeetCode #312) - ⭐ Common
   - Maximum coins from bursting balloons
   - Time: O(n³), Space: O(n²)
   - Hint: Interval DP

7. **Palindrome Partitioning II** (LeetCode #132) - ⭐ Common
   - Minimum cuts for palindrome partitioning
   - Time: O(n²), Space: O(n²)
   - Hint: DP + palindrome check

8. **Scramble String** (LeetCode #87) - ⭐ Common
   - Check if strings are scrambled
   - Time: O(n⁴), Space: O(n³)
   - Hint: 3D DP

9. **Interleaving String** (LeetCode #97) - ⭐ Common
   - Check if string is interleaving
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

10. **Distinct Subsequences** (LeetCode #115) - ⭐ Common
    - Count distinct subsequences
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D DP

11. **Longest Increasing Path in a Matrix** (LeetCode #329) - ⭐ Common
    - Find longest increasing path
    - Time: O(mn), Space: O(mn)
    - Hint: DFS + memoization

12. **Maximum Profit in Job Scheduling** (LeetCode #1235) - ⭐ Common
    - Maximum profit from jobs
    - Time: O(n log n), Space: O(n)
    - Hint: DP + binary search

13. **Maximum Score from Performing Multiplication Operations** (LeetCode #1770) - ⭐ Common
    - Maximum score from multiplications
    - Time: O(m²), Space: O(m²)
    - Hint: 2D DP

14. **Count Different Palindromic Subsequences** (LeetCode #730) - ⭐ Common
    - Count different palindromic subsequences
    - Time: O(n²), Space: O(n²)
    - Hint: Interval DP

15. **Minimum Cost to Merge Stones** (LeetCode #1000) - ⭐ Common
    - Minimum cost to merge stones
    - Time: O(n³), Space: O(n²)
    - Hint: Interval DP

### System Design (10+ problems)

1. **LRU Cache** (LeetCode #146) - ⭐⭐⭐ Very Common
   - Least Recently Used cache
   - Time: O(1) all operations, Space: O(capacity)
   - Hint: HashMap + Doubly Linked List

2. **LFU Cache** (LeetCode #460) - ⭐⭐ Common
   - Least Frequently Used cache
   - Time: O(1) all operations, Space: O(capacity)
   - Hint: Nested data structures

3. **Design Twitter** (LeetCode #355) - ⭐⭐ Common
   - Twitter-like system
   - Time: O(n log n) getNewsFeed, Space: O(n)
   - Hint: HashMap + PriorityQueue

4. **Design Underground System** (LeetCode #1396) - ⭐ Common
   - Underground system
   - Time: O(1) all operations, Space: O(n)
   - Hint: HashMap + statistics

5. **Design Browser History** (LeetCode #1472) - ⭐ Common
   - Browser history system
   - Time: O(1) all operations, Space: O(n)
   - Hint: Two stacks or list

6. **Design Add and Search Words Data Structure** (LeetCode #211) - ⭐ Common
   - Word dictionary with wildcards
   - Time: O(m) search, Space: O(ALPHABET_SIZE * N * M)
   - Hint: Trie with DFS

7. **Design Search Autocomplete System** (LeetCode #642) - ⭐ Common
   - Autocomplete system
   - Time: O(p + q + m log m), Space: O(n)
   - Hint: Trie + PriorityQueue

8. **Design Snake Game** (LeetCode #353) - ⭐ Common
   - Snake game implementation
   - Time: O(1) move, Space: O(width * height)
   - Hint: Queue + HashSet

9. **Design Hit Counter** (LeetCode #362) - ⭐ Common
   - Hit counter system
   - Time: O(1) hit, O(1) getHits, Space: O(n)
   - Hint: Circular array or queue

10. **Design Tic-Tac-Toe** (LeetCode #348) - ⭐ Common
    - Tic-tac-toe game
    - Time: O(1) move, Space: O(n)
    - Hint: Track rows, cols, diagonals

## ⚠️ Common Mistakes

### Not Breaking Down Complex Problems
- **Problem**: Trying to solve complex problem all at once
- **Solution**: Break down into smaller subproblems
- **Example**: For hard DP problems, identify state, transition, and base case separately

### Wrong Algorithm Selection
- **Problem**: Using wrong algorithm for complex problems
- **Solution**: Identify problem pattern and choose appropriate algorithm
- **Example**: Use graph algorithms for graph problems, advanced DP for optimization

### Not Optimizing Space
- **Problem**: Using excessive space for large inputs
- **Solution**: Use space optimization techniques (1D DP, rolling arrays)
- **Example**: Use O(1) space for O(n) space problems when possible

### Incorrect Complexity Analysis
- **Problem**: Not analyzing complexity correctly for complex algorithms
- **Solution**: Carefully analyze time and space complexity
- **Example**: Graph algorithms: O(V + E) for adjacency list, O(V²) for matrix

### Not Handling Edge Cases
- **Problem**: Not considering all edge cases in complex problems
- **Solution**: Think about all possible input scenarios
- **Example**: Empty graphs, disconnected components, cycles, negative weights

### Wrong State Representation
- **Problem**: Incorrectly representing state in DP/graph problems
- **Solution**: Clearly define what state represents
- **Example**: `dp[i][j]` = maximum value using first i items with capacity j

### Not Considering System Design
- **Problem**: Not considering scalability for system design problems
- **Solution**: Think about scalability, reliability, and performance
- **Example**: Use distributed systems, caching, load balancing for large scale

## 💡 Problem Solving Tips

- **Break down complex problems**: Identify smaller subproblems
- **Use advanced algorithms**: Apply complex algorithms
- **Consider system design**: Think about scalability
- **Optimize thoroughly**: Use optimal time/space complexity
- **Handle edge cases**: Consider all possible scenarios

## 🎯 Success Metrics

- **Time to solve**: 30-60 minutes per problem
- **Accuracy**: 70%+ correct on first attempt
- **Code quality**: Production-ready, well-documented
- **Edge cases**: Handle all edge cases properly
- **Optimization**: Use optimal time/space complexity
