package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/16 14:19
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 80, 6, 987, 1025, 4, 41, 36};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int arr[]) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }

        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length + 1];

        int[] count = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int digitOfElement = (value / n) % 10;
                bucket[digitOfElement][count[digitOfElement]] = value;
                count[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < count.length; k++) {
                if (count[k] != 0) {
                    for (int j = 0; j < count[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                count[k] = 0;
            }
        }

    }
}
