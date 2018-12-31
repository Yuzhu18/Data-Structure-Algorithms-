public class Solution {
    // 中间有多个空格，且head tail的空格需要去掉
    public String reverseWords(String s) {
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
}
    
    
    
    
    
//     // in-place 三步翻转法
//     // time: O(n)
//     // 中间空格只有一个
//     public String reverseWords(String s) {
//         if(s == null || s.length() == 0){
//             return s;
//         }
//         if(s.equals(" ") ){
//            return ""; 
//         }
//         char[] array = s.toCharArray();
//         // reverse the whole string
//         reverse(array, 0, array.length - 1);
//         //reverse each words
//          int start = 0;
//         for(int i = 0; i < array.length; i++){
           
//             if(array[i] != ' '  && (i == 0 || array[i - 1] == ' ') ){
//                 start = i;
//             }
//             if(array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ') ){
//                 reverse(array, start, i);
//             }
//         }
        
//         return new String(array);
//     }
    
//     private void reverse(char[] array, int left, int right){
//         while(left < right){
//             char tmp = array[left];
//             array[left] = array[right];
//             array[right] = tmp;
//             left++;
//             right--;
//         }
//     }
}
