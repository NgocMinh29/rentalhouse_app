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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DichvuController implements Initializable {
    
    @FXML
    private Button dichvu_capnhatbtn;

    @FXML
    private TableColumn<?, ?> dichvu_col_id;

    @FXML
    private TableColumn<?, ?> dichvu_col_ten;

    @FXML
    private TextField dichvu_id;

    @FXML
    private Button dichvu_lammoibtn;

    @FXML
    private TextField dichvu_search;

    @FXML
    private TableView<?> dichvu_tableview;

    @FXML
    private TextField dichvu_ten;

    @FXML
    private Button dichvu_thembtn;

    @FXML
    private Button dichvu_xoabtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
