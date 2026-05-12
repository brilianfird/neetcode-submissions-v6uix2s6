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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            result.add(new ArrayList<>());
            for (int i=0;i<queueSize;i++) {
                TreeNode node = queue.pollFirst();
                result.get(result.size() - 1).add(node.val);

                if (node.left != null) {
                    queue.offerLast(node.left);
                }

                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }

        return result;
    }
}
