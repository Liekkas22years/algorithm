package leetcode.string;
//字符串中的第一个唯一字符
/*
执行用时：18 ms, 在所有 Java 提交中击败了65.09%的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了81.28%的用户
 */
public class L_387_1 {
    public static int firstUniqChar(String s) {
        char[] a=s.toCharArray();
        if(a.length==1){
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<a.length;j++){
                if(a[i]!=a[j]&&j==a.length-1){
                    return i;
                }
                if(a[i]==a[j]&&i!=j){
                    break;
                }
                if(i==a.length-1&&j==a.length-1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "dddccdbba";
        System.out.println(firstUniqChar(s));
    }
}
