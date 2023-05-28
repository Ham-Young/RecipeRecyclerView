package com.example.reciperecyclerview;

public class Recipe {

    private String name;
    private String description;
    private String text;

    private int imageResId;

    public Recipe(String name, String description, String text,int imageResId) {
        this.name = name;
        this.description = description;
        this.text = text;
        this.imageResId=imageResId;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public String getText() {

        return text;
    }

    public int getImageResId() {

        return imageResId;
    }
}
