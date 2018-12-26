class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        ListNode c1= l1;
        ListNode c2 = l2;
        int sum = 0;
        while(c1 != null || c2 != null){
            
             sum /= 10;
            
             if(c1 != null){
                 sum += c1.val;
                 c1 = c1.next;
             }
            
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            start.next = new ListNode(sum % 10);
            start = start.next;
        }
        // 最后有进位的情况
        if(sum / 10 == 1){
            start.next = new ListNode(1);
        }
        return dummy.next;
    }
}
