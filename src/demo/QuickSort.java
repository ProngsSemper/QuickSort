package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/13 14:56
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = GenerateArr.generateArray(10000, 100);
        int[] arr = {5,3,1,9,8,2,4,7};
//        System.out.println(Arrays.toString(arr));
//        long startTime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
//        randomQuick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
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
            System.out.println(Arrays.toString(arr));
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

    public static void randomQuick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        //从数组中随机选择一个数作为基准点
        int k = (int) (Math.random() * (right - left + 1)) + left;
        System.out.println("基数点："+k);
        int temp = arr[k];
        arr[k] = arr[left];
        //将以基准点放在数组下标为0的位置--》容易判断
        arr[left] = temp;
        int firstIndex = left;
        int first = arr[firstIndex];
        while (i < j) {
            while (i < j && arr[j] >= first) {
                j--;
            }
            while (i < j && arr[i] <= first) {

                i++;
            }
            if (i < j) {
                int temp2 = arr[j];
                arr[j] = arr[i];
                arr[i] = temp2;
            }
        }
        arr[firstIndex] = arr[i];
        arr[i] = first;
        randomQuick(arr, left, i - 1);
        randomQuick(arr, i + 1, right);
    }

}
