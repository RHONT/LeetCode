package LeetCode.Hard;

import java.util.*;

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("()(()"));
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses(")())"));
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("(()()"));
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("((())"));
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("()"));
//
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("(()"));
//
//        System.out.print(" 2=");
//        System.out.println(test.longestValidParentheses("())))"));
//
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("()()(()()"));
//
//        System.out.print(" 4=");
//        System.out.println(test.longestValidParentheses("()())()()"));
//
//        System.out.print(" 6=");
//        System.out.println(test.longestValidParentheses("(()())"));
//
//        System.out.print(" 8=");
//        System.out.println(test.longestValidParentheses("((()))())"));
//
//        System.out.print(" 22=");
//        System.out.println(test.longestValidParentheses(")(((((()())()()))()(()))("));

        System.out.print(" 4=");
        System.out.println(test.longestValidParentheses("(()))())("));

        System.out.print(" 4=");
        System.out.println(test.longestValidParentheses("(())(()"));

        System.out.print(" 6=");
        System.out.println(test.longestValidParentheses(")(())))(())())"));

        System.out.print(" 0=");
        System.out.println(test.longestValidParentheses("((((((("));
        System.out.print(" 0=");
        System.out.println(test.longestValidParentheses(")))))))))"));

        System.out.print(" 6=");
        System.out.println(test.longestValidParentheses("()(((()())(()"));

        System.out.print(" 132=");
        System.out.println(test.longestValidParentheses(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
        System.out.print(" 134=");
        System.out.println(test.longestValidParentheses(")(()))()(())()()()()(()(()))()())(()()(())()(((()()(()((()(()()((()()))(())())(()(())(()(())(()(()))(()))()()(((()())(()()(()((())))))(()(()())(()))))))())))()())()(())(((()(()))()()(()(((()))()"));

        System.out.print(" 14=");
        System.out.println(test.longestValidParentheses("())(()(())(()(())(()(()))"));

    }


    public int longestValidParentheses(String s) {

        int[] array = convertAndRemoveEdges(new int[s.length()], s);
        if (isValidBest(array)) {
            return array.length;
        }

        return findMaxVailid(array);

    }


    private int findMaxVailid(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        int tempSumm = 0;

        List<Integer> resultList = new ArrayList<>();
        if (array.length < 2) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 & sumRight == 0) {
                resultList.add(tempSumm);
                tempSumm = 0;

                int[] current = Arrays.copyOfRange(array, i + 1, array.length);
                int open = Arrays.stream(Arrays.copyOfRange(array, i + 1, array.length)).sum();
                int closed = (int) Arrays.stream(Arrays.copyOfRange(array, i + 1, array.length)).filter(o -> o == 0).count();
                int[] temp = deleteOpen(Arrays.copyOfRange(array, i + 1, array.length), open, closed);
                if (current.length > temp.length) {
                    i += current.length - temp.length;
                }

            } else {

                if (array[i] == 1) {
                    sumRight++;

                } else if (array[i] == 0) {
                    sumLeft++;
                    if (sumLeft <= sumRight) {
                        tempSumm += 2;
                        sumRight--;
                        sumLeft--;
                    }
                    if (sumLeft == 0 & sumRight == 0) {
                        int[] current = Arrays.copyOfRange(array, i + 1, array.length);
                        int open = Arrays.stream(Arrays.copyOfRange(array, i + 1, array.length)).sum();
                        int closed = (int) Arrays.
                                stream(Arrays.copyOfRange(array, i + 1, array.length)).
                                filter(o -> o == 0).count();
                        int[] temp = deleteOpen(Arrays.copyOfRange(array, i + 1, array.length), open, closed);
                        if (current.length > temp.length) {
                            i += current.length - temp.length;
                            resultList.add(tempSumm);
                            tempSumm = 0;
                        }
                    }
                }

            }

        }
        resultList.add(tempSumm);

        return resultList.stream().max(Comparator.naturalOrder()).orElse(0);
    }


    private int[] convertAndRemoveEdges(int[] array, String s) {

        if (s.length() < 2) {
            return new int[0];
        }

        int open = 0;
        int closed = 0;
        int left = 0;
        int right = array.length;

        fillArray(array, s);
        right = findRightPosForDel(array);
        left = findLeftPosForDel(array);


        int[] clearArray = Arrays.copyOfRange(array, left, right + 1);
        open = Arrays.stream(clearArray).sum();
        closed = (int) Arrays.stream(clearArray).filter(o -> o == 0).count();


        if (open > closed) {
            int[] temp = deleteOpen(clearArray, open, closed);
            return temp;
        }

        if (open < closed) {
            int[] temp = deleteClosed(clearArray, open, closed);
            return temp;
        }

        return clearArray;
    }

    private int findLeftPosForDel(int[] array) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                return i;
            }
        }
        return i;
    }

    private int findRightPosForDel(int[] array) {
        int i;
        for (i = array.length - 1; i >= 0; i--) {
            if (array[i] == 0) {
                return i;
            }
        }
        return i;
    }

    private void fillArray(int[] array, String s) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (s.charAt(i) == '(' ? 1 : 0);
        }
    }

    private int[] deleteClosed(int[] firstArray, int open, int closed) {
        int indexEnd = 0;
        int tempOpen = open;
        int tempClose = closed;
        int raznica = closed - open;
        int accum = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (tempClose == raznica) {
                indexEnd = i;
                break;
            }
            if (firstArray[i] == 1 & tempClose > 0) {
                accum++;
                tempOpen--;
            } else {
                if (accum > 0) {
                    tempClose--;
                    accum--;
                }
            }
            indexEnd = i + 1;
        }

        return Arrays.copyOfRange(firstArray, 0, indexEnd);
    }

    private int[] deleteOpen(int[] firstArray, int open, int closed) {
        int indexStart = 0;
        int tempOpen = open;
        int tempClose = closed;
        int raznica = open - closed;
        int accum = 0;
        for (int i = firstArray.length - 1; i >= 0; i--) {
            if (tempOpen == raznica) {
                indexStart = i + 1;
                break;
            }
            if (firstArray[i] == 0 & tempClose > 0) {
                accum++;
                tempClose--;
            } else {
                if (accum > 0) {
                    tempOpen--;
                    accum--;

                }
            }
            indexStart = i;
        }

        return Arrays.copyOfRange(firstArray, indexStart, firstArray.length);
    }


    public boolean isValidBest(int[] input) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (var c : input) {
            if (c == 1)
                stack.push(0);
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
