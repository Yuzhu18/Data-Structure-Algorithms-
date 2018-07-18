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
  public ListNode partition(ListNode head, int target) {
    // 遍历一遍 <T + >=T
    //运用 dummy node
    if(head == null || head.next == null){
      return head;
    }
    ListNode curr = head;
    ListNode dummy1 = new ListNode(0);
    ListNode one = dummy1;
    ListNode dummy2 = new ListNode(0);
    ListNode two = dummy2;
    while(curr != null ){
      if(curr.value < target){
        one.next = new ListNode(curr.value);
        one = one.next;
      }else{
        two.next = new ListNode(curr.value);
        two = two.next;
      }
      curr = curr.next;
    }
    one.next = dummy2.next;
    return dummy1.next;
  }
}
