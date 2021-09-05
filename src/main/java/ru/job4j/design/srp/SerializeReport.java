package ru.job4j.design.srp;

public interface SerializeReport<T> {
    public String serialise(T item);
    public T deSerialize(String itemJson);
}
