class Solution {
    // one pass, 如果发现走到第i 个点gas < 0, 说明之前的点都不符合
    // 从下一个点继续走，直到找到结果
    // time: O(n)
    // space: O(1)
    //If car starts at A and can not reach B. Any station between A and B
    //can not reach B.(B is the first station that A can not reach.)
    //If the total number of gas is bigger than the total number of cost. There must be a solution.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int startIndex = 0;
        int tank = 0;
        for(int i = 0; i < gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                startIndex = i + 1;
                tank = 0;
            }
        }
        
        if(sumGas < sumCost){
            return -1;
        }else{
            return startIndex;
        }
        
    }
}







