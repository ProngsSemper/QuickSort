package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/20 10:19
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = GenerateArr.generateArray(10000, 100);
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public static void bubbleSort(int[] arr) {
        int i, j;
        boolean flag = false;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
