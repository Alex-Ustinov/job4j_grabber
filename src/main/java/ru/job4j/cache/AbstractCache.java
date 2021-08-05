package ru.job4j.cache;

import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> softReference = new SoftReference<>(value);
        cache.put(key, softReference);
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return (V) cache.get(key);
        }
        return null;
    }

    protected abstract V load(K key);

}