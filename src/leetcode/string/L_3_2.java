package leetcode.string;

import java.util.HashSet;
import java.util.Set;

//无重复字符的最长子串
/*执行用时：5 ms, 在所有 Java 提交中击败了65.95%的用户
内存消耗：41.6 MB, 在所有 Java 提交中击败了22.76%的用户
通过测试用例：987 / 987*/
public class L_3_2 {
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aab";
        lengthOfLongestSubstring(s);
    }
}
