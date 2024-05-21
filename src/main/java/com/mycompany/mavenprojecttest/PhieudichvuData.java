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
public class PhieudichvuData {
    private StringProperty pdvid;
    private StringProperty phongid;
    private IntegerProperty soluongdv;
    private StringProperty ngaydien;
    
    public PhieudichvuData(String pdvi, String pi, int sl, String nd) {
        pdvid = new SimpleStringProperty(pdvi);
        phongid = new SimpleStringProperty(pi);
        soluongdv = new SimpleIntegerProperty(sl);
        ngaydien = new SimpleStringProperty(nd); 
    }
    
    public StringProperty getPDVIdProperty() {
        return pdvid;
    }
    
    public StringProperty getPhongIdProperty() {
        return phongid;
    }
    
    public IntegerProperty getSoLuongProperty() {
        return soluongdv;
    }
    
    public StringProperty getNgayDienProperty() {
        return ngaydien;
    }    
    
}
