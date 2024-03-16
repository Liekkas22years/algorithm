package leetcode.tree;

import leetcode.bath.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的最大深度
//广度优先搜索
/*

 */
public class L_104_answer_2 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(20,t2,t3);
        TreeNode t5 = new TreeNode(3,t1,t4);
        System.out.println(maxDepth(t5));
    }
}
