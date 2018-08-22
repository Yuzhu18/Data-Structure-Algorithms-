public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // 不是所有n queen都有解，2，3都无解
    // 如果有的话，也可能不止一个解，要求输出所有解 
    // 每一个arrayList是一组解，rst是所有可能的解
    // 类似DFS的思路
    // time : O(n * n!)
    List<List<Integer>> rst = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    helper(cur, n, rst);
    return rst;
  }
  private void helper(List<Integer> cur, int n, List<List<Integer>> rst){
    //base case
    if(cur.size() == n){
      rst.add(new ArrayList<Integer>(cur));
      return;
    }
    for(int i = 0; i < n; i++){
      if(valid(cur, i)){  //验证放在这一列是否可行
        cur.add(i);
        helper(cur, n, rst);
        cur.remove(cur.size() - 1); //backtracking
      }
    }
  }
  
  private boolean valid(List<Integer> cur, int col){
    int row = cur.size();
    for(int j = 0; j < row; j++){
      if(cur.get(j) == col || Math.abs(cur.get(j) - col) == row - j){
        // 检查这一列col,有没有放过queen || 坐标差相等说明是在一条对角线上
        return false;
      }
    }
    return true;
  }
  
  // way 2: 记录不可以放的坐标，实现O(1) 验证
  // time: O(n!)
}
