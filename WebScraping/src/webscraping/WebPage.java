package webscraping;

import java.util.ArrayList;
import java.util.List;

public class WebPage {
    private String mainUrl;
    private List<String> subUrls;

    public WebPage(String url) {
        this.mainUrl = url;
        subUrls = new ArrayList<>();
    }

    public void setSubUrls(List<SubPages> subPages) {
        for (SubPages sp: subPages) {
            subUrls.add(sp.getUrl());
        }
    }

    public List<String> getSubUrls() {
        return subUrls;
    }

    public String getMainUrl() {
        return mainUrl;
    }
}
