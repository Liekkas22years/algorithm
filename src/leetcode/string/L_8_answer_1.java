package leetcode.string;

//字符串转换整数 (atoi)
/*
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了26.56%的用户
 */
public class L_8_answer_1 {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("  0000000000012345678"));
    }
}
