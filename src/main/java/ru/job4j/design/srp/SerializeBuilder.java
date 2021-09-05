package ru.job4j.design.srp;

public interface SerializeBuilder<F> {
    public String createJson(F item);
    public F fromJson(String item, Class Tclass);
}
