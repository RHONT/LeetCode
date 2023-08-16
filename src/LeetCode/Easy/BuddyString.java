package LeetCode.Easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CRC32;

public class BuddyString {
    public static void main(String[] args) {

        System.out.println(buddyStrings("ab", "ca"));


    }

    public static boolean buddyStrings(String s, String goal) {

        if (!childCase(s, goal)) {
            return false;
        }

        if (s.equals(goal)) {
            return checkDublicatesSimbols(s);
        } else return chekShift(s, goal);
    }

    private static boolean childCase(String s, String goal) {

        if (s == null || goal == null || (s.length() != goal.length()) || s.length() < 2) {
            return false;
        }
        return true;
    }

    private static boolean chekShift(String s, String goal) {
        int left = -1;
        int right = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (left == -1) {
                    left = i;
                } else {
                    right = i;
                    if ((s.charAt(left) != goal.charAt(right)) || (s.charAt(right) != goal.charAt(left))) {
                        return false;
                    }
                    if (i < s.length() - 1) {
                        if (s.substring(i + 1).equals(goal.substring(i + 1))) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkDublicatesSimbols(String str) {

        Set<Character> dictionary = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (dictionary.contains(str.charAt(i))) {
                return true;
            }
            dictionary.add(str.charAt(i));
        }
        return false;
    }
}
