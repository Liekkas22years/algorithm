package leetcode.string;
//字符串转换整数 (atoi)
//暴力法
/*
执行用时：9 ms, 在所有 Java 提交中击败了5.43%的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了5.61%的用
 */
public class L_8_1 {
    public static int myAtoi(String s) {
        s=s.trim();
        char[] c = s.toCharArray();
        if(c.length==0){
            return 0;
        }
        String t = "";
        if(c[0]=='-'){
            t+=c[0];
        }
        else if(c[0]=='+'){

        }
        else if(c[0]>57||c[0]<48) {
            return 0;
        }
        else if(c[0]=='0') {

        }
        else {
            t+=c[0];
        }
        for(int i=1;i<c.length;i++){
            if(t.length()>11) {
                break;
            }
            if(Character.isSpace(c[0])) {
                break;
            }
            if(c[i]>57||c[i]<48){
                break;
            }
            else if(c[i]=='.') {
                break;
            }
            else if(t.equals("")&&c[i]=='0') {

            }
            else if(t.equals("-")&&c[i]=='0'){

            }
            else {
                t+=c[i];
            }
        }
        if(t.equals("-")||t.equals("+")||t.equals("")){
            return 0;
        }
        long a = Long.valueOf(t);
        if(a>Math.pow(2, 31)) {
            a=(long) Math.pow(2, 31);
        }
        return (int) (a<Math.pow(-2, 31)?Math.pow(-2, 31): a);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("-000000000000001"));
        System.out.println(myAtoi("      -11919730356x"));
    }
}
