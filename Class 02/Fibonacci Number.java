public class Solution {

  // iteration 版,不会overflow
  
  public long fibonacci(int k) {
  
    if(k < 0){
      return 0;
    }
    if(k == 0 || k == 1){
      return k;
    }
    
    long a = 0;
    long b = 1;
    long c = 1;
    
    for(int i = 1; i < k; i++){
        c = a + b;
        a = b;
        b = c;
      }
      
    return c;
  }
}


//recursion 版本，会overflow

public long fibonacci(int k){

  if(k == 0){
    return 0;
  }
  if(k == 1){
    return 1;
  }
  return fibonacci(n - 1) + fibonacci(n - 2);
}


