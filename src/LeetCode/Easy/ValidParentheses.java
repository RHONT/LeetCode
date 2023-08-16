package LeetCode.Easy;

import java.util.*;

public class ValidParentheses {

    Map<Character, Integer> dictionaryOpen = new HashMap<>(Map.of('{', 0, '(', 1, '[', 2));
    Map<Character, Integer> dictionaryClosed = new HashMap<>(Map.of('}', 0, ')', 1, ']', 2));

    public static void main(String[] args) {


        ValidParentheses v = new ValidParentheses();

        System.out.println(v.isValid("{[]}{}"));
        System.out.println(v.isValid("([)]"));
    }

    // Решение хорошее, но харкод.
    public boolean isValidBest(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();

    }

    public boolean isValid(String s) {
        StringBuilder temp = new StringBuilder(s);

        if (s.length() % 2 == 1 || s.length() < 2) {
            return false;
        }

        int[] indexes = new int[dictionaryOpen.size()];
        Arrays.fill(indexes, 0);

        for (int i = 0; i < temp.length(); i++) {
            if (dictionaryClosed.containsKey(temp.charAt(0))) {
                return false;
            }

            if (dictionaryOpen.containsKey(temp.charAt(i))) {
                indexes[dictionaryOpen.get(temp.charAt(i))] += 1;
            } else {
                if (dictionaryClosed.get(temp.charAt(i)) == dictionaryOpen.get(temp.charAt(i - 1))) {

                    indexes[dictionaryClosed.get(temp.charAt(i))] -= 1;

                    if (indexes[dictionaryClosed.get(temp.charAt(i))] < 0) return false;
                    else {
                        temp.delete(i - 1, i + 1);
                        i -= 2;
                    }
                } else return false;


            }
        }
        return Arrays.stream(indexes).sum() == 0;
    }


}
