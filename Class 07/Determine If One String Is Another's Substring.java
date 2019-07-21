public class Solution {
  public int strstr(String large, String small) {
    
    // 相当于两个For loop
    if(small.length() > large.length()){
      return -1;
    }
    if(small.length() == 0){
      return 0;
    }
    char[] arrayL = large.toCharArray();
    char[] arrayS = small.toCharArray();
    for(int i = 0; i <= arrayL.length - arrayS.length; i++){ ////上限需要减small length 且 <=
      if(equal(arrayL, i, arrayS)){
         return i;
      }
    }
    return -1;
  }
  private boolean equal(char[] large, int i, char[] small){
    for(int j = 0; j < small.length; j++ ){
      if(small[j] != large[i + j]){
        return false;
      }
    }
    return true;
  }
}




