package com.example.todo;

import android.graphics.Bitmap;

public class ImgClass {
    private Bitmap imageItem;
    private String name;
    private String bytee;


    public ImgClass(Bitmap imageItem, String name, String bytee) {
        this.imageItem = imageItem;
        this.name = name;
        this.bytee = bytee;
    }

    public Bitmap getImageItem() {
        return imageItem;
    }

    public String getBytee() {
        return bytee;
    }

    public void setBytee(String bytee) {
        this.bytee = bytee;
    }

    public void setImageItem(Bitmap imageItem) {
        this.imageItem = imageItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImgClass{" +
                "imageItem=" + imageItem +
                ", name='" + name + '\'' +
                ", bytee='" + bytee + '\'' +
                '}';
    }
}
