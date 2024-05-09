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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ThongKeController implements Initializable {
    
    @FXML
    private Label thongke_dichvucho;
    
    @FXML
    private ComboBox<?> thongke_hdthang;

    @FXML
    private ComboBox<?> thongke_hdnam;
    
    @FXML
    private BarChart<String, Integer> thongke_hoadonchart;
    
    @FXML
    private CategoryAxis xthongke_hoadonchart;

    @FXML
    private NumberAxis ythongke_hoadonchart;

    @FXML
    private Label thongke_hoadonno;

    @FXML
    private BarChart<?, ?> thongke_hopdongchart;

    @FXML
    private Label thongke_hopdonghethan;

    @FXML
    private Label thongke_phongthue;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    public void ThongKeHoaDonThang() {
        ObservableList listData = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
        thongke_hdthang.setItems(listData);
    }   
    //int HoaDonNam[] = {2023,2024};
    public void ThongKeHoaDonNam() {
        List<Integer> listS = new ArrayList<>();
        for (int year = currentYear; year >= 0; year--) {
            listS.add(year);
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        thongke_hdnam.setItems(listData);
    }
    
    public void homeChart(){
        
        
        //String sql;
        try{
        thongke_hdthang.valueProperty().addListener((observable, oldValue, newValue) -> {
            thongke_hoadonchart.getData().clear();
            String sql = "SELECT MAPHONG, TONGTIEN FROM HOADON WHERE THANG = ? AND NAM = ?";
        
            connect = database.getConn();

            try{
                //XYChart.Series chart = new XYChart.Series();
                XYChart.Series<String, Integer> chart = new XYChart.Series<>();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, String.valueOf(thongke_hdthang.getSelectionModel().getSelectedItem()));  // Month = 2
                prepare.setString(2, String.valueOf(thongke_hdnam.getSelectionModel().getSelectedItem()));
                result = prepare.executeQuery();

                while(result.next()){
                    chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
                    //chart.getData().add(new XYChart.Data<>("PG02",50));
                }

                thongke_hoadonchart.getData().addAll(chart);

            }catch(Exception e){e.printStackTrace();}
            
        });
        } catch (NullPointerException e) {
            // Xử lý lỗi tại đây
            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
            // Thực hiện các hành động xử lý thích hợp (ví dụ: ghi log, hiển thị thông báo cho người dùng)
          }

          try{
        
        thongke_hdnam.valueProperty().addListener((observable, oldValue, newValue) -> {
            thongke_hoadonchart.getData().clear();
            String sql = "SELECT MAPHONG, TONGTIEN FROM HOADON WHERE THANG = ? AND NAM = ?";
        
            connect = database.getConn();

            try{
                //XYChart.Series chart = new XYChart.Series();
                XYChart.Series<String, Integer> chart = new XYChart.Series<>();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, String.valueOf(thongke_hdthang.getSelectionModel().getSelectedItem()));  // Month = 2
                prepare.setString(2, String.valueOf(thongke_hdnam.getSelectionModel().getSelectedItem()));
                result = prepare.executeQuery();

                while(result.next()){
                    chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
                    //chart.getData().add(new XYChart.Data<>("PG02",50));
                }

                thongke_hoadonchart.getData().addAll(chart);

            }catch(Exception e){e.printStackTrace();}
            
        });
        
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
        ThongKeHoaDonThang() ;
            ThongKeHoaDonNam() ;
            int index = thongke_hdthang.getItems().indexOf(currentMonth);
            if (index != -1) {
                thongke_hdthang.getSelectionModel().select(index);
            }
            int index2 = thongke_hdnam.getItems().indexOf(currentYear);
            if (index2 != -1) {
                thongke_hdnam.getSelectionModel().select(index2);
            }
            homeChart();
        // TODO
    }    
    
}
