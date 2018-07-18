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
  
  public ListNode merge(ListNode one, ListNode two) {
    // 谁小移谁

    ListNode dummy = new ListNode(0);
    ListNode iter = dummy;
    
    while(one != null && two != null){

      if(one.value >= two.value){
        iter.next = new ListNode(two.value);
        two = two.next;
      }else{
        iter.next = new ListNode(one.value);
        one = one.next;
      }
      iter = iter.next;
    }
    if(one != null){
      iter.next = one;
    }else{
      iter.next = two;
    }
    return dummy.next;
  }
}
