package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Xunhuandanlianb {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        //实现一个循环链表
        Node list = new Node();
        Node first = new Node();
        first = list;
        for (int i = 0; i < length; i++) {
            if(i<length-1) {
                list.value = i;
                list.next = new Node();
                list = list.next;
            }else{  //将首节点的地址赋给尾节点的next，实现循环
                list.value = i;
                list.next = first;
                list = first;
            }
        }
        while (list!=null){
            System.out.println(list.value);
            list = list.next;
            Thread.sleep(1000);
        }


    }
    //使用静态内部类定义链表节点
    static class Node {
        public int value;
        public Node next;

    }
}
