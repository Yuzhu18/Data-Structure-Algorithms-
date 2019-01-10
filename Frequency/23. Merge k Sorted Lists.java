/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 利用 PriorityQueue -- minHeap
        // 重写一下heap 的comparator
        // time: O()
        // space: O(logn)
        
        if(lists == null || lists.length == 0){
            return null;
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                if(o1.val == o2.val){
                   return 0; 
                }else if(o1.val < o2.val){
                    return -1;
                }else{
                    return 1;
                }
            }
        }); 
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // store the inital nodes into the heap
        for(ListNode node : lists){
            if(node != null){
                heap.offer(node);
            }  
        }
        
        while(!heap.isEmpty()){
            ListNode top = heap.poll();
            cur.next = top;
            cur = cur.next;
            if(cur.next != null){
                heap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
