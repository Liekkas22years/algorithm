package classical_algorithm.josephus;

import oj.Houzi;

import java.util.Scanner;

//约瑟夫环---循环链表实现
public class realize_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();//表示总共有N人，数到数字M时出局

        //构建循环单链表
        Node head = new Node();
        Node p = new Node();
        Node r = new Node();
        head=p;
        for(int i=1;i<=N;i++)
        {
            p.data=i;
            if(i!=N){
                p.next = new Node();
                p = p.next;
            }
            else{
                p.next=head;
            }
        }

        while(head.next!= head)  //如果head的next=head，说明目前只有一个元素
        {
            for(int i=1;i<M;i++)  //报到数字为M的时候出局
            {
                r=head;   //保留出局的前一个结点
                head=head.next; //head指向的是要出局的这个结点，需要保留前一个结点
            }
            System.out.println(head.data+" ");
            r.next=head.next;
            head=head.next;
        }
        System.out.println("last one: "+head.data);
    }

    static class Node{
        public int data;
        public Node next;
    }
}



