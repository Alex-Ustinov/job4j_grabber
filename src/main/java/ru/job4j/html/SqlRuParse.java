package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    public static void main(String[] args) throws Exception {
        SqlRuParse sqlRuParse = new SqlRuParse();
        sqlRuParse.list("https://www.sql.ru/forum/job-offers/707");
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
    public List<Post> list(String link) throws IOException, ParseException {
        List<Post> postList = new ArrayList();
        Document doc = Jsoup.connect(link).get();
        Elements hrefs = doc.select(".sort_options");
        Integer amountPages = Integer.parseInt(hrefs.last().select("td").first().select("a").last().text());
        for (int i = 1; i < amountPages; i++) {
            Elements links = doc.select(".postslisttopic");
            for (Element td : links) {
                Element href = td.child(0);
                Post post = detail(String.valueOf(href.attr("href")));
                postList.add(post);
            }
        }
        return postList;
    }

    @Override
    public Post detail(String link) throws IOException, ParseException {
        Post post = new Post();
        post.getData(link);
        return post;
    }
}