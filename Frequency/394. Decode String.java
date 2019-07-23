class Solution {
    //用两个stack 分别存 res 和 count 、 类似 calculator
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int cout = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    cout = cout * 10 + ( s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(cout);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int times = countStack.pop();
                for (int i = 0; i < times; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;                
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}
