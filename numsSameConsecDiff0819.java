import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numsSameConsecDiff0819{
    
    public static int[] numsSameConsecDiff(int N, int K) {
        if (N==1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        else{
            int[] arrN_1 = numsSameConsecDiff(N-1, K);
            List<Integer> arrN = new ArrayList<Integer>();
            for (int num: arrN_1){
                int tailDigit = num%10;
                if (tailDigit + K <10 && num!=0){ //防止N=2时，0+7->7只有一位，只能70
                    arrN.add(num*10+tailDigit+K);
                }
                if (tailDigit - K >= 0 && K != 0){// 如果K=0只执行上一个向右添加的操作，避免重复和0
                    arrN.add(num*10+tailDigit-K);
                }
            }
            return arrN.stream().mapToInt(i->i).toArray(); //List<Integer> to int[]
        }
    }
       
    public static void main(String[] args){
        int N=3;
        int K=7;
        System.out.println(Arrays.toString(numsSameConsecDiff(N, K)));
          System.out.println(Arrays.toString(numsSameConsecDiff(2, 0)));
        
    }
}