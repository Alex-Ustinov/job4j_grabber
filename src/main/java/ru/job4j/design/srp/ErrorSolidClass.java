package ru.job4j.design.srp;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class ErrorSolidClass {

    public static class User {

        private String name;

        private String lastName;

        private String id;

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public List<User> saveData(List<User> users) {
        try (InputStream in = ErrorSolidClass.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            Connection cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            String sql = "insert into items (name, lastName) values (?, ?)";
            try (PreparedStatement preparedStatement = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                for (User user : users) {
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getLastName());
                    try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            user.setId(resultSet.getString(1));
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return users;
    }
}
