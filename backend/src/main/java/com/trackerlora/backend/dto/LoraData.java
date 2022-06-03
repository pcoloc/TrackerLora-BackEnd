package com.trackerlora.backend.dto;

public class LoraData {
    public String title;
    public String Author;
    public String content;
    public String date;
    public String urlImage;

    public LoraData(String title, String author, String content, String date, String urlImage) {
        this.title = title;
        Author = author;
        this.content = content;
        this.date = date;
        this.urlImage = urlImage;
    }

    public LoraData() {
    }
}
