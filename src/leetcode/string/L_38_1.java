package leetcode.string;

import java.util.Stack;

//外观数列
/*
执行用时：40 ms, 在所有 Java 提交中击败了5.81%的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了5.10%的用户
 */
public class L_38_1 {
    public static String countAndSay(int n) {
        String[] s = new String[n];
        s[0]="1";
        /*s[1]="11";
        s[2]="21";
        s[3]="1211";
        s[4]="111221";*/
        Stack<Character> stack = new Stack<>();
        char[] c;
        int l=0;
        int r=0;
        for(int i=1;i<n;i++){
            c = s[i-1].toCharArray();
            int j=0;
            while (j<c.length){
                if(stack.empty()){
                    stack.push(c[j]);
                }
                else if(stack.peek()==c[j]){
                    stack.push(c[j]);
                }
                else{
                    if(s[i]==null){
                        s[i]=stack.size()+""+c[j-1];
                    }
                    else {
                        s[i]+=stack.size()+""+c[j-1];
                    }
                    stack.clear();
                    stack.push(c[j]);
                }
                if(j==c.length-1){
                    if(s[i]==null){
                        s[i]=stack.size()+""+c[j];
                    }
                    else {
                        s[i]+=stack.size()+""+c[j];
                    }
                    stack.clear();
                }
                j++;
            }
        }
        return s[n-1];
    }

    public static void main(String[] args) {
        countAndSay(5);
    }
}
