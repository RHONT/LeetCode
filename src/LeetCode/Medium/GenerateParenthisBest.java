package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

// как и ожидалось. Рекурсия блядь.

public class GenerateParenthisBest {
    public static void main(String[] args) {
        GenerateParenthisBest generateParenthisBest = new GenerateParenthisBest();
        System.out.println(generateParenthisBest.generateParenthesis(4));
    }

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new char[n * 2]);
        return res;
    }

    private void generate(int n, int opened, int closed, char[] curr) {
        if (opened + closed == n * 2) {
            res.add(String.valueOf(curr));
            return;
        }
        int idx = opened + closed;
        if (opened == n) {
            curr[idx] = ')';
            generate(n, opened, closed + 1, curr);
        } else {
            curr[idx] = '(';
            generate(n, opened + 1, closed, curr);
            if (opened > closed) {
                curr[idx] = ')';
                generate(n, opened, closed + 1, curr);
            }
        }
    }
}
