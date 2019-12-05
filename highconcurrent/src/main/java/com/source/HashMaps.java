package com.source;

/**
 * @Author qtq
 * @Created on 2019-11-17 20:13.
 */
public class HashMaps<K, V> implements Mapp<K, V> {

    private static int DEFAULT_LENGTH = 16;  // 初始化容量

    private static double DEFAULT_FACTOR = 0.75; //容量因子 ，超过会自动扩容

    private Entry[] table = null;

    private int size = 0;


    public HashMaps() {  //初始化
        this(DEFAULT_LENGTH, DEFAULT_FACTOR);
    }

    public HashMaps(int length) {
        DEFAULT_LENGTH = length;
    }

    public HashMaps(int length, double size) {
        DEFAULT_LENGTH = length;
        DEFAULT_FACTOR = size;
        table = new Entry[DEFAULT_LENGTH];
    }

    @Override
    public V put(K k, V v) {
        size++;
        int index = hash(k);
        Entry<K, V> entry = table[index];

        if (entry == null) {
            table[index] = newEntry(k, v, null); // 键没有冲突


        } else { // 如果键冲突
            table[index] = newEntry(k, v, entry); // 键没有冲突
        }

        return (V) table[index].getValue();
    }

    //返回键值对
    public Entry<K, V> newEntry(K k, V v, Entry<K, V> entry) {
        return new Entry<>(k, v, entry);
    }


    public int hash(K k) {  // 哈希算法
        int m = DEFAULT_LENGTH;
        int i = k.hashCode() % m;  //对16取模 0-15的取值
        return i >= 0 ? i : -i;
    }

    @Override
    public V get(K k) {
        int index = hash(k);
        if (table[index] == null) {
            return null;
        }
        return (V) find(k, table[index]);
    }


    public V find(K k, Entry<K, V> entry) {
        if (k == entry.getKey() || k.equals(entry.getKey())) {
            if (entry.next != null) {
                System.out.println("maps的老value：" + entry.next.getValue());
            }
            return entry.getValue();
        } else {
            if (entry.next != null) { // 键冲突了

                System.out.println("maps的新value：" + entry.next.getValue());
                return find(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }


    class Entry<K, V> implements Mapp.Entry<K, V> {

        K k;
        V v;
        Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
