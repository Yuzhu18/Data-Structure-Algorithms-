//public class Solution {
//    public List<Integer> spiral(int[][] matrix) {
//        // follow up : 不是正方形的矩阵
//        //需要设置四个变量
//        List<Integer> rst = new ArrayList<>();
//        int n = matrix.length;
//        if(n == 0){
//            return rst;
//        }
//        int m = matrix[0].length;
//        int left = 0;
//        int right = m - 1;
//        int up = 0;
//        int down = n - 1;
//        while(left < right && up < down){
//            for(int i  = left; i <= right; i++){
//                rst.add(matrix[up][i]);
//            }
//            for(int i = up + 1; i <= down - 1; i++){
//                rst.add(matrix[i][right]);
//            }
//            for(int i = right; i >=left; i--){
//                rst.add(matrix[down][i]);
//            }
//            for(int i = down - 1; i>= up + 1; i--){
//                rst.add(matrix[i][left]);
//            }
//            left++;
//            right--;
//            up++;
//            down--;
//        }
//        //base case
//        //1. there is nothing left
//        if(left > right || up > down){
//            return rst;
//        }
//        //2. there is one column left
//        if(left == right){
//            for(int i = up; i <= down; i++){
//                rst.add(matrix[i][left]);
//            }
//        }else{
//            //3. there is one row left
//            for(int i = left; i <= right; i++){
//                rst.add(matrix[up][i]);
//            }
//        }
//        return rst;
//    }
//}
