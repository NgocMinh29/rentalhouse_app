/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenprojecttest;

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
    private TableColumn<DichVuData, String> dichvu_col_id;

    @FXML
    private TableColumn<DichVuData, String> dichvu_col_ten;

    @FXML
    private TextField dichvu_id;

    @FXML
    private Button dichvu_lammoibtn;

    @FXML
    private TextField dichvu_search;

    @FXML
    private TableView<DichVuData> dichvu_tableview;

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
    private CallableStatement caSt;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();

     public void ThemDichVu(ActionEvent event) { 
        try {
            Alert alert;
            if (dichvu_ten.getText() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter name of service!");
                alert.showAndWait();
            } 
            else {

                connect = database.getConn();
                
//                String checkQuery = "SELECT * FROM DICHVU WHERE TENDICHVU = ?";
//                prepare = connect.prepareStatement(checkQuery);
//                prepare.setString(1, dichvu_ten.getText());
//                result = prepare.executeQuery();

                String strCall = "{call Them_Dichvu(?)}";
                caSt = connect.prepareCall(strCall);
                caSt.setString(1, String.valueOf(dichvu_ten.getSelectedText()));
                caSt.execute(); 
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success Message");
                alert.setHeaderText(null);
                alert.setContentText("Service added successfully!");
                alert.showAndWait();
                
                DichVuShowListData();
                DichVuClear();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the service. Please try again.");
            alert.showAndWait();
        }
    }
     
     public void DichVuSearch() {
        
        FilteredList<DichVuData> filter = new FilteredList<>(DichVuList, e -> true);

        dichvu_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate((DichVuData PrediateDichVuData) -> {

                if (newValue.isEmpty() /*|| newValue == null*/) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (String.valueOf(PrediateDichVuData.getDichVuIdProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateDichVuData.getDichVuTenProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });

        SortedList<DichVuData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(dichvu_tableview.comparatorProperty());

        dichvu_tableview.setItems(sortList);
        });
    }
     
     public void DichVuSelect() {  //sau khi sửa bên textfiled thì không đc xóa
        DichVuData khang = dichvu_tableview.getSelectionModel().getSelectedItem();
        int num = dichvu_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        dichvu_id.setText(String.valueOf(khang.getDichVuIdProperty().getValue()));
        dichvu_ten.setText(String.valueOf(khang.getDichVuTenProperty().getValue()));
        
        
        dichvu_capnhatbtn.setDisable(false); 
        dichvu_xoabtn.setDisable(false); 
       
   }
     
     
    public void CapNhatDichVu(ActionEvent event) {
        try {
            Alert alert;
            if (dichvu_ten.getText() == null || dichvu_id.getText() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields!");
                alert.showAndWait();
            } 
            else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Make sure that you want to UPDATE DICHVU ID: " + dichvu_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if (option.get().equals(ButtonType.OK)) {
                    String strCall = "{call Sua_Dichvu(?,?)}";
                    CallableStatement caSt = connect.prepareCall(strCall);
                    caSt.setString(1, String.valueOf(dichvu_id.getSelectedText()));
                    caSt.setString(2, String.valueOf(dichvu_ten.getSelectedText()));
                    caSt.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                       
//                    String sql = "SELECT MADV FROM DICHVU WHERE TENDICHVU = ?";
//                    prepare = connect.prepareStatement(sql);
//                    prepare.setString(1, String.valueOf(dichvu_ten.getSelectedText()));
//                    
//                    result = prepare.executeQuery();
                    
                    DichVuListData();
                    DichVuClear();
                }
            }
        } 
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while updating the service. Please try again.");
            alert.showAndWait();
        }
    }
    
    public void XoaDichVu(ActionEvent event) {
        try {
            Alert alert;

            if (dichvu_id.getText() == null || dichvu_id.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter the service ID to delete!");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE service with ID: " + dichvu_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                    //connect = database.getConn();

//                    String sql = "DELETE FROM DICHVU WHERE MADV = ?";
//                    prepare = connect.prepareStatement(sql);
//                    prepare.setString(1, dichvu_id.getText());
//                    int result = prepare.executeUpdate();
                    String strCall = "{call XOA_DICHVU(?)}";
                    caSt = connect.prepareCall(strCall);
                    caSt.setString(1, String.valueOf(dichvu_id.getSelectedText()));
                    caSt.execute();

                    
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Service deleted successfully!");
                        alert.showAndWait();
                        
                        DichVuShowListData();
                        DichVuClear();
                    
                }
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while deleting the service. Please try again.");
            alert.showAndWait();
        }
    }
    
//    public void LamMoiDichVu(ActionEvent event) {
//        dichvu_id.clear();
//        dichvu_ten.clear();
//        dichvu_search.clear();
//    
//        dichvu_tableview.getSelectionModel().clearSelection();
//    }


    public ObservableList<DichVuData> DichVuListData() {
        ObservableList<DichVuData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM DICHVU";

        try {
            connect = database.getConn();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            DichVuData dichvu;

            while (result.next()) { 
                dichvu = new DichVuData(result.getString("MADV"),result.getString("TENDICHVU"));
                listData.add(dichvu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<DichVuData> DichVuList;
    
    public void DichVuShowListData() {
        DichVuList = DichVuListData();
        // Lấy danh sách dịch vụ từ cơ sở dữ liệu
        try { 
            dichvu_col_id.setCellValueFactory(cellData -> cellData.getValue().getDichVuIdProperty());
            dichvu_col_ten.setCellValueFactory(cellData -> cellData.getValue().getDichVuTenProperty());

            dichvu_tableview.setItems(DichVuList);
        } catch (NullPointerException e) {
            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
        }
    }

    // Xóa các trường nhập liệu
    public void DichVuClear() {
        dichvu_id.clear();
        dichvu_ten.clear();
        dichvu_search.clear();
        dichvu_capnhatbtn.setDisable(true); 
        dichvu_xoabtn.setDisable(true); 
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         DichVuShowListData(); 
         dichvu_capnhatbtn.setDisable(true); 
         dichvu_xoabtn.setDisable(true);
         DichVuSearch() ;
         
        // TODO
    }    
    
}
