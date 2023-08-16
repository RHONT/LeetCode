package LeetCode.Hard;

import LeetCode.Medium.ListNode;
import org.w3c.dom.NodeList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists m = new MergeKSortedLists();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(5);

        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);


        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        ListNode[] test = new ListNode[]{l1, null, null, l4};

        System.out.println("Finish");
        ListNode l10 = m.mergeKLists(test);
        System.out.println("Finish");


    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length < 2) {
            return lists[0];
        } else {
            for (int i = 1; i < lists.length; i++) {
                lists[0] = mergeTwoListNode(lists[0], lists[i]);
            }
        }

        return lists[0];
    }


    private ListNode mergeTwoListNode(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode tail = result;

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return result.next;
    }

}
