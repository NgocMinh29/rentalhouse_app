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
public class HopDongData {
    private StringProperty hopDongId;
    private StringProperty ngayBatDau;
    private StringProperty ngayTraPhong;
    private StringProperty maKhachThue;
    private StringProperty maPhong;
    private IntegerProperty giaThue;
    private IntegerProperty tienCoc;
    private StringProperty trangThai;

    public HopDongData(String hopDongId, String ngayBatDau, String ngayTraPhong, 
                       String maKhachThue, String maPhong, int giaThue, int tienCoc, String trangThai) {
      this.hopDongId = new SimpleStringProperty(hopDongId);
      this.ngayBatDau = new SimpleStringProperty(ngayBatDau);
      this.ngayTraPhong = new SimpleStringProperty(ngayTraPhong);
      this.maKhachThue = new SimpleStringProperty(maKhachThue);
      this.maPhong = new SimpleStringProperty(maPhong);
      this.giaThue = new SimpleIntegerProperty(giaThue);
      this.tienCoc = new SimpleIntegerProperty(tienCoc);
      this.trangThai = new SimpleStringProperty(trangThai);
    }

    // Getters for all properties
    public StringProperty getHopDongIdProperty() {
      return hopDongId;
    }

    public StringProperty getNgayBatDauProperty() {
      return ngayBatDau;
    }

    public StringProperty getNgayTraPhongProperty() {
      return ngayTraPhong;
    }

    public StringProperty getMaKhachThueProperty() {
      return maKhachThue;
    }

    public StringProperty getMaPhongProperty() {
      return maPhong;
    }

    public IntegerProperty getGiaThueProperty() {
      return giaThue;
    }

    public IntegerProperty getTienCocProperty() {
      return tienCoc;
    }

    public StringProperty getTrangThaiProperty() {
      return trangThai;
    }
}
    
