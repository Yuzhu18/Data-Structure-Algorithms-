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
    // reference：https://www.youtube.com/watch?v=aaSFzFfOQ0o
    // 用DFS bottom-up , recursion
    // 从树的下到上来考虑, 这样子不会遗漏
    // Time: O (n) 
    // Space: O(n) --set
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // 首先把to_delete 转化为set
        Set<Integer> delete = new HashSet<>();
        for (int e : to_delete) {
            delete.add(e);
        }
        List<TreeNode> rst = new ArrayList<>();
        // check if root should be maintain
        if (!delete.contains(root.val)) {
            rst.add(root);
        }
        dfs(root, delete, rst);
        return rst;
    }
    
    private TreeNode dfs(TreeNode root, Set<Integer> delete, List<TreeNode> rst) {
        // check if current node is the leaf
        if (root == null) {
            return null;
        }
        // 因为想要从下到上遍历，所以先dfs
        root.left = dfs(root.left, delete, rst);
        root.right = dfs(root.right, delete, rst);
        if (delete.contains(root.val)) {
            // 如果这个待删除的node， 左/右子树不为空，那么左右子树的root应该加入结果里
            if (root.left != null) {
                rst.add(root.left);
            }
            if (root.right != null) {
                rst.add(root.right);
            }
            // 删除当前这个node
            return null;
        }
        // 如果不是要删除的点，直接返回当前点
        return root;
    }
}
