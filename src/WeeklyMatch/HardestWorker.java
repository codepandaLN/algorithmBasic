package WeeklyMatch;

import java.util.HashMap;

public class HardestWorker {
    public int hardestWorker1(int n, int[][] logs) {
        //哈希表
        int m = logs.length;
        int maxTime = logs[0][1];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                   //时长    员工
        map.put(logs[0][1],logs[0][0]);

        for(int i = 1;i < m;++i){
            if(logs[i][1] - logs[i-1][1] > maxTime){
                map.put(logs[i][1] - logs[i-1][1],logs[i][0]);
                maxTime = Math.max(maxTime,logs[i][1] - logs[i-1][1]);
            }
            if(logs[i][1] - logs[i-1][1] == maxTime){
                map.put(maxTime,Math.min(logs[i][0],map.get(maxTime)));
            }
        }
        int res = map.get(maxTime);
        return res;
    }
    //暴力法模拟遍历
    public int hardestWorker2(int n, int[][] logs) {
         int m = logs.length;
         int res = logs[0][0];
         int maxTime = logs[0][1];
         for(int i = 1; i < m;++i){
             if(logs[i][1]-logs[i-1][1] > maxTime){
                 res = logs[i][0];
                 maxTime = logs[i][1]-logs[i-1][1];
             }
             if(logs[i][1]-logs[i-1][1] == maxTime){
                 res = Math.min(res,logs[i][0]);
             }
         }
         return res;
    }

    public int hardestWorker3(int n, int[][] logs) {
        int m = logs.length;
        // ans 表示答案，best 表示目前最长处理时间，last 表示当前任务开始时间
        int ans = 0, best = 0, last = 0;
        for (int i = 0; i < m; i++) {
            // 员工编号
            int idx = logs[i][0];
            // 当前任务处理时长
            int len = logs[i][1] - last;
            // 判断是否更新答案
            if (len > best || (len == best && idx < ans)) {
                ans = idx;
                best = len;
            }
            // 更新下一个任务开始时间
            last = logs[i][1];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] logs = new int[][]{
                {0,3},
                {2,5},
                {0,9},
                {1,15}
        };
        HardestWorker s =  new HardestWorker();
        int res1 = s.hardestWorker1(10,logs);
        int res2 = s.hardestWorker2(10,logs);
        int res3 = s.hardestWorker3(10,logs);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);


    }

}
