public class Q3LongestSubstringWIthoutRepeatingCharacters{
    public static void main(String[] args){
        String str = "abcabcbb";
        System.out.println(SolutionQ3.FindLongestSubstring(str));
    }
}

class SolutionQ3{
    public static int FindLongestSubstring(String str){
        // 两遍遍历，开头字符start从1到len， 结尾字母end从start到len
        // 内循环字符串，if字符没出现过就加长 
        // maxword_len内循环结束后更新
        int strlen = str.length();
        // 如果是空格字符串就直接回0
        if (strlen==0) return 0;

        // 只要有一个字母就至少长为1，可以循环
        int max_word_len = 1;
        int cur_word_len = 1;

        for (int start=0; start<strlen-1; start++){
            // 每个外循环， 定义一个substring
            cur_word_len=1;
            for (int end=start+1; end<strlen; end++){
                String substr = str.substring(start, end);
                String cur_letter = str.substring(end, end+1);
                // 判断在子字符数组中是否出现过，用contains方法
                if (!substr.contains(cur_letter)) {
                    // System.out.printf(cur_letter +" " + substr +"\n");
                    // System.out.printf("start: %s \n end: %s \n cur_word_len: %d \n"+
                    // " max_word_len: %d \n \n", start, end, cur_word_len, max_word_len);
                    cur_word_len ++;
                }   
                else break;
            if (cur_word_len>max_word_len) max_word_len = cur_word_len;
            }
        }
        return max_word_len;
    }
}