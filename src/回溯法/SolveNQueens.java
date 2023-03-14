package 回溯法;

import java.util.*;

public class SolveNQueens {
    /**
     * 基于集合的回溯   ‘Q’代表皇后的位置 ‘.’空白位置
     */
    public List<List<String>> solveNQueens1(int n) {
        //定义一个返回结果的集合
        List<List<String>> res = new ArrayList<>();
        //定义一个存储皇后的集合
        int[] queens = new int[n];
        //填充数组queens[]中的每个元素都是-1
        //queens={-1,-1,-1...-1}
        Arrays.fill(queens, -1);
        //定义一个变量，来记录当前元素所在的列，并将他所在的列标记为不可放元素
        Set<Integer> columns = new HashSet<>();
        //定义一个变量，来记录当前元素所在的左对角线，并将他所在的左对角线标记为不可放元素
        Set<Integer> diagonals1 = new HashSet<>();
        //定义一个变量，来记录当前元素所在的右对角线，并将他所在的右对角线标记为不可放元素
        Set<Integer> diagonals2 = new HashSet<>();
        //深度优先搜索方法
        dfs(res, queens, n, 0, columns, diagonals1, diagonals2);
        int sum = res.size();
        System.out.println("皇后个数n = "+ n +" 时有 " + sum +" 种可行方案,可行解为 ：" );
        System.out.println(res);
        return res;
    }

    public void dfs(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns,
                    Set<Integer> diagonals1, Set<Integer> diagonals2) {
        //如果当前遍历到最后一行，就说明存在一个解法
        //所以将皇后的位置，存放入结果中
        if (row == n) {
            //用来将当前的N行N列中的元素所在的位置结果，转换格式
            List<String> board = generateBoard(queens, n);
            //将符合条件的结果添加进返回结果集中
            res.add(board);
        } else {
            //遍历所有行
            for (int i = 0; i < n; i++) {
                //用来标记，当前行元素所在的列，都不可放元素
                if (columns.contains(i)) {
                    continue;
                }
                //去除左对角线上的所有元素
                //row 表示行，i表示列
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                //去除右对角线上的元素
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                //经过上面的三次排除，就可以找到元素在当前行的哪一列的位置。
                //选第一行的第几列，也可以叫单元格所在的位置
                queens[row] = i;
                //把选中的单元格加入到，去除列的集合中
                //用来给下一行的元素所在的列作为排除条件判断
                columns.add(i);
                //把选中的单元格加入到，去除左对角线的集合中
                diagonals1.add(diagonal1);
                //把选中的单元格加入到，去除右对角线的集合中
                diagonals2.add(diagonal2);
                //递归遍历下一行，
                dfs(res, queens, n, row + 1, columns, diagonals1, diagonals2);
                //剪枝操作
                queens[row] = -1;
                //将当前列和左对角线和右对角线的元素都删除，避免重复遍历
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    //转换格式
    public List<String> generateBoard(int[] queens, int n) {
        //定义一个结果集，用于返回结果
        List<String> board = new ArrayList<>();
        //遍历所有行
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            //将当前行所在的列的，位置置为Q
            row[queens[i]] = 'Q';
            //将当前结果添加进结果集中
            board.add(new String(row));
        }
        return board;
    }

    /**
     * 基于位运算的回溯法     ‘Q’代表皇后的位置 ‘.’空白位置
     */
    public List<List<String>> solveNQueens2(int n) {
        // 这个数组用于记录每行中皇后所在的位置
        int[] queens = new int[n];
        // 官方在这里用-1填充queens数组，但是和下面的状态重置一样，没有必要
        // Arrays.fill(queens,-1);
        List<List<String>> results = new ArrayList<>();
        solveNQueens(results, queens, n, 0, 0, 0, 0);
        int sum = results.size();
        System.out.println("皇后个数n = "+ n +" 时有 " + sum +" 种可行方案,可行解为 ：" );
        System.out.println(results);
        return results;
    }

    /**
     * int n：总行数
     * int row：当前行数
     * int columns：不可选的列
     * int diagonals1：不可选的左斜边
     * int diagonals2：不可选的右斜边
     */
    public void solveNQueens(List<List<String>> results, int[] queens, int n, int row,
                             int columns, int diagonals1, int diagonals2) {
        // 如果能到达这一步，说明搜索已经到底了，我们已经记录下了一个可行的方案
        if (row == n) {
            // 直接生成一个结果，并放入结果集中
            results.add(generateString(queens));
            // 方法终止
            return;
        }
        // 1<<n-1 是为了转化一个长度为n的，每位上都是1的二进制数，用于定位可以放置皇后的位置
        // 这里用于定位所有可选的位置，这里有一步取反，千万不要忽视了！
        // 上面我们用 1 表示不可选的位置，但是这里我们取反后，用1表示可选的位置
        int availableLocations = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        // 我们通过下面的操作来保持之前所有的行对下一行的影响
        // 左斜边因为下降了一行需要左移一位
        diagonals1 <<= 1;
        // 右斜边因为下降了一行需要右移一位
        diagonals2 >>= 1;
        // 开始检查每个可选的位置
        while (availableLocations != 0) {
            // 定位最后一个1的位置，这个操作可以自己手写验证一下（不要忘了把负数转成补码）
            // 这个定位的意思是，生成的这个二进制数只有最后一个1还为1，其他位都变成了0
            int position = availableLocations & (-1 * availableLocations);
            // 这个方法是统计一个二进制数中所有的“1”的个数
            int columnNum = Integer.bitCount(position - 1);
            // 将这个位置添加到记录数组中
            queens[row] = columnNum;
            // 将这一位从可选取的位中移除
            // 减1把最后一个1拆成后面的多个1，再经过一次与操作把这些多出来的1全部清除
            availableLocations = availableLocations & (availableLocations - 1);
            // 沿着这个位置向下搜索，可选行和可选列的直接在参数上变化即可，这样就不需要手动重置状态了
            solveNQueens(results, queens, n, row + 1, columns | position,
                    diagonals1 | position << 1, diagonals2 | position >> 1);
            // 官方在这里曾经重置过数组queens的状态，但实际上没这个必要，每次循环上一次的结果都会被覆盖
            // queens[row]=-1;
        }
    }

    // 生成字符串
    public List<String> generateString(int[] queens) {
        List<String> result = new ArrayList<>();
        for (int i : queens) {
            char[] chars = new char[queens.length];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            result.add(String.valueOf(chars));
        }
        return result;
    }

    public static void main(String[] args) {
        SolveNQueens s = new SolveNQueens();
        System.out.println("基于集合的回溯法结果为：");
        s.solveNQueens1(4);
        s.solveNQueens1(5);
        s.solveNQueens1(6);
        System.out.println("\n");
        System.out.println("基于位运算的回溯法结果为：");
        s.solveNQueens2(4);
        s.solveNQueens2(5);
        s.solveNQueens2(6);

    }
}
