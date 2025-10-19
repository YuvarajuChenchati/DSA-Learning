package datastructures.trees;

import java.util.*;

/**
 * Tree Implementation
 * 
 * This class contains essential tree operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class TreeOperations {
    
    /**
     * Binary Tree Node
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    /**
     * Preorder traversal (Root, Left, Right)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return List of values in preorder
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private static void preorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        result.add(root.val);
        preorderHelper(root.left, result);
        preorderHelper(root.right, result);
    }
    
    /**
     * Inorder traversal (Left, Root, Right)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return List of values in inorder
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private static void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        inorderHelper(root.left, result);
        result.add(root.val);
        inorderHelper(root.right, result);
    }
    
    /**
     * Postorder traversal (Left, Right, Root)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return List of values in postorder
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
    
    private static void postorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        postorderHelper(root.left, result);
        postorderHelper(root.right, result);
        result.add(root.val);
    }
    
    /**
     * Level order traversal (BFS)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param root Root of tree
     * @return List of lists for each level
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
    
    /**
     * Maximum depth of binary tree
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return Maximum depth
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    /**
     * Check if two trees are same
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param p First tree
     * @param q Second tree
     * @return True if same, false otherwise
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        return p.val == q.val && 
               isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }
    
    /**
     * Check if tree is symmetric
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return True if symmetric, false otherwise
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    
    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        
        return left.val == right.val &&
               isSymmetricHelper(left.left, right.right) &&
               isSymmetricHelper(left.right, right.left);
    }
    
    /**
     * Invert binary tree
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return Inverted tree
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
    
    /**
     * Check if path sum exists
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @param targetSum Target sum
     * @return True if path exists, false otherwise
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
    
    /**
     * Find all paths with target sum
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @param targetSum Target sum
     * @return List of all paths
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        pathSumHelper(root, targetSum, currentPath, result);
        return result;
    }
    
    private static void pathSumHelper(TreeNode root, int targetSum, 
                                    List<Integer> currentPath, 
                                    List<List<Integer>> result) {
        if (root == null) return;
        
        currentPath.add(root.val);
        
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            pathSumHelper(root.left, targetSum - root.val, currentPath, result);
            pathSumHelper(root.right, targetSum - root.val, currentPath, result);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
    /**
     * Validate Binary Search Tree
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return True if valid BST, false otherwise
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if (root == null) return true;
        
        if (root.val <= min || root.val >= max) return false;
        
        return isValidBSTHelper(root.left, min, root.val) &&
               isValidBSTHelper(root.right, root.val, max);
    }
    
    /**
     * Search in Binary Search Tree
     * 
     * Time Complexity: O(h) where h is height
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of BST
     * @param val Value to search
     * @return Node with value, or null if not found
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
    
    /**
     * Insert into Binary Search Tree
     * 
     * Time Complexity: O(h) where h is height
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of BST
     * @param val Value to insert
     * @return Root of modified BST
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
    
    /**
     * Delete from Binary Search Tree
     * 
     * Time Complexity: O(h) where h is height
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of BST
     * @param key Value to delete
     * @return Root of modified BST
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        
        return root;
    }
    
    private static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    /**
     * Find Lowest Common Ancestor
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @param p First node
     * @param q Second node
     * @return Lowest common ancestor
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    
    /**
     * Binary Tree Right Side View
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return List of right side view
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
    
    /**
     * Binary Tree Maximum Path Sum
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     * 
     * @param root Root of tree
     * @return Maximum path sum
     */
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }
    
    private static int maxPathSumHelper(TreeNode root, int[] maxSum) {
        if (root == null) return 0;
        
        int leftSum = Math.max(0, maxPathSumHelper(root.left, maxSum));
        int rightSum = Math.max(0, maxPathSumHelper(root.right, maxSum));
        
        int currentSum = root.val + leftSum + rightSum;
        maxSum[0] = Math.max(maxSum[0], currentSum);
        
        return root.val + Math.max(leftSum, rightSum);
    }
    
    /**
     * Serialize binary tree
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param root Root of tree
     * @return Serialized string
     */
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    
    /**
     * Deserialize binary tree
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param data Serialized string
     * @return Root of tree
     */
    public static TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};
        return deserializeHelper(values, index);
    }
    
    private static TreeNode deserializeHelper(String[] values, int[] index) {
        if (index[0] >= values.length || values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        root.left = deserializeHelper(values, index);
        root.right = deserializeHelper(values, index);
        
        return root;
    }
    
    /**
     * Main method for testing tree operations
     */
    public static void main(String[] args) {
        System.out.println("=== Tree Operations Examples ===");
        
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        // Test traversals
        System.out.println("Preorder: " + preorderTraversal(root));
        System.out.println("Inorder: " + inorderTraversal(root));
        System.out.println("Postorder: " + postorderTraversal(root));
        System.out.println("Level order: " + levelOrder(root));
        
        // Test tree properties
        System.out.println("Max depth: " + maxDepth(root));
        System.out.println("Is symmetric: " + isSymmetric(root));
        System.out.println("Has path sum 7: " + hasPathSum(root, 7));
        
        // Test BST operations
        TreeNode bst = new TreeNode(4);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(6);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(3);
        bst.right.left = new TreeNode(5);
        bst.right.right = new TreeNode(7);
        
        System.out.println("Is valid BST: " + isValidBST(bst));
        System.out.println("Search 5 in BST: " + (searchBST(bst, 5) != null));
        
        // Test right side view
        System.out.println("Right side view: " + rightSideView(root));
        
        // Test max path sum
        System.out.println("Max path sum: " + maxPathSum(root));
        
        // Test serialize/deserialize
        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);
        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized tree is same: " + isSameTree(root, deserialized));
    }
}
