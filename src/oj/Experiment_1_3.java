package oj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Experiment_1_3 {
    //二叉树的数据结果
    static class BinaryTree{
        char val;//根节点数据
        BinaryTree left;//左子树
        BinaryTree right;//右子树
        public BinaryTree(char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //向二叉排序树中插入子树
    public void insert(BinaryTree root, char data){
        //二叉排序树的右节点都比根节点大
        if(data > root.val){
            if(root.right == null)
                root.right = new BinaryTree(data);
            else
                this.insert(root.right,data);//递归插入子节点
        }
        //二叉排序树的左节点都比根节点小
        else{
            if(root.left == null)
                root.left = new BinaryTree(data);
            else
                this.insert(root.left, data);//递归插入子节点
        }
    }

    //构造二叉树
    public void insertTree(BinaryTree root, char data){
        if(root.left == null && root.val!='#') {
            root.left = new BinaryTree(data);
        }
        else if(root.right == null && root.val!='#') {
            root.right = new BinaryTree(data);
        }
        else if(root.left != null && root.left.val!='#'){
            this.insert(root.left, data);//递归插入子节点
        }
        else if(root.right != null && root.right.val!='#'){
            this.insert(root.right, data);//递归插入子节点
        }
    }

    //先序遍历
    public static void preOrder(BinaryTree root){
        if(root != null && root.val!='#'){
            System.out.print(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //层次遍历
    public void layoutOrder(BinaryTree root){
        if(root == null){
            return;
        }
        Queue<BinaryTree> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTree node = queue.poll();
            System.out.print(node.val +" ");
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }

        System.out.println();
    }

    //中序遍历
    public static void inOrder(BinaryTree root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val+"-");
            inOrder(root.right);
        }
    }

    //后序遍历
    public static void postOrder(BinaryTree root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+"-");
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = "ABD##E#G##CF###";
        //scanner.nextLine();
        char[] chars = str.toCharArray();
        Experiment_1_3 btb = new Experiment_1_3();
        BinaryTree root = new BinaryTree(chars[0]);
        for(int i = 1; i<chars.length; i++){
            btb.insertTree(root, chars[i]);
        }
        System.out.print("先序遍历：");
        preOrder(root);
        System.out.println("");
        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println("");
        System.out.print("后序遍历：");
        postOrder(root);
    }
}
