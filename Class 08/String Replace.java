public class Solution {
  public String replace(String input, String source, String target) {
    // 分两种情况，source > target ; source < target
    
    char[] arrayIn = input.toCharArray();
    if(source.length() > target.length()){
      return replaceShorter(arrayIn, source, target);
    }else{
      return replaceLonger(arrayIn, source, target);
    }
  }
  
  //被替换部分短，可以直接in-place操作
  // two pointers 遍历一遍
  private String replaceShorter(char[] array, String source, String target){
    int slow = 0;
    int fast = 0;
    while(fast < array.length){
      if(fast <= array.length - source.length() && equals(array, source, fast)){
        copy(array, target, slow);
        fast = fast + source.length();
        slow = slow + target.length();
      }else{
        array[slow++] = array[fast++];
      }
    }
    return new String(array, 0, slow);
  }
  
  
  private String replaceLonger(char[] array, String source, String target){
    ArrayList<Integer> matches = getAllMatches(array, source);
    int newSize = array.length + (target.length() - source.length()) * matches.size();
    char[] result = new char[newSize];
    int slow = result.length - 1;
    int fast = array.length - 1;
    int lastMatch = matches.size() - 1;
    while(fast >= 0){
      if(lastMatch >= 0 && fast == matches.get(lastMatch)){
        copy(result, target, slow - target.length() + 1);
        fast = fast - source.length();
        slow = slow - target.length();
        lastMatch--;
      }else{
        result[slow--] = array[fast--];  ////
      }
    }
    return new String(result);
  }
  
  private boolean equals(char[] array, String source, int index){
    char[] s = source.toCharArray();
    for(int i = 0; i < s.length; i++){
      if(array[index] != s[i]){
        return false;
      }else{
        index++;
      }
    }
    return true;
  }
  
  private void copy(char[] array, String target, int index){
    char[] t = target.toCharArray();
    for(int i = 0; i < t.length; i++ ){
      array[index] = t[i];
      index++;
    }
  }
  
  private ArrayList<Integer> getAllMatches(char[] array, String source){
    char[] s = source.toCharArray();
    ArrayList<Integer> rst = new ArrayList<>();
    int i = 0;
    while(i <= array.length - source.length()){
      if(equals(array, source, i)){
        rst.add(i + s.length - 1);
        i = i + source.length();   /////
      }else{
        i++;
      }
    }
    return rst;
  }
}

