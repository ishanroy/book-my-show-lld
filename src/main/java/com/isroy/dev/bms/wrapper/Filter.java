package com.isroy.dev.bms.wrapper;

public class Filter {
    private String title;
    private String genre;
    private String language;
    private String price;

    public Filter() {
    }

    public Filter(String title, String genre, String language, String price) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
