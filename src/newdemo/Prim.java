package newdemo;

/**
 * @author Prongs
 * @date 2020/6/28 10:58
 */
public class Prim {

    public static void main(String[] args) {
        float[][] c = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 34, Float.MAX_VALUE, Float.MAX_VALUE, 12, Float.MAX_VALUE},
                {0, 34, 0, 46, Float.MAX_VALUE, Float.MAX_VALUE, 19},
                {0, Float.MAX_VALUE, 46, 0, 17, Float.MAX_VALUE, 25},
                {0, Float.MAX_VALUE, Float.MAX_VALUE, 17, 0, 38, 25},
                {0, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 38, 0, 26},
                {0, Float.MAX_VALUE, 19, 25, 25, 26, 0}
        };

        prim(6, c);
    }

    public static void prim(int n, float[][] c) {
        float[] lowcost = new float[n + 1];
        int[] closest = new int[n + 1];
        boolean[] s = new boolean[n + 1];
        s[1] = true;
        for (int i = 2; i <= n; i++) {
            lowcost[i] = c[1][i];
            closest[i] = 1;
            s[i] = false;
        }
        for (int i = 1; i < n; i++) {
            float min = Float.MAX_VALUE;
            int j = 1;
            for (int k = 2; k <= n; k++) {
                if ((lowcost[k] < min) && (!s[k])) {
                    min = lowcost[k];
                    j = k;
                }
            }
            System.out.println(j - 1 + " ,  " + (closest[j] - 1));
            s[j] = true;
            for (int k = 2; k <= n; k++) {
                if ((c[j][k] < lowcost[k]) && (!s[k])) {
                    lowcost[k] = c[j][k];
                    closest[k] = j;
                }
            }
        }
    }
}
