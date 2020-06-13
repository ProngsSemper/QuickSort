package newdemo;

/**
 * @Author: Prongs
 * @Date: 2020/3/27 11:59
 */
public class Loading {
    /**
     * 集装箱数
     */
    static int n;
    /**
     * 集装箱重量数组
     */
    static int[] w;
    /**
     * 第一艘轮船的载重量
     */
    static int c;
    /**
     * 当前载重量
     */
    static int cw;
    /**
     * 当前最优载重量
     */
    static int bestw;
    /**
     * 剩余集装箱重量
     */
    static int r;
    /**
     * 当前解
     */
    static int[] x;
    /**
     * 当前最优解
     */
    static int[] bestx;

    public static void maxLoading(int[] ww, int cc) {
        //初始化数据成员，数组下标从1开始
        n = ww.length - 1;
        w = ww;
        c = cc;
        cw = 0;
        bestw = 0;
        x = new int[n + 1];
        bestx = new int[n + 1];

        //初始化r，即剩余最大重量
        for (int i = 1; i <= n; i++) {
            r += w[i];
        }

        //计算最优载重量
        backtrack(1);
    }

    /**
     * 回溯算法
     */
    public static void backtrack(int t) {
        //到达叶结点
        if (t > n) {
            if (cw > bestw) {
                for (int i = 1; i <= n; i++) {
                    bestx[i] = x[i];
                }
                bestw = cw;
            }
            return;
        }

        r -= w[t];
        //搜索左子树
        if (cw + w[t] <= c) {
            x[t] = 1;
            cw += w[t];
            backtrack(t + 1);
            //回溯
            cw -= w[t];
        }

        if (cw + r > bestw) {
            //搜索右子树
            x[t] = 0;
            backtrack(t + 1);
        }
        //恢复
        r += w[t];

    }

    public static void main(String[] args) {
        //0作为根节点
        int[] ww = {0, 5, 2, 1, 3};
        int c1 = 10;
        int c2 = 12;
        int n = ww.length - 1;

        maxLoading(ww, c1);
        int weight2 = 0;
        for (int i = 1; i <= n; i++) {
            weight2 += ww[i] * (1 - bestx[i]);

        }
        if (weight2 > c2) {
            System.out.println("无解");
        } else {
            System.out.println("第一艘船装载货物的重量： " + bestw);
            System.out.println("第二艘船装载货物的重量： " + weight2);

        }

    }

}
