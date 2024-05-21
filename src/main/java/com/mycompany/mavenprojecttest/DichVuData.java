/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author user
 */
public class DichVuData {
    private final StringProperty dichvu_id;
    private final StringProperty dichvu_ten;
    
    public DichVuData(String id, String ten) {
        this.dichvu_id = new SimpleStringProperty(id);
        this.dichvu_ten = new SimpleStringProperty(ten);
    }

    // Các phương thức getter
    public StringProperty getDichVuIdProperty(){
        return dichvu_id;
    }
    public StringProperty getDichVuTenProperty(){
        return dichvu_ten;
    }
}
