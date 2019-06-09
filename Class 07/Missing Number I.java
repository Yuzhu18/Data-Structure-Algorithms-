public class Solution {
  public int missing(int[] array) {
    // 1. 求和相减
    if(array.length == 0){
      return 1;
    }
    int sum = 0;
    int expect = (2 + array.length) * (array.length + 1) / 2;
    for(int i = 0; i < array.length; i++){
      sum = sum + array[i];
    }
    int rst = expect - sum;
    return rst;
  }
}



// 2. bit way

public class Solution {
    public int missing(int[] array) {
        int xor = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            xor ^= i;
        }

        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }

        return xor;
    }
}
