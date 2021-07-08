package ru.job4j.grabber;

import ru.job4j.grabber.utils.Post;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) throws SQLException {
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        cnn = DriverManager.getConnection(cfg.getProperty("url"), cfg.getProperty("login"), cfg.getProperty("password"));
    }

    @Override
    public void save(Post post) {
        try(PreparedStatement statement = cnn.prepareStatement(
                "INSERT INTO post(name, text, link, created) values (?, ?, ?, ?)"), Statement.RETURN_GENERATED_KEYS)) {
                sta
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PreparedStatement statement =
                     cnn.prepareStatement("insert into cities(name, population) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }
}