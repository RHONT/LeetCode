package LeetCode.Hard;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

// Найти первое пропущенное положительное число в неотсортированном массиве.
public class FirstMissingPositive {
    public static void main(String[] args) {

        FirstMissingPositive f = new FirstMissingPositive();
        System.out.print("2 = ");
        System.out.println(f.firstMissingPositive(new int[]{1, 1, 1, 1, 4}));
        System.out.print("1 = ");
        System.out.println(f.firstMissingPositive(new int[]{0, -2, 0, -5, 4}));
        System.out.print("1 = ");
        System.out.println(f.firstMissingPositive(new int[]{-5, -2, 0, -6, -4}));


    }

    // Thanks btw_cool
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        int[] resultArray = new int[j];
        Arrays.fill(resultArray, 1);

        for (int i = 0; i < resultArray.length; i++) {
            int idx = nums[i] - 1;
            if (idx < j && resultArray[idx] > 0) {
                resultArray[idx] = -resultArray[idx];
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] > 0) {
                return i + 1;
            }
        }
        return j + 1;
    }
}
