package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/13 15:21
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = GenerateArr.generateArray(10000, 100);
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
