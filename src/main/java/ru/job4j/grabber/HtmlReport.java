package ru.job4j.grabber;

import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.Report;
import ru.job4j.design.srp.Store;
import ru.job4j.template.CustomGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class HtmlReport implements Report {

    private Store store;

    public HtmlReport(Store store) {
        this.store = store;
    }
    @Override
    public String  generate(Predicate filter) throws Exception {
        List<Employee> employees = store.findBy(filter);
        StringBuilder report = new StringBuilder();
        for(Employee employee : employees) {
            CustomGenerator customGenerator = new CustomGenerator();
            HashMap<String, String> keyValue = new HashMap<>();
            Date hiredDate = employee.getHired().getTime();
            Date firedDate = employee.getFired().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strHiredDate = dateFormat.format(hiredDate);
            String strFiredDate = dateFormat.format(firedDate);
            keyValue.put("name", employee.getName());
            keyValue.put("hired", strHiredDate);
            keyValue.put("fired", strFiredDate);
            keyValue.put("name", Double.toString(employee.getSalary()));
            report.append(customGenerator
                    .produce("Name: ${name}, </br> Hired: ${hired},</br> Fired: ${fired}, Salary: ${salary}",
                            keyValue));
        }
        return report.toString();
    }
}
