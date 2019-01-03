class Solution {
    // Integer range -2^31 ~ 2^31 - 1
    // 所以需要防止 reverse之后溢出
    // time : O(logn) 以10为底
    //space: O(1)
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int tail = x % 10;
            int newRst = result * 10 + tail;
            //prevent Integer overflow
            if((newRst - tail) / 10 != result){
                return 0;
            }
            result = newRst;
            x = x / 10;
        }
        return result;
    }
}


