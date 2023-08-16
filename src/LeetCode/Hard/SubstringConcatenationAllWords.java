package LeetCode.Hard;

import java.util.*;

public class SubstringConcatenationAllWords {
    public static void main(String[] args) {
        SubstringConcatenationAllWords s = new SubstringConcatenationAllWords();
        System.out.println(s.findSubstringBest("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
//        System.out.println(s.findSubstringBest("aaaaaaaaaaaaaa", new String[]{"aa", "aa"}));
    }

    public List<Integer> findSubstringBest(String s, String[] words) {
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        Map<String, Integer> hash = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        char[] s2 = s.toCharArray();
        // создание каркаса и мапы к нему.
        for (String value : words) {
            hash.putIfAbsent(value, hash.size());
        }

        int[] count = new int[hash.size()];
        for (String word : words) {
            count[hash.get(word)]++;
        }

        for (int i = 0; i < wordLength; i++) {
            for (int j = i; j <= s.length() - totalWordsLength; j += wordLength) {
                int[] localCount = new int[hash.size()];
                for (int k = j + totalWordsLength - wordLength; k >= j; k -= wordLength) {
                    String str = new String(s2, k, wordLength);     // [ k, k+wordLength )
                    Integer key = hash.get(str);

                    if (!(key != null && count[key] >= ++localCount[key])) {
                        j = k;
                        break;
                    }
                    if (j == k) {
                        ans.add(j);
                    }
                }
            }
        }
        return ans;
    }


    public List<Integer> findSubstring(String s, String[] words) {

        int count = words.length;
        int lengthStr = count * words[0].length();
        int endIndex = s.length() - lengthStr;
        int part = words[0].length();
        List<String> inputList = new ArrayList<>(Arrays.asList(words));
        Collections.sort(inputList);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < endIndex + 1; ) {
            if (inputList.contains(s.substring(i, i + part))) {
                String tryStr = s.substring(i, i + lengthStr);
                boolean test = splitString(tryStr, inputList, part);
                if (test) {
                    result.add(i);
                }
            }
            i++;
        }
        return result;
    }

    private boolean splitString(String s, List<String> input, int part) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            result.add(s.substring(i, i + part));
            i += part;
        }

        Collections.sort(result);
        return input.equals(result);
    }
}
