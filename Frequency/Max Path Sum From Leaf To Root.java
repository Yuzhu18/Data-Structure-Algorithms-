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
  // 因为是直上直下，可以用in-order traverse (类似dfs)
  // 也可以用三步曲
  public int maxPathSumLeafToRoot(TreeNode root) {
    int[] max = new int[]{Integer.MIN_VALUE};
    findMax(root, max, new int[]{0});
    return max[0];
  }

  private void findMax(TreeNode root, int[] max, int[] cur) {
    if (root == null) {
      return;
    }

    // update rst
    if (root.left == null && root.right == null) {
      max[0] = Math.max(max[0], cur[0] + root.key);
    }
    
    cur[0] = cur[0] + root.key;
    findMax(root.left, max, cur);
    findMax(root.right, max, cur);
    cur[0] = cur[0] - root.key;
  }

}
