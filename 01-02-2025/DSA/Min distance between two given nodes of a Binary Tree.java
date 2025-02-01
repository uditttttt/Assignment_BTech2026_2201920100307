class GfG {
  // Helper method to find the Lowest Common Ancestor (LCA) of nodes with values `a` and `b`
  Node findLca(Node root, int a, int b) {
      // Base Case 1: If tree is empty or current node is `a` or `b`, return it as LCA candidate
      if (root == null || root.data == a || root.data == b) {
          return root;
      }

      // Recursively search for LCA in left and right subtrees
      Node left = findLca(root.left, a, b);  // Result from left subtree
      Node right = findLca(root.right, a, b); // Result from right subtree

      // Case 1: If `a` and `b` are found in different subtrees, current root is the LCA
      if (left != null && right != null) {
          return root;
      }
      // Case 2: If only left subtree contains LCA candidate, return it
      else if (left != null) {
          return left;
      }
      // Case 3: If only right subtree contains LCA candidate, return it
      else {
          return right;
      }
  }

  // Helper method to compute distance from `root` to node with value `n`
  int dis(Node root, int n, int depth) {
      // Base Case 1: Node not found in this subtree
      if (root == null) {
          return -1;
      }
      // Base Case 2: Found the target node `n` at current depth
      if (root.data == n) {
          return depth; // Return the accumulated depth
      }

      // Recursively search left and right subtrees, incrementing depth by 1 (for the current edge)
      int left = dis(root.left, n, depth + 1);  // Check left subtree
      int right = dis(root.right, n, depth + 1); // Check right subtree

      // Return the valid distance (if found in left or right subtree)
      return (left != -1) ? left : right; // Prioritize left result if valid
  }

  // Main method to calculate the minimum distance between nodes `a` and `b`
  int findDist(Node root, int a, int b) {
      // Step 1: Find the LCA of nodes `a` and `b`
      Node lca = findLca(root, a, b);

      // Step 2: Calculate distance from LCA to `a` (starts at depth 0)
      int dist1 = dis(lca, a, 0);

      // Step 3: Calculate distance from LCA to `b` (starts at depth 0)
      int dist2 = dis(lca, b, 0);

      // Step 4: Total distance = sum of distances from LCA to `a` and `b`
      return dist1 + dist2;
  }
}