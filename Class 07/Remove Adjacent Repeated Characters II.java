public class Solution {
  public String deDup(String input) {
    // 涉及回头看数据结构 ： stack
    // two pointers
    
    if(input == null || input.length() < 2){
      return input;
    }
    char[] arrayIn = input.toCharArray();
    int end = 0;  // 模拟stack头指针
    for(int fast = 1; fast < arrayIn.length; fast++){
      if(end == -1 || arrayIn[fast] != arrayIn[end]){
        arrayIn[++end] = arrayIn[fast];
      }else {
        end--;
        while(fast + 1 < arrayIn.length && arrayIn[fast] == arrayIn[fast + 1]){
          fast++;
        }
      }
    } 
    return new String(arrayIn, 0, end + 1);
  }
}

