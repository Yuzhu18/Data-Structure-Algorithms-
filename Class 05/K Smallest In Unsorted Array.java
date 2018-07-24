public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // way 1: max heap
    
    if(array.length == 0 || k==0){
      return new int[0];
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
    for(int i = 0; i < array.length; i++){
      if(i < k){
        maxHeap.offer(array[i]);
      }else if(array[i] < maxHeap.peek()){
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    int[] rst = new int[k];
    for(int j = k - 1; j >= 0; j-- ){
      int temp = maxHeap.poll();
      rst[j] = temp;
    }
    return rst;
  }
  
  // way 2: quick select
  
}
