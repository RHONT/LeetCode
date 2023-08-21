package LeetCode.Easy;

// Задача добраться до последнего индекса
// суть - накапливаю temp и с каждым ходом переменная тает,
// если встречает большее или равное значение, подпитывается и живет дальше

public class CanJump {

    public static void main(String[] args) {
        int[] jump={5,0,0,0,0,0,4};
        int[] jump2={1,1,1,0};
        int[] jump3={ 1,1,2,2,0,1,1};
        CanJump runJump=new CanJump();
        System.out.println(runJump.canJump(jump));
        System.out.println(runJump.canJump(jump2));
        System.out.println(runJump.canJump(jump3));

    }

    public boolean canJump(int[] nums) {
        int temp=0;
        boolean endGame=false;
        for (int i = 0; i < nums.length ; i++) {
            if (endGame) {
                return false;
            }

            if (temp!=0 && temp>nums[i]) {
                temp--;
            }

            if (temp<nums[i]) {
                temp = nums[i];
            }

            if (i== nums.length-1) {
                return true;
            }

            if (temp==0) {
                endGame=true;
            }

        }
        return true;
    }
}
