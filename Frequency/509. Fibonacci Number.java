class Solution {
    // 1. iterative way, 不会overflow
    public int fib(int N) {
        // base case 
        if(N < 0){
            return 0;
        }else if(N == 0 || N == 1){
            return N;
        }
        int a = 0;
        int b = 1;
        int curSum = 1;
        for(int i = 1; i < N; i++){
            curSum = a + b;
            a = b;
            b = curSum;
        }
        return curSum;
    }
    
//     // 2. recursion way 可能会overflow
//     public int fib(int N){
//         if(N == 0){
//             return 0;
//         }else if( N == 1){
//             return 1;
//         }
        
//         return fib(n - 1) + fib(n - 2);
//     }
}
