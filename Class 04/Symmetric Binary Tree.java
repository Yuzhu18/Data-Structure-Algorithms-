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
  public boolean isSymmetric(TreeNode root) {
  
    // recursion
    // Amazon 
    // time: O(n) 每个点遍历一遍
    // space: O(logn) 类似二叉
    
    if(root == null){
      return true;
    }
    return helper(root.left, root.right);
  }
  
  private boolean helper(TreeNode left, TreeNode right){
    //base case
    if(left == null && right == null){
      return true;
    }
    else if(left == null || right == null){
      return false;
    }
    else if(left.key != right.key){
      return false;
    }
    /// 同时判断对称位置的node
    return helper(left.left, right.right) && helper(left.right, right.left);
  }
}

