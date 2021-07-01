package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {

    static Connection connection;

    static Properties readProperties() throws Exception {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("app.properties");
            FileInputStream file = new FileInputStream("./rabbit.properties")) {
            properties.load(fileInputStream);
            properties.load(file);
        }
        return properties;
    }

    AlertRabbit() throws Exception {
        Class.forName("org.postgresql.Driver");
            Properties properties = readProperties();
            connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password")
            );

    }

    public static void main(String[] args) throws Exception {
        Properties properties = readProperties();
            try {
                List<Long> store = new ArrayList<>();
                Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
                scheduler.start();
                JobDataMap data = new JobDataMap();

                data.put("store", connection);
                JobDetail job = newJob(Rabbit.class)
                        .usingJobData(data)
                        .build();
                SimpleScheduleBuilder times = simpleSchedule()
                        .withIntervalInSeconds(new Integer(properties.getProperty("rabbit.interval")))
                        .repeatForever();
                Trigger trigger = newTrigger()
                        .startNow()
                        .withSchedule(times)
                        .build();
                scheduler.scheduleJob(job, trigger);
                Thread.sleep(10000);
                scheduler.shutdown();

            } catch (Exception se) {
                se.printStackTrace();
            }
    }

    public static class Rabbit implements Job {

        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException, SQLException {
            System.out.println("Rabbit runs here ...");
            List<Long> store = (List<Long>) context.getJobDetail().getJobDataMap().get("store");
            String SQL = "insert into items (created_date) values ('1111')";
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                if (statement.executeUpdate() > 1) {
                    System.out.println(store);
                }
            }
            store.add(System.currentTimeMillis());
        }
    }

}