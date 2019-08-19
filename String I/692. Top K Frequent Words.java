class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // minheap + 自定义Comparator
        // time: O(n + klogk)
        // space: O(n)
        if (words.length == 0) {
            return new ArrayList<String>();
        }
        // build hashmap
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                int num = map.get(words[i]);
                map.put(words[i], num + 1);
            }
        }
        // build minheap
        PriorityQueue<Map.Entry<String, Integer>> minheap = new PriorityQueue<>( new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) {
                    return e2.getKey().compareTo(e1.getKey());
                }else {
                    return e1.getValue().compareTo(e2.getValue());
                }
            }
        });
        // loop the hashmap, fill the minHeap
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            minheap.offer(entry);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        // build result list
        List<String> rst = new ArrayList<>();
        while(!minheap.isEmpty()) {
            rst.add(0, minheap.poll().getKey());
        }
        return rst;
    }
}
