package 贪心算法;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Kruskal {
    public static void main(String[] args) {
        double graph[][] = {
                {-0, 6, 0, 0, 0, 1, 0 },
                {6, -0, 4, 0, 0, 0, 3 },
                {0, 4, -0, 2, 0, 0, 0 },
                {0, 0, 2, -0, 6, 0, 5 },
                {0, 0, 0, 6, -0, 8, 7 },
                {1, 0, 0, 0, 8, -0, 0 },
                {0, 3, 0, 5, 7, 0, -0 }
        };
        double tree[][] = minimumSpanningTree(graph);
        if (tree == null) {
            System.out.println("no spanning tree");
            System.exit(0);
        }
        PriorityQueue<Edge> edgeList = generateEdgeList(tree);
        for (Edge e : edgeList) {
            System.out.println(e);
        }
    }

    public static double[][] minimumSpanningTree(double[][] graph) {
        int rlength = graph.length;
        int clength = graph[0].length;
        PriorityQueue<Edge> edgeList;
        edgeList = generateEdgeList(graph);
        double tree[][] = new double[rlength][clength];
        /**
         * 初始化tree
         */
        for (int i = 0; i < rlength; i++) {
            for (int j = 0; j < clength; j++) {
                if (i == j)
                    tree[i][j] = 0;
                else
                    tree[i][j] = Double.MAX_VALUE;
            }
        }
        /**
         * map用于标识边的某个顶点属于哪个集合，认为顶点刚开始属于不同的集合，当选择一条边时，就合并两个集合，如果选择的边在同一个集合内，就代表有环路出现了
         */
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int edgeCount = 0;
        while (edgeCount < rlength - 1 && !edgeList.isEmpty()) {
            Edge e = edgeList.poll();


            Set<Integer> setU = map.get(e.u);
            Set<Integer> setV = map.get(e.v);
            //System.out.println(e);
            //边的两个顶点都未出现在其他集合中
            if (setU == null && setV == null) {
                Set<Integer> set = new HashSet<Integer>();
                set.add(e.u);
                set.add(e.v);
                map.put(e.u, set);
                map.put(e.v, set);
            }//有一个顶点在其他集合中，一个不在，将不在的那个顶点集合合并进去
            else if (setU == null && setV != null) {
                map.put(e.u, setV);
                setV.add(e.u);
            } else if (setU != null && setV == null) {
                map.put(e.v, setU);
                setU.add(e.v);
            }//分别在不同的集合中，合并两个集合
            else if (setU != setV) {
                for (int v : setV) {
                    map.put(v, setU);
                }
                setU.addAll(setV);
            }//两个顶点在同一个结合中，会出现环路，舍弃
            else {
                continue;
            }
            tree[e.u][e.v] = e.weight;
            tree[e.v][e.u] = e.weight;
            edgeCount++;
        }

        if (edgeCount == rlength - 1)
            return tree;
        else
            return null;
    }

    /**
     * 生成边的排序好的队列
     */
    private static PriorityQueue<Edge> generateEdgeList(double[][] graph) {
        PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>();
        int rlength = graph.length;
        int clength = graph[0].length;
        for (int i = 0; i < rlength; i++) {
            for (int j = i + 1; j < clength; j++) {
                if (graph[i][j] > 0 & graph[i][j] < Double.MAX_VALUE) {
                    Edge e = new Edge(i, j, graph[i][j]);
                    edgeList.add(e);
                }
            }
        }
        return edgeList;
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    double weight;

    public Edge(int u, int v, double weight) {
        super();
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        if (e.weight == weight)
            return 0;
        else if (weight < e.weight)
            return -1;
        else
            return 1;

    }

    public String toString() {
        return u + "---->" + v + " 距离为：" + weight;
    }

}
