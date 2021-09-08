package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HrReport implements Report {

    private Store store;

    HrReport(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name; Salary");
        List<Employee> employees = store.findBy(filter);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        for (Employee employee : employees) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(employee.getName()).append(";");
            stringBuilder.append(employee.getSalary()).append(";");
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
