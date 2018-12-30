package acmicpc.sort.insert;

import org.junit.Assert;
import org.junit.Test;

import acmicpc.sort.utils.SortUtils;

/**
 * https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html
 * Best: N
 * Worst: N^2
 * Avg: N^2
 */
public class InsertSort {

    @Test
    public void test() {
        int[] data = new int[]{3, 5, 1, 2, 7, 4};
        int[] expect = new int[]{1, 2, 3, 4, 5, 7};

        insertSort(data);
        Assert.assertArrayEquals(data, expect);
    }

    public void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }
}
