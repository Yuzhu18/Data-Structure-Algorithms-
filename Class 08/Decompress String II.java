public class Solution {
  public String decompress(String input) {
    // 因为可能存在既有变短a0,b1,c2这种情况，又有变长的情况
    // 所以先处理变短的，再剩下处理都是变长的
    // 预处理变短:
    // 处理变长:正向遍历一遍确认长度，反向遍历填入
    if(input.length() == 0){
      return input;
    }
    char[] arrayIn = input.toCharArray();
    return decodeLonger(arrayIn, decodeShorter(arrayIn));
  }
  
  private int decodeShorter(char[] array){
    int end = 0;
    for(int i = 0; i < array.length; i+= 2){
      int digit = getNumber(array[i + 1]);
      if(digit >= 0 && digit <= 2){
        for(int j = 0; j < digit ; j++){
          array[end++] = array[i];
        }
      }else{
        array[end++] = array[i];
        array[end++] = array[i + 1];
      }
    }
    return end;
  }
  
  private String decodeLonger(char[] array, int length){
    int newLength = length;
    //正向遍历确认新的长度
    for(int i = 0; i < length; i++){    /////上界是length ,而不是array.length
      int digit = getNumber(array[i]);
      if(digit > 2 && digit <= 9){
          newLength = newLength + (digit - 2);
      }
    }
    //反向填入
    char[] newArray = new char[newLength];
    int slow = newArray.length - 1;
    for(int fast = length - 1; fast >= 0; fast--){
      int digit = getNumber(array[fast]);
      if(digit > 2 && digit <= 9){
        fast--;
        for(int j = 0; j < digit; j++){
          newArray[slow--] = array[fast];
        }
      }else{
        newArray[slow--] = array[fast];
      }
    }
    return new String(newArray);
  }
  
  private int getNumber(char num){
    return num - '0';
  }
}

