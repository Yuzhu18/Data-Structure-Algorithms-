class Solution {
    //binary search
    //数组从任意位置劈开后，至少有一半是有序的，什么意思呢？
    //比如 [ 4 5 6 7 1 2 3] ，从 7 劈开，左边是 [ 4 5 6 7] 右边是 [ 7 1 2 3]，左边是有序的。
    //我们可以先找到哪一段是有序的 (只要判断端点即可)，
    //然后看 target 在不在这一段里，如果在，那么就把另一半丢弃。如果不在，那么就把这一段丢弃。


    //time: O(logn)
    //space: O(1)
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            
            //左半段有序
            if(nums[start] <= nums[mid]){
                //target 在左半段
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
                
            // 右半段有序
            }else{
                // target 在右半段
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
