class Solution {
    // 利用stack ，实现先计算乘除
    // time : O(n)
    // space: O(n)
    public int calculate(String s) {
        // corner case
        if(s == null || s.length() == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                num = 10 * num + s.charAt(i) - '0';
            }
            
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1)){
                if(sign == '-'){
                    stack.push(-num);
                }
                else if(sign == '+'){
                    stack.push(num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int rst = 0;
        for(int e : stack){
            rst += e;
        }
        return rst;
    }
}



