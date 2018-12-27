/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 
 // time: loop once O(n)
 // space: map O(n)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null ){
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode cur = head;
        RandomListNode newCur = newHead;
        
        map.put(cur, newCur);
    
        while(cur != null){
            if(cur.next != null){
                
                if( !map.containsKey(cur.next)){
                    newCur.next = new RandomListNode(cur.next.label);
                    map.put(cur.next, newCur.next);
                }else{
                    newCur.next = map.get(cur.next);
                }
            }
            
            if(cur.random != null){
                if(!map.containsKey(cur.random)){
                    newCur.random = new RandomListNode(cur.random.label);
                    map.put(cur.random, newCur.random);
                }else{
                    newCur.random = map.get(cur.random);
                }
            }
            newCur = newCur.next;
            cur = cur.next;
        }
        return newHead;
    }
}
