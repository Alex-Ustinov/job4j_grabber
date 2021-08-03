package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    @Override
    public String get(String key) {
        return super.get(key);
    }

    @Override
    public void put(String key, String value) {
        super.put(key, value);
    }

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String fileWay = cachingDir+""+key;
        String rsl = null;
        if (get(fileWay).equals(null)) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileWay)))) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String line = in.readLine(); line != null; line = in.readLine()) {
                    stringBuilder.append(line);
                }
                rsl = stringBuilder.toString();
                put(fileWay, rsl);
            } catch (Exception e) {

            }
        } else {
            rsl = get(key);
        }
        return rsl;
    }
}