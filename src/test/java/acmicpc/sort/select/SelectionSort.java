package acmicpc.sort.select;

import org.junit.Assert;
import org.junit.Test;

import acmicpc.sort.utils.SortUtils;

/**
 * https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html
 * Best: N^2
 * Worst: N^2
 * Avg: N^2
 * 앞쪽부터 정렬이 된다.
 */
public class SelectionSort {

    @Test
    public void test() {
        int[] data = new int[]{3, 5, 1, 2, 7};
        int[] expect = new int[]{1, 2, 3, 5, 7};

        selectionSort(data);
        Assert.assertArrayEquals(data, expect);
    }

    public void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[minIndex] > data[j]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(data, minIndex, i);
        }
    }
}
