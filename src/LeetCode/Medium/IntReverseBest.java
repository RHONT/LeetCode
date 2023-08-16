package LeetCode.Medium;

// Внимательно рассмотреть!
public class IntReverseBest {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                // result will overflow if another digit is added
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                // result will underflow if another digit is added
                return 0;
            }
            result = result * 10 + digit;
            x /= 10;
        }
        return result;
    }

}
