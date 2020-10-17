import java.util.ArrayList;
import java.util.Arrays;

public class NC38 {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0)
            return res;
        int n = matrix[0].length;
        if (n == 0)
            return res;
        // [left, right); [up, low)

        int left = 0;
        int right = n;
        int up = 0;
        int low = m;

        while (left < right - 1 && up < low - 1) {
            for (int i = left; i < right; i++) {
                res.add(matrix[up][i]);
            }
            for (int j = up + 1; j < low; j++) {
                res.add(matrix[j][right - 1]);
            }
            for (int i = right - 2; i >= left; i--) {
                res.add(matrix[low - 1][i]);
            }
            for (int j = low - 2; j >= up + 1; j--) {
                res.add(matrix[j][left]);
            }

            left++;
            right--;
            up++;
            low--;
        }

        if (left == right - 1) {
            for (int j = up; j < low; j++) {
                res.add(matrix[j][left]);
            }
        } else if (up == low - 1) {
            for (int i = left; i < right; i++) {
                res.add(matrix[up][i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        int[][] mat2 = new int[2][1];
        mat2[0] = new int[] { 3 };
        mat2[1] = new int[] { 2 };

        int[][] mat3 = new int[1][1];
        mat3[0] = new int[] { 1 };

        ArrayList<Integer> result = spiralOrder(mat);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
