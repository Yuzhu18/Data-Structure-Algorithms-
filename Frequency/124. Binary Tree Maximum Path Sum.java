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
    // 三部曲 bottom up
    // Time:O(num of nodes)
    // Time:O(height)
    public int maxPathSum(TreeNode root) {
        int[] rst = new int[]{Integer.MIN_VALUE};
        traverse(root, rst);
        return rst[0];
    }
    
    private int traverse(TreeNode root, int[] rst) {
        // stop case:
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left, rst);
        int right = traverse(root.right, rst);
        int sum = Math.max(left, 0) + Math.max(right, 0) + root.val;// 这个是在求从一个node 到另一个node且包含这个root的sum
        rst[0] = Math.max(rst[0], sum);
        return Math.max(Math.max(left, right), 0) + root.val;  //// 返回的是对于当前root这个node,最大的值，也就是向左/右直上直下的sum
    }
}
