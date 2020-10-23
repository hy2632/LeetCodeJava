import java.util.Stack;

/**1541. 平衡括号字符串的最少插入次数

    当前步如果是左括号，则左边的问题结束(因为没有连续右括号了)，默认左边问题已经解决，
    只需要记住当前步多了一个左括号（可以放到栈里也可以计数）。

    当前步如果是右括号，
        1. 如果下一步也是右括号，两个并成一个 "))"，如果Left里有左括号就pop出来一个，和现在的 "))"消去；
        如果目前没有多余的左括号，就把 "))" 存到 Right2 栈里 (计数也行)
        2. 如果下一步是个左括号，那这一步的 ')' 就需要单独处理：
            2.1 当前Left栈里有左括号，直接在这一步插入一个 ')' 消去一组 "())", 这种借来的 ')'先计入rightDemand中
            2.2 当前Left栈空，就在这个')'左右加 '(' 和 ')'，leftDemand 和 rightDemand 各计一个
        
    最后多余的每一个 '(' 需要加两个 ')', "))" 需要加一个 '('

 */

public class LC1541 {
    public static int minInsertions(String s) {
        int i = 0;
        Stack<String> Left = new Stack<>();
        Stack<String> Right2 = new Stack<>();
        int rightDemand = 0;
        int leftDemand = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                Left.push("(");
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') { // try to combine "))"
                    i += 1; // skip 1
                    if (!Left.empty()) {
                        Left.pop();
                    } else {
                        Right2.push("))");
                    }
                } else {
                    if (!Left.empty()) {
                        // Add ")" to the right immediately and eliminate one left.
                        Left.pop();
                        rightDemand++;
                    } else {
                        // only one single ')', immediately eliminate it
                        leftDemand += 1;
                        rightDemand += 1;
                    }
                }
            }
            i++;
        }

        rightDemand += 2 * Left.size();
        leftDemand += Right2.size();
        return rightDemand + leftDemand;
    }

    public static void main(String[] args) {
        // String str = "))())(";
        String str = "(()))";
        System.out.println(minInsertions(str));
    }
}
