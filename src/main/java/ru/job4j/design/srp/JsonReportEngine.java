package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class JsonReportEngine implements UserReport {

    private UserStore store;

    public JsonReportEngine(UserStore store) {
        this.store = store;
    }

    public String generate(Predicate<User> filter) throws Exception {
        List<User> employees =  store.findBy(filter);
        Gson lib = new GsonBuilder().create();
        String report = lib.toJson(employees);
        System.out.println(report);
        return report;
    }
}
