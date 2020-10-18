public class NC56 {
    public static boolean isPalindrome (int x) {
        // write code here
        if (x < 0) return false;
        if (x / 10 == 0) return true;
        
        
        while(x >= 0){
            int div = 1;
            while (x / div >= 1){
                div *= 10;
            }
            int hi = x / div;
            int low = x % 10;
            if (hi != low) return false;
            x = (x % div) / 10;
            System.out.println(div);
            System.out.println(x);
            System.out.println();

        }
        return true;

    }

    public static void main(String[] args){
        int i = 121;
        System.out.println(isPalindrome(i));
    }
}
