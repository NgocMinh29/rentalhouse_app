/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.userapp;

import connection.database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author NGUYEN MY NGAN
 */
public class HoaDonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label hd_cthd_slDien;

    @FXML
    private Label hd_cthd_slNuoc;

    @FXML
    private Label hd_cthd_slPhong;

    @FXML
    private Label hoadon_cthd_dongiaDien;

    @FXML
    private Label hoadon_cthd_dongiaNuoc;

    @FXML
    private Label hoadon_cthd_dongiaPhong;

    @FXML
    private Label hoadon_cthd_thanhtienDien;

    @FXML
    private Label hoadon_cthd_thanhtienNuoc;

    @FXML
    private Label hoadon_cthd_thanhtienPhong;

    @FXML
    private Label hoadon_hd_conno;

    @FXML
    private Label hoadon_hd_kidong;

    @FXML
    private ComboBox<String> hoadon_hd_tenphong;

    @FXML
    private Label hoadon_hd_tongtien;

    @FXML
    private Label hoadon_hd_trangthai;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect = database.getConn();
       
        loadTenPhong();
        LayTenPGMacDinh();
        
        
        hoadon_hd_kidong();
        hoadon_hd_tongtien();
        hoadon_hd_conno();
        hoadon_hd_trangthai();
        hoadon_cthd_dongiaPhong();
        hoadon_cthd_thanhtienPhong();
        hd_cthd_slDien();
        hoadon_cthd_dongiaDien();
        hoadon_cthd_thanhtienDien();
        hd_cthd_slNuoc();
        hoadon_cthd_dongiaNuoc();
        hoadon_cthd_thanhtienNuoc();
    }    
    private void loadTenPhong() {
        try {
            // Truy vấn để lấy tên phòng từ cơ sở dữ liệu
            String query = "SELECT PHONG.TENPG FROM PHONG, HOPDONG, CTHOPDONG, TAIKHOAN WHERE PHONG.MAP=HOPDONG.MAP "
                    + "AND HOPDONG.MHD=CTHOPDONG.MHD AND CTHOPDONG.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN=?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, LoginData.taikhoan); // Đặt giá trị cho tham số USERNAME
            ResultSet resultSet = preparedStatement.executeQuery();



            // Thêm các tên phòng vào ComboBox
            while (resultSet.next()) {
                String tenPhong = resultSet.getString("TENPG");
                hoadon_hd_tenphong.getItems().add(tenPhong);
            }
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra khi truy vấn cơ sở dữ liệu
            e.printStackTrace();
        }
    }
    
    public void LayTenPGMacDinh(){
        try {
            // Truy vấn để lấy tên phòng từ cơ sở dữ liệu
            String query = "SELECT PHONG.TENPG FROM PHONG, HOPDONG, CTHOPDONG, TAIKHOAN WHERE PHONG.MAP=HOPDONG.MAP "
                    + "AND HOPDONG.MHD=CTHOPDONG.MHD AND CTHOPDONG.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN=? AND ROWNUM=1";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, LoginData.taikhoan); // Đặt giá trị cho tham số USERNAME
            ResultSet resultSet = preparedStatement.executeQuery();

            // Thêm các tên phòng vào ComboBox
            if (resultSet.next()) {
                String tenPhong = resultSet.getString("TENPG");
                int index1 = hoadon_hd_tenphong.getItems().indexOf(tenPhong);
                if (index1 != -1) 
                    hoadon_hd_tenphong.getSelectionModel().select(index1);
               
            }
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra khi truy vấn cơ sở dữ liệu
            e.printStackTrace();
        }
    }
    
    public void hoadon_hd_kidong(){
        int thang = LocalDate.now().minusMonths(1).getMonth().getValue();
        int nam = LocalDate.now().getYear();
        String kidong = thang + "/" +nam;
        hoadon_hd_kidong.setText(kidong);
    }
    
