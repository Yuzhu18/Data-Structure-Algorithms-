public class Solution {

  public long power(int a, int b) {
   
    if(b == 0){
      return 1;
    }
    long temp = power(a, b / 2);
    if(b % 2 == 0){
      return temp * temp;
    }else{
      return temp * temp * a;
    }
  }
}
