package LeetCode.Hard;
// суть в том, что в стеке остаеться проблемные скобки, а нормальные удаляются, и потом мы вычисляем
// диапазоны между этими проблемными индексами, это и есть ответ.

import java.util.Stack;

public class LongestValidParenthesesBest {

    public static void main(String[] args) {


        LongestValidParenthesesBest test = new LongestValidParenthesesBest();
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("()(()"));
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses(")())"));
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("(()()"));
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("((())"));
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("()"));
//
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("(()"));
//
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("())))"));
//
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("()()(()()"));
//
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("()())()()"));
//
//        System.out.print(" 6=");
//        System.out.println(test.longestValidParentheses("(()())"));
//
//        System.out.print(" 8=");
//        System.out.println(test.longestValidParentheses("((()))())"));
//
//        System.out.print(" 22=");
//        System.out.println(test.longestValidParentheses(")(((((()())()()))()(()))("));
//
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("(()))())("));
//
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("(())(()"));

        System.out.print(" 6=");
        System.out.println(test.longestValidParentheses(")(())))(())())"));

        System.out.print(" 0=");
        System.out.println(test.longestValidParentheses("((((((("));
        System.out.print(" 0=");
        System.out.println(test.longestValidParentheses(")))))))))"));

        System.out.print(" 6=");
        System.out.println(test.longestValidParentheses("()(((()())(()"));

        System.out.print(" 132=");
        System.out.println(test.longestValidParentheses(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
        System.out.print(" 134=");
        System.out.println(test.longestValidParentheses(")(()))()(())()()()()(()(()))()())(()()(())()(((()()(()((()(()()((()()))(())())(()(())(()(())(()(()))(()))()()(((()())(()()(()((())))))(()(()())(()))))))())))()())()(())(((()(()))()()(()(((()))()"));

        System.out.print(" 14=");
        System.out.println(test.longestValidParentheses("())(()(())(()(())(()(()))"));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {

                // current closing bracket

                if (!st.empty() && s.charAt(st.peek()) == '(') {
                    // balanced case
                    st.pop();
                } else {
                    // unbalanced case
                    st.push(i);
                }
            }
        }

        int maxLen = 0;
        int endTerminal = s.length();

        while (!st.empty()) {
            int startTerminal = st.pop();
            maxLen = Math.max(maxLen, endTerminal - startTerminal - 1);
            endTerminal = startTerminal;
        }

        return Math.max(endTerminal, maxLen);

    }
}
