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
  public ListNode middleNode(ListNode head) {
    // 一个指针走两步，一个指针走一步
    // while 条件
    ListNode slow = head;
    ListNode quick = head;
    if(head == null || head.next == null){
      return head;
    }
    while(quick.next != null && quick.next.next != null){
      slow = slow.next;
      quick = quick.next.next;
    }
    return slow;
  }
}

