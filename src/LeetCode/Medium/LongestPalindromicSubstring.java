package LeetCode.Medium;

import java.util.*;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
//        System.out.println(longestPalindromicSubstring.longestPalindrome("4444616771232112332134511661178187777"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("sbbbbaaaaabbbb"));
//        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa"));


    }

    public String longestPalindrome(String s) {

        if (!checkAtEnglishAndDigit(s) || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }
        return findMaxPalidrom(s);
    }

    private String findMaxPalidrom(String s) {

        List<String> startAndEnd = startOrEndMonotonePalidrom(s);
        List<String> withVertex = withVertexPalidrom(s);
        List<String> withoutVertex = withoutVertex(s);

        List<String> result = new ArrayList<>(startAndEnd);
        result.addAll(withoutVertex);
        result.addAll(withVertex);

        if (result.size() > 1) {
            result.sort(((o1, o2) -> o2.length() - o1.length()));
        } else if (result.size() == 0) {
            result.add(s.substring(0, 1));
        }

        return result.get(0);
    }

    private List<String> withoutVertex(String s) {
        int left;
        int right;
        List<String> result = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                left = i - 1;
                right = i;
                while ((left - 1 >= 0) && (right + 1 <= s.length() - 1)) {
                    if (s.charAt(left - 1) == s.charAt(right + 1)) {
                        right++;
                        left--;
                    } else break;
                }
                result.add(s.substring(left, right + 1));

            }
        }
        return result;
    }

    private List<String> withVertexPalidrom(String s) {
        int left;
        int right;
        List<String> result = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            if (i > 1 && s.charAt(i) == s.charAt(i - 2)) {
                left = i - 2;
                right = i;
                while ((left > 0) && (right < s.length() - 1)) {
                    if (s.charAt(left - 1) == s.charAt(right + 1)) {
                        right++;
                        left--;
                    } else break;

                }
                result.add(s.substring(left, right + 1));
            }
        }

        return result;
    }


    private List<String> startOrEndMonotonePalidrom(String s) {
        List<String> result = new ArrayList<>();
        int left = 1;
        int right = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                right++;
            } else break;
        }
        if (right > 3) {
            result.add(s.substring(0, right));
        }

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                left++;
            } else break;
        }
        if (left > 3) {
            result.add(s.substring(s.length() - left, s.length()));
        }

        if (result.size() > 1) {
            if (result.get(0).equals(result.get(1))) {
                result.remove(1);
            }
        }

        return result;
    }

    private static boolean checkAtEnglishAndDigit(String input) {
        boolean result = false;
        char[] charArray = input.toCharArray();
        for (var c : charArray) {
            result = ((c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9'));
            if (!result) {
                break;
            }
        }
        return result;
    }

}
