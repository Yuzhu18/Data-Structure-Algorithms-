/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // O (n)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode last = dummy;
        while(curr != null){
            if (curr.val == val) {
                last.next = curr.next;
            }else{
                last = last.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
