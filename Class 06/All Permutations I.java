public class Solution {
  public List<String> permutations(String set) {
    // 找所有的排列
    char[] arraySet = set.toCharArray();
    List<String> rst = new ArrayList<>();
    if(set == null){
      return rst;
    }
    helper(arraySet, rst, 0);
    return rst;
  }
  private void helper(char[] array, List<String> rst, int index){
    //base case
    if(index == array.length){
      rst.add(new String(array));
      return;
    }
    for(int i = index; i < array.length; i++){
      swap(array, i, index);
      helper(array, rst, index + 1);
      swap(array, i, index);
    }
  }
  
  private void swap(char[] array, int i, int j){
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}


