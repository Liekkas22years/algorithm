package leetcode.tree;

import leetcode.bath.TreeNode;

//二叉树的最大深度
//深度优先搜索
/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了35.38%的用户
 */
public class L_104_answer_1 {
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else {
            int leftH=maxDepth(root.left);
            int rightH=maxDepth(root.right);
            return Math.max(leftH,rightH)+1;
        }
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
