/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //先算出长度差，然后长的那个先走长出的部分， 保证对齐开始
    // 长度相等开始走，当第一个node1 == node2, 返回结果
    //1, Get the length of the two lists.
    // 2, Align them to the same start point.
    // 3, Move them together until finding the intersection point, or the end null
    // time: O(n)
    // space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        
        while(headA !=  headB) {
        
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    private int getLen(ListNode node){
        int len = 0;
        if(node == null){
            return len;
        }
        
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}



