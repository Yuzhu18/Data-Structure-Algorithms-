// 要求in-place 实现
// Time: O(m * n)
// Space：O(1)


//先把第一行/ 第一列有没有0记录下来

// 然后以第一行和第一列为基准，先loop一遍除了第一行和第一列的元素，
// 如果发现是零，那么更新对应的第一行或者第一列的元素
// 最后一起处理：
//    1.当前行的第一行是0 -- 全行都是0
//    2.当前列第一列是0  -- 全列都是0


class Solution {
    public void setZeroes(int[][] matrix) {
        //corner case
        if (matrix.length == 0) {
            return;
        }
        
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // check the first row
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        //check the first column
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // check the other cells except the first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // handle the other cells , except the first row and first col
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // handle the first row 
        if (firstRowZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
        // handle first col
        if (firstColZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
