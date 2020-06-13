package newdemo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: Prongs
 * @Date: 2020/5/22 12:49
 */
public class BestLoading {
    public void addLiveNode(PriorityQueue<HeapNode> H, bbnode E, int wt, boolean ch, int lev) {
        bbnode b = new bbnode(E, ch);
        HeapNode n = new HeapNode(b, wt, lev);
        H.add(n);
    }

    public int maxLoading(int w[], int c, int n, boolean bestx[]) {
        /* 生成最大堆 */
        PriorityQueue<HeapNode> H = new PriorityQueue(1000, new Comp());
        int[] r = new int[n + 1];
        r[n] = 0;
        for (int j = n - 1; j > 0; j--) {
            r[j] = r[j + 1] + w[j + 1];
        }
        int i = 1;
        bbnode E = new bbnode(null, false);
        int Ew = 0;
        while (i != n + 1) {
            if (Ew + w[i] <= c) {
                addLiveNode(H, E, Ew + w[i] + r[i], true, i + 1);
            }
            addLiveNode(H, E, Ew + r[i], false, i + 1);
            HeapNode N;
            N = H.poll();
            i = N.level;
            E = N.ptr;
            Ew = N.uweight - r[i - 1];
        }
        // 构造最优解
        for (int j = n; j > 0; j--) {
            bestx[j] = E.Lchild;
            E = E.parent;
        }
        return Ew;
    }

    public static void main(String[] args) {
        System.out.println(" 请输入物品总数： ");
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        int[] w = new int[n + 1];
        System.out.println(" 请输入物品重量并用空格隔开： ");
        Scanner sc2 = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            w[i] = sc2.nextInt();
        }
        System.out.println(" 请分别输入两艘轮船载重并用空格隔开： ");
        Scanner sc3 = new Scanner(System.in);
        int c1 = sc3.nextInt();
        int c2 = sc3.nextInt();
        boolean[] bestx = new boolean[100];
        BestLoading t = new BestLoading();
        // 处理第一个箱子
        System.out.println("第一艘轮船总载重:" + t.maxLoading(w, c1, n, bestx));
        System.out.print(" 载重方案为： ");
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (bestx[i]) {
                count++;
                //输出一个可行方案
                System.out.print(w[i] + " ");
            }
        }
        System.out.println();
        /* 处理第二个箱子 */
        int m = n - count;
        int[] ww = new int[m + 1];
        int k = 1;
        for (int i = 1; i <= n; i++) {
            if (!bestx[i]) {
                ww[k] = w[i];
                k++;
                bestx[i] = false;
            }
        }
        System.out.println();
        System.out.println("第二艘轮船总载重:" + t.maxLoading(ww, c2, m, bestx));
        System.out.print(" 载重方案为： ");
        for (int i = 1; i <= m; i++) {
            if (bestx[i]) {
                /* 输出一个可行方案 */
                System.out.print(ww[i] + " ");
            }
        }
    }
}

/**
 * 堆结点类
 */
class HeapNode {
    bbnode ptr;
    int uweight;
    int level;

    public HeapNode() {
    }

    public HeapNode(bbnode ptr, int uweight, int level) {
        this.ptr = ptr;
        this.uweight = uweight;
        this.level = level;
    }

    @Override
    public String toString() {
        return "" + this.uweight;
    }
}

class bbnode {
    bbnode parent;
    boolean Lchild;

    public bbnode(bbnode node, boolean ch) {
        this.parent = node;
        this.Lchild = ch;
    }
}

/**
 * 定义比较器类
 */
class Comp implements Comparator<HeapNode> {
    @Override
    public int compare(HeapNode o1, HeapNode o2) {
        int dif = o1.uweight - o2.uweight;
        return Integer.compare(0, dif);
    }

}
