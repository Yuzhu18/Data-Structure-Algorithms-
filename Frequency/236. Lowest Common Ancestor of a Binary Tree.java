public class Solution {
  // 一共有两个case：
  //        1. node 1, node 2 在同一个subtree里，return 其中一个
  //        2. node 1, 2 分别在两个不同的tree里，返回这两个tree的root
  // 三部曲：
  // 1. What do you except from your lChild/rChild? 需要从左右子树得到什么
  // 2. What do you want to do in current layer? 当前层需要什么操作
  // 3. What do you wanto to report to your parent? 需要返回给父节点什么

  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
        if (root == null) {
          return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
          return root;
        } else if (root == one || root == two) {
          return root;
        } else {
          return left != null ? left : right;
        }
  }

}
