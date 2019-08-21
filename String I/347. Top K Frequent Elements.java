class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 和String array 同样的方法： 先放进hashmap里, 再用minheap
        //time : O (nlogk)
        //space: hasmap: O(n)
        if (nums.length == 0) {
           return new ArrayList<Integer>(); 
        }
        
        // add all elements into hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int tmp = map.get(nums[i]);
                map.put(nums[i], tmp + 1);
            }
        }
        
        // build minheap
        PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        
        // put elements in minheap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minheap.offer(entry);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        //return reesult list
        List<Integer> rst = new ArrayList<>();
        while (!minheap.isEmpty() ){
            rst.add(0, minheap.poll().getKey());
        }
        return rst;
    }
}
