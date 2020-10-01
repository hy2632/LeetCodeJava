import java.util.*;

/**
 * 
 * @param arr int整型一维数组 the array
 * @return int整型
 */
public class NowCoder_MaxLength {

    // 滑动窗口是一个set，如果没有就添加，否则比较长度，start增加1
    public static int maxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                start = Math.max(start, map.get(arr[end]) + 1); // 注意点
            }
            max = Math.max(max, end - start + 1);
            map.put(arr[end], end);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = { 2, 2, 3, 2, 4, 3, 4, 3, 4 };
        System.out.println(maxLength(a));
    }

}