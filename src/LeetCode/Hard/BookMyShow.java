package LeetCode.Hard;

import java.util.Arrays;
import java.util.function.BiConsumer;

// Если Info я создаю в поле BookMyShow кидает NullPointer, видимо сначала создаются переменные, а потом уже
// создаться конструктор, а массив задаться в конструкторе, и Info получает преждевременную работу с этим массивом.
public class BookMyShow {
    private static int[][] test;
    private Info info;

    public static void main(String[] args) {
//        BookMyShow obj = new BookMyShow(4, 5);
//        obj.info.printArea();
//        boolean param_1 = obj.scatter(6, 2);
//        obj.info.printArea();
//        int[] param_2 = obj.gather(6, 3);
//        obj.info.printArea();
//        boolean param_3 = obj.scatter(9, 1);
//        obj.info.printArea();
//        System.out.println(param_1);
//        System.out.println(Arrays.toString(param_2));
//        System.out.println(param_3);

//        BookMyShow obj = new BookMyShow(4, 5);
//        int[] param_2 = obj.gather(5, 2);
//        obj.info.printArea();
//        int[] param_3 = obj.gather(5, 2);
//        int[] param_4 = obj.gather(5, 2);
//        int[] param_5 = obj.gather(5, 2);
//        int[] param_6 = obj.gather(5, 2);
//        obj.info.printArea();
//        System.out.println(Arrays.toString(param_2));
//        System.out.println(Arrays.toString(param_3));
//        System.out.println(Arrays.toString(param_4));
//        System.out.println(Arrays.toString(param_5));
//        System.out.println(Arrays.toString(param_6));

//        System.out.println(param_1);
//        System.out.println(Arrays.toString(param_2));
//        System.out.println(param_3);

//        BookMyShow obj = new BookMyShow(5, 9);
//        int[] param_1 = obj.gather(10, 1);
//        obj.info.printArea();
//        boolean param_2 = obj.scatter(3, 3);
//        obj.info.printArea();
//        int[] param_3 = obj.gather(9, 1);
//        obj.info.printArea();
//        int[] param_4 = obj.gather(10, 2);
//        obj.info.printArea();
//        int[] param_5 = obj.gather(2, 0);
//        obj.info.printArea();
//        System.out.println(Arrays.toString(param_1));
//        System.out.println(param_2);
//        System.out.println(Arrays.toString(param_3));
//        System.out.println(Arrays.toString(param_4));
//        System.out.println(Arrays.toString(param_5));


        BookMyShow obj = new BookMyShow(3, 999999999);
        boolean param_2 = obj.scatter(1000000000, 2);
        obj.info.printArea();
        int[] param_3 = obj.gather(999999999, 2);
        obj.info.printArea();
        int[] param_4 = obj.gather(999999999, 2);
        obj.info.printArea();
        int[] param_5 = obj.gather(999999999, 2);

//        obj.info.printArea();
//        boolean param_4 = obj.scatter(6, 1);
//        obj.info.printArea();
//        boolean param_5 = obj.scatter(5, 2);
//        boolean param_6 = obj.scatter(7, 5);
//        System.out.println(param_4);
//        System.out.println(param_5);
//        obj.info.printArea();
//
//        System.out.println("----------------");
//        System.out.println(Arrays.toString(param_1));
//        System.out.println(Arrays.toString(param_2));
//        System.out.println(Arrays.toString(param_3));
//        System.out.println("------------------");
//        boolean param_3 = obj.scatter(5, 1);
//        boolean param_4 = obj.scatter(5, 1);


//        System.out.println(Arrays.toString(param_2));
//        System.out.println(param_3);
//        System.out.println(param_4);
    }

    public BookMyShow(int n, int m) {
        test = new int[n][m];
        this.info = new Info();
    }


