public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    // K个XX，一般两种思路
    // 1.k 个一起处理
    // 2.每两个一起处理
    //k-way merge 有三种方法
    // 1. iterative : n + 2n + 3n...+kn (就是每次加进一个way然后一起遍历)/ O(k^2 *n)
    // 2. Binary reduction: 两个一起处理 O(logk *kn) space: O(kn)
    // 3. k个一起处理（heap）: O(logk * kn) space: O(k) 难点是定义Element
    PriorityQueue<Element> minHeap= new PriorityQueue<>(11,  new myComparator());
    //build min heap
    int length = 0;
    for(int i = 0; i < arrayOfArrays.length; i++){
      int len = arrayOfArrays[i].length;
      length += len;
      if(len > 0){   ////////
        int first = arrayOfArrays[i][0];
        minHeap.offer(new Element(i, 0, first));
      }
    }
    int[] rst = new int[length];
    int index = 0;
    while(!minHeap.isEmpty()){
      Element cur = minHeap.poll();
      rst[index++] = cur.value;
      if(cur.indexInArray + 1 < arrayOfArrays[cur.indexOfArray].length){
        cur.indexInArray++;
        int val = arrayOfArrays[cur.indexOfArray][cur.indexInArray];
        minHeap.offer(new Element(cur.indexOfArray,cur.indexInArray, val ));
      }
    }
    return rst;
  }
  
  public class myComparator implements Comparator<Element>{
  public int compare(Element o1, Element o2){
    if(o1.value == o2.value){
      return 0;
    }
    return o1.value < o2.value ? -1 : 1;
  }
}
  
  class Element{
  int indexOfArray;
  int indexInArray;
  int value;
  Element(int row, int col, int value){
    indexOfArray = row;
    indexInArray = col;
    this.value = value;
  }
}
}
 
