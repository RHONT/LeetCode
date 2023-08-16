package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindrom {


    public boolean isPalindrome(int x) {

        if ((x < 0)) {
            return false;
        }
        int[] array = IntToArray(x);
        return checingForPalindrom(array);
    }

    private boolean checingForPalindrom(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private int[] IntToArray(int x) {
        int length = getLengthDigit(x);
        int[] array = new int[length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (x < 10) {
                array[i] = x;
            } else {
                array[i] = x % 10;
                x = x / 10;
            }
        }
        return array;
    }

    private int getLengthDigit(int x) {

        if (x < 100000) {
            if (x < 100) {
                if (x < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (x < 1000) {
                    return 3;
                } else {
                    if (x < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (x < 10000000) {
                if (x < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (x < 100000000) {
                    return 8;
                } else {
                    if (x < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    public boolean isPalindromeBest(int x) {

        if (x < 0) {
            return false;
        }

        int y = x;
        int z = 0;
        while (y > 0) {
            z = z * 10 + y % 10;
            y = y / 10;
        }

        return x == z;
    }


}
