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
    // recursion + tree
    // 分三个步骤想
    // 1. 需要向下面的child node 要什么 ？
    // 2. 每次得到之后需要做什么处理 ？
    // 3. 需要返回给parent node 什么 ？
    // Time: O(num of all treeNode)
    // Space: O( height )
    
    public int sumOfLeftLeaves(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        int[] sum = new int[1];
        sum[0] = 0;
        dfs(root, sum, false);
        
        return sum[0];
    }
    
    private void dfs(TreeNode root, int[] sum, boolean isLeft) {
        // stop case:
        if (root.left == null && root.right == null) {
            if(isLeft) {
                int tmp = sum[0];
                sum[0] = root.val + tmp;
            }
        }
        if (root.left != null) {
            dfs(root.left, sum, true);
        }
        
        if (root.right != null) {
            dfs(root.right, sum, false);
        }
    }
}
