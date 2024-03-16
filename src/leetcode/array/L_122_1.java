package leetcode.array;
//买卖股票的最佳时机 II
/*
执行用时：1 ms, 在所有 Java 提交中击败了99.69%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了5.13%的用户
 */
public class L_122_1 {
    public static int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int l=0;
        int r=0;
        int profit=0;
        boolean flag=false;
        int t;
        while (l<prices.length-1){
            if(r==prices.length-1){
                if(prices[r]-prices[l]>0){
                    t=prices[r]-prices[l];
                }
                else {
                    t=0;
                }
                return flag?profit+t:t;
            }
            if(prices[r]<prices[r+1] && r<prices.length){
                r++;
            }
            else {
                flag=true;
                profit+=prices[r]>prices[l]?prices[r]-prices[l]:0;
                l=r+1;
                if(l<prices.length-1){
                    r=l;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a1={7,1,5,3,6,4};
        int[] a={1,2,3,4,5,6};
        int[] a2={7,6,4,3,1};
        int[] a3={3,2,6,5,0,3};
        System.out.println(maxProfit(a2));
    }
}
