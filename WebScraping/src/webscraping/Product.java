package webscraping;

public class Product {
    private String title;
    private String price;
    private String pictureHref;
    private String productPageLink;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public void setPictureHref(String pictureHref) {
        this.pictureHref = pictureHref;
    }
}
