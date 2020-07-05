public class HammingDistance{
   
    public static void main(String[] args){
        int x = 1;
        int y = 4;
        int hammer = x ^ y;

        // int hammer_len = (int)(Math.ceil(Math.pow((double) hammer, 0.5)))
        // int[] bin_hammer = new int[hammer_len];
        // 十进制数转二进制数组，"除2取余，逆序排列"
        int ones_ct = 0;
        while(hammer > 0){
            if (hammer % 2 > 0) ones_ct ++;
            hammer /= 2;
        }
        // 也可以用hammer.digitcounts
        System.out.println(ones_ct);
    }
}