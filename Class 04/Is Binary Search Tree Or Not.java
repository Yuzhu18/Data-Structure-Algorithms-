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
  public boolean isBST(TreeNode root) {
    // 1.常用方法：带着区间判断
    if(root == null){
      return true;
    }
    return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private boolean helper(TreeNode root, int lBound, int hBound){
    if(root == null){
      return true;
    }
    if(root.key >= hBound || root.key <= lBound){
      return false;
    }
    return helper(root.left, lBound, root.key) && helper(root.right, root.key, hBound);
  }
  
  //2.in-Order遍历，判断是否从大到小排列(exist bug)
   public boolean isBST(TreeNode root) {
     TreeNode prev = new TreeNode(Integer.MIN_VALUE);
     boolean rst = true;
     inorder(root, prev, rst);
     return rst;
   }
   private void inorder(TreeNode root, TreeNode prev, Boolean rst){
     if(root == null){
       rst = true;
     }
     inorder(root.left, root, rst);
     if(root.key <= prev.key){
       rst = false;
     }
     inorder(root.right, root, rst);
   }
}
