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
  public List<Integer> getRange(TreeNode root, int min, int max) {
  
    // recursion
    //in-order 
    // time: O(n)
    // space: O(n)
    
    List<Integer> result = new ArrayList<>();
    helper(root, min, max, result);
    return result;
  }
  
  private void helper(TreeNode root, int min, int max, List<Integer> rst){
    if (root == null) {   ////base case
            return;
    }
    if(root.key > min){
      helper(root.left, min, max, rst);
    }
    if(root.key >= min && root.key <= max){
      rst.add(root.key);
    }
    if(root.key < max){
      helper(root.right, min, max, rst);
    }
  }
}



