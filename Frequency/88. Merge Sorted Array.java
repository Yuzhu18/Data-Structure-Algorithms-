class Solution {
    // 要求in-place实现
    // 从后向前，先找最大值，放在最后
    // time : O(n)
    // space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int x1 = m - 1;
        int x2 = n - 1;
        while(x1 >= 0 && x2 >= 0){
            if(nums1[x1] >= nums2[x2]){
                nums1[index--] = nums1[x1--];
            }else{
                nums1[index--] = nums2[x2--];
            }
        }
        // while(x1 >= 0){
        //     nums1[index--] = nums1[x1--];
        // }
        while(x2 >= 0){
            nums1[index--] = nums2[x2--];
        }
        
    }
}
