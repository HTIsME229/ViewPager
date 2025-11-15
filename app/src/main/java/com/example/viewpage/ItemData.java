package com.example.viewpage;


public class ItemData {
    private String title;
    private String description;
    private int imageResId; // Resource ID hoặc ID giả lập

    public ItemData(String title, String description, int imageResId) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}