package datastructures.graphs;

import java.util.*;

/**
 * Graph Implementation
 * 
 * This class contains essential graph operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class GraphOperations {
    
    /**
     * Graph representation using adjacency list
     */
    public static class Graph {
        private int V;
        private List<List<Integer>> adj;
        
        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
        
        /**
         * Add edge to graph
         * 
         * @param u Source vertex
         * @param v Destination vertex
         */
        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // For undirected graph
        }
        
        /**
         * Add directed edge to graph
         * 
         * @param u Source vertex
         * @param v Destination vertex
         */
        public void addDirectedEdge(int u, int v) {
            adj.get(u).add(v);
        }
        
        /**
         * Get adjacency list
         * 
         * @return Adjacency list
         */
        public List<List<Integer>> getAdj() {
            return adj;
        }
        
        /**
         * Get number of vertices
         * 
         * @return Number of vertices
         */
        public int getV() {
            return V;
        }
    }
    
    /**
     * DFS traversal of graph
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Graph to traverse
     * @param start Starting vertex
     * @return List of vertices in DFS order
     */
    public static List<Integer> dfs(Graph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getV()];
        dfsHelper(graph, start, visited, result);
        return result;
    }
    
    private static void dfsHelper(Graph graph, int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);
        
        for (int neighbor : graph.getAdj().get(v)) {
            if (!visited[neighbor]) {
                dfsHelper(graph, neighbor, visited, result);
            }
        }
    }
    
    /**
     * BFS traversal of graph
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Graph to traverse
     * @param start Starting vertex
     * @return List of vertices in BFS order
     */
    public static List<Integer> bfs(Graph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getV()];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.add(v);
            
            for (int neighbor : graph.getAdj().get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
    
    /**
     * Check if graph has cycle using DFS
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Graph to check
     * @return True if cycle exists, false otherwise
     */
    public static boolean hasCycle(Graph graph) {
        boolean[] visited = new boolean[graph.getV()];
        boolean[] recStack = new boolean[graph.getV()];
        
        for (int i = 0; i < graph.getV(); i++) {
            if (!visited[i]) {
                if (hasCycleHelper(graph, i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean hasCycleHelper(Graph graph, int v, boolean[] visited, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;
        
        for (int neighbor : graph.getAdj().get(v)) {
            if (!visited[neighbor]) {
                if (hasCycleHelper(graph, neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }
        
        recStack[v] = false;
        return false;
    }
    
    /**
     * Topological sort using DFS
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Directed graph
     * @return Topological order
     */
    public static List<Integer> topologicalSort(Graph graph) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getV()];
        
        for (int i = 0; i < graph.getV(); i++) {
            if (!visited[i]) {
                topologicalSortHelper(graph, i, visited, result);
            }
        }
        
        Collections.reverse(result);
        return result;
    }
    
    private static void topologicalSortHelper(Graph graph, int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        
        for (int neighbor : graph.getAdj().get(v)) {
            if (!visited[neighbor]) {
                topologicalSortHelper(graph, neighbor, visited, result);
            }
        }
        
        result.add(v);
    }
    
    /**
     * Find shortest path using BFS
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Graph
     * @param start Starting vertex
     * @param end Ending vertex
     * @return Shortest path distance
     */
    public static int shortestPath(Graph graph, int start, int end) {
        boolean[] visited = new boolean[graph.getV()];
        int[] distance = new int[graph.getV()];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            
            if (v == end) {
                return distance[v];
            }
            
            for (int neighbor : graph.getAdj().get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[v] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return -1; // No path found
    }
    
    /**
     * Count connected components
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Graph
     * @return Number of connected components
     */
    public static int countConnectedComponents(Graph graph) {
        boolean[] visited = new boolean[graph.getV()];
        int count = 0;
        
        for (int i = 0; i < graph.getV(); i++) {
            if (!visited[i]) {
                dfsHelper(graph, i, visited, new ArrayList<>());
                count++;
            }
        }
        return count;
    }
    
    /**
     * Check if graph is bipartite
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Graph
     * @return True if bipartite, false otherwise
     */
    public static boolean isBipartite(Graph graph) {
        int[] color = new int[graph.getV()];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < graph.getV(); i++) {
            if (color[i] == -1) {
                if (!isBipartiteHelper(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isBipartiteHelper(Graph graph, int v, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        color[v] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.getAdj().get(current)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[current];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[current]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Find strongly connected components using Kosaraju's algorithm
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * 
     * @param graph Directed graph
     * @return List of strongly connected components
     */
    public static List<List<Integer>> stronglyConnectedComponents(Graph graph) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getV()];
        Stack<Integer> stack = new Stack<>();
        
        // First pass: fill stack
        for (int i = 0; i < graph.getV(); i++) {
            if (!visited[i]) {
                fillStack(graph, i, visited, stack);
            }
        }
        
        // Create transpose graph
        Graph transpose = getTranspose(graph);
        
        // Second pass: process vertices in reverse order
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                dfsHelper(transpose, v, visited, component);
                result.add(component);
            }
        }
        
        return result;
    }
    
    private static void fillStack(Graph graph, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        
        for (int neighbor : graph.getAdj().get(v)) {
            if (!visited[neighbor]) {
                fillStack(graph, neighbor, visited, stack);
            }
        }
        
        stack.push(v);
    }
    
    private static Graph getTranspose(Graph graph) {
        Graph transpose = new Graph(graph.getV());
        
        for (int v = 0; v < graph.getV(); v++) {
            for (int neighbor : graph.getAdj().get(v)) {
                transpose.addDirectedEdge(neighbor, v);
            }
        }
        
        return transpose;
    }
    
    /**
     * Main method for testing graph operations
     */
    public static void main(String[] args) {
        System.out.println("=== Graph Operations Examples ===");
        
        // Create a sample graph
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        
        // Test DFS
        System.out.println("DFS from vertex 0: " + dfs(graph, 0));
        
        // Test BFS
        System.out.println("BFS from vertex 0: " + bfs(graph, 0));
        
        // Test cycle detection
        System.out.println("Has cycle: " + hasCycle(graph));
        
        // Test connected components
        System.out.println("Connected components: " + countConnectedComponents(graph));
        
        // Test bipartite
        System.out.println("Is bipartite: " + isBipartite(graph));
        
        // Test shortest path
        System.out.println("Shortest path from 0 to 5: " + shortestPath(graph, 0, 5));
        
        // Test strongly connected components
        Graph directedGraph = new Graph(5);
        directedGraph.addDirectedEdge(0, 1);
        directedGraph.addDirectedEdge(1, 2);
        directedGraph.addDirectedEdge(2, 0);
        directedGraph.addDirectedEdge(1, 3);
        directedGraph.addDirectedEdge(3, 4);
        
        System.out.println("Strongly connected components: " + stronglyConnectedComponents(directedGraph));
    }
}
