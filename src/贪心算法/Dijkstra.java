package 贪心算法;
import java.util.Scanner;
/**
 * 迪杰斯特拉算法:
 * 思路：选取一个顶点作为起点，刚开始顶点集合中只有起始点（源点）一个，
 * 然后通过查找到源点距离最短的顶点，将这个顶点加入到顶点集合中，然后
 * 更新加入这个顶点之后源点到其他顶点的距离，一步步把所有的顶点都加入到
 * 顶点集合中，等到顶点全部加入到顶点集合中去，顶点集合的顺序便是从源点出发遍历所有顶点的最短路径。
 */
public class Dijkstra {
    public static int[] dijkstra(int n, int x,int[][] distance) {

        int[] prev = new int[n];
        //记录最短路径顺序的数组
        int[] path = new int[n];
        //最短路径元素的下标
        int pathIndex = 0;
        int prevIndex = 0;
        //先将源点放到最短路径顺序数组中
        path[pathIndex++] = x;
        //d数组存储的是其余的点到源点的距离
        int[] d = new int[n];
        //代表是否加入顶点集合中,false代表未加入，true代表已经加入了顶点集合中。
        boolean[] flag = new boolean[n];
        //刚开始顶点集合中只有源点
        flag[x - 1] = true;

        //初始化
        for (int i = 0; i < n; i++) {
            d[i] = distance[x - 1][i];
            if(d[i] == MAX_INT){
                prev[i] = 0;
            }else{
                prev[i] = x-1;
            }
        }
        //index为要新加入顶点集合的下标
        int index = x - 1;

        //循环n-1次，将剩下的n-1个顶点加入到顶点集合中
        for (int count = 0; count < n - 1; count++) {
            int temp = MAX_INT;
            //找出到源点最小距离的点
            for (int i = 0; i < n; i++) {
                //当这个顶点为未加入顶点集合并且距离小于临时值时
                if ((!flag[i]) && d[i] < temp) {
                    temp = d[i];
                    index = i;
                }
            }
            path[pathIndex] = index + 1;
            pathIndex++;
            //将顶点加入到顶点集合中去
            flag[index] = true;
            //添加节点之后，更新未加入顶点集合的顶点到源点的距离
            for (int i = 0; i < n; i++) {
                if (!flag[i] && distance[index][i] < MAX_INT) {
                    int change = d[index] + distance[index][i];
                    if (change < d[i]) {
                        d[i] = change;
                        prev[i] = index+1;
                    }
                }
            }
        }
        System.out.print("初始顶点的顺序为：");
        for (int i = 1; i <= n; i++) {
            if (i == n ) {
                System.out.print(i);
            } else {
                System.out.print((i) + "---->");
            }
        }
        System.out.print("\n");
        System.out.print("路径的前驱节点为：");
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(prev[i]);
            } else {
                System.out.print((prev[i]) + "---->");
            }
        }
        System.out.print("\n"+"*********************************************************"+"\n");
        System.out.print("求得的最短路径为：" );
        for (int i = 0; i < path.length; i++) {
            if (i == path.length - 1) {
                System.out.print(path[i]);
            } else {
                System.out.print((path[i]) + "---->");
            }
        }

        System.out.print("\n");
        System.out.print("得最短距离依次为：");
        for (int i = 0; i < n; i++) {
            System.out.print(d[i] + "     ");
        }
        System.out.print("\n");
        return path;
    }

    //定义一个常量，如果两个顶点之间没有通路，那么两点间的距离为MAX_INT;
    public final static int MAX_INT = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一共有几个顶点");
        int n = scanner.nextInt();
        System.out.println("源节点是:");
        int x = scanner.nextInt();
        //存储的是所有的节点之间的距离，distance[i][j]表示的是从顶点i到顶点j的距离，如果没有通路则为MAX_INT,distance[i][i]为0
        int[][] distance = {
                {0, 4, 6, 6, MAX_INT, MAX_INT, MAX_INT},
                {MAX_INT, 0, 1, MAX_INT, 7, MAX_INT, MAX_INT},
                {MAX_INT, MAX_INT, 0, MAX_INT, 7, 4, MAX_INT},
                {MAX_INT, MAX_INT, 2, 0, MAX_INT, 5, MAX_INT},
                {MAX_INT, MAX_INT, MAX_INT, MAX_INT, 0, MAX_INT, 4},
                {MAX_INT, MAX_INT, MAX_INT, MAX_INT, 1, 0, 8},
                {MAX_INT, MAX_INT, MAX_INT, MAX_INT, MAX_INT, MAX_INT, 0}
        };
        int[] path = dijkstra( n, x,distance);

    }

}
