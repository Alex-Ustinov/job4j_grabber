package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {
    @Test
    public void whenMyOwnMaxMinTest() {
        MaxMin maxMin = new MaxMin();
        List customList = new ArrayList();
        customList.add(5);
        customList.add(1);
        customList.add(2);
        Comparator<Integer> comparator = (Integer first, Integer second) -> second - first;
        assertThat(maxMin.myOwnMaxMin(customList, comparator, "max"), is(5));
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