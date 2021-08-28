package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        T result = value.size() != 0 ? value.get(0) : null;
        if (!result.equals(null)) {
            for (int i = 1; i < value.size(); i++) {
                if (comparator.compare(result, value.get(i)) > 0) {
                    result = value.get(i);
                }
            }
        }
        return result;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T result = value.size() != 0 ? value.get(0) : null;
        if (!result.equals(null)) {
            for (int i = 1; i < value.size(); i++) {
                if (comparator.compare(result, value.get(i)) < 0) {
                    result = value.get(i);
                }
            }
        }
        return result;
    }

}