package LeetCode.Hard;

import LeetCode.Medium.ListNode;

public class MergeKSortedListsBest {

    public static void main(String[] args) {
        MergeKSortedListsBest m = new MergeKSortedListsBest();

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

        l7.next = l8;


        ListNode[] test = new ListNode[]{l1, l4, null, null, l7, l9};

        System.out.println("Finish");
        ListNode l10 = m.mergeKLists(test);
        System.out.println("Finish");
        System.out.println(m.factorial(3));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(arr, start, mid);
        ListNode right = mergeKLists(arr, mid + 1, end);

        return merge(left, right);

    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ans.next = list1;
                list1 = list1.next;
            } else {
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }

        ans.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    private int factorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        result = n * factorial(n - 1);
        return result;
    }


}

