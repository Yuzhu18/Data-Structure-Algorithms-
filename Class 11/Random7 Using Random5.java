public class Solution {
  public int random7() {
    // 看做一个二维矩阵 / 两位的5进制数
    // random5() * 5 + random5()
    while(true){
      int random = 5 * RandomFive.random5() + RandomFive.random5();
      if(random < 21){
        return random % 7;
      }
    }
  }
}
