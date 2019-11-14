package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/14 21:02
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 7, 1, 6};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
