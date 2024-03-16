package zuochengyun.basics.class04;

public class Code07_FindFirstIntersectNode {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		// 俩链表都无环
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		// 俩链表都有环
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		// 一个链表有环，一个无环，一定不相交
		return null;
	}

	// 找到链表第一个入环节点，如果无环，返回null
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	// 如果两个链表都无环，返回第一个相交节点，如果不相交，返回null
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0; // 链表1和链表2的长度都用n表示，最后n表示的是链表1和链表2的长度的差值
		while (cur1.next != null) { // 来到最后一个节点停
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) { // 链表1最后一个节点的内存地址和链表2最后一个节点的内存地址不相等，则一定不相交
			return null;
		}
		cur1 = n > 0 ? head1 : head2; // 谁长，谁的头变成cur1
		cur2 = cur1 == head1 ? head2 : head1; // 谁短，谁的头变成cur2
		n = Math.abs(n);
		while (n != 0) { // 长链表先走差值的部分
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) { // 然后长链表和短链表一起走，直到再次相遇
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1; // 返回第一个相遇的节点
	}

	// 两个有环链表，返回第一个相交节点，如果不相交返回null
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) { // loop1,loop2为入环的第一个节点
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) { // 情况2，两链表的入环节点相同，将入环节点看做是最后一个节点
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else { // 情况3 两链表入环节点不相同
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null; // 当链表1转回去也没遇见链表2，则不相交，情况1
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
