package acmicpc.sort.select;


import org.junit.Assert;
import org.junit.Test;

import acmicpc.sort.utils.SortUtils;

/**
 * https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
 * Best: N^2
 * Worst: N^2
 * Avg: N^2
 */

public class BubbleSort {

    @Test
    public void test() {
        int[] data = new int[]{3, 5, 1, 2, 7, 4};
        int[] expect = new int[]{1, 2, 3, 4, 5, 7};

        bubbleSort(data);
        Assert.assertArrayEquals(data, expect);
    }

    @Test
    public void advancedTest() {
        int[] data = new int[]{3, 5, 1, 2, 7, 4};
        int[] expect = new int[]{1, 2, 3, 4, 5, 7};

        advancedBubbleSort(data);
        Assert.assertArrayEquals(data, expect);
    }

    public void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1] > data[j]) {
                    SortUtils.swap(data, j, j - 1);
                }
            }
        }
    }

    public void advancedBubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            boolean isSwap = false;
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1] > data[j]) {
                    isSwap = true;
                    SortUtils.swap(data, j, j - 1);
                }
            }
            if (!isSwap) break;
        }
    }
}
