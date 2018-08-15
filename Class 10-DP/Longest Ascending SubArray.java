public class Solution {
  public int longest(int[] array) {
  
    // DP: M[i] 代表从0th 到 ith(必须包括ith / 因为subarray必须连续)的范围中最大长度
    
    if(array.length == 0){
      return 0;
    }
    int max = 1;
    int size = array.length;
    int[] Max = new int[size];   ///这一部分空间复杂度可以省，只用一个变量代替 int cur
    Max[0] = 1;
    for(int i = 1; i < array.length; i++){
      if(array[i] > array[i - 1]){
        Max[i] = Max[i - 1] + 1;
        if(max < Max[i]){
          max = Max[i];
        }
      }else{
        Max[i] = 1;
      }
    }
    return max;
  }
}
