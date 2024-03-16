package leetcode.brute_force;

import java.util.Arrays;
//两数之和
//暴力，双循环
/*执行用时：49 ms, 在所有 Java 提交中击败了37.97%的用户
内存消耗：41.7 MB, 在所有 Java 提交中击败了10.95%的用户
通过测试用例：57 / 57*/
public class L_1_2 {
    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int t =10;
        twoSum(nums,t);
    }
}
