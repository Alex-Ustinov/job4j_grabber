package ru.job4j.cache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        try {
            Path filePath = Paths.get(cachingDir, key);
            return Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}