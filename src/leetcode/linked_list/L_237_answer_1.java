package leetcode.linked_list;

//删除链表中的节点
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了77.26%的用户
 */
public class L_237_answer_1 {
    public void deleteNode(ListNode1 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}