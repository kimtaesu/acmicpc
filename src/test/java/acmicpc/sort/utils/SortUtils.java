package acmicpc.sort.utils;

import java.util.Arrays;

public class SortUtils {
    public static void swap(int[] data, int to, int from) {
        int temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }

    public static void printArray(int[] data) {
        Arrays.stream(data).forEach(value ->
                System.out.print(value + " ")
        );
        System.out.println();
    }
}
