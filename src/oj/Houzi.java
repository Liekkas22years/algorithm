package oj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Houzi {
    public static void main(String[] args) throws InterruptedException {
        Node list = new Node();
        Node first = new Node();
        first = list;
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] array = new int[m];
        int count = 0;//链表长度
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<n;i++) {
            if(i<n-1) {
                list.value = scanner.nextInt();
                if(!map.containsKey(list.value)){
                    map.put(list.value,1);
                }
                else {
                    int t=map.get(list.value);
                    t++;
                    map.put(list.value,t);
                }
                list.num=i;
                list.next = new Node();
                list = list.next;
                count++;
            }else{
                //将首节点的地址赋给尾节点的next，实现循环
                list.value = scanner.nextInt();
                if(!map.containsKey(list.value)){
                    map.put(list.value,1);
                }
                else {
                    int t=map.get(list.value);
                    t++;
                    map.put(list.value,t);
                }
                list.num=i;
                list.next = first;
                list = first;
                count++;
            }
        }
        if(map.size()==1){
            System.out.print(n);
            return;
        }
        for(int i=0;i<m;i++) {
            array[i]=scanner.nextInt();
            //开始筛选大王
            while (map.get(array[i])>0){
                if(count==1){
                    System.out.print(list.num+1);
                    break;
                }
                else if(list.next.value==array[i]){
                    //删除当前节点
                    list.next=list.next.next;
                    int t = map.get(array[i]);
                    t--;
                    map.put(array[i],t);
                    count--;
                }
                else {
                    list = list.next;
                }
            }
        }

    }
    //使用静态内部类定义链表节点
    static class Node {
        public int value;
        public Node next;
        public int num;//记录编号
    }
}

