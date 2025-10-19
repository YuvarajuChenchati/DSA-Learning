# Graphs 📊

> **Master graph data structures and graph algorithms**

## 🎯 Learning Objectives

- Understand graph fundamentals
- Master graph representations
- Learn graph algorithms
- Apply graph patterns to solve problems

## 📚 Theory

### Graph Basics

#### Properties
- **Vertices (Nodes)**: Points in the graph
- **Edges**: Connections between vertices
- **Directed/Undirected**: Edge direction matters
- **Weighted/Unweighted**: Edge weights
- **Connected/Disconnected**: Path between all vertices

#### Common Operations
- **Traversal**: O(V + E) time - visit all vertices
- **Shortest Path**: O(V log V + E) time - Dijkstra's
- **Minimum Spanning Tree**: O(E log V) time - Kruskal's
- **Topological Sort**: O(V + E) time - DAG ordering

### Graph Representations

#### Adjacency List
- **Space**: O(V + E)
- **Add Edge**: O(1)
- **Check Edge**: O(degree)
- **Best for**: Sparse graphs

#### Adjacency Matrix
- **Space**: O(V²)
- **Add Edge**: O(1)
- **Check Edge**: O(1)
- **Best for**: Dense graphs

## 🔧 Implementation

### Basic Graph Operations

```java
// Graph using adjacency list
class Graph {
    private int V;
    private List<List<Integer>> adj;
    
    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // For undirected graph
    }
}
```

### Graph Traversals

```java
// DFS traversal
public void dfs(int start) {
    boolean[] visited = new boolean[V];
    dfsHelper(start, visited);
}

private void dfsHelper(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    
    for (int neighbor : adj.get(v)) {
        if (!visited[neighbor]) {
            dfsHelper(neighbor, visited);
        }
    }
}

// BFS traversal
public void bfs(int start) {
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[start] = true;
    queue.offer(start);
    
    while (!queue.isEmpty()) {
        int v = queue.poll();
        System.out.print(v + " ");
        
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

## 📝 Practice Problems

### Easy
1. **Number of Islands** - O(mn) time, O(mn) space
2. **Flood Fill** - O(mn) time, O(mn) space
3. **Find the Town Judge** - O(n) time, O(n) space
4. **Find Center of Star Graph** - O(1) time, O(1) space
5. **Find if Path Exists in Graph** - O(V + E) time, O(V) space

### Medium
1. **Course Schedule** - O(V + E) time, O(V) space
2. **Redundant Connection** - O(V + E) time, O(V) space
3. **Number of Connected Components** - O(V + E) time, O(V) space
4. **Graph Valid Tree** - O(V + E) time, O(V) space
5. **Minimum Number of Vertices to Reach All Nodes** - O(V + E) time, O(V) space

### Hard
1. **Critical Connections in a Network** - O(V + E) time, O(V) space
2. **Word Ladder** - O(M²N) time, O(MN) space
3. **Word Ladder II** - O(M²N) time, O(MN) space
4. **Reconstruct Itinerary** - O(E log E) time, O(E) space
5. **Minimum Cost to Connect All Points** - O(E log E) time, O(V) space

## 💡 Key Insights

- **DFS**: Use for path finding, cycle detection
- **BFS**: Use for shortest path, level order
- **Union-Find**: Use for connectivity problems
- **Topological Sort**: Use for dependency resolution
- **Shortest Path**: Use Dijkstra's or BFS

## 🎯 Interview Tips

- Choose appropriate representation
- Consider directed vs undirected
- Think about weighted vs unweighted
- Use DFS for exploration, BFS for shortest path
- Consider space-time tradeoffs

## 📚 Additional Resources

- [Graph Data Structure](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
- [Graph Traversals](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/)
- [Shortest Path Algorithms](https://www.geeksforgeeks.org/shortest-path-unweighted-graph/)
- [Minimum Spanning Tree](https://www.geeksforgeeks.org/minimum-spanning-tree/)
