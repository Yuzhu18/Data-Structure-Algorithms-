public class Solution {
  public String reverseWords(String input) {
    // two stack 思想
    if(input == null || input.length() == 0){
      return input;
    }
    String[] array = input.split(" ");
    String rst = array[array.length - 1];
    for(int i = array.length - 2; i >= 0; i--){
      rst = rst + " " + array[i];
    }
    return rst;
  }
}

