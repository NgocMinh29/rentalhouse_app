/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class PhieudichvuController implements Initializable {
    
    @FXML                                                                       //phieudv
    private Button phieu_capnhatbtn;

    @FXML
    private TextField phieu_maphong;

    @FXML
    private TableColumn<?, ?> phieu_col_maphong;

    @FXML
    private TableColumn<?, ?> phieu_col_id;

    @FXML
    private TableColumn<?, ?> phieu_col_ngdien;

    @FXML
    private TableColumn<?, ?> phieu_col_sl;

    @FXML
    private AnchorPane phieu_form;

    @FXML
    private TextField phieu_id;

    @FXML
    private Button phieu_lammoibtn;

    @FXML
    private DatePicker phieu_ngdien;

    @FXML
    private TextField phieu_search;

    @FXML
    private TableView<?> phieu_tableview;

    @FXML
    private TextField phieu_sl;

    @FXML
    private Button phieu_xoabtn;
    
    @FXML
    private Button phieu_xemctpbtn;
    
    @FXML
    private Button ctpdv_capnhatbtn;

    @FXML
    private TableColumn<?, ?> ctpdv_col_madv;

    @FXML
    private TableColumn<?, ?> ctpdv_col_tendv;

    @FXML
    private TableColumn<?, ?> ctpdv_col_tinhtrang;

    @FXML
    private AnchorPane ctpdv_form;

    @FXML
    private Button ctpdv_lammoibtn;

    @FXML
    private TextField ctpdv_madv;

    @FXML
    private Label ctpdv_map;

    @FXML
    private Label ctpdv_mapg;

    @FXML
    private Label ctpdv_ngdien;

    @FXML
    private Button ctpdv_quaylaibtn;

    @FXML
    private Label ctpdv_sl;

    @FXML
    private TableView<?> ctpdv_tableview;

    @FXML
    private TextField ctpdv_tendv;

    @FXML
    private Button ctpdv_thembtn;

    @FXML
    private ComboBox<?> ctpdv_tinhtrang;

    @FXML
    private Button ctpdv_xoabtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    public void XemCTHD(ActionEvent ev){
        
            phieu_form.setVisible(false);

            ctpdv_form.setVisible(true);
            
            
//            CTHDShowListData();
//            
//            cthd_hdid.setText(HoaDonId);
//            cthd_kydong.setText(KyDong);
//            cthd_maphong.setText(MaPhong);
//            cthd_tenphong.setText(TenPhong);
//            cthd_tongtien.setText(TongTien);
//            
//            cthd_thanhtien.setDisable(true);
//            cthd_loaihd.setDisable(false);
//            
//            cthd_xoabtn.setDisable(true); 
//            cthd_capnhatbtn.setDisable(true);
//            
//            CTHDLoaiHD();
        
    }
    
    public void QuayLai(ActionEvent ev){
        
            phieu_form.setVisible(true);

            ctpdv_form.setVisible(false);
            
            
//            CTHDShowListData();
//            
//            cthd_hdid.setText(HoaDonId);
//            cthd_kydong.setText(KyDong);
//            cthd_maphong.setText(MaPhong);
//            cthd_tenphong.setText(TenPhong);
//            cthd_tongtien.setText(TongTien);
//            
//            cthd_thanhtien.setDisable(true);
//            cthd_loaihd.setDisable(false);
//            
//            cthd_xoabtn.setDisable(true); 
//            cthd_capnhatbtn.setDisable(true);
//            
//            CTHDLoaiHD();
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
