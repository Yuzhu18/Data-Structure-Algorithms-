public class Solution {
  public int random1000() {
    // 利用5的二进制，5^5 = 3125
    while(true){
      int random = 625 * RandomFive.random5() + 125 * RandomFive.random5() + 25 * RandomFive.random5() + 5 * RandomFive.random5() + RandomFive.random5();
      if(random < 3000){
        return random % 1000;
      }
    }
  }
}
