package LeetCode.Easy;

public class LongestCommonPrefixBest {

    public static void main(String[] args) {
        LongestCommonPrefixBest ln = new LongestCommonPrefixBest();
        String[] test = new String[]{"lana", "lasha", "lararara"};
        System.out.println(ln.longestCommonPrefix(test));
    }


    public String longestCommonPrefix(String[] strs) {
        //find the shortest str in strs
        int shortestLen = Integer.MAX_VALUE;
        for (String str : strs) {//O(n)
            shortestLen = Math.min(shortestLen, str.length());
        }
        int i = 0;
        for (; i < shortestLen; i++) {
            char c = strs[0].charAt(i);
            for (int k = 1; k < strs.length; k++) {
                if (c != strs[k].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }

        }
        return strs[0].substring(0, i);

    }

}
