class Solution {
    // 遍历一遍,存一个substring的map，保证不重复且计算出现次数
    // 因为是指定了长度是10，所以可以用substring()方法，复杂度是constant的 O(10)
    // Time : O(n)
    // Space: O(n) --map
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rst = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return rst;
        }
        Map<String, Integer> unique = new HashMap<>();
        // 注意计算好范围！！，这里是 "< s.length() - 9"
        for (int i = 0; i < s.length() - 10 + 1 ; i++) {
            String cur = s.substring(i, i + 10);
            int num = unique.getOrDefault(cur, 0);
            unique.put(cur, num + 1);
            if (unique.get(cur) == 2) {
                rst.add(cur);
            }
        }
        return rst;
    }
}
