package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;

public class ModelPost {
    private Integer id;
    private String title;
    private String link;
    private String description;
    private LocalDateTime created;

    public void getData(String url) throws IOException, ParseException {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/"+url).get();
        Elements description = doc.select(".msgBody");
        this.description = description.get(1).text();

        Elements created = doc.select(".msgFooter");
        SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
        this.created = sqlRuDateTimeParser.parse(created.get(1).text());

        Elements title = doc.select(".messageHeader");
        this.title = title.get(1).text();

        Elements link = doc.select(".canonical");


        for (Element td : link) {
            System.out.println(td.attr("href"));
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        ModelPost modelPost = new ModelPost();
        modelPost.getData("1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t");
    }
}
