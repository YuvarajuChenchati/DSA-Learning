# Graph Problems 🕸️

> **Comprehensive collection of graph problems organized by difficulty**

## 🎯 Problem Categories

### Easy Problems (10+)

1. **Find the Town Judge** (LeetCode #997) - ⭐ Common
   - Find town judge with trust relationships
   - Time: O(n), Space: O(n)
   - Hint: Count in-degree and out-degree

2. **Find Center of Star Graph** (LeetCode #1791) - ⭐ Common
   - Find center of star graph
   - Time: O(1), Space: O(1)
   - Hint: Check first two edges

3. **Number of Provinces** (LeetCode #547) - ⭐⭐ Common
   - Count number of connected components
   - Time: O(n²), Space: O(n)
   - Hint: DFS or Union-Find

4. **Flood Fill** (LeetCode #733) - ⭐ Common
   - Flood fill algorithm
   - Time: O(mn), Space: O(mn)
   - Hint: DFS or BFS

5. **Island Perimeter** (LeetCode #463) - ⭐ Common
   - Calculate island perimeter
   - Time: O(mn), Space: O(1)
   - Hint: Count edges

6. **Find if Path Exists in Graph** (LeetCode #1971) - ⭐ Common
   - Check if path exists between nodes
   - Time: O(V+E), Space: O(V+E)
   - Hint: DFS or BFS

7. **All Paths From Source to Target** (LeetCode #797) - ⭐ Common
   - Find all paths from source to target
   - Time: O(2^V * V), Space: O(V)
   - Hint: DFS with backtracking

8. **Keys and Rooms** (LeetCode #841) - ⭐ Common
   - Check if can visit all rooms
   - Time: O(V+E), Space: O(V)
   - Hint: DFS from room 0

9. **Employee Importance** (LeetCode #690) - ⭐ Common
   - Calculate employee importance
   - Time: O(n), Space: O(n)
   - Hint: DFS or BFS

10. **Network Delay Time** (LeetCode #743) - ⭐ Common
    - Find network delay time
    - Time: O(E log V), Space: O(V+E)
    - Hint: Dijkstra's algorithm

### Medium Problems (20+)

1. **Number of Islands** (LeetCode #200) - ⭐⭐⭐ Very Common
   - Count number of islands
   - Time: O(mn), Space: O(mn)
   - Hint: DFS or BFS

2. **Course Schedule** (LeetCode #207) - ⭐⭐⭐ Very Common
   - Check if courses can be completed
   - Time: O(V+E), Space: O(V+E)
   - Hint: Topological sort or DFS cycle detection

3. **Clone Graph** (LeetCode #133) - ⭐⭐ Common
   - Clone undirected graph
   - Time: O(V+E), Space: O(V)
   - Hint: DFS with hash map

4. **Word Ladder** (LeetCode #127) - ⭐⭐ Common
   - Shortest transformation sequence
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS

5. **Course Schedule II** (LeetCode #210) - ⭐⭐ Common
   - Return course order
   - Time: O(V+E), Space: O(V+E)
   - Hint: Topological sort

6. **Redundant Connection** (LeetCode #684) - ⭐ Common
   - Find edge that creates cycle
   - Time: O(n), Space: O(n)
   - Hint: Union-Find

7. **Number of Connected Components** (LeetCode #323) - ⭐ Common
   - Count connected components
   - Time: O(V+E), Space: O(V+E)
   - Hint: DFS or Union-Find

8. **Graph Valid Tree** (LeetCode #261) - ⭐ Common
   - Check if graph is valid tree
   - Time: O(V+E), Space: O(V+E)
   - Hint: DFS and check cycles

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

13. **Rotting Oranges** (LeetCode #994) - ⭐ Common
    - Find minutes until all oranges rot
    - Time: O(mn), Space: O(mn)
    - Hint: Multi-source BFS

14. **Shortest Path in Binary Matrix** (LeetCode #1091) - ⭐ Common
    - Shortest path in binary matrix
    - Time: O(mn), Space: O(mn)
    - Hint: BFS

15. **As Far from Land as Possible** (LeetCode #1162) - ⭐ Common
    - Find cell farthest from land
    - Time: O(mn), Space: O(mn)
    - Hint: Multi-source BFS

16. **Pacific Atlantic Water Flow** (LeetCode #417) - ⭐ Common
    - Find cells that can flow to both oceans
    - Time: O(mn), Space: O(mn)
    - Hint: DFS from both oceans

17. **Surrounded Regions** (LeetCode #130) - ⭐ Common
    - Capture surrounded regions
    - Time: O(mn), Space: O(mn)
    - Hint: DFS from borders

18. **Walls and Gates** (LeetCode #286) - ⭐ Common
    - Fill empty rooms with distance to nearest gate
    - Time: O(mn), Space: O(mn)
    - Hint: Multi-source BFS

19. **Evaluate Division** (LeetCode #399) - ⭐ Common
    - Evaluate division equations
    - Time: O(n * m), Space: O(n)
    - Hint: Build graph and DFS

20. **Is Graph Bipartite?** (LeetCode #785) - ⭐ Common
    - Check if graph is bipartite
    - Time: O(V+E), Space: O(V)
    - Hint: Graph coloring

### Hard Problems (15+)

1. **Critical Connections in a Network** (LeetCode #1192) - ⭐⭐ Common
   - Find critical connections
   - Time: O(V+E), Space: O(V+E)
   - Hint: Tarjan's algorithm

2. **Word Ladder II** (LeetCode #126) - ⭐ Common
   - All shortest transformation sequences
   - Time: O(M * N), Space: O(M * N)
   - Hint: BFS + backtracking

3. **Minimum Cost to Connect All Points** (LeetCode #1584) - ⭐ Common
   - Minimum cost to connect points
   - Time: O(n² log n), Space: O(n²)
   - Hint: Kruskal's algorithm

4. **Course Schedule III** (LeetCode #630) - ⭐ Common
   - Maximum courses that can be taken
   - Time: O(n log n), Space: O(n)
   - Hint: Greedy + priority queue

5. **Swim in Rising Water** (LeetCode #778) - ⭐ Common
   - Minimum time to reach bottom right
   - Time: O(n² log n), Space: O(n²)
   - Hint: Binary search + DFS

6. **Minimum Cost to Make at Least One Valid Path** (LeetCode #1368) - ⭐ Common
   - Minimum cost for valid path
   - Time: O(mn), Space: O(mn)
   - Hint: BFS with 0-1 weights

7. **Shortest Path in a Grid with Obstacles Elimination** (LeetCode #1293) - ⭐ Common
   - Shortest path with k obstacles
   - Time: O(mn*k), Space: O(mn*k)
   - Hint: BFS with state

8. **Parallel Courses III** (LeetCode #2050) - ⭐ Common
   - Minimum time to complete courses
   - Time: O(V+E), Space: O(V+E)
   - Hint: Topological sort + DP

9. **Maximum Employees to Be Invited to a Meeting** (LeetCode #2127) - ⭐ Common
   - Maximum employees for meeting
   - Time: O(n), Space: O(n)
   - Hint: Cycle detection + DP

10. **Find Critical and Pseudo-Critical Edges** (LeetCode #1489) - ⭐ Common
    - Find critical and pseudo-critical edges in MST
    - Time: O(E²), Space: O(V+E)
    - Hint: Kruskal's algorithm variants

11. **Minimum Weighted Subgraph** (LeetCode #2204) - ⭐ Common
    - Find minimum weighted subgraph
    - Time: O(V+E), Space: O(V+E)
    - Hint: Shortest path variants

12. **Detonate Maximum Bombs** (LeetCode #2101) - ⭐ Common
    - Maximum bombs that can be detonated
    - Time: O(n²), Space: O(n²)
    - Hint: Build graph and DFS

13. **Longest Cycle in a Graph** (LeetCode #2360) - ⭐ Common
    - Find longest cycle in graph
    - Time: O(V+E), Space: O(V)
    - Hint: DFS with cycle detection

14. **Count Unreachable Pairs** (LeetCode #2316) - ⭐ Common
    - Count unreachable pairs of nodes
    - Time: O(V+E), Space: O(V)
    - Hint: Find connected components

15. **Maximum Star Sum of a Graph** (LeetCode #2497) - ⭐ Common
    - Maximum star sum
    - Time: O(V+E), Space: O(V)
    - Hint: Greedy selection

## 💡 Problem-Solving Strategies

### Graph Traversal Patterns
- **DFS**: For path finding, cycle detection, connected components
- **BFS**: For shortest path, level-order traversal
- **Topological Sort**: For dependency ordering, cycle detection
- **Union-Find**: For connectivity, cycle detection

### Common Approaches
1. **Adjacency List**: Most common representation
2. **Adjacency Matrix**: For dense graphs
3. **DFS Recursive**: Natural for tree-like structures
4. **DFS Iterative**: Use stack for explicit control
5. **BFS**: Use queue for level-order traversal

### Graph Algorithms
- **Shortest Path**: Dijkstra, Bellman-Ford, Floyd-Warshall
- **Minimum Spanning Tree**: Kruskal, Prim
- **Cycle Detection**: DFS with visited/recursion stack
- **Topological Sort**: Kahn's algorithm or DFS

## 🎯 Practice Recommendations

### For Beginners
- Start with Easy problems (Number of Provinces, Flood Fill)
- Focus on basic DFS/BFS
- Practice with 2-3 problems per day
- Time yourself (15-20 minutes per problem)

### For Intermediate
- Practice Medium problems (Number of Islands, Course Schedule)
- Focus on advanced algorithms
- Practice with 3-5 problems per day
- Time yourself (30-45 minutes per problem)

### For Advanced
- Practice Hard problems (Critical Connections, Word Ladder II)
- Focus on complex graph algorithms
- Practice with 2-3 problems per day
- Time yourself (45-60 minutes per problem)

## 📚 Additional Resources

- [LeetCode Graph Problems](https://leetcode.com/tag/graph/)
- [GeeksforGeeks Graph Data Structure](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
- [HackerRank Graph Problems](https://www.hackerrank.com/domains/algorithms/graph-theory)

---

**Remember**: Practice consistently, understand graph representations, and master traversal algorithms. Good luck! 🚀
