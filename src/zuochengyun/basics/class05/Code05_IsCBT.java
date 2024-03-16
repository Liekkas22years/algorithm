package zuochengyun.basics.class05;

import java.util.LinkedList;

public class Code05_IsCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 判断一颗二叉树是完全二叉树
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> queue = new LinkedList<>();
		// 是否遇到过左右两个孩子不双全的节点
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if (
					(leaf && (l != null || r != null))//已经遇到过左右两个孩子不双全的节点，并且此时节点有孩子(不是叶子节点)，直接返回false
					||
					(l == null && r != null)// 有右孩子无左孩子，直接返回false
			   ) {
				return false;
			}
			if (l != null) {
				queue.add(l);
			}
			if (r != null) {
				queue.add(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}

}
