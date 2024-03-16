package leetcode.stack;

import java.util.ArrayList;
//最小栈
/*
执行用时：278 ms, 在所有 Java 提交中击败了5.01%的用户
内存消耗：40 MB, 在所有 Java 提交中击败了75.90%的用户
 */
public class L_155_1 {
    public ArrayList<Integer> list=new ArrayList<>(0);

    public L_155_1() {

    }

    //将元素 x 推入栈中
    public void push(int val) {
        list.add(val);
    }
    //删除栈顶的元素
    public void pop() {
        list.remove(list.size()-1);
    }
    //获取栈顶元素
    public int top() {
        return list.get(list.size()-1);
    }
    //检索栈中的最小元素
    public int getMin() {
        int min=list.get(0);
        for(int i:list){
            if(i<min){
                min=i;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        L_155_1 obj = new L_155_1();
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
