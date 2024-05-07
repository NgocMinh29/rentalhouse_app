/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author user
 */
public class CTHDData {
    private StringProperty hoadonid;
    private StringProperty loaihoadon;
    private IntegerProperty soluong;
    private IntegerProperty dongia;
    private IntegerProperty thanhtien;
    
    public CTHDData(String hdi, String lhd, int sl, int dg){
        hoadonid = new SimpleStringProperty(hdi);
        loaihoadon = new SimpleStringProperty(lhd);
        soluong = new SimpleIntegerProperty(sl);
        dongia = new SimpleIntegerProperty(dg);
        //thanhtien = new SimpleIntegerProperty(tt);
    thanhtien = new SimpleIntegerProperty(sl*dg);

    }

    // Các phương thức getter
    public StringProperty getHoaDonIdProperty(){
        return hoadonid;
    }
    public StringProperty getLoaiHDProperty(){
        return loaihoadon;
    }
    public IntegerProperty getSoLuongProperty(){
        return soluong;
    }
    public IntegerProperty getDonGiaProperty(){
        return dongia;
    }
    public IntegerProperty getThanhTienProperty(){
        return thanhtien;
    }
  
}
