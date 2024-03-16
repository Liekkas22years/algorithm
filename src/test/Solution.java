package test;

import java.util.Arrays;

public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        //初始条件
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候，利润才会最大，
        //只需要返回dp[length - 1][0]即可
        return dp[length - 1][0];
    }

    public int numRescueBoats(int[] people, int limit) {
        //先对数组进行排序（人发重量按照从小到大的顺序排序）
        Arrays.sort(people);
        //统计船的个数
        int count = 0;
        //从小到大排序，左边的是最小的，右边的是最大的
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            //如果体重最大的和体重最小的可以单独乘坐
            //一条船，就让他们同乘一条船
            if (people[right] + people[left] <= limit)
                left++;
            //体重最大的每次都要减1
            right--;
            //使用船的数量
            count++;
        }
        return count;
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


    public static void rotate2(int[] nums, int k) {
        if(nums.length==1){
            return;
        }
        int t=0;
        for(int i=0;i<nums.length/2;i++) {
            t=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=t;
        }
        for (int i = 0; i < k/2; i++) {
            t=nums[i];
            nums[i]=nums[k-1-i];
            nums[k-1-i]=t;
        }
        for (int i = 0; i < (nums.length-k)/2; i++) {
            t=nums[i+k];
            nums[i+k]=nums[nums.length-1-i];
            nums[nums.length-1-i]=t;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public int numRescueBoats1(int[] people, int limit) {

        return 1;
    }

    public static void main(String[] args) {

        int[] a2 = {7,1,5,3,6,4};
        int[] a3 = {-3,-1,0,2};
        int[] a={1,2};
        //rotate(a,3);
    }
}
