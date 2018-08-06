public class Solution {
  public List<String> permutations(String set) {
    List<String> rst = new ArrayList<>();
    if(set == null){
      return rst;
    }
    if(set.length() == 0){
      rst.add(set);
      return rst;
    }
    char[] arraySet = set.toCharArray();
    helper(arraySet, rst, 0);
    return rst;
  }
  
  private void helper(char[] array, List<String> rst, int index){
    //base case
    if(index == array.length){
      rst.add(new String(array));
    }
    Set<Character> unique = new HashSet<>();
    for(int i = index; i < array.length; i++){
      if(!unique.contains(array[i])){
        unique.add(array[i]);
        swap(array, index, i);
        helper(array, rst, index + 1);
        swap(array, index, i);
      }
    }
  }
  
  private void swap(char[] array, int left, int right){
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
