public class Solution {
    public int[] dedup(int[] array) {
    // follow up: 如果有重复都不保留
    // 设置两个fast指针，判断fast2- fast1 >= 1, 则不放，如果< 1，则放
    // 同理fast2 - fast1 也适用于“最多保留n个元素的follow up”
    if(array.length <= 1){
      return array;
    }
    int slow = -1;
    int fast1 = 0;
    for(int fast2 = 0; fast2 < array.length; fast2++){
      if(array[fast2] != array[fast1]){
        if(fast2 - fast1 <= 1){
          array[++slow] = array[fast1];
          fast1 = fast2 ;
        }else{
          fast1 = fast2 ;
        }
      }
    }
    //// 需要验证最后一个元素是否包含
    if(fast1 == array.length - 1){
      array[++slow] = array[fast1];
    }
    return Arrays.copyOf(array, slow + 1);
  }
}


/// way 2: 利用flag验证
  public int[] dedup(int[] array) {
  if(array.length <= 1){
      return array;
  }
  int slow = 0;
  boolean flag = false;
  for(int fast = 1; fast < array.length; fast++){
    if(array[fast] == array[slow]){
      flag = true;
    }else if(flag == true){
      array[slow] = array[fast];
      flag = false;
    }else{
      array[++slow] = array[fast];
    }
  }
  return Arrays.copyOf(array, flag ? slow : slow + 1);
}
