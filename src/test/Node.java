package test;

import test.Entry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Node<K,V> {
    private Node(List<Entry<K, V>> entries, List<Node<K, V>> children, boolean leaf, Comparator<K> kComparator, Node<K, V> parent) {
        this.entries = entries;
        this.children = children;
        this.leaf = leaf;
        this.kComparator = kComparator;
        this.parent = parent;
    }
    //关键字列表
    private List<Entry<K,V>> entries;
    //子结点列表
    private List<Node<K, V>> children;
    //是否为叶子节点
    private boolean leaf;
    //键值比较函数对象，如果采用倒序或者其它排序方式，传入该对象
    private Comparator<K> kComparator;
    private Node<K, V> parent;
    public Node<K, V> getParent() {
        return parent;
    }
    public void setParent(Node<K, V> parent) {
        this.parent = parent;
    }
    //判断node的entries的数量是否超过最大keyMaxSize
    public boolean isOverFlow(int keyMaxSize) {
        return this.entries.size() > keyMaxSize;
    }
    //比较两个key，如果没有传入自定义排序方式则采用默认的升序
    public int compare(K key1, K key2) {
        return this.kComparator == null ? ((Comparable<K>) key1).compareTo(key2) : kComparator.compare(key1, key2);
    }
    Node(int degree) {
        this.entries = new ArrayList<Entry<K, V>>(degree);
        this.children = new ArrayList<Node<K, V>>(degree);
        this.leaf = false;
        this.parent = null;
    }
    public int nodeSize() {
        return this.entries.size();
    }
    public List<Entry<K, V>> getEntries() {
        return entries;
    }
    public List<Node<K, V>> getChildren() {
        return children;
    }
    public boolean isLeaf() {
        return leaf;
    }
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
    public Comparator<K> getkComparator() {
        return kComparator;
    }
    public void setkComparator(Comparator<K> kComparator) {
        this.kComparator = kComparator;
    }
    public SearchResult<K, V> search(K key){
        int left = 0; //左指针
        int right = this.getEntries().size()-1;//右指针
        V res = null;//返回值
        int mid = (left+right)/2;//中间的位置
        boolean isExist = false; //判断是否找到了
        int index = 0; //要找的关键字的下标
        while(left <= right){
            mid = (left+right)/2;//中间的位置
            Entry<K,V> midEntry = this.entries.get(mid);//拿到中间的关键字
            int comparator = this.compare(key,midEntry.getKey());
            if(comparator == 0){//找到了
                isExist = true;
                index = mid;
                res = this.entries.get(mid).getValue();
                break;
            }else if(comparator==1){//在右侧
                left = mid + 1;
            }else{//midKey大于key 在左侧
                right = mid - 1;
            }
        }
        //二分查找结束了
        //B树首次插入节点，会出现left = 0且right = -1的情况
        if(isExist == false) {
            if (right == -1) {
                index = left;
            } else {
                //能走到这里说明left > right
                //选择较小的哪个值
                int min = Math.min(left, right);
                K midKey = this.entries.get(min).getKey();//虽然没有找到key但是找到了离key最近的一个关键字
                int comRe = compare(key, midKey); //判断key和关键字哪个大
                if(comRe>0){ //key大 那么就是关键字的右子树
                    index = min + 1;
                }else { //key小 返回当前left的左子树
                    index = min ;
                }
            }
        }
        return new SearchResult<K, V>(isExist, index, res == null ? null : this);
    }
    //得到index处的项
    public Entry<K, V> entryAt(int index) {
        return this.entries.get(index);
    }
    private void insertEntry(Entry<K, V> entry, int index) {
        this.entries.add(index, entry);
    }
    //将新关键字插入 如果存在相同的关键字key不允许插入
    public boolean insertEntry(Entry<K,V> entry){
        SearchResult<K, V> result = search(entry.getKey()); //这里会返回适合的节点
        if (result.isExist()) { //如果有了相同的key就不然插入
            return false;
        } else {
            insertEntry(entry, result.getIndex());
            return true;
        }
    }
    public Node<K, V> childAt(int index) {
        return this.children.get(index);
    }
}
