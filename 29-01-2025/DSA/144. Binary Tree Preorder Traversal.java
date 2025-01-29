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

 class Solution {
    public void solve(TreeNode root ,ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        solve(root.left,ans);
        solve(root.right,ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root , ans);
        return ans;
    }
}

/*

Preorder traversal means visiting the root first, then the left subtree, and then the right subtree. 

Steps to Perform Preorder Traversal
For a given BST:

Visit the root node and add its value to the result.
Recur(traverse) for the left subtree.
Recur(traverse) for the right subtree.

*/