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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 奇数层 right -> left
        // 偶数层 left -> right
        // 用deque
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
       Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> rst = new ArrayList<>();
        int layer = 1;
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> curLayer = new ArrayList<>();
            for(int i = 0;i < size; i++){
                // even layer
                if(layer == 0){
                    TreeNode tmp = deque.pollLast();
                    curLayer.add(tmp.val);
                    if(tmp.right != null){
                        deque.offerFirst(tmp.right);
                    }
                    if(tmp.left != null){
                        deque.offerFirst(tmp.left);
                    }
            
                }else{
                    // odd level from left -> right
                    TreeNode temp = deque.pollFirst();
                    curLayer.add(temp.val);
                    if(temp.left != null){
                      deque.offerLast(temp.left);
                    }
                    if(temp.right != null){
                      deque.offerLast(temp.right);
                    }
                }
            }
            layer = 1 - layer;
            rst.add(curLayer); 
        }
        return rst;
    }
}
