public class Solution {
  public String decompress(String input) {
    // 先从前往后确定长度
    // 再从后往前填入
    if(input.length() == 0){
      return input;
    }
    char[] arrayIn = input.toCharArray();
    int longer = 0;;
    for(int i = 0; i < arrayIn.length; i++){
      int digit = getNumber(arrayIn[i]);
      if(Character.isDigit(arrayIn[i]) && digit > 2){
        longer = longer + digit - 2;
      }
    }
    char[] result = new char[arrayIn.length + longer];
    int slow = result.length - 1;
    for(int fast = arrayIn.length - 1; fast >= 0; fast--){
      if(Character.isDigit(arrayIn[fast])){
        int num = getNumber(arrayIn[fast]);
        for(int j = 0; j < num; j++){
          result[slow--] = arrayIn[fast - 1];
        }
        fast--;
      }else{
        result[slow--] = arrayIn[fast];
      }
    }
    return new String(result);
  }
  
  private int getNumber(Character digit){
    return digit - '0';
  }
}


