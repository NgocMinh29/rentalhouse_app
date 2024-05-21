/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author NGUYEN MY NGAN
 */
public class YCDVData {
    private StringProperty tenDV;
    private StringProperty ngaydien;
    private StringProperty trangthai;


    public YCDVData(){
        
    }

    public YCDVData(String t, String nd, String tt) {
        this.tenDV = new SimpleStringProperty(t);
        this.ngaydien = new SimpleStringProperty(nd);
        this.trangthai = new SimpleStringProperty(tt);
    }

    public StringProperty getTenDVProperty() {
        return tenDV;
    }
    
    public void setTenDVProperty(String t){
        this.tenDV = new SimpleStringProperty(t);
    }

    public StringProperty getNgayDienProperty() {
        return ngaydien;
    }

    public StringProperty getTrangThaiProperty() {
        return trangthai;
    }   

}


