package ru.job4j.template;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testProduceErrorTemplateNotHasKey() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Template does not have key");
        CustomGenerator  customGenerator = new CustomGenerator();
        HashMap<String, String> keyValue = new HashMap<>();
        keyValue.put("name", "Petr Arsentev");
        keyValue.put("subject", "you");
        keyValue.put("test", "test");
        customGenerator.produce("I am a ${name}, Who are ${subject}?", keyValue);
    }

    @Test
    public void testProduceErrorMapNotHasKey() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Map does not have key for replacement");
        CustomGenerator  customGenerator = new CustomGenerator();
        HashMap<String, String> keyValue = new HashMap<>();
        keyValue.put("name", "Petr Arsentev");
        keyValue.put("subject", "you");
        customGenerator.produce("I am a ${name}, Who are ${subject}? ${test}", keyValue);
    }
}