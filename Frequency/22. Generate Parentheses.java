class Solution {
    // DFS backtracking 
    // time: O(2^2n)
    // space: O(2n)
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        helper(rst, 0, 0, "", n);
        return rst;
    }
    
    private void helper(List<String> rst, int left, int right, String curStr, int max){
        if(curStr.length() == max * 2){
            rst.add(curStr);
            return;
        }
        //can add left parenthesis
        if(left < max){
            helper(rst, left + 1, right, curStr + "(", max);
        }
        //can add right parenthesis
        if(right < left){
            helper(rst, left, right + 1, curStr + ")", max);
        }
    }
}
