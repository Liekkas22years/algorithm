package leetcode.dp;
//买卖股票的最佳时机
//一次遍历
/*
执行用时：2 ms, 在所有 Java 提交中击败了92.86%的用户
内存消耗：50.6 MB, 在所有 Java 提交中击败了98的用户
 */
public class L_121_3_answer {
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        int[] a1={1,2,3};

        System.out.println(maxProfit(a));
    }
}
