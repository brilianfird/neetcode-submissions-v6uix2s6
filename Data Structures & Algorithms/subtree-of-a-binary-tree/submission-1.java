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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public boolean isSameTree(TreeNode q, TreeNode p) {
        if (p == null || q == null) return p == q;

        return p.val == q.val && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }
}
