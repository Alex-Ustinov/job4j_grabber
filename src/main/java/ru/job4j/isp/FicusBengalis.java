package ru.job4j.isp;

import java.util.NoSuchElementException;

public class FicusBengalis implements Tree {
    @Override
    public String getLeaves() {
        return "It has a lot of leaves";
    }

    @Override
    public String getRotes() {
        throw new NoSuchElementException();
    }
}
