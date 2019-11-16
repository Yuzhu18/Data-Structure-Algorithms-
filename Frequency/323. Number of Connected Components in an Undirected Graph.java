class Solution {
    // 主要的idea是进行图的遍历，任意node开始，每BFS遍历一次，说明遍历到一个connected的图
    // 所以遍历了几次就代表有多少个connected 图
    
    public int countComponents(int n, int[][] edges) {
        
        Set<Integer> allNodes = new HashSet<>();
        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        for (int i = 0; i < edges.length ; i++) {
            int left = edges[i][0];
            int right = edges[i][1];
            allNodes.add(left);
            allNodes.add(right);
            List<Integer> leftN = neighbor.getOrDefault(left, new ArrayList<Integer>());
            List<Integer> rightN = neighbor.getOrDefault(right, new ArrayList<Integer>());
            leftN.add(right);
            rightN.add(left);
            neighbor.put(left, leftN);
            neighbor.put(right, rightN);
        }
        int rst = n - allNodes.size(); /// 若有单独的点，相当于没有边
        while (allNodes.size() > 0) {
            rst++;
            bfs(allNodes, neighbor);
        }
        return rst;
    } 
    
    private void bfs(Set<Integer> allNodes, Map<Integer, List<Integer>> neighbor) {
        Deque<Integer> queue = new LinkedList<>();
        for (int e : allNodes) {
            queue.offer(e);
            break;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            allNodes.remove(cur);
            for (int n : neighbor.get(cur)) {
                if (allNodes.contains(n)) {
                    queue.offer(n);
                }
            }
        }
    }
    
    
    
    ///////union find 方法
//     public int countComponents(int n, int[][] edges) {
//         int[] roots = new int[n];
//         for(int i = 0; i < n; i++) roots[i] = i; 

//         for(int[] e : edges) {
//             int root1 = find(roots, e[0]);
//             int root2 = find(roots, e[1]);
//             if(root1 != root2) {      
//                 roots[root1] = root2;  // union
//                 n--;
//             }
//         }
//         return n;
//     }

//     public int find(int[] roots, int id) {
//         while(roots[id] != id) {
//             roots[id] = roots[roots[id]];  // optional: path compression
//             id = roots[id];
//         }
//         return id;
//     }
}
