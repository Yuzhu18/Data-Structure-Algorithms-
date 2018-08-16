public class Solution {
  public int[] largestSum(int[] array) {
  
    // follow up 需要返回左右边界index
    if(array.length == 1){
      int[] rst = new int[3];
      rst[0] = array[0];
      rst[1] = 0;
      rst[2] = 0;
      return rst;
    }
    int max = array[0];
    int cur = array[0];
    int right = 0;
    int left = 0;
    for(int i = 1; i < array.length; i++){
      if(cur + array[i] <= array[i]){
        cur = array[i];
        if(max < cur){
          left = i;
        }
      }else{
        cur = cur + array[i];
      }
      if(max < cur){
        max = cur;
        right = i;
      }
    }
    int[] result = new int[3];
    result[0]= max;
    result[1] = left;
    result[2] = right;
    return result;
  }
}
