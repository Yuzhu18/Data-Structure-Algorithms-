// BFS ，把matrix状态变成String表示
// 优化的话可以提前预处理一下，每个格子可以到达的位置
// time： O( (n*m)! ) ,如果是3*3的话就是 9！
// space： O( (n*m)! ) 
// 打印路径 “/////path”

class Solution {
    public int slidingPuzzle(int[][] board) {
        int rows = 2;
        int cols = 3;
        String goal = "123450";
        String start = "";
        for (int i = 0 ;i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        if (start.equals(goal)) {
            return 0;
        }
        int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //////path
        String[] move = {"left", "right", "up", "down"};
        //////
        Set<String> visited = new HashSet<>();
        int step = 0;
        
        //////path : queue of list 对应另外一个queue，每个到当前状态的路径存在list里
        Queue<List<String>> path = new LinkedList<>();
        path.offer(new ArrayList<>());
        //////
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                
                //////path
                List<String> curPath = path.poll();
                //////
                
                int zero = cur.indexOf('0');
                int y = zero / cols;
                int x = zero % cols;
                for (int j = 0; j < 4 ; j++) {
                    int new_x = x + direct[j][0];
                    int new_y = y + direct[j][1];
                    if (new_x < 0 || new_y < 0 || new_x >= cols || new_y >= rows) {
                        continue;
                    }
                    int new_zero = new_y * cols + new_x;
                    // swap the new zero index, current zero index
                    String new_status = swap(cur, zero, new_zero);
                    //////path
                    List<String> newPath = new ArrayList<>(curPath);
                    newPath.add(move[j]);
                    //////
                    if (visited.contains(new_status)) {
                        continue;
                    }
                    if (new_status.equals(goal)) {
                        return step;
                    }
                    visited.add(new_status);
                    queue.offer(new_status);
                    //////path
                    path.offer(newPath);
                    //////
                }
            }
        }
        return -1;
    }
    
    private String swap(String s, int left, int right){
        char[] array = s.toCharArray();
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
        return new String(array);
    }
}
