import java.util.*;

public class Main {

    public static void main(String[] args) {
        double[] prices = {12.13, 3.2356, 4.5, 2.2345647, 8.23, 15.29};
        List<List<Double>> rst = getCombos(prices, 13.70016);
        for (List<Double> l : rst) {
            for (double d : l) {
                System.out.println(d);
            }
            System.out.println("=============");
        }
    }

    // 问精度 ！！！ 问是否可以重复order一种东西
    // 思路是先sort，然后DFS，中间减支
    // space: O(n) recursion
    // time ： O（2^n）

    // 先处理精度问题，在调用search（），此方法精度是0.01，但是有overflow的风险（尽量避免说overflow）
    // （这个方法不太行----> 直接用double然后在判断的时候用  abs(a+b-c) < 0.0000001
    private static List<List<Double>> getCombos(double[] prices, double target) {
        List<List<Double>> res = new ArrayList<List<Double>>();
        if (prices == null || prices.length == 0 || target <= 0) {
            return res;
        }

        int centsTarget = (int) Math.round(target * 100);
        Arrays.sort(prices);
        int[] centsPrices = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            centsPrices[i] = (int) Math.round(prices[i] * 100);
        }

        search(res, centsPrices, 0, centsTarget, new ArrayList<Double>(), prices);
        return res;
    }


    // DFS 找 combination
    private static void search(List<List<Double>> res, int[] centsPrices, int start, int centsTarget, List<Double> curCombo, double[] prices) {

        // 还可以直接用double然后在判断的时候用  abs(a+b-c) < 0.0000001！！！！！！！
        if (centsTarget == 0) {
            res.add(new ArrayList<Double>(curCombo));
            return;
        }

        for (int i = start; i < centsPrices.length; i++) {
            if (i > start && centsPrices[i] == centsPrices[i - 1]) {
                continue;
            }
            // pruning 减支
            if (centsPrices[i] > centsTarget) {
                break;
            }

            curCombo.add(prices[i]);
            // 如果是可以重复的话就是 start = i ！！！！！！！，否则是 i + 1
            search(res, centsPrices, i + 1, centsTarget - centsPrices[i], curCombo, prices);
            curCombo.remove(curCombo.size() - 1);
        }
    }

    ///////////////////////Using "abs(a+b-c) < 0.0000001" Way 这个方法不太行 ！！！！ ////////////////////////////////

//    private static List<List<Double>> getCombos2(double[] prices, double target){
//        List<List<Double>> res = new ArrayList<List<Double>>();
//        if (prices == null || prices.length == 0 || target <= 0) {
//            return res;
//        }
//        Arrays.sort(prices);
//        bfs(res, prices, new ArrayList<Double>(), target, 0);
//        return res;
//    }
//
//
//    private static void bfs(List<List<Double>> rst, double[] candidates, List<Double> cur, double target, int start){
//        //Using "abs(a+b-c) < 0.0000001"
//        if(Math.abs(target) < 0.0000001 ){
//            System.out.println("target now is: " + target);///////////////////////
//            rst.add(new ArrayList<Double>(cur));
//            return;
//        }
//        for(int i = start; i < candidates.length; i++){
//            // 减支 ： 如果当前candidate 大于target，那么就不会有符合条件的组合了
//            if (candidates[i] > target) {
//                break;
//            }
//            cur.add(candidates[i]);
//            bfs(rst, candidates, cur, target - candidates[i], i + 1);// not i + 1 because it can be repeatedly used
//            cur.remove(cur.size() - 1);
//        }
//    }
}
