package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {
    @Test
    public void whenMyOwnMaxMinTestMax() {
        MaxMin maxMin = new MaxMin();
        List customList = new ArrayList();
        customList.add(5);
        customList.add(1);
        customList.add(2);
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x > y;
        assertThat(maxMin.myOwnMaxMin(customList, biPredicate), is(5));
    }

    @Test
    public void whenMyOwnMaxMinTestMin() {
        MaxMin maxMin = new MaxMin();
        List customList = new ArrayList();
        customList.add(7);
        customList.add(1);
        customList.add(2);
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x < y;
        assertThat(maxMin.myOwnMaxMin(customList, biPredicate), is(1));
    }

    @Test
    public void maxTest() {
        MaxMin maxMin = new MaxMin();
        List customList = new ArrayList();
        customList.add(3);
        customList.add(1);
        customList.add(2);
        Comparator<Integer> comparator = (Integer first, Integer second) -> second - first;
        assertThat(maxMin.max(customList, comparator), is(3));
    }

    @Test
    public void minTest() {
        MaxMin maxMin = new MaxMin();
        List customList = new ArrayList();
        customList.add(3);
        customList.add(1);
        customList.add(2);
        Comparator<Integer> comparator = (Integer first, Integer second) ->  second - first;
        assertThat(maxMin.min(customList, comparator), is(1));
    }

}