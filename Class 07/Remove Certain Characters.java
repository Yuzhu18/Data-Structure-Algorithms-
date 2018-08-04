public class Solution {
  public String remove(String input, String t) {
    // two pointers
    // use set
    
    if(input.length() == 0 || t.length() == 0){
      return input;
    }
    char[] arrayIn = input.toCharArray();
    Set<Character> set = buildSet(t);
    int end = 0;
    for(int i = 0; i < arrayIn.length; i++){
      if(!set.contains(arrayIn[i])){
        arrayIn[end++] = arrayIn[i];
      }
    }
    return new String(arrayIn, 0, end);
  }
  private Set<Character> buildSet(String t){
    Set<Character> rst = new HashSet<>();
    char[] target = t.toCharArray();
    for(int j = 0; j < target.length; j++){
      rst.add(target[j]);
    }
    return rst;
  }
}
