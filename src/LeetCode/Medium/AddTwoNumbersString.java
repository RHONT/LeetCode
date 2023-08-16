package LeetCode.Medium;

import java.util.*;
import java.util.Arrays;

//Ввиду больших чисел, придеться складывать столбиком.
public class AddTwoNumbersString {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);


        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);


        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;


//        AddTwoNumbersString addTwoNumbers = new AddTwoNumbersString();
////если символ является не цифрой, то число уже считано и его можно записать в переменную sum
//        System.out.println(readerAndGiveStringBuilder(addTwoNumbers.addTwoNumbers(l1, l4)));


        System.out.println(Arrays.toString(columAddition(new StringBuilder("5"), new StringBuilder("5"))));
        System.out.println(addTwoNumbers(l1, l4));
//        System.out.println(Arrays.toString(concatWithStream(new String[]{"1", "1"}, new String[]{"2", "2"})));


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String[] sum = columAddition(readerAndGiveStringBuilder(l1), readerAndGiveStringBuilder(l2));

        return inputDigitIntoNode(sum);
    }

    private static String[] columAddition(StringBuilder sb1, StringBuilder sb2) {

        String[] small = (sb1.length() <= sb2.length() ? sb1.toString().split("") : sb2.toString().split(""));
        String[] big = (sb1.length() > sb2.length() ? sb1.toString().split("") : sb2.toString().split(""));

        int delta = big.length - small.length;

        if (delta > 0) {
            String[] empty = new String[delta];
            Arrays.fill(empty, "0");
            small = concatWithStream(empty, small);
        }

        int sum;
        int incr = 0;
        String smallElement;
        String bigElement;
        String temp;

        for (int i = big.length - 1; i >= 0; i--) {
            smallElement = small[small.length - 1 - incr];
            bigElement = big[i];

            sum = Integer.parseInt(smallElement) + Integer.parseInt(bigElement);
            incr++;

            if (sum > 9) {
                big[i] = String.valueOf(sum % 10);
                if (i == 0) {
                    big = concatWithStream(new String[]{"1"}, big);
                    break;
                }
                temp = big[i - 1];
                big[i - 1] = String.valueOf(Integer.parseInt(temp) + 1);

            } else {
                big[i] = String.valueOf(sum);

            }
        }

        return big;
    }

    private static StringBuilder readerAndGiveStringBuilder(ListNode listNode) {

        StringBuilder accum = new StringBuilder();
        ListNode temp = listNode;
        while (true) {
            if (temp != null && temp.val >= 0) {
                accum.append(temp.val);
            } else {
                break;
            }
            temp = temp.next;
        }
        return accum.reverse();
    }


    private static ListNode inputDigitIntoNode(String[] sum) {
        List<ListNode> listNodes = new ArrayList<>();
        int quantityNode = sum.length;

        for (int i = 0; i < quantityNode; i++) {
            listNodes.add(new ListNode());
        }

        for (int i = 0; i < quantityNode; i++) {
            listNodes.get(i).val = Integer.parseInt(sum[quantityNode - i - 1]);
            if (i + 1 < quantityNode) {
                listNodes.get(i).next = listNodes.get(i + 1);
            }
        }

        return listNodes.get(0);
    }

    static String[] concatWithStream(String[] array1, String[] array2) {
        String[] result = new String[array1.length + array2.length];

        int len1 = array1.length;
        int len2 = array2.length;

        System.arraycopy(array1, 0, result, 0, len1);
        System.arraycopy(array2, 0, result, len1, len2);

        return result;
    }
}
