public class Solution {
  
  private Deque<Integer> stack;
  private Deque<Integer> stackMin;

  public Solution() {
    // 实时更新最小值
    stack = new LinkedList<>();
    stackMin = new LinkedList<>();

  }
  
  public int pop() {
    if(!stack.isEmpty()){
      int temp = stack.removeFirst();
      stackMin.removeFirst();
 
      return temp;
    }
    return -1;
  }
  
  public void push(int element) {
    
      stack.addFirst(element);
      
    
      if(stackMin.isEmpty() || element <= stackMin.peekFirst()){
        stackMin.addFirst(element);
      }else{
        int tmp = stackMin.peekFirst();
        stackMin.addFirst(tmp);
    }
  }
  
  public int top() {
    if(!stack.isEmpty()){
      return stack.peekFirst();
    }
    return -1;
  }
  
  public int min() {
    if(!stack.isEmpty()){
      return stackMin.peekFirst();
    }
    return -1;
  }
}

