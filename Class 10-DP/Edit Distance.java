public class Solution {
  public int editDistance(String one, String two) {
    // M[i][j] ： one 0- ith / two 0 -jth 对应的最小操作数量
    // M[i][j] = min(case1, case2, case3)
    int sizeOne = one.length();
    int sizeTwo = two.length();
    int[][] M = new int[sizeOne + 1][sizeTwo + 1]; /// substring(0,i)不包括i
  
    for(int i = 0; i <= sizeOne; i++){
      for(int j = 0; j <= sizeTwo; j++){
        if(i == 0){   ///// base case 需要写进来
          M[i][j] = j;
        }else if(j == 0){
          M[i][j] = i;
        }else if(one.charAt(i - 1) == two.charAt(j - 1)){
          M[i][j] = M[i - 1][j - 1];
        }else{
          int temp = Math.min(M[i - 1][j], M[i - 1][j - 1]);
          M[i][j] = Math.min(temp, M[i][j - 1]) + 1;
        }
      }
    }
    return M[sizeOne][sizeTwo];
  }
}
