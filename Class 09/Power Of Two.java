public class Solution {
  public boolean isPowerOfTwo(int number) {
  
    // 保证是正数的前提下
    // 2的倍数的二进制，一定是只有一位是1，其余都是0
    return (number & (number - 1)) == 0 && number > 0;
  }
}
