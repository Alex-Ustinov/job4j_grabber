package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.util.List;

public class SqlRuParse implements Parse {

    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 6; i++) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/"+i).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element href = td.child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());
            }
            Elements rowDate = doc.select(".altCol");
            SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
            for (Element tds : rowDate) {
                if ("text-align:center".equals(tds.attr("style"))) {
                    System.out.println(tds.text());
                }
            }
        }
    }

    @Override
    public List<Post> list(String link) {
        return null;
    }

    @Override
    public Post detail(String link) {
        return null;
    }
}