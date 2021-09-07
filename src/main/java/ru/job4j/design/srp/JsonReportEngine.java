package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {

    private Store store;

    public JsonReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws Exception {
        List<Employee> employees =  store.findBy(filter);
        Gson lib = new GsonBuilder().create();
        String report = lib.toJson(employees);
        System.out.println(report);
        return report;
    }
}
