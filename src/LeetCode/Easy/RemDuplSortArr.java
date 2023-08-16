package LeetCode.Easy;

//  0 0 1 1 3 3 3
public class RemDuplSortArr {
    public static void main(String[] args) {
        RemDuplSortArr r = new RemDuplSortArr();
        int[] test = new int[]{1, 1, 1, 1, 1, 2, 2, 4, 5, 5, 5, 8};
        System.out.println(r.removeDuplicatesBest(test));
        System.out.println();
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        sortWithoutDuplicates(nums);
        return findQuantityDuplicates(nums);

    }

    private void sortWithoutDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[j];
                    nums[j] = temp;

                    break;
                }

            }
        }
    }

    private int findQuantityDuplicates(int[] nums) {
        int counter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                counter = i;
                break;
            }
        }
        if (counter == 0) {
            counter = nums.length;
        }
        return counter;
    }

    public int removeDuplicatesBest(int[] nums) {
        int curNum = nums[0];
        int curPos = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != curNum) {
                curNum = nums[index];
                nums[curPos++] = nums[index];
            }
        }
        return curPos;
    }
}
