/* 
    逐元素遍历；
    若上下左右有1，则减
*/

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        // int[][] grid = new int[][] { { 1, 1 } };
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if ((i > 0) & (j > 0)) {
                        if (grid[i - 1][j] == 1)
                            perimeter -= 2;
                        if (grid[i][j - 1] == 1)
                            perimeter -= 2;
                    }
                    if ((i == 0) & (j > 0)) {
                        if (grid[i][j - 1] == 1)
                            perimeter -= 2;
                    }
                    if ((j == 0) & (i > 0)) {
                        if (grid[i - 1][j] == 1)
                            perimeter -= 2;
                    }
                }
            }
        }
        System.out.println(perimeter);

    }
}