package webscraping;

public enum SubPages {

    software_and_computer_literature("/kategooria/arvutid/tarkvara-ja-arvutikirjandus", 2),
    computer_games("/kategooria/arvutid/arvutimangud", 2),
    monitors("/kategooria/arvutid/monitorid", 5),
    printers_scanners("/kategooria/arvutid/printerid-skannerid", 2),
    tablets("/kategooria/arvutid/tahvelarvutid", 3),
    internet_www("/kategooria/arvutid/internet-ja-www", 7),
    network_devices_servers("/kategooria/arvutid/vorguseadmed-serverid", 4),
    desktop_computers("/kategooria/arvutid/lauaarvutid", 8);


    private String url;
    private int pages;

    SubPages(String url, int pages) {
        this.url = url;
        this.pages = pages;
    }

    public String getUrl() {
        return url;
    }

    public int getPages() {
        return pages;
    }
}
