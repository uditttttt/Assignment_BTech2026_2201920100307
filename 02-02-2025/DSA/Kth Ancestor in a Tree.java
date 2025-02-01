import java.util.*;

class Solution {

    // Recursive function to find the path to the target node
    public void solve(Node root, int node, List<Integer> ans, List<Integer> result) {
        if (root == null) return;  // Base case: If we reach a null node, return.

        if (root.data == node) {
            ans.addAll(result);  // Store the path when we find the target node.
            return;
        }

        result.add(root.data);  // Add current node to path before recursion.

        solve(root.left, node, ans, result);  // Search in the left subtree.
        solve(root.right, node, ans, result);  // Search in the right subtree.

        result.remove(result.size() - 1);  // Backtrack: Remove last node after recursion.
    }

    public int kthAncestor(Node root, int k, int node) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        solve(root, node, ans, result);

        if (ans.size() < k) return -1;  // If not enough ancestors exist, return -1.

        return ans.get(ans.size() - k);  // Return the k-th ancestor.
    }
}
