package leetcode.string;

//无重复字符的最长子串
/*执行用时：5 ms, 在所有 Java 提交中击败了65.95%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了5.36%的用户
通过测试用例：987 / 987*/
public class L_3_1 {
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder builder = new StringBuilder();
        int l=0;
        for(int i=0;i<s.length();i++){
            String c = String.valueOf(s.charAt(i));//String.charAt()方法返回指定索引处的char值
            if (builder.indexOf(c) >= 0) {
                builder.delete(0, builder.indexOf(c) + 1);
            }

            builder.append(c);

            l=Math.max(l,builder.length());
        }
        return l;
    }

    public static void main(String[] args) {
        String s = "aab";
        lengthOfLongestSubstring(s);
    }
}
