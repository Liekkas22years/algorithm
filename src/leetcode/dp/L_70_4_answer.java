package leetcode.dp;
//爬楼梯
//动态规划
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：35 MB, 在所有 Java 提交中击败了88.30%的用户
 */
public class L_70_4_answer {
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
