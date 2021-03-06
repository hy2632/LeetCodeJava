import java.util.*;

public class NC61 {
    /**
     * 
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */

    public static int[] twoSum(int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        int tgt = 6;
        System.out.println(Arrays.toString(twoSum(nums, tgt)));
    }

}