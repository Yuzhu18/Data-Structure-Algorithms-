public class Solution {
  public int percentile95(List<Integer> lengths) {
    // bucket sort
    // O(n)
    int[] bucket = new int[4097];
    for(int i = 0; i < lengths.size(); i++){
      int temp = lengths.get(i);
      bucket[temp] = bucket[temp] + 1;
    }
    int sum = 0;
    int len = 4097;
    while(sum <= 0.05 * lengths.size()){
      sum += bucket[--len];
    }
    return len;
  }
}
