package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CustomGsonBuilder implements SerializeBuilder {

    private Gson builder = new GsonBuilder().create();

    @Override
    public String createJson(Object item) {
        return builder.toJson(item);
    }

    @Override
    public Object fromJson(String item, Class Tclass) {
        return builder.fromJson(item, Tclass);
    }
}
