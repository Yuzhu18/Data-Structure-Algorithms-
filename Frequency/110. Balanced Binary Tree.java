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
    // 如果是unbalanced return -1，else return height
    // Time: O(num of nodes)
    // Space: O(height)
    public boolean isBalanced(TreeNode root) {
        int rst = getHeight(root);
        return rst != -1;
    }
    
    private int getHeight(TreeNode root) {
        // stop case:
        if (root == null) {
            return 0;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        // check if balanced
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
    
}
