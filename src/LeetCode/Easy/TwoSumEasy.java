package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumEasy {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
//        System.out.println(Arrays.toString(twoSumBest(new int[]{3, 3, 3}, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        boolean exit = false;
        int[] result = new int[2];
        int hiLine;

        while (!exit) {
            for (int i = 0; i < nums.length; i++) {
                hiLine = target - nums[i];

                for (int j = i + 1; j < nums.length; j++) {

                    if (nums[j] == hiLine) {
                        result[0] = i;
                        result[1] = j;
                        exit = true;
                        break;
                    }
                }
                if (exit) {
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSumBest(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[]{numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[]{};
    }
}
