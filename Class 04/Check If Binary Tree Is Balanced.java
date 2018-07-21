public class Solution {

  public boolean isBalanced(TreeNode root) {
  
    // recursion, balanced:高度差不大于一
    // 分析recursion 复杂度，画树状图分析每个level
    // level数：O(logn)
    // 每个level --getHeight:O(n) worst case
    //总：O(nlogn)
    
    if(root == null){
      return true;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    if(Math.abs(left - right) > 1){
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }
  
  // get height time: O(n) space:O(n)
  private int getHeight(TreeNode root){
    if(root == null){
      return 0;
    }
    return Math.max(getHeight(root.left),getHeight(root.right))+1;
  }
}