    public int[] gather(int k, int maxRow) {

        if (maxRow > test.length - 1) {
            return new int[]{};
        }

        int[] actualStartIdxAndRow = ActionArea.checkSeatsForGather(k, maxRow, info);

        if (actualStartIdxAndRow[1] == -1) {
            return new int[]{};
        } else {
            BiConsumer<int[], Integer> fillAreaForGather = new ActionArea.fillAreaForGather();
            fillAreaForGather.accept(actualStartIdxAndRow, k);
            info.calcRowFreeSetts();
        }
        return actualStartIdxAndRow;
    }

    public boolean scatter(int k, int maxRow) {
        if (maxRow > test.length - 1) {
            return false;
        }
        if (!ActionArea.checkForScatter(k, maxRow, info.getRowSettsFreeArray())) {
            return false;
        }

        BiConsumer<Integer, Integer> fillAreaScatter = new ActionArea.fillAreaForScatter();
        fillAreaScatter.accept(k, maxRow);

        info.calcRowFreeSetts();
        info.calcAllFreeSeats();

        return true;

    }


    class Info {
        private int allFreeSettsOnArea;
        private int[] rowSettsFree;

        public Info() {
            calcRowFreeSetts();
            calcAllFreeSeats();
        }

        private void calcAllFreeSeats() {

            this.allFreeSettsOnArea = Arrays.stream(rowSettsFree).sum();
        }

        private void calcRowFreeSetts() {
            int[] results = new int[test.length];
            for (int i = 0; i < test.length; i++) {
                results[i] = (int) Arrays.stream(test[i]).filter(o -> o == 0).count();
            }
            rowSettsFree = results;
        }

        public int[] getRowSettsFreeArray() {
            return rowSettsFree;
        }

        public void printArea() {
            for (var element : test) {
                System.out.println(Arrays.toString(element));
            }

            System.out.print("Свободных мест всего: ");
            System.out.println(allFreeSettsOnArea);
            System.out.print("Свободных мест по рядам: ");
            System.out.println(Arrays.toString(rowSettsFree));
        }
    }

    static class ActionArea {

        public static boolean checkForScatter(int k, int maxRow, int[] seatFreeRow) {
            for (int i = 0; i <= maxRow; i++) {
                k -= seatFreeRow[i];
                if (k <= 0) {
                    return true;
                }
            }
            return false;
        }

        public static int[] checkSeatsForGather(int k, int maxRow, Info info) {

            if (k > test[maxRow].length || test.length - 1 < maxRow) {
                return new int[]{0, -1};
            }

            int[] actualStartIdxAndRow = new int[2];
            int count = k;

            for (int i = 0; i <= maxRow; i++) {

                if (info.getRowSettsFreeArray()[i] < k) {
                    actualStartIdxAndRow[1] = -1;

                } else {
                    for (int j = 0; j < test[i].length; j++) {
                        if (test[i][j] == 0) {
                            count--;
                            if (count == 0) {
                                actualStartIdxAndRow[1] = j - k + 1;
                                actualStartIdxAndRow[0] = i;
                                return actualStartIdxAndRow;
                            }
                        } else {
                            if (test[i].length - 1 - j < count) {
                                count = k;
                                break;
                            } else {
                                count = k;
                            }
                        }
                    }
                }
            }
            return actualStartIdxAndRow;
        }


        static class fillAreaForScatter implements BiConsumer<Integer, Integer> {
            public fillAreaForScatter() {
            }

            @Override
            public void accept(Integer k, Integer maxRow) {
                for (int i = 0; i <= maxRow; i++) {
                    for (int j = 0; j < test[i].length; j++) {
                        if (test[i][j] == 0) {
                            test[i][j] = 1;
                            k--;
                            if (k == 0) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        static class fillAreaForGather implements BiConsumer<int[], Integer> {
            public fillAreaForGather() {
            }

            @Override
            public void accept(int[] ActualRowAndStartIdx, Integer k) {
                int startIdx = ActualRowAndStartIdx[1];
                int row = ActualRowAndStartIdx[0];
                for (int i = startIdx; i < startIdx + k; i++) {
                    test[row][i] = 1;
                }

            }
        }


    }

}






