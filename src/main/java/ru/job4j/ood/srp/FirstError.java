package ru.job4j.ood.srp;

import ru.job4j.grabber.PsqlStore;
import ru.job4j.grabber.utils.Post;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FirstError implements FirstErrorInterface {
    @Override
    public List createData() {
        List data = new ArrayList();
        try {
            FileInputStream fileInputStream = new FileInputStream("./test");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            PsqlStore psqlStore = new PsqlStore(properties);
            List<Post> sqlData = psqlStore.getAll();
            for (Post item : sqlData) {
                data.add(item.getTitle() + " " + item.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
