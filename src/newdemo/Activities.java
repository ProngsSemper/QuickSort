package newdemo;

/**
 * @author Prongs
 * @date 2020/6/19 11:24
 */
public class Activities {
    public static int greedySelector(int[] s, int[] f, boolean[] a) {

        int n = s.length - 1;
        //安排第一个活动，标记为true
        a[1] = true;
        int j = 1;
        int count = 1;

        for (int i = 2; i <= n; i++) {
            //检验当前最早结束的活动的开始时间是否晚于前一个活动的结束结束时间
            if (s[i] >= f[j]) {
                //如果晚于，则表示两个活动相互兼容，将活动标记为true
                a[i] = true;
                j = i;
                //记已经安排活动的个数
                count++;
            } else {
                //与已安排活动不兼容，标记此活动未安排
                a[i] = false;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        //初始化数据s数组记录活动开始时间；f数组记录活动结束时间
        int[] s = {3,

                2,

                1,

                9,

                5,
                4,

                11,

                8
                ,
                6,

                7};
        int[] f = {10,

                4,

                3,

                15,

                8,

                6,

                13,

                12,

                9,

                16};

        boolean[] a = new boolean[s.length];

        int result = greedySelector(s, f, a);

        for (int i = 1; i <= s.length - 1; i++) {
            if (a[i]) {
                System.out.println("第" + (i + 1) + "个活动被选中，其开始时间为：" + s[i] + "，结束时间为：" + f[i]);
            }
        }
        System.out.println("被选中的活动共有: " + result + "个");

    }

}
