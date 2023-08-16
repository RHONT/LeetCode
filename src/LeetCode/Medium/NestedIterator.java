package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Суть: Иду по корзинам. Делаю лист с числами для каждой позиции. И из этого листа возвращаю в next() значения, пока они есть.
 */

public class NestedIterator implements Iterator<Integer> {
    int currentIdxBacked, sizeList, currentIdxForList;
    List<NestedInteger> input;
    List<Integer> currentBacked;


    public NestedIterator(List<NestedInteger> nestedList) {
        currentIdxBacked = 0;
        currentIdxForList = 0;
        sizeList = nestedList.size();
        input = nestedList;
        currentBacked = new ArrayList<>();
        currentBacked = findNextBacked();
    }

    private void fillBacked(NestedInteger unknownElement) {
        if (unknownElement.isInteger()) {
            currentBacked.add(unknownElement.getInteger());
        } else {
            for (NestedInteger element : unknownElement.getList()) {
                fillBacked(element);
            }
        }

    }

    @Override
    public Integer next() {
        return currentBacked.get(currentIdxBacked++);
    }

    @Override
    public boolean hasNext() {
        if (currentIdxBacked < currentBacked.size()) {
            return true;
        }
        currentBacked.clear();
        currentIdxBacked = 0;

        return !findNextBacked().isEmpty();
    }

    private List<Integer> findNextBacked() {
        while (sizeList != 0) {
            fillBacked(input.get(currentIdxForList));
            sizeList--;
            currentIdxForList++;
            if (currentBacked.size() != 0) {
                break;
            }
        }
        return currentBacked;
    }
}

