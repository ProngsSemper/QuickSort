package newdemo;

/**
 * @Author: Prongs
 * @Date: 2020/6/4 10:55
 */
public class MatrixChain {
    public static void main(String args[]) {
        int p[] = {5, 200, 200, 2, 2, 100, 100, 30, 30, 200};
        int m[][] = new int[p.length][p.length];
        int s[][] = new int[p.length][p.length];
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                m[i][j] = 0;
                s[i][j] = 0;
            }
        }

        matrixChain(p, m, s);
        for (int i = 1; i < p.length; i++) {
            for (int j = 1; j < p.length; j++) {
                System.out.print("      " + m[i][j] + "       ");
            }
            System.out.println();
        }
        traceBack(s, 1, p.length-1);
    }

    public static void matrixChain(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;
        for (int i = 0; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }

                }
            }
        }
    }

    public static void traceBack(int[][] s, int i, int j) {
        if (i == j) {
            return;
        }
        traceBack(s, i, s[i][j]);
        traceBack(s, s[i][j] + 1, j);
        System.out.println("Multiply A" + i + "," + s[i][j] + " and A" + (s[i][j] + 1) + "," + j);
    }
}

