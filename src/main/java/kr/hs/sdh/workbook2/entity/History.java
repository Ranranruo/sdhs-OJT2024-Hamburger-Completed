package kr.hs.sdh.workbook2.entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class History {
    public String name;
    public int price;
    public LocalDateTime saleDatetime;

    public History(String name, int price){
        this.name = name;
        this.price = price;
        this.saleDatetime = LocalDateTime.now();
    }


}
