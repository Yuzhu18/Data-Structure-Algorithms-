public class Solution {
  public int longest(String input) {
  
    // two pointers 遍历一遍, 只返回长度
    if(input.length() == 0){
      return 0;
    }
    int max = 0;
    char[] arrayIn = input.toCharArray();
    int slow = 0;
    int fast = 0;
    HashSet<Character> set = new HashSet<>();
    while(fast < arrayIn.length){
      if(!set.contains(arrayIn[fast])){
        set.add(arrayIn[fast++]);  ///先++，再确定max
        max = Math.max(max, fast - slow); ////
      }else{
        set.remove(arrayIn[slow++]);
      }
    }
    return max;
  }
}


