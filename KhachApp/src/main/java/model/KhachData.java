/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;
import javafx.beans.property.StringProperty;

public class KhachData {
    private StringProperty khachid;
    private StringProperty hoten;
    private StringProperty gioitinh;
    private StringProperty ngaysinh; // Sửa thành ObjectProperty<LocalDate>
    private StringProperty sdt;
    private StringProperty cccd;
    private StringProperty email;
    private StringProperty ngaybatdau;
    private StringProperty ngayketthuc;
    private StringProperty daidienid;
    private StringProperty hotendd;
    private StringProperty trangthai;

    public KhachData(){
        
    }

    public KhachData(String ki, String ht, String gt, String ns, String sdt, String cccd, String e, String ddi, String tt,String nbd,String nkt) {
        this.khachid = new SimpleStringProperty(ki);
        this.hoten = new SimpleStringProperty(ht);
        this.gioitinh = new SimpleStringProperty(gt);
        this.ngaysinh = new SimpleStringProperty(ns);
        this.sdt = new SimpleStringProperty(sdt);
        this.cccd = new SimpleStringProperty(cccd);
        this.email = new SimpleStringProperty(e);
        this.ngaybatdau = new SimpleStringProperty(nbd);
        this.ngayketthuc = new SimpleStringProperty(nkt);
        this.daidienid = new SimpleStringProperty(ddi);
        this.trangthai = new SimpleStringProperty(tt);
    }

    public StringProperty getKhachidProperty() {
        return khachid;
    }
    
    public void setKhachidProperty(String ki){
        this.khachid = new SimpleStringProperty(ki);
    }

    public StringProperty getHotenProperty() {
        return hoten;
    }

    public StringProperty getGioitinhProperty() {
        return gioitinh;
    }

    public StringProperty getNgaysinhProperty() {
        return ngaysinh;
    }

    public StringProperty getSdtProperty() {
        return sdt;
    }

    public StringProperty getCccdProperty() {
        return cccd;
    }

    public StringProperty getEmailProperty() {
        return email;
    }
    public StringProperty getNgaybatdauProperty() {
        return ngaybatdau;
    }
    public StringProperty getNgayketthucProperty() {
        return ngayketthuc;
    }
    public StringProperty getDaidienidProperty() {
        return daidienid;
    }

    public StringProperty getHotenddProperty() {
        return hotendd;
    }
    public StringProperty getTrangthaiProperty() {
        return trangthai;
    }

}
