package test;

public class Entry<K, V> {
    private K key;
    private V value;
    public void setKey(K key) {
        this.key = key;
    }
    public K getKey() {
        return this.key;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public V getValue() {
        return this.value;
    }
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public Entry() {
    }
    @Override
    public String toString() {
        return "key: " + this.key;
    }
}
