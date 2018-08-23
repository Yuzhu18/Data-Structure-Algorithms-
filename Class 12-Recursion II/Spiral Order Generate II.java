public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    // follow up : 生成一个长方形
    // iterative way
    int[][] rst = new int[m][n];
    if(m == 0 || n == 0){
      return rst;
    }
    int left = 0;
    int right = n - 1;
    int up = 0;
    int down = m - 1;
    int num = 1;
    while(left < right && up < down){
      for(int i = left; i <= right; i++){
        rst[up][i] = num++;
      }
      for(int i = up + 1; i <= down - 1; i++){
        rst[i][right] = num++;
      }
      for(int i = right; i >= left; i--){
        rst[down][i] = num++;
      }
      for(int i = down - 1; i >= up + 1; i--){
        rst[i][left] = num++;
      }
      left++;
      right--;
      up++;
      down--;
    }
    // base case 
      //1. there is no left
      if(left > right || up > down){
        return rst;
      }
      //2. there is one col left
      if(left == right){
        for(int i = up; i<= down ; i++ ){
          rst[i][left] = num++;
        }
      }else{
        //3. there is one row left
        for(int i = left; i <= right; i++){
          rst[up][i] = num++;
        }
      }
    return rst;
  } 
}
