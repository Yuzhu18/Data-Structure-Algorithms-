class Solution {
    //用双指针，loop 一遍target，尽量匹配更多source里的subsequence
    // greedy 方法
    // Time：O(m * n)
    //Space: O(1)
    public int shortestWay(String source, String target) {
        int rst = 0;
        int t = 0;
        while (t < target.length()) {
            int start = t;
            for (int i = 0; i < source.length(); i++) {
                if (t < target.length() && target.charAt(t) == source.charAt(i)) {
                    t++;
                }
            }
            // 说明source里面没有subsequence能匹配
            if (t == start) {
                return -1;
            }
            rst++;
        }
        return rst;
    }
}
