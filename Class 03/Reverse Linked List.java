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
 
 // 1. iterative way 
 //    prev设置成 null  
public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null){
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
        }
        return prev;
        }
  
     // 2. recursion way
     // 从后向前改变状态
     // 每个状态必须将cur.next 指针置null,要不下一个状态的参数影响
   public ListNode reverse(ListNode head) {
     
     if(head == null || head.next == null){
       return head;
     }
     ListNode curr = head;
     ListNode next = head.next;
     ListNode newHead = reverse(next);
     next.next = curr;
     curr.next = null;
     return newHead;
   }
  
}

