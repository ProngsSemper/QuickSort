package demo;

import java.util.Arrays;

/**
 * @author Prongs
 * @date 2019/11/16 14:19
 * 队列实现基数排序
 */
public class RadixQueueSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 80, 6, 987, 1025, 4, 41, 36};
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
        //存放临时数据的队列数组
        MyQueue[] temp = new MyQueue[10];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new MyQueue();
        }
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int ys = value / n % 10;
                temp[ys].add(value);
            }
            int index = 0;
            //把所有队列中的数字取出来
            for (MyQueue myQueue : temp) {
                while (!myQueue.isEmpty()) {
                    arr[index] = myQueue.poll();
                    //记录下一个位置
                    index++;
                }
            }
        }
    }
}
