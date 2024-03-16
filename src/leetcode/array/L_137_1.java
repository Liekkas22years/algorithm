package leetcode.array;

import java.util.Arrays;

//只出现一次的数字II
/*
执行用时：2 ms, 在所有 Java 提交中击败了62.52%的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了14.01%的用户
 */
public class L_137_1 {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i=i+3) {
            if(nums[i]-nums[i+1]==0){

            }
            else {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] a= {0,1,0,1,0,1,99};
        System.out.println(singleNumber(a));
    }
}
