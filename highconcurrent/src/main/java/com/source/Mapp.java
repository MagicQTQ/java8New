package com.source;

/**
 * @Author qtq
 * @Created on 2019-11-17 20:12.
 */
public interface Mapp<K, V> {

    public V put(K k, V v);

    public V get(K k);

    public int size();

    public interface Entry<K, V> {

        public K getKey();

        public V getValue();
    }


}
