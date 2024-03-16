package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

// 二叉树的序列化与反序列化
public class L_297_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String str = root.val + "_";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split("_");
        Queue<String> queue = new LinkedList();
        for (int i = 0; i < str.length; i++) {
            queue.add(str[i]);
        }
        return bulidTree(queue);
    }

    public TreeNode bulidTree(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(str));
        head.left = bulidTree(queue);
        head.right = bulidTree(queue);
        return head;
    }
}
