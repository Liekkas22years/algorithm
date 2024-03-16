package oj;

import java.util.Scanner;

public class Shiya_1_3 {
    public static String str;
    public static int count;
    public static int countYeZi;//叶子数
    public static int countJieDian;//节点数
    //静态内部类，定义二叉树节点
    static class TreeNode {
        public char data;
        public TreeNode lchild;
        public TreeNode rchild;
        public int deep;
        public TreeNode(char x,int deep) {
            this.data = x;
            this.deep = deep;
            this.lchild = null;
            this.rchild = null;
        }
    }

    //根据前序序列递归构建二叉树
    public static TreeNode createBtree(int d) {
        TreeNode root = null;

        if (count >= str.length() || str.charAt(count++)=='#') {
            root = null;
        } else {
            root = new TreeNode(str.charAt(count - 1),d);
            root.lchild = createBtree(d+1);
            root.rchild = createBtree(d+1);
        }

        return root;
    }

    //前序遍历
    public static void preTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.data);
            preTraverse(root.lchild);
            preTraverse(root.rchild);
        }
    }

    //中序遍历
    public static void inTraverse(TreeNode root) {
        if (root != null) {
            inTraverse(root.lchild);
            System.out.print(root.data);
            inTraverse(root.rchild);
        }
    }

    //后序遍历
    public static void postTraverse(TreeNode root) {
        if (root != null) {
            postTraverse(root.lchild);
            postTraverse(root.rchild);
            System.out.print(root.data);
        }
    }

    //统计叶子节点
    public static int yezi(TreeNode root) {
        if (root == null)
            return 0;
        if (root.lchild==null && root.rchild==null)
            return 1;
        return yezi(root.lchild)+yezi(root.rchild);
    }

    //统计二叉树节点数
    public static int jiedian(TreeNode root){
        if (root != null) {
            jiedian(root.lchild);
            jiedian(root.rchild);
            countJieDian++;
        }
        return countJieDian;
    }

    //输出第k层上的结点个数；
    public static int countK(TreeNode root,int K){
        if(root == null){
            return 0;
        }
        if(K == 1){
            return 1;// 第一层只有一个
        }
        int left = countK(root.lchild, K - 1);
        int right = countK(root.rchild, K - 1);
        int count = left + right;
        return count;
    }

    //输出某一结点的深度
    public static int getNodeHigh(TreeNode root,char x) {
        if(root == null)
            return -1;
        if(root.data == x){
            return root.deep;
        }
        int a=getNodeHigh(root.lchild,x),b=getNodeHigh(root.rchild,x);
        return a+b+1;
    }

    //输出二叉树的深度；
    public static int deep(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 计算左子树的深度
        int left = deep(root.lchild);
        // 计算右子树的深度
        int right = deep(root.rchild);
        // 树root的深度=路径最长的子树深度 + 1
        return left >= right ? (left + 1) : (right + 1);
    }

    //交换二叉树的每个结点的左右孩子
    public static void swap(TreeNode root){
//        if (root==null)
//            return;
//        TreeNode tmp = root.lchild;
//        root.lchild = root.rchild;
//        root.rchild = tmp;
//        swap(root.lchild);
//        swap(root.rchild);

        if (root!=null){
            swap(root.lchild);
            swap(root.rchild);
            TreeNode tmp=root.lchild;
            root.lchild= root.rchild;
            root.rchild=tmp;
        }
    }


    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        str = cin.nextLine();
        int k = cin.nextInt();
        char c = cin.next().charAt(0);
        count = 0;
        countYeZi = 0;
        countJieDian = 0;
        TreeNode root = createBtree(1);

        // 前序遍历
        preTraverse(root);
        System.out.println();

        // 中序遍历
        inTraverse(root);
        System.out.println();

        // 后序遍历
        postTraverse(root);
        System.out.println();

        //叶子节点数
        System.out.println(yezi(root));

        //二叉树的结点个数
        System.out.println(jiedian(root));

        //输出第k层上的结点个数；
        System.out.println(countK(root,k));

        //输出X结点的深度（X结点不存在时，输出-1）；
        System.out.println(getNodeHigh(root,c));
        //输出二叉树的深度；
        System.out.println(deep(root));

        //输出交换二叉树的每个结点的左右孩子之后的先序遍历结果；
        swap(root);
        preTraverse(root);
    }
}

