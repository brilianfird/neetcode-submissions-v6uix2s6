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
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        getIsBalanced(root);
        return this.balanced;
    }

    public int getIsBalanced(TreeNode node) {
        if (node == null) return 0;

        int left = getIsBalanced(node.left);
        int right = getIsBalanced(node.right);

        if (Math.abs(left-right) > 1) {
            this.balanced = false;
        }

        return Math.max(left, right) + 1;
    }
}
