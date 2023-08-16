package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZigzagConversion {

    private int marker = 0;

    public static void main(String[] args) {

        ZigzagConversion z = new ZigzagConversion();
        System.out.println(z.convert("AB", 1));
    }


    public String convert(String s, int numRows) {
        if (numRows >= s.length() || numRows == 1 || numRows == 0) {
            return s;
        }
        if (s.equals("")) {
            return "";
        }

        List<StringBuilder> charsArray = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            charsArray.add(new StringBuilder());
        }


        for (; marker < s.length(); ) {

            down(charsArray, numRows, s);
            up(charsArray, numRows, s);
        }

        marker = 0;

        return String.join("", charsArray);
    }

    private void down(List<StringBuilder> charsArray, int numRows, String s) {
        for (int i = 0; i < numRows - 1; i++) {
            charsArray.get(i).append(s.charAt(marker));
            marker++;
            if (marker == s.length()) {
                break;
            }
        }
    }

    private void up(List<StringBuilder> charsArray, int numRows, String s) {
        if (marker == s.length()) {
            return;
        }

        for (int i = numRows - 1; i >= 1; i--) {
            charsArray.get(i).append(s.charAt(marker));
            marker++;
            if (marker == s.length()) {
                break;
            }
        }
    }

}
