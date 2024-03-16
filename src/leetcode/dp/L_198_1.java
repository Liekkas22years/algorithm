package leetcode.dp;
//打家劫舍
//dp
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：35.8 MB, 在所有 Java 提交中击败了55.31%的用户
 */
public class L_198_1 {
    public static int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];

    }

    public static void main(String[] args) {
        int[] a={2,1,1,2};
        System.out.println(rob(a));
    }
}
