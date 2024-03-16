package leetcode.double_pointer;

import java.util.Arrays;
//两数之和
//双指针
/*执行用时：61 ms, 在所有 Java 提交中击败了10.48%的用户
内存消耗：41.8 MB, 在所有 Java 提交中击败了7.44%的用户
通过测试用例：57 / 57*/
public class L_1_1 {
    public static int[] twoSum(int[] nums, int target) {
        int i=0,j=1;
        int[] array = new int[2];
        int count;
        while (i< nums.length){
            count=nums[i]+nums[j];
            if(count==target){
                array[0]=i;
                array[1]=j;
                break;
            }
            else if(j==nums.length-1){
                i++;
                j=i+1;
            }
            else {
                j++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int t =10;
        twoSum(nums,t);
    }
}
