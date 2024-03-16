package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

//最小栈
/*
执行用时：5 ms, 在所有 Java 提交中击败了67.35%的用户
内存消耗：40 MB, 在所有 Java 提交中击败了68.84%的用户
 */
public class L_155_2 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public L_155_2() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    //将元素 x 推入栈中
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    //删除栈顶的元素
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    //获取栈顶元素
    public int top() {
        return xStack.peek();
    }
    //检索栈中的最小元素
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        L_155_2 obj = new L_155_2();
        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
}
