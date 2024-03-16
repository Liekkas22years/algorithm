package base.linked_list;


public class DoubleLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DoubleListDemo list = new DoubleListDemo();
        ListNode n1 = new ListNode(1, "a");
        ListNode n2 = new ListNode(2, "b");
        ListNode n3 = new ListNode(3, "c");
        ListNode n4 = new ListNode(4, "d");
        ListNode n5 = new ListNode(5, "e");
        ListNode n6 = new ListNode(6, "f");
        list.addListNode(n1);
        list.addListNode(n2);
        list.addListNode(n3);
        System.out.println("-------添加节点测试");
        list.showListNode(list.getHead());
        System.out.println("-------修改节点测试");
        list.updataListNode(new ListNode(3, "q"));
        list.showListNode(list.getHead());
        System.out.println("-------删除节点测试");
        list.delListNode(n4);
        list.delListNode(n3);
        list.delListNode(n2);
        list.delListNode(n1);
        list.showListNode(list.getHead());
        System.out.println("-------有序加入节点测试");
        list.addReorder(n4);
        //System.out.println(n4.pre);
        //System.out.println("测试");
        //list.showListNode(list.getHead());
        list.addReorder(n2);
        //System.out.println(n2.pre);
        //System.out.println(n4.pre);
        //System.out.println("测试");
        //list.showListNode(list.getHead());
        list.addReorder(n3);
        //System.out.println("测试");
        //list.showListNode(list.getHead());
        list.addReorder(n1);
        list.addListNode(n5);
        //System.out.println("测试");
        //list.showListNode(list.getHead());
        //System.out.println("测试");
        list.showListNode(list.getHead());
        System.out.println("测试前节点是否正确");
        System.out.println(n1.pre);
        System.out.println(n2.pre);
        System.out.println(n3.pre);
        System.out.println(n4.pre);
        System.out.println(n5.pre);
    }

}

class ListNode {
    public int id;
    public String name;
    public ListNode pre;
    public ListNode next;

    public ListNode(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return ("ListNode [id = " + id + ", name = " + name + "];");
    }
}

class DoubleListDemo{
    private ListNode head = new ListNode(0, "");
    //获取头结点
    public ListNode getHead() {
        return head;
    }
    //添加节点
    public void addListNode(ListNode listNode) {
        ListNode temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = listNode;
        listNode.pre = temp;
    }
    //显示链表节点
    public void showListNode(ListNode head) {
        ListNode temp = head;
        if(temp.next == null) {
            System.out.println("空链表，无法显示");
            return;
        }
        while(temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
    //修改节点
    public void updataListNode(ListNode listNode) {
        ListNode temp = head;
        while(temp.next != null) {
            if(temp.next.id == listNode.id) {
                temp.next = listNode;
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有找到要修改的节点");
    }
    //删除节点
    public void delListNode(ListNode listNode) {
        ListNode temp = head;
        if(temp.next == null) {
            System.out.println("空链表，无法删除");
            return;
        }
        while(temp.next != null) {
            if (temp.next.id == listNode.id) {
                if(temp.next.next != null) {
                    temp.next = temp.next.next;
                    temp.next.next.pre = temp;
                    return;
                }else {
                    temp.next = temp.next.next;
                    return;
                }
            }
            temp = temp.next;
        }
        System.out.println("未找到待删除的节点");
    }
    //有序添加
    public void addReorder(ListNode listNode) {
        ListNode temp = head;
        if(temp.next == null) {
            temp.next = listNode;
            listNode.pre = temp;
            return;
        }
        while(temp.next != null) {
            if(temp.next.id > listNode.id) {
                temp.next.pre = listNode;
                listNode.next= temp.next;
                listNode.pre = temp;
                temp.next = listNode;
                return;
            }else if (temp.next.id == listNode.id) {
                System.out.println("节点" + listNode.id + "已存在");
                return;
            }
            temp = temp.next;
        }
        temp.next = listNode;
        listNode.pre = temp;
    }
    //
}


