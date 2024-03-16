package leetcode.dp;
//买卖股票的最佳时机
/*
数组的长度如果过多，此算法容易超时
 */
public class L_121_1_fail {
    public static int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int max=0;
        for (int i = 0; i < prices.length-1; i++) {
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>max){
                    max=prices[j]-prices[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
