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
        T result = value.size() != 0 ? value.get(0) : null;
        if (!result.equals(null)) {
            for (int i = 1; i < value.size(); i++) {
                if (predicate.test(comparator.compare(value.get(i), result))) {
                    result = value.get(i);
                }
            }
        }
        return result;
    }

}