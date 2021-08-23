package ru.job4j.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomGenerator implements Generator {

    @Override
    public String produce(String template, Map<String, String> args) throws Exception {
        String result = template;
        CustomGenerator  customGenerator = new CustomGenerator();
        List<String> keys = customGenerator.getTemplateKeys(template);
        for (Map.Entry<String, String> entry : args.entrySet()) {
            if (keys.contains(entry.getKey())) {
                result = setTemplate(result, entry.getKey(), entry.getValue());
            } else {
                throw new Exception("Map does not have key for replacement");
            }
        }
        for (int i = 0; i < keys.size(); i++) {
            if (!args.containsKey(keys.get(i))) {
                throw new Exception("Template does not have key");
            }
        }
        return result;
    }

    public String setTemplate (String template, String key, String value) {
        return template.replace("${" + key + "}", value);
    }

    public List<String> getTemplateKeys(String template) {
        List<String> rsl = new ArrayList();
        Pattern pattern = Pattern.compile("[\\{](.*?)[\\}]");
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            rsl.add(matcher.group(1));
        }
        return rsl;
    }

    public static void main(String[] args) throws Exception {
        CustomGenerator  customGenerator = new CustomGenerator();
        HashMap<String, String> keyValue = new HashMap<>();
        keyValue.put("name", "Petr Arsentev");
        keyValue.put("subject", "you");
        System.out.println(customGenerator.produce("I am a ${name}, Who are ${subject}? ", keyValue));

    }
}
