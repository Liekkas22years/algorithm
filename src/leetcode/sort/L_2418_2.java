package leetcode.sort;
// 按身高排序
// 插入排序

/**
 * 执行用时：19 ms, 在所有 Java 提交中击败了14.92%的用户
 * 内存消耗：42.5 MB, 在所有 Java 提交中击败了5.10%的用户
 * 通过测试用例：68 / 68
 */
public class L_2418_2 {

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[j+1]) {
                    swap(names,heights,j,j+1);
                }
            }
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
