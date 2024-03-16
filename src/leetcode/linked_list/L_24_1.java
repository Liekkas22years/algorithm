package leetcode.linked_list;

// 反转链表
// 如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为 O(1)
public class L_24_1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
