package LeetCode.Hard;

import java.util.Arrays;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        System.out.println(m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(m.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = sumArray(nums1, nums2);
        Arrays.sort(result);
        int remains = result.length % 2;
        int avg = result.length / 2;
        if (remains == 0) {
            return (double) (result[avg - 1] + result[avg]) / 2;
        } else return (double) (result[avg]);

    }

    static int[] sumArray(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        int len1 = array1.length;
        int len2 = array2.length;

        System.arraycopy(array1, 0, result, 0, len1);
        System.arraycopy(array2, 0, result, len1, len2);

        return result;
    }
}
