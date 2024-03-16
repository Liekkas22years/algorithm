package leetcode.linked_list;

import leetcode.bath.ListNode;

import java.util.ArrayList;
//两数相加
//暴力法
/*
通过测试用例：
1565 / 1568

[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
[5,6,4]
输出：[-3,-4,-3,-5,-7,-7,-4,-5,-8,-6,-3,0,-2,-7,-3,-3,-2,-2,-9,0]
预期结果：[6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
 */

public class L_2_1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long vlu1=0;
        long vlu2=0;
        int i=0;
        while (l1!=null){
            vlu1+= (long) (Math.pow(10,i)*l1.val);
            i++;
            l1=l1.next;
        }
        int j=0;
        while (l2!=null){
            vlu2+= (long) (Math.pow(10,j)*l2.val);
            j++;
            l2=l2.next;
        }
        long vlu;
        vlu=vlu1+vlu2;
        String str=""+vlu;
        int length=str.length();
        long[] a=new long[length];
        while (length>0){
            a[length-1]= (long) (vlu/(long) Math.pow(10,length-1));
            length--;
            vlu=vlu%(long)Math.pow(10,length);
        }
        ArrayList<ListNode> arrayList=new ArrayList();
        for(int k=0;k<a.length;k++){
            arrayList.add(new ListNode((int) a[k]));
        }
        for(int k=0;k<a.length-1;k++){
            arrayList.get(k).next=arrayList.get(k+1);
        }
        return arrayList.get(0);
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(9,l1);
        ListNode l3=new ListNode(9,l2);
        ListNode l4=new ListNode(9,l3);
        ListNode l5=new ListNode(9,l4);
        ListNode l6=new ListNode(9,l5);
        ListNode l7=new ListNode(9,l6);
        ListNode l8=new ListNode(9,l7);
        ListNode l9=new ListNode(9,l8);
        ListNode l10=new ListNode(1,l9);
        ListNode l11=new ListNode(9);
        addTwoNumbers(l11,l10);
    }
}
