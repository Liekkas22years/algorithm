package leetcode.dp;
//买卖股票的最佳时机
/*
数组的长度如果过多，此算法容易超时
 */
public class L_121_2_fail {
    public static int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int max=0;
        int l=0;
        int r=1;
        while (l!=(prices.length-1)){
            if(prices[r]-prices[l]>max){
                max=prices[r]-prices[l];
                if(r<prices.length-1){
                    r++;
                }
                else{
                    l++;
                }
                continue;
            }
            else if(prices[l]>=prices[r] && r<prices.length-1){
                r++;
                continue;
            }
            else if(r==prices.length-1){
                l++;
                r=l+1;
            }
            else {
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        int[] a1={1,2,3};

        System.out.println(maxProfit(a));
    }
}
