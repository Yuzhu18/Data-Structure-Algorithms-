// method 1 : PQ 
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // time : O (nlogk) 遍历所有的点，但是维持一个k size 的 max-PQ, 不把所有的点放进PQ里
        // space: O (k) k size pq
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new myComparator());
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] rst = new int[K][2];
        while (K > 0) {
            rst[--K] = pq.poll();
        }
        return rst;
    }
}
//自定义 comparator
class myComparator implements Comparator<int[]>{
    public int compare(int[] a, int[]b){
        return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
    }
}


// method 2 : quick select -- kth smallest XX 
// 找pivot， 类似quick select，但是只需要recursion 一边
