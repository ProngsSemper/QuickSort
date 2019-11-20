package demo;

/**
 * @author Prongs
 * @date 2019/11/20 10:21
 */
public class GenerateArr {
    public static int[] generateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }
}
