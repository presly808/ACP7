package week1.hashMap;

import java.util.*;
import java.util.Iterator;

public class MyHashMap<K, V> implements Map<K, V>, Iterable<MyHashMap.Bucket<K,V>> {

    public static final int DEFAULT_TABLE_SIZE = 16;
    final float loadFactor = 0.75f;
    private int size;
    private float threshold;
    private Bucket<K, V>[] table;

    public MyHashMap() {
        table = new Bucket[DEFAULT_TABLE_SIZE];
        threshold = (int) (table.length * loadFactor);
    }

//    public void checkInputKey(Object key){
//        if (key.getClass() != K){
//
//        }
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {

        int position = findPosition(key);

        if (table[position] == null) {
            return false;
        } else {
            Bucket<K, V> iter = findInBucket(key, position);
            return iter != null;
        }

    }

    @Override
    public boolean containsValue(Object value) {
        Iterator<Bucket<K, V>> iterator = new BucketIterator();
        while (iterator.hasNext()) {
            Bucket<K, V> next = iterator.next();
            if (next.value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public V get(Object key) {

        int position = findPosition(key);

        if (table[position] == null) {
            return null;
        } else {
            Bucket<K, V> iter = findInBucket(key, position);
            return iter != null ? iter.value : null;
        }
    }

    @Override
    public V put(K key, V value) {
        if (size++ >= threshold) {
            resize(table.length);
        }

        putBucket(table, key, value);
        size++;

        return null;
    }

    public void putBucket(Bucket<K, V>[] table, K key, V value) {
        int position = findPosition(key);

        if (table[position] == null) {
            table[position] = new Bucket<>(key, value);
        } else {
            int marker = 0;
            Bucket iter = table[position];
            // find last node in bucket
            while (iter.next != null) {
                if (iter.key.equals(key)) {
                    iter.value = value;
                    marker = 1;
                } else {

                    iter = iter.next;
                }
            }
            if (marker != 1) {
                iter.next = new Bucket<>(key, value);
            }
        }
    }

    private void resize(int oldLength) {
        int newLength = oldLength * 2;
        Bucket<K, V>[] newTable = new Bucket[newLength];
        rehash(newTable);
        table = newTable;
        threshold = (int) (newLength * loadFactor);

    }

    private void rehash(Bucket<K, V>[] newTable) {
        for (int i = 0; i < newTable.length; i++) {
            Iterator<Bucket<K, V>> iterator = new BucketIterator();
            while (iterator.hasNext()) {
                Bucket<K, V> next = iterator.next();
                putBucket(newTable, next.key, next.value);
            }
        }
    }

    @Override
    public V remove(Object key) {
        if (!this.containsKey(key)) {
            return null;
        }
        int position = findPosition(key);
        Bucket<K, V> current = table[position];
        Bucket<K, V> prev = table[position];
        if (current.next == null) {
            table[position] = null;
            size--;
            return current.value;
        } else {
            while (!prev.next.key.equals(key)) {
                prev = prev.next;
            }
            current = prev.next;
            prev.next = current.next;
            size--;
            return current.value;
        }

    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if ((m.size() + this.size >= threshold)) {
            resize(table.length);
        }
//        MyHashMap<K, V> map = (HashMap<K, V>) m;
        Iterator<? extends Entry<? extends K, ? extends V>> iterator = m.entrySet().iterator();

        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {

        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();

        Iterator<Bucket<K, V>> iterator = new BucketIterator();
        while (iterator.hasNext()) {
            Bucket<K, V> next = iterator.next();
            keys.add(next.key);
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<V>();
        Iterator<Bucket<K, V>> iterator = new BucketIterator();
        while (iterator.hasNext()) {
            Bucket<K, V> next = iterator.next();
            values.add(next.value);
        }

        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public Iterator<Bucket<K, V>> iterator() {
        return new BucketIterator();
    }


//    public Iterator<Bucket<K,V>> iterator() {
//        return new BucketIterator();
//    }

    private class BucketIterator implements Iterator<Bucket<K, V>> {

        Bucket<K, V> current;
        int position = 0;

        public BucketIterator() {
            findNextNotNullBucket();
        }

        private void findNextNotNullBucket() {
            for (; position < table.length && table[position] == null; position++) {
            }
            current = position < table.length ? table[position] : null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Bucket<K, V> next() {
            Bucket<K, V> forRet = current;

            if (current.next != null) {
                current = current.next;
            } else {
                position++; // chage start position in search for findNextNotNullBucket()
                findNextNotNullBucket();
            }

            return forRet;
        }
    }

    private Bucket<K, V> findInBucket(Object key, int position) {
        Bucket<K, V> iter = table[position];
        // find last node in bucket
        while (iter.next != null) {
            if (iter.key.equals(key)) {
                return iter;
            }
            iter = iter.next;
        }

        return null;
    }

    private int findPosition(Object key) {
        int hash = Math.abs(key.hashCode());
        return hash % table.length;
    }

    public static class Bucket<KB, VB> {
        KB key;
        VB value;
        Bucket<KB, VB> next;


        public Bucket(KB key, VB value, Bucket next) {
            this.key = key;
            this.value = value;
            this.next = next;

        }

        public Bucket(KB key, VB value) {
            this.key = key;
            this.value = value;

        }
    }
}