package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public interface UserStore {
    List<User> findBy(Predicate<User> filter);
}
