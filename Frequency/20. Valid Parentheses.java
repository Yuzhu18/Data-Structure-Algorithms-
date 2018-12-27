//利用stack 特性， 回头看
// time: loop once O(n)
// space: stack O(n)

class Solution {
   public boolean isValid(String input) {
    if (input == null || input.length() == 0) {
      return true;
    }
    
    Deque<Character> stack = new ArrayDeque<>();
    
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      
      if (ch == '(') {
        stack.push(')');
      }
      else if (ch == '[') {
        stack.push(']');
      }
      else if (ch == '{') {
        stack.push('}');
      }
      else {
        if (stack.isEmpty() || stack.pop() != ch) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
