package ru.job4j.cache;

import java.io.FileNotFoundException;
import java.io.IOException;
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
            V data = load(key);
            put(key, data);
            return data;
        } else {
            V reference = cache.get(key).get();
            if (reference != null) {
                return reference;
            } else {
                V data = load(key);
                put(key, data);
                return data;
            }
        }
    }

    protected abstract V load(K key);

}