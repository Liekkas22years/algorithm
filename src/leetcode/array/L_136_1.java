package leetcode.array;

import java.util.Arrays;

//只出现一次的数字
/*
执行用时：6 ms, 在所有 Java 提交中击败了30.73%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了48.74%的用户
 */
public class L_136_1 {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i=i+2) {
            if(nums[i]-nums[i+1]==0){

            }
            else {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] a= {1};
        System.out.println(singleNumber(a));
    }
}
