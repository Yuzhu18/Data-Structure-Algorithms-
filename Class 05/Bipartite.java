/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
 
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    Map<GraphNode, Integer> hashmap = new HashMap<>();
    
    for (GraphNode node : graph) {
      if (!BFS(node, hashmap)) {
        return false;
      }
    }
    
    return true;
  }
  
  private boolean BFS(GraphNode node, Map<GraphNode, Integer> hashmap) {
    if (hashmap.containsKey(node)) {
      return true;
    }
    
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    hashmap.put(node, 0);
    
    while (!queue.isEmpty()) {
      GraphNode curr = queue.poll();
      int currColor = hashmap.get(curr);
      int neiColor = currColor == 0 ? 1 : 0;
      
      for (GraphNode neighbor : curr.neighbors) {
        if (!hashmap.containsKey(neighbor)) {
          hashmap.put(neighbor, neiColor);
          queue.offer(neighbor);
        }
        else if (hashmap.get(neighbor) != neiColor) {
          return false;
        }
      }
    }
    
    return true;
  }
}






