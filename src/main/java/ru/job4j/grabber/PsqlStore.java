package ru.job4j.grabber;

import ru.job4j.grabber.utils.Post;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Date;

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
    public void save(Post post) throws SQLException {
        try(PreparedStatement statement =
                    cnn.prepareStatement("INSERT INTO post(name, text, link, created) values (?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.setString(3, post.getLink());
            statement.setDate(4, new Date(Timestamp.valueOf(post.getCreated()).getTime()));
            statement.execute();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    post.setId(resultSet.getInt("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> result = new ArrayList<>();
        try (PreparedStatement statement = cnn.prepareStatement("SELECT * FROM post");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Timestamp timestamp = new Timestamp(resultSet.getDate("created").getSeconds());
                result.add(
                        new Post(resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("link"),
                            resultSet.getString("description"),
                                timestamp.toLocalDateTime()
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Post findById(int id) {
        Post result = null;
        try (PreparedStatement statement = cnn.prepareStatement("SELECT * FROM post WHERE id = ?");
                ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                result = new Post();
                result.setId(resultSet.getInt("id"));
                result.setTitle(resultSet.getString("title"));
                result.setLink(resultSet.getString("link"));
                result.setDescription(resultSet.getString("description"));
                result.setCreated(convertToLocalDate(resultSet.getDate("create")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }
}