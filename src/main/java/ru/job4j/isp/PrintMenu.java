package ru.job4j.isp;

import java.util.List;

public interface PrintMenu {
    String createViewMenu(List<String> menu);
    void print(String menu);
}
