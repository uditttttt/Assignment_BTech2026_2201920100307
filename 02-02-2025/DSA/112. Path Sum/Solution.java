class Solution {
  // Helper function to check if there's a root-to-leaf path with the given targetSum
  public boolean solve(TreeNode root, int targetSum) {
      // If the node is null, there's no path, so return false
      if (root == null) return false;

      // Check if the node is a leaf (no left or right child)
      if (root.left == null && root.right == null) {
          // If it's a leaf node, check if targetSum is exactly equal to node's value
          return targetSum == root.val;
      }

      // Recursively check the left subtree with the updated targetSum (subtract current node's value)
      boolean left = solve(root.left, targetSum - root.val);

      // Recursively check the right subtree with the updated targetSum
      boolean right = solve(root.right, targetSum - root.val);

      // If any of the subtrees return true, that means there's a valid path, so return true
      return left || right;
  }

  // Main function called by users
  public boolean hasPathSum(TreeNode root, int targetSum) {
      // Simply calls the helper function with the given root and targetSum
      return solve(root, targetSum);
  }
}
