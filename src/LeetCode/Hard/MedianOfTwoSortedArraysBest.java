package LeetCode.Hard;

import java.util.Arrays;

public class MedianOfTwoSortedArraysBest {
    public static void main(String[] args) {
        MedianOfTwoSortedArraysBest m = new MedianOfTwoSortedArraysBest();
        System.out.println(m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(m.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size1 = nums1.length + nums2.length;
        int[] nums3 = new int[size1];
        int index = 0;
        double median = 0;
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[index] = nums1[i];
                i++;
                index++;
            } else {
                nums3[index] = nums2[j];
                index++;
                j++;
            }
        }

        if (i < nums1.length) {
            while (i < nums1.length) {
                nums3[index] = nums1[i];
                i++;
                index++;
            }
        }
        if (j < nums2.length) {
            while (j < nums2.length) {
                nums3[index] = nums2[j];
                j++;
                index++;
            }
        }
        int middle = nums3.length / 2;

        if (nums3.length % 2 == 0) {

            median = (double) (nums3[middle] + nums3[middle - 1]) / 2;
        } else {
            median = (double) nums3[middle];
        }

        return median;
    }
}
