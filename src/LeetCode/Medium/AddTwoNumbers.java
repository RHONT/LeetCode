package LeetCode.Medium;

import java.util.*;

public class AddTwoNumbers {


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

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        System.out.println(readerAndGiveLong(addTwoNumbers.addTwoNumbers(l1, l4)));


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long sum = readerAndGiveLong(l1) + readerAndGiveLong(l2);

        return inputDigitIntoNode(sum);
    }

    private static long readerAndGiveLong(ListNode listNode) {

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
        return Long.parseLong(accum.reverse().toString());
    }


    private static ListNode inputDigitIntoNode(long sum) {
        List<ListNode> listNodes = new ArrayList<>();
        int QuantityNode = String.valueOf(sum).length();

        for (int i = 0; i < QuantityNode; i++) {
            listNodes.add(new ListNode());
        }

        for (int i = 0; i < QuantityNode; i++) {
            listNodes.get(i).val = (int) (sum % 10);
            if (i + 1 < QuantityNode) {
                listNodes.get(i).next = listNodes.get(i + 1);
            }
            sum = sum / 10;
        }

        return listNodes.get(0);
    }


}
