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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, p, q);
    }    

    public TreeNode traverse(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        if (node.val == q.val || node.val == p.val) return node;

        TreeNode left = traverse(node.left, p, q);
        TreeNode right = traverse(node.right, p, q);

        if (left != null && right != null) {
            return node;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
