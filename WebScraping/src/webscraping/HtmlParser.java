package webscraping;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class HtmlParser {
    private String filePath = "src/webscraping/json/";

    private static FieldNamingStrategy customPolicy = new FieldNamingStrategy() {
        @Override
        public String translateName(Field f) {
            if (f.getName().equals("title")) {
                return f.getName().replace("title", "Title");
            } else if (f.getName().equals("price")) {
                return f.getName().replace("p", "P");
            } else if (f.getName().equals("pictureHref")) {
                return f.getName().replace("pictureHref", "Picture href");
            }
            return "null";
        }
    };

    /**
     *  Get data by url from all pages.
     * @param url page full url
     * @param pageAmount how many pages need to scrap.
     * @return list of products.
     */
    public List<Product> getData(String url, int pageAmount) {
        List<Product> productList = new ArrayList<>();
        String titleStr = "";
        String currentPrice = "";
        Document document = null;
        try {
            for (int i = 1; i <= pageAmount; i++) {
                document = Jsoup.connect(url + "/page-" + i).get();
                Element mainContent = document
                        .select("div.main-content__section-helper > div.container > div.row > div.col-lg-9").first();
                Elements links = mainContent.getElementsByClass("offer-thumb");
                for (Element link : links) {
                    Product product = new Product();
                    Element image = link.getElementsByClass("offer-thumb__image").get(0);
                    Element title = link.getElementsByClass("offer-thumb__title").get(0);
                    titleStr = title.attr("title");
                    Element pictureHref = image.select("a").first();
                    //String productPage = "https://www.osta.ee/" + pictureHref.attr("href");
                    String pictureHrefStr = pictureHref.attr("data-original");
                    Elements priceFooter = link.getElementsByClass("offer-thumb__footer");
                    for (Element el : priceFooter) {
                        try {
                            currentPrice = el.select("span.price-cp").first().text();
                        } catch (NullPointerException ex) {
                            System.out.println("exception by " + "Object: " + titleStr);
                            currentPrice = "N/A";
                        }
                    }
                        if (currentPrice.equals("")) {
                            Element priceDiscount = link.getElementsByClass("discount-price").get(0);
                            currentPrice = priceDiscount.text();
                        }


                    product.setTitle(titleStr);
                    product.setPrice(currentPrice);
                    product.setPictureHref(pictureHrefStr);
                    productList.add(product);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return productList;
    }


    public List<Product> sortListByPrice(List<Product> productList) {
        List<Product> result = new ArrayList<>();
        HashMap<Product, Double> prices = new HashMap<>();
        for (Product p: productList) {
            String priceStr = p.getPrice().substring(0, p.getPrice().length() - 1).replaceAll(" ", "");
            double price = Double.valueOf(priceStr);
            prices.put(p, price);
        }
        Map<Product, Double> sorted = prices
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));

        for (Map.Entry<Product, Double> entry : sorted.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }

    public void toJson(List<Product> productList, String urlName, boolean toSort) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingStrategy(customPolicy);
        String fileName = "";
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        for (SubPages sp: SubPages.values()) {
            if (sp.getUrl().contains(urlName)) {
                if (toSort) {
                    fileName = sp.name() + "_sorted.json";
                } else {
                    fileName = sp.name() + ".json";
                }
            }
        }
        try {
            Writer writer = new FileWriter(filePath  + fileName);
            gson.toJson(productList, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return gson.toJson(productList);
    }

}
