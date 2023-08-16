package LeetCode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class SortColors {

    private Map<Integer, Integer> colors;
    private int currentIdx = 0;

    public static void main(String[] args) {
        SortColors s = new SortColors();
        s.sortColors(new int[]{0, 1, 0, 0, 1, 1, 0, 0, 2, 2});
    }

    public void sortColors(int[] nums) {

        setColors(0, 1, 2);
        sortModule(nums, colors);

    }

    private void sortModule(int[] nums, Map<Integer, Integer> colors) {
        fillColors(nums, colors);
        rewriteInputArr(nums, colors);
    }

    private void rewriteInputArr(int[] nums, Map<Integer, Integer> colors) {
        for (var element : colors.entrySet()) {
            Arrays.fill(nums, currentIdx, currentIdx + element.getValue(), element.getKey());
            currentIdx += element.getValue();
        }
    }

    private void fillColors(int[] nums, Map<Integer, Integer> colors) {
        for (int i = 0; i < nums.length; i++) {
            colors.put(nums[i], colors.get(nums[i]) + 1);
        }
    }

    public void setColors(int... colors) {
        this.colors = new TreeMap<>();
        for (var element : colors) {
            this.colors.put(element, 0);
        }
    }
}
