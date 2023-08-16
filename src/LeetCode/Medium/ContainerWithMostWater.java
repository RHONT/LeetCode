package LeetCode.Medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContainerWithMostWater {

    int max = 0;

    public static void main(String[] args) {

        IntStream copiedArray = new Random().ints(100000, 1000, 10000);

        ContainerWithMostWater c = new ContainerWithMostWater();

        long start = System.nanoTime();
        System.out.println(c.maxArea(copiedArray.toArray()));
//        System.out.println(c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed / 1000000);
    }

    public int maxAreaBest(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int heightVar = (Math.min(height[i], height[j]));  // вычисляет нижний порог
            int areaVar = heightVar * (j - i);                // сразу вычисляет площадь
            if (areaVar > area)
                area = areaVar;
            while (height[i] <= heightVar && i < j) i++;        // стремиться в обе стороны пробегая лишнее
            while (height[j] <= heightVar && i < j) j--;
        }
        return area;
    }

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int[] minElement = Arrays.stream(height).sorted().distinct().toArray();
        int minIndex = 0;

        while (minIndex < minElement.length) {

            while (height[leftIndex] < minElement[minIndex]) leftIndex++;
            while (height[rightIndex] < minElement[minIndex]) rightIndex--;

            while (height[leftIndex] >= minElement[minIndex] || height[rightIndex] >= minElement[minIndex] || minIndex < minElement.length - 1) {
                minIndex++;
            }


            max = Math.max(max, (rightIndex - leftIndex) * minElement[minIndex]);
            minIndex++;
        }

        return max;
    }




}
