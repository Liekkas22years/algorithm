package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两个数组的交集 II
//排序
/*
执行用时：1 ms, 在所有 Java 提交中击败了99.96%的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了34.19%的用户
 */
public class L_350_answer_2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        intersect(nums1,nums2);
    }
}
