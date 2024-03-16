package leetcode.string;
//反转字符串
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：44.8 MB, 在所有 Java 提交中击败了84.51%的用户
 */
public class L_344_1 {
    public static void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        char t;
        while(l<r){
            t=s[l];
            s[l]=s[r];
            s[r]=t;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] a={'q','t','r'};
        reverseString(a);
    }
}
