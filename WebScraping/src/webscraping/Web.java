package webscraping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Web {
    private HtmlParser htmlParser;
    private String currentPage = "";
    private String logFilePath = "src/webscraping/log.txt";

    public Web() {
        this.htmlParser = new HtmlParser();
    }



    /**
     * Goes to webpage by url and returns all available products.
     * @param page -Main webpage
     * @param url - Page sub url
     * @param toSort - by Product price.
     * @return JSON string of products.
     */
    public void goTo(WebPage page, String url, boolean toSort) {
        int pageAmount = 0;
        List<Product> resultList = new ArrayList<>();
        if (!page.getSubUrls().contains(url)) {
            String message = "\nPAGE " + page.getMainUrl() + " does not contain sub url:" + "<" + url + ">";
            this.toLog("\n" + message + ". STATUS: NOT OK");
            throw new GetRequestException(message);
        } else {
            for (SubPages sp: SubPages.values()) {
                if (sp.getUrl().contains(url)) {
                    pageAmount = sp.getPages();
                }
            }
        }
        String fullPath = page.getMainUrl() + url;
        List<Product> productList = htmlParser.getData(fullPath, pageAmount);
        if (toSort) {
            resultList = htmlParser.sortListByPrice(productList);
        } else {
            resultList = productList;
        }
        this.setCurrentPage(fullPath);
        this.toLog("\nPAGE: " + fullPath
                + ". STATUS: OK. PRODUCTS: "
                + productList.size()
                + ". TIME: " + getDateTimeStr());
        htmlParser.toJson(resultList, url, toSort);
    }



    public void setCurrentPage(String page) {
        currentPage = page;
    }

    public void toLog(String value)  {
        try (FileWriter writer = new FileWriter(logFilePath, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.append(value);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }

    public String  getDateTimeStr() {
        DateFormat df = new SimpleDateFormat("HH:mm-MM/dd/yyyy");
        Date today = Calendar.getInstance().getTime();
        String todayString = df.format(today);
        return todayString;
    }



    public static void main(String[] args) {
        Web web = new Web();
        WebPage webPage = new WebPage("https://www.osta.ee");
        WebPage webPage2 = new WebPage("https://www.osta.ee");
        webPage2.setSubUrls(Arrays.asList(
                SubPages.software_and_computer_literature));

        webPage.setSubUrls(Arrays.asList(
                SubPages.computer_games,
                SubPages.software_and_computer_literature,
                SubPages.monitors,
                SubPages.printers_scanners,
                SubPages.tablets,
                SubPages.internet_www,
                SubPages.desktop_computers,
                SubPages.network_devices_servers));




        for (int i = 0; i < webPage.getSubUrls().size(); i++) {
            System.out.println("-------------" + webPage.getSubUrls().get(i));
           web.goTo(webPage, webPage.getSubUrls().get(i), false);
        }

        for (int i = 0; i < webPage.getSubUrls().size(); i++) {
            System.out.println("-------------sorted" + webPage.getSubUrls().get(i));
            web.goTo(webPage, webPage.getSubUrls().get(i), true);
        }

        web.goTo(webPage2, SubPages.network_devices_servers.getUrl(), false);


//        System.out.println(web.goTo(webPage, SubPages.monitors.getUrl(), true));
    }
}
