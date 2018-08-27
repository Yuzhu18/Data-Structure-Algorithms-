//public class Solution {
//    public boolean match(String input, String pattern) {
//        // 用recursion方法：类似于遍历一遍，每次向后移相应的位数
//        // O(n)
//        return helper(input, pattern, 0, 0);
//    }
//
//    private boolean helper(String input, String pattern, int in, int p){
//        // bsae case
//        if(in == input.length() && p == pattern.length()){
//            return true;
//        }else if(in >= input.length() || p >= pattern.length()){ ///必须是>=, 而不是==
//            return false;
//        }
//        // recursive rule
//        // case 1 : when current character is letter 
//        if(pattern.charAt(p) < '0' || pattern.charAt(p) > '9'){
//            if(pattern.charAt(p) == input.charAt(in)){
//                return helper(input, pattern, in + 1, p + 1);
//            }
//            return false;
//        }else{
//            // case 2 : when current character is digits, we need to count all digits
//            int count = 0;
//            while(p < pattern.length() && pattern.charAt(p) <= '9' && pattern.charAt(p) >= '0'){
//                count = count * 10 + (pattern.charAt(p) - '0');
//                p++;
//            }
//            return helper(input, pattern, in + count, p);
//        }
//    }
//}
