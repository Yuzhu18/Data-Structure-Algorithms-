// Time: O(N*lgN)
// Space: O(N)
// 这个题是可能有重复的数字的情况，不能用inplace来做
// leetcode 280 没有重复数字，可以inplace实现

class Solution {
    public void wiggleSort(int[] nums) {
        // corner case: 
        if(nums.length == 1) {
            return;
        }
        // copy a int array
        int[] temp = Arrays.copyOf(nums, nums.length);
        // sort
        Arrays.sort(temp);
        // 找到偶数位最小数的index，和最大数的index
        int smallIndex = (nums.length + 1)/2 - 1;
        int largeIndex = nums.length-1;
        
        for(int i = 0; i < nums.length; ++i) {
            nums[i] = (i%2 == 0) ? temp[smallIndex--] : temp[largeIndex--];
        }
    }
}
