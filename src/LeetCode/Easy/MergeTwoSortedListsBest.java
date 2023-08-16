package LeetCode.Easy;

import LeetCode.Medium.ListNode;

public class MergeTwoSortedListsBest {

    public static void main(String[] args) {
        ListNode firstLN = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);

        ListNode secondLN = new ListNode(1);
        ListNode l6 = new ListNode(3);
        ListNode l8 = new ListNode(4);


        firstLN.next = l2;
        l2.next = l3;
        l3.next = l4;

        secondLN.next = l6;
        l6.next = l8;


//        ListNode result = new ListNode();
//        result = firstLN;
//        result = result.next;
//        result.val = 100;
        MergeTwoSortedListsBest m = new MergeTwoSortedListsBest();
        ListNode test = m.mergeTwoLists(firstLN, secondLN);
        System.out.println("stop program");


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temphead = new ListNode();
        ListNode tail = temphead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;
        return temphead.next;
    }

}
