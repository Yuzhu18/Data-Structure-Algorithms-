/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
 
public class Solution {
  public boolean isCompleted(TreeNode root) {
    // 遍历一遍不要有气泡
    if(root == null){
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean flag = false;
    while(!queue.isEmpty()){
      TreeNode cur = queue.poll();
      //left child
      if(cur.left == null){
        flag = true;   
      }else if(flag){
        return false;
      }else{
        queue.offer(cur.left);
      }
      // right child
      if(cur.right == null){
        flag = true;
      }else if(flag){
        return false;
      }else{
        queue.offer(cur.right);
      }
    }
    return true;
  }
}


