import java.util.*;

//背景是一个滑雪选手从高山上往下滑，会遇到不同的checkpoint，每一个checkpoint有自己的point，然后每个edge有distance。
// 经过每一个checkpoint所得到的score是通过一个包含point和distance的式子算出来的（比如2 * point +distance之类的）。
// 最终求从最高点往下滑能得到的最大score是多少，用BFS就可以。

//有向图 拓扑排序 每个点只会遍历一遍
//如果有多个起点：
// 1。degree map 会找到多个起点，同时degree map也去重
// 2。buildGraph() 需要将这些起点的初始Score都变成0

//Time O（V + E） --O(nodes:n + edges: m)
//Space: O(n)
public class Main {

    public static void main(String[] args) {
        String[] nodes = {"A,5", "B,7", "C,6", "D,2", "E,4", "F,7", "H,7", "I,3", "J,2"} ;
        String[] edges = {
                "A->B,2",
                "A->C,3",
                "B->D,5",
                "B->E,6",
                "C->E,4",
                "C->F,4",
                "D->H,7",
                "E->H,6",
                "H->I,1",
                "H->J,2",
                "F->J,3"
        } ;

        List<String> path = new ArrayList<>() ;
        int rst = findMaxPath(nodes, edges, "A", path) ;
        System.out.println(rst);
        System.out.println(path);
    }

    static class Node {
        String name ;
        int point ;
        Map<String, Integer> nexts;
        int score ;
        Node(String name, int point) {
            this.name = name ;
            this.point = point ;
            this.nexts = new HashMap<>();
            this.score = Integer.MIN_VALUE;
        }
    }

    private static int findMaxPath(String[] nodes, String[] edges, String src, List<String> path) {
        // build the directed graph
        Map<String, Node> graph = new HashMap<>();
        Map<String, Integer> degree = new HashMap<>();

        buildGraph(nodes, edges, graph, degree, src);

        // topological order
        // pathEdge 用于储存最大Score 所走过的边
        Map<String, String> pathEdge = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        //followup ： 如果有多个起点的时候，找degree == 0 加进去
        //否则直接在queue里加进src就可以了 "q.offer(graph.get(src));"  ！！！！！！！！！！！！！
        for ( String name: degree.keySet() ) {
            if ( degree.get(name) == 0 ) q.offer(graph.get(name));
        }
        /////////////////////////


        String largestLeafName = "";
        int maxScore = Integer.MIN_VALUE;
        while ( ! q.isEmpty() ) {
            Node curNode = q.poll() ;

            // 到达叶节点时更新最大的Score 和 此时的叶子结点名字
            if ( curNode.nexts.isEmpty() && maxScore < curNode.score ) {
                maxScore = curNode.score;
                largestLeafName = curNode.name;
            }

            //处理所有非叶节点
            for ( String next: curNode.nexts.keySet() ) {
                /////感觉没必要check这个？？？？？？？？？？？？？？？？///////////////
//                if ( curNode.score != Integer.MIN_VALUE ) {
                    int score = getScore(curNode.point, curNode.nexts.get(next));
                    // 只有当这条边走到这个点Score变大的时候，才会存储这一条边到path（pathEdge map）里
                    if ( curNode.score + score > graph.get(next).score ) {
                        graph.get(next).score = curNode.score + score;
                        pathEdge.put(next, curNode.name);
                    }
//                }//////////////////////////////////////
                // 拓扑排序 去重
                degree.put(next, degree.get(next) - 1);
                if ( degree.get(next) == 0 ) {
                    q.offer(graph.get(next));
                }
            }
        }
        
        // Build path：反向构造path
        getPath(pathEdge, largestLeafName, path);
        return maxScore;
    }

    private static void buildGraph(String[] nodes, String[] edges, Map<String, Node> graph, Map<String, Integer> degree, String src){

        for ( String s: nodes ) {
            String[] node = s.split(",");
            String name = node[0];
            int point = Integer.parseInt(node[1]);
            if ( !graph.containsKey(name) ) {
                graph.put(name,  new Node(name, point));
            }

            degree.put(name, 0);
            // Set src score to 0
            // 如果有多个起点，需要将这些起点的Score都变成0
            if ( name.equals(src) ) {
                graph.get(name).score = 0;
            }
        }

        for ( String s: edges ) {
            String[] tmp = s.split(",");
            String[] fromTo = tmp[0].split("->");
            String from = fromTo[0];
            String  to = fromTo[1];
            int dist = Integer.parseInt(tmp[1]);
            if ( !graph.get(from).nexts.containsKey(to) ) {
                degree.put(to, degree.getOrDefault(to, 0) + 1);
            }
            graph.get(from).nexts.put(to, dist);
        }
    }

    // Score the 计算方式（可变）
    private static int getScore(int point, int dist) {
        return 2 * point + dist;
    }

    // Build path：反向构造path
    private static void getPath(Map<String, String> links, String leafName, List<String> path){
        while ( !leafName.isEmpty() ) {
            path.add(leafName);
            leafName = links.containsKey(leafName) ? links.get(leafName) : "" ;
        }
        Collections.reverse(path);
    }
}
