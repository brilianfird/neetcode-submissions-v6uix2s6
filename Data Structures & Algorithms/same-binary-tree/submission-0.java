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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return getSameTree(p, q);
    }

    public boolean getSameTree(TreeNode pNode, TreeNode qNode) {
        if ((pNode == null && qNode != null) || (pNode != null && qNode == null)) {
            return false;
        }
        if (pNode == null && qNode == null) {
            return true;
        }
        boolean left = getSameTree(pNode.left, qNode.left);
        boolean right = getSameTree(pNode.right, qNode.right);
        return left && right && pNode.val == qNode.val;
    }
}
