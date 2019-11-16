package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/16 14:19
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,80,6,987,1025,4,41,36};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        //存数组中最大的数
        for (int value : arr) {
            if (max < value) {
                max = value;
            }
        }
        //计算最大数是几位数
        int maxLength = (max + "").length();
        //存放临时数据
        int[][] temp = new int[10][arr.length];
        //记录在temp中相应的数组存放数字的数量
        int[] counts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int ys = value / n % 10;
                temp[ys][counts[ys]] = value;
                counts[ys]++;
            }
            int index = 0;
            for (int k = 0; k < counts.length; k++) {
                if (counts[k] != 0) {
                    for (int l = 0; l < counts[k]; l++) {
                        arr[index] = temp[k][l];
                        index++;
                    }
                    counts[k] = 0;
                }
            }
        }
    }
}
