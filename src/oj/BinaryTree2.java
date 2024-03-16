package oj;

import java.util.Scanner;

public class BinaryTree2 {
    static String str;
    static int count = 0;
    static int countYeZi = 0;
    static int countJieDian = 0;

    static class TreeNode {
        public char data;
        public TreeNode lchild;
        public TreeNode rchild;
        public int deep;
        public TreeNode(char x,int deep) {
            this.data = x;
            this.deep = deep;
        }
    }

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

    public static void preTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.data);
            preTraverse(root.lchild);
            preTraverse(root.rchild);
        }
    }


    public static void inTraverse(TreeNode root) {
        if (root != null) {
            inTraverse(root.lchild);
            System.out.print(root.data);
            inTraverse(root.rchild);
        }
    }


    public static void postTraverse(TreeNode root) {
        if (root != null) {
            postTraverse(root.lchild);
            postTraverse(root.rchild);
            System.out.print(root.data);
        }
    }


    public static int yezi(TreeNode root) {
        if (root.lchild != null && root.rchild !=null) {
            yezi(root.lchild);
            yezi(root.rchild);
        }
        else {
            countYeZi++;
        }
        return countYeZi;
    }


    public static int jiedian(TreeNode root){
        if (root != null) {
            jiedian(root.lchild);
            jiedian(root.rchild);
            countJieDian++;
        }
        return countJieDian;
    }


    public static int countK(TreeNode root,int K){
        if(root == null){
            return 0;
        }
        if(K == 1){
            return 1;
        }
        int left = countK(root.lchild, K - 1);
        int right = countK(root.rchild, K - 1);
        int count = left + right;
        return count;
    }


    public static void getNodeHigh(TreeNode root,String s) {
        if(root == null){
            return ;
        }
        char x = s.charAt(0);
        int index=str.indexOf(String.valueOf(x));
        if(index<0 || s.length()>1 || x=='#') {
            System.out.println(-1);
            return ;
        }
        if(root.data == x){
            System.out.println(root.deep);
        }
        else {
            getNodeHigh(root.lchild,s);
            getNodeHigh(root.rchild,s);
        }

    }


    public static int deep(TreeNode root){
        if (root == null) {
            return 0;
        }

        int left = deep(root.lchild);

        int right = deep(root.rchild);

        return left >= right ? (left + 1) : (right + 1);
    }


    public static void swap(TreeNode root){

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
        String s = cin.next();
        TreeNode root = createBtree(1);

        preTraverse(root);
        System.out.println();

        inTraverse(root);
        System.out.println();

        postTraverse(root);
        System.out.println();

        System.out.println(yezi(root));

        System.out.println(jiedian(root));

        System.out.println(countK(root,k));

        getNodeHigh(root,s);

        System.out.println(deep(root));

        swap(root);
        preTraverse(root);
    }
}