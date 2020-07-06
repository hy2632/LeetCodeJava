import java.util.Arrays;

public class UglyNumber2 {
    public static void main(String[] args) {
        int n = 1600;
        Solution(n);
    }

    private static int Solution(int n){
        // 如果偶数，一直除以2，一直除以3，一直除以5最后为1；
        // 如果奇数，一直/3 /5
        int ugly_value = 1;
        int ugly_idx = 0;
        int i = 1;
        while(ugly_idx != n){
            int i_ = i;
            while (i_ %2==0){
                i_ /= 2; 
            }
            while (i_ %3==0){
                i_ /= 3; 
            }
            while (i_ %5==0){
                i_ /= 5; 
            }
            if (i_ == 1){
                ugly_value = i;
                ugly_idx ++;
            }
            i++;
        }
        System.out.println(ugly_value);
        return ugly_value;
    }

}

// 不幸超时了。。。题目给的hint：一个丑数是之前某个丑数2/3/5倍，如何保存顺序是关键
// 用三个List保存并且合并；
// min(2L1, 3L2, 5L3).