package LeetCode.Medium;

public class StringToIntegerAtoi {
    public static void main(String[] args) {

        StringToIntegerAtoi strr = new StringToIntegerAtoi();
        System.out.println(strr.myAtoiBest("       asd-143sdsd"));
    }

    private int integer(char c) { // ловкое преобразование типа, без применения класса обертки
        return c - '0';
    }

    public int myAtoiBest(String s) {
        int i = 0, n = s.length(), sign = 1;
        while (i < n && s.charAt(i) == ' ') i++;  // while пропустил все пробелы. Причем i отстегиваеться.
        // так ж тут ожибка не идет проверка не не числа после пробела

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) { // ищем первое вхождение знака, и сразу же i++
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        long res = 0;
        while (i < n) {     // отсчет идет не сначала, а с последнего i
            char c = s.charAt(i++);
            if (!Character.isDigit(c)) break;  // если следующий знак не число, сразу ломаем ,а результат уже 0!
            int val = integer(c);
            res = (res * 10) + val; // очень классно с конца идет преобразование строки в число
            if (sign == -1 && res > (long) Integer.MAX_VALUE + 1)
                res = (long) Integer.MAX_VALUE + 1; // мы не допускаем разрастания числа.
            if (sign == 1 && res > Integer.MAX_VALUE)
                res = Integer.MAX_VALUE;                // постоянное его возвращаем к максимальному значению инта
        }
        return sign * (int) res;
    }


    public int myAtoi(String s) {
        s = s.trim();
        char[] sign = findSignAndLeftPositionDigit(s);
        String rowResult = findDigits(sign, s);

        return checkDigits(rowResult);
    }

    private String findDigits(char[] sign, String s) {
        if (sign[0] == '0') {
            return "0";
        }

        StringBuilder accum = new StringBuilder();
        accum.append(sign[0]);
        int start = Character.digit(sign[1], 10);

        for (int i = start; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                accum.append(s.charAt(i));
            } else {
                break;
            }
        }
        return accum.toString();
    }


    private int checkDigits(String rowResult) {

        double result = Double.parseDouble(rowResult);

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    private char[] findSignAndLeftPositionDigit(String s) {

        char[] sign = new char[]{'0', '0'};

        if (s.length() == 0) {
            return sign;
        }
        if (s.length() == 1 & !Character.isDigit(s.charAt(0))) {
            return sign;
        }

        if (Character.isDigit(s.charAt(0))) {
            sign[0] = '+';
            return sign;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 43 || s.charAt(i) == 45) {
                    if (sign[0] == '0') {
                        sign[0] = s.charAt(i);
                        if (i < s.length() - 1) {
                            if (!Character.isDigit(s.charAt(i + 1))) {
                                sign[0] = '0';
                                return sign;
                            } else {
                                sign[1] = (char) (i + 1 + '0');
                                break;
                            }
                        }
                    }

                }

            }

        }

        return sign;
    }

}
