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
  public boolean hasCycle(ListNode head) {
    // 快慢双指针
    if(head == null){
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        return true;
      }
    }
    return false;
  }
}
