package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstringOptimization {
    private List<String> tempResult = new ArrayList<>();
    private int left;
    private int right;

    public static void main(String[] args) {
        LongestPalindromicSubstringOptimization LongestPalindromicSubstringOptimization = new LongestPalindromicSubstringOptimization();
//        System.out.println(longestPalindromicSubstring.longestPalindrome("4444616771232112332134511661178187777"));
        System.out.println(LongestPalindromicSubstringOptimization.longestPalindrome("asd"));
//        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa"));


    }

    public String longestPalindrome(String s) {

        if (s.length() == 1 || childCase(s)) {
            return s;
        }


        return findMaxPalindrome(s);
    }

    private boolean childCase(String s) {
        StringBuilder leftPart = new StringBuilder();
        StringBuilder rightPart = new StringBuilder();
        tempResult.clear();

        if (s.length() % 2 == 1) {
            leftPart.append(s, 0, s.length() / 2);
            rightPart.append(s.substring(s.length() / 2 + 1));
            if (leftPart.toString().equals(rightPart.reverse().toString())) {
                return true;
            }
        } else {
            leftPart.append(s, 0, s.length() / 2);
            rightPart.append(s.substring(s.length() / 2));
            if (leftPart.toString().equals(rightPart.reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    private String findMaxPalindrome(String s) {
        List<String> startAndEnd = startOrEndMonotonePalindrome(s);
        if (!startAndEnd.isEmpty() && startAndEnd.get(0).length() > s.length() / 2) {
            return startAndEnd.get(0);
        }
        List<String> result = new ArrayList<>(startAndEnd);

        List<String> withVertexList = withVertexPalindrome(s);
        if (!withVertexList.isEmpty() && withVertexList.get(0).length() == s.length()) {
            return withVertexList.get(0);
        }
        result.addAll(withVertexList);

        List<String> withoutVertexList = withoutVertex(s);

        result.addAll(withoutVertexList);


        if (result.size() > 1) {
            result.sort(((o1, o2) -> o2.length() - o1.length()));
        } else if (result.size() == 0) {
            result.add(s.substring(0, 1));
        }

        return result.get(0);
    }

    private List<String> withoutVertex(String s) {
        tempResult.clear();

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
                tempResult.add(s.substring(left, right + 1));

            }
        }
        return tempResult;
    }

    private List<String> withVertexPalindrome(String s) {
        tempResult.clear();

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
                tempResult.add(s.substring(left, right + 1));
            }
        }

        return tempResult;
    }


    private List<String> startOrEndMonotonePalindrome(String s) {
        tempResult.clear();
        left = 1;
        right = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                right++;
            } else break;
        }
        if (right > 1) {
            tempResult.add(s.substring(0, right));
        }

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                left++;
            } else break;
        }
        if (left > 1) {
            tempResult.add(s.substring(s.length() - left));
        }

        if (tempResult.size() > 1) {
            if (tempResult.get(0).equals(tempResult.get(1))) {
                tempResult.remove(1);
            } else {
                tempResult.sort(((o1, o2) -> o2.length() - o1.length()));
            }
        }
        return tempResult;
    }

}
