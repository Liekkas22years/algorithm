package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

//只出现一次的数字 III
/*
执行用时：2 ms, 在所有 Java 提交中击败了47.26%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了64.27%的用户
 */
public class L_260_1 {
    public static int[] singleNumber(int[] nums) {
        int[] a=new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i=i+2) {
            if(nums[i]-nums[i+1]==0){

            }
            else {
                list.add(nums[i]);
                i=i-1;
            }
        }
        if(list.size()==1){
            list.add(nums[nums.length-1]);
        }
        for (int i = 0; i < list.size(); i++) {
            a[i]=list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a= {0,1};
        singleNumber(a);
    }
}
