package ru.job4j.design.srp;

public class SerialiseReportToJson implements SerializeReport<Employee> {

    private CustomGsonBuilder customGsonBuilder = new CustomGsonBuilder();

    @Override
    public String serialise(Employee item) {
        return customGsonBuilder.createJson(item);
    }

    @Override
    public Employee deSerialize(String employeeJson) {
        Object employee = customGsonBuilder.fromJson(employeeJson, Employee.class);
        return (Employee) employee;
    }
}
