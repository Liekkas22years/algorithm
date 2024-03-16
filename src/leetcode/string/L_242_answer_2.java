package leetcode.string;

import java.util.Arrays;

//有效的字母异位词
//哈希表
/*
执行用时：4 ms, 在所有 Java 提交中击败了44.76%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了62.05%的用户
 */
public class L_242_answer_2 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram","nagaram"));
    }
}
