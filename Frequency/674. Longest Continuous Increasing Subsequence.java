class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //DP : M[i] represnt 到i位置，max ascending subarray
        // 优化成不用额外array储存空间，只存储前面一个prev就可以了
        // time: O (n)
        // space: O(1)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int prev = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                prev = prev + 1;
                max = Math.max (prev, max);
            } else {
                prev = 1;
            }
        }
        return max;
    }
}
