class Solution {
    // DFS 一共n个level，每一位上的int占一行
    //      每一个level有两种情况，包含/不包含
    // Time: O(2^n)
    // Space: O(n) - 有n个level
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null) {
            return rst;
        }
        dfs(0, nums, rst, new ArrayList<Integer>());
        return rst;
    }
    
    private void dfs(int index, int[] nums, List<List<Integer>> rst, List<Integer> current) {
        // stop case:
        if (index == nums.length) {
            rst.add(new ArrayList<Integer>(current));  ////// should new an arrayList
            return;
        }
        // case1: this num is included
        current.add(nums[index]);
        dfs(index + 1, nums, rst, current);
        // case2: this num is not included
        current.remove(current.size() - 1);
        dfs(index + 1, nums, rst, current);
    }
}
