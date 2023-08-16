package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

// 1994
// 1000
//900
//90
//4
//M CM XC IV

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();


        System.out.println(integerToRoman.intToRoman(3999));
    }


    public String intToRoman(int num) {
        List<Integer> innerArray = new ArrayList<>();
        giveArrayDigit(num, innerArray);

        return assembling(innerArray);

    }

    private int giveArrayDigit(int numb, List<Integer> arrayDigit) {
        if (numb < 10) {
            arrayDigit.add(numb);
            return numb;
        }
        int temp = giveArrayDigit(numb / 10, arrayDigit);
        arrayDigit.add(numb % 10);
        return temp;
    }

    private String findRomanByIndex(int index, int value) {

        switch (index) {
            case 3:
                return getRoman("I", "V", "X", value);
            case 2:
                return getRoman("X", "L", "C", value);
            case 1:
                return getRoman("C", "D", "M", value);
            case 0:
                return getRoman("M", "", "", value);
            default:
                return "";
        }
    }

    private String getRoman(String begin, String middle, String end, int value) {
        if (value < 4) {
            return begin.repeat(value);
        }
        if (value == 4) {
            return begin.concat(middle);
        }
        if (value == 5) {
            return middle;
        }
        if (value < 9) {
            return middle.concat(begin.repeat(value - 5));
        }
        if (value == 9) {
            return begin.concat(end);
        }

        return "null";
    }

    private String assembling(List<Integer> array) {
        int[] tempArray = new int[4];
        StringBuilder accumResult = new StringBuilder();
        int incr = 3;

        for (int i = array.size() - 1; i >= 0; i--) {
            tempArray[incr] = array.get(i);
            incr--;
        }

        for (int i = 0; i < tempArray.length; i++) {
            accumResult.append(findRomanByIndex(i, tempArray[i]));
        }
        return accumResult.toString();
    }

}
