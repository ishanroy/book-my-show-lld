package com.isroy.dev.bms.services.search;

public class Filter {
    private String title;
    private String genre;
    private String language;
    private double priceRangeLow;
    private double priceRangeHigh;

    public Filter(String title, String genre, String language, String price) {
        this.title = title.toLowerCase();
        this.genre = genre.toLowerCase();
        this.language = language.toLowerCase();
        if(price.contains(":")){
            String[] priceRange  = price.split(":");
            if(priceRange.length == 2){
                this.priceRangeLow = Double.parseDouble(priceRange[0]);
                this.priceRangeHigh = Double.parseDouble(priceRange[1]);
            }
        }
        if(priceRangeHigh == 0.0){
            priceRangeHigh = 1000.0;
        }
    }

    public String getTitle() {
        if(title != null && !title.isEmpty())
            return title;
        else
            return ".*";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        if(genre != null && !genre.isEmpty())
            return genre;
        else
            return ".*";
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        if(language != null && !language.isEmpty())
            return language;
        else
            return ".*";
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPriceRangeLow() {
        return priceRangeLow;
    }

    public void setPriceRangeLow(double priceRangeLow) {
        this.priceRangeLow = priceRangeLow;
    }

    public double getPriceRangeHigh() {
        return priceRangeHigh;
    }

    public void setPriceRangeHigh(double priceRangeHigh) {
        this.priceRangeHigh = priceRangeHigh;
    }
}
