public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    // 利用hashmap遍历一遍
    List<Integer> rst = new ArrayList<>();
    if(lo.length() == 0 || lo.length() < sh.length()){
      return rst;
    }
    char[] s = sh.toCharArray();
    Map<Character, Integer> hashmap = buildMap(s);
    int matchNum = hashmap.size();
    
    for(int i = 0; i < lo.length(); i++){
      char temp = lo.charAt(i);
      Integer count = hashmap.get(temp);
      // handle new added item (rightmost)，右边滑进窗口
      if(count != null){
         hashmap.put(temp, count - 1);
         if(count == 1){
           matchNum--;
         }
      }
      // handle the leftmost item, 左边滑出窗口
      if(i >= sh.length()){
        temp = lo.charAt(i - sh.length());
        count = hashmap.get(temp);  ////要用Integer，后面判null
        if(count != null){
          hashmap.put(temp, count + 1);
          if(count == 0){
            matchNum++;
          }
        }
      }
      
      if(matchNum == 0){
        rst.add(i - sh.length() + 1);
      }
    }
    return rst;
  }
  
  private HashMap<Character, Integer> buildMap(char[] array){
    HashMap<Character, Integer> rst = new HashMap<>();
    for(int i = 0; i < array.length; i++ ){
      char temp = array[i];
      Integer count = rst.get(temp);
      if(count != null){
        rst.put(temp, count + 1);
      }else{
        rst.put(temp, 1);
      }
    }
    return rst;
  }
}


