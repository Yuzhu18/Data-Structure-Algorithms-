public class Solution {
    // 利用两个heap: max_heap + min_heap
    // size: max_heap = min_heap (+ 1)
    private PriorityQueue<Integer> leftMax;
    private PriorityQueue<Integer> rightMin;
  public Solution() {
    rightMin = new PriorityQueue<Integer>();
    leftMax = new PriorityQueue<Integer>(Collections.reverseOrder());
  }
  
  public void read(int value) {
    // 读进数据
    if(leftMax.isEmpty() || value <= leftMax.peek()){
      leftMax.offer(value);
    }else{
      rightMin.offer(value);
    }
    // resize two heap
    if(leftMax.size() - rightMin.size() >= 2){
      rightMin.offer(leftMax.poll());
    }else if(rightMin.size() > leftMax.size()){
      leftMax.offer(rightMin.poll());
    }
  }
  
  public Double median() {
    // 返回中位数
    int size = leftMax.size() + rightMin.size();
    if(size == 0){
      return null;
    }else if(size % 2 != 0){
      return (double)leftMax.peek(); ////注意double类型转换
    }else{
      return (leftMax.peek() + rightMin.peek()) / 2.0;  ////注意double类型转换
    }
  }
}
