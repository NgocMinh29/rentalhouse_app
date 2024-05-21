/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import DAO.HoaDonDAO;
import connection.database;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HoadonController implements Initializable {
    
    @FXML
    private TextField conno_conno;

    @FXML
    private AnchorPane conno_form;

    @FXML
    private Button hoadon_capnhatbtn;                                           //hoadon

    @FXML
    private TableColumn<HoaDonData, String> hoadon_col_conno;

    @FXML
    private TableColumn<HoaDonData, String> hoadon_col_id;

    @FXML
    private TableColumn<HoaDonData, String> hoadon_col_kydong;

    @FXML
    private TableColumn<HoaDonData, String> hoadon_col_maphong;

    @FXML
    private TableColumn<HoaDonData, String> hoadon_col_tongtien;

    @FXML
    private TableColumn<HoaDonData, String> hoadon_col_trangthai;

    @FXML
    private TextField hoadon_conno;

    @FXML
    private AnchorPane hoadon_form;

    @FXML
    private TextField hoadon_tenphong;
    
    @FXML
    private TextField hoadon_id;

    @FXML
    private TextField hoadon_kydong;

    @FXML
    private Button hoadon_lammoibtn;

//    @FXML
//    private TextField hoadon_maphong;
    
    @FXML
    private Button hoadon_thanhtoan1phan;
    
    @FXML
    private Button hoadon_dathanhtoan;
    
    @FXML
    private ComboBox<?> hoadon_maphong;

    @FXML
    private TextField hoadon_search;

    @FXML
    private TableView<HoaDonData> hoadon_tableview;

    @FXML
    private Button hoadon_thembtn;

    @FXML
    private TextField hoadon_tongtien;

    @FXML
    private ComboBox<?> hoadon_trangthai;
    
    @FXML
    private ComboBox<?> hoadon_thang;
    
    @FXML
    private ComboBox<?> hoadon_nam;

    @FXML
    private Button hoadon_xemchitietbtn;

    @FXML
    private Button hoadon_xoabtn;
    
    @FXML
    private TableView<CTHDData> cthd_tableview;                                 //cthd
    
    @FXML
    private AnchorPane cthd_form;
    
    @FXML
    private Label cthd_hdid;

    @FXML
    private Button cthd_capnhatbtn;

    @FXML
    private TableColumn<CTHDData, String> cthd_col_dongia;

    @FXML
    private TableColumn<CTHDData, String> cthd_col_hdid;

    @FXML
    private TableColumn<CTHDData, String> cthd_col_sl;
    
    @FXML
    private TableColumn<CTHDData, String> cthd_col_loaihd;

    @FXML
    private TableColumn<CTHDData, String> cthd_col_thanhtien;

    @FXML
    private TextField cthd_dongia;

    @FXML
    private Label cthd_tenphong;
     
    @FXML
    private Label cthd_tongtien;
    
    @FXML
    private Label cthd_kydong;
    
    @FXML
    private Label cthd_maphong;

    @FXML
    private Button cthd_lammoibtn;

    @FXML
    private ComboBox<?> cthd_loaihd;

    @FXML
    private TextField cthd_sl;

    @FXML
    private TextField cthd_thanhtien;

    @FXML
    private Button cthd_thembtn;

    @FXML
    private Button cthd_xoabtn;

    @FXML
    private Button cthd_quaylai;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private CallableStatement caSt;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    private HoaDonDAO hd;
    
    public void HoaDonThem(ActionEvent event) { //SỬA THÀNH NHẬP TRẠNG THÁI VÀ CONNO RỖNG VẪN ĐƯỢC

//        String sql = "INSERT INTO HOADON (MAHD,MAPHONG,THANG,NAM,TONGTIEN,TRANGTHAI,CONNO) "
//                + "VALUES(?,?,?,?,?,?,?)";
//
//        connect = database.getConn();

        try {
            Alert alert;

            if (//hoadon_id.getText().isEmpty()
                    //|| hoadon_maphong.getText().isEmpty()
                     hoadon_maphong.getSelectionModel().getSelectedItem() == null
                    //|| hoadon_trangthai.getSelectionModel().getSelectedItem() == null
                    || hoadon_thang.getSelectionModel().getSelectedItem() == null
                    || hoadon_nam.getSelectionModel().getSelectedItem() == null
                    //|| hoadon_tongtien.getText().isEmpty()
                    //|| hoadon_conno.getText().isEmpty()
                    ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
//                int flag = 0;
//                try {
//                    Integer.parseInt(hoadon_conno.getText());
//                   flag++;     
//                    
//                } catch (NumberFormatException e) {
//                    
//                }
//                if (flag==0 && !hoadon_conno.getText().isEmpty()){
//                    alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Tiền nợ phải là số nguyên.");
//                    alert.showAndWait();
//                    
//                } else
//                    if (Integer.parseInt(hoadon_conno.getText()) > 0 && !hoadon_conno.getText().isEmpty()){
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Tiền nợ phải bé hơn hoặc bằng tổng tiền.");
//                alert.showAndWait();
//                }
                    //else {
                    // CHECK IF THE FLOWER ID IS ALREADY EXIST
                    String checkData = "SELECT MAHD FROM HOADON WHERE MAHD = '"
                            + hoadon_id.getText() + "'";

                    statement = connect.createStatement();
                    result = statement.executeQuery(checkData);

                    if (result.next()) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Ma hoa don: " + hoadon_id.getText() + " was already exist!");
                        alert.showAndWait();
                    } else {
//                        prepare = connect.prepareStatement(sql);
//                        prepare.setString(1, hoadon_id.getText());
//                        //prepare.setString(2, hoadon_maphong.getText());
//                        prepare.setString(2, (String) hoadon_maphong.getSelectionModel().getSelectedItem());
//                        prepare.setString(3, String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()));
//                        prepare.setString(4, String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
//                        prepare.setString(5, hoadon_tongtien.getText());
//                        prepare.setString(6, (String) hoadon_trangthai.getSelectionModel().getSelectedItem());
//                        prepare.setString(7, hoadon_conno.getText());
//
//                        prepare.executeUpdate();
//                        hd.ThemHoaDon(hoadon_id.getText(),(String) hoadon_maphong.getSelectionModel().getSelectedItem()
//                                , String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()),
//                                String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()),
//                                hoadon_tongtien.getText(),
//                                (String) hoadon_trangthai.getSelectionModel().getSelectedItem(),
//                                hoadon_conno.getText());
                        
                        String strCall = "{call them_HoaDon(?,?,?)}";
                        caSt = connect.prepareCall(strCall);
                 
                        caSt.setString(1, String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()));
  
                        caSt.setString(2, String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
    //                    
                        caSt.setString(3, (String) hoadon_maphong.getSelectionModel().getSelectedItem());
                        
                        caSt.execute();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();
                        
                        String sql = "SELECT MAHD FROM HOADON WHERE MAP = ? AND THANG = ? AND NAM = ?";
                        prepare = connect.prepareStatement(sql);
                        prepare.setString(1, (String) hoadon_maphong.getSelectionModel().getSelectedItem());
                        prepare.setString(2, String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()));
                        prepare.setString(3, String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
                        result = prepare.executeQuery();

                        if (result.next()) cthd_hdid.setText(result.getString(1));
                        cthd_kydong.setText(String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()) + "/" +String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
                        cthd_maphong.setText((String) hoadon_maphong.getSelectionModel().getSelectedItem());
                        cthd_tenphong.setText(hoadon_tenphong.getText());
                        
                        sql = "SELECT TONGTIEN FROM HOADON WHERE MAHD = ?";
                        prepare = connect.prepareStatement(sql);
                        prepare.setString(1, cthd_hdid.getText());
                        result = prepare.executeQuery();
                        
                        if (result.next())cthd_tongtien.setText(result.getString(1));
                        CTHDShowListData();

                        cthd_thanhtien.setDisable(true);
                        cthd_loaihd.setDisable(false);

                        cthd_xoabtn.setDisable(true); 
                        cthd_capnhatbtn.setDisable(true);

                        CTHDLoaiHD();

                        hoadon_form.setVisible(false);
                        conno_form.setVisible(false);
                        cthd_form.setVisible(true);
            
                        HoaDonClear();
                        
                   // }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void HoaDonUpdate(ActionEvent event) {

//        String sql = "UPDATE HOADON SET TONGTIEN = "
//                + Integer.valueOf(hoadon_tongtien.getText()) + ", MAPHONG = '"
//                //+ hoadon_maphong.getText() + "', THANG = "
//                + hoadon_maphong.getSelectionModel().getSelectedItem() + "', THANG = "
//                + Integer.valueOf(String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem())) + ", NAM = "
//                + Integer.valueOf(String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem())) + ", TRANGTHAI = '"
//                + hoadon_trangthai.getSelectionModel().getSelectedItem() + "', CONNO = "
//                + Integer.valueOf(hoadon_conno.getText()) + " WHERE MAHD = '" 
//                + hoadon_id.getText() + "'";
//        
////        String sql = "UPDATE HOADON "
////                + "SET TONGTIEN = ?, MAPHONG = ?, THANG = ?, NAM = ?, TRANGTHAI = ?, CONNO = ?" +
////                    " WHERE MAHD = ?;";
//
//        connect = database.getConn();

        try {
            Alert alert;

            if (hoadon_id.getText().isEmpty()
                    //|| hoadon_maphong.getText().isEmpty()
                    || hoadon_maphong.getSelectionModel().getSelectedItem() == null
                    || hoadon_trangthai.getSelectionModel().getSelectedItem() == null
                    || hoadon_thang.getSelectionModel().getSelectedItem() == null
                    || hoadon_nam.getSelectionModel().getSelectedItem() == null
                    || hoadon_tongtien.getText().isEmpty()
                    || hoadon_conno.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE HOADON ID: " + hoadon_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
//                    prepare = connect.prepareStatement(sql);
//                    prepare.setString(1, hoadon_tongtien.getText());
//                    prepare.setString(2, hoadon_maphong.getText());
//                    prepare.setString(3, String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()));
//                    prepare.setString(4, String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
//                    prepare.setString(5, (String) hoadon_trangthai.getSelectionModel().getSelectedItem());
//                    prepare.setString(6, hoadon_conno.getText());
//                    prepare.setString(7, hoadon_id.getText());
//                    
//                    prepare.executeUpdate();
                    
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
                    hd.SuaHoaDon(hoadon_id.getText(),(String) hoadon_maphong.getSelectionModel().getSelectedItem(),
                            Integer.valueOf(String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem())) ,
                            Integer.valueOf(String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem())),
                             Integer.valueOf(hoadon_tongtien.getText()),
                             (String)hoadon_trangthai.getSelectionModel().getSelectedItem() ,
                              Integer.valueOf(hoadon_conno.getText()));
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    //HoaDonShowListData();

                    // CLEAR ALL FIELDS
                    HoaDonClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void HoaDonConNo(ActionEvent event) {

        try {
            Alert alert;

            if (hoadon_id.getText().isEmpty()
                    //|| hoadon_maphong.getText().isEmpty()
                    ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng chọn hóa đơn!");
                alert.showAndWait();

            }else if ("Đã thanh toán".equals((String)hoadon_trangthai.getSelectionModel().getSelectedItem())) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hóa đơn này đã thanh toán!");
                alert.showAndWait();

            } else { hoadon_form.setVisible(false);
            cthd_form.setVisible(false);
            conno_form.setVisible(true);
            conno_conno.setText("");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void HoaDonDaThanhToan(ActionEvent event) {

        try {
            Alert alert;

            if (hoadon_id.getText().isEmpty()
                    //|| hoadon_maphong.getText().isEmpty()
                    ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng chọn hóa đơn!");
                alert.showAndWait();

            }else if ("Đã thanh toán".equals((String)hoadon_trangthai.getSelectionModel().getSelectedItem())) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hóa đơn này đã thanh toán!");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc hóa đơn này đã thanh toán?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
//                    prepare = connect.prepareStatement(sql);
//                    prepare.setString(1, hoadon_tongtien.getText());
//                    prepare.setString(2, hoadon_maphong.getText());
//                    prepare.setString(3, String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()));
//                    prepare.setString(4, String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
//                    prepare.setString(5, (String) hoadon_trangthai.getSelectionModel().getSelectedItem());
//                    prepare.setString(6, hoadon_conno.getText());
//                    prepare.setString(7, hoadon_id.getText());
//                    
//                    prepare.executeUpdate();
                    
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
                    hd.SuaHoaDon(hoadon_id.getText(),(String) hoadon_maphong.getSelectionModel().getSelectedItem(),
                            Integer.valueOf(String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem())) ,
                            Integer.valueOf(String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem())),
                             Integer.valueOf(hoadon_tongtien.getText()),
                             "Đã thanh toán" ,0);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("Đã cập nhật thành công!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    //HoaDonShowListData();

                    // CLEAR ALL FIELDS
                    HoaDonClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void HoaDonSelect() {  //lam them khong cho sua mahd,bla
        HoaDonData hoadon = hoadon_tableview.getSelectionModel().getSelectedItem();
        int num = hoadon_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        hoadon_id.setText(String.valueOf(hoadon.getHoaDonIdProperty().getValue()));
        //hoadon_maphong.setText(String.valueOf(hoadon.getPhongIdProperty().getValue()));
        hoadon_tongtien.setText(String.valueOf(hoadon.getTongTienProperty().getValue()));
        hoadon_conno.setText(String.valueOf(hoadon.getConNoProperty().getValue()));
        int index = hoadon_thang.getItems().indexOf(Integer.valueOf(hoadon.getThangProperty().getValue()));
        if (index != -1) {
            hoadon_thang.getSelectionModel().select(index);
        }
        int index2 = hoadon_nam.getItems().indexOf(Integer.valueOf(hoadon.getNamProperty().getValue()));
        if (index2 != -1) {
            hoadon_nam.getSelectionModel().select(index2);
        }
        int index1 = hoadon_trangthai.getItems().indexOf(String.valueOf(hoadon.getTrangThaiProperty().getValue()));
        if (index1 != -1) {
            hoadon_trangthai.getSelectionModel().select(index1);
        }
        int index3 = hoadon_maphong.getItems().indexOf(String.valueOf(hoadon.getPhongIdProperty().getValue()));
        if (index3 != -1) {
            hoadon_maphong.getSelectionModel().select(index3);
        }
        
        //hoadon_tongtien.setDisable(false);
        hoadon_xemchitietbtn.setDisable(false); 
        hoadon_capnhatbtn.setDisable(false); 
        hoadon_xoabtn.setDisable(false); 
//        hoadon_thanhtoan1phan.setDisable(false); 
//        hoadon_dathanhtoan.setDisable(false); 
        //hoadon_id.setDisable(true);
        hoadon_maphong.setDisable(true);
        
        //hoadon_thang.setText(String.valueOf(hoadon.getThangProperty()));
        String hdn = String.valueOf(hoadon.getNamProperty().getValue());
        String hdmap = String.valueOf(hoadon.getPhongIdProperty().getValue());
        String hdt = String.valueOf(hoadon.getThangProperty().getValue());
        String hdcn = String.valueOf(hoadon.getConNoProperty().getValue());
        String hdtt = String.valueOf(hoadon.getTrangThaiProperty().getValue());
        
        if ("Đã thanh toán".equals(hdtt)) {
            //hoadon_maphong.setDisable(true);
            hoadon_thang.setDisable(true);
            hoadon_nam.setDisable(true); 
//            hoadon_dathanhtoan.setDisable(true); 
//            hoadon_thanhtoan1phan.setDisable(true); 
        }
        else {
            //hoadon_maphong.setDisable(true);
            hoadon_thang.setDisable(false);
            hoadon_nam.setDisable(false);
//            hoadon_dathanhtoan.setDisable(false); 
//            hoadon_thanhtoan1phan.setDisable(false); 
        }
        
//        hoadon_conno.textProperty().addListener((observable, oldValue, newValue) -> {
//            
//            if (newValue.equals(hdcn) 
//                    && ((String) hoadon_trangthai.getSelectionModel().getSelectedItem()).equals(hdtt)
//                    && ((String)hoadon_maphong.getSelectionModel().getSelectedItem()).equals(hdmap)
//                    //&& hoadon_maphong.getText().equals(hdmap)
//                    && String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()).equals(hdt)
//                    && String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()).equals(hdn)){
//                hoadon_xemchitietbtn.setDisable(false);
//                hoadon_xoabtn.setDisable(false);
//                hoadon_thanhtoan1phan.setDisable(false); 
//                hoadon_dathanhtoan.setDisable(false); 
//            } else{
//                hoadon_xemchitietbtn.setDisable(true);
//                hoadon_xoabtn.setDisable(true); 
//            }
//        });
//        hoadon_trangthai.valueProperty().addListener((observable, oldValue, newValue) -> {
//            hoadon_xemchitietbtn.setDisable(true);
//            hoadon_xoabtn.setDisable(true); 
//            if (newValue.equals(hdtt) 
//                    && hoadon_conno.getText().equals(hdcn)
//                    && ((String)hoadon_maphong.getSelectionModel().getSelectedItem()).equals(hdmap)
//                    //&& hoadon_maphong.getText().equals(hdmap)
//                    && String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()).equals(hdt)
//                    && String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()).equals(hdn)){
//                hoadon_xemchitietbtn.setDisable(false);
//                hoadon_xoabtn.setDisable(false);
//                hoadon_thanhtoan1phan.setDisable(false); 
//                hoadon_dathanhtoan.setDisable(false); 
//            } else{
//                hoadon_xemchitietbtn.setDisable(true);
//                hoadon_xoabtn.setDisable(true); 
//            }
//        });       
        //hoadon_maphong.textProperty().addListener((observable, oldValue, newValue) -> {
//        hoadon_maphong.valueProperty().addListener((observable, oldValue, newValue) -> {
//            hoadon_xemchitietbtn.setDisable(true);
//            hoadon_xoabtn.setDisable(true); 
////            hoadon_thanhtoan1phan.setDisable(true); 
////            hoadon_dathanhtoan.setDisable(true);
//            if (newValue.equals(hdmap) 
//                    && ((String) hoadon_trangthai.getSelectionModel().getSelectedItem()).equals(hdtt)
//                    && hoadon_conno.getText().equals(hdcn)
//                    && String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()).equals(hdt)
//                    && String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()).equals(hdn)){
//                hoadon_xemchitietbtn.setDisable(false);
//                hoadon_xoabtn.setDisable(false);
////                hoadon_thanhtoan1phan.setDisable(false); 
////                hoadon_dathanhtoan.setDisable(false); 
//            }
//        });
        hoadon_thang.valueProperty().addListener((observable, oldValue, newValue) -> {
            
            if (newValue == Integer.valueOf(hdt)
//                    && hoadon_conno.getText().equals(hdcn)
//                    //&& hoadon_maphong.getText().equals(hdmap)
//                    && ((String)hoadon_maphong.getSelectionModel().getSelectedItem()).equals(hdmap)
//                    && ((String) hoadon_trangthai.getSelectionModel().getSelectedItem()).equals(hdtt)
                    && String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()).equals(hdn)){
                hoadon_xemchitietbtn.setDisable(false);
                hoadon_xoabtn.setDisable(false);
//                hoadon_thanhtoan1phan.setDisable(false); 
//                hoadon_dathanhtoan.setDisable(false); 
            }else{
                   hoadon_xemchitietbtn.setDisable(true);
            hoadon_xoabtn.setDisable(true);  
            }
        }); 
        hoadon_nam.valueProperty().addListener((observable, oldValue, newValue) -> {
             
            if (newValue == Integer.valueOf(hdn) 
//                    && hoadon_conno.getText().equals(hdcn)
//                    //&& hoadon_maphong.getText().equals(hdmap)
//                    && ((String)hoadon_maphong.getSelectionModel().getSelectedItem()).equals(hdmap)
                    && String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()).equals(hdt)
//                    && ((String) hoadon_trangthai.getSelectionModel().getSelectedItem()).equals(hdtt)
                    ) {
                hoadon_xemchitietbtn.setDisable(false);
                hoadon_xoabtn.setDisable(false);
//                hoadon_thanhtoan1phan.setDisable(false); 
//                hoadon_dathanhtoan.setDisable(false); 
            }else{
                hoadon_xemchitietbtn.setDisable(true);
            hoadon_xoabtn.setDisable(true);
            }
        });  
        
        HoaDonId = String.valueOf(hoadon.getHoaDonIdProperty().getValue());  
        MaPhong = String.valueOf(hoadon.getPhongIdProperty().getValue());
        KyDong= String.valueOf(hoadon.getKyDongProperty().getValue());  
        TongTien = String.valueOf(hoadon.getTongTienProperty().getValue());
        TenPhong = String.valueOf(hoadon_tenphong.getText());
    }
    
    public void DoiMaPhong(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        hoadon_maphong.valueProperty().addListener((Observable, oldValue, newValue) -> {
        String sql = "SELECT TENPG FROM PHONG WHERE MAP = ?";
        if (newValue == null){
            hoadon_tenphong.setText("");
        }
        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, (String)newValue);
            result = prepare.executeQuery();
            
            if(result.next()){
                hoadon_tenphong.setText(result.getString(1));
            } else {
                hoadon_tenphong.setText("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
    }
    
    private String HoaDonId;
    private String MaPhong;
    private String TenPhong;
    private String KyDong;
    private String TongTien;
    
     public void HoaDonXoa(ActionEvent event) {

        String sql = "DELETE HOADON WHERE MAHD = '"
                + hoadon_id.getText() + "'";

        connect = database.getConn();

        try {
            Alert alert;

            if (hoadon_id.getText().isEmpty()
                    //|| hoadon_maphong.getText().isEmpty()
                    || hoadon_maphong.getSelectionModel().getSelectedItem() == null
                    || hoadon_trangthai.getSelectionModel().getSelectedItem() == null
                    || hoadon_thang.getSelectionModel().getSelectedItem() == null
                    || hoadon_nam.getSelectionModel().getSelectedItem() == null
                    || hoadon_tongtien.getText().isEmpty()
                    || hoadon_conno.getText().isEmpty())   {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill HOADON_ID fields");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE HOA DON where MAHD: " + hoadon_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    //HoaDonShowListData();

                    HoaDonClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void HoaDonClear() { //sua luon setdisable cua may texfield

        hoadon_id.setText("");
        //hoadon_maphong.setText("");
        hoadon_maphong.getSelectionModel().clearSelection();
        hoadon_tenphong.setText("");
        hoadon_thang.getSelectionModel().clearSelection();
        hoadon_nam.getSelectionModel().clearSelection();
        hoadon_trangthai.getSelectionModel().clearSelection();
        //hoadon_tongtien.setText("");
        hoadon_conno.setText("");
        hoadon_search.setText("");
        
        HoaDonShowListData();
        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
        hoadon_xemchitietbtn.setDisable(true); 
        hoadon_thembtn.setDisable(false); 
        hoadon_xoabtn.setDisable(true); 
        hoadon_capnhatbtn.setDisable(true); 
        hoadon_id.setDisable(false);
        hoadon_tongtien.setDisable(true); 
        hoadon_maphong.setDisable(false);
        
        hoadon_tongtien.setText(String.valueOf(0));
        
        
    }
    
    public void HoaDonSearch() {
        
        FilteredList<HoaDonData> filter = new FilteredList<>(HoaDonList, e -> true);

        hoadon_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate((HoaDonData PrediateHoaDonData) -> {

                if (newValue.isEmpty() /*|| newValue == null*/) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (String.valueOf(PrediateHoaDonData.getHoaDonIdProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHoaDonData.getKyDongProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHoaDonData.getTrangThaiProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHoaDonData.getPhongIdProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHoaDonData.getTongTienProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHoaDonData.getConNoProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    return false;
                }
            });

        SortedList<HoaDonData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(hoadon_tableview.comparatorProperty());

        hoadon_tableview.setItems(sortList);
        });
    }
    
    public void HoaDonPhong() {
        String sql = "SELECT MAP FROM PHONG WHERE TRANGTHAI = 'Đã cho thuê'";
        List<String> listS = new ArrayList<>();

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            HoaDonData hoadon;
            while (result.next()) { 
                listS.add(result.getString("MAP"));
                
            }
        

        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        hoadon_maphong.setItems(listData);
        
    }
    
    //String HoaDonStatus[] = {"Chua thanh toan", "Da thanh toan"};
    public void HoaDonStatus() {
        ObservableList listData = FXCollections.observableArrayList("Chưa thanh toán", "Đã thanh toán");
        hoadon_trangthai.setItems(listData);
        
    }    
    //int HoaDonThang[] = {1,2,3,4,5,6,7,8,9,10,11,12};
    public void HoaDonThang() {
        ObservableList listData = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
        hoadon_thang.setItems(listData);
    }   
    //int HoaDonNam[] = {2023,2024};
    public void HoaDonNam() {
        List<Integer> listS = new ArrayList<>();
        for (int year = currentYear; year >= 0; year--) {
            listS.add(year);
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        hoadon_nam.setItems(listData);
    }
    
    
    public ObservableList<HoaDonData> HoaDonListData() {

        ObservableList<HoaDonData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM HOADON";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            HoaDonData hoadon;

            while (result.next()) { 
                hoadon = new HoaDonData(result.getString("MAHD"),
                         result.getString("MAP"), result.getInt("THANG"),
                         result.getInt("NAM"), result.getInt("TONGTIEN"),
                         result.getString("TRANGTHAI"), result.getInt("CONNO"));

                listData.add(hoadon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<HoaDonData> HoaDonList;

    public void HoaDonShowListData() {
        HoaDonList = HoaDonListData();
        try{
        hoadon_col_id.setCellValueFactory(cellData -> cellData.getValue().getHoaDonIdProperty());
        hoadon_col_maphong.setCellValueFactory(cellData -> cellData.getValue().getPhongIdProperty());
        hoadon_col_kydong.setCellValueFactory(cellData -> cellData.getValue().getKyDongProperty());
        hoadon_col_tongtien.setCellValueFactory(cellData -> cellData.getValue().getTongTienProperty().asString());
        hoadon_col_trangthai.setCellValueFactory(cellData -> cellData.getValue().getTrangThaiProperty());
        hoadon_col_conno.setCellValueFactory(cellData -> cellData.getValue().getConNoProperty().asString());
        
        hoadon_tableview.setItems(HoaDonList);
        }catch (NullPointerException e) {
            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
            //hoadonMaPhong = ""; // Gán giá trị mặc định
          }
    }

    
    public void backofCTHD(ActionEvent ev){

            hoadon_form.setVisible(true);
            cthd_form.setVisible(false);
            conno_form.setVisible(false);
            HoaDonClear();
    }
    
    public void DoiLoaiCTHD(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        cthd_loaihd.valueProperty().addListener((Observable, oldValue, newValue) -> {
            if (newValue == "Phòng"){
                cthd_sl.setDisable(true);
                cthd_dongia.setDisable(true);

            }
            else{
                cthd_sl.setDisable(false);
                cthd_dongia.setDisable(false);

            }
        });
    }
    
    
    public void CTHDThem(ActionEvent event) { //khi them cthd mà loại phòng trọ thì tự cập nhật số lượng và đơn giá

//        String sql = "INSERT INTO CTHD (MAHD,LOAIHD,SL,DONGIA,THANHTIEN) "
//                + "VALUES(?,?,?,?,?)";

        connect = database.getConn();

        try {
            Alert alert;

            if (cthd_hdid.getText().isEmpty()
                    || cthd_loaihd.getSelectionModel().getSelectedItem() == null
                    || cthd_sl.getText().isEmpty()
                    || cthd_dongia.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                int dongia = Integer.parseInt(cthd_dongia.getText());
                int sl = Integer.parseInt(cthd_sl.getText());
                int thanhtien = dongia * sl;
                cthd_thanhtien.setText(String.valueOf(thanhtien));
                // CHECK IF THE FLOWER ID IS ALREADY EXIST
                String checkData = "SELECT LOAIHD FROM CTHD WHERE MAHD = '"
                        + cthd_hdid.getText() + "' AND LOAIHD = '" + (String) cthd_loaihd.getSelectionModel().getSelectedItem() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Loai hoa don: " + (String) cthd_loaihd.getSelectionModel().getSelectedItem() + " da ton tai!");
                    alert.showAndWait();
                } else {
                    String strCall = "{call THEM_CTHD(?,?,?,?)}";
                        caSt = connect.prepareCall(strCall);
                 
                        caSt.setString(1, cthd_hdid.getText());
  
                        caSt.setString(2,(String) cthd_loaihd.getSelectionModel().getSelectedItem());
    //                    
                        caSt.setString(3, cthd_sl.getText());
                        
                        caSt.setString(4, cthd_dongia.getText());
                        
                        caSt.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    //HoaDonShowListData();

                    // CLEAR ALL FIELDS
                    CTHDClear();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
     public void CTHDXoa(ActionEvent event) {

//        String sql = "DELETE FROM CTHD WHERE MAHD = '"
//                + cthd_hdid.getText() + "' and LOAIHD = '" + (String) cthd_loaihd.getSelectionModel().getSelectedItem() + "'";

        connect = database.getConn();

        try {
            Alert alert;

            if (cthd_hdid.getText().isEmpty()
                    || cthd_loaihd.getSelectionModel().getSelectedItem() == null
                    || cthd_sl.getText().isEmpty()
                    || cthd_dongia.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc muốn xóa chi tiết hóa đơn này?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
                    String strCall = "{call XOA_CTHD(?,?,?,?)}";
                        caSt = connect.prepareCall(strCall);
                 
                        caSt.setString(1, cthd_hdid.getText());
  
                        caSt.setString(2,(String) cthd_loaihd.getSelectionModel().getSelectedItem());
    //                    
                        caSt.setString(3, cthd_sl.getText());
                        
                        caSt.setString(4, cthd_dongia.getText());
                        
                        caSt.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    //HoaDonShowListData();

                    CTHDClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
     public void CTHDUpdate(ActionEvent event) {

//        String sql = "UPDATE CTHD SET SL = '"
//                + cthd_sl.getText() + "' AND DONGIA = '"
//                + cthd_dongia.getText()+ "'AND THANHTIEN = '"
//                + cthd_thanhtien.getText()+  "' WHERE MAHD = '" 
//                + cthd_hdid.getText() + "' AND  LOAIHD = '" 
//                + String.valueOf(cthd_loaihd.getSelectionModel().getSelectedItem()) + "'";
//
//        connect = database.getConn();

        try {
            Alert alert;

            if (cthd_hdid.getText().isEmpty()
                    || cthd_loaihd.getSelectionModel().getSelectedItem() == null
                    || cthd_sl.getText().isEmpty()
                    || cthd_dongia.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                int dongia = Integer.parseInt(cthd_dongia.getText());
                int sl = Integer.parseInt(cthd_sl.getText());
                int thanhtien = dongia * sl;
                cthd_thanhtien.setText(String.valueOf(thanhtien));
                
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc muốn cập nhật CTHD này?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
                    String strCall = "{call SUA_CTHD(?,?,?,?,?)}";
                        caSt = connect.prepareCall(strCall);
                 
                        caSt.setString(1, cthd_hdid.getText());
  
                        caSt.setString(2,(String) cthd_loaihd.getSelectionModel().getSelectedItem());
    //                    
                        caSt.setString(3, cthd_sl.getText());
                        
                        caSt.setString(4, cthd_dongia.getText());
                        caSt.setString(5, cthd_thanhtien.getText());
                        
                        caSt.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW

                    // CLEAR ALL FIELDS
                    CTHDClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
     
    public void CTHDClear() { //sua luon setdisable cua may texfield

        cthd_loaihd.getSelectionModel().clearSelection();
        cthd_thanhtien.setText("");
        cthd_sl.setText("");
        cthd_dongia.setText("");
        
        CTHDShowListData();
//        cthd_hdid.setText(HoaDonId);
//        cthd_kydong.setText(KyDong);
//        cthd_maphong.setText(MaPhong);
//        cthd_tenphong.setText(TenPhong);
//        cthd_tongtien.setText(TongTien);
        String sql = "SELECT TONGTIEN FROM HOADON WHERE MAHD = ?";
        connect = database.getConn();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, cthd_hdid.getText());
            result = prepare.executeQuery();

            if (result.next())cthd_tongtien.setText(result.getString(1));
        } catch (SQLException e){}
        
        cthd_thanhtien.setDisable(true);
        cthd_loaihd.setDisable(false);
        
        cthd_xoabtn.setDisable(true); 
        cthd_capnhatbtn.setDisable(true); 

    }
    
    public void CTHDSelect() {  //sau khi sửa bên textfiled thì không đc xóa
        CTHDData cthd = cthd_tableview.getSelectionModel().getSelectedItem();
        int num = cthd_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        cthd_hdid.setText(String.valueOf(cthd.getHoaDonIdProperty().getValue()));
        cthd_sl.setText(String.valueOf(cthd.getSoLuongProperty().getValue()));
        cthd_dongia.setText(String.valueOf(cthd.getDonGiaProperty().getValue()));
        cthd_thanhtien.setText(String.valueOf(cthd.getThanhTienProperty().getValue()));
        int index = cthd_loaihd.getItems().indexOf(String.valueOf(cthd.getLoaiHDProperty().getValue()));
        if (index != -1) {
            cthd_loaihd.getSelectionModel().select(index);
        }
        
        cthd_loaihd.setDisable(true);
        cthd_xoabtn.setDisable(false); 
        cthd_capnhatbtn.setDisable(false); 
        
        String cthdsl = String.valueOf(cthd.getSoLuongProperty().getValue());
        String cthddg = String.valueOf(cthd.getDonGiaProperty().getValue());
        
        cthd_sl.textProperty().addListener((observable, oldValue, newValue) -> {
            
            if (newValue.equals(cthdsl) 
                    && cthd_dongia.getText().equals(cthddg)){
                cthd_xoabtn.setDisable(false); 
            } else{
                cthd_xoabtn.setDisable(true);
            }
        });
        cthd_dongia.textProperty().addListener((observable, oldValue, newValue) -> {
            
            if (newValue.equals(cthddg) 
               && cthd_sl.getText().equals(cthdsl)){
                cthd_xoabtn.setDisable(false);
            } else{
                cthd_xoabtn.setDisable(true);
            }
        });

        
    }
    
    public ObservableList<CTHDData> CTHDListData() {

        ObservableList<CTHDData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM CTHD WHERE MAHD = '" + cthd_hdid.getText() + "'";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            CTHDData cthd;

            while (result.next()) { 
                cthd = new CTHDData(result.getString("MAHD"),
                         result.getString("LOAIHD"), result.getInt("SL"),
                         result.getInt("DONGIA"));

                listData.add(cthd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<CTHDData> CTHDList;

    public void CTHDShowListData() {
        CTHDList = CTHDListData();
        cthd_col_hdid.setCellValueFactory(cellData -> cellData.getValue().getHoaDonIdProperty());
        cthd_col_loaihd.setCellValueFactory(cellData -> cellData.getValue().getLoaiHDProperty());
        cthd_col_sl.setCellValueFactory(cellData -> cellData.getValue().getSoLuongProperty().asString());
        cthd_col_dongia.setCellValueFactory(cellData -> cellData.getValue().getDonGiaProperty().asString());
        cthd_col_thanhtien.setCellValueFactory(cellData -> cellData.getValue().getThanhTienProperty().asString());
        
        cthd_tableview.setItems(CTHDList);
    }
    
    public void CTHDLoaiHD() {
        ObservableList listData = FXCollections.observableArrayList("Phòng", "Điện", "Nước");
        cthd_loaihd.setItems(listData);        
    }
    
    public void XemCTHD(ActionEvent ev){
        

            hoadon_form.setVisible(false);
            conno_form.setVisible(false);
            cthd_form.setVisible(true);

            if (hoadon_trangthai.getSelectionModel().getSelectedItem() == "Đã thanh toán") {
                cthd_loaihd.setDisable(true);
                cthd_sl.setDisable(true);
                cthd_dongia.setDisable(true);
                cthd_thanhtien.setDisable(true);
                cthd_thembtn.setDisable(true);
                cthd_xoabtn.setDisable(true);
                cthd_capnhatbtn.setDisable(true);
            } else {
                cthd_sl.setDisable(false);
                cthd_dongia.setDisable(false);
                cthd_loaihd.setDisable(false);
                cthd_thembtn.setDisable(false);
                cthd_xoabtn.setDisable(false);
                cthd_capnhatbtn.setDisable(false);
            }
                
            
            cthd_kydong.setText(String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()) + "/" +String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
            cthd_maphong.setText((String) hoadon_maphong.getSelectionModel().getSelectedItem());
            cthd_tenphong.setText(hoadon_tenphong.getText());
            cthd_hdid.setText(hoadon_id.getText());
//            cthd_kydong.setText(KyDong);
//            cthd_maphong.setText(MaPhong);
//            cthd_tenphong.setText(TenPhong);
//            cthd_tongtien.setText(TongTien);

            cthd_tongtien.setText(hoadon_tongtien.getText());
            CTHDShowListData();
            DoiLoaiCTHD();

            cthd_thanhtien.setDisable(true);
            cthd_loaihd.setDisable(false);

            cthd_xoabtn.setDisable(true); 
            cthd_capnhatbtn.setDisable(true);

            CTHDLoaiHD();
            
        
    }
    public void XongConNo(ActionEvent ev){
        try {
            Alert alert;

            if (conno_conno.getText().isEmpty() ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Điền vào ô trống!");
                alert.showAndWait();

            } else {

                int flag = 0;
                try {
                    Integer.parseInt(conno_conno.getText());
                   flag++;     
                    
                } catch (NumberFormatException e) {
                    
                }
                if (flag==0){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tiền nợ phải là số nguyên.");
                    alert.showAndWait();
                    
                } else if (Integer.parseInt(hoadon_conno.getText()) < Integer.parseInt(conno_conno.getText())){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tiền nợ mới phải bé hơn hoặc bằng tiền nợ cũ.");
                    alert.showAndWait();
                    } else {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn có chắc muốn cập nhật hóa đơn này?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {
                        hd.SuaHoaDon(hoadon_id.getText(),(String) hoadon_maphong.getSelectionModel().getSelectedItem(),
                            Integer.valueOf(String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem())) ,
                            Integer.valueOf(String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem())),
                             Integer.valueOf(hoadon_tongtien.getText()),
                             "Chưa thanh toán" , Integer.valueOf(conno_conno.getText()));

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Updated!");
                        alert.showAndWait();

                        // SHOW UPDATED TABLEVIEW

                        // CLEAR ALL FIELDS
                        HoaDonClear();
                        conno_form.setVisible(false);
                        hoadon_form.setVisible(true);
                        cthd_form.setVisible(false);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
            
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        hoadon_form.setVisible(true);           
        cthd_form.setVisible(false);
        conno_form.setVisible(false);
        // TODO
        HoaDonShowListData();
            
            HoaDonPhong();
            HoaDonStatus();
            HoaDonThang();
            HoaDonNam();
            
            HoaDonSearch();
            
            DoiMaPhong();
            
            hoadon_xemchitietbtn.setDisable(true); 
            hoadon_thembtn.setDisable(false); 
            hoadon_xoabtn.setDisable(true); 
            hoadon_capnhatbtn.setDisable(true); 
//            hoadon_dathanhtoan.setDisable(true); 
//            hoadon_thanhtoan1phan.setDisable(true); 
            
            hoadon_id.setDisable(false);
            hoadon_tongtien.setDisable(true); 
            hoadon_tenphong.setDisable(true);
            hoadon_tongtien.setText(String.valueOf(0));
    }    
    
}
