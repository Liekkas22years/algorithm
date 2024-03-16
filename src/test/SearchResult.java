package test;

import test.Node;

public class SearchResult<K, V> {
    private boolean isExist;
    private int index;
    private Node<K, V> node;
    public SearchResult(boolean isExist, int index, Node<K, V> node) {
        this.isExist = isExist;
        this.index = index;
        this.node = node;
    }
    public boolean isExist() {
        return isExist;
    }
    public V getValue() {
        if (node != null) {
            return (V) node.getEntries().get(index);
        } else {
            return null;
        }
    }
    public int getIndex() {
        return index;
    }
    public Node<K, V> getNode() { return node; }
}
