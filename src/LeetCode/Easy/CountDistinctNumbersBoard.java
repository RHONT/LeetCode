package LeetCode.Easy;

import java.util.HashSet;

/**
 * Вам дано целое положительное число n, которое изначально находится на доске. Каждый день в течение 109 дней вы выполняете следующую процедуру:
 * <p>
 * Для каждого числа x, присутствующего на доске, найдите все числа 1 <= i <= n такие, что x % i == 1.
 * Затем разместите эти цифры на доске.
 * Возвращает количество различных целых чисел на доске по истечении 109 дней.
 * <p>
 * Примечание:
 * Как только число помещено на доску, оно останется на ней до конца.
 * % обозначает операцию по модулю. Например, 14 % 3 равно 2.
 */

public class CountDistinctNumbersBoard {
    HashSet<Integer> dict = new HashSet<>();

    public static void main(String[] args) {
        CountDistinctNumbersBoard c = new CountDistinctNumbersBoard();
        System.out.print("4 = ");
        System.out.println(c.distinctIntegers(5));

        System.out.print("2 = ");
        System.out.println(c.distinctIntegers(3));

        System.out.print("? = ");
        System.out.println(c.distinctIntegers(50));
    }


    // Вот было решение!!!!
    // Просто n-1!
    public int distinctIntegersBest(int n) {
        if (n == 1) {
            return 1;
        }
        return n - 1;
    }

    public int distinctIntegers(int n) {
        recursive(n);

        int result = dict.size() + 1;
        dict.clear();
        return result;

    }

    private void recursive(int n) {
        if (n == 2 || n == 1) {
            return;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                dict.add(i);
            }
        }
        recursive(n - 1);
    }

}
