package zuochengyun.basics.class05;

public class Code06_IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 判断一颗二叉树是否是平衡二叉树，使用树型DP方法
	public static boolean isBalanced(Node head) {
		return process(head).isBalanced;
	}

	public static class ReturnType {
		public boolean isBalanced;
		public int height;

		public ReturnType(boolean isB, int hei) {
			isBalanced = isB;
			height = hei;
		}
	}

	public static ReturnType process(Node x) {
		if (x == null) {
			return new ReturnType(true, 0);
		}
		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);
		int height = Math.max(leftData.height, rightData.height);
		boolean isBalanced = leftData.isBalanced && rightData.isBalanced
				&& Math.abs(leftData.height - rightData.height) < 2;
		return new ReturnType(isBalanced, height);
	}
}
