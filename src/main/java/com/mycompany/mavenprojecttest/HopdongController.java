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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class HopdongController implements Initializable {
    
    @FXML
    private Button hopdong_capnhatbtn;

    @FXML
    private TableColumn<?, ?> hopdong_col_giathue;

    @FXML
    private TableColumn<?, ?> hopdong_col_id;

    @FXML
    private TableColumn<?, ?> hopdong_col_makt;

    @FXML
    private TableColumn<?, ?> hopdong_col_maphong;

    @FXML
    private TableColumn<?, ?> hopdong_col_ngbd;

    @FXML
    private TableColumn<?, ?> hopdong_col_ngtraphong;

    @FXML
    private TableColumn<?, ?> hopdong_col_tiencoc;

    @FXML
    private TableColumn<?, ?> hopdong_col_tinhtrang;

    @FXML
    private AnchorPane hopdong_form;

    @FXML
    private TextField hopdong_giathue;

    @FXML
    private TextField hopdong_id;

    @FXML
    private Button hopdong_lammoibtn;
    
    @FXML
    private Button hopdong_xemcthdbtn;

    @FXML
    private TextField hopdong_makt;

    @FXML
    private TextField hopdong_maphong;

    @FXML
    private TextField hopdong_ngbd;

    @FXML
    private TextField hopdong_ngtraphong;

    @FXML
    private TextField hopdong_search;

    @FXML
    private TableView<?> hopdong_tableview;

    @FXML
    private Button hopdong_thembtn;

    @FXML
    private TextField hopdong_tiencoc;

    @FXML
    private ComboBox<?> hopdong_trangthai;

    @FXML
    private Button hopdong_xoabtn;
    
     @FXML
    private Button cthdg_capnhatbtn;

    @FXML
    private TextField cthdg_cccdkt;

    @FXML
    private AnchorPane cthdg_form;

    @FXML
    private Label cthdg_hdgid;

    @FXML
    private Button cthdg_lammoibtn;

    @FXML
    private TextField cthdg_makt;

    @FXML
    private Label cthdg_mapg;

    @FXML
    private TextField cthdg_sdtkt;

    @FXML
    private TableView<?> cthdg_tableview;
    
        @FXML
    private TableColumn<?, ?> cthdg_col_cccdkt;

    @FXML
    private TableColumn<?, ?> cthdg_col_makt;

    @FXML
    private TableColumn<?, ?> cthdg_col_sdtkt;

    @FXML
    private TableColumn<?, ?> cthdg_col_tenkt;

    @FXML
    private TextField cthdg_tenkt;

    @FXML
    private Button cthdg_thembtn;

    @FXML
    private Button cthdg_xoabtn;

    @FXML
    private Button ctpdv_capnhatbtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    public void HopDongStatus() {
        ObservableList listData = FXCollections.observableArrayList("Het han", "Con han");
        hopdong_trangthai.setItems(listData);        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HopDongStatus();
        // TODO
    }    
    
}
