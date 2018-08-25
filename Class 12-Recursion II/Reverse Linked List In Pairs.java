public class Solution {
    public ListNode reverseInPairs(ListNode cur) {
        // 想好最后的状态是什么，结合虚线框
        //  1 -> 2 | -> 3 -> 4 -> 5
        // cur  next   head
        //  2 -> 1 | -> 4 -> 3 -> 5
        // next cur  newHead
        // 确定好newHead 传进来的是什么,此处 newHead = 4

        //base case 
        if(cur == null || cur.next == null){
            return cur;
        }
        ListNode next = cur.next; //先存储next 2
        ListNode newHead = reverseInPairs(cur.next.next);// newHead(4) 是有3点产生的
        cur.next = newHead; // 1 -> 4
        next.next = cur; // 2 -> 1
        return next; // 新的链表头
    }
}
