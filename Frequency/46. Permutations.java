class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 每一level 代表当前位置
        // 每个level 有 当前位置到最后个branches， 每个level的branch不同
        // Time:O (n!)
        // Space: O (n)
        List<List<Integer>> rst= new ArrayList<>();
        dfs(0, nums, rst);
        return rst;
    }
    private void dfs(int index, int[] nums, List<List<Integer>> rst) {
        //stop case:
        if (index == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int e: nums) {
                l.add(e);
            }
            rst.add(l);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(index + 1, nums, rst);
            swap(nums,i, index);
        }
    }
    
    private void swap (int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
