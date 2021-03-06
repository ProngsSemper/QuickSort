package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/14 21:02
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {25, 30, 11, 7, 22, 16, 18, 33, 40, 55};
//        System.out.println(Arrays.toString(arr));
//        long startTime = System.currentTimeMillis();
        System.out.println("begin");
        selectSort(arr);
        System.out.println("end");
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
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
            System.out.println(Arrays.toString(arr));
        }
    }
}
