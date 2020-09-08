public class NowCoder_minPathSum {
    public static int minPathSum(int[][] grid) {
        // write code here
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows + 1][columns + 1];
        for (int i = 0; i <= rows; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= columns; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i != 0 && j != 0) {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                } else if (i == 0) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + grid[i][j];
                } else if (j == 0) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + grid[i][j];
                }
            }
        }
        return dp[rows][columns];
    }

    public static void main(String[] args) {
        // int[][] grid = {{1,2},{5,6},{1,1}};
        int[][] grid = { { 1 } };
        System.out.println(minPathSum(grid));
    }
}
