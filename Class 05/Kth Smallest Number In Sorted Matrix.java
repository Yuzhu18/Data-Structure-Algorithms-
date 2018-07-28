public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // BFS 2 (Dijsktra)
    int row = matrix.length;
    int col = matrix[0].length;
    boolean[][] visited = new boolean[row][col];
    
    PriorityQueue<Cell> heap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                else {
                    return c1.value < c2.value ? -1 : 1;
              }
            }
        });
    
    heap.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    for(int i = 0; i < k - 1; i++){
      Cell cur = heap.poll();
      int curRow = cur.row;
      int curCol = cur.col;
      if(curRow + 1 < row && visited[curRow + 1][curCol] != true){
        heap.offer(new Cell(curRow + 1, curCol, matrix[curRow + 1][curCol]));
        visited[curRow + 1][curCol] = true;
      }
      if(curCol + 1 < col && visited[curRow][curCol + 1] != true){
        heap.offer(new Cell(curRow, curCol + 1, matrix[curRow][curCol + 1]));
        visited[curRow][curCol + 1] = true;
      }
    }
    return heap.peek().value;
  }
  
  static class Cell{
    int row;
    int col;
    int value;
     
      Cell(int row, int col, int value){
      this.row = row;
      this.col = col;
      this.value = value;
    }
  } 
}

 
