package com.example.habitapp.Model;

public class List {
    private String name;

    private int image;
    private int number;
    private int colour;

    public List(String name, int image, int number, int colour) {
        this.name = name;
        this.image = image;
        this.number = number;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}