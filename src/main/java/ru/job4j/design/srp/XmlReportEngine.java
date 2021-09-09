package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class XmlReportEngine implements UserReport {

    private UserStore store;

    public XmlReportEngine(UserStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<User> filter) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Users.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        List<User> users =  store.findBy(filter);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Users(users), writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
