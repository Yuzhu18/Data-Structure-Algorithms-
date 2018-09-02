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
  public List<Integer> zigZag(TreeNode root) {
    // 奇数层left - right
    // 偶数层right - left
    // 利用deque
    if(root == null){
      return new ArrayList<Integer>();
    }
    Deque<TreeNode> deque = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    int layer = 0;
    deque.offerLast(root);
    while(!deque.isEmpty()){
      // store deque size first, because it changes all the time
      int size = deque.size();
      for(int i = 0; i < size; i++){
        // even level from right -> left
      if(layer == 0){
        TreeNode tmp = deque.pollLast();
        list.add(tmp.key);
        if(tmp.right != null){
          deque.offerFirst(tmp.right);
        }
        if(tmp.left != null){
          deque.offerFirst(tmp.left);
        }
      }else{
        // odd level from left -> right
        TreeNode temp = deque.pollFirst();
        list.add(temp.key);
        if(temp.left != null){
          deque.offerLast(temp.left);
        }
        if(temp.right != null){
          deque.offerLast(temp.right);
        }
      }
     }
      layer = 1 - layer; //保证奇偶循环
    }
    return list;
  }
}
