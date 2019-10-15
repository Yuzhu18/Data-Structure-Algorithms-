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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // 注意要提前放好size
    List<List<Integer>> rst = new ArrayList<>();
    if(root == null){
      return rst;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int size = queue.size();
      List<Integer> curLayer = new ArrayList<>();
      for(int i = 0; i < size; i++){
        TreeNode cur = queue.poll();
        curLayer.add(cur.key);
        if(cur.left != null){
          queue.offer(cur.left);
        }
        if(cur.right != null){
          queue.offer(cur.right);
        }
      }
     rst.add(curLayer);
    }
    return rst;
  }
}

