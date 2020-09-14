import java.util.*;
public class NowCoder_BiggestSquare {
    public static void main(String[] args) {
        char[][] mat = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(solve(mat));
    }

    public static int solve (char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int maxEdge = 0;

        // Initialize and conver char to int
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = matrix[i][j] - '0';
            }
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    if (dp[i][j] > maxEdge){
                        maxEdge = dp[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < m; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return maxEdge * maxEdge;
    }






    // public static int solve(char[][] matrix) {
    //     // write code here
    //     if (matrix.length == 0 || matrix[0].length == 0)
    //         return 0;

    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int max = 0;
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             dp[i][j] = matrix[i][j] - '0';
    //             if (dp[i][j] == 1) {
    //                 max = 1;
    //             }
    //         }
    //     }
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             if (matrix[i][j] == '1') {
    //                 dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
    //                 max = Math.max(dp[i][j], max);
    //             }
    //         }
    //     }
    //     for (int i = 0; i < m; i++){
    //         System.out.println(Arrays.toString(dp[i]));
    //     }
    //     return max * max;
    // }
}