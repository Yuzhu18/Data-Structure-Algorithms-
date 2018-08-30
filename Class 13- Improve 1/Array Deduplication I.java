//public class Solution {
//    public int[] dedup(int[] array) {
//        // 已经sorted的array去重，并保证相对顺序
//        // two pointers
//        if(array.length <= 1){
//            return array;
//        }
//        int slow = 0;
//        for(int fast = 1; fast < array.length; fast++){
//            if(array[fast] != array[slow]){
//                array[++slow] = array[fast];
//            }
//        }
//        int[] rst = new int[slow + 1];
//        for(int i = 0; i <= slow; i++){
//            rst[i] = array[i];
//        }
//        return rst;
//    }
//}
