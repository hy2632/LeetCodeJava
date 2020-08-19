import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TaskScheduler0728 {
    public static void main(String[] args) {
        // ordered String[]
        char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;

        // // hashmap to store the frequency of element
        // // https://www.geeksforgeeks.org/count-occurrences-elements-list-java/
        // Map<String, Integer> hm = new HashMap<String, Integer>();
        // for (String i : tasks) {
        // Integer j = hm.get(i);
        // hm.put(i, (j == null) ? 1 : j + 1);
        // }
        // System.out.println(hm.toString());

        
        // 统计每个字母出现次数
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        
        // 出现次数最多的task先按照CD排好序，此时总时间(maxFreq-1)*(n+1)+1
        // 考虑最后的排序是贪心的，每个单元尽可能按总体次数（优先级）排序，如 ABCABC
        // 如果没有idle，即A重复出现的单元全部被其他任务排满，则时间就等于总长。考虑方块图，最左端最长，向右递减
        // 只要还有idle，因为我们是按单元次序填充的，所以不必担心剩余任务的CD问题
        // 如果和第一多并列，则尾巴groupsize++
        // 如果严格比第一多的少，则可以填入空闲时间
        

        int maxFreq = 0;
        int groupSize = 0;

        for (int i : count) {
            if (i > maxFreq) {
                maxFreq = i;
                groupSize = 0;
            }
            if (maxFreq == i) {
                groupSize++;
            }
        }
        Math.max(tasks.length, (n + 1) * (maxFreq - 1) + groupSize);

    }
}
