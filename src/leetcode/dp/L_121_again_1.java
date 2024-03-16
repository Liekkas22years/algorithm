package leetcode.dp;
//买卖股票的最佳时机
/*
执行用时：2 ms, 在所有 Java 提交中击败了92.58%的用户
内存消耗：51.2 MB, 在所有 Java 提交中击败了70.43%的用户
 */
public class L_121_again_1 {
    public static int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int minprice =prices[0];
        int maxprofit=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minprice){
                minprice=prices[i];
            }
            maxprofit=Math.max(prices[i]-minprice,maxprofit);
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
