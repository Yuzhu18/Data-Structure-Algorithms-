class Solution {
    //一边遍历，一边预处理，i*2, i*3, i* ....i*j < n
    // time: 比 O(n)大， 但是小于 O(n * 根号n) -- isPrime 的做法， 
    // 因为预处理过的数字，之后不会进循环了
    public int countPrimes(int n) {
        //初始 boolean[] 都是false
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n ; i++){
            if(notPrime[i] == false){
                count++;
                //预处理， pre-operate
                for(int j = 2; i * j < n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}



