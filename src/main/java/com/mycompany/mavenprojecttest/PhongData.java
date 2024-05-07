/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhongData {
    private final StringProperty phongid;
    private final StringProperty tenphong;
    private final StringProperty loai;
    private final IntegerProperty songdgo;
    private final IntegerProperty dientich;
    private final IntegerProperty gia;
    private final StringProperty trangthai;

    public PhongData(String pi, String tp, String l, int sndo, int dt, int g, String trt) {
        this.phongid = new SimpleStringProperty(pi);
        this.tenphong = new SimpleStringProperty(tp);
        this.loai = new SimpleStringProperty(l);
        this.songdgo = new SimpleIntegerProperty(sndo);
        this.dientich = new SimpleIntegerProperty(dt);
        this.gia = new SimpleIntegerProperty(g);
        this.trangthai = new SimpleStringProperty(trt);
    }

    public StringProperty getPhongidProperty() {
        return phongid;
    }

    public StringProperty getTenphongProperty() {
        return tenphong;
    }

    public StringProperty getLoaiProperty() {
        return loai;
    }

    public IntegerProperty getSongdgoProperty() {
        return songdgo;
    }

    public IntegerProperty getDientichProperty() {
        return dientich;
    }

    public IntegerProperty getGiaProperty() {
        return gia;
    }

    public StringProperty getTrangthaiProperty() {
        return trangthai;
    }
}
