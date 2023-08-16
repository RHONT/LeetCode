package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] newArr;
        newArr = ii.insert(new int[][]{{2, 4}, {7, 8}, {11, 12}, {45, 50}}, new int[]{-5, 3});
//        newArr = ii.insertinArray(3, new int[][]{{2, 4}, {6, 8}, {10, 12}, {15, 40}}, new int[]{1, 100});


        for (var element : newArr) {
            System.out.println(Arrays.toString(element));
        }


    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int posDirection = checkStartEnd(intervals, newInterval);
        if (posDirection == -1 || posDirection == -2) {
            return insertinArray(posDirection, intervals, newInterval);
        }

        return findNewIntervals(intervals, newInterval);

    }

    private int[][] findNewIntervals(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int passIdx = 0;
        boolean startOn = false;
        boolean EndOn = false;


        for (int i = 0; i < intervals.length - 1; i++) {
            if (!startOn) {
                int[] response = giveNewStartPosition(intervals[i], intervals[i + 1], newInterval, i);
                if (response[0] == -1) {
                    continue;
                }
                if (response[0] == 0) {
                    return intervals;
                }
                if (response[0] == 1) {
                    return insertinArray(i + 1, intervals, newInterval);
                }
                if (response[0] == 2) {
                    intervals[i] = new int[]{intervals[i][0], newInterval[1]};
                    return intervals;
                }

                if (response[0] == 3) {
                    intervals[i + 1] = new int[]{newInterval[0], intervals[i + 1][1]};
                    return intervals;
                }


                if (response[0] == 4) {
                    intervals[i] = new int[]{intervals[i][0], intervals[i + 1][1]};
                    int[][] ints = new int[intervals.length - 1][];
                    int raznica = intervals.length - (i + 2);
                    System.arraycopy(intervals, 0, ints, 0, i + 1);
                    System.arraycopy(intervals, i + 2, ints, i + 1, raznica);
                    return ints;
                }

                if (response[0] == 5) {
                    startOn = true;

                }


            }

        }

        return intervals;
    }

    /**
     * respose[]
     * [0]
     * -1 (нет вхождения)
     * 0 (новый интервал входи в уже существующие, массив остается неизменным)
     * 1 (новый интервал находитьс между текущими массивами, требуется запустить метод insertinArray)
     * 2 (Расширить первый массив, включив в него новый)
     * 3 (расширить второй массив, вклюив в него новый)
     * 4 (объеденить два массива в один)
     * 5 (возвращаем индекс старта и идем искать конец вдаль.)
     */

    private int[] giveNewStartPosition(int[] current, int[] next, int[] emergent, int i) {
        int[] response = new int[]{-1, 0, 0};
        if (emergent[0] > current[0] && emergent[0] > current[1] && emergent[0] > next[0] && emergent[0] > next[1]) {
            return response;
        }
        if (entryCheck(current, emergent) || entryCheck(next, emergent)) {
            response[0] = 0;
            return response; //0
        }
        if (entryBetween(current, next, emergent)) {
            response[0] = 1;
            return response;
        }

        if (emergent[0] >= current[0] && emergent[0] <= current[1] && emergent[1] < next[0]) {
            response[0] = 2;
            return response;
        }

        if (emergent[0] > current[1] && emergent[1] >= next[0] && emergent[1] <= next[1]) {
            response[0] = 3;
            return response;
        }

        if (emergent[0] >= current[0] && emergent[1] <= next[1]) {
            response[0] = 4;
            return response;
        }


        return response;
    }

    private int[][] insertinArray(int posDirection, int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][2];
        if (posDirection == -1) {
            System.arraycopy(intervals, 0, newArr, 0, intervals.length);
            newArr[intervals.length] = newInterval;
        } else if (posDirection == -2) {
            System.arraycopy(intervals, 0, newArr, 1, intervals.length);
            newArr[0] = newInterval;
        } else {
            int raznica = intervals.length - posDirection;
            System.arraycopy(intervals, 0, newArr, 0, posDirection);
            newArr[posDirection] = newInterval;
            System.arraycopy(intervals, posDirection, newArr, posDirection + 1, raznica);
        }
        return newArr;

    }

    private int checkStartEnd(int[][] intervals, int[] newInterval) {
        if (newInterval[1] < intervals[0][0]) {
            return -2;
        }
        if (newInterval[0] > intervals[intervals.length - 1][1]) {
            return -1;
        }

        return 0;
    }

    private boolean entryCheck(int[] original, int[] emergent) {
        if (emergent[0] >= original[0] && emergent[1] <= original[1]) {
            return true;
        }
        return false;
    }

    private boolean entryBetween(int[] original, int[] next, int[] newInterval) {

        if (original[1] < newInterval[0] && newInterval[1] < next[0]) {
            return true;
        }
        return false;

    }

}
