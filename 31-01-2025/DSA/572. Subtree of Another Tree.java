/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Definition for TreeNode (assuming it's already defined in your environment)
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {
    
    // Helper function to check if two trees are identical
    public boolean isIdentical(TreeNode node, TreeNode subRoot) {
        // Base Case: If both nodes are null, they are identical
        if (node == null && subRoot == null) return true;
        
        // If one is null and the other isn't, or values don't match, they are not identical
        if (node == null || subRoot == null || node.val != subRoot.val) {
            return false;
        }

        // Recursively check if left subtrees and right subtrees are identical
        if (!isIdentical(node.left, subRoot.left)) return false;
        if (!isIdentical(node.right, subRoot.right)) return false;

        // If both left and right subtrees match, return true
        return true;
    }

    // Function to check if subRoot is a subtree of root
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base Case: If the main tree (root) is null, subRoot can't be a subtree
        if (root == null) {
            return false;
        }

        // If the current node matches the subRoot's value, check if the subtrees are identical
        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot)) {
                return true; // If identical, subRoot is found in root
            }
        }

        // Recursively check if subRoot is a subtree in the left or right subtree of root
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        // Return true if subRoot is found in either left or right subtree
        return left || right;
    }
}


/*

In summary, the approach is:

- For each node in the main tree, check if the subtree starting there matches subRoot.

- To check if two trees are identical, recursively compare each node's value and structure.

- If any node in the main tree leads to an identical subtree, return true; otherwise, false.

This combines a traversal of the main tree (using isSubtree) with a structural comparison (using isIdentical). The recursion in both methods allows for efficient checking without needing to track nodes manually.

*/