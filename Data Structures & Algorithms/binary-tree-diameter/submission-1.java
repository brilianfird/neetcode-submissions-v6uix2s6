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

    private int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return this.maxLength;  
    }


    public int getMaxDepth(TreeNode node) {
        if (node == null) return 0;

        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);
        this.maxLength=Math.max(this.maxLength, left+right);
        return left > right ? left + 1 : right + 1;
    }

}
