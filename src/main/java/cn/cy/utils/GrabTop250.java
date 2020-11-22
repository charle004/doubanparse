package cn.cy.utils;

import cn.cy.domain.Top250;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * 豆瓣Top250爬取
 */
public class GrabTop250 {

    private static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        getTop250List().forEach(System.out::println);
    }


    public static List<Top250> getTop250List() {

        List<Top250> top250List = new ArrayList<>();

        String top250Url = "https://movie.douban.com/top250";

        for (int i = 0; i < 10; i++) {
            int start = i * 25;
            String url = top250Url + "?start=" + start;

            try {

                Document document = Jsoup.parse(new URL(url), TIMEOUT);
                Elements itemElements = document.select("ol.grid_view").select("div.item");

                for (Element element : itemElements) {

                    Top250 top250 = new Top250();

                    Elements elem = element.select("div.pic");
                    //豆瓣链接
                    String doubanUrl = elem.select("a").attr("href");
                    //封面图片url
                    String coverUrl = elem.select("img").attr("src");

                    //片名
                    StringBuilder nameBuilder = new StringBuilder();
                    Elements nameSpan = element.select("div.info").select("div.hd").select("a").select("span");
                    for (Element span : nameSpan) {
                        String name = span.text();
                        nameBuilder.append(name);
                    }

                    Integer year = null;
                    String region = null;
                    String category = null;
                    Elements pElements = element.select("div.info").select("div.bd").select("p");
                    for (Element pe : pElements) {
                        String pClass = pe.attr("class");
                        if ("".equals(pClass)) {

                            //地区 年份 类型
                            try {
                                String html = pe.html();
                                String[] split = html.split("<br>");
                                String[] split1 = split[1].split("/");
                                year = Integer.parseInt(split1[0].replaceAll("&nbsp", "").replaceAll(";", "").trim());
                                region = split1[1].replaceAll("&nbsp", "").replaceAll(";", "").trim();
                                category = split1[2].replaceAll("&nbsp", "").replaceAll(";", "").trim();
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    //一句话简介
                    String description = element.select("div.info").select("div.bd").select("p.quote").select("span").text();

                    //评分 评论数
                    String scoreStr = element.select("div.info").select("div.bd").select("div.star").select("span.rating_num").text();
                    float score = Float.parseFloat(scoreStr);
                    String reviewCountStr = element.select("div.info").select("div.bd").select("div.star").select("span:eq(3)").text();
                    int reviewCount = Integer.parseInt(reviewCountStr.replaceAll("人评价", "").trim());
                    top250.setCreateTime(LocalDateTime.now());
                    top250.setRankOf250(++start);
                    top250.setFilmName(nameBuilder.toString());
                    top250.setRate(score);
                    top250.setYear(year);
                    top250.setRegion(region);
                    top250.setCategory(category);
                    top250.setCoverUrl(coverUrl);
                    top250.setReviewCount(reviewCount);
                    top250.setDescription(description);
                    top250.setFilmId(null);
                    top250.setDoubanUrl(doubanUrl);
                    top250.setReserved1(null);
                    top250.setReserved2(null);
                    top250List.add(top250);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return top250List;
    }


}
