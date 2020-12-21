package com.example.imgfrb;

public class Data {
    private String Judul;
    private String ImageURL;

    public Data(String judul, String imageURL) {
        Judul = judul;
        ImageURL = imageURL;
    }

    public Data() {

    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}

