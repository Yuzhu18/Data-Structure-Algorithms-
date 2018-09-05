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
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    // follow up : 找k 个node 的 lowest ancestor 且 k 个 node 一定都在tree里
    // recursion 三部曲
    HashSet<TreeNode> set = new HashSet<>(nodes);
    return helper(root, set);
  }
  
  private TreeNode helper(TreeNode root, Set<TreeNode> set){
    if(root == null || set.contains(root)){
      return root;
    }
    TreeNode left = helper(root.left, set);
    TreeNode right = helper(root.right, set);
    if(left != null && right != null){
      return root;
    }
    return left != null ? left : right;
  }
}


