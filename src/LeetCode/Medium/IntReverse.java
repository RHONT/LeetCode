package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntReverse {
    public static void main(String[] args) {
        IntReverse in = new IntReverse();
        System.out.println(in.reverse(1563847412));

    }

    public int reverse(int x) {

        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        int minus = (x < 0 ? -1 : 1);
        int[] intsArray = new int[(int) (Math.log10(Math.abs(x)) + 1)];
        giveArrayReversDigit(Math.abs(x), 0, intsArray);

        if (!checkWrong(intsArray)) {
            return 0;
        }
        return giveNumber(minus, intsArray);
    }

    private boolean checkWrong(int[] intsArray) {
        if (intsArray.length == 10) {
            if (intsArray[0] > 2 && intsArray[1] > 1) {
                return false;
            }
        }
        return true;
    }

    private int giveNumber(int minus, int[] intsArray) {

        int increase = 1;
        int sum = 0;
        int temp;

        for (int i = intsArray.length - 1; i >= 0; i--) {
            temp = intsArray[i] * increase + sum;
            if (temp < sum) {
                return 0;
            } else {
                sum += intsArray[i] * increase;
                increase *= 10;
            }

        }

        return sum * minus;
    }


    private void giveArrayReversDigit(int numb, int index, int[] empty) {
        if (numb < 10) {
            empty[index] = numb;
            return;
        }
        empty[index] = numb % 10;
        giveArrayReversDigit(numb / 10, index + 1, empty);
    }
}
