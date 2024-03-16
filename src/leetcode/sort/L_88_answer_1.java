package leetcode.sort;

import java.util.Arrays;

//合并两个有序数组
//直接合并后排序:先将数组nums2放入数组nums1的尾部，然后排序
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了31.53%的用户
 */
public class L_88_answer_1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[]  a= {4,0,0,0,0,0};
        int[]  b= {1,2,3,5,6};
        merge(a,1,b,5);
    }
}
