/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 三部曲
    // Time: O(num of nodes)
    // Space: O(height)
    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }
    
    private int getHeight(TreeNode root) {
        // stop case:
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
