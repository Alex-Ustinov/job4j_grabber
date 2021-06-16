package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {

    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        try (InputStream inputStream = AlertRabbit.class.getClassLoader().getResourceAsStream("app.properties") ) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password")
            );
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (FileInputStream file = new FileInputStream("./rabbit.properties");
                Connection connection = getConnection()) {
                properties.load(file);
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
                String SQL = "insert into items (created_date) values ('1111')";
                try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                    if (statement.executeUpdate() > 1) {
                        System.out.println(store);
                    }
                }
                Thread.sleep(10000);
                scheduler.shutdown();

            } catch (Exception se) {
                se.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Rabbit implements Job {

        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            List<Long> store = (List<Long>) context.getJobDetail().getJobDataMap().get("store");
            store.add(System.currentTimeMillis());
        }
    }

}