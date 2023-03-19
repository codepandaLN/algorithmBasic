package WeeklyMatch.week337;

/**
 * @author panda
 */
public class CheckValidGrid {
    public boolean checkValidGrid(int[][] grid) {
        int[][] index = new int[grid.length * grid.length][];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                index[grid[i][j]] = new int[] { i, j };
            }
        }
        for (int i = 1; i < index.length; i++) {
            if (Math.abs(index[i][0] - index[i - 1][0]) * Math.abs(index[i][1] - index[i - 1][1]) != 2) {
                return false;
            }
        }
        return grid[0][0] == 0;
    }
}
