package newdemo;

/**
 * @author: Prongs
 * @date: 2020/4/5 15:51
 */
public class Coloring {
    //图的顶点数
    static int n;
    //当前解
    static int[] x;
    //当前已找到的可m着色方案数
    static long sum;
    //图的邻接矩阵
    static int[][] a;
    //可用颜色数
    static int m;

    private static void backtrack(int t) {
        if (t > n) {
            sum++;
            for (int i = 1; i <= n; i++) {
                System.out.print(x[i] + "  ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= m; i++) {
                x[t] = i;
                if (ok(t)) {
                    backtrack(t + 1);
                }
                x[t] = 0;
            }
        }
    }

    private static boolean ok(int k) {
        for (int j = 1; j <= n; j++) {
            //某条边的两个顶点着不同颜色；a[k][j]=1表示某条边（即边集E中的边）
            if (a[k][j] == 1 && (x[j] == x[k])) {
                return false;
            }
        }
        return true;
    }

    public long mcoloring(int mm, int nn, int[][] aa) {
        n = nn;
        a = aa;
        x = new int[n + 1];
        m = mm;
        sum = 0;
        backtrack(1);
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int[][] a = {{-1, -1, -1, -1, -1, -1}, {-1, 0, 1, 1, 1, 0}, {-1, 1, 0, 1, 1, 1}, {-1, 1, 1, 0, 1, 0}, {-1, 1, 1, 1, 0, 1}, {-1, 0, 1, 0, 1, 0}};
        Coloring c = new Coloring();
        System.out.println("着色方案如下：");
        long sum = c.mcoloring(m, n, a);
        System.out.println("可行的着色方案数目为：" + sum);
    }

}
