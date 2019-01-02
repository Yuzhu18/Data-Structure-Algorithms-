/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // two pointers slow ,fast 之间保持 n 个距离
    // 找到倒数 nth + 1， 这样就能删除倒数 nth
    // 当fast == null 时， slow = 倒数 nth + 1
    
    // time: O(n)
    // space: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
 
        //Move fast in front so that the gap between slow and fast becomes n
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = slow;
        slow.next = head;
        
        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //delete the nth node
        slow.next = slow.next.next;
        return dummy.next;
    }
}


