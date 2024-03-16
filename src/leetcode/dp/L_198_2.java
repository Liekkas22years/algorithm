package leetcode.dp;
//打家劫舍
//
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：35.9 MB, 在所有 Java 提交中击败了18.14%的用户
 */
public class L_198_2 {
    public static int rob(int[] nums) {
        int p=0,q=0,r=0;
        for(int i=0;i<nums.length;i++){
            p = q;
            q = r;
            r = nums[i]+p>q?nums[i]+p:q;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a={2,1,1,2};
        System.out.println(rob(a));
    }
}
