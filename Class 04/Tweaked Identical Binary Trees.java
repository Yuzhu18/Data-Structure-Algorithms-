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
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
  
    // recursion
    //在判断对称的基础上增加case: 可以对称，也可以完全一样
    //Microsoft 
    // time: O(n^2) 每次分四个叉
    // space: O(logn)
    
    if(one == null && two == null){
      return true;
    }
    else if(one == null || two == null){
      return false;
    }
    else if(one.key != two.key){
      return false;
    }
    return (isTweakedIdentical(one.left, two.right)&& isTweakedIdentical(one.right, two.left)) 
      ||(isTweakedIdentical(two.left, one.left) && isTweakedIdentical(two.right, one.right));
  }
  
}
