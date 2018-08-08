public class Solution {
  public String reverse(String input) {
    // 不断swap
     if(input.length() == 0){
       return input;
     }
    char[] arrayIn = input.toCharArray();
    int left = 0;
    int right = arrayIn.length - 1;
    while(left < right){
      swap(arrayIn, left++, right--);
    }
    return new String(arrayIn);
  }
  
  private void swap(char[] array, int left, int right){
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}


