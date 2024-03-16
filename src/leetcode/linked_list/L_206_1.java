package leetcode.linked_list;

import leetcode.bath.ListNode;

import java.util.ArrayList;

//反转链表
/*
执行用时：1 ms, 在所有 Java 提交中击败了5.65%的用户
内存消耗：38 MB, 在所有 Java 提交中击败了85.19%的用户
 */
public class L_206_1 {
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ArrayList<ListNode> list =new ArrayList<>();
        //取下每个节点
        while(head!=null){
            list.add(new ListNode(head.val));
            head=head.next;
        }
        //倒序连接
        for(int i=list.size()-1;i>0;i--){
            list.get(i).next=list.get(i-1);
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
        ListNode l2=new ListNode(4,l1);
        ListNode l3=new ListNode(3,l2);
        ListNode l4=new ListNode(2,l3);
        ListNode l5=new ListNode(1,l4);
        reverseList(l5);
    }

}

























