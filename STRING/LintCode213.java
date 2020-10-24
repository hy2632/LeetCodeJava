public class LintCode213 {
    /**
     * https://www.lintcode.com/problem/string-compression
     * @param originalString: a string
     * @return: a compressed string
     */
    
    public static String compress(String originalString) {
        // write your code here
        
        if (originalString.length() < 1) return "";
        
        int i = 1;
        char prev;
        char curr;
        int count = 1;
        String compressed = "";

        while (i < originalString.length()){
            prev = originalString.charAt(i-1);
            curr = originalString.charAt(i);

            if (curr == prev){
                count++;
            } else {
                compressed = compressed.concat(String.valueOf(prev)).concat(String.valueOf(count));
                count = 1;
            }
            i++;
        }
        prev = originalString.charAt(i-1);
        compressed = compressed.concat(String.valueOf(prev)).concat(String.valueOf(count));

        return compressed.length() < originalString.length() ? compressed: originalString;
    }

    public static void main(String[] args){
        String original  = "a";
        System.out.println(compress(original));
    }


}