public class Solution {
  public int[] search(int[][] matrix, int target) {
  
    // 2D array里的 binary search
    //通过 /col %col 转化成 1D array 的 binary search
    
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = row * col - 1;
    while(left <= right){
      int mid = left + (right - left) / 2;
      int midRow = mid / col;
      int midCol = mid % col;
      int[] pos = new int[2];
      pos[0] = midRow;
      pos[1] = midCol;
      if( matrix[midRow][midCol] == target ){
        return pos;
      }else if(matrix[midRow][midCol] < target){
        left = mid + 1;
      }else {
        right = mid - 1;
      }
    }
    
    return new int[]{-1, -1};
  }
}
