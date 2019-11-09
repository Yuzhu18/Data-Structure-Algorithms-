public class Solution {
  // total 2n level, 2n position to fill
  // every level have two choice: "(" or ")"
  // DFS 可以减支一部分，即有条件的dfs， 必须满足当前左括号的数量大于等于 有括号的数量， 才是valid的
  // Time ： O(2^n) - 虽然减支，但是数量级是一样的
  // Space: O(2n) = O(n) 一共 2n level
  public List<String> validParentheses(int n) {
    List<String> rst = new ArrayList<>();
    if (n == 0) {
      return rst;
    }
    dfs(0, 0, n, new StringBuilder(), rst);
    return rst;
  }

  private void dfs (int l, int r, int n, StringBuilder cur, List<String> rst) {
    // stop case:
    if (l + r == 2*n) {
      rst.add(cur.toString());
      return;
    }
    // case 1: add left "("
    if (l < n) {
      cur.append("(");
      dfs(l + 1, r, n, cur, rst);
      cur.deleteCharAt(cur.length() - 1);  //////////remember to delete it
    }
    // case 2: add right ")"
    if (r < l) {
      cur.append(")");
      dfs(l, r + 1, n, cur, rst);
      cur.deleteCharAt(cur.length() - 1); //////////remember to delete it
    }
  }
}
