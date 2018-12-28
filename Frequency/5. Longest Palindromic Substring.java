class Solution {
    // time : O (n ^ 2)
    // space: O(1)
    int start = 0;
    int max = 0;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        
        for(int i = 0; i < s.length(); i++){
            expandCenter(s, i, i);
            expandCenter(s, i, i + 1);
        }
        return s.substring(start, start + max );
        
    }
    
    public void expandCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(max < right - left - 1){
            start = left + 1;
            max = right - left - 1;
        }
    }
}
