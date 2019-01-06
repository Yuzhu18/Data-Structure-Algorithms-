class Solution {
    //实质是directed graph判断是否有环
    // BFS / DFS 都可以
    // time: O(n)
    // space: O(n)
    // 1. 统计所有点的入度数 ： 初始indegree 数组
    // 2. 入度为零的先加入queue，作为起始点遍历
    // 3. 遍历过程中，遍历过的点，对应的入度减少，直到遍历完
    // 4. 所有点入度为零，说明无环， 入度不为零说明有环
    
    //1. BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if(numCourses == 0 || len == 0){
            return true;
        }
        
        // store every course indegree num
        int[] indegree = new int[numCourses];
        for(int i = 0; i < len; i++){
            indegree[prerequisites[i][0]]++;
        }
        
        //push 0 indegree course into queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int j = 0; j < numCourses; j++){
            if(indegree[j] == 0){
                queue.offer(j);
            }
        }
        
        //BFS
        int numNoPre = queue.size();
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int i = 0; i < len; i++){
                if(prerequisites[i][1] == top){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        numNoPre++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourses == numNoPre;
    }
}
