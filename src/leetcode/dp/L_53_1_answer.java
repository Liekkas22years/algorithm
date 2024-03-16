package leetcode.dp;
//最大子序和
//动态规划
/*
执行用时：1 ms, 在所有 Java 提交中击败了94.87%的用户
内存消耗：48.8 MB, 在所有 Java 提交中击败了5.07%的用户
 */
public class L_53_1_answer {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);

        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
