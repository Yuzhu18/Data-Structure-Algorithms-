public class Solution {
  public List<String> validParentheses(int n) {
  
    // each level represent each poisition
    // each level states to be left / right ()
    
    List<String> rst = new ArrayList<>();
    if(n == 0){
      return rst;
    }
    StringBuilder sb = new StringBuilder();
    helper(rst, 0, 0, n, sb);
    return rst;
  }
  private void helper(List<String> rst, int left, int right, int n, StringBuilder sb){
    //base case
    if(left + right == 2 * n){
      rst.add(sb.toString());
      return;
    }
    if(left < n){
      sb.append("(");
      helper(rst, left + 1, right, n, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
    
    if(left > right){
      sb.append(")");
      helper(rst, left, right + 1, n, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}


