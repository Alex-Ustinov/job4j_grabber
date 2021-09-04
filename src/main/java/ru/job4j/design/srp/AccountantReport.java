package ru.job4j.design.srp;

import java.util.function.Predicate;

public class AccountantReport implements Report {

    private Store store;
    private Double exchangeRateDollar = 1.72;

    public Double getExchangeRateDollar () {
        return this.exchangeRateDollar;
    }

    AccountantReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name; Hired; Fired; Salary");
        for (Employee employee : store.findBy(filter)) {
            Double wage = (Double) employee.getSalary() * exchangeRateDollar;
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(employee.getName()).append(";");
            stringBuilder.append(employee.getHired()).append(";");
            stringBuilder.append(employee.getFired()).append(";");
            stringBuilder.append(wage).append(";");
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
