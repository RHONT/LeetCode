package LeetCode.Hard;

import java.util.Arrays;

// Если Info я создаю в поле BookMyShow кидает NullPointer, видимо сначала создаются переменные, а потом уже
// создаться конструктор, а массив задаться в конструкторе, и Info получает преждевременную работу с этим массивом.
public class BookMyShowLove {

    public ActionArea action;
    private static int[][] emptyInputArray;
    private int[] rowSettsFree;
    private final int rows;
    private final int setts;
    private int startSearchRow;
    private double duty;
    private int upperLine;
    private final double part;


    public static void main(String[] args) {
//        BookMyShowLove obj = new BookMyShowLove(2, 5);
//        obj.action.printArrays();
//        int[] param_1 = obj.gather(4, 0);
//        obj.action.printArrays();
//        int[] param_2 = obj.gather(2, 0);
//        obj.action.printArrays();
//        boolean param_3 = obj.scatter(5, 1);
//        obj.action.printArrays();
//        boolean param_4 = obj.scatter(5, 1);
//        obj.action.printArrays();
//
//        System.out.println(Arrays.toString(param_1));
//        System.out.println(Arrays.toString(param_2));
//        System.out.println(param_3);
//        System.out.println(param_4);

//        BookMyShowLove obj = new BookMyShowLove(50000, 1);
//        obj.action.printArrays();
//        boolean param_1 = obj.scatter(1, 49999);
//        obj.action.printArrays();
//        boolean param_2 = obj.scatter(50000, 49999);
//        obj.action.printArrays();
//        boolean param_3 = obj.scatter(50000, 49999);
//        obj.action.printArrays();
//
//        System.out.println(param_1);
//        System.out.println(param_2);
//        System.out.println(param_3);

        BookMyShowLove obj = new BookMyShowLove(5, 5);
        obj.action.printArrays();
        boolean param_1 = obj.scatter(1, 1);
        obj.action.printArrays();
        boolean param_2 = obj.scatter(2, 2);
        obj.action.printArrays();
        boolean param_3 = obj.scatter(10, 0);
        obj.action.printArrays();
        boolean param_4 = obj.scatter(7, 2);
        obj.action.printArrays();

        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    public BookMyShowLove(int n, int m) {
        emptyInputArray = new int[][]{};
        setts = m;
        rows = n;
        duty = 0;
        startSearchRow = 0;
        upperLine = 0;
        part = 1 / (double) setts;
        this.action = new ActionArea();
        rowSettsFree = new int[rows];
        Arrays.fill(rowSettsFree, setts);
    }

    public int[] gather(int k, int maxRow) {

        return action.checkSeatsForGather(k, maxRow);
    }

    public boolean scatter(int k, int maxRow) {
        if (maxRow > upperLine & (k > (maxRow + 1 - duty) * setts)) {
            return false;
        }
        return action.checkForScatter(k, maxRow);
    }

    class ActionArea {

        private boolean checkForScatter(int k, int maxRow) {

            int accum = 0;
            for (int i = startSearchRow; i <= maxRow; i++) {
                accum += rowSettsFree[i];
                if (k <= accum) {
                    rowSettsFree[i] = accum - k;
                    startSearchRow = i;
                    upperLine = i;
                    duty += k * part;
                    return true;
                }
            }
            return false;
        }

        private void printArrays() {
            System.out.println("-------------------");
            System.out.println("Ряд свободных мест = " + Arrays.toString(rowSettsFree));
            System.out.println("Верхняя граница = " + upperLine);
            System.out.println("Новый старт = " + startSearchRow);
            System.out.println("Долг = " + duty);
            System.out.println("-------------------");
        }

        private int[] checkSeatsForGather(int k, int maxRow) {

            if (k > setts || rows - 1 < maxRow) {
                return new int[]{};
            }
            int[] actualStartIdxAndRow = new int[2];

            for (int i = startSearchRow; i <= maxRow; i++) {
                if (rowSettsFree[i] >= k) {
                    actualStartIdxAndRow[0] = i;
                    actualStartIdxAndRow[1] = setts - rowSettsFree[i];
                    rowSettsFree[i] -= k;
                    duty += k * part;
                    if (i >= upperLine) {
                        upperLine = i;
                    }
                    return actualStartIdxAndRow;
                }
            }
            return new int[]{};
        }
    }
}






