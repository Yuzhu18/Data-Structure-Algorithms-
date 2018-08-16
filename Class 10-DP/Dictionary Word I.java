public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // 左大段 + 右小段
    // M[i] 0 - ith个字母是否在字典里(必须包含i)
    char[] arrayIn = input.toCharArray();
    boolean[] M = new boolean[input.length()];
    if(inDic(dict, input.substring(0, 1))){
      M[0] = true;
    }else{
      M[0] = false;
    }
    for(int i = 1; i < input.length();i++){
      M[i] = false;
      String left = input.substring(0, i + 1);
      if(inDic(dict, left)){
        M[i] = true;
      }else{
        for(int j = 0; j < i; j++){
          String tmp = input.substring(j + 1, i + 1);
          if(M[j] && inDic(dict, tmp)){
            M[i] = true;
          }
        }
      }
    }
    return M[input.length() - 1];
  }
  
  private boolean inDic(String[] dict, String in){
    for(int i = 0; i < dict.length; i++){
      if(dict[i].equals(in)){
        return true;
      }
    }
    return false;
  }
}
