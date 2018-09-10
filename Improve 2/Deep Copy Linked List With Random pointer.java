/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // 难点：避免重复copy同一个点
    if(head == null){
      return null;
    }
    RandomListNode newHead = new RandomListNode(head.value);
    RandomListNode curr = newHead;
    HashMap<RandomListNode, RandomListNode> exist = new HashMap<>();
    exist.put(head, newHead);
    while(head != null){
      if(head.next != null){
        if(!exist.containsKey(head.next)){ ////必须用if,即使不在hashmap里也要建立连接
          exist.put(head.next, new RandomListNode(head.next.value));
        }
        curr.next = exist.get(head.next);
      }
      if(head.random != null ){
        if(!exist.containsKey(head.random)){
          exist.put(head.random, new RandomListNode(head.random.value));
        }
        curr.random = exist.get(head.random);
      }
      curr = curr.next;
      head = head.next;
    }
    return newHead;
  }
}

