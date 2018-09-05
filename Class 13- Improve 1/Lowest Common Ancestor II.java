/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // follow up: 有parent指针 / 不保证两个node都在tree里面
    // way1: 1. store all a's ancestor in a hashset
    //       2. trace up from b, and then we find the current node is already 
    //       is already in the hashset, then return the current node.
    //    time:O(height)    ;    space: O(height)
    
    // way2: 1.Trace from a and b to the root to find their height from root 
    //       respectively.
    //       2. move the deeper node to the abs|height(a) - height(b)|, so that 
    //       a and b are on the same level.
    //       3. move a and b up at same time, one level by level, until (a == b)
    if(one == null || two == null){
      return null;
    }
    int l1 = getHeight(one);
    int l2 = getHeight(two);
    if(l1 <= l2){
      return mergeTree(one, two, l2 - l1);
    }else{
      return mergeTree(two, one, l1 - l2);
    }
  }
  private int getHeight(TreeNodeP node){
    int height = 0;
    while(node.parent != null){
      height++;
      node = node.parent;
    }
    return height;
  }
  
  private TreeNodeP mergeTree(TreeNodeP shorter, TreeNodeP longer, int diff){
    while(diff > 0){
      longer = longer.parent;
      diff--;
    }
    while(shorter != longer){
      shorter = shorter.parent;
      longer = longer.parent;
    }
    return longer;
  }
}

