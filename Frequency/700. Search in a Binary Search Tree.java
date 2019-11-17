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
    // 左小右大, 类似binary search
    // Time: (num of tree nodes)
    // Space:O(tree height)
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode rst = null;
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return rst;
    }
}
