class Solution {
    // 可以用 bucket sort 来优化 前提是数据规模也就是matrix 的 m+n 不会overflow
    // Time: O(mnlog(mn))
    // Space: O(m * n)
    class Pair{
        int w;
        int b;
        int distance;
        Pair(int w, int b, int distance) {
            this.b = b;
            this.w = w;
            this.distance = distance;
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] rst = new int[workers.length];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override 
            public int compare(Pair o1, Pair o2) {
                if (o1.distance == o2.distance) {
                    if (o1.w == o2.w) {
                        return o1.b - o2.b;
                    }
                    return o1.w - o2.w;
                }
                return o1.distance - o2.distance;
            }
        });
        
        // build pairs and PiorityQueue
        for (int i = 0 ; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                Pair p = new Pair(i, j, dist);
                pq.offer(p);
            }
        }
        Set<Integer> visitedW = new HashSet<>();
        Set<Integer> visitedB = new HashSet<>();
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int w = current.w;
            int b = current.b;
            if (!visitedW.contains(w) && !visitedB.contains(b)) {
                rst[w] = b;
                visitedW.add(w);
                visitedB.add(b);
            }
        }
        return rst;
    }
}
