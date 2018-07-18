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
 
    // 1.find the middle node
    // 2.reverse half
    // 3. merge two sorted linkedlist
    
public class Solution {
  public ListNode reorder(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
   
    // find middle 
    ListNode mid = findMiddle(head);
    ListNode half1 = head;
    ListNode half2 = mid.next;
    mid.next = null;
    
   //reverse
    ListNode newHalf2 = reverse(half2);
    
    //merge
    ListNode dummy = new ListNode(0);
    ListNode iter = dummy;
    while(half1 != null && newHalf2 != null){  /// 条件控制
      iter.next = half1; ///注意先输出前一半 1,7,2,6...
      half1 = half1.next;
      iter.next.next = newHalf2;
      newHalf2 = newHalf2.next;
      iter = iter.next.next;
    }
    if(half1 != null){
      iter.next = half1;
    }else{
      iter.next = newHalf2;
    }
    return dummy.next;
  }
  
  private ListNode findMiddle(ListNode head){
      ListNode slow = head;
      ListNode fast = head;
     while(fast.next != null && fast.next.next != null){
       slow = slow.next;
       fast = fast.next.next;
     }
    return slow;
  }
  
  private ListNode reverse(ListNode head){
    if(head == null || head.next == null){   ///分成了一半，所以也要考虑
      return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null){    /// 条件控制
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
