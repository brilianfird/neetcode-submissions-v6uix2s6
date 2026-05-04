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
        return checkSubTree(root, subRoot);
    }

    public boolean checkSubTree(TreeNode node, TreeNode subRoot) {
        if (node == null) return false;
        
        if (node.val == subRoot.val && isSameTree(node, subRoot)) return true;

        return checkSubTree(node.left, subRoot) || checkSubTree(node.right, subRoot); 
    }

    public boolean isSameTree(TreeNode q, TreeNode p) {
        if (p == null || q == null) return p == q;

        return p.val == q.val && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }
}
