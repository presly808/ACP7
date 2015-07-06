package ua.artcode.week1.map;

import java.io.IOException;
import java.util.*;


public class MyHashMap<K, V> implements Map<K, V> {
    public int defaultSize = 4;

    private Bucket<K, V>[] table;
    private int size;
    private double loadFactor;

    public MyHashMap(double loadFactor) throws IOException {
        this();
        if (loadFactor > 1 || loadFactor < 0) {
            throw new IOException("Inccorect Load factor. Load Factor must be in range[0,1]");
        }
        this.loadFactor = loadFactor;

    }

    public MyHashMap() {
        table = new Bucket[defaultSize];
        loadFactor = 0.7;
    }


    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                table[i] = null;
            }
        }
        size = 0;

    }

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
        int pos = getPosition(key);
        if (table[pos] == null) {
            return false;
        } else {
            Bucket iter = table[pos];
            while (iter.getNext() != null) {
                if (iter.getKey().equals(key)) ;
                return true;

            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Iterator<Bucket<K, V>> iter = new BucketIterator();
        while (iter.hasNext()) {
            Bucket<K, V> bucket = iter.next();
            if (bucket.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Iterator<Bucket<K, V>> iter = new BucketIterator();
        while (iter.hasNext()) {
            Bucket<K, V> bucket = iter.next();
            if (bucket.getKey().equals(key)) {
                return bucket.getValue();
            }
        }
        return null;
    }

    private int getPosition(Object key, int size) {
        int hash = Math.abs(key.hashCode());
        int pos = hash % defaultSize;
        return pos;
    }

    private int getPosition(Object key) {
        return getPosition(key, defaultSize);
    }

    @Override
    public V put(K key, V value) {
        System.out.println("load status: " + getLoadStatus() + " size: " + size() + " dSize: " + defaultSize);
        if (loadFactor <= getLoadStatus()) {
            System.out.println("Start to recreate map: " + getLoadStatus());
            recreateMap();
        }
        int position = getPosition(key);
        addOperation(table, new Bucket<K, V>(key, null, value), position);
        size++;

        return value;
    }

    private void addOperation(Bucket<K, V>[] table, Bucket<K, V> newBucket, int position) {
        if (table[position] == null) {
            table[position] = newBucket;
        } else {
            Bucket iter = table[position];
            while (iter.getNext() != null) {
                iter = iter.getNext();
            }
            iter.setNext(newBucket);
        }
    }

    private void recreateMap() {
        int newDefaultSize = defaultSize * 2;
        Bucket<K, V>[] newTable = new Bucket[newDefaultSize];
        Iterator<Bucket<K, V>> iter = new BucketIterator();
        while (iter.hasNext()) {
            Bucket<K, V> bucket = iter.next();
            bucket.setNext(null);
            int newPosition = getPosition(bucket.getKey(), newDefaultSize);
            addOperation(newTable, bucket, newPosition);
        }
        table = newTable;
        defaultSize = newDefaultSize;


    }

    private double getLoadStatus() {
        return Double.valueOf(size) / Double.valueOf(defaultSize);
    }

    @Override
    public V remove(Object key) {
//        Iterator<Bucket<K, V>> iter = new BucketIterator();
//        while (iter.hasNext()) {
//            Bucket<K, V> bucket = iter.next();
//            if (bucket.getKey().equals(key)) {
//                bucket.setKey(null);
//            }
//        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public Set<K> keySet() {
        Set keys = new HashSet<K>();
        Iterator<Bucket<K, V>> iter = new BucketIterator();
        while (iter.hasNext()) {
            keys.add(iter.next().getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        Iterator<Bucket<K, V>> iter = new BucketIterator();
        while (iter.hasNext()) {
            Bucket<K, V> bucket = iter.next();
            values.add(bucket.getValue());
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> entrySet = new HashSet<>();
        Iterator<Bucket<K, V>> iter = new BucketIterator();
        while (iter.hasNext()) {
            Bucket<K, V> bucket = iter.next();
            Entry<K,V> entry = new AbstractMap.SimpleEntry<K, V>(bucket.getKey(), bucket.getValue());
            entrySet.add(entry);
        }
        return entrySet;
    }

    private static class Bucket<K, V> {
        K key;
        V value;
        Bucket<K, V> next;

        public Bucket(K key, Bucket<K, V> next, V value) {
            this.key = key;
            this.next = next;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Bucket<K, V> getNext() {
            return next;
        }

        public void setNext(Bucket<K, V> next) {
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Bucket)) return false;

            Bucket<?, ?> bucket = (Bucket<?, ?>) o;

            if (getKey() != null ? !getKey().equals(bucket.getKey()) : bucket.getKey() != null) return false;
            return !(getValue() != null ? !getValue().equals(bucket.getValue()) : bucket.getValue() != null);

        }

    }

    private class BucketIterator implements Iterator<Bucket<K, V>> {
        int position = 0;
        Bucket<K, V> current;

        public BucketIterator() {
            setCurrent();

        }

        private void setCurrent() {
            for (; position < table.length && table[position] == null; position++) ;
            if (position == table.length) {
                current = null;
            } else {
                current = table[position++];
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Bucket<K, V> next() {
            //todo home work
            Bucket<K, V> next = current;
            if (current.getNext() != null)
                current = current.getNext();
            setCurrent();

            return next;
        }
    }


}
