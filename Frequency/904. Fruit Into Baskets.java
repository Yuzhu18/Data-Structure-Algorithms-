//similar to 2.longest subtring without repeatted characters
//time: loop once O(n)
//space: map O(n)

class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> hashmap = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int end = 0; end < tree.length; end++) {
            hashmap.put(tree[end], hashmap.getOrDefault(tree[end], 0) + 1);
            
            while (hashmap.size() > 2) {
                hashmap.put(tree[start], hashmap.get(tree[start]) - 1);                
                if (hashmap.get(tree[start]) == 0) {
                    hashmap.remove(tree[start]);
                }
                start++;
            }
            max = Math.max(end - start + 1, max);            
        }
        return max;
    }
}
