import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class toGoatLatin0819 {
    public static String toGoatLatin(String S) {
        // RegexMatcher(S)
    }


    public static void main(String[] args){
        String input = "I speak Goat Latin";
        String patternString = "\\s+";
        Pattern pattern = Pattern.compile(patternString);
        System.out.println(pattern.matcher(input));
    }
}