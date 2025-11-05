# Microsoft Interview Questions 🪟

> **Curated list of Microsoft interview questions organized by topic and difficulty**

## 🎯 Overview

Microsoft interviews focus on:
- **Technical excellence**
- **Problem-solving skills**
- **System design**
- **Coding proficiency**
- **Collaboration**

## 📊 Question Distribution

- **Arrays & Strings**: 25%
- **Trees & Graphs**: 20%
- **Dynamic Programming**: 15%
- **System Design**: 20%
- **Math & Bit Manipulation**: 15%
- **Other**: 5%

## 🔥 Easy Questions

### Arrays (15+ problems)
1. **Two Sum** (LeetCode #1) - ⭐⭐⭐ Very Common
   - Find two numbers that sum to target
   - Time: O(n), Space: O(n)
   - Hint: Use HashMap

2. **Best Time to Buy and Sell Stock** (LeetCode #121) - ⭐⭐⭐ Very Common
   - Maximum profit from stock trading
   - Time: O(n), Space: O(1)
   - Hint: Track minimum price

3. **Contains Duplicate** (LeetCode #217) - ⭐⭐⭐ Very Common
   - Check if array contains duplicates
   - Time: O(n), Space: O(n)
   - Hint: Use HashSet

4. **Single Number** (LeetCode #136) - ⭐⭐ Common
   - Find single number in array
   - Time: O(n), Space: O(1)
   - Hint: XOR operation

5. **Rotate Array** (LeetCode #189) - ⭐⭐ Common
   - Rotate array to the right by k steps
   - Time: O(n), Space: O(1)
   - Hint: Reverse in parts

6. **Remove Duplicates from Sorted Array** (LeetCode #26) - ⭐⭐ Common
   - Remove duplicates in-place
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

7. **Plus One** (LeetCode #66) - ⭐ Common
   - Add one to number represented as array
   - Time: O(n), Space: O(1)
   - Hint: Handle carry-over

8. **Move Zeroes** (LeetCode #283) - ⭐⭐ Common
   - Move all zeros to end
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

9. **Remove Element** (LeetCode #27) - ⭐ Common
   - Remove all instances of value
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

10. **Intersection of Two Arrays** (LeetCode #349) - ⭐ Common
    - Find intersection of two arrays
    - Time: O(n+m), Space: O(n)
    - Hint: Use HashSet

11. **Missing Number** (LeetCode #268) - ⭐⭐ Common
    - Find missing number in range [0, n]
    - Time: O(n), Space: O(1)
    - Hint: XOR or sum

12. **Majority Element** (LeetCode #169) - ⭐⭐ Common
    - Find element appearing more than n/2 times
    - Time: O(n), Space: O(1)
    - Hint: Boyer-Moore voting

13. **Squares of Sorted Array** (LeetCode #977) - ⭐ Common
    - Return squares in sorted order
    - Time: O(n), Space: O(n)
    - Hint: Two pointers from ends

14. **Pascal's Triangle** (LeetCode #118) - ⭐ Common
    - Generate Pascal's triangle
    - Time: O(n²), Space: O(n²)
    - Hint: Dynamic programming

15. **Maximum Subarray** (LeetCode #53) - ⭐⭐ Common
    - Find contiguous subarray with maximum sum
    - Time: O(n), Space: O(1)
    - Hint: Kadane's algorithm

### Strings (15+ problems)
1. **Valid Anagram** (LeetCode #242) - ⭐⭐⭐ Very Common
   - Check if strings are anagrams
   - Time: O(n), Space: O(1)
   - Hint: Count characters

2. **First Unique Character** (LeetCode #387) - ⭐⭐⭐ Very Common
   - Find first non-repeating character
   - Time: O(n), Space: O(1)
   - Hint: Frequency counting

3. **Valid Palindrome** (LeetCode #125) - ⭐⭐⭐ Very Common
   - Check if string is palindrome
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

4. **Reverse String** (LeetCode #344) - ⭐⭐ Common
   - Reverse string in-place
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

5. **Longest Common Prefix** (LeetCode #14) - ⭐⭐ Common
   - Find longest common prefix
   - Time: O(nm), Space: O(1)
   - Hint: Compare characters

6. **Valid Parentheses** (LeetCode #20) - ⭐⭐⭐ Very Common
   - Check if parentheses are valid
   - Time: O(n), Space: O(n)
   - Hint: Use stack

7. **Implement strStr()** (LeetCode #28) - ⭐ Common
   - Find needle in haystack
   - Time: O(nm), Space: O(1)
   - Hint: Brute force or KMP

8. **Isomorphic Strings** (LeetCode #205) - ⭐ Common
   - Check if strings are isomorphic
   - Time: O(n), Space: O(n)
   - Hint: Character mapping

9. **Reverse Words in String** (LeetCode #151) - ⭐ Common
   - Reverse order of words
   - Time: O(n), Space: O(n)
   - Hint: Split and reverse

10. **Add Binary** (LeetCode #67) - ⭐ Common
    - Add two binary strings
    - Time: O(n), Space: O(1)
    - Hint: Handle carry-over

11. **Roman to Integer** (LeetCode #13) - ⭐ Common
    - Convert Roman numeral to integer
    - Time: O(n), Space: O(1)
    - Hint: Map characters to values

12. **Count and Say** (LeetCode #38) - ⭐ Common
    - Generate count-and-say sequence
    - Time: O(n * 2^n), Space: O(2^n)
    - Hint: Build next sequence

13. **Longest Palindrome** (LeetCode #409) - ⭐ Common
    - Find longest palindrome length
    - Time: O(n), Space: O(1)
    - Hint: Count character frequencies

14. **String Compression** (LeetCode #443) - ⭐ Common
    - Compress string using counts
    - Time: O(n), Space: O(1)
    - Hint: Two pointers

15. **Reverse Vowels** (LeetCode #345) - ⭐ Common
    - Reverse vowels in string
    - Time: O(n), Space: O(1)
    - Hint: Two pointers

### Linked Lists (12+ problems)
1. **Reverse Linked List** (LeetCode #206) - ⭐⭐⭐ Very Common
   - Reverse linked list
   - Time: O(n), Space: O(1)
   - Hint: Iterative or recursive

2. **Merge Two Sorted Lists** (LeetCode #21) - ⭐⭐⭐ Very Common
   - Merge two sorted linked lists
   - Time: O(n+m), Space: O(1)
   - Hint: Two pointers

3. **Remove Duplicates** (LeetCode #83) - ⭐ Common
   - Remove duplicates from sorted list
   - Time: O(n), Space: O(1)
   - Hint: Two pointers

4. **Middle of Linked List** (LeetCode #876) - ⭐ Common
   - Find middle node
   - Time: O(n), Space: O(1)
   - Hint: Fast and slow pointers

5. **Delete Node** (LeetCode #237) - ⭐ Common
   - Delete node without head reference
   - Time: O(1), Space: O(1)
   - Hint: Copy next node

6. **Remove Linked List Elements** (LeetCode #203) - ⭐ Common
   - Remove all nodes with value
   - Time: O(n), Space: O(1)
   - Hint: Dummy head

7. **Palindrome Linked List** (LeetCode #234) - ⭐⭐ Common
   - Check if linked list is palindrome
   - Time: O(n), Space: O(1)
   - Hint: Reverse second half

8. **Intersection of Two Linked Lists** (LeetCode #160) - ⭐ Common
   - Find intersection node
   - Time: O(n+m), Space: O(1)
   - Hint: Two pointers

9. **Linked List Cycle** (LeetCode #141) - ⭐⭐⭐ Very Common
   - Detect cycle in linked list
   - Time: O(n), Space: O(1)
   - Hint: Floyd's algorithm

10. **Remove Nth Node From End** (LeetCode #19) - ⭐⭐ Common
    - Remove nth node from end
    - Time: O(n), Space: O(1)
    - Hint: Two pointers

11. **Add Two Numbers** (LeetCode #2) - ⭐⭐ Common
    - Add two numbers represented as linked lists
    - Time: O(n+m), Space: O(1)
    - Hint: Handle carry-over

12. **Swap Nodes in Pairs** (LeetCode #24) - ⭐ Common
    - Swap every two adjacent nodes
    - Time: O(n), Space: O(1)
    - Hint: Iterative or recursive

## 🚀 Medium Questions

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
   - Hint: Use heap or bucket sort

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
    - Hint: Find insertion point and merge

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
   - Hint: Use BFS with queue

2. **Construct Binary Tree from Preorder and Inorder** (LeetCode #105) - ⭐⭐ Common
   - Build tree from traversals
   - Time: O(n), Space: O(n)
   - Hint: Recursive with hash map

3. **Validate Binary Search Tree** (LeetCode #98) - ⭐⭐⭐ Very Common
   - Check if tree is valid BST
   - Time: O(n), Space: O(h)
   - Hint: Check range for each node

4. **Lowest Common Ancestor** (LeetCode #236) - ⭐⭐ Common
   - Find LCA of two nodes
   - Time: O(n), Space: O(h)
   - Hint: Recursive DFS

5. **Binary Tree Right Side View** (LeetCode #199) - ⭐⭐ Common
   - Return right side view
   - Time: O(n), Space: O(h)
   - Hint: BFS and track last node

6. **Binary Tree Zigzag Level Order** (LeetCode #103) - ⭐ Common
   - Return zigzag level order
   - Time: O(n), Space: O(n)
   - Hint: BFS with direction flag

7. **Path Sum II** (LeetCode #113) - ⭐ Common
   - Find all paths with target sum
   - Time: O(n²), Space: O(h)
   - Hint: Backtracking DFS

8. **Flatten Binary Tree to Linked List** (LeetCode #114) - ⭐⭐ Common
   - Flatten tree to linked list
   - Time: O(n), Space: O(h)
   - Hint: Morris traversal or recursive

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
    - Hint: DFS and track max sum

12. **Sum Root to Leaf Numbers** (LeetCode #129) - ⭐ Common
    - Sum all root-to-leaf numbers
    - Time: O(n), Space: O(h)
    - Hint: DFS with path sum

13. **Populating Next Right Pointers** (LeetCode #116) - ⭐ Common
    - Connect next right pointers
    - Time: O(n), Space: O(1)
    - Hint: Use level-order traversal

14. **Construct Binary Tree from Inorder and Postorder** (LeetCode #106) - ⭐ Common
    - Build tree from traversals
    - Time: O(n), Space: O(n)
    - Hint: Recursive with hash map

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
   - Hint: Topological sort or DFS cycle detection

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
   - Hint: Check cycle and connectivity

6. **Clone Graph** (LeetCode #133) - ⭐⭐ Common
   - Clone undirected graph
   - Time: O(V+E), Space: O(V)
   - Hint: DFS or BFS with hash map

7. **Word Ladder** (LeetCode #127) - ⭐⭐ Common
   - Shortest transformation sequence
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS with word transformation

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
    - Hint: DFS with backtracking

11. **Cheapest Flights Within K Stops** (LeetCode #787) - ⭐ Common
    - Find cheapest flight path
    - Time: O(E * K), Space: O(V)
    - Hint: BFS or Bellman-Ford

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
    - Hint: BFS from all rotten oranges

### Dynamic Programming (15+ problems)
1. **Climbing Stairs** (LeetCode #70) - ⭐⭐⭐ Very Common
   - Number of ways to climb stairs
   - Time: O(n), Space: O(1)
   - Hint: Fibonacci sequence

2. **House Robber** (LeetCode #198) - ⭐⭐⭐ Very Common
   - Maximum money that can be robbed
   - Time: O(n), Space: O(1)
   - Hint: DP with two variables

3. **Longest Increasing Subsequence** (LeetCode #300) - ⭐⭐ Common
   - Length of longest increasing subsequence
   - Time: O(n log n), Space: O(n)
   - Hint: DP with binary search

4. **Coin Change** (LeetCode #322) - ⭐⭐⭐ Very Common
   - Minimum number of coins needed
   - Time: O(amount * coins), Space: O(amount)
   - Hint: Unbounded knapsack

5. **Word Break** (LeetCode #139) - ⭐⭐⭐ Very Common
   - Check if string can be segmented
   - Time: O(n²), Space: O(n)
   - Hint: DP with substring check

6. **Unique Paths** (LeetCode #62) - ⭐⭐ Common
   - Number of unique paths
   - Time: O(mn), Space: O(n)
   - Hint: DP with 2D array

7. **Longest Palindromic Substring** (LeetCode #5) - ⭐⭐ Common
   - Find longest palindromic substring
   - Time: O(n²), Space: O(1)
   - Hint: Expand around centers

8. **Partition Equal Subset Sum** (LeetCode #416) - ⭐⭐ Common
   - Check if can partition into equal sum
   - Time: O(n * sum), Space: O(sum)
   - Hint: 0/1 knapsack

9. **Decode Ways** (LeetCode #91) - ⭐⭐ Common
   - Number of ways to decode string
   - Time: O(n), Space: O(1)
   - Hint: DP with validation

10. **Edit Distance** (LeetCode #72) - ⭐⭐ Common
    - Minimum operations to convert string
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D DP

11. **Maximum Product Subarray** (LeetCode #152) - ⭐⭐ Common
    - Maximum product of subarray
    - Time: O(n), Space: O(1)
    - Hint: Track min and max product

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
    - Hint: DP with subset sum

15. **Perfect Squares** (LeetCode #279) - ⭐ Common
    - Minimum number of perfect squares
    - Time: O(n * √n), Space: O(n)
    - Hint: DP with square numbers

## 🔥 Hard Questions

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

14. **LRU Cache** (LeetCode #146) - ⭐⭐ Common
    - Design LRU cache
    - Time: O(1) all operations, Space: O(capacity)
    - Hint: HashMap + Doubly linked list

15. **LFU Cache** (LeetCode #460) - ⭐ Common
    - Design LFU cache
    - Time: O(1) all operations, Space: O(capacity)
    - Hint: HashMap + LinkedHashSet

### Trees (12+ problems)
1. **Serialize and Deserialize Binary Tree** (LeetCode #297) - ⭐⭐ Common
   - Serialize and deserialize tree
   - Time: O(n), Space: O(n)
   - Hint: Preorder traversal

2. **Binary Tree Maximum Path Sum** (LeetCode #124) - ⭐⭐ Common
   - Maximum path sum
   - Time: O(n), Space: O(h)
   - Hint: DFS and track max sum

3. **Word Search II** (LeetCode #212) - ⭐ Common
   - Find all words in board
   - Time: O(mn * 4^L), Space: O(L)
   - Hint: Trie + DFS

4. **Count Complete Tree Nodes** (LeetCode #222) - ⭐ Common
   - Count nodes in complete tree
   - Time: O(log²n), Space: O(1)
   - Hint: Binary search on height

5. **Binary Tree Postorder Traversal** (LeetCode #145) - ⭐ Common
   - Postorder traversal
   - Time: O(n), Space: O(h)
   - Hint: Iterative with stack

6. **Recover Binary Search Tree** (LeetCode #99) - ⭐ Common
   - Recover swapped nodes in BST
   - Time: O(n), Space: O(h)
   - Hint: Inorder traversal

7. **Binary Tree Inorder Traversal** (LeetCode #94) - ⭐ Common
   - Inorder traversal
   - Time: O(n), Space: O(h)
   - Hint: Iterative with stack

8. **Construct Binary Tree from Preorder and Postorder** (LeetCode #889) - ⭐ Common
   - Build tree from traversals
   - Time: O(n), Space: O(n)
   - Hint: Recursive with hash map

9. **Binary Tree Preorder Traversal** (LeetCode #144) - ⭐ Common
   - Preorder traversal
   - Time: O(n), Space: O(h)
   - Hint: Iterative with stack

10. **Validate Binary Search Tree** (LeetCode #98) - ⭐⭐ Common
    - Check if tree is valid BST
    - Time: O(n), Space: O(h)
    - Hint: Check range for each node

11. **Lowest Common Ancestor** (LeetCode #236) - ⭐ Common
    - Find LCA of two nodes
    - Time: O(n), Space: O(h)
    - Hint: Recursive DFS

12. **Binary Tree Right Side View** (LeetCode #199) - ⭐ Common
    - Return right side view
    - Time: O(n), Space: O(h)
    - Hint: BFS and track last node

### Graphs (15+ problems)
1. **Critical Connections in a Network** (LeetCode #1192) - ⭐ Common
   - Find critical connections
   - Time: O(V+E), Space: O(V+E)
   - Hint: Tarjan's algorithm

2. **Word Ladder** (LeetCode #127) - ⭐⭐ Common
   - Shortest transformation sequence
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS with word transformation

3. **Word Ladder II** (LeetCode #126) - ⭐ Common
   - All shortest transformation sequences
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS with backtracking

4. **Reconstruct Itinerary** (LeetCode #332) - ⭐ Common
   - Reconstruct itinerary
   - Time: O(E log E), Space: O(E)
   - Hint: DFS with backtracking

5. **Minimum Cost to Connect All Points** (LeetCode #1584) - ⭐ Common
   - Minimum cost to connect points
   - Time: O(E log E), Space: O(V)
   - Hint: Minimum spanning tree

6. **Number of Islands** (LeetCode #200) - ⭐ Common
   - Count number of islands
   - Time: O(mn), Space: O(mn)
   - Hint: DFS or BFS

7. **Course Schedule** (LeetCode #207) - ⭐ Common
   - Check if courses can be completed
   - Time: O(V+E), Space: O(V+E)
   - Hint: Topological sort or DFS cycle detection

8. **Clone Graph** (LeetCode #133) - ⭐ Common
   - Clone undirected graph
   - Time: O(V+E), Space: O(V)
   - Hint: DFS or BFS with hash map

9. **Course Schedule II** (LeetCode #210) - ⭐ Common
   - Return course order
   - Time: O(V+E), Space: O(V+E)
   - Hint: Topological sort

10. **Alien Dictionary** (LeetCode #269) - ⭐ Common
    - Find alien dictionary order
    - Time: O(C), Space: O(1)
    - Hint: Topological sort

11. **Cheapest Flights Within K Stops** (LeetCode #787) - ⭐ Common
    - Find cheapest flight path
    - Time: O(E * K), Space: O(V)
    - Hint: BFS or Bellman-Ford

12. **Network Delay Time** (LeetCode #743) - ⭐ Common
    - Find network delay time
    - Time: O(E log V), Space: O(V+E)
    - Hint: Dijkstra's algorithm

13. **Island Perimeter** (LeetCode #463) - ⭐ Common
    - Calculate island perimeter
    - Time: O(mn), Space: O(1)
    - Hint: Count edges

14. **Rotting Oranges** (LeetCode #994) - ⭐ Common
    - Find minutes until all oranges rot
    - Time: O(mn), Space: O(mn)
    - Hint: BFS from all rotten oranges

15. **Accounts Merge** (LeetCode #721) - ⭐ Common
    - Merge accounts with common emails
    - Time: O(nk log nk), Space: O(nk)
    - Hint: Union-Find or DFS

### Dynamic Programming (15+ problems)
1. **Edit Distance** (LeetCode #72) - ⭐⭐ Common
   - Minimum operations to convert string
   - Time: O(mn), Space: O(min(m,n))
   - Hint: 2D DP

2. **Regular Expression Matching** (LeetCode #10) - ⭐ Common
   - Match string with pattern
   - Time: O(mn), Space: O(mn)
   - Hint: 2D DP with backtracking

3. **Wildcard Matching** (LeetCode #44) - ⭐ Common
   - Match string with wildcard pattern
   - Time: O(mn), Space: O(mn)
   - Hint: 2D DP

4. **Longest Valid Parentheses** (LeetCode #32) - ⭐ Common
   - Length of longest valid parentheses
   - Time: O(n), Space: O(n)
   - Hint: Stack or DP

5. **Minimum Insertions to Make Palindrome** (LeetCode #1312) - ⭐ Common
   - Minimum insertions for palindrome
   - Time: O(n²), Space: O(n²)
   - Hint: 2D DP

6. **Longest Increasing Path in Matrix** (LeetCode #329) - ⭐ Common
   - Find longest increasing path
   - Time: O(mn), Space: O(mn)
   - Hint: DFS with memoization

7. **Maximum Profit in Job Scheduling** (LeetCode #1235) - ⭐ Common
   - Maximum profit from jobs
   - Time: O(n log n), Space: O(n)
   - Hint: DP with binary search

8. **Palindrome Partitioning II** (LeetCode #132) - ⭐ Common
   - Minimum cuts for palindrome partition
   - Time: O(n²), Space: O(n²)
   - Hint: DP with palindrome check

9. **Burst Balloons** (LeetCode #312) - ⭐ Common
   - Maximum coins from bursting balloons
   - Time: O(n³), Space: O(n²)
   - Hint: Interval DP

10. **Scramble String** (LeetCode #87) - ⭐ Common
    - Check if strings are scrambled
    - Time: O(n⁴), Space: O(n³)
    - Hint: 3D DP

11. **Distinct Subsequences** (LeetCode #115) - ⭐ Common
    - Count distinct subsequences
    - Time: O(mn), Space: O(mn)
    - Hint: 2D DP

12. **Interleaving String** (LeetCode #97) - ⭐ Common
    - Check if string is interleaving
    - Time: O(mn), Space: O(mn)
    - Hint: 2D DP

13. **Best Time to Buy and Sell Stock IV** (LeetCode #188) - ⭐ Common
    - Maximum profit with k transactions
    - Time: O(nk), Space: O(k)
    - Hint: 2D DP

14. **Longest Common Subsequence** (LeetCode #1143) - ⭐ Common
    - Length of longest common subsequence
    - Time: O(mn), Space: O(min(m,n))
    - Hint: 2D DP

15. **Minimum Cost to Merge Stones** (LeetCode #1000) - ⭐ Common
    - Minimum cost to merge stones
    - Time: O(n³), Space: O(n²)
    - Hint: Interval DP

## 🎯 System Design Questions

### Easy
1. **Design a URL Shortener** - URL shortening service
2. **Design a Chat System** - Basic chat application
3. **Design a Parking Lot** - Parking lot management system
4. **Design a Library Management System** - Library system
5. **Design a Restaurant Management System** - Restaurant system

### Medium
1. **Design Microsoft Office Online** - Online office suite
2. **Design a Search Engine** - Search engine system
3. **Design a Distributed Cache** - Distributed caching system
4. **Design a Message Queue** - Message queue system
5. **Design a File Storage System** - File storage system

### Hard
1. **Design Microsoft Azure** - Cloud computing platform
2. **Design Microsoft Teams** - Video conferencing and collaboration
3. **Design Microsoft Office 365** - Productivity suite
4. **Design Microsoft Bing** - Search engine at scale
5. **Design Microsoft Xbox Live** - Gaming platform at scale

## 💡 Microsoft Values

### Behavioral Questions
1. **Growth Mindset** - How do you approach learning and development?
2. **Customer Obsession** - How do you prioritize customer needs?
3. **Diversity and Inclusion** - How do you promote inclusive environments?
4. **One Microsoft** - How do you collaborate across teams?
5. **Making a Difference** - How do you measure impact?

### Technical Leadership
1. **Technical Excellence** - How do you ensure code quality?
2. **Innovation** - How do you approach new technologies?
3. **Mentorship** - How do you help others grow?
4. **Problem Solving** - How do you approach complex problems?
5. **Communication** - How do you explain technical concepts?

## 📚 Resources

### Practice Platforms
- [LeetCode](https://leetcode.com/) - Coding problems
- [HackerRank](https://www.hackerrank.com/) - Algorithm practice
- [CodeSignal](https://codesignal.com/) - Technical assessments
- [Pramp](https://www.pramp.com/) - Mock interviews

### Study Materials
- [Cracking the Coding Interview](https://www.crackingthecodinginterview.com/)
- [System Design Primer](https://github.com/donnemartin/system-design-primer)
- [Microsoft's Engineering Blog](https://devblogs.microsoft.com/)
- [Microsoft's Technical Talks](https://www.youtube.com/user/MicrosoftDeveloper)

### Microsoft-Specific Resources
- [Microsoft's Open Source Projects](https://github.com/microsoft)
- [Microsoft's Research Publications](https://www.microsoft.com/en-us/research/)
- [Microsoft's Technical Blog](https://devblogs.microsoft.com/)
- [Microsoft's Developer Resources](https://developer.microsoft.com/)

## 🎯 Success Metrics

### Technical Skills
- **Problem-solving ability**: 40%
- **Coding proficiency**: 30%
- **System design skills**: 20%
- **Communication**: 10%

### Behavioral Skills
- **Growth mindset**: 30%
- **Collaboration skills**: 25%
- **Problem-solving approach**: 25%
- **Cultural fit**: 20%

---

**Remember**: Microsoft values both technical excellence and growth mindset. Practice consistently, think systematically, and communicate clearly. Good luck! 🚀
