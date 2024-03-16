package test;

import java.util.ArrayList;
import java.util.List;
public class BTreeTest {
    public static void test01(){
        BTree<Integer, Integer> btree = new BTree<Integer, Integer>(4);
        List<Integer> insertList = new ArrayList<Integer>();
        insertList.add(2);
        insertList.add(3);
        insertList.add(5);
        insertList.add(7);
        insertList.add(10);
        insertList.add(17);
        insertList.add(19);
        insertList.add(22);
        insertList.add(28);
        insertList.add(33);

        for (int i = 0; i < insertList.size(); ++i) {
            Integer r = insertList.get(i);
            Entry entry = new Entry<Integer, Integer>();
            entry.setKey(r);
            entry.setValue(r);
            btree.insert(entry);
        }
        btree.output();
        /*List<Integer> deleteList = new ArrayList<Integer>();
        deleteList.add(10);
        deleteList.add(20);
        deleteList.add(30);
        deleteList.add(40);
        deleteList.add(50);
        deleteList.add(60);
        deleteList.add(70);
        deleteList.add(80);
        deleteList.add(90);
        deleteList.add(100);
        deleteList.add(110);
        deleteList.add(120);
        deleteList.add(130);
        deleteList.add(140);
        deleteList.add(150);
        deleteList.add(160);
        deleteList.add(170);
        deleteList.add(81);
        deleteList.add(82);
        deleteList.add(83);
        deleteList.add(84);
        deleteList.add(85);
        deleteList.add(86);
        deleteList.add(141);
        deleteList.add(142);
        deleteList.add(143);
        deleteList.add(144);
        deleteList.add(145);
        deleteList.add(146);
        deleteList.add(9);
        deleteList.add(51);
        deleteList.add(99);
        deleteList.add(147);
        deleteList.add(171);
        deleteList.add(87);
        deleteList.add(88);
        deleteList.add(89);
        deleteList.add(171);
        deleteList.add(172);
        deleteList.add(173);
        deleteList.add(71);
        deleteList.add(72);
        deleteList.add(73);
        deleteList.add(101);
        deleteList.add(102);
        deleteList.add(21);
        deleteList.add(22);
        deleteList.add(148);
        deleteList.add(149);
        deleteList.add(52);
        deleteList.add(53);
        deleteList.add(1);
        deleteList.add(161);
        deleteList.add(162);
        deleteList.add(163);
        deleteList.add(174);
        deleteList.add(175);
        deleteList.add(176);
        for(int i = 0; i < deleteList.size(); ++i) {
            Integer res = deleteList.get(i);
            Entry entry = new Entry<Integer, Integer>();
            entry.setKey(res);
            entry.setValue(res);
            btree.delete(entry);
        }*/
//
//        Entry entry = new Entry<Integer, Integer>();
//        entry.setKey(10);
//        entry.setValue(10);
//        btree.deleteNode(entry);
       /* System.out.println("----------------------");
        btree.output();
        System.out.println("----------------------");*/
//        SearchResult<Integer, Integer> result86 = btree.searchfromRoot(86);
//        System.out.println(result86.getValue()+ " index: "+result86.getIndex() + " addr: " + result86.getNode());
//        SearchResult<Integer, Integer> result142 = btree.searchfromRoot(142);
//        System.out.println(result142.getValue()+ " index: "+result142.getIndex() + " addr: " + result142.getNode());
//
//        SearchResult<Integer, Integer> result143 = btree.searchfromRoot(143);
//        System.out.println(result143.getValue()+ " index: "+result143.getIndex() + " addr: " + result143.getNode());
//
//        SearchResult<Integer, Integer> result145 = btree.searchfromRoot(145);
//        System.out.println(result145.getValue()+ " index: "+result145.getIndex() + " addr: " + result145.getNode());
//
//        SearchResult<Integer, Integer> result146 = btree.searchfromRoot(146);
//        System.out.println(result146.getValue()+ " index: "+result146.getIndex() + " addr: " + result146.getNode());
//
//        SearchResult<Integer, Integer> result147 = btree.searchfromRoot(147);
//        System.out.println(result147.getValue()+ " index: "+result147.getIndex() + " addr: " + result147.getNode());
//        SearchResult<Integer, Integer> result160 = btree.searchfromRoot(170);
//        System.out.println(result160.getValue()+ " index: "+result160.getIndex() + " addr: " + result160.getNode());
    }
    public static void test02(){
        BTree<Integer, Integer> btree = new BTree<Integer, Integer>(4);
        for (int i = 1; i <= 100; i ++) {
            Entry entry = new Entry<Integer, Integer>();
            entry.setKey(i);
            entry.setValue(i);
            btree.insert(entry);
        }
        btree.output();
        for(int i = 0; i <= 100; ++i) {
            Entry entry = new Entry<Integer, Integer>();
            entry.setKey(100 - i);
            entry.setValue(100 - i);
            btree.delete(entry);
        }
        System.out.println("----------------------");
        btree.output();
        System.out.println("----------------------");
    }
    public static void main(String[] args){
        test01();
        //test02();
    }
}
