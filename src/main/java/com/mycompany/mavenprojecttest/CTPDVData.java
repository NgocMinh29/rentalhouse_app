package com.mycompany.mavenprojecttest;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class CTPDVData {
    private final StringProperty id;
    private final StringProperty ten;
    private final StringProperty trangthai;
    
    
    public CTPDVData(String id, String ten, String tt) {
        this.id = new SimpleStringProperty(id);
        this.ten = new SimpleStringProperty(ten);
        this.trangthai = new SimpleStringProperty(tt);
    }

    // Các phương thức getter
    public StringProperty getDichVuIdProperty(){
        return id;
    }
    public StringProperty getDichVuTenProperty(){
        return ten;
    }
    public StringProperty getTrangThaiProperty(){
        return trangthai;
    }
    
}
