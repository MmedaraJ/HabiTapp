package com.example.habitapp.Model;

public class Category {
    private String name;
    private int image;
    private int numberOfReminders;
    private boolean selected;

    public Category(String name, int image, int numberOfReminders, boolean selected) {
        this.name = name;
        this.image = image;
        this.numberOfReminders = numberOfReminders;
        this.selected = selected;
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

    public int getNumberOfReminders() {
        return numberOfReminders;
    }

    public void setNumberOfReminders(int numberOfReminders) {
        this.numberOfReminders = numberOfReminders;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
