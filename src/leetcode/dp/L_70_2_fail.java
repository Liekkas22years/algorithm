package leetcode.dp;
//爬楼梯
/*
在leetcode中超时
 */
public class L_70_2_fail {
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
