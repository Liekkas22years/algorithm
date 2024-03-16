package leetcode.dp;
//爬楼梯
//记忆化递归
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：34.6 MB, 在所有 Java 提交中击败了99.83%的用户
 */
public class L_70_3_answer {
    public static int climbStairs(int n) {
        int memo[] = new int[n+1];
        return climbStairsMemo(n,memo);

    }

    public static int climbStairsMemo(int n,int[] memo){
        if(memo[n]>0){
            return memo[n];
        }
        if(n==1){
            memo[n]=1;
        }
        else if (n == 2) {
            memo[n]=2;
        }
        else{
            memo[n]=climbStairsMemo(n-1,memo)+climbStairsMemo(n-2,memo);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
