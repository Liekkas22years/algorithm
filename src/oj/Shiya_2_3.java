package oj;

import java.util.*;

public class Shiya_2_3 {
    static double count2 = 2;

    static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }

    public static int insert(Tree tree, int v) {
        Tree t1 = tree;
        Tree t2 = tree;
        int high = 1;
        while (t1 != null) {
            if (t1.val == v) {
                return 0;
            } else if (t1.val > v) {
                t2 = t1;
                t1 = t1.left;
                high++;
            } else {
                t2 = t1;
                t1 = t1.right;
                high++;
            }
        }
        Tree t = new Tree();
        t.val = v;
        if (t2.val > v) {
            t2.left = t;
        } else {
            t2.right = t;
        }
        count2 += high + 1;
        return high;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double count1 = 1;
        int num = n;
        int x = 0;
        Tree tree = new Tree();
        tree.val = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            x=scanner.nextInt();
            int h = insert(tree, x);
            if (h == 0) {
                num--;
            }
            else {
                count1 += h;
            }
        }
        System.out.println(String.format("%.2f", count1 / num));
        System.out.println(String.format("%.2f", count2 / (num + 1)));
    }
}