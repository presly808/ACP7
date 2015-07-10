package ua.artcode.ClassWork.Week_1.hash;


import java.util.*;

public class MyHashMap<K,V> implements Map<K,V> {

    public static final int DEFAULT_TABLE_SIZE = 16;

    private int size;
    private Bucket<K,V>[] table;

    public MyHashMap() {
        table = new Bucket[DEFAULT_TABLE_SIZE];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {

        int position = findPosition(key);

        if(table[position] == null){
            return false;
        } else {
            Bucket<K,V> iter = findInBucket(key, position);
            return iter != null;
        }

    }

    @Override
    public boolean containsValue(Object value) {
        Iterator<Bucket<K,V>>iterator = new BucketIterator();
        while (iterator.hasNext()){
            Bucket<K,V> next = iterator.next();
            if(next.value.equals(value)){
                return true;
            }
        }
        return false; // iterator
    }

    @Override
    public V get(Object key) {

        int position = findPosition(key);

        if(table[position] == null){
            return null;
        } else {
            Bucket<K,V> iter = findInBucket(key, position);
            return iter != null ? iter.value : null;
        }
    }

    @Override
    public V put(K key, V value) {

        int hash = Math.abs(key.hashCode());

        int position = hash % table.length;

        if(table[position] == null){
            table[position] = new Bucket<>(key,value);
        } else {
            Bucket iter = table[position];
            // find last node in bucket
            while(iter.next != null){
                iter = iter.next;
            }

            iter.next = new Bucket<>(key,value);
        }

        size++;

        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        Iterator<Bucket<K,V>>iterator = new BucketIterator();
        while (iterator.hasNext()){
            Bucket<K,V> next = iterator.next();
        }
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private class BucketIterator implements Iterator<Bucket<K,V>> {

        Bucket<K,V> current;
        int position=0;
        public BucketIterator() {

            findNextNotNullBucket();

        }

        private void findNextNotNullBucket() {
            for (; position < table.length && table[position] == null; position++) {
            }
            current = table[position];
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Bucket<K,V> next() {

            Bucket<K,V> forRes = current;
            if(current.next!=null){
                current= current.next;
            } else{
                findNextNotNullBucket();
            }

            return current;
        }
    }

    private Bucket<K,V> findInBucket(Object key, int position){
        Bucket<K,V> iter = table[position];
        // find last node in bucket
        while(iter.next != null){
            if(iter.key.equals(key)){
                return iter;
            }
            iter = iter.next;
        }

        return null;
    }

    private int findPosition(Object key){
        int hash = Math.abs(key.hashCode());
        return hash % table.length;
    }

    private static class Bucket<KB,VB> {
        KB key;
        VB value;
        Bucket<KB,VB> next;

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
