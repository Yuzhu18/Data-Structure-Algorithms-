class Solution {
    // 同Course Schedule I
    // 只是遍历的同时把结果存下来
    // time: O(n)
    // space: O(n)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        //if there is no prerequisites, return a sequence of courses
        if(len == 0){
            int[] res = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                res[i]=i;
            }
            return res;
        }
        
        // store every course indegree(pre course) num
        int[] indegree = new int[numCourses];
        for(int j = 0; j < len ; j++){
            indegree[prerequisites[j][0]]++;
        }
        
        // push indegree 0 course into queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        //DFS and store rst
        int numNoPre = queue.size();
        // initilize result array
        int[] rst = new int[numCourses];
        int index = 0;
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            rst[index++] = top;
            for(int j = 0; j < len; j++){
                if(prerequisites[j][1] == top){
                    indegree[prerequisites[j][0]]--;
                    if(indegree[prerequisites[j][0]] == 0){
                        numNoPre++;
                        queue.offer(prerequisites[j][0]);
                    }
                }
            }
        }
        
        if(numCourses == numNoPre){
            return rst;
        }else{
            return new int[0];
        }
        
    }
}
