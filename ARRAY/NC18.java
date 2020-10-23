import java.util.Arrays;

public class NC18 {
    public static int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] rotated = new int[n][n];
        for (int j = 0;  j < n; j++) {
            for (int i = 0; i < n; i++) {
                rotated[j][i] = mat[n-1-i][j];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[][] mat = { 
            { 1, 2, 3 }, 
            { 4, 5, 6 }, 
            { 7, 8, 9 } 
        };
        System.out.println(Arrays.toString(rotateMatrix(mat, 3)[0]));
        System.out.println(Arrays.toString(rotateMatrix(mat, 3)[1]));
        System.out.println(Arrays.toString(rotateMatrix(mat, 3)[2]));


    }

}
