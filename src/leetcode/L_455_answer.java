package leetcode;

import java.util.Arrays;

//分发饼干
/*
执行用时：7 ms, 在所有 Java 提交中击败了99.75%的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了32.57%的用户
通过测试用例：21 / 21
 */
public class L_455_answer {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g={1,2,3};
        int[] s={1,2};
        L_455_answer.findContentChildren(g,s);

    }
}
