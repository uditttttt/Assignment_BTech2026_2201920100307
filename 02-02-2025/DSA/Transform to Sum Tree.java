// Class definition for a binary tree node
class Node {
  int data;
  Node left, right;
  
  Node(int item) {
      data = item;
      left = right = null;
  }
}

public class SumTreeConverter {

  // Main function that converts the tree into a sum tree
  public void toSumTree(Node root) {
      toSumTreeUtil(root);
  }

  // Helper function that converts the tree to a sum tree.
  // It returns the sum of the subtree rooted at the given node
  // (including the original value at the node) before modification.
  private int toSumTreeUtil(Node node) {
      // Base case: empty node contributes 0 to the sum.
      if (node == null)
          return 0;
      
      // If the node is a leaf, store its value, update it to 0,
      // and return its original value.
      if (node.left == null && node.right == null) {
          int temp = node.data;
          node.data = 0;
          return temp;
      }
      
      // Recursively convert the left and right subtrees and get their sums.
      int leftSum = toSumTreeUtil(node.left);
      int rightSum = toSumTreeUtil(node.right);
      
      // Store the original value of the current node
      int oldVal = node.data;
      
      // Update current node's value to the sum of values in left and right subtrees.
      node.data = leftSum + rightSum;
      
      // Return the sum of the subtree rooted at this node
      // (including its original value) for parent's calculation.
      return node.data + oldVal;
  }
  
}
