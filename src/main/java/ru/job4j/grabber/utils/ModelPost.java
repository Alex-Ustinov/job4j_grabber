package ru.job4j.grabber.utils;

import java.time.LocalDateTime;

public class ModelPost {
    String id;
    String title;
    String link;
    String description;
    LocalDateTime created;

    ModelPost (String id, String title, String link, String description, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.created = created;
    }
}
