package test;

import test.Node;
import test.Entry;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BTree<K, V> {
    //默认是5阶树,度为5
    private static int DEFAULT_DEGREE = 100;

    //根节点
    private Node<K, V> root;
    private int m;
    //非根节点的最小项数，体现的是除了根节点，其余节点都是分裂而来的！
    //节点的最大儿子数
    private int nodeMaxSize;
    //节点的最大关键字数
    private int keyMaxSize;
    //这里体现了除根节点和叶子节点外每个节点的最小儿子数量
    private int nodeMinSize;
    //节点的最小关键字数
    private int keyMinSize;
    //比较函数对象
    private Comparator<K> kComparator;
    public BTree() {
        this(DEFAULT_DEGREE);
        this.m = DEFAULT_DEGREE;
    }
    public BTree(int degree) {
        if (degree < 3) {
            throw new RuntimeException("degree less than 3!!");
        }
        this.m = degree;
        this.nodeMaxSize = this.m;
        this.keyMaxSize = this.m - 1;
        this.nodeMinSize = upToInt(this.m ,2);
        this.keyMinSize = upToInt(this.m ,2) - 1;
        this.root = new Node<>(this.keyMaxSize);
        root.setLeaf(true);
    }
    private int upToInt(int dividend,int divisor) {
        return dividend % 2 == 1 ? (dividend + 1) / divisor : dividend / divisor;
    }
    private int getKeyMaxSize() {
        return keyMaxSize;
    }
    public SearchResult<K, V> searchfromRoot (K key){
        return search(this.root, key);
    }
    private SearchResult<K, V> search(Node<K, V> node, K key) {//从查找根节点
        SearchResult<K, V> re = node.search(key);
        if (re.isExist()) {
            return re;
        } else {
            //回归条件
            if (node.isLeaf()) {//找到了叶子节点也没找到就不需要继续寻找下去了
                return new SearchResult<>(false, re.getIndex(), node);
            }
            int index = re.getIndex();
            //递归搜索子节点
            return search(node.childAt(index), key);
        }
    }
    private void insertNode(Node<K, V> node, int index, Entry<K, V> entry) {
        //entries插入之后，再判断是否超过最大值
        node.getEntries().add(index, entry);
        Entry<K, V> midEntry = null;
        if(!isGreaterThanKeyMaxSize(node)) {//没有超过，则结束
            return;
        } else {
            int midIndex = this.keyMaxSize / 2;
            midEntry = node.getEntries().get(midIndex);
            //新建一个newNode分裂的key左边的key加入新节点，将相同数量的children的元素也加入到新节点中,原来节点中的删除
            Node<K, V> newNode = new Node<>(this.keyMaxSize);
            for (int i = 0;i < midIndex+1; i++) {
                newNode.getEntries().add(node.getEntries().get(0));
                node.getEntries().remove(0);
            }
            newNode.getEntries().remove(midIndex);
            if (!node.isLeaf()) { // 非叶子节点
                for (int i = 0;i < midIndex+1; i++) {
                    newNode.getChildren().add(node.getChildren().get(0));
                    node.getChildren().get(0).setParent(newNode);
                    node.getChildren().remove(0);
                }
            }
            if (newNode.getChildren().size() == 0) {
                newNode.setLeaf(true);
            }
            Node<K, V> parent = node.getParent();
            if(parent != null) {//判断是否有父节点
                newNode.setParent(parent);
                for (int i = 0; i < parent.getChildren().size(); i++) {
                    if (node == parent.getChildren().get(i)) {
                        index = i;
                        break;
                    }
                }
                parent.getChildren().add(index, newNode);
                insertNode(parent, index, midEntry);
            } else { //没有父节点
                Node<K, V> newRoot = new Node<>(this.keyMaxSize);
                newRoot.getEntries().add(midEntry);
                List<Node<K, V>> rootChildren = newRoot.getChildren();
                rootChildren.add(newNode);
                newNode.setParent(newRoot);
                rootChildren.add(node);
                node.setParent(newRoot);
                if (node.getChildren().size() == 0) {
                    node.setLeaf(true);
                }
                this.root = newRoot;
                return;
            }
        }
    }
    private boolean isGreaterThanKeyMaxSize(Node<K, V> node) {
        return node.isOverFlow(this.getKeyMaxSize());
    }
    public void insert(Entry<K, V> entry) {
        SearchResult<K, V> sr = searchfromRoot(entry.getKey());
        if (sr.isExist()) {
            return;
        }
        insertNode(sr.getNode(), sr.getIndex(), entry);//sr.getIndex()表示应该往叶子节点的插的index
    }
    public void output() {
        Queue<Node<K, V>> queue = new LinkedList<Node<K, V>>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node<K, V> node = queue.poll();
            for (int i = 0; i < node.nodeSize(); ++i) {
                System.out.print(node.entryAt(i) + " ");
                if (i == node.nodeSize() - 1) {
                    System.out.print(" node: "+node + " parent: " +node.getParent());
                }
            }
            System.out.println();
            if (!node.isLeaf()) {
                for (int i = 0; i <= node.getChildren().size() - 1; ++i) {
                    queue.offer(node.childAt(i));
                }
            }
        }
    }
    private boolean isExists(Entry<K, V> entry) {
        return searchfromRoot(entry.getKey()).isExist();
    }
    private SearchResult<K, V> prefixNode(Entry<K, V> entry){
        SearchResult<K, V> sr = searchfromRoot(entry.getKey());
        Node<K, V> node = sr.getNode();
        int index = sr.getIndex();
        Node<K, V> preNode = node.getChildren().get(index);
        while (!preNode.isLeaf()) {
            List<Node<K, V>> children = preNode.getChildren();
            preNode = children.get(children.size()-1);
        }
        return new SearchResult<K, V>(true, preNode.getEntries().size()-1, preNode);
    }
    private SearchResult<K, V> suffixNode(SearchResult<K, V> sr){
        Node<K, V> node = sr.getNode();
        int index = sr.getIndex();
        Node<K, V> sufNode = node.getChildren().get(index + 1);
        while (!sufNode.isLeaf()) {
            List<Node<K, V>> children = sufNode.getChildren();
            sufNode = children.get(0);
        }
        return new SearchResult<K, V>(true, 0, sufNode);
    }
    public void delete(Entry<K, V> entry) {
        SearchResult<K, V> res = searchfromRoot(entry.getKey());
        if (!res.isExist()) {
            return;
        }
        Node<K, V> node = res.getNode();
        int index = res.getIndex();
        if (!node.isLeaf()) {
            //如果不是叶子节点，则找到后继节点中的后继Entry
            SearchResult<K, V> sufNodeSR = suffixNode(res);
            Node<K, V> sufNode = sufNodeSR.getNode();
            int sufIndex = sufNodeSR.getIndex();
            Entry<K, V> sufEntry = sufNode.getEntries().get(sufIndex);
            res.getNode().getEntries().set(index, sufEntry);
            deleteLeafNodeEntry(sufNode, sufIndex);
        } else {
            //如果是叶子节点，则直接删除
            deleteLeafNodeEntry(node, index);
        }
    }
    private void deleteLeafNodeEntry(Node<K, V> node, int index) {
        int entriesSize = node.getEntries().size();
        if (entriesSize > this.keyMinSize) {
            //本节点中minKeySize < keySize < maxKeySize
            node.getEntries().remove(index);
            return;
        } else {
            //entriesSize == this.keyMinSize，B树在构建的过程中，不可能出现entriesSize < this.keyMinSize的情况
            //首先把该Entry删除
            node.getEntries().remove(index);
            if (node == this.root) {
                return;
            }
            int parentEntrisSize = -1;
            Node<K, V> parentNode = node;
            do {
                parentNode = nodeLessThanKeyMinSize(parentNode, index);
                parentEntrisSize = parentNode.getEntries().size();
            }while (parentNode != this.root && parentEntrisSize < this.keyMinSize);
        }
    }
    private Node<K, V> nodeLessThanKeyMinSize(Node<K, V> node, int index) {
        Node<K, V> parent = node.getParent();
        List<Node<K, V>> parentChildren = parent.getChildren();
        int nodeIndex = -1;
        for (int i = 0; i < parentChildren.size(); i++) {
            if (node == parentChildren.get(i)) {
                nodeIndex = i;
                break;
            }
        }
        Node<K, V> leftNode = null;
        Node<K, V> rightNode = null;
        boolean isRotate = false;
        if (nodeIndex > 0 && nodeIndex < parentChildren.size() - 1) {
            leftNode = parentChildren.get(nodeIndex - 1);
            if (isRotate == false && leftNode.getEntries().size() > this.keyMinSize) {
                //左兄弟够借，需要右旋
                rightRotate(node, nodeIndex);
                isRotate = true;
            }
            rightNode = parentChildren.get(nodeIndex + 1);
            if (isRotate == false && rightNode.getEntries().size() > this.keyMinSize) {
                //右兄弟够借，需要左旋
                leftRotate(node, nodeIndex);
                isRotate = true;
            }
        } else if (nodeIndex == 0){
            rightNode = parentChildren.get(nodeIndex + 1);
            if (rightNode.getEntries().size() > this.keyMinSize) {
                //右兄弟够借，需要左旋
                leftRotate(node, nodeIndex);
                isRotate = true;
            }
        } else {
            leftNode = parentChildren.get(nodeIndex - 1);
            if (leftNode.getEntries().size() > this.keyMinSize) {
                //左兄弟够借，需要右旋
                rightRotate(node, nodeIndex);
                isRotate = true;
            }
        }
        //判断是否发生了旋转，如果isRotate=true,说明发生了旋转，B树就平衡了，无需进行下面的操作了
        if (isRotate == false) {
            //若没有发生旋转，所以B树现在还没有平衡
            if (nodeIndex > 0) {
                //entry进入左兄弟
                if (parent == this.root && parent.getEntries().size() == 1) {
                    Node<K, V> rootLeftChild = parent.getChildren().get(nodeIndex - 1);
                    rootLeftChild.getEntries().add(parent.getEntries().get(0));
                    for (int i = 0; i < node.getEntries().size(); i ++) {
                        rootLeftChild.getEntries().add(node.getEntries().get(i));
                    }
                    if (!node.isLeaf()) {
                        for (int i = 0; i < node.getChildren().size(); i ++) {
                            rootLeftChild.getChildren().add(node.getChildren().get(i));
                            node.getChildren().get(i).setParent(rootLeftChild);
                        }
                    }
                    //以下操作，方便虚拟机回收
                    //node和root的关系
                    this.root.getChildren().remove(1);
                    node.setParent(null);
                    //node和子节点的关系
                    for (Node<K, V> kvNode : node.getChildren()) {
                        kvNode.setParent(rootLeftChild);
                    }
                    node.getChildren().clear();
                    //right和root的关系
                    this.root.getChildren().clear();
                    this.root = rootLeftChild;
                    rootLeftChild.setParent(null);
                    return this.root;
                } else {
                    //进入左兄弟节点
                    if (node.isLeaf()) {
                        Entry<K, V> parentEntry = parent.getEntries().get(nodeIndex - 1);
                        leftNode.getEntries().add(parentEntry);
                        for (int i = 0; i < node.getEntries().size(); i++) {
                            leftNode.getEntries().add(node.getEntries().get(i));
                        }
                        //node删除，父节点的children处理
                        node.setParent(null);
                        parent.getChildren().remove(nodeIndex);
                        parent.getEntries().remove(nodeIndex - 1);
                    } else {
                        Entry<K, V> parentEntry = parent.getEntries().get(nodeIndex - 1);
                        leftNode.getEntries().add(parentEntry);
                        for (int i = 0; i < node.getEntries().size(); i++) {
                            leftNode.getEntries().add(node.getEntries().get(i));
                            leftNode.getChildren().add(node.getChildren().get(i));
                            node.getChildren().get(i).setParent(leftNode);
                        }
                        leftNode.getChildren().add(node.getChildren().get(node.getChildren().size() - 1));
                        node.getChildren().get(node.getChildren().size() - 1).setParent(leftNode);
                        node.setParent(null);
                        parent.getChildren().remove(nodeIndex);
                        parent.getEntries().remove(nodeIndex - 1);
                    }
                }
            } else {
                //entry进入右兄弟
                if (parent == this.root && parent.getEntries().size() == 1) {
                    Node<K, V> rootRightChild = parent.getChildren().get(nodeIndex + 1);
                    rootRightChild.getEntries().add(0, parent.getEntries().get(0));
                    for (int i = 0; i < node.getEntries().size(); i ++) {
                        rootRightChild.getEntries().add(0, node.getEntries().get(node.getEntries().size() - 1 - i));
                    }
                    if (!node.isLeaf()) {
                        for (int i = 0; i < node.getChildren().size(); i ++) {
                            rootRightChild.getChildren().add(0, node.getChildren().get(node.getChildren().size() -1 - i));
                            node.getChildren().get(node.getChildren().size() - 1 - i).setParent(rightNode);
                        }
                    }
                    //以下操作，方便虚拟机回收
                    //node和root的关系
                    this.root.getChildren().remove(0);
                    node.setParent(null);
                    //node和子节点的关系
                    for (Node<K, V> kvNode : node.getChildren()) {
                        kvNode.setParent(rootRightChild);
                    }
                    node.getChildren().clear();
                    //right和root的关系
                    this.root.getChildren().clear();
                    this.root = rootRightChild;
                    rootRightChild.setParent(null);
                    return this.root;
                } else {
                    if (node.isLeaf()) {
                        Entry<K, V> parentEntry = parent.getEntries().get(nodeIndex);
                        rightNode.getEntries().add(0, parentEntry);
                        for (int i = 0; i < node.getEntries().size(); i++) {
                            rightNode.getEntries().add(0, node.getEntries().get(node.getEntries().size() - 1 - i));
                        }
                        //node删除，父节点的children处理
                        node.setParent(null);
                        parent.getChildren().remove(nodeIndex);
                        parent.getEntries().remove(nodeIndex);
                    } else {
                        Entry<K, V> parentEntry = parent.getEntries().get(nodeIndex);
                        rightNode.getEntries().add(0, parentEntry);
                        for (int i = 0; i < node.getEntries().size(); i++) {
                            rightNode.getEntries().add(0, node.getEntries().get(node.getEntries().size() - 1 - i));
                            rightNode.getChildren().add(0, node.getChildren().get(node.getChildren().size() -1 - i));
                            node.getChildren().get(node.getChildren().size() -1 - i).setParent(rightNode);
                        }
                        rightNode.getChildren().add(0, node.getChildren().get(0));
                        node.getChildren().get(0).setParent(rightNode);
                        node.setParent(null);
                        parent.getChildren().remove(nodeIndex);
                        parent.getEntries().remove(nodeIndex);
                    }
                }
            }
        }
        return parent;
    }
    private void leftRotate(Node<K, V> node, int indexOfParent) {
        Node<K, V> parent = node.getParent();
        Entry<K, V> parentEntry = parent.getEntries().get(indexOfParent);
        Node<K, V> rightNode = parent.getChildren().get(indexOfParent + 1);
        Entry<K, V> rightNodeFirstEntry = rightNode.getEntries().get(0);
        List<Entry<K, V>> entries = node.getEntries();
        //entries.set(entries.size() - 1, parentEntry);
        entries.add(parentEntry);
        parent.getEntries().set(indexOfParent, rightNodeFirstEntry);
        rightNode.getEntries().remove(0);
        if (!node.isLeaf()) {
            rightNode.getChildren().get(0).setParent(node);
            node.getChildren().add(rightNode.getChildren().get(0));
            rightNode.getChildren().remove(0);
        }
    }
    private void rightRotate(Node<K, V> node, int indexOfParent) {
        Node<K, V> parent = node.getParent();
        Entry<K, V> parentEntry = parent.getEntries().get(indexOfParent - 1);
        Node<K, V> leftNode = parent.getChildren().get(indexOfParent - 1);
        Entry<K, V> leftNodeLastEntry = leftNode.getEntries().get(leftNode.getEntries().size() - 1);
        List<Entry<K, V>> entries = node.getEntries();
        entries.add(0, parentEntry);
        parent.getEntries().set(indexOfParent - 1, leftNodeLastEntry);
        leftNode.getEntries().remove(leftNode.getEntries().size() - 1);
        if (!node.isLeaf()) {
            leftNode.getChildren().get(leftNode.getChildren().size() - 1).setParent(node);
            node.getChildren().add(0, leftNode.getChildren().get(leftNode.getChildren().size() - 1));
            leftNode.getChildren().remove(leftNode.getChildren().size() - 1);
        }
    }
}
