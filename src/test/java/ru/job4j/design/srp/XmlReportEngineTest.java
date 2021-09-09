package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class XmlReportEngineTest {

    @Test
    public void generate() throws Exception {
        CustomUserStore store = new CustomUserStore();
        User worker = new User("Ivan", "Ivanov");
        store.add(worker);
        UserReport engine = new XmlReportEngine(store);
;
        assertThat(engine.generate(em -> true), is("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<users>\n    <users/>\n</users>\n"));
    }

}