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
  public ListNode insert(ListNode head, int value) {
    /// 考虑首尾的 Corner case
    ListNode newNode = new ListNode(value);
    if(head == null || head.value >= value){ 
      newNode.next = head;
      return newNode;
    }
    ListNode curr = head;
    while(curr.next != null && curr.next.value < value){
      curr = curr.next;
    }
    newNode.next = curr.next;
    curr.next = newNode;
    return head;
  }
}
