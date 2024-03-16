package leetcode.double_pointer;
//移动零
//双指针
/*
执行用时：2 ms, 在所有 Java 提交中击败了40.43%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了25.14%的用户
 */
public class L_283_answer_1 {
    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] a= {0,1,0,3,12};
        moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
