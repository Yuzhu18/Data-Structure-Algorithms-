/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode merge(List<ListNode> listOfLists) {
    // 全放进 minheap, 再一个一个拿出来
    // time : O(logk *nk) space: O(k)
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new myComparator());
    // build minHeap
    for(ListNode node : listOfLists){
      if(node != null){
        minHeap.offer(node);
      }
    }
    // get min from heap
    while(!minHeap.isEmpty()){
      ListNode tmp = minHeap.poll();
      cur.next = tmp;
      cur = cur.next;
      if(tmp.next != null){   ///////是一串链表，每个点又是一串链表
        minHeap.offer(tmp.next);
      }
    }
   return dummy.next;
  }
  class myComparator implements Comparator<ListNode>{
    public int compare(ListNode o1, ListNode o2){
      if(o1.value == o2.value){
        return 0;
      }
      return o1.value < o2.value ? -1 : 1;
    }
  }
}
