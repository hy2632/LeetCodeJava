import java.util.Arrays;

public class NC127 {
    /**
     * longest common substring
     * 
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String str1, String str2) {
        // write code here
        int[][] DP = new int[str1.length() + 1][str2.length() + 1];
        int startIdx = 0, endIdx = 0;
        int maxLen = 0;
        String result;

        for (int i = 0; i < str1.length() + 1; i++) {
            DP[i][0] = 0;
        }

        for (int i = 0; i < str2.length() + 1; i++) {
            DP[0][i] = 0;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.min(DP[i - 1][j], DP[i][j - 1]);
                }

                if (DP[i][j] >= maxLen) {
                    maxLen = DP[i][j];
                    endIdx = i;
                }
            }
        }

        startIdx = endIdx - maxLen + 1;

        System.out.printf("startIdx: %d, endIdx: %d \n", startIdx, endIdx);
        for (int i = 0; i < str1.length() + 1; i++) {
            System.out.println(Arrays.toString(DP[i]));
        }

        result = str1.substring(startIdx - 1, endIdx);
        if (result.length() == 0)
            return "-1";

        return result;
    }

    public static void main(String[] args) {
        String str1 = "1AB23456HCDEFG", str2 = "123456QCDEFG";
        System.out.println(LCS(str1, str2));
    }
}
