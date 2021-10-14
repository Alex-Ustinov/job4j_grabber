package ru.job4j.isp;

import java.util.List;

public interface Menu {
    void create(MenuItem item, String dash);
    List<String> getMenuItem ();
}
