package LeetCode.Medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Сука гениально и просто.
 * Скорость добавления элементов в linkedList очень высокая. Напихивай не хочу со скоростью света.
 * Потом мы создаем итератор к этой коллекции. Через итератор гораздо быстрее идет перебор, нежели
 * штатно пользоваться функционалом linkedList
 * минимум кода. Пользуемся простыми методами из коробки и ничего не выдумываем кастомного.
 */

public class NestedIteratorBest implements Iterator<Integer> {
    Iterator<Integer> itr;

    public NestedIteratorBest(List<NestedInteger> nestedList) {
        LinkedList<Integer> records = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            traverse(node, records);
        }
        itr = records.iterator();
    }

    private void traverse(NestedInteger root, LinkedList<Integer> list) {
        if (root.isInteger()) {
            list.add(root.getInteger());
            return;  // обрыв функции, классный подход
        }

        for (NestedInteger node : root.getList()) {
            traverse(node, list);
        }
    }

    @Override
    public Integer next() {
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }
}
