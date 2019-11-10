class Solution {
    // 每个level 代表index 位置
    // 每个level有 n - 1 种 branches 
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        if (k > n || k == 0) {
            return rst;
        }
        dfs(0, 1, n, k, new ArrayList<Integer>(), rst);
        return rst;
    }
    
    private void dfs (int index, int start,int n, int k, List<Integer> cur, List<List<Integer>> rst) {
        // stop case:
        if (index == k) {
            rst.add(new ArrayList<Integer>(cur));
        }
        
        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(index + 1, i + 1, n, k, cur, rst);  //// 这里要传进去 i + 1 而不是start ！！！
            cur.remove(cur.size() - 1);
        }
    }
}
