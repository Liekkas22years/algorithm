package leetcode;

import java.util.Arrays;

//分发饼干
/*
执行用时：7 ms, 在所有 Java 提交中击败了99.75%的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了97.61%的用户
通过测试用例：21 / 21
 */
public class L_455_1 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int k=0;
        int t=0;
        int j;
        for (int i = 0; i < g.length; i++) {
            for (j = t; j < s.length; j++) {
                if(s[j]>=g[i]){
                    k++;
                    t=j+1;
                    break;
                }
            }
            if(j==s.length){
                break;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] g={1,2,3};
        int[] s={1,2};
        L_455_1.findContentChildren(g,s);

    }
}
