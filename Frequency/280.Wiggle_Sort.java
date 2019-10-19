class Solution {
    // Time:O(n)
    // Space:O(1)
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; ++i) {
            // 判断当前是否是偶数位
            if(i%2 == 1) {
                // 如果偶数小于前一个奇数位，那么交换
                if(nums[i] < nums[i-1]) {
                    swap(nums, i, i-1);
                }
            }else {
                // 如果奇数位，当前奇数位大于前一个偶数位，则交换
                if(nums[i] > nums[i-1]) {
                    swap(nums, i, i-1);
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
