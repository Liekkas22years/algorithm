package leetcode.array;

import java.util.Arrays;

//存在重复元素
/*
执行用时：3 ms, 在所有 Java 提交中击败了99.38%的用户
内存消耗：41.5 MB, 在所有 Java 提交中击败了88.78%的用户
 */
public class L_217_1 {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]-nums[i+1]==0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] a= {0};
        System.out.println(containsDuplicate(a));
    }
}
