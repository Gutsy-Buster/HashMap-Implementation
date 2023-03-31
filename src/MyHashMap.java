public class MyHashMap<K,V> {
    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAX_SIZE = 1 << 30;
    Entry[] hashTable;
    int tableSize;

    public MyHashMap() {
        tableSize = INITIAL_SIZE;
        hashTable = new Entry[tableSize];
    }

    public MyHashMap(int size) {
        tableSize = getTableSize(size);
        hashTable = new Entry[tableSize];
    }

    private int getTableSize(int size) {
        // int n = 1;
        // while(n < size) n = n << 1;
        // return n;
        int n = size - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int s = (n < 0) ? 1 : (n >= MAX_SIZE) ? MAX_SIZE: n+1;
        System.out.println("Size = " + s);
        return s;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % tableSize;

        Entry node = hashTable[hashCode];
        Entry newNode = new Entry(key, value);
        if(node == null) {
            hashTable[hashCode] = newNode;
            return;
        }
        
        Entry prev = node;
        while(node != null) {
            if(node.key.equals(key)) {
                node.value = value;
                return;
            }
            prev = node;
            node = node.next;
        }
        prev.next = newNode;
    }

    public V get(K key) {
        int hashCode = key.hashCode() % tableSize;

        Entry node = hashTable[hashCode];

        while(node != null) {
            if(node.key.equals(key)) {
                return (V)node.value;
            }
            node = node.next;
        }

        return null;
 
    }
}
