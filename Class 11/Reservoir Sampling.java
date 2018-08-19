public class Solution {
  // 此题是steam input， 维持一个sample
  private int count;
  private Integer sample;
  public Solution() {
    count = 0;
    sample = null;
  }
  
  public void read(int value) {
    // 保证每次读进来的sample 概率是 1 / count
    count++;
    int prob = (int) (Math.random() * count);
    if(prob == 0){
      sample = value;
    }
  }
  
  public Integer sample() {
    // read sample
    return sample;
  }
}
