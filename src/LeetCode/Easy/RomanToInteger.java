package LeetCode.Easy;

import java.io.FilterOutputStream;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToIntBest1("MCMXCIV"));

    }

    public static int romanToInt(String s) {

        Map<Character, Integer> dictionary = new HashMap<>(Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000));
        int thisValue;
        int nextValue;
        int accumulator = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (i == (charArray.length - 1)) {
                accumulator += dictionary.get(charArray[i]);
            } else {
                thisValue = dictionary.get(charArray[i]);
                nextValue = dictionary.get(charArray[i + 1]);
                if (thisValue < nextValue) {
                    accumulator += nextValue - thisValue;
                    i += 1;
                } else {
                    accumulator += thisValue;
                }
            }
        }

        return accumulator;
    }

    public static int romanToIntBest1(String s) {
        int sum = 0, n;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    n = 1;
                    break;
                case 'V':
                    n = 5;
                    break;
                case 'X':
                    n = 10;
                    break;
                case 'L':
                    n = 50;
                    break;
                case 'C':
                    n = 100;
                    break;
                case 'D':
                    n = 500;
                    break;
                default:
                    n = 1000;
            }
            if (4 * n < sum) sum -= n;
            else sum += n;
        }
        return sum;
    }
}


