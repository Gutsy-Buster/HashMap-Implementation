public class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next;
    public Entry(K k, V v) {
        key = k;
        value = v;
        next = null;
    }
}
