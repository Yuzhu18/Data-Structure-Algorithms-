//public class Solution {
//    public List<Integer> spiral(int[][] matrix) {
//        // 每次记录正方形的size， 起始点坐标offset
//        // 然后四个for循环，上右下左四个边
//        if(matrix.length == 0){
//            return new ArrayList<Integer>();
//        }
//        List<Integer> rst = new ArrayList<>();
//        helper(matrix, 0, matrix.length, rst);
//        return rst;
//    }
//    private void helper(int[][] matrix, int offset, int size , List<Integer> rst){
//        if(size == 0){
//            return;
//        }
//        if(size == 1){
//            rst.add(matrix[offset][offset]);
//            return;
//        }
//        // upper row
//        for(int i = 0; i < size - 1; i++){
//            rst.add(matrix[offset][offset + i]);
//        }
//        // right col
//        for(int j = 0; j < size - 1; j++){
//            rst.add(matrix[offset + j][offset + size - 1]);
//        }
//        // bottom row
//        for(int n = size - 1; n >= 1; n--){
//            rst.add(matrix[offset + size - 1][offset + n]);
//        }
//        //left col
//        for(int m = size - 1; m >=  1; m--){
//            rst.add(matrix[offset + m][offset]);
//        }
//        helper(matrix, offset + 1, size - 2, rst);
//    }
//}
