class Solution {
    public int[] productExceptSelf(int[] nums) {
        // loop 两次 left -> right  && right -> left
        //time: O(n)
        //space: O(1)
        
        int[] rst = new int[nums.length];
        rst[0] = 1;
        for(int i = 1; i < nums.length ; i++){
            rst[i] = rst[i - 1] * nums[i - 1] ;
        }
        int right = 1;
        for(int j = nums.length - 1; j >= 0; j--){
            rst[j] *= right;
            right *= nums[j];
        }
        return rst;
    }
}






