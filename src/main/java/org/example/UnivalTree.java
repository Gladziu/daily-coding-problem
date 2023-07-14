// #8 Problem
package org.example;

public class UnivalTree {
    /*
    A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

    Given the root to a binary tree, count the number of unival subtrees.

    For example, the following tree has 5 unival subtrees:

       0
      / \
     1   0
        / \
       1   0
      / \
     1   1
     */

    private static class TreeNode {
      TreeNode left;
      TreeNode right;
      int value;

        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    private static class UnivalTreeCount {
      boolean isUnival;
      int count;

        public UnivalTreeCount(boolean isUnival, int count) {
            this.isUnival = isUnival;
            this.count = count;
        }
    }

    public UnivalTreeCount UnivalTreeFunction(TreeNode node) {
        if (node == null) {
            return new UnivalTreeCount(true, 0);
        }

        if (node.left == null && node.right == null) {
            return new UnivalTreeCount(true, 1);
        }

        UnivalTreeCount leftTreeCount = UnivalTreeFunction(node.left);

        UnivalTreeCount rightTreeCount = UnivalTreeFunction(node.right);

        if (    leftTreeCount.isUnival
                && rightTreeCount.isUnival
                && (node.left == null || node.left.value == node.value)
                && (node.right == null || node.right.value == node.value)) {
            return new UnivalTreeCount(true, leftTreeCount.count + rightTreeCount.count + 1);
        }
        return new UnivalTreeCount(false, leftTreeCount.count + rightTreeCount.count);
    }
}
