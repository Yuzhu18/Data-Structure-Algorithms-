 // two pointers
 // time : O(n)  traverse onece
 // space: O(n)   char array + set 


class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        if(s.length() == 0){
            return 0;
        }
       
        Set<Character> words = new HashSet<Character>();
        int slow = 0;
        int slowMax = 0;//////
        int max = 0;
        int fast = 0;
        char[] arrayIn = s.toCharArray();
        while( fast < s.length()){
            if(!words.contains(arrayIn[fast])){
                words.add(arrayIn[fast]);
                fast++;
                if((fast - slow) > max){
                    slowMax = slow;
                    max = fast - slow;
                }
            }else{
                words.remove(arrayIn[slow]);
                slow++; 
            }
        }
        // return s.subtring(slowMax, slowMax + max);
        return max;
    }
}
