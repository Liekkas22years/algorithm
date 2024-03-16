package leetcode.dp;
//爬楼梯
//斐波那契数列
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：34.8 MB, 在所有 Java 提交中击败了97.45%的用户
 */
public class L_70_5_answer {
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int first=1;
        int second=2;
        for(int i=3;i<=n;i++){
            int third=first+second;
            first=second;
            second=third;
        }
        return second;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
