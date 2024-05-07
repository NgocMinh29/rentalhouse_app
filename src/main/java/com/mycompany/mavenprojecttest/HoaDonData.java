package com.mycompany.mavenprojecttest;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class HoaDonData {
    private StringProperty hoadonid;
    private StringProperty phongid;
    //co nên tạo tên phòng không
    private IntegerProperty thang;
    private IntegerProperty nam;
    private IntegerProperty tongtien;
    private StringProperty trangthai;
    private IntegerProperty conno;
    private StringProperty kydong;
    
    public HoaDonData(String hdi, String pi, int t, int n, int tt, String trt, int cn){
        hoadonid = new SimpleStringProperty(hdi);
        phongid = new SimpleStringProperty(pi);
        thang = new SimpleIntegerProperty(t);
        nam = new SimpleIntegerProperty(n);
        tongtien = new SimpleIntegerProperty(tt);
        trangthai = new SimpleStringProperty(trt);
        conno = new SimpleIntegerProperty(cn);
        kydong = new SimpleStringProperty(t + "/" + n);
    }

    // Các phương thức getter
    public StringProperty getHoaDonIdProperty(){
        return hoadonid;
    }
    public StringProperty getPhongIdProperty(){
        return phongid;
    }
    public IntegerProperty getThangProperty(){
        return thang;
    }
    public IntegerProperty getNamProperty(){
        return nam;
    }
    public IntegerProperty getTongTienProperty(){
        return tongtien;
    }
    public StringProperty getTrangThaiProperty(){
        return trangthai;
    }
    public IntegerProperty getConNoProperty(){
        return conno;
    }
    public StringProperty getKyDongProperty(){
        return kydong;
    }    
}