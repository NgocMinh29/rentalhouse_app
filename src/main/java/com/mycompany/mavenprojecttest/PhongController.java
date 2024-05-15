/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import connection.database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PhongController implements Initializable {
    
    @FXML
    private Button phong_capnhatbtn;

    @FXML
    private TableColumn<PhongData, String> phong_col_dientich;

    @FXML
    private TableColumn<PhongData, String> phong_col_gia;

    @FXML
    private TableColumn<PhongData, String> phong_col_id;

    @FXML
    private TableColumn<PhongData, String> phong_col_loai;

    @FXML
    private TableColumn<PhongData, String> phong_col_songuoi;

    @FXML
    private TableColumn<PhongData, String> phong_col_ten;

    @FXML
    private TableColumn<PhongData, String> phong_col_trangthai;

    @FXML
    private TextField phong_dientich;

    @FXML
    private TextField phong_giathue;

    @FXML
    private TextField phong_id;

    @FXML
    private Button phong_lamloibtn;

    @FXML
    private ComboBox<?> phong_loaiphong;

    @FXML
    private TextField phong_search;

    @FXML
    private TextField phong_songuoi;

    @FXML
    private TableView<PhongData> phong_tableview;

    @FXML
    private TextField phong_ten;

    @FXML
    private Button phong_thembtn;

    @FXML
    private ComboBox<?> phong_trt;

    @FXML
    private Button phong_xoabtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();

    public void PhongThem(ActionEvent event) {

        String sql = "INSERT INTO PHONG (MAP,TENPG,LOAI,SONGUOI,DIENTICH,GIA,TRANGTHAI) "
                + "VALUES(?,?,?,?,?,?,?)";
//        String sql = "INSERT INTO PHONG (MAP,TENPG,SONGUOI,DIENTICH,GIA) "
//                + "VALUES(?,?,?,?,?)";
        
        connect = database.getConn();

        try {
            Alert alert;

            if (phong_id.getText().isEmpty()
                    || phong_ten.getText().isEmpty()
                    || phong_loaiphong.getSelectionModel().getSelectedItem() == null
                    || phong_trt.getSelectionModel().getSelectedItem() == null
                    || phong_giathue.getText().isEmpty()
                    //|| phong_songuoi.getText().isEmpty()
                    || phong_dientich.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                // CHECK IF THE FLOWER ID IS ALREADY EXIST
                String checkData = "SELECT MAP FROM PHONG WHERE MAP = '"
                        + phong_id.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Ma phong: " + phong_id.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, phong_id.getText());
                    prepare.setString(2, phong_ten.getText());
                    prepare.setString(3, (String) phong_loaiphong.getSelectionModel().getSelectedItem());
                    //prepare.setString(3, phong_songuoi.getText());
                    prepare.setString(3, "0");
                    prepare.setString(4, phong_dientich.getText());
                    prepare.setString(5, phong_giathue.getText());
                    //prepare.setString(7, (String) phong_trt.getSelectionModel().getSelectedItem());
                    prepare.setString(7, "Còn trống");
                  
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    PhongShowListData();

                    // CLEAR ALL FIELDS
                    PhongClear();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
     public void PhongXoa(ActionEvent event) {

        String sql = "DELETE PHONG WHERE MAP = '"
                + phong_id.getText() + "'";

        connect = database.getConn();

        try {
            Alert alert;

            if (phong_id.getText().isEmpty())  {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill phong_id fields");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE phong where maphong: " + phong_id.getText() + "?");
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
                    PhongShowListData();

                    // CLEAR ALL FIELDS
                    PhongClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void PhongClear() {

        phong_id.setText("");
        phong_ten.setText("");
        phong_loaiphong.getSelectionModel().clearSelection();
        phong_giathue.setText("");
        phong_trt.getSelectionModel().clearSelection();
        phong_songuoi.setText("");
        phong_dientich.setText("");
        PhongShowListData();
        

    }
    
    public void PhongStatus() {
        ObservableList listData = FXCollections.observableArrayList("Còn trống", "Đã cho thuê");
        phong_trt.setItems(listData);
        
    }
    
    public void PhongLoai() {
        ObservableList listData = FXCollections.observableArrayList("Sinh viên", "Gia đình");
        phong_loaiphong.setItems(listData);
        
    }
    
    
    public ObservableList<PhongData> PhongListData() {

        ObservableList<PhongData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM PHONG";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            PhongData phong;

            while (result.next()) { 
                phong = new PhongData(result.getString("MAP"),
                         result.getString("TENPG"), result.getString("LOAI"),
                         result.getInt("SONGUOI"), result.getInt("DIENTICH"),
                          result.getInt("GIA"),result.getString("TRANGTHAI"));

                listData.add(phong);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<PhongData> PhongList;

    public void PhongShowListData() {
        
        PhongList = PhongListData();
        try{    
        phong_col_id.setCellValueFactory(cellData -> cellData.getValue().getPhongidProperty());
        phong_col_ten.setCellValueFactory(cellData -> cellData.getValue().getTenphongProperty());
        phong_col_loai.setCellValueFactory(cellData -> cellData.getValue().getLoaiProperty());
        phong_col_songuoi.setCellValueFactory(cellData -> cellData.getValue().getSongdgoProperty().asString());
        phong_col_dientich.setCellValueFactory(cellData -> cellData.getValue().getDientichProperty().asString());
        phong_col_gia.setCellValueFactory(cellData -> cellData.getValue().getGiaProperty().asString());
        phong_col_trangthai.setCellValueFactory(cellData -> cellData.getValue().getTrangthaiProperty());

        phong_tableview.setItems(PhongList);
        } catch (NullPointerException e) {
            // Xử lý lỗi tại đây
            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
            // Thực hiện các hành động xử lý thích hợp (ví dụ: ghi log, hiển thị thông báo cho người dùng)
          }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PhongShowListData();
            PhongStatus();
            PhongLoai();
        // TODO
    }    
    
}
