package com.example.burgerview.Model;

public class ModelLiga {
    private String image;
    private String title;

    private  String stadion;



    public ModelLiga(String image, String title, String stadion) {
        this.image = image;
        this.title = title;
        this.stadion = stadion;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
    public String getStadion() {
        return stadion;
    }

}
