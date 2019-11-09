public class Solution {
  // total 4 levels(types of coins), each level represent one type of coin 每层代表每种硬币的数量
  // each level worest has "target" num of branches (because only use 1 cent coin)
  // Time: O(4^target)  types^target
  // Space: O(4) - O(types)
  // 这道题DFS，不再是二叉树了，是多叉树的情况 --for 循环里有 recursion
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> rst = new ArrayList<>();
    if (target == 0) {
      return rst;
    }
    dfs(0, target, coins, rst, new ArrayList<Integer>());
    return rst;
  }

  private void dfs(int index, int remain, int[] coins, List<List<Integer>> rst, List<Integer> cur) {
    // stop case:
    if (index == coins.length ) {
      // 验证这种组合可以达到target，才加进rst里
      if (remain == 0) {
        rst.add(new ArrayList<Integer>(cur));
      }
      return;
    }
    int max = remain / coins[index];
    for (int i = 0; i <= max; i++) {
      cur.add(i);
      dfs(index + 1, remain - i * coins[index], coins, rst, cur);
      cur.remove(cur.size() - 1);
    }
  }
}
