public class Solution {
  //
  public int diffBits(int a, int b) {
    int bit = 0;
    
    // 注意increment条件要用>>>而不是>>，当a^b为负数时，首位为1，用>>会一直在左侧补1导致死循环
    for (int c = a ^ b; c != 0; c >>>= 1) {
      bit += c & 1;
    }    
    return bit;
  }  
}
