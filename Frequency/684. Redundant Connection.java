class Solution {
    // 在无向图里面找circle, 用类似有向图里的拓扑排序
    // 计算每个node的degree
    // 如果在环里，那么整个环上的每个点，degree一定 >= 2
    // 我们每次将degree == 1 的node 加入queue里，然后最后剩下的就是环上的点
    // 删除环上任意一个边就行啦
    // Time: O(n) -- BFS
    // Space: O(n) -- queue
    
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            int left = edges[i][0];
            int right = edges[i][1];
            allNodes.add(left);
            allNodes.add(right);
            int degreeL = degree.getOrDefault(left, 0);
            int degreeR = degree.getOrDefault(right, 0);
            degree.put(left, degreeL + 1);
            degree.put(right, degreeR + 1);
            List<Integer> nL = neighbor.getOrDefault(left, new ArrayList<Integer>());
            List<Integer> nR = neighbor.getOrDefault(right, new ArrayList<Integer>());
            nL.add(right);
            nR.add(left);
            neighbor.put(left, nL);
            neighbor.put(right, nR);
        }
        // add the nodes with <= 1 degree into queue
        Deque<Integer> queue = new LinkedList<>();
        for (int i : degree.keySet()) {
            if (degree.get(i) <= 1) {
                queue.offer(i);
            }
        }
        // loop the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();
            allNodes.remove(node);
            // loop through all its neighbors
            for (int n : neighbor.get(node)) {
                int num = degree.get(n);
                degree.put(n, num - 1);
                if (num - 1 == 1) {
                    queue.offer(n);
                }
            }
        }
        // find the edges to remove
        int[] rst = new int[2];
        for (int j = edges.length - 1; j >= 0; j--) {
            if (allNodes.contains(edges[j][0]) && allNodes.contains(edges[j][1])) {
                rst[0] = edges[j][0];
                rst[1] = edges[j][1];
                return rst;
            }
        }
        return rst;
    }
}
