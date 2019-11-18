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
    // level traverse 遇到第一个是null, 之后必须都是null
    // Time: O(n)
    // Space:O(n)
    public boolean isCompleteTree(TreeNode root) {
        // corner case:
        if (root == null) {
            return true;
        }
        // initial queue
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    if (hasNull) {
                        return false;
                    }
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    hasNull = true;
                }
            }
            
        }
        return true;
    }
}
