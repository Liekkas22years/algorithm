package leetcode.string;

import java.util.Stack;

//外观数列
/*
执行用时：40 ms, 在所有 Java 提交中击败了5.81%的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了5.10%的用户
 */
public class L_38_answer_1 {
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        countAndSay(5);
    }
}
