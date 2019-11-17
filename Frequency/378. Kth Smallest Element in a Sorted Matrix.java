class Solution {
  // 用BFS-2 expand rule in heap, 确保每次expand出来的点都是当前value 最小的
  // 记得要去重！！！
  // Time: O((E + V) logV)  E --edge
  // Space: O(V)  V -- vertic
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>(){
      @Override
      public int compare(Node o1, Node o2) {
        return o1.val - o2.val;
      }
    });
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    Node start = new Node(0, 0, matrix[0][0]);
    heap.offer(start);
    int num = 0;
    while (!heap.isEmpty()) {
      Node cur = heap.poll();
      num++;
      if (num == k) {
        return cur.val;
      }
      
      // current node's right neighbor
      if (cur.row + 1 < matrix.length && !visited[cur.row + 1][cur.col]) {
        heap.offer(new Node(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        visited[cur.row + 1][cur.col] = true;
      }
      // current node's down neighbor
      if (cur.col + 1 < matrix[0].length && !visited[cur.row][cur.col + 1]) {
        heap.offer(new Node(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    return -1;
  }

  class Node{
    int row;
    int col;
    int val;
    Node(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }
}
