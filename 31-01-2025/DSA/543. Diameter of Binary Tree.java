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
 
 // optimised
 class Solution {

    // Helper method to calculate subtree heights and update the diameter
    public int solve(TreeNode root, int[] diameter) {
        // Base case: if the current node is null, the height is 0
        if (root == null) return 0;

        // 1. Recursively get heights of left and right subtrees
        // - This traverses all the way down to leaf nodes first (post-order traversal)
        int leftHeight = solve(root.left, diameter);
        int rightHeight = solve(root.right, diameter);

        // 2. Update the diameter at THIS NODE
        // - The potential longest path through this node is leftHeight + rightHeight
        // - We compare it with the current maximum diameter
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // 3. Return THIS SUBTREE'S height to parent nodes
        // - Height = 1 (current node) + max of left/right subtree heights
        // - This propagates height information upward for diameter calculations
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Main method to calculate tree diameter
    public int diameterOfBinaryTree(TreeNode root) {
        // Use a single-element array to simulate pass-by-reference
        // (Java can't pass primitive types by reference)
        int[] diameter = new int[1]; // Default value is [0]
        
        // Start the recursive calculation from the root
        solve(root, diameter);
        
        // After recursion completes, diameter[0] holds the final result
        return diameter[0];
    }
}
// tc = o(n^2)
// class Solution {
//     public int height(TreeNode root){
//         if(root == null) return 0;
//         int lh = height(root.left);
//         int rh = height(root.right);
//         return Math.max(lh , rh) + 1;
//     }
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null) return 0;
//         // for finding diameter of left subtree
//         int ld = diameterOfBinaryTree(root.left);
//         // for finding diameter of right subtree
//         int rd = diameterOfBinaryTree(root.right);
//         // for finding diameter through root node
//         int lh = height(root.left);
//         int rh = height(root.right);
//         // as we'r calculating diameter in terms of edge and 
//         // height in terms of edge = height in terms of root - 1
//         int selfDiameter = (lh + rh + 1 )- 1; 

//         return Math.max(selfDiameter , Math.max(ld , rd));
//     }
// }