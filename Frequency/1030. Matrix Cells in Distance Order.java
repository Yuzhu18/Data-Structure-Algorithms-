class Solution {
    //BFS time: O(R*C)
    // vistied array: space: O(R * C)
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        boolean[][] visited = new boolean[R][C];
        int[][] result = new int[R * C][2];
        int index = 0;
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curR = cell[0];
            int curC = cell[1];
            if (curR < 0 || curR >= R || curC < 0 || curC >= C) {
                continue;
            }
            if (visited[curR][curC] == true) {
                continue;
            }
            
            visited[curR][curC] = true;
            result[index] = cell;
            index++;
            queue.offer(new int[]{curR - 1, curC});
            queue.offer(new int[]{curR + 1, curC});
            queue.offer(new int[]{curR, curC - 1});
            queue.offer(new int[]{curR, curC + 1});
        }
        return result;
    }
}
