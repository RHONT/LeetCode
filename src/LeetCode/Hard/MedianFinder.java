package LeetCode.Hard;

import java.util.*;

/**
 * Задача: получить центральное значение отсортированного рейнджа
 * 1,2,3 = 2
 * 1,2,3,4 = 2.5
 * Суть решения задачи: создаем две приоритетные очереди.
 * одна хранит левый набор, другая правый от центра набор цифр
 * и потом вызываем peek() у обоих очередей и находим то, что нужно
 * так же есть флаг even, если четный складываем и делим, если нечет, то берем из одной очереди первое значение
 */

public class MedianFinder {


    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();

        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
        m.addNum(5);
        m.addNum(6);
        System.out.println(m.leftQ);
        System.out.println(m.rightQ);
        System.out.println(m.even);
        System.out.println(m.findMedian());
    }

    PriorityQueue<Integer> rightQ = new PriorityQueue<>();
    PriorityQueue<Integer> leftQ = new PriorityQueue<>((a, b) -> b - a);
    boolean even = false;

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (!even) {
            rightQ.add(num);
            leftQ.add(rightQ.poll());
        } else {
            leftQ.add(num);
            rightQ.add(leftQ.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return leftQ.peek();
        } else {
            System.out.println(leftQ.peek());
            System.out.println(rightQ.peek());
            return ((leftQ.peek() + rightQ.peek()) / 2.0); // Вот это подкол! На 2 делить нельзя! Это целочисленное деление.
            // для double нужно делить на 2.0!!!!
        }
    }

}
