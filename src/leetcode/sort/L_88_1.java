package leetcode.sort;

import java.util.Arrays;

//合并两个有序数组
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了55.55%的用户
 */
public class L_88_1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //如果nums1为空，nums1=nums2
        if(nums1.length==n){
            for (int i = 0; i < nums2.length; i++) {
                nums1[i]=nums2[i];
            }
            return;
        }
        int[] num= new int[nums1.length-n];
        //将nums1中要排序的值取出
        for(int i=0;i<num.length;i++){
            num[i]=nums1[i];
        }
        int l1=0;
        int l2=0;
        int i=-1;
        //一一比较两个数组，存入nums1
        while (l1<num.length||l2<nums2.length){
            i++;
            if(l1==num.length){
                nums1[i]=nums2[l2++];
            }
            else if(l2== nums2.length){
                nums1[i]=num[l1++];
            }
            else if(num[l1]>=nums2[l2]){
                nums1[i]=nums2[l2++];
            }
            else {
                nums1[i]=num[l1++];
            }
        }
    }

    public static void main(String[] args) {
        int[]  a= {4,0,0,0,0,0};
        int[]  b= {1,2,3,5,6};
        merge(a,1,b,5);
    }
}
