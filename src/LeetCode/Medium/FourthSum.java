package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 */

public class FourthSum {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        int[] arr2 = new int[]{1, 0, -1, 0, -2, 2};
        FourthSum f = new FourthSum();
//        System.out.println(Arrays.binarySearch(arr1, 0, arr1.length, 6));
        System.out.println(f.fourSum(arr2, 0));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        boolean negative = target < 0;
        Optional<Integer> sumOne;
        Optional<Integer> sumTwo;
        List<List<Integer>> res = new ArrayList<>(4);
        List<Integer> temp = new ArrayList<Integer>(List.of(0, 0, 0, 0));

        Arrays.sort(nums);
        nums = removeExcess(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            temp.set(0, nums[i]);

            for (int j = i + 1; j < nums.length - 2; j++) {

                temp.set(1, nums[j]);
                sumOne = Optional.ofNullable(checkSum(temp.get(0), temp.get(1)));

                if ((sumOne.isEmpty() || (sumOne.get() > target && !negative))) {
                    break;
                }

                for (int k = j + 1; k < nums.length - 1; k++) {
                    temp.set(2, nums[k]);
                    sumTwo = Optional.ofNullable(checkSum(sumOne.get(), temp.get(2)));

                    if (sumTwo.isEmpty() || sumTwo.get() > target && !negative) {
                        break;
                    }

                    int resultInt = searchFourth(nums, k + 1, target, sumTwo.get());

                    if (resultInt >= 0) {
                        temp.set(3, nums[resultInt]);
                        res.add(new ArrayList<>(temp));
                    }
                }

            }
        }

        return res.stream().distinct().collect(Collectors.toList());
    }

    private Integer checkSum(Integer o1, Integer o2) {
        int sumOne;
        try {
            sumOne = Math.addExact(o1, o2);

        } catch (ArithmeticException e) {
            return null;
        }
        return sumOne;
    }

    private int[] removeExcess(int[] nums) {
        int count = 1;

        List<Integer> trueList = new ArrayList<>();
        trueList.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] && count < 4) {
                count++;
                trueList.add(nums[i]);
            } else if (nums[i - 1] != nums[i]) {
                count = 1;
                trueList.add(nums[i]);
            }
        }
        return trueList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int searchFourth(int[] nums, int currentIdx, int target, int sumTwo) {

        int needInt = target - sumTwo;
        return Arrays.binarySearch(nums, currentIdx, nums.length, needInt);

    }


}
