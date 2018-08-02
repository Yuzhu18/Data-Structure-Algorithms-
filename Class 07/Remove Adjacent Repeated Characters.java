public class Solution {
  public String deDup(String input) {
    // to char array : two pointers
    if(input == null || input.length() < 2){
      return input;
    }
    char[] arrayIn = input.toCharArray();
    int slow = 0;
    int fast = 1;
    while(fast < arrayIn.length ){
      if(arrayIn[fast] != arrayIn[slow]){
        slow++;
        arrayIn[slow] = arrayIn[fast];
      }
      fast++; 
    }
    return new String(arrayIn, 0, slow + 1);
  }
}


