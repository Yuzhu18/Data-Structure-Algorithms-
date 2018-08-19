public class Solution {
  // 维持一个k size 的sample
  // 当data stream < k 时直接读进 ; 当data stream > k时，每次读进要随机删除一个
  private final int k;
  private int count;
  private List<Integer> sample;
  
  public Solution(int k) {
    // Complete the constructor if necessary.
    
    this.k = k;
    this.count = 0;
    sample = new ArrayList<Integer>();
  }
  
  public void read(int value) {
    // 随机一个位置（random < k）改成value
    count++;
    if(count <= k){
      sample.add(value);
    }
    int random = (int) (Math.random() * count);
    if(random < k){
      sample.set(random, value);
    }
  }
  
  public List<Integer> sample() {
    // Write your implementation here.
    return sample;
  }
}
