/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // 利用BFS1 / DFS进行遍历
    HashMap<GraphNode,GraphNode> map = new HashMap<>();
    for(GraphNode node : graph){
      if(!map.containsKey(node)){
        map.put(node, new GraphNode(node.key));
        DFS(node, map);
      }
    }
    return new ArrayList<GraphNode>(map.values());
  }
  private void DFS(GraphNode node, HashMap<GraphNode, GraphNode> map){
    GraphNode copy = map.get(node);
    for(GraphNode nei: node.neighbors){
      if(!map.containsKey(nei)){
        map.put(nei, new GraphNode(nei.key));
        DFS(nei, map);
      }
      copy.neighbors.add(map.get(nei));
    }
  }
}


