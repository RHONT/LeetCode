package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Поиск комбинаций для уникальных значений символов.
 * Фишка: мы не просчитываем сразу все комбинации, а делаем это при каждом вызове next()
 * input: CombinationIteratorBest c1 = new CombinationIteratorBest("12345", 3);
 * output:
 * 123
 * 124
 * 125
 * 134
 * 135
 * 145
 * 234
 * 235
 * 245
 * 345
 * Суть такова:
 * мы синхронизируем стек и строку result. Если стек пустой, значит hasNext() = false.
 * Если нет, значит уже у нас есть подготовленное значение от предыдущего некста.
 * Мы отдаем всегда предыдущий результат, а сами уже имеем готовый.
 * Если стек пустой, значит все. А пустым мы его делаем в next при соблюдении условии, что последние
 * символы являются последними :). А значит генерировать дальше нечего
 */

public class CombinationIteratorBest {

    Stack<Character> st; // Размер = значению комбинации
    Map<Character, Integer> ch2Idx; // создаем мапу с индексами элементов.
    String result, str; // str - исходная строка. result -- итоговая строка=значению комб. всегда разная.
    int combLength;

    public static void main(String[] args) {
        CombinationIteratorBest c1 = new CombinationIteratorBest("12345", 3);
        while (c1.hasNext()) {
            System.out.println(c1.next());
            System.out.println(c1.hasNext());
        }
    }

    public CombinationIteratorBest(String characters, int combinationLength) {
        combLength = combinationLength;
        ch2Idx = new HashMap();
        str = characters;
        st = new Stack();
        result = "";
        // create the first combination
        for (Character ch : characters.toCharArray()) {
            st.push(ch);
            result = result + ch;
            if (st.size() == combinationLength) break;
        }
        int idx = 0;
        // set up the mapping between character --> index
        for (Character ch : characters.toCharArray()) {
            ch2Idx.put(ch, idx++);
        }
    }

    public String next() {
        String currResult = result;
        // process the next result

        int idx = str.length() - 1; // получаем индекс крайнего элемента
        // если последний элемент с крайним индексом, значит нужно смещать предпоследний элемент
        while (!st.isEmpty() && ch2Idx.get(st.peek()) == idx) {
            st.pop();
            idx--;
            result = result.substring(0, result.length() - 1); // отсекаем последний индекс
        }
        if (st.isEmpty()) return currResult; // there is no next result to pre-process

        idx = ch2Idx.get(st.pop()); // we need to add elements after this idx
        result = result.substring(0, result.length() - 1);

        while (st.size() != combLength) {
            Character temp = str.charAt(++idx);
            result += temp;
            st.push(temp);
        }

        return currResult;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

}
