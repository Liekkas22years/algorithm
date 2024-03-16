package leetcode.string;

import java.util.Arrays;

//有效的字母异位词
//排序
/*
执行用时：3 ms, 在所有 Java 提交中击败了73.84%的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了31.02%的用户
 */
public class L_242_1 {
    public static boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS,charT);
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram","nagaram"));
    }
}
