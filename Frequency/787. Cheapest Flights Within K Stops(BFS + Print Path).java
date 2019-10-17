//BFS : 需要打印出来路径
// 先建图-- Map<start_city, [end_city, cost]>
// Queue< [from src to cur city, total_min_cost] >
// pruning branch 需要减支，因为cost都是正数，所以大于当前最小值的路径不用搜索了（不加入queue）
// Time: O(n^(k+ 1) )
// space: O( n^(k+ 1) )


/// 如果想打印出 path : "/////Path"
// 在Flight 类里面多加了一个path 参数


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Flight>> graph = new HashMap<Integer, List<Flight>>();
        for (int i = 0 ; i < flights.length; i++) {
            Flight flight = new Flight(flights[i][1], flights[i][2], " - " + String.valueOf(flights[i][1]));
            int cur = flights[i][0];
            if (!graph.containsKey(cur)) {
                List<Flight> endList = new ArrayList<Flight>();
                endList.add(flight);
                graph.put(cur, endList);
            } else {
                List<Flight> tmp = graph.get(cur);
                tmp.add(flight);
                graph.put(cur, tmp);
            }
        }

        int minCost = Integer.MAX_VALUE;
        ///// Path
        String minPath = "";
        /////
        int step = 0;
        Queue<Flight> queue = new LinkedList<Flight>();
        queue.offer(new Flight(src, 0, String.valueOf(src)));



        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Flight curr = queue.poll();
                int cur_city = curr.city;
                int cur_cost = curr.cost;
                ///// Path
                String cur_path = curr.path;
                /////
                if (cur_city == dst) {
                    minCost = Math.min(minCost, cur_cost);
                    minPath = minCost < cur_cost ? minPath : cur_path;
                }

                List<Flight> list = graph.get(cur_city) == null ? new ArrayList<Flight>() : graph.get(cur_city);
                for (Flight f : list) {
                    // 减支 pruning
                    if (cur_cost + f.cost > minCost) {
                        continue;
                    }
                    queue.offer(new Flight(f.city, cur_cost + f.cost, cur_path + f.path));

                }
            }
            if (step++ > K) {
                break;
            }
        }
        // System.out.println(minPath);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    class Flight{
        private int city;
        private int cost;
        private String path;
        private Flight(int city, int cost, String path) {
            this.city = city;
            this.cost = cost;
            this.path = path;
        }
    }

}
