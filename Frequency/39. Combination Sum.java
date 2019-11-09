class Solution {
    // 母题是 DFSII 的 coin change 问题 ： 多个 branch 问题, 结果返回的形式需要处理一下
    // 每一层代表一种candidate
    // 每一层的branch 代表这个candidate 出现几次
    // 这个方法不如下面减支的那个方法好
    // Time: O(branch^level)
    // Space: O(level)
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> tmp = new ArrayList<>();
//         if  (target < 1) {
//             return tmp;
//         }
//         dfs (0, candidates, target, tmp, new ArrayList<Integer>());
        
//         List<List<Integer>> rst = new ArrayList<>();
        
//         for (List<Integer> l : tmp) {
//             List<Integer> temp = new ArrayList<>();
//             for (int i = 0; i < l.size(); i++) {
//                 int num = l.get(i);
//                 while (num > 0) {
//                     temp.add(candidates[i]);
//                     num--;
//                 }
//             }
//             rst.add(temp);
//         }
//         return rst;
//     }
    
//     private void dfs (int index, int[] candidates, int remain, List<List<Integer>> rst, List<Integer> cur) {
//         // stop case:
//         if (index == candidates.length) {
//             // valid result
//             if (remain == 0) {
//                 rst.add(new ArrayList<Integer>(cur));
//             }
//             return;
//         }
//         // loop through how many candidates can be used
//         int max = remain / candidates[index];
//         for (int i = 0; i <= max; i++) {
//             cur.add(i);
//             dfs(index + 1, candidates, remain - i * candidates[index], rst, cur);
//             cur.remove(cur.size() - 1);
//         }
//     }
    
    
    // 每行代表结果组合当前应该加入哪个candidate
    // branches 是 candidates 数量，每个candidate都试一遍
    // 先sort 这样子可以减支
    // int start 为了去重,记录的是当前candidate的index
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        // sort for cut branches
        Arrays.sort(candidates);
        dfs(rst, candidates, new ArrayList<>(), target, 0);
        return rst;
    }
    
    private void dfs(List<List<Integer>> rst, int[] candidates, List<Integer> cur, int remain, int start){
        // stop case:
        if (remain == 0) {
            rst.add(new ArrayList<>(cur));
            return;
        }
        
        // try every candidates
        for (int i = start ;i < candidates.length; i++) {
            // cut branches
            if (remain < candidates[i]) {
                break;
            }
            cur.add(candidates[i]);
            dfs(rst, candidates, cur, remain - candidates[i], i);  /// 这里是i，因为同一个candidate可以重复用，为了去重，所以记录当前
            cur.remove(cur.size() - 1);
        }
    }
}
