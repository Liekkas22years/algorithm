package leetcode.linked_list;

import leetcode.bath.ListNode;

import java.util.ArrayList;
//两数相加
//模拟
/*
执行用时：2 ms, 在所有 Java 提交中击败了91.55%的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了33.51%的用户
 */

public class L_2_answer_1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(3);
        ListNode l2=new ListNode(4,l1);
        ListNode l3=new ListNode(2,l2);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(6,l4);
        ListNode l6=new ListNode(5,l5);
        addTwoNumbers(l3,l6);
    }
}
