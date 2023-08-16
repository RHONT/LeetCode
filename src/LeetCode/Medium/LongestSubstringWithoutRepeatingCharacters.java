package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("anviaj"));
        System.out.println(l.lengthOfLongestSubstringBest("anviaj"));
    }

    public int lengthOfLongestSubstring(String s) {
        RangeRemoveSupport<Character> result = new RangeRemoveSupport<>();
        int firstInnerSimbol;
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!result.contains(s.charAt(i))) {
                result.add(s.charAt(i));
            } else {
                maxSize = Math.max(maxSize, result.size());
                firstInnerSimbol = result.indexOf(s.charAt(i));
                result.removeRange(0, firstInnerSimbol + 1);
                result.add(s.charAt(i));
                if ((s.length() - i) + result.size() < maxSize) {
                    break;
                }
            }
        }
        maxSize = Math.max(maxSize, result.size());
        return maxSize;
    }

    static class RangeRemoveSupport<E> extends ArrayList<E> {
        public void removeRange(int fromIndex, int toIndex) {
            super.removeRange(fromIndex, toIndex);
        }

    }

    private int lengthOfLongestSubstringBest(String s) {
        int maxLength = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            int indexSubStrFound = s.indexOf(s.charAt(right), left);
            if (indexSubStrFound != right) {
                left = indexSubStrFound + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


}




