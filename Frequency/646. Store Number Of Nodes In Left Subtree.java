/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  // 需要明确三个步骤
  // 1. 从左/右 child node要什么？
  // 2. 当前层需要更新什么？
  // 3. 返回给parent node 什么值？

  public void numNodesLeft(TreeNodeLeft root) {
    dfs(root);
  }

  private int dfs(TreeNodeLeft root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    root.numNodesLeft = left;
    return left + right + 1;  /// 相当于返回subtree的个数
  }
}
