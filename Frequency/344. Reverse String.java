class Solution {
    // inplace reverse
    // time: O(n)
    // space: O(1)
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            swap(s, left, right);
            left++;
            right--;
        }
    }
    private void swap(char[]s, int left, int right){
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }
}
