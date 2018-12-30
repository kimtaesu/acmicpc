package acmicpc.sort.merge;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * https://gmlwjd9405.github.io/2018/05/08/algorithm-merge-sort.html
 *
 * Best, Worst, Avg: N * logN
 */
public class MergeSort {

    @Test
    public void test() {
        int[] data = new int[]{3, 5, 1, 2, 7, 4};
        int[] expect = new int[]{1, 2, 3, 4, 5, 7};

        mergeSort(data);
        Assert.assertArrayEquals(data, expect);
    }

    public void mergeSort(int[] data) {
    }
}
