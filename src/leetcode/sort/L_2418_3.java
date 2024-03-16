package leetcode.sort;
// 按身高排序
// 选择排序

/**
 * 执行用时：10 ms, 在所有 Java 提交中击败了30.13%的用户
 * 内存消耗：41.9 MB, 在所有 Java 提交中击败了60.91%的用户
 * 通过测试用例：68 / 68
 */
public class L_2418_3 {

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;

        for (int i = n; i > 0; i--) {
            int max = n - i;
            for (int j = n - i; j < n; j++) {
                max = heights[j] > heights[max] ? j : max;
            }
            swap(names,heights,n-i,max);
        }
        return  names;
    }

    public static void swap(String[] names, int[] heights, int i, int j) {
        String t = names[i];
        names[i] = names[j];
        names[j] = t;
        int tt = heights[i];
        heights[i] = heights[j];
        heights[j] = tt;
    }

    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma","Alice","Bob","Bob"};
        int[] heights = {180,165,170,155,185,150};
        sortPeople(names,heights);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
