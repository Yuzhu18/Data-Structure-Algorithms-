public class Solution {

  private Deque<Integer> stack1;
  private Deque<Integer> stack2;
  
  public Solution() {
    // 用两个stack实现queue
    // 注意在stack2空了的时候及时将stack1的内容补上
   stack1 = new LinkedList<>();
   stack2 = new LinkedList<>();
  }
  
  public Integer poll() {
    move();
    if(!stack2.isEmpty()){
      int temp = stack2.removeFirst();
      return temp;
    }
    return null;
  }
  
  public void offer(int element) {
    stack1.addFirst(element);
  }
  
  public Integer peek() {
    move();
    if(!stack2.isEmpty()){
      int temp = stack2.peekFirst();
      return temp;
    }
    return null;
  }
  
  public int size() {
    return stack1.size() + stack2.size();
  }
  
  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
  
  private void move(){
    if(stack2.isEmpty() && !stack1.isEmpty()){
      while(!stack1.isEmpty()){
        Integer tmp = stack1.removeFirst();
        stack2.addFirst(tmp);
      }
    }
  }
}
