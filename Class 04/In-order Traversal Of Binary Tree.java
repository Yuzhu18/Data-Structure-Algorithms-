public class Solution {  
  // recursion way
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inOrderTraversal(root, result);
    return result;
  }  
  
  private void inOrderTraversal(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    
    inOrderTraversal(root.left, result);
    result.add(root.key);
    inOrderTraversal(root.right, result);
  }
}


// iterative way
public List<Integer> inOrder(TreeNode root) {
        
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> inorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) { /// 判断条件
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                inorder.add(cur.key);
                cur = cur.right;
            }
        }
        return inorder;
    }
    
