package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> boolean customCompare (T firstValue, T secondValue, Comparator<T> comparator,  String rate) {
        if (rate.equals("max")) {
            return comparator.compare(firstValue, secondValue) > 0;
        } else if (rate.equals("min")) {
            return comparator.compare(firstValue, secondValue) < 0;
        }
        return false;
    }

    public <T> T setInitialValue (List<T> value) {
        return value.size() != 0 ? value.get(0) : null;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        T result = setInitialValue(value);
        if (!result.equals(null)) {
            for (int i = 1; i < value.size(); i++) {
                if (customCompare(result, value.get(i), comparator, "max")) {
                    result = value.get(i);
                }
            }
        }
        return result;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T result = setInitialValue(value);
        if (!result.equals(null)) {
            for (int i = 1; i < value.size(); i++) {
                if (customCompare(result, value.get(i), comparator, "min")) {
                    result = value.get(i);
                }
            }
        }
        return result;
    }

    public <T> T myOwnMaxMin(List<T> value, Comparator<T> comparator, String rate) {
        T result = setInitialValue(value);
        if (!result.equals(null)) {
            for (int i = 1; i < value.size(); i++) {
                if (customCompare(result, value.get(i), comparator, rate)) {
                    result = value.get(i);
                }
            }
        }
        return result;
    }
}