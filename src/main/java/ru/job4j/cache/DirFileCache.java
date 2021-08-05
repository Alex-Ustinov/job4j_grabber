package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    protected final Map<String, SoftReference<String>> cache = new HashMap<>();

    @Override
    public String get(String key) {
        String rsl = "";
        String fileWay = cachingDir+""+key;
        if (!cache.containsKey(fileWay)){
            rsl = load(fileWay);
        } else {
            rsl = cache.get(fileWay).get();
        }
        return rsl;
    }

    @Override
    public void put(String key, String value) {
        cache.put(key, new SoftReference<>(value));
    }

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String rsl = null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(key)))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                stringBuilder.append(line);
            }
            rsl = stringBuilder.toString();
            put(key, rsl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }
}