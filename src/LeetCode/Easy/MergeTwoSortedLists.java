package LeetCode.Easy;

import LeetCode.Medium.ListNode;

public class MergeTwoSortedLists {
    static boolean stop = false;
    static ListNode innerResult = new ListNode();

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
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode test = m.mergeTwoLists(firstLN, secondLN);
        System.out.println("stop program");


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode innerList1 = list1;
        ListNode innerList2 = list2;

        while (innerList1 != null || innerList2 != null) {

            if (innerList1 == null) {
                addAllNode(result, innerList2);
                break;
            }

            if (innerList2 == null) {
                addAllNode(result, innerList1);
                break;
            }

            if (innerList1.val <= innerList2.val) {
                addNode(result, innerList1);
                innerList1 = innerList1.next;

            } else {
                addNode(result, innerList2);
                innerList2 = innerList2.next;

            }
        }

        return result.next;
    }

    private static void addAllNode(ListNode result, ListNode allNodes) {
        stop = false;
        innerResult = result;

        while (!stop) {
            if (innerResult.next == null) {
                innerResult.next = allNodes;
                stop = true;
            } else innerResult = innerResult.next;
        }
    }

    private static void addNode(ListNode result, ListNode addedNodeList) {
        stop = false;
        innerResult = result;

        while (!stop) {
            if (innerResult.next == null) {
                innerResult.next = new ListNode(addedNodeList.val);
                stop = true;
            } else innerResult = innerResult.next;
        }
    }
}
