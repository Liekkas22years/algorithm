package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

//两个数组的交集 II
//排序
/*
执行用时：2 ms, 在所有 Java 提交中击败了77.37%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了55.71%的用户
 */
public class L_350_1 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list =new ArrayList<>();
        int l1=0;
        int l2=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (l1<nums1.length&&l2<nums2.length){
            if (nums1[l1]==nums2[l2]){
                list.add(nums1[l1]);
                l1++;
                l2++;
                continue;
            }
            if (nums1[l1]>nums2[l2]){
                l2++;
                continue;
            }
            if (nums1[l1]<nums2[l2]){
                l1++;
            }
        }
        int[] a=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i]=list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        intersect(nums1,nums2);
    }
}
