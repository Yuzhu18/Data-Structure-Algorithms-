
public class Solution {

// 1. recursion way:
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preOrderTraversal(root, result);
    return result;
  }  
  
  private void preOrderTraversal(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    
    result.add(root.key);    
    preOrderTraversal(root.left, result);
    preOrderTraversal(root.right, result);
  }  
}


//2. iterative way:

public class Solution {
    public List<Integer> preOrder(TreeNode root) {
        // root left right
        
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> preorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {  ////
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            preorder.add(cur.key);
        }
        return preorder;
    }
} 
