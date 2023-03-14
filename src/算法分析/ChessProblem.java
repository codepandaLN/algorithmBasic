package 算法分析;

public class ChessProblem {

    int size;//容量
    int[][] board;//棋盘
    int specialRow;//特殊点横坐标
    static int number = 0;//L形编号，这个一定要是静态的，可以在任何地方访问到
    int specialCol;//特殊点纵坐标

    public ChessProblem(int specialRow, int specialCol, int size) {
        this.size = size;
        this.specialCol = specialCol;
        this.specialRow = specialRow;
        board = new int[size][size];
    }

    //specialRow   特殊点的行下标
    //specialCol   特殊点的列下标
    //leftRow      矩阵的左边起点行下标
    //leftCol      矩阵左边起点的列下标
    //size         棋盘的宽或者高

    public void setBoard(int specialRow, int specialCol, int leftRow, int leftCol, int size) {
        //大小为1时，结束递归
        if (1 == size) {
            return;
        }

        int subSize = size / 2;
        number++;
        int n = number;//注意这里一定要吧number存在当前的递归层次里，否则进入下一层递归全局变量会发生改变

        //假设特殊点在左上角区域
        if (specialRow < leftRow + subSize && specialCol < leftCol + subSize) {
            setBoard(specialRow, specialCol, leftRow, leftCol, subSize);
        }
        else {
            //不在左上角，设左上角矩阵的右下角就是特殊点（和别的一起放置L形）
            board[leftRow + subSize - 1][leftCol + subSize - 1] = n;
            setBoard(leftRow + subSize - 1, leftCol + subSize - 1, leftRow, leftCol, subSize);
        }

        //假设特殊点在右上方
        if (specialRow < leftRow + subSize && specialCol >= leftCol + subSize) {
            setBoard(specialRow, specialCol, leftRow, leftCol + subSize, subSize);
        }
        else {
            //不在右上方，设右上方矩阵的左下角就是特殊点（和别的一起放置L形）
            board[leftRow + subSize -1][leftCol + subSize] = n;
            setBoard(leftRow + subSize -1, leftCol + subSize, leftRow, leftCol + subSize, subSize);
        }

        //特殊点在左下方
        if (specialRow >= leftRow + subSize && specialCol < leftCol + subSize) {
            setBoard(specialRow, specialCol, leftRow + subSize, leftCol, subSize);
        }
        else {
            //不在左下方，设左下方矩阵的右上角就是特殊点（和别的一起放置L形）
            board[leftRow + subSize][leftCol + subSize - 1] = n;
            setBoard(leftRow + subSize, leftCol + subSize - 1, leftRow + subSize, leftCol, subSize);
        }

        //特殊点在右下角
        if (specialRow >= leftRow + subSize && specialCol >= leftCol + subSize) {
            setBoard(specialRow, specialCol, leftRow + subSize, leftCol + subSize, subSize);
        }
        else {
            //不在右下角，设右下角矩阵的左上就是特殊点（和别的一起放置L形）
            board[leftRow + subSize][leftCol + subSize] = n;
            setBoard(leftRow + subSize, leftCol + subSize, leftRow + subSize, leftCol + subSize, subSize);
        }
    }

    //输出棋盘
    public void printBoard(int specialRow,int specialCol,int size) {
        setBoard(specialRow, specialCol, 0, 0, size);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        //棋盘的大小
        int N = 8;
        //特殊点的坐标
        int specialRow = 1;
        int specialCol = 4;
        ChessProblem chessProblem = new ChessProblem(specialRow , specialCol , N);
        chessProblem.printBoard(specialRow, specialCol, N);
    }

}

