class Solution {
    // DFS backtracking 
    // time: 2^n
    // space: recursion O(n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(candidates);
        helper(rst, candidates, new ArrayList<Integer>(), target, 0);
        return rst;
    }
    
    private void helper(List<List<Integer>> rst, int[] candidates, List<Integer> temp, int remain, int start){
        if(remain < 0){return; }
        else if(remain == 0){
            // temp每次都在变
            rst.add( new ArrayList<Integer>(temp));
        }else{
            for(int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                
                helper(rst, candidates, temp, remain - candidates[i], i);// not i + 1 because it can be repeatedly used
                temp.remove(temp.size() - 1);
            }
        }
    }
}














