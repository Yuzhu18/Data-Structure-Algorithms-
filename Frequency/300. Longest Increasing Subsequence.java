class Solution {
    // DP[i] represents the longest increasing subsequence ends at nums[i]
    // O(n^2) 做法是每次从当前index往前遍历，看比他小且dp[k] 最大的，然后dp[i] = dp[k] + 1; 如果找不到则dp[i] = 1
    // public int lengthOfLIS(int[] nums) {
    //     if (nums == null || nums.length == 0){
    //         return 0;
    //     }
    //     int max = 1;
    //     int[] dp = new int[nums.length];
    //     dp[0] = 1;
    //     for (int i = 1; i < nums.length; i++) {
    //         dp[i] = 1;
    //         for (int j = i; j >= 0; j--) {
    //             if (nums[j] < nums[i]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             } 
    //         }
    //         max = Math.max(max, dp[i]);
    //     }
    //     return max;
    // }
    
    /// O(nlogn) 做法 sol2：https://www.cnblogs.com/grandyang/p/4938187.html
    // 维护一个sorted list，只有遇到比list里最大的大的元素时，将元素加进最后，其他的就是不断binary search更新这个sorted array
    // return list.size()
    // 这个方法就是尽可能保留一个最小的数的sorted array
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> sorted = new ArrayList<>();
        sorted.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < sorted.get(0)) {
                sorted.set(0, nums[i]);
            } else if (nums[i] > sorted.get(sorted.size() - 1)) {
                sorted.add(nums[i]);
            } else {
                // binary search to fin the first num's index that bigger than current num
                int left = 0;
                int right = sorted.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (sorted.get(mid) < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid; ////////
                    }
                }
                sorted.set(right, nums[i]);
            }
        }
        return sorted.size();
    }
}
