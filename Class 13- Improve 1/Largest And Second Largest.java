public class Solution {
  public int[] largestAndSecond(int[] array) {
   //第二大的数，唯一一次被比下去的是和最大值比较
   // 因此只要记下最大值的比较历史，比较历史里最大的就是2rd 大的数
    Element[] helper = covert(array);
    int length = array.length;
    while(length > 1){
      compareAndSwap(helper, length);
      length = (length + 1) / 2;
    }
    return new int[]{helper[0].value, largest(helper[0].compared)};
  }
  
  private void compareAndSwap(Element[]helper, int length){
    for(int i = 0; i < length / 2; i++){
      if(helper[i].value < helper[length - 1 - i].value){
        swap(helper, i, length - 1 - i);
      }
      helper[i].compared.add(helper[length - 1 - i].value);
    }
  }
  
  private Element[] covert(int[] array){
    Element[] rst = new Element[array.length];
    for(int i = 0; i < array.length; i++){
      rst[i] = new Element(array[i]);
    }
    return rst;
  }
  private void swap(Element[] helper, int left, int right){
    Element temp = helper[left];
    helper[left] = helper[right];
    helper[right] = temp;
  }
  
  private int largest(List<Integer> compared){
      int max = compared.get(0);
       for (int num : compared) {
          max = Math.max(max, num);
       }
      return max;
  }
}

class Element{
   int value;
   List<Integer> compared;
   Element(int value){
     this.value = value;
     this.compared = new ArrayList<Integer>();
   }
}
