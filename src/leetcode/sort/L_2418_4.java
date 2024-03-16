package leetcode.sort;
// 按身高排序
// 归并排序

/**
 * 执行用时：3 ms, 在所有 Java 提交中击败了97.87%的用户
 * 内存消耗：41.8 MB, 在所有 Java 提交中击败了86.98%的用户
 * 通过测试用例：68 / 68
 */
public class L_2418_4 {

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        mergeSort(names,heights,0,n-1);
        return  names;
    }

    public static void mergeSort(String[] names, int[] heights, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(names,heights,l,mid);
        mergeSort(names,heights,mid + 1,r);
        merge(names,heights,l,mid,r);
    }

    public static void merge(String[] names, int[] heights, int l, int m,int r) {
        int[] help = new int[r - l + 1];
        String[] help2 = new String[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            help2[i] = heights[p1] > heights[p2] ? names[p1] : names[p2];
            help[i++] = heights[p1] > heights[p2] ? heights[p1++] : heights[p2++];
        }
        while (p1 <= m) {
            help2[i] = names[p1];
            help[i++] = heights[p1++];
        }
        while (p2 <= r) {
            help2[i] = names[p2];
            help[i++] = heights[p2++];
        }
        for (int j = 0; j < r - l + 1; j++) {
            heights[l + j] = help[j];
            names[l + j] = help2[j];
        }
    }

    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma","Alice","Bob","Bob"};
        int[] heights = {180,165,170,155,185,150};
        sortPeople(names,heights);
        for (int i = 0; i < heights.length; i++) {
            System.out.println(heights[i]+" "+names[i]);
        }

    }
}
