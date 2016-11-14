package com.projectina.ina;

/**
 * Created by zrs on 11/13/16.
 */

public class GlossaryTerm {
    private String title, genre, year;

    public GlossaryTerm() {
    }

    public GlossaryTerm(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}