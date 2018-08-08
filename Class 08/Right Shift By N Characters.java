public class Solution {
  public String rightShift(String input, int n) {
    // 两边分别翻转，再整体翻转
    if(input.length() < 2 || n == 0){
      return input;
    }
    char[] arrayIn = input.toCharArray();
    n %= arrayIn.length;
    reverse(arrayIn, 0, arrayIn.length - n - 1);
    reverse(arrayIn, arrayIn.length - n, arrayIn.length - 1);
    reverse(arrayIn, 0, arrayIn.length - 1);
    return new String(arrayIn);
  }
  private void reverse(char[] array, int left, int right){
    while(left < right){
      swap(array, left++, right--);
    }
  }
  
  private void swap(char[] array, int left, int right){
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}


