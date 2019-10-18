
class Solution {
    // DFS backtracking 
    // time: 2^n
    // space: recursion O(n)
    // pruning 减支来提升time complexcity
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(candidates);
        helper(rst, candidates, new ArrayList<Integer>(), target, 0);
        return rst;
    }
    
    private void helper(List<List<Integer>> rst, int[] candidates, List<Integer> cur, int target, int start){
        if(target == 0){
            rst.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            // 减支 ： 如果当前candidate 大于target，那么就不会有符合条件的组合了
            if (candidates[i] > target) {
                break;
            }
            cur.add(candidates[i]);
            // not i + 1 because it can be repeatedly used
            helper(rst, candidates, cur, target - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
