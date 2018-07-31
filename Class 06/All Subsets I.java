public class Solution {
  public List<String> subSets(String set) {
  
    // DFS 
    // n level, each level repreasents the letter exist or not
    
    List<String> rst = new ArrayList<>();
    if(set == null){
      return rst;
    }
    char[] arraySet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(arraySet, sb, 0, rst);
    return rst;
  }
  private void helper(char[] set, StringBuilder sb, int index, List<String> rst ){
    //base case
    if(index == set.length){
      rst.add(sb.toString());
      return;
    }
    // case 1: 这个元素不加
    helper(set, sb, index + 1, rst);
    //case 2： 加这个元素
    helper(set, sb.append(set[index]), index + 1, rst);
    sb.deleteCharAt(sb.length() - 1);  // 恢复
  }
}
