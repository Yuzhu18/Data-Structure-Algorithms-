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
  // 因为是直上直下的路径，可以用pre-order, 类似dfs (这题要求的是直上直下路径, 且可以不从root/leaf起始)
  // 也可以用三步曲
  // 两个方法，复杂度是一样的
  // Time：O(num of nodes)
  // Space: O(height)

  // 1. pre-order / dfs 方法
  public int maxPathSum(TreeNode root) {
    int[] rst = new int[]{Integer.MIN_VALUE};
    dfs(root, 0, rst);
    return rst[0];
  }

  private void dfs(TreeNode root, int max, int[] rst) {
    // stop case: 
    if (root == null) {
      return;
    }
    max = Math.max(root.key, root.key + max);
    rst[0] = Math.max(max, rst[0]);
    dfs(root.left, max, rst);
    dfs(root.right, max, rst);
  }


  // 2. 三步曲方法：
  public int maxPathSum(TreeNode root) {
    int[] rst = new int[]{Integer.MIN_VALUE};
    dfs(root, rst);
    return rst[0];
  }

  private int dfs(TreeNode root, int[] rst) {
    // stop case:
    if (root == null) {
      return 0;
    }
    // a. 先向左右孩子要当前 max sum
    int left = dfs(root.left, rst);
    int right = dfs(root.right, rst);
    // b. update rst 值
    int m = Math.max(left, right);
    rst[0] = Math.max(Math.max(m, 0) + root.key, rst[0]);
    // c. 返回当前max sum
    return Math.max(m, 0) + root.key;
  }
}
