package 贪心算法;

import java.util.*;

public class Prim {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                // 0  1  2  3  4  5  6
                {-0, 6, 0, 0, 0, 1, 0},
                {6, -0, 4, 0, 0, 0, 3},
                {0, 4, -0, 2, 0, 0, 0},
                {0, 0, 2, -0, 6, 0, 5},
                {0, 0, 0, 6, -0, 8, 7},
                {1, 0, 0, 0, 8, -0, 0},
                {0, 3, 0, 5, 7, 0, -0}
        };

        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[0][i] != 0 && !visited[i]) {
                queue.add(new Integer[]{arr[0][i], 0, i});
            }
        }
        while (count < arr.length) {
            Integer[] temp = null;
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (visited[temp[2]]) continue;
                break;
            }
            visited[temp[2]] = true;
            System.out.println("起点" + temp[1] + "---->" + temp[2] + " 距离为：" + temp[0]);
            for (int i = 0; i < arr.length; i++) {
                if (arr[temp[2]][i] != 0 && !visited[i]) {
                    queue.add(new Integer[]{arr[temp[2]][i], temp[2], i});
                }
            }
            count++;
        }
    }
}
