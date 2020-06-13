package newdemo;

/**
 * @author: Prongs
 * @date: 2020/3/27 15:42
 */
public class FlowShop {
    static int n,       //作业数
            f1,      //  机器1完成处理时间
            f,       //  完成时间和
            bestf;   //  当前最优值
    static int[][] m;   //  各作业所需的处理时间

    static int[] x;     //  当前作业调度
    static int[] bestx; //  当前最优作业调度
    static int[] f2;    //  机器2完成处理时间

    public static void backtrack(int i) {
        if (i > n) {
            if (n >= 0) {
                System.arraycopy(x, 1, bestx, 1, n);
            }
            bestf = f;
        } else {
            for (int j = i; j <= n; j++) {
                f1 += m[x[j]][1];
                f2[i] = (Math.max(f2[i - 1], f1)) + m[x[j]][1];
                f += f2[i];
                if (f < bestf) {
                    swap(i, j);
                    backtrack(i + 1);
                    swap(i, j);
                }
                f1 -= m[x[j]][1];
                f -= f2[i];
            }
        }

    }

    private static void swap(int i, int j) {
        int temp;
        temp = x[j];
        x[j] = x[i];
        x[i] = temp;
    }

    public void showTest() {
        n = 3;
        bestf = Integer.MAX_VALUE;
        f1 = 0;
        f = 0;

        int[][] m = {{0, 0}, {2, 1}, {3, 1}, {2, 3}};
        int[] x = {0, 1, 2, 3};
        int[] bestx = {0, 1, 2, 3};
        f2 = new int[4];
        FlowShop.m = m;
        FlowShop.x = x;
        FlowShop.bestx = bestx;

        backtrack(1);
        System.out.println("当前最优值:" + bestf);
        System.out.println("当前最优作业调度:");
        for (int i = 1; i <= n; i++) {
            System.out.print(bestx[i] + "  ");
        }
    }

    public static void main(String[] args) {
        FlowShop flowShop = new FlowShop();
        flowShop.showTest();
    }

}