public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // 1.全部放入hashmap统计frequency
    // 2.放入k heap里找top k
   
   
    //hashmap
    HashMap<String, Integer> map = new HashMap<>();
    for(int i = 0; i < combo.length; i++){
      if(!map.containsKey(combo[i])){
        map.put(combo[i], 1);
      }
      int temp = map.get(combo[i]);
      map.put(combo[i], temp + 1);
    }
    // heap
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, 
      new Comparator<Map.Entry<String, Integer>>(){
        @Override
        public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2){
          return entry1.getValue() < entry2.getValue() ? -1 : 1;
        }
      });
      
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      minHeap.offer(entry);
      if(minHeap.size() > k){
        minHeap.poll();
      }
    }
    
     String[] rst = new String[minHeap.size()];  ///当k > combo.length 的情况
     for(int j = rst.length - 1; j >= 0; j--){
       String cur = minHeap.poll().getKey();
       rst[j] = cur;
     }
    return rst;
  }
}

