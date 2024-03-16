package leetcode.other;

import java.util.Stack;

//有效的括号
//栈
/*
执行用时：2 ms, 在所有 Java 提交中击败了57.07%
内存消耗：36.5 MB, 在所有 Java 提交中击败了50.09%的用户
 */
public class L_20_1 {
    public static boolean isValid(String s) {
        char[] c=s.toCharArray();
        Stack stack=new Stack();
        for (int i = 0; i < c.length; i++) {
            if(c[i]=='('||c[i]=='{'||c[i]=='['){
                stack.push(c[i]);
            }
            if(stack.empty()&&(c[i]==')'||c[i]=='}'||c[i]==']')){
                stack.push(c[i]);
                continue;
            }
            if(c[i]==')'&&(char)stack.peek()=='('){
                stack.pop();
                continue;
            }
            if(c[i]==')'&&(char)stack.peek()!='('){
                stack.push(c[i]);
            }
            if(c[i]=='}'&&(char)stack.peek()=='{'){
                stack.pop();
                continue;
            }
            if(c[i]=='}'&&(char)stack.peek()!='{'){
                stack.push(c[i]);
            }
            if(c[i]==']'&&(char)stack.peek()=='['){
                stack.pop();
                continue;
            }
            if(c[i]==']'&&(char)stack.peek()!='['){
                stack.push(c[i]);
            }
        }
        if(stack.empty()){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
