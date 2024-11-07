package kr.hs.sdh.workbook2.entity;

import java.beans.ConstructorProperties;
import java.text.DecimalFormat;

public class Hamburger {

    private final String name;
    private final int price;
    private String imagePath;
    private final boolean isNew;
    private final boolean isRecommended;

    @ConstructorProperties(value = {
        "name",
        "price",
        "imagePath",
        "isNew",
        "isRecommended"
    })
    public Hamburger(String name, int price, String imagePath, boolean isNew, boolean isRecommended) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.isNew = isNew;
        this.isRecommended = isRecommended;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public boolean getIsRecommended() {
        return isRecommended;
    }

    public String getPriceByFormat(){
        return new DecimalFormat("##,###").format(this.price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hamburger hamburger) {
            return hamburger.name.contentEquals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 123;
    }

}