package LeetCode.Easy;

public class LongestCommonPrefix {


    public static void main(String[] args) {
        LongestCommonPrefix ln = new LongestCommonPrefix();
        String[] test = new String[]{"ab", "a"};
        System.out.println(ln.longestCommonPrefix(test));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs[0].equals("")) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        int count = 0;

        while (!recursive(strs, 0, count).equals("")) {

            result = result.concat(strs[0].substring(count, count + 1));

            count++;
        }


        return result;
    }

    public String recursive(String[] strs, int end, int beginChar) {

        if (beginChar >= strs[end].length()) {
            return "";
        }

        String Compared;

        if (end == strs.length - 1) {
            Compared = strs[end].substring(beginChar, beginChar + 1);
            return Compared;
        }

        Compared = strs[end].substring(beginChar, beginChar + 1);
        String temp = recursive(strs, end + 1, beginChar);
        if (temp.equals(Compared)) {
            return temp;
        } else return "";

    }

}
