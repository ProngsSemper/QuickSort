package newdemo;

/**
 * @Author: Prongs
 * @Date: 2020/6/13 15:32
 */
public class Dianlubuxian {
    public int[] c;
    public int[][] size;
    public int[] net;

    public Dianlubuxian(int[] cc) {
        this.c = cc;
        this.size = new int[cc.length][cc.length];
        this.net = new int[cc.length];
    }

    public void mnset(int[] c, int[][] size) {
        int n = c.length - 1;
        //i=1时，分了两种情况，分别等于0,1
        for (int j = 0; j < c[1]; j++) {
            size[1][j] = 0;
        }
        for (int j = c[1]; j <= n; j++) {
            size[1][j] = 1;
        }
        //i大于1时，同样分了两种情况(当i=n时单独计算，即此方法最后一行)
        for (int i = 2; i < n; i++) {
            //第一种
            if (c[i] >= 0) {
                System.arraycopy(size[i - 1], 0, size[i], 0, c[i]);
            }
            //第二种
            for (int j = c[i]; j <= n; j++) {
                size[i][j] = Math.max(size[i - 1][j], (size[i - 1][c[i] - 1] + 1));
            }
        }

        size[n][n] = Math.max(size[n - 1][n], (size[n - 1][c[n] - 1] + 1));
    }

    public int traceback(int[] c, int[][] size, int[] net) {
        int n = c.length - 1;
        int j = n;
        int m = 0;
        for (int i = n; i > 1; i--) {
            if (size[i][j] != size[i - 1][j]) {
                net[m++] = i;
                j = c[i] - 1;
            }

        }
        if (j >= c[1]) {
            net[m++] = 1;
        }
        System.out.println("最大不相交连线分别为：");
        for (int t = m - 1; t >= 0; t--) {
            System.out.println(net[t] + "  " + c[net[t]]);
        }
        return m;
    }

    public static void main(String[] args) {
        //下标从1开始,第一个数，0不算,总共10个数
        int[] c = {0, 8, 7, 4, 2, 5, 1, 9, 3, 10, 6};
        Dianlubuxian di = new Dianlubuxian(c);
        di.mnset(di.c, di.size);
        int x = di.traceback(di.c, di.size, di.net);
        System.out.println("最大不相交连线数目为：" + x);
    }
}


