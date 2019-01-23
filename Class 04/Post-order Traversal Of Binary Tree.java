public class Solution {

///1. iterative way:
  public List<Integer> postOrder(TreeNode root) {
    // 1.reverse pre-order with right before left
    if(root == null){
      return new ArrayList<Integer>();
    }
    // Pre-order
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> preorder = new ArrayList<>();
    
    stack.offerFirst(root);
    while(!stack.isEmpty()){
      TreeNode cur = stack.pollFirst();
      preorder.add(cur.key);
      if(cur.left != null){
        stack.offer(cur.left);
      }
      if(cur.right != null){
        stack.offerFirst(cur.right);
      }
    }
    
    // traverse into post-order
    Collections.reverse(preorder);
    return preorder;
  }
}


// 2. recursion way:
public class Solution {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add(root.key);
    }
}
