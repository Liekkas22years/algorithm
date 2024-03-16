package leetcode.greed;

// 跳跃游戏
public class L_55_1 {
    public static boolean canJump(int[] nums) {
        int maxD = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxD = Math.max(maxD,i + nums[i]);
            if (maxD <= i) {
                return false;
            }
        }
        return maxD >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] a = {0,2,3};
        canJump(a);
    }
}
