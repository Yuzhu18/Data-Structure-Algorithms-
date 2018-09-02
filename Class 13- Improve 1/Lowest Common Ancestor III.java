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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // follow up: two nodes may not in the tree
    // 找到之后check 一下 LCA（B, A, A）
    TreeNode rst = LCA(root, one, two);
    if(rst == one){
      if(LCA(one, two, two) == null){
        return null;
      }
    }
    if(rst == two){
      if(LCA(two, one, one) == null){
        return null;
      }
    }
    return rst;
  }
  private TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
    if(root == null || root == one || root == two){
      return root;
    }
    TreeNode left = LCA(root.left, one, two);
    TreeNode right = LCA(root.right, one , two);
    if(left != null && right != null){
      return root;
    }
    return left != null ? left : right;
  }
}
