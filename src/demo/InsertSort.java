package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/13 15:21
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
//        int[] arr = GenerateArr.generateArray(10000, 100);
        int[] arr = {25, 30, 11, 7, 22, 16, 18, 33, 40, 55};
//        System.out.println(Arrays.toString(arr));
//        long startTime = System.currentTimeMillis();
//        System.out.println("begin");
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }

//        for (int i = 1; i < arr.length; i++) {
//            int a = 0;
//            if (arr[i] < arr[i - 1]) {
//                a++;
//                int temp = arr[i];
//                int j;
//                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
//                    a++;
//                    arr[j + 1] = arr[j];
//                }
//                arr[j + 1] = temp;
//            }
//            System.out.println(a);
//            System.out.println(Arrays.toString(arr));
//        }
    }
}
