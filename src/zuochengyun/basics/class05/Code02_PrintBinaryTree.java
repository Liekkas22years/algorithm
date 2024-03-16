package zuochengyun.basics.class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Code02_PrintBinaryTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 求二叉树结点最多的那一层的节点个数，即二叉树的最大宽度
	public static int maxWidth(Node head) {
		if (head == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		HashMap<Node,Integer> levelMap = new HashMap<>();
		levelMap.put(head,1);// 放入根节点及其所在的层数
		int curLevel = 1; // 当前节点所在的层数,初始值是根节点所在的层数
		int curLevelNodes = 0;// 当前层的节点数
		int max = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curNodeLevel = levelMap.get(cur); //得到当前节点的层数
			if (curNodeLevel == curLevel) { //当前节点所在的层数等于我想统计的那一层
				curLevelNodes++;
			} else {
				max = Math.max(max,curLevelNodes);// 上一层节点数更新max
				curLevel++;
				curLevelNodes = 1;
			}
			if (cur.left != null) {
				levelMap.put(cur.left,curLevel+1);// 登记弹出节点左孩子所在的层数
				queue.add(cur.left);
			}
			if (cur.right != null) {
				levelMap.put(cur.right,curLevel+1);// 登记弹出节点右孩子所在的层数
				queue.add(cur.right);
			}
		}
		return Math.max(max,curLevelNodes);// 如果最后一层是最宽的，需要再比较一下
	}

	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(-222222222);
		head.right = new Node(3);
		head.left.left = new Node(Integer.MIN_VALUE);
		head.right.left = new Node(55555555);
		head.right.right = new Node(66);
		head.left.left.right = new Node(777);
		printTree(head);

		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.left.left.right = new Node(7);
		printTree(head);

		head = new Node(1);
		head.left = new Node(1);
		head.right = new Node(1);
		head.left.left = new Node(1);
		head.right.left = new Node(1);
		head.right.right = new Node(1);
		head.left.left.right = new Node(1);
		printTree(head);

	}

}
