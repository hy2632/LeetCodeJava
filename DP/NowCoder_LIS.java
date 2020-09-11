import java.util.*;

public class NowCoder_LIS {
    // public static int[] LIS(int[] arr){
    // int[][] DP = new int[arr.length][];
    // DP[0] = new int[] {arr[0]};
    // int[] bestarr = DP[0];

    // for (int i = 1; i < arr.length; i++){
    // bestarr = DP[0];
    // for (int j = 0; j < i; j++){
    // bestarr = arrayCompare(searchInsert(DP[j], arr[i]), bestarr);
    // }
    // DP[i] = bestarr;
    // System.out.printf("arr[%d]: %d, DP[%d] : %s \n", i, arr[i], i,
    // Arrays.toString(DP[i]));
    // }

    // bestarr = DP[0];
    // for (int i = 1; i < DP.length; i++){
    // bestarr = arrayCompare(bestarr, DP[i]);
    // }

    // return bestarr;
    // }

    // 能用但超时
    public static int[] LIS(int[] arr) {
        int[][] DP = new int[arr.length][];
        // 括号内表示LIS长度
        DP[0] = new int[] {};
        DP[1] = new int[] { arr[0] };
        int maxlength = 1;
        int[] bestarr = DP[maxlength];

        for (int i = 1; i < arr.length; i++) {
            bestarr = searchInsert(DP[maxlength], arr[i]);
            for (int j = maxlength-1; j >= 1; j--){
                bestarr = arrayCompare(bestarr, searchInsert(DP[j], arr[i]));
            }
            DP[bestarr.length] = bestarr;
            if (bestarr.length > maxlength) maxlength=bestarr.length;
            // System.out.printf("arr[%d]: %d, DP[%d] : %s \n", i, arr[i], maxlength, Arrays.toString(DP[maxlength]));
        }
        return DP[maxlength];
    }

    // [1,3,4,8,9] < [1,3,4,7,10] 末尾开始比较
    public static int[] arrayCompare(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            return a1.length > a2.length ? a1 : a2;
        } else {
            // return (Arrays.compare(a1, a2) == 0) ? a1 : a2;
            return (Arrays.toString(a1).compareTo(Arrays.toString(a2)) == 0) ? a1 : a2;
        }            
    }

    public static int[] searchInsert(int[] arr, int a) {
        if (arr.length == 0 || a < arr[0]) {
            return new int[] { a };
        } else if (a >= arr[arr.length - 1]) {
            return arrayAppend(arr, a);
        } else {
            int left = 0;
            int right = arr.length - 1;
            while (left + 1 != right){
                int mid = (left + right) >> 1;
                if (arr[mid] > a){
                    right = mid;
                } else {
                    left = mid;
                }
            }
            int[] result = Arrays.copyOfRange(arr, 0, right+1);
            result[result.length - 1] = a;
            return result;
        }
    }

    public static int[] arrayAppend(int[] arr, int a) {
        int[] result = Arrays.copyOf(arr, arr.length + 1);
        result[result.length - 1] = a;
        return result;
    }

    // 参考做法
    public static int[] LIS2(int[] arr) {
        // write code here
        int n = arr.length;
        int[] end = new int[n + 1];
        int[] dp = new int[n];
        int len = 1;
        end[1] = arr[0];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (end[len] < arr[i]) {
                end[++len] = arr[i];
                dp[i] = len;
            } else {
                int l = 0;
                int r = len;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (end[mid] >= arr[i]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                end[l] = arr[i];
                dp[i] = l;
            }
        }
        int[] res = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {1,3,4,8,9,7,10};
        // int[] arr = {5, 3, 9, 13, 12, 11, 1, 2, 8, 6, 4, 15, 14, 7,};
        // int[] arr = {2,8,1,3,5,9};
        // int[] arr = {1,2,8,6,4,5,3,9,13,12,11};


        int[] arr = { 49506168, 69680825, 12509291, 48480857, 25223382, 19183828, 59158379, 86939717, 40645996, 6308877,
                10012993, 63667893, 50197187, 24801729, 25023038, 47920500, 20403356, 51081751, 53271648, 93798698,
                17212977, 33985688, 41235650, 53107971, 28540590, 88207258, 41085783, 67747947, 79259171, 38774038,
                47976443, 69145317, 23674167, 23375819, 64283405, 53278302, 6842944, 32835306, 65425302, 57452938,
                44061263, 33188353, 36344809, 40853306, 42614674, 18170661, 62426275, 95157030, 93852465, 14694594,
                27510732, 6588658, 76929617, 44994473, 15916331, 34728593, 92424819, 24068421, 62452242, 72288496,
                58516068, 38068970, 32887138, 7139725, 55989211, 44497486, 99670615, 43652169, 55855016, 8400743,
                4818109, 36575316, 59923999, 37546251, 68006009, 80237095, 61109920, 82015485, 38021784, 48795556,
                74632998, 9965861, 57739193, 86269790, 33882927, 68623665, 18399472, 72220645, 28234019, 56500908,
                45331825, 14190203, 61666988, 69450522, 84914849, 56895970, 45318684, 9731080, 57102758, 65566000,
                41127251, 93881179, 24211530, 14612193, 12776968, 54282870, 77449039, 14614543, 10452592, 43882497,
                80167247, 44983066, 49385171, 78410318 };

        // System.out.println(Arrays.toString(LIS2(arr)));
        System.out.println(Arrays.toString(LIS(arr)));
        // int[] a = {1,3,4,8,9};
        // int[] b = {1,3,4,7,10};
        // System.out.println(Arrays.compare(a, b));
    }
}