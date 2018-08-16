public class Solution {
  public int minJump(int[] array) {
    // 求最小跳跃步数
    // 从后往前扫 M[i] 代表i到最后位置的最小步数
    // 取可到达的已知步数的最小值
    if(array.length == 1){
      return 0;
    }
    int[] M = new int[array.length];
    M[array.length - 1] = 0;
    for(int i = array.length - 2; i >= 0; i--){
      if(array[i] == 0 ){
        M[i] = -1;
      }else{
        //任意设一个初始值min
        int min = array.length - i;
        for(int j = array[i]; j >= 1; j--){
          //保证不越界out of index
          if(i + j < array.length){
            if(min > M[i + j] && M[i + j] != -1){
              min = M[i + j];
            }
          }
        }
        if(min == array.length - i){
          M[i] = -1;
        }else{
          M[i] = 1 + min;
        }
      }
    }
    return M[0];
  }
}
