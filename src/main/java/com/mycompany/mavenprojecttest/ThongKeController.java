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
    private Label thongke_songuoidnago;

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
    
    java.sql.Date sqltoday = java.sql.Date.valueOf(today);
    
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
            String sql = "SELECT MAP, TONGTIEN FROM HOADON WHERE THANG = ? AND NAM = ?";
        
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
            String sql = "SELECT MAP, TONGTIEN FROM HOADON WHERE THANG = ? AND NAM = ?";
        
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
    
    public void ThongKePhongDangChoThue(){
        
        String sql = "SELECT COUNT(*) FROM PHONG WHERE TRANGTHAI = 'Đã cho thuê'";
        
        connect = database.getConn();
        
        try{
            int countTI = 0;
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next()){
                countTI = result.getInt("COUNT(*)");
            }
            
            thongke_phongthue.setText(String.valueOf(countTI));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void ThongKeHoaDonConNo(){
        
        String sql = "SELECT COUNT(*) FROM HOADON WHERE TRANGTHAI = 'Chưa thanh toán'";
        
        connect = database.getConn();
        
        try{
            int countTI = 0;
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next()){
                countTI = result.getInt("COUNT(*)");
            }
            
            thongke_hoadonno.setText(String.valueOf(countTI));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void ThongKeSoNgDangO(){
        
        String sql = "SELECT COUNT(*) FROM KHACHTHUE WHERE NGAYKETTHUC > ?";
        String sql1 = "SELECT COUNT(*) FROM KHACHNGANHAN WHERE NGAYKETTHUC > ? AND TRANGTHAI = 'Đã duyệt'";
        
        connect = database.getConn();
        
        try{
            int countTI = 0;
            
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, sqltoday);
            result = prepare.executeQuery();
//            prepare = connect.prepareStatement(sql);
//            java.sql.Date Today = java.sql.Date.valueOf(today);
//            prepare.setDate(1, Today);
//            result = prepare.executeQuery();
            
            if(result.next()){
                countTI = result.getInt(1);
            }
            prepare = connect.prepareStatement(sql1);
            prepare.setDate(1, sqltoday);
            result = prepare.executeQuery();
            if(result.next()){
                countTI += result.getInt(1);
            }
            thongke_songuoidnago.setText(String.valueOf(countTI));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void ThongKePhieuChoXuLy(){
        
        String sql = "SELECT COUNT(DISTINCT PHIEUDICHVU.MPDV) FROM PHIEUDICHVU, CTPDV WHERE PHIEUDICHVU.MPDV = CTPDV.MPDV AND TINHTRANG = 'Chưa hoàn thành'";
        
        
        connect = database.getConn();
        
        try{
            int countTI = 0;
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next()){
                countTI = result.getInt(1);
            }
//            prepare = connect.prepareStatement(sql1);
//            prepare.setDate(1, sqltoday);
//            result = prepare.executeQuery();
//            if(result.next()){
//                countTI += result.getInt("COUNT(*)");
//            }
            thongke_dichvucho.setText(String.valueOf(countTI));
            
        }catch(Exception e){e.printStackTrace();}
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ThongKeHoaDonThang() ;
        //thongke_songuoidnago.setText("0");
        ThongKeSoNgDangO();
        ThongKeHoaDonConNo();
        ThongKePhieuChoXuLy();
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
            ThongKePhongDangChoThue();
        // TODO
    }    
    
}
