/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 1.use HashSet time: O(n) ; space: O(n)


// 2.two pointers / fast pointer two steps every time
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null ){
            return false;
        }
        
        ListNode cur = head;
        ListNode slow = head;
        
        while(cur != null && cur.next != null){
            slow = slow.next;
            cur = cur.next.next;
            if(slow == cur){
                return true;
            }
        }
        return false;
    }
}
