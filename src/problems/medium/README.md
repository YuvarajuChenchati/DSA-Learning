# Medium Problems 📝

> **Collection of medium-level problems organized by topic**

## 🎯 Problem Categories

### Arrays (15+ problems)

1. **Three Sum** (LeetCode #15) - ⭐⭐⭐ Very Common
   - Find all unique triplets that sum to zero
   - Time: O(n²), Space: O(1)
   - Hint: Sort and use two pointers

2. **Container With Most Water** (LeetCode #11) - ⭐⭐⭐ Very Common
   - Find two lines that form container
   - Time: O(n), Space: O(1)
   - Hint: Two pointers from ends

3. **Product of Array Except Self** (LeetCode #238) - ⭐⭐⭐ Very Common
   - Return array with products
   - Time: O(n), Space: O(1)
   - Hint: Prefix and suffix products

4. **Maximum Subarray** (LeetCode #53) - ⭐⭐⭐ Very Common
   - Find contiguous subarray with maximum sum
   - Time: O(n), Space: O(1)
   - Hint: Kadane's algorithm

5. **Spiral Matrix** (LeetCode #54) - ⭐⭐ Common
   - Return elements in spiral order
   - Time: O(mn), Space: O(1)
   - Hint: Track boundaries

6. **Set Matrix Zeroes** (LeetCode #73) - ⭐⭐ Common
   - Set entire row/column to zero if element is zero
   - Time: O(mn), Space: O(1)
   - Hint: Use first row/column as markers

7. **Longest Consecutive Sequence** (LeetCode #128) - ⭐⭐ Common
   - Find longest consecutive sequence length
   - Time: O(n), Space: O(n)
   - Hint: Use HashSet and check neighbors

8. **Group Anagrams** (LeetCode #49) - ⭐⭐ Common
   - Group strings that are anagrams
   - Time: O(nk), Space: O(nk)
   - Hint: Sort strings or count characters

9. **Top K Frequent Elements** (LeetCode #347) - ⭐⭐ Common
   - Find k most frequent elements
   - Time: O(n log k), Space: O(n)
   - Hint: Use HashMap and PriorityQueue

10. **Find Peak Element** (LeetCode #162) - ⭐⭐ Common
    - Find peak element index
    - Time: O(log n), Space: O(1)
    - Hint: Binary search

11. **Search in Rotated Sorted Array** (LeetCode #33) - ⭐⭐⭐ Very Common
    - Search in rotated sorted array
    - Time: O(log n), Space: O(1)
    - Hint: Modified binary search

12. **Merge Intervals** (LeetCode #56) - ⭐⭐⭐ Very Common
    - Merge overlapping intervals
    - Time: O(n log n), Space: O(n)
    - Hint: Sort and merge

13. **Insert Interval** (LeetCode #57) - ⭐⭐ Common
    - Insert new interval
    - Time: O(n), Space: O(n)
    - Hint: Find insertion point

14. **Rotate Image** (LeetCode #48) - ⭐⭐ Common
    - Rotate 2D matrix 90 degrees clockwise
    - Time: O(n²), Space: O(1)
    - Hint: Transpose and reverse

15. **Jump Game** (LeetCode #55) - ⭐⭐ Common
    - Check if can reach last index
    - Time: O(n), Space: O(1)
    - Hint: Greedy approach

### Trees (15+ problems)

1. **Binary Tree Level Order Traversal** (LeetCode #102) - ⭐⭐⭐ Very Common
   - Return level order traversal
   - Time: O(n), Space: O(n)
   - Hint: BFS with queue

2. **Construct Binary Tree from Preorder and Inorder** (LeetCode #105) - ⭐⭐ Common
   - Build tree from traversals
   - Time: O(n), Space: O(n)
   - Hint: Use hash map for indices

3. **Validate Binary Search Tree** (LeetCode #98) - ⭐⭐⭐ Very Common
   - Check if tree is valid BST
   - Time: O(n), Space: O(h)
   - Hint: Check bounds

4. **Lowest Common Ancestor** (LeetCode #236) - ⭐⭐ Common
   - Find LCA of two nodes
   - Time: O(n), Space: O(h)
   - Hint: Recursive search

5. **Binary Tree Right Side View** (LeetCode #199) - ⭐⭐ Common
   - Return right side view
   - Time: O(n), Space: O(h)
   - Hint: BFS and take last element

6. **Binary Tree Zigzag Level Order** (LeetCode #103) - ⭐ Common
   - Return zigzag level order
   - Time: O(n), Space: O(n)
   - Hint: BFS with direction flag

7. **Path Sum II** (LeetCode #113) - ⭐ Common
   - Find all paths with target sum
   - Time: O(n²), Space: O(h)
   - Hint: DFS with backtracking

8. **Flatten Binary Tree to Linked List** (LeetCode #114) - ⭐⭐ Common
   - Flatten tree to linked list
   - Time: O(n), Space: O(h)
   - Hint: Recursive or iterative

9. **Kth Smallest Element in BST** (LeetCode #230) - ⭐⭐ Common
   - Find kth smallest element
   - Time: O(h+k), Space: O(h)
   - Hint: Inorder traversal

10. **Count Complete Tree Nodes** (LeetCode #222) - ⭐ Common
    - Count nodes in complete tree
    - Time: O(log²n), Space: O(1)
    - Hint: Binary search on height

11. **Binary Tree Maximum Path Sum** (LeetCode #124) - ⭐⭐ Common
    - Find maximum path sum
    - Time: O(n), Space: O(h)
    - Hint: DFS with max calculation

12. **Sum Root to Leaf Numbers** (LeetCode #129) - ⭐ Common
    - Sum all root-to-leaf numbers
    - Time: O(n), Space: O(h)
    - Hint: DFS with number building

13. **Populating Next Right Pointers** (LeetCode #116) - ⭐ Common
    - Connect next right pointers
    - Time: O(n), Space: O(1)
    - Hint: Use existing pointers

14. **Construct Binary Tree from Inorder and Postorder** (LeetCode #106) - ⭐ Common
    - Build tree from traversals
    - Time: O(n), Space: O(n)
    - Hint: Similar to preorder/inorder

15. **Serialize and Deserialize Binary Tree** (LeetCode #297) - ⭐ Common
    - Serialize and deserialize tree
    - Time: O(n), Space: O(n)
    - Hint: Preorder traversal

### Graphs (15+ problems)

1. **Number of Islands** (LeetCode #200) - ⭐⭐⭐ Very Common
   - Count number of islands
   - Time: O(mn), Space: O(mn)
   - Hint: DFS or BFS

2. **Course Schedule** (LeetCode #207) - ⭐⭐⭐ Very Common
   - Check if courses can be completed
   - Time: O(V+E), Space: O(V+E)
   - Hint: Topological sort or DFS

3. **Redundant Connection** (LeetCode #684) - ⭐ Common
   - Find edge that creates cycle
   - Time: O(n), Space: O(n)
   - Hint: Union-Find

4. **Number of Connected Components** (LeetCode #323) - ⭐ Common
   - Count connected components
   - Time: O(V+E), Space: O(V+E)
   - Hint: DFS or Union-Find

5. **Graph Valid Tree** (LeetCode #261) - ⭐ Common
   - Check if graph is valid tree
   - Time: O(V+E), Space: O(V+E)
   - Hint: DFS and check cycles

6. **Clone Graph** (LeetCode #133) - ⭐⭐ Common
   - Clone undirected graph
   - Time: O(V+E), Space: O(V)
   - Hint: DFS with hash map

7. **Word Ladder** (LeetCode #127) - ⭐⭐ Common
   - Shortest transformation sequence
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS

8. **Course Schedule II** (LeetCode #210) - ⭐⭐ Common
   - Return course order
   - Time: O(V+E), Space: O(V+E)
   - Hint: Topological sort

9. **Alien Dictionary** (LeetCode #269) - ⭐ Common
   - Find alien dictionary order
   - Time: O(C), Space: O(1)
   - Hint: Topological sort

10. **Reconstruct Itinerary** (LeetCode #332) - ⭐ Common
    - Reconstruct itinerary
    - Time: O(E log E), Space: O(E)
    - Hint: DFS with sorting

11. **Cheapest Flights Within K Stops** (LeetCode #787) - ⭐ Common
    - Find cheapest flight path
    - Time: O(E * K), Space: O(V)
    - Hint: Bellman-Ford variant

12. **Network Delay Time** (LeetCode #743) - ⭐ Common
    - Find network delay time
    - Time: O(E log V), Space: O(V+E)
    - Hint: Dijkstra's algorithm

13. **Critical Connections** (LeetCode #1192) - ⭐ Common
    - Find critical connections
    - Time: O(V+E), Space: O(V+E)
    - Hint: Tarjan's algorithm

14. **Island Perimeter** (LeetCode #463) - ⭐ Common
    - Calculate island perimeter
    - Time: O(mn), Space: O(1)
    - Hint: Count edges

15. **Rotting Oranges** (LeetCode #994) - ⭐ Common
    - Find minutes until all oranges rot
    - Time: O(mn), Space: O(mn)
    - Hint: Multi-source BFS

### Dynamic Programming (15+ problems)

1. **Climbing Stairs** (LeetCode #70) - ⭐⭐⭐ Very Common
   - Number of ways to climb stairs
   - Time: O(n), Space: O(1)
   - Hint: Fibonacci pattern

2. **House Robber** (LeetCode #198) - ⭐⭐⭐ Very Common
   - Maximum money that can be robbed
   - Time: O(n), Space: O(1)
   - Hint: DP with two states

3. **Longest Increasing Subsequence** (LeetCode #300) - ⭐⭐ Common
   - Length of longest increasing subsequence
   - Time: O(n log n), Space: O(n)
   - Hint: DP or binary search

4. **Coin Change** (LeetCode #322) - ⭐⭐⭐ Very Common
   - Minimum number of coins needed
   - Time: O(amount * coins), Space: O(amount)
   - Hint: DP with optimization

5. **Word Break** (LeetCode #139) - ⭐⭐⭐ Very Common
   - Check if string can be segmented
   - Time: O(n²), Space: O(n)
   - Hint: DP with substring check

6. **Unique Paths** (LeetCode #62) - ⭐⭐ Common
   - Number of unique paths
   - Time: O(mn), Space: O(n)
   - Hint: DP grid

7. **Longest Palindromic Substring** (LeetCode #5) - ⭐⭐ Common
   - Find longest palindromic substring
   - Time: O(n²), Space: O(1)
   - Hint: Expand around centers

8. **Partition Equal Subset Sum** (LeetCode #416) - ⭐⭐ Common
   - Check if can partition into equal sum
   - Time: O(n * sum), Space: O(sum)
   - Hint: 0/1 knapsack variant

9. **Decode Ways** (LeetCode #91) - ⭐⭐ Common
   - Number of ways to decode string
   - Time: O(n), Space: O(1)
   - Hint: DP with two states

10. **Edit Distance** (LeetCode #72) - ⭐⭐ Common
    - Minimum operations to convert string
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D DP

11. **Maximum Product Subarray** (LeetCode #152) - ⭐⭐ Common
    - Maximum product of subarray
    - Time: O(n), Space: O(1)
    - Hint: Track min and max

12. **Best Time to Buy and Sell Stock with Cooldown** (LeetCode #309) - ⭐ Common
    - Maximum profit with cooldown
    - Time: O(n), Space: O(1)
    - Hint: State machine DP

13. **Longest Common Subsequence** (LeetCode #1143) - ⭐⭐ Common
    - Length of longest common subsequence
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D DP

14. **Target Sum** (LeetCode #494) - ⭐ Common
    - Number of ways to reach target sum
    - Time: O(n * sum), Space: O(sum)
    - Hint: DP or memoization

15. **Perfect Squares** (LeetCode #279) - ⭐ Common
    - Minimum number of perfect squares
    - Time: O(n * √n), Space: O(n)
    - Hint: DP with optimization

### Backtracking (12+ problems)

1. **Generate Parentheses** (LeetCode #22) - ⭐⭐⭐ Very Common
   - Generate all valid parentheses
   - Time: O(4^n/√n), Space: O(n)
   - Hint: Backtracking with constraints

2. **Combination Sum** (LeetCode #39) - ⭐⭐ Common
   - Find all combinations that sum to target
   - Time: O(2^n), Space: O(target)
   - Hint: Backtracking with pruning

3. **Permutations** (LeetCode #46) - ⭐⭐⭐ Very Common
   - Generate all permutations
   - Time: O(n!), Space: O(n)
   - Hint: Backtracking with swap

4. **Subsets** (LeetCode #78) - ⭐⭐⭐ Very Common
   - Generate all subsets
   - Time: O(2^n), Space: O(2^n)
   - Hint: Backtracking or bit manipulation

5. **Word Search** (LeetCode #79) - ⭐⭐ Common
   - Find word in 2D board
   - Time: O(mn * 4^L), Space: O(L)
   - Hint: DFS with backtracking

6. **N-Queens** (LeetCode #51) - ⭐⭐ Common
   - Find all N-Queen solutions
   - Time: O(n!), Space: O(n)
   - Hint: Backtracking with diagonal checks

7. **Combination Sum II** (LeetCode #40) - ⭐ Common
   - Find combinations without duplicates
   - Time: O(2^n), Space: O(target)
   - Hint: Backtracking with skip duplicates

8. **Permutations II** (LeetCode #47) - ⭐ Common
   - Generate unique permutations
   - Time: O(n!), Space: O(n)
   - Hint: Backtracking with duplicate handling

9. **Subsets II** (LeetCode #90) - ⭐ Common
   - Generate unique subsets
   - Time: O(2^n), Space: O(2^n)
   - Hint: Backtracking with skip duplicates

10. **Palindrome Partitioning** (LeetCode #131) - ⭐ Common
    - Partition string into palindromes
    - Time: O(2^n), Space: O(n)
    - Hint: Backtracking with palindrome check

11. **Sudoku Solver** (LeetCode #37) - ⭐ Common
    - Solve Sudoku puzzle
    - Time: O(9^m), Space: O(1)
    - Hint: Backtracking with validation

12. **Restore IP Addresses** (LeetCode #93) - ⭐ Common
    - Restore IP addresses from string
    - Time: O(1), Space: O(1)
    - Hint: Backtracking with validation

## ⚠️ Common Mistakes

### Not Identifying Patterns
- **Problem**: Not recognizing common patterns (two pointers, sliding window, etc.)
- **Solution**: Learn common patterns and recognize when to use them
- **Example**: Use two pointers for sorted arrays, sliding window for subarrays

### Wrong Algorithm Choice
- **Problem**: Using wrong algorithm for the problem
- **Solution**: Identify problem type and choose appropriate algorithm
- **Example**: Use DP for overlapping subproblems, greedy for optimization problems

### Not Handling Duplicates
- **Problem**: Not handling duplicate elements correctly
- **Solution**: Sort array first and skip duplicates
- **Example**: `if (i > start && nums[i] == nums[i - 1]) continue;` to skip duplicates

### Incorrect State Management
- **Problem**: Not managing state correctly in backtracking/DP
- **Solution**: Carefully track state changes and undo when needed
- **Example**: Remove element after backtracking: `path.remove(path.size() - 1);`

### Not Optimizing Space
- **Problem**: Using O(n) space when O(1) is possible
- **Solution**: Consider space optimization techniques
- **Example**: Use two pointers instead of hash map when possible

### Wrong Base Case
- **Problem**: Incorrect base case in recursion/DP
- **Solution**: Clearly define base case first
- **Example**: `if (n == 0) return 0;` for base case

### Not Considering All Constraints
- **Problem**: Not checking all constraints before solving
- **Solution**: Read all constraints carefully and validate them
- **Example**: Check array size, value ranges, and edge cases

## 💡 Problem Solving Tips

- **Break down the problem**: Identify subproblems
- **Use recursion**: Natural for many medium problems
- **Consider memoization**: Avoid recomputation
- **Think about data structures**: Choose appropriate structures
- **Practice pattern recognition**: Identify common patterns

## 🎯 Success Metrics

- **Time to solve**: 15-30 minutes per problem
- **Accuracy**: 80%+ correct on first attempt
- **Code quality**: Clean, efficient, well-structured
- **Edge cases**: Handle all edge cases properly
- **Optimization**: Use optimal time/space complexity
