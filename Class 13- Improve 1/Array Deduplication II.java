//public class Solution {
//    public int[] dedup(int[] array) {
//        // follow up : 最多可以保留两个相同元素
//        // 所以fast 每次和slow - 1 元素比较
//        if(array.length <= 2){
//            return array;
//        }
//        int slow = 1;
//        for(int fast = 2; fast < array.length; fast++){
//            if(array[fast] != array[slow - 1]){
//                array[++slow] = array[fast];
//            }
//        }
//
//        int[] rst = new int[slow + 1];
//        for(int i = 0; i <= slow; i++){
//            rst[i] = array[i];
//        }
//        return rst;
//    }
//}
