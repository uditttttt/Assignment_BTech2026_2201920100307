import java.util.*;

class Solution {

    // Helper function to find the path from root to the target node
    private void solve(TreeNode root, int node, List<Integer> ans, List<Integer> result) {
        if (root == null) return;  
        // **Why?** If the tree is empty or we reach a leaf node with no children, we stop recursion.
        
        if (root.val == node) { 
            ans.addAll(result);  
            // **Why?** If we find the target node, we store the path taken so far into `ans`.
            return;  
            // **Why?** No need to explore further, as we already found the target node.
        }

        result.add(root.val);  
        // **Why?** We are adding the current node to `result`, as it is part of the path we are exploring.

        solve(root.left, node, ans, result);  
        // **Why?** Try to find the node in the left subtree first.

        solve(root.right, node, ans, result);  
        // **Why?** If not found in the left subtree, explore the right subtree.

        result.remove(result.size() - 1);  
        // **Why?** This is **backtracking** - if the node was not found in this path, we remove the last added node.
        // This ensures we are only keeping the correct path and not incorrect paths in `result`.
    }

    public int kthAncestor(TreeNode root, int k, int node) {
        List<Integer> ans = new ArrayList<>();
        // **Why?** `ans` will store the correct path from root to target node after recursion.

        List<Integer> result = new ArrayList<>();
        // **Why?** `result` stores the current path during traversal.

        solve(root, node, ans, result);
        // **Why?** This function call finds the path from root to `node` and stores it in `ans`.

        if (ans.size() < k) return -1;  
        // **Why?** If there are fewer than `k` ancestors, return -1 since the `k-th` ancestor doesn’t exist.

        return ans.get(ans.size() - k);  
        // **Why?** The `k-th` ancestor is at index `size - k` in `ans` list.
    }
}