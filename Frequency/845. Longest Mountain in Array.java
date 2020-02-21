class Solution {
    // DP 正向遍历一遍，再反向遍历一遍
    // ascend[i]:  [0 ~ i) continuous asending subarray length
    // descend[i]: [0 ~ i) continuous descending subarray length
    // Time : O(n)
    // Space: O(n)
    public int longestMountain(int[] A) {
        int[] ascend = new int[A.length];
        int[] descend = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] > A[i-1]) {
                ascend[i] = ascend[i - 1] + 1;
            }
        }
        
        for (int j = A.length - 2; j >= 0; j--) {
            if (A[j + 1] < A[j]) {
                descend[j] = descend[j + 1] + 1;
            }
        }
        int rst = 0;
        for (int k = 0; k < A.length; k++) {
            if (ascend[k] > 0 && descend[k] > 0) {
                rst = Math.max(rst, ascend[k] + descend[k] + 1);
            }
        }
        return rst;
    }
}
