package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/13 14:56
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = GenerateArr.generateArray(10000, 100);
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public static void quickSort(int[] arr, int start, int end) {
        int i, j, temp, t;
        if (start > end) {
            return;
        }
        i = start;
        j = end;
        //temp就是基准位
        temp = arr[start];
        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[start] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, start, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, end);
    }
}
