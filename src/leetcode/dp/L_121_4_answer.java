package leetcode.dp;
//买卖股票的最佳时机
//动态规划
/*
执行用时：3 ms, 在所有 Java 提交中击败了35.29%的用户
内存消耗：51 MB, 在所有 Java 提交中击败了92.66%的用户
 */
public class L_121_4_answer {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        int hold = -prices[0];//持有股票
        int noHold = 0;//不持有股票
        for (int i = 1; i < length; i++) {
            //递推公式
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        //毋庸置疑，最后肯定是手里没持有股票利润才会最大，
        //也就是卖出去了
        return noHold;
    }

    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        int[] a1={1,2,3};

        System.out.println(maxProfit(a));
    }
}
