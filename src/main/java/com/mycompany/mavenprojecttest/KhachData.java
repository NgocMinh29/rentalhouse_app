/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojecttest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

public class KhachData {
//    @FXML
//    private TableView<KhachData> khachngan_tableview;
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
    //private StringProperty hotendd;
    private StringProperty trangthai;

    

    public KhachData(String ki, String ht, String gt, String ns, String sdt, String cccd, String e, String ddi,String nbd,String nkt, String tt) {
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
        //this.hotendd = new SimpleStringProperty(htdd);
        this.trangthai = new SimpleStringProperty(tt);
    }
    public KhachData(String ki, String ht, String gt, String ns, String sdt, String cccd, String e,String nbd,String nkt) {
        this.khachid = new SimpleStringProperty(ki);
        this.hoten = new SimpleStringProperty(ht);
        this.gioitinh = new SimpleStringProperty(gt);
        this.ngaysinh = new SimpleStringProperty(ns);
        this.sdt = new SimpleStringProperty(sdt);
        this.cccd = new SimpleStringProperty(cccd);
        this.email = new SimpleStringProperty(e);
        this.ngaybatdau = new SimpleStringProperty(nbd);
        this.ngayketthuc = new SimpleStringProperty(nkt);
        //this.daidienid = new SimpleStringProperty(ddi);
        //this.trangthai = null;
    }
    public KhachData(String ki, String ht,String sdt, String cccd){
        this.khachid = new SimpleStringProperty(ki);
        this.hoten = new SimpleStringProperty(ht);
        this.sdt = new SimpleStringProperty(sdt);
        this.cccd = new SimpleStringProperty(cccd);
    }
    public KhachData(String ki){
        this.khachid = new SimpleStringProperty(ki);
    }

    public StringProperty getKhachidProperty() {
        return khachid;
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
    public StringProperty getTrangthaiProperty() {
        return trangthai;
    }
//    public void KhachNganXuat(ActionEvent event) {
//        try {
//            File file = new File("KhachNgan.txt");
//            FileWriter writer = new FileWriter(file);
//
//            // Extract data from TableView
//            // ... (Implement logic to extract and format data)
//
//            // Write data to text file
//            for (KhachData khach : khachngan_tableview.getItems()) {
//                String formattedRow = String.valueOf(khach.getKhachidProperty().getValue()) 
//                        + ", " + String.valueOf(khach.getHotenProperty().getValue())
//                        + ", " + String.valueOf(khach.getGioitinhProperty().getValue())
//                        + ", " + String.valueOf(khach.getNgaysinhProperty().getValue())
//                        + ", " + String.valueOf(khach.getSdtProperty().getValue())
//                        + ", " + String.valueOf(khach.getCccdProperty().getValue())
//                        ;
//                writer.write(formattedRow);
//                writer.write("\n");
//            }
//
//            writer.close();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Thông báo");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Đã xuất sang file 'KhachNgan.txt'");
//                        alert.showAndWait();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
