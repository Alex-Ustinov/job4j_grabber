package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class XmlReportEngineTest {

    @Test
    public void generate() throws Exception {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new XmlReportEngine(store);
;
        assertThat(engine.generate(em -> true), is(""));
    }

}