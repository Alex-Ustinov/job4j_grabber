package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JsonReportEngineTest {
    @Test
    public void generate() throws Exception {
        CustomUserStore store = new CustomUserStore();
        User worker = new User("Ivan", "Ivanov");
        store.add(worker);
        UserReport engine = new JsonReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("[{")
                .append("\"name\":\"").append(worker.getName()).append("\"")
                .append(",\"lastName\":\"").append(worker.getLastName()).append("\"")
                .append("}]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    //[{\"name\":\"Ivan\",\"lastName\":\"Ivanov\"}]
}