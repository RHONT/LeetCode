package LeetCode.Medium;

import java.util.Arrays;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.print(" -6 = ");
        System.out.println(d.divide(20, -3));

        System.out.print(" -6 = ");
        System.out.println(d.divide(-20, 3));

        System.out.print(" 10 = ");
        System.out.println(d.divide(100, 10));

        System.out.print(" 2 = ");
        System.out.println(d.divide(-5, -2));

        System.out.print(" -2 = ");
        System.out.println(d.divide(7, -3));

        System.out.print(" -1 = ");
        System.out.println(d.divide(-1, 1));

        System.out.print(" 1073741823 = ");
        System.out.println(d.divide(2147483647, 2));

        System.out.print(" -1073741824 = ");
        System.out.println(d.divide(-2147483648, 2));

        System.out.print(" 1 = ");
        System.out.println(d.divide(2, 2));

        System.out.print(" 0 = ");
        System.out.println(d.divide(-1010369383, -2147483648));

        System.out.print(" 0 = ");
        System.out.println(d.divide(100, 200));

        System.out.print(" -1 = ");
        System.out.println(d.divide(-1, 1));

        System.out.print(" 12 = ");
        System.out.println(d.divide(-1021989372, -82778243));

        System.out.print(" 0 = ");
        System.out.println(d.divide(1038925803, -2147483648));

        System.out.print(" -1 = ");
        System.out.println(d.divide(1026117192, -874002063));


    }

    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }

        if (dividend == -2147483648 && divisor == -1) {
            return (2147483647);
        }
        if (dividend == -2147483648 && divisor == 1) {
            return (-2147483648);
        }

        if (dividend < 0 & divisor < 0 & divisor < dividend) {
            return 0;
        }

        if (divisor > 0 & dividend > 0 & divisor > dividend) {
            return 0;
        }


        int remains = 0;

        if (dividend == Integer.MIN_VALUE) {
            dividend += 1;
            remains = -1;
        }

        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }


        int prefiks = (((dividend < 0 & divisor > 0) || (dividend > 0 & divisor < 0)) ? -1 : 1);


        dividend = (dividend < 0) ? -dividend : dividend;
        divisor = (divisor < 0) ? -divisor : divisor;

        if (divisor > dividend) {
            return 0;
        }


        int sizeMemory = calcMemorySize(dividend, divisor);
        int[] memory = fillMemory(divisor, sizeMemory);

        return calcResult(memory, prefiks, dividend, divisor, remains);
    }

    private int calcMemorySize(int dividend, int divisor) {
        int lengthDividend = String.valueOf(dividend).length();
        int lengthDivisor = String.valueOf(divisor).length();
        int result = lengthDividend - lengthDivisor + 1;
        if (result > 5) {
            return result + 3072;
        }
        if (result > 4) {
            return result + 1536;
        }
        if (result > 3) {
            return result + 1024;
        }
        if (result > 2) {
            return result + 5;
        }
        return result;

    }

    private int calcResult(int[] memory, int prefiks, int dividend, int divisor, int remains) {
        int result = 0;

        if (divisor == 1) {
            return prefiks < 0 ? -dividend : dividend;
        }

        if (divisor == dividend) {
            return prefiks < 0 ? -1 : 1;
        }

        if (remains == -1) {
            dividend -= memory[memory.length - 1];
            dividend += 1;
            result += memory.length;
        }

        for (; dividend > divisor; ) {
            for (int j = memory.length - 1; j >= 0; j--) {
                for (; memory[j] <= dividend; ) {
                    result += j + 1;
                    dividend -= memory[j];
                }
            }
        }
        return prefiks < 0 ? -result : result;
    }

    private int[] fillMemory(int divisor, int sizeMemory) {
        int[] memory = new int[sizeMemory];
        int accuum = 0;
        for (int i = 0; i < memory.length; i++) {
            accuum += divisor;
            memory[i] += accuum;
        }
        return memory;
    }
}
