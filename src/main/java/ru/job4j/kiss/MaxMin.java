package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = (x) -> x < 0;
        return minMax(value, predicate, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = (x) -> x > 0;
        return minMax(value, predicate, comparator);
    }

    private <T> T minMax(List<T> value, Predicate<Integer> predicate, Comparator<T> comparator) {
        if (value.size() == 0) {
            return null;
        }
        T result = value.get(0);
        for (T item : value) {
            if (predicate.test(comparator.compare(item, result))) {
                result = item;
            }
        }
        return result;
    }

}