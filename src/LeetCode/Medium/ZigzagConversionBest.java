package LeetCode.Medium;

public class ZigzagConversionBest {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        final int cycleLength = numRows * 2 - 2;
        int cycles = s.length() / cycleLength;
        if (s.length() % cycleLength > 0) {
            cycles++;
        }

        StringBuilder output = new StringBuilder(s.length());

        // Row 1.
        for (int i = 0; i < cycles; i++) {
            int pos = i * cycleLength + 0;
            if (pos < s.length()) {
                output.append(s.charAt(pos));
            }
        }

        // Rows in between.
        for (int row = 1; row < numRows - 1; row++) {
            for (int i = 0; i < cycles; i++) {
                int pos = i * cycleLength + row;
                if (pos < s.length()) {
                    output.append(s.charAt(pos));
                }

                pos = i * cycleLength + cycleLength - row;
                if (pos < s.length()) {
                    output.append(s.charAt(pos));
                }
            }
        }

        // Row N.
        for (int i = 0; i < cycles; i++) {
            int pos = i * cycleLength + numRows - 1;
            if (pos < s.length()) {
                output.append(s.charAt(pos));
            }
        }

        return output.toString();
    }
}
