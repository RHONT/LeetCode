package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Очень простая задача. Чудом попалась на реализацию генерации сочетаний из цикла алгоритмов.
 */

public class Combinations {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> accumResult = new ArrayList<>();

        int[] comb = new int[k + 2];
        for (int i = 0; i < k; i++) {
            comb[i] = i;
        }
        comb[k] = n;
        comb[k + 1] = 0;
        for (; ; ) {
            fillResult(comb, accumResult, 0, k);
            int j = 0;
            for (; comb[j] + 1 == comb[j + 1]; ) {
                comb[j] = j;
                j = j + 1;
            }
            if (j < k) {
                comb[j]++;
            } else {
                break;
            }
        }
        return accumResult;
    }


    public static void fillResult(int[] array, List<List<Integer>> accumResult, int s, int e) {
        List<Integer> part = new ArrayList<>();
        for (int i = s; i < e; i++) {
            part.add(array[i] + 1);
        }
        accumResult.add(part);
    }
}
