package kr.hs.sdh.workbook2.entity;

import java.beans.ConstructorProperties;
import java.text.DecimalFormat;

public class Hamburger {

    private String name;
    private int price;
    private String imagePath;
    public boolean isNew;
    public boolean isRecommended;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
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
