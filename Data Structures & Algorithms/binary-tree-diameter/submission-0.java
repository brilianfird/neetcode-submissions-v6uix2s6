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
    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> maxLength = new ArrayList<>(0);
        getMaxDepth(root, maxLength);
        return maxLength.get(maxLength.size() - 1);    
    }


    public int getMaxDepth(TreeNode node, List<Integer> maxLength) {
        if (node == null) return 0;

        int left = getMaxDepth(node.left, maxLength);
        int right = getMaxDepth(node.right, maxLength);

        if (maxLength.size() == 0 || left + right + 1 > maxLength.get(maxLength.size() - 1)) {
            int res = left + right;
            maxLength.add(res);
        }

        return left > right ? left + 1 : right + 1;
    }

}
