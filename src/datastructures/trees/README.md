# Trees 🌳

> **Master tree data structures and tree-based algorithms**

## 🎯 Learning Objectives

- Understand tree fundamentals
- Master tree operations
- Learn tree-based algorithms
- Apply tree patterns to solve problems

## 📚 Theory

### Tree Basics

#### Properties
- **Hierarchical structure**: Parent-child relationships
- **Root node**: Topmost node with no parent
- **Leaf nodes**: Nodes with no children
- **Height**: Longest path from root to leaf
- **Depth**: Distance from root to a node

#### Common Operations
- **Traversal**: O(n) time - visit all nodes
- **Search**: O(log n) time for balanced trees
- **Insertion**: O(log n) time for balanced trees
- **Deletion**: O(log n) time for balanced trees

### Tree Types

#### Binary Tree
- Each node has at most 2 children
- Left and right subtrees
- Can be unbalanced

#### Binary Search Tree (BST)
- Left child < parent < right child
- Efficient search, insertion, deletion
- Can become unbalanced

#### Balanced Trees
- **AVL Tree**: Height-balanced
- **Red-Black Tree**: Color-balanced
- **B-Tree**: Multi-way balanced

#### Special Trees
- **Trie**: Prefix tree for strings
- **Segment Tree**: Range queries
- **Fenwick Tree**: Prefix sums

## 🔧 Implementation

### Basic Tree Operations

```java
// Binary Tree Node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

// Tree Traversals
public void preorder(TreeNode root) {
    if (root == null) return;
    
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}

public void inorder(TreeNode root) {
    if (root == null) return;
    
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}

public void postorder(TreeNode root) {
    if (root == null) return;
    
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```

### Binary Search Tree

```java
// BST Operations
public TreeNode search(TreeNode root, int val) {
    if (root == null || root.val == val) {
        return root;
    }
    
    if (val < root.val) {
        return search(root.left, val);
    } else {
        return search(root.right, val);
    }
}

public TreeNode insert(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    
    if (val < root.val) {
        root.left = insert(root.left, val);
    } else if (val > root.val) {
        root.right = insert(root.right, val);
    }
    
    return root;
}
```

## 📝 Practice Problems

### Easy
1. **Maximum Depth of Binary Tree** - O(n) time, O(h) space
2. **Same Tree** - O(n) time, O(h) space
3. **Symmetric Tree** - O(n) time, O(h) space
4. **Invert Binary Tree** - O(n) time, O(h) space
5. **Path Sum** - O(n) time, O(h) space

### Medium
1. **Binary Tree Level Order Traversal** - O(n) time, O(n) space
2. **Construct Binary Tree from Preorder and Inorder** - O(n) time, O(n) space
3. **Validate Binary Search Tree** - O(n) time, O(h) space
4. **Lowest Common Ancestor** - O(n) time, O(h) space
5. **Binary Tree Right Side View** - O(n) time, O(h) space

### Hard
1. **Serialize and Deserialize Binary Tree** - O(n) time, O(n) space
2. **Binary Tree Maximum Path Sum** - O(n) time, O(h) space
3. **Word Search II** - O(mn * 4^L) time, O(L) space
4. **Count Complete Tree Nodes** - O(log n) time, O(1) space
5. **Binary Tree Postorder Traversal** - O(n) time, O(h) space

## 💡 Key Insights

- **Recursion**: Natural for tree problems
- **Traversal patterns**: Preorder, inorder, postorder
- **BST properties**: Left < root < right
- **Balanced trees**: Maintain height balance
- **Tree DP**: Bottom-up or top-down approaches

## ⚠️ Common Mistakes

### Null Pointer Exceptions
- **Problem**: Not checking for null before accessing node
- **Solution**: Always check `node != null` before `node.left` or `node.right`
- **Example**: `if (root != null && root.left != null)` before accessing root.left

### Incorrect BST Property
- **Problem**: Not maintaining BST property correctly
- **Solution**: Remember left < root < right for BST
- **Example**: Check `root.val > left.val && root.val < right.val` for BST

### Stack Overflow in Recursion
- **Problem**: Deep recursion causing stack overflow
- **Solution**: Use iterative approach or tail recursion for deep trees
- **Example**: Use `Stack<TreeNode>` for iterative traversal instead of recursion

### Wrong Traversal Order
- **Problem**: Using wrong traversal order
- **Solution**: Understand preorder (root-left-right), inorder (left-root-right), postorder (left-right-root)
- **Example**: Use inorder for BST to get sorted order

### Incorrect Height Calculation
- **Problem**: Not calculating height correctly
- **Solution**: Height is number of edges from root to deepest leaf
- **Example**: Empty tree has height -1, single node has height 0

### Not Handling Empty Tree
- **Problem**: Not checking for empty tree
- **Solution**: Always check `root == null` first
- **Example**: `if (root == null) return 0;` before processing

### Memory Leaks in Deletion
- **Problem**: Not properly disconnecting nodes
- **Solution**: Set parent's child pointer to null when deleting
- **Example**: `parent.left = null;` or `parent.right = null;` when deleting child

### Infinite Loops in Tree Traversal
- **Problem**: Creating cycles or not marking visited nodes
- **Solution**: Use visited set or ensure tree structure is correct
- **Example**: Mark visited nodes in graph-like tree traversal

## 🎯 Interview Tips

- Always consider null cases
- Use recursion for natural solutions
- Think about traversal order
- Consider space complexity of recursion
- Use iterative approaches for optimization

## 📚 Additional Resources

- [Tree Data Structure](https://www.geeksforgeeks.org/binary-tree-data-structure/)
- [Binary Search Tree](https://www.geeksforgeeks.org/binary-search-tree-data-structure/)
- [Tree Traversals](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)
- [Balanced Trees](https://www.geeksforgeeks.org/balanced-binary-tree/)
