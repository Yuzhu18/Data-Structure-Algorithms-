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
    // 思路是in-order 遍历 tree 维护一个 k-size queue, 
    // 每次比较queue的头和target的接近程度, 最后返回这个queue里的k个元素
    // Time: O(n) -- total tree node
    // Space: O(tree height)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> queue = new LinkedList<>();
        traverse(root, target, k, queue);
        // store rst
        List<Integer> rst = new ArrayList<>();
        while (!queue.isEmpty()) {
            rst.add(queue.pollFirst());
        }
        return rst;
    }
    
    private void traverse(TreeNode root, double target, int k, Deque<Integer> queue) {
        // stop case:
        if (root == null) {
            return;
        }
        // in-order traverse left node firstly
        traverse(root.left, target, k, queue);
        // in-order traverse handle the current root node
        if (queue.size() < k) {
            queue.offerLast(root.val);
        } else {
            int smallest = queue.getFirst();
            if (Math.abs(root.val - target) < Math.abs(smallest - target)) {
                queue.pollFirst();
                queue.offerLast(root.val);
            }
        }
        // in-order traverse right node lastly
        traverse(root.right, target, k, queue);
    }
}
