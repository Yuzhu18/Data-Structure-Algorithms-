class Solution {
    // DFS 
    // each level represents a worker
    // every level has n branches which is bike numbers, but we can cut branch if we already use this bike
    // Time:O(n^m)
    // Space:O(n)
    public int assignBikes(int[][] workers, int[][] bikes) {
        if (workers == null || workers.length == 0) {
            return 0;
        }
        int[] rst = new int[1];
        rst[0] = Integer.MAX_VALUE;
        dfs(0, workers, bikes, new HashSet<Integer>(), rst, new ArrayList<Integer>());
        return rst[0];
    }
    
    private void dfs(int index, int[][] workers, int[][] bikes, Set<Integer> visitedB, int[] rst, List<Integer> cur) {
        // stop case:
        if (index == workers.length) {
            rst[0] = Math.min(rst[0], sum(cur));
            return;
        }
        // pruning branches
        if (sum(cur) > rst[0]) {
            return;
        }
        
        for (int i = 0; i < bikes.length; i++) {
            if (!visitedB.contains(i)) {
                int dist = Math.abs(bikes[i][0] - workers[index][0]) + Math.abs(bikes[i][1] - workers[index][1]); 
                cur.add(dist);
                visitedB.add(i);
                dfs(index + 1, workers, bikes, visitedB, rst, cur);
                visitedB.remove(i);
                cur.remove(cur.size() - 1);
            }
            
        }
    }
    
    private int sum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
