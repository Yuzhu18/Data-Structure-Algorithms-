public class Solution {
  public String removeSpaces(String input) {
    // two pointers 
    if(input.length() == 0){
      return input;
    }
    char[] arrayIn = input.toCharArray();
    int end = 0;
    for(int fast = 0; fast < arrayIn.length; fast++){
      //1.第一个是空格时不拷贝
      //2.前一个是空格时不拷贝
      if(arrayIn[fast] == ' ' && (fast == 0 || arrayIn[fast - 1] == ' ')){
        continue;
      }
      arrayIn[end++] = arrayIn[fast];
    }
    
    // 跳出循环时，最后一个可能是空格
      if(end > 0 && arrayIn[end - 1] == ' '){
        return new String(arrayIn, 0, end - 1);
      }
      return new String(arrayIn, 0, end);
  }
}





