import java.util.LinkedList;

class Pair<K, V> {
    K key;
    V value;

    public Pair() {
        this.key = null;
        this.value = null;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

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
}

public class HashTable<K, V> {
    private LinkedList<Pair<K, V>>[] table;
    private int size;

    public HashTable() {
        this.table = new LinkedList[100];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Pair<K, V>>();
        }
        for (Pair<K, V> Pair : table[index]) {
            if (Pair.getKey().equals(key)) {
                Pair.setValue(value);
                return;
            }
        }
        table[index].add(new Pair<K, V>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        for (Pair<K, V> Pair : table[index]) {
            if (Pair.getKey().equals(key)) {
                return Pair.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }
        for (int i = 0; i < table[index].size(); i++) {
            if (table[index].get(i).getKey().equals(key)) {
                table[index].remove(i);
                size--;
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode())%100;
    }
}
