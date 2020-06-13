package newdemo;

import java.util.Scanner;

/**
 * @Author: Prongs
 * @Date: 2020/5/22 12:38
 */
public class Clproblem {
    static int n;//集装箱数
    static int[] w;//集装箱重量数组
    static int c;//第一艘轮船的载重量

    static int cw;//当前载重量
    static int bw;//当前最优载重量

    static int r;//岸上可供选择的集装箱总重量

    static int[] x;//当前解
    static int[] bx;//当前最优解

    public static void init(int num, int[] ww, int cc) {
        //初始化类数据成员
        n = num;
        w = ww;
        c = cc;
        cw = 0;
        bw = 0;
        x = new int[n + 1];
        bx = x;
        for (int i = 0; i < n; i++) {
            //初始化
            r += w[i];
        }
        backtrack(1);
    }

    public static void backtrack(int t) {
        //搜索第i层结点
        //到达叶结点
        if (t > n) {
            if (n >= 0) {
                System.arraycopy(x, 1, bx, 1, n);
            }
            bw = cw;
            return;
        }
        //搜索子树
        //岸上剩余可选择集装箱总重量
        r -= w[t - 1];
        if (cw + w[t - 1] <= c) {
            //搜索左子树
            x[t - 1] = 1;
            cw += w[t - 1];
            //向下搜索
            backtrack(t + 1);
            //回到当前可扩展结点需要减掉往下时加的重量
            cw -= w[t - 1];
        }
        if (cw + r > bw) {
            //搜索右子树，右子树都是不放入，因此默认右子树都可达
            x[t - 1] = 0;
            backtrack(t + 1);
        }
        //返回当前可扩展结点需要加上可选择集装箱重量
        r += w[t - 1];
    }

    public static void main(String[] args) {
        System.out.println("请输入集装箱个数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ww = new int[num];
        System.out.println("请输入各个集装箱的重量：");
        for (int i = 0; i < num; i++) {
            ww[i] = sc.nextInt();
        }
        System.out.println("请输入第一艘轮船的最大承载重量：");
        int cc = sc.nextInt();
        init(num, ww, cc);
        System.out.print("此时最优解为：\n{");
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                System.out.println(bx[i] + "}");
            } else {
                System.out.print(bx[i] + ",");
            }
        }
        System.out.println("最优载重量为：\n" + bw);
    }
}

