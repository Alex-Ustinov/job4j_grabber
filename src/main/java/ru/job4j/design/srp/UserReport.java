package ru.job4j.design.srp;

import java.util.function.Predicate;

public interface UserReport {
    String generate(Predicate<User> filter) throws Exception;
}
