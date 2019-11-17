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
    // idea 是traverse 一遍tree, 维护一个variable
    // 利用 BST 左小右大的特性
    // Time: O(n) -- num of tree nodes
    // Space: O(1)
    public int closestValue(TreeNode root, double target) {
        int rst = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(rst - target)) {
                rst = root.val;
            }
            
            if (root.val == target) {
                return root.val;
            } else if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return rst;
    }
}
