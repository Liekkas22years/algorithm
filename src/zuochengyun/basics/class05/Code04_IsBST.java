package zuochengyun.basics.class05;

import java.util.LinkedList;

public class Code04_IsBST {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int preValue = Integer.MIN_VALUE;

	// 判断一颗二叉树是否是二叉搜索树
	public static boolean checkBST(Node head) {
		if (head == null) {
			return true;
		}
		boolean leftIsBST = checkBST(head.left);
		if (!leftIsBST) {
			return false;
		}
		if (head.value <= preValue) {
			return false;
		} else {
			preValue = head.value;
		}
		return checkBST(head.right);
	}

	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> inOrderList = new LinkedList<>();
		process(head, inOrderList);
		int pre = Integer.MIN_VALUE;
		for (Node cur : inOrderList) {
			if (pre >= cur.value) {
				return false;
			}
			pre = cur.value;
		}
		return true;
	}

	public static void process(Node node, LinkedList<Node> inOrderList) {
		if (node == null) {
			return;
		}
		process(node.left, inOrderList);
		inOrderList.add(node);
		process(node.right, inOrderList);
	}

	// 判断一颗二叉树是否是二叉搜索树，使用树型DP方法
	public static boolean isBST2(Node head) {
		return process(head).isBST;
	}

	public static class ReturnType {
		public boolean isBST;
		public int max;
		public int min;

		public ReturnType(boolean isBST,int max,int min) {
			this.isBST = isBST;
			this.max = max;
			this.min = min;
		}
	}

	public static ReturnType process(Node x) {
		if (x == null) {
			return null;
		}

		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);
		int min = x.value;
		int max = x.value;

		if (leftData != null) {
			min = Math.min(min,leftData.min);
		}
		if (rightData != null) {
			max = Math.max(max,rightData.max);
		}

		boolean isBST = true;

		if (leftData != null && (!leftData.isBST || leftData.max >= x.value)) {
			isBST = false;
		}
		if (rightData != null && (!rightData.isBST || rightData.min <= x.value)) {
			isBST = false;
		}

		return new ReturnType(isBST,max,min);
	}

	// 判断一颗二叉树是否是满二叉树，使用树型DP方法
	public static boolean isFull(Node head) {
		return process1(head).nodes == ( 1 << process1(head).height - 1);// return process1(head).nodes == Math.pow(2,process1(head).height)-1;
	}

	public static class Info {
		public int height;
		public int nodes;

		public Info(int h,int n){
			this.height = h;
			this.nodes = n;
		}
	}

	public static Info process1(Node x) {
		if (x == null) {
			return new Info(0,0);
		}

		Info leftData = process1(x.left);
		Info rightData = process1(x.right);

		int height = Math.max(leftData.height,rightData.height) + 1;
		int nodes = leftData.nodes + rightData.nodes + 1;

		return new Info(height,nodes);
	}
}
