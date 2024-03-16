package leetcode.linked_list;

// 相交链表
/*执行用时：1 ms, 在所有 Java 提交中击败了98.27%的用户
内存消耗：44.1 MB, 在所有 Java 提交中击败了69.72%的用户
通过测试用例：39 / 39*/
public class L_160_1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l_A = 0;
        int l_B = 0;
        ListNode l = headA;
        ListNode A =headA;
        ListNode B = headB;
        while (l != null) {
            l_A++;
            l = l.next;
        }
        l = headB;
        while (l != null) {
            l_B++;
            l = l.next;
        }
        int n = Math.abs(l_A - l_B);
        if (l_A > l_B) {
            while (n > 0) {
                A = A.next;
                n--;
            }

        } else {
            while (n > 0) {
                B = B.next;
                n--;
            }
        }
        while (A != null || B != null) {
            if (A == B) {
                return A;
            }
            A = A.next;
            B = B.next;
        }
        return null;
    }
}
