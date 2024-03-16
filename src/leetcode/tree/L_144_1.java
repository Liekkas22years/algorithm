package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

// 二叉树的前序遍历
// 递归
/* 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了16.21%的用户
通过测试用例：69 / 69 */
public class L_144_1 {
    List<Integer> list = new ArrayList<>();
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
