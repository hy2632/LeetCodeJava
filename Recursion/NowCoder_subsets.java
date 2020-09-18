import java.util.*;

public class NowCoder_subsets {
    /** 集合的所有子集 */
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // 包含空子集
        if (S.length == 0) {
            ArrayList<Integer> empty = new ArrayList<>();
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            result.add(empty);
            return result;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] S_m1 = Arrays.copyOfRange(S, 0, S.length - 1);
        ArrayList<ArrayList<Integer>> result_m1 = subsets(S_m1);
        for (ArrayList<Integer> subset_m1 : result_m1) {
            if (subset_m1.size() == 0)
                continue; // 空子集暂时不管
            result.add(subset_m1); // 之前的也要加上
            ArrayList<Integer> subset = (ArrayList<Integer>) subset_m1.clone();
            subset.add(S[S.length - 1]);
            Collections.sort(subset);
            result.add(subset);
        }
        // 加最后一位的一元子集
        ArrayList<Integer> lastDigit = new ArrayList<>();
        lastDigit.add(S[S.length - 1]);
        result.add(lastDigit);
        // 加空集
        ArrayList<Integer> empty = new ArrayList<>();
        result.add(empty);
        return result;
    }

    public static void main(String[] args) {
        int[] S = { 1 };
        ArrayList<ArrayList<Integer>> subset = subsets(S);
        for (ArrayList<Integer> i : subset)
            System.out.println(Arrays.toString(i.toArray()));

    }
}