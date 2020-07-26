public class AddDigits0726{
    public static void main(String[] args){
        int a = 64;
        System.out.println(final_sum(a));
    }
    
    private static int digit_sum(int input){
        // 去除所有末位0
        while (input%10==0){
            input /= 10;
        }
        int sum = 0;
        while (input!=0){
            sum += input%10;
            input /= 10;
        }
        return sum;
    }

    private static int final_sum(int input){
        int current_sum = input;
        while (current_sum >=10){
            current_sum = digit_sum(current_sum);
        }
        return current_sum;
    }
}





// 666的写法 https://leetcode.com/articles/add-digits/
// class Solution {
//     public int addDigits(int num) {
//         return num == 0 ? 0 : 1 + (num - 1) % 9;
//     }
// }