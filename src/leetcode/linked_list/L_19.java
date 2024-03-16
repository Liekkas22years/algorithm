package leetcode.linked_list;

import leetcode.bath.ListNode;

import java.util.ArrayList;

public class L_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null ||head==null){
            return null;
        }
        int count = 0;
        ArrayList<ListNode> arrayList = new ArrayList<>();
        while (head!=null){
            arrayList.add(new ListNode(head.val));
            head=head.next;
            count++;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(n==1 && i==count-n-1){
                break;
            }
            else if(i==count-n){
                arrayList.get(i).val=arrayList.get(i+1).val;
                break;
            }
            else {
                arrayList.get(i).next=arrayList.get(i+1);
            }
        }
        return arrayList.get(0);
    }

    public static void main(String[] args) {
        ListNode l5=new ListNode(2);
        ListNode l6=new ListNode(1,l5);
        removeNthFromEnd(l6,1);
    }
}
