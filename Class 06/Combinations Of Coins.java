public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
  
    // 每层代表每种硬币的数量
    // 每个level有几个叉不一定
    
    List<List<Integer>> rst = new ArrayList<>();
    if(target == 0){
      return rst;
    }
    List<Integer> cur = new ArrayList<>();
    helper(target, coins, cur, rst, 0);
    return rst;
  }
  private void helper(int remain, int[] coins, List<Integer> curr, List<List<Integer>> rst, int index){
    // base case
    if(index == coins.length - 1){
      if(remain % coins[coins.length - 1] ==0){
        curr.add(remain / coins[coins.length - 1]);
        rst.add(new ArrayList<Integer>(curr));
        curr.remove(curr.size() - 1);
      }
      return;
    }
    int max = remain / coins[index]; //最多个数
    for(int i = 0; i <= max; i++){
      curr.add(i);
      helper(remain - i * coins[index], coins, curr, rst, index + 1 );
      curr.remove(curr.size() - 1);
    }
  }
}

