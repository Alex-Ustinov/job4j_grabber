package ru.job4j.isp;

import java.util.NoSuchElementException;

public class ChristmasTree implements Tree {

    @Override
    public String getLeaves() {
        throw new NoSuchElementException();
    }

    @Override
    public String getRotes() {
        return "one big rote";
    }
}