public void hoadon_hd_tongtien() {
    String sqlTongTien = "SELECT TONGTIEN " +
                         "FROM HOADON, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                         "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                         "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                         "AND HOADON.MAP = HOPDONG.MAP " +
                         "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                         "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                         "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                         "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlTongTien);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_hd_tongtien.setText(result.getString("TONGTIEN"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_hd_conno() {
    String sqlConNo = "SELECT CONNO " +
                      "FROM HOADON, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                      "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                      "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                      "AND HOADON.MAP = HOPDONG.MAP " +
                      "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                      "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                      "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                      "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlConNo);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_hd_conno.setText(result.getString("CONNO"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_hd_trangthai() {
    String sqlTrangThai = "SELECT TRANGTHAI " +
                          "FROM HOADON, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                          "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                          "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                          "AND HOADON.MAP = HOPDONG.MAP " +
                          "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                          "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                          "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                          "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlTrangThai);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_hd_trangthai.setText(result.getString("TRANGTHAI"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_cthd_dongiaPhong() {
    String sqlDonGia = "SELECT DONGIA " +
                       "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                       "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                       "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                       "AND CTHD.LOAIHD = 'Phòng' " +
                       "AND HOADON.MAP = HOPDONG.MAP " +
                       "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                       "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                       "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                       "AND CTHD.MAHD = HOADON.MAHD " +
                       "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlDonGia);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_cthd_dongiaPhong.setText(result.getString("DONGIA"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_cthd_thanhtienPhong() {
    String sqlThanhTien = "SELECT THANHTIEN " +
                          "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                          "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                          "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                          "AND CTHD.LOAIHD = 'Phòng' " +
                          "AND HOADON.MAP = HOPDONG.MAP " +
                          "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                          "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                          "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                          "AND CTHD.MAHD = HOADON.MAHD " +
                          "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlThanhTien);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_cthd_thanhtienPhong.setText(result.getString("THANHTIEN"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hd_cthd_slDien() {
    String sqlSlDien = "SELECT SL " +
                       "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                       "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                       "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                       "AND CTHD.LOAIHD = 'Điện' " +
                       "AND HOADON.MAP = HOPDONG.MAP " +
                       "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                       "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                       "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                       "AND CTHD.MAHD = HOADON.MAHD " +
                       "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlSlDien);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hd_cthd_slDien.setText(result.getString("SL"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_cthd_dongiaDien() {
    String sqlDonGiaDien = "SELECT DONGIA " +
                           "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                           "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                           "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                           "AND CTHD.LOAIHD = 'Điện' " +
                           "AND HOADON.MAP = HOPDONG.MAP " +
                           "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                           "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                           "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                           "AND CTHD.MAHD = HOADON.MAHD " +
                           "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlDonGiaDien);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_cthd_dongiaDien.setText(result.getString("DONGIA"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_cthd_thanhtienDien() {
    String sqlThanhTienDien = "SELECT THANHTIEN " +
                              "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                              "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                              "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                              "AND CTHD.LOAIHD = 'Điện' " +
                              "AND HOADON.MAP = HOPDONG.MAP " +
                              "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                              "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                              "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                              "AND CTHD.MAHD = HOADON.MAHD " +
                              "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlThanhTienDien);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_cthd_thanhtienDien.setText(result.getString("THANHTIEN"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void hd_cthd_slNuoc() {
    String sqlSlNuoc = "SELECT SL " +
                       "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                       "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                       "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                       "AND CTHD.LOAIHD = 'Nước' " +
                       "AND HOADON.MAP = HOPDONG.MAP " +
                       "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                       "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                       "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                       "AND CTHD.MAHD = HOADON.MAHD " +
                       "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlSlNuoc);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hd_cthd_slNuoc.setText(result.getString("SL"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_cthd_dongiaNuoc() {
    String sqlDonGiaNuoc = "SELECT DONGIA " +
                           "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                           "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                           "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                           "AND CTHD.LOAIHD = 'Nước' " +
                           "AND HOADON.MAP = HOPDONG.MAP " +
                           "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                           "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                           "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                           "AND CTHD.MAHD = HOADON.MAHD " +
                           "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlDonGiaNuoc);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_cthd_dongiaNuoc.setText(result.getString("DONGIA"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void hoadon_cthd_thanhtienNuoc() {
    String sqlThanhTienNuoc = "SELECT THANHTIEN " +
                              "FROM HOADON, CTHD, HOPDONG, CTHOPDONG, KHACHTHUE, TAIKHOAN " +
                              "WHERE HOADON.THANG = EXTRACT(MONTH FROM ADD_MONTHS(SYSDATE, -1)) " +
                              "AND HOADON.NAM = EXTRACT(YEAR FROM ADD_MONTHS(SYSDATE, -1)) " +
                              "AND CTHD.LOAIHD = 'Nước' " +
                              "AND HOADON.MAP = HOPDONG.MAP " +
                              "AND CTHOPDONG.MHD = HOPDONG.MHD " +
                              "AND KHACHTHUE.MAKT = CTHOPDONG.MAKT " +
                              "AND KHACHTHUE.MAKT = TAIKHOAN.MAKT " +
                              "AND CTHD.MAHD = HOADON.MAHD " +
                              "AND TAIKHOAN.TENTAIKHOAN = ?";

    try {
        prepare = connect.prepareStatement(sqlThanhTienNuoc);
        prepare.setString(1, LoginData.taikhoan);
        result = prepare.executeQuery();

        if (result.next()) {
            hoadon_cthd_thanhtienNuoc.setText(result.getString("THANHTIEN"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
}
