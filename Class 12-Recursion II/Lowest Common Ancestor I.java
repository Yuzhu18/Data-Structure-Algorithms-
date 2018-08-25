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
  // recursion way : Tree 的每层结构一致，所以用recursion结合（从下往上返）
    // 三部曲：
    // 1. What do you except from your lChild/rChild? 需要从左右子树得到什么
    // 2. What do you want to do in current layer? 当前层需要什么操作
    // 3. What do you wanto to report to your parent? 需要返回给父节点什么
    // 1,3步物理意义一样
    
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // a和b一共两种关系: 1.在同一个subtree里(b能向上寻找到a)
    //                 2.不在同一个subtree里，common ancestor 是root
    // 从下往上返：case 1. 一边是a/b;另一边是null, 向上返a/b
    //           case 2. 两边都是null, return null
    //           case 3. 一边是a,另一边是b, return root
    
    
    // base case
    if(root == null || root == one || root == two){
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if(left != null && right != null){
      return root;
    }else if(left == null){
      return right;
    }else{
      return left;
    }
  }
}
