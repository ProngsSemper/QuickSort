package newdemo;

/**
 * @Author: Prongs
 * @Date: 2020/6/4 10:12
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 8, 12, 15, 16, 21, 30, 35, 39};
        String index1 = binary(arr, 30, 0, arr.length - 1);
        String index2 = binary(arr, 20, 0, arr.length - 1);
        String index3 = binary(arr, 10, 0, arr.length - 1);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
    }

    /**
     * 搜索指定要搜索元素在数组中是索引
     *
     * @param arr：要二分搜索的数组
     * @param key：要查找的关键字
     * @param low：起始索引
     * @param high：结尾索引
     * @return 若搜索到这个元素，则返回数组的索引下标；否则返回无此元素
     */
    public static String binary(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return String.valueOf(mid);
            }
        }

        if (key == 10) {
            int i = high, j = low;
            if (key < arr[0]) {
                String result = ("数组中不存在比" + key + "更小的最大元素位置" + ", " + "大于" + key + "的最小元素位置为" + j);
                return result;
            }
            //x<a[8],说明数组中没有比x更大的元素了
            else if (key > arr[arr.length - 1]) {
                String result = ("小于" + key + "的最大元素位置为" + i + ", " + "数组中不存在比" + key + "更大的最小元素位置");
                return result;
            } else {
                String result = ("小于" + key + "的最大元素位置为" + i + ", " + "大于" + key + "的最小元素位置为" + j);
                return result;
            }
        }
        return "无此元素";
    }

}
