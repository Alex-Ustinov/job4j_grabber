package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CustomGeneratorTest {


    @Test
    public void testProduce() throws Exception {
        CustomGenerator  customGenerator = new CustomGenerator();
        HashMap<String, String> keyValue = new HashMap<>();
        keyValue.put("name", "Petr Arsentev");
        keyValue.put("subject", "you");
        assertThat(customGenerator.produce("I am a ${name}, Who are ${subject}?", keyValue), is("I am a Petr Arsentev, Who are you?"));
    }
}