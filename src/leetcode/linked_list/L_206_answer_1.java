package leetcode.linked_list;

import leetcode.bath.ListNode;

import java.util.ArrayList;

//反转链表
//迭代
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了26.84%的用户
 */
public class L_206_answer_1 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

























