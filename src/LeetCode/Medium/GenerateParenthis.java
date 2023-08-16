package LeetCode.Medium;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//Example 1: Input: n = 3
//        Output: ["((()))","(()())","(())()","()(())","()()()"]
//Example 2: Input: n = 1
//        Output: ["()"]

// не могу победить... Тут напрашивается рекурсия. Но это для меня темный лес.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthis {
    private static int step;
    private static String[] originArray;

    public static void main(String[] args) {
        char c = '(';
        char b = ')';
        System.out.println((int) c);
        System.out.println((int) b);
        System.out.println(c < b);
        System.out.println();


        int[] test = new int[]{1, 1, 0, 0, 0, 1, 1, 0};
        GenerateParenthis generateParenthis = new GenerateParenthis();
        System.out.println(generateParenthis.generateParenthesis(4));

    }

    public List<String> generateParenthesis(int n) {
        char[] charsArray = new char[n * 2];
        fillArray(charsArray, n);
        List<String> result = new ArrayList<>(List.of(converToString(charsArray)));
        calcNarayanPermutations(charsArray, result);

        return result;

    }

    private String converToString(char[] chars) {
        return String.valueOf(chars);
    }

    private void calcNarayanPermutations(char[] array, List<String> result) {

        int firstIndex = findFirstIndex(array);

        while (firstIndex != -1) {
            int firstSmall = array[firstIndex];
            int secondIndex = findSecondValueIndex(array, firstSmall);
            swap(array, firstIndex, secondIndex);
            reverse(array, firstIndex);
            if (checkActualString(array)) {
                result.add(converToString(array));
            }

            firstIndex = findFirstIndex(array);
        }
    }

    private void swap(char[] array, int firstIndex, int secondIndex) {
        char temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private int findSecondValueIndex(char[] array, int firstValue) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > firstValue) {
                return i;
            }
        }
        return -1;
    }

    private int findFirstIndex(char[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private void reverse(char[] permutation, int index) {
        int shift = index + 1;
        for (int i = 0; i < (permutation.length - shift) / 2; i++) {
            char temp = permutation[shift + i];
            permutation[shift + i] = permutation[permutation.length - i - 1];
            permutation[permutation.length - i - 1] = temp;
        }
    }

    private void fillArray(char[] intArray, int n) {
        Arrays.fill(intArray, 0, n, '(');
        Arrays.fill(intArray, n, intArray.length, ')');
    }

    private boolean checkActualString(char[] checkArray) {
        if (checkArray[0] == ')' || checkArray[checkArray.length - 1] == '(') {
            return false;
        }
        int sumClosed = 0;
        int sumOpen = 0;
        for (int i = checkArray.length - 1; i >= 0; i--) {
            if (checkArray[i] == ')') {
                sumClosed++;
            } else {
                sumOpen++;
                if (sumOpen > sumClosed) {
                    return false;
                }
            }
        }
        return true;
    }
}

