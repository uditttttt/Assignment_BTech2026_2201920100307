# Path Sum (Leetcode 112)

## Problem Statement
Given the root of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf** path such that adding up all the values along the path equals `targetSum`.

A **leaf** is a node with no children.

### Example 1:
#### Input:
```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

targetSum = 22
```
#### Output:
```
true
```
#### Explanation:
The path `5 -> 4 -> 11 -> 2` sums to `22`.

---

### Example 2:
#### Input:
```
      1
     / \
    2   3

targetSum = 5
```
#### Output:
```
false
```
#### Explanation:
There is no path that sums to `5`.

---

## Approach

### **1. Recursion (Depth-First Search - DFS)**
We use recursion to explore all root-to-leaf paths and check if their sum equals `targetSum`.

- **Base Case:**
  - If `root == null`, return `false` (empty tree).
  - If `root` is a leaf node (no left or right child), check if `targetSum == root.val`.

- **Recursive Case:**
  - Reduce `targetSum` by the current node’s value (`targetSum - root.val`).
  - Recursively check the left and right subtrees.
  - If either `left` or `right` subtree returns `true`, return `true`.

---

## Solution (Java)
```java
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; // If tree is empty, return false

        // If it's a leaf node, check if targetSum matches
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check left and right subtrees
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right; // Return true if any path matches targetSum
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the number of nodes in the tree.
  - We visit each node once in the worst case.

- **Space Complexity:** `O(H)`, where `H` is the height of the tree.
  - In a balanced tree, `H = log(N)`, so `O(log N)`.
  - In a skewed tree, `H = N`, so `O(N)` in the worst case.

---

## Alternative Approaches
### **1. Iterative DFS (Using Stack)**
Instead of recursion, we can use an explicit **stack** (Depth-First Search).
### **2. BFS (Using Queue)**
A Breadth-First Search (BFS) approach using a **queue** can also solve the problem.

---

## Summary
✅ Uses DFS (recursion) to traverse the tree.
✅ Checks for valid root-to-leaf paths.
✅ Efficient with `O(N)` time complexity.
✅ Works for all types of binary trees.

---
**Tags:** `Binary Tree`, `Recursion`, `DFS`, `Backtracking`.

