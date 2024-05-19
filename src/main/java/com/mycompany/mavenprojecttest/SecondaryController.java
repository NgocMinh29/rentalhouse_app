package com.mycompany.mavenprojecttest;

//import com.google.i18n.phonenumbers.PhoneNumberUtil;
//import com.google.i18n.phonenumbers.PhoneNumber;
import connection.database;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PrinterJob;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;

public class SecondaryController implements Initializable{
    
    @FXML
    private Button caidat_btn;

    @FXML
    private Button caidat_doimkbtn;

    @FXML
    private AnchorPane caidat_form;

    @FXML
    private PasswordField caidat_mkcu;

    @FXML
    private PasswordField caidat_mkmoi;

    @FXML
    private PasswordField caidat_xacnhan;

    
    //public ThongKeController tk;

    @FXML
    private AnchorPane main_form;
    
    @FXML
    private Button close;
    
    @FXML
    private Button minimize;

                                                                                //HOADON
    @FXML
    private Button hoadon_btn;

//    @FXML
//    private Button hoadon_capnhatbtn;
//
//    @FXML
//    private TableColumn<HoaDonData, String> hoadon_col_conno;
//
//    @FXML
//    private TableColumn<HoaDonData, String> hoadon_col_id;
//
//    @FXML
//    private TableColumn<HoaDonData, String> hoadon_col_kydong;
//
//    @FXML
//    private TableColumn<HoaDonData, String> hoadon_col_maphong;
//
//    @FXML
//    private TableColumn<HoaDonData, String> hoadon_col_tongtien;
//
//    @FXML
//    private TableColumn<HoaDonData, String> hoadon_col_trangthai;
//
//    @FXML
//    private TextField hoadon_conno;

    @FXML
    private AnchorPane hoadon_form;

    //CTHD FORM
//    @FXML
//    private AnchorPane cthd_form;
    
                                                                                //HOADON
//    @FXML
//    private TextField hoadon_tenphong;
//    
//    @FXML
//    private TextField hoadon_id;
//
//    @FXML
//    private TextField hoadon_kydong;
//
//    @FXML
//    private Button hoadon_lammoibtn;

//    @FXML
//    private TextField hoadon_maphong;
    
//    @FXML
//    private ComboBox<?> hoadon_maphong;
//
//    @FXML
//    private TextField hoadon_search;
//
//    @FXML
//    private TableView<HoaDonData> hoadon_tableview;
//
//    @FXML
//    private Button hoadon_thembtn;
//
//    @FXML
//    private TextField hoadon_tongtien;
//
//    @FXML
//    private ComboBox<?> hoadon_trangthai;
//    
//    @FXML
//    private ComboBox<?> hoadon_thang;
//    
//    @FXML
//    private ComboBox<?> hoadon_nam;
//
//    @FXML
//    private Button hoadon_xemchitietbtn;
//
//    @FXML
//    private Button hoadon_xoabtn;

    @FXML
    private Button hopdong_btn;

//    @FXML
//    private Button hopdong_capnhatbtn;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_giathue;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_id;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_makt;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_maphong;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_ngbd;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_ngtraphong;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_tiencoc;
//
//    @FXML
//    private TableColumn<?, ?> hopdong_col_tinhtrang;
//
    @FXML
    private AnchorPane hopdong_form;
//
//    @FXML
//    private TextField hopdong_giathue;
//
//    @FXML
//    private TextField hopdong_id;
//
//    @FXML
//    private Button hopdong_lammoibtn;
//    
//    @FXML
//    private Button hopdong_xemcthdbtn;
//
//    @FXML
//    private TextField hopdong_makt;
//
//    @FXML
//    private TextField hopdong_maphong;
//
//    @FXML
//    private TextField hopdong_ngbd;
//
//    @FXML
//    private TextField hopdong_ngtraphong;
//
//    @FXML
//    private TextField hopdong_search;
//
//    @FXML
//    private TableView<?> hopdong_tableview;
//
//    @FXML
//    private Button hopdong_thembtn;
//
//    @FXML
//    private TextField hopdong_tiencoc;
//
//    @FXML
//    private ComboBox<?> hopdong_trangthai;
//
//    @FXML
//    private Button hopdong_xoabtn;

                                                                                // KHACH THUE
    @FXML
    private Button khach_btn;

//    @FXML
//    private Button khach_capnhatbtn;
//
//    @FXML
//    private TextField khach_cccd;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_cccd;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_ngdaidien;
//    
//    @FXML
//    private TableColumn<KhachData, String> khach_col_ngbd;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_ngkt;
//
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_gioitinh;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_id;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_mail;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_ngs;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_sdt;
//
//    @FXML
//    private TableColumn<KhachData, String> khach_col_ten;
//
//    @FXML
//    private TextField khach_mangdaidien;
//    @FXML
//    private TextField khach_tenngdaidien;

    @FXML
    private AnchorPane khach_form;
//
//    @FXML
//    private ComboBox<?> khach_gioitinh;
//
//    @FXML
//    private TextField khach_id;
//
//    @FXML
//    private Button khach_lammoibtn;
//
//    @FXML
//    private TextField khach_mail;
//
//    @FXML
//    private DatePicker khach_ngs;
//    
//    @FXML
//    private DatePicker khach_ngbd;
//    
//    @FXML
//    private DatePicker khach_ngkt;
//
//    @FXML
//    private TextField khach_sdt;
//
//    @FXML
//    private TextField khach_search;
//
//    @FXML
//    private TableView<KhachData> khach_tableview;
//
//    @FXML
//    private TextField khach_ten;
//
//    @FXML
//    private Button khach_thembtn;
//
//    @FXML
//    private Button khach_xoabtn;

                                                                                //LOGOUT
    @FXML
    private Button logout;

                                                                                //PHIEU DICH VU
    @FXML
    private Button phieu_btn;

//    @FXML
//    private Button phieu_capnhatbtn;
//
//    @FXML
//    private TextField phieu_maphong;
//
//    @FXML
//    private TableColumn<?, ?> phieu_col_maphong;
//
//    @FXML
//    private TableColumn<?, ?> phieu_col_id;
//
//    @FXML
//    private TableColumn<?, ?> phieu_col_ngdien;
//
//    @FXML
//    private TableColumn<?, ?> phieu_col_sl;

    @FXML
    private AnchorPane phieu_form;

//    @FXML
//    private TextField phieu_id;
//
//    @FXML
//    private Button phieu_lammoibtn;
//
//    @FXML
//    private DatePicker phieu_ngdien;
//
//    @FXML
//    private TextField phieu_search;
//
//    @FXML
//    private TableView<?> phieu_tableview;
//
//    @FXML
//    private TextField phieu_sl;
//
//    @FXML
//    private Button phieu_xoabtn;
//
//    @FXML
//    private Button phieu_xemctpbtn;

                                                                                //PHONG
    @FXML
    private Button phong_btn;
//
//    @FXML
//    private Button phong_capnhatbtn;
//
//    @FXML
//    private TableColumn<PhongData, String> phong_col_dientich;
//
//    @FXML
//    private TableColumn<PhongData, String> phong_col_gia;
//
//    @FXML
//    private TableColumn<PhongData, String> phong_col_id;
//
//    @FXML
//    private TableColumn<PhongData, String> phong_col_loai;
//
//    @FXML
//    private TableColumn<PhongData, String> phong_col_songuoi;
//
//    @FXML
//    private TableColumn<PhongData, String> phong_col_ten;
//
//    @FXML
//    private TableColumn<PhongData, String> phong_col_trangthai;
//
//    @FXML
//    private TextField phong_dientich;
//
    @FXML
    private AnchorPane phong_form;
//
//    @FXML
//    private TextField phong_giathue;
//
//    @FXML
//    private TextField phong_id;
//
//    @FXML
//    private Button phong_lamloibtn;
//
//    @FXML
//    private ComboBox<?> phong_loaiphong;
//
//    @FXML
//    private TextField phong_search;
//
//    @FXML
//    private TextField phong_songuoi;
//
//    @FXML
//    private TableView<PhongData> phong_tableview;
//
//    @FXML
//    private TextField phong_ten;
//
//    @FXML
//    private Button phong_thembtn;
//
//    @FXML
//    private ComboBox<?> phong_trt;
//
//    @FXML
//    private Button phong_xoabtn;

   // @FXML
//    private Button taikhoan_btn;
                                                                                //CHI TIET HOA DON
    
//    @FXML
//    private TableView<CTHDData> cthd_tableview;
//    
//    @FXML
//    private Label cthd_hdid;
//
//    @FXML
//    private Button cthd_capnhatbtn;
//
//    @FXML
//    private TableColumn<CTHDData, String> cthd_col_dongia;
//
//    @FXML
//    private TableColumn<CTHDData, String> cthd_col_hdid;
//
//    @FXML
//    private TableColumn<CTHDData, String> cthd_col_sl;
//    
//    @FXML
//    private TableColumn<CTHDData, String> cthd_col_loaihd;
//
//    @FXML
//    private TableColumn<CTHDData, String> cthd_col_thanhtien;
//
//    @FXML
//    private TextField cthd_dongia;
//
//    @FXML
//    private Label cthd_tenphong;
//     
//    @FXML
//    private Label cthd_tongtien;
//    
//    @FXML
//    private Label cthd_kydong;
//    
//    @FXML
//    private Label cthd_maphong;
//
//    @FXML
//    private Button cthd_lammoibtn;
//
//    @FXML
//    private ComboBox<?> cthd_loaihd;
//
//    @FXML
//    private TextField cthd_sl;
//
//    @FXML
//    private TextField cthd_thanhtien;
//
//    @FXML
//    private Button cthd_thembtn;
//
//    @FXML
//    private Button cthd_xoabtn;
//
//    @FXML
//    private Button cthd_quaylai;

                                                                                //THỐNG KÊ
    @FXML
    private Button thongke_btn;

//    @FXML
//    private Label thongke_dichvucho;
//
    @FXML
    private AnchorPane thongke_form; 
//    
//    @FXML
//    private ComboBox<?> thongke_hdthang;
//
//    @FXML
//    private ComboBox<?> thongke_hdnam;
//    
//    @FXML
//    private BarChart<String, Integer> thongke_hoadonchart;
//    
//    @FXML
//    private CategoryAxis xthongke_hoadonchart;
//
//    @FXML
//    private NumberAxis ythongke_hoadonchart;
//
//    @FXML
//    private Label thongke_hoadonno;
//
//    @FXML
//    private BarChart<?, ?> thongke_hopdongchart;
//
//    @FXML
//    private Label thongke_hopdonghethan;
//
//    @FXML
//    private Label thongke_phongthue;
    
                                                                                //CHI TIẾT HỢP ĐỒNG
//     @FXML
//    private Button cthdg_capnhatbtn;
//
//    @FXML
//    private TextField cthdg_cccdkt;
//
//    @FXML
//    private AnchorPane cthdg_form;
//
//    @FXML
//    private Label cthdg_hdgid;
//
//    @FXML
//    private Button cthdg_lammoibtn;
//
//    @FXML
//    private TextField cthdg_makt;
//
//    @FXML
//    private Label cthdg_mapg;
//
//    @FXML
//    private TextField cthdg_sdtkt;
//
//    @FXML
//    private TableView<?> cthdg_tableview;
//    
//        @FXML
//    private TableColumn<?, ?> cthdg_col_cccdkt;
//
//    @FXML
//    private TableColumn<?, ?> cthdg_col_makt;
//
//    @FXML
//    private TableColumn<?, ?> cthdg_col_sdtkt;
//
//    @FXML
//    private TableColumn<?, ?> cthdg_col_tenkt;
//
//    @FXML
//    private TextField cthdg_tenkt;
//
//    @FXML
//    private Button cthdg_thembtn;
//
//    @FXML
//    private Button cthdg_xoabtn;
//
//    @FXML
//    private Button ctpdv_capnhatbtn;

                                                                                //CHI TIET PHIEU DICH VU
//    @FXML
//    private TableColumn<?, ?> ctpdv_col_madv;
//
//    @FXML
//    private TableColumn<?, ?> ctpdv_col_map;
//
//    @FXML
//    private TableColumn<?, ?> ctpdv_col_tendv;
//
//    @FXML
//    private AnchorPane ctpdv_form;
//
//    @FXML
//    private Button ctpdv_lammoibtn;
//
//    @FXML
//    private TextField ctpdv_madv;
//
//    @FXML
//    private TextField ctpdv_map;
//
//    @FXML
//    private TextField ctpdv_search;
//
//    @FXML
//    private TableView<?> ctpdv_tableview;
//
//    @FXML
//    private TextField ctpdv_tendv;
//
//    @FXML
//    private Button ctpdv_thembtn;
//
//    @FXML
//    private Button ctpdv_xoabtn;
    
                                                                                //KHACH NGAN HAN
     @FXML
    private Button khachngan_btn;

//    @FXML
//    private Button khachngan_capnhatbtn;
//
//    @FXML
//    private TextField khachngan_cccd;
//
//    @FXML
//    private Button khachngan_duyetbtn;
//
    @FXML
    private AnchorPane khachngan_form;
//
//    @FXML
//    private ComboBox<?> khachngan_gioitinh;
//    
//    @FXML
//    private ComboBox<?> khachngan_searchtt;
//
//    @FXML
//    private TextField khachngan_id;
//
//    @FXML
//    private Button khachngan_lammoibtn;
//
//    @FXML
//    private TextField khachngan_mail;
//
//    @FXML
//    private DatePicker khachngan_ngbd;
//
//    @FXML
//    private TextField khachngan_mangdaidien;
//    
//    @FXML
//    private TextField khachngan_tenngdaidien;
//
//    @FXML
//    private DatePicker khachngan_ngkt;
//
//    @FXML
//    private DatePicker khachngan_ngs;
//
//    @FXML
//    private TextField khachngan_sdt;
//
//    @FXML
//    private TextField khachngan_search;
//
//    @FXML
//    private TableView<KhachData> khachngan_tableview;
//    
//     @FXML
//    private TableColumn<KhachData, String> khachngan_col_cccd;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_mail;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_gioitinh;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_id;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_ngbd;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_ngdaidien;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_ngkt;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_ngs;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_sdt;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_ten;
//
//    @FXML
//    private TableColumn<KhachData, String> khachngan_col_trangthai;
//
//    @FXML
//    private TextField khachngan_ten;
//
//    @FXML
//    private ComboBox<?> khachngan_trangthai;
//
//    @FXML
//    private Button khachngan_xoabtn;
    
                                                                                //DICHVU
     @FXML
    private Button dichvu_btn;

//    @FXML
//    private Button dichvu_capnhatbtn;
//
//    @FXML
//    private TableColumn<?, ?> dichvu_col_id;
//
//    @FXML
//    private TableColumn<?, ?> dichvu_col_ten;
//
    @FXML
    private AnchorPane dichvu_form;
//
//    @FXML
//    private TextField dichvu_id;
//
//    @FXML
//    private Button dichvu_lammoibtn;
//
//    @FXML
//    private TextField dichvu_search;
//
//    @FXML
//    private TableView<?> dichvu_tableview;
//
//    @FXML
//    private TextField dichvu_ten;
//
//    @FXML
//    private Button dichvu_thembtn;
//
//    @FXML
//    private Button dichvu_xoabtn;


    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    //private String decimalPattern = "^[-+]?[0-9]*\\.?[0-9]+$";
    
//    public void ThongKeHoaDonThang() {
//        ObservableList listData = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
//        thongke_hdthang.setItems(listData);
//    }   
//    //int HoaDonNam[] = {2023,2024};
//    public void ThongKeHoaDonNam() {
//        List<Integer> listS = new ArrayList<>();
//        for (int year = currentYear; year >= 0; year--) {
//            listS.add(year);
//        }
//        ObservableList listData = FXCollections.observableArrayList(listS);
//        thongke_hdnam.setItems(listData);
//    }
//    
//    public void homeChart(){
//        
//        
//        //String sql;
//        try{
//        thongke_hdthang.valueProperty().addListener((observable, oldValue, newValue) -> {
//            thongke_hoadonchart.getData().clear();
//            String sql = "SELECT MAPHONG, TONGTIEN FROM HOADON WHERE THANG = ? AND NAM = ?";
//        
//            connect = database.getConn();
//
//            try{
//                //XYChart.Series chart = new XYChart.Series();
//                XYChart.Series<String, Integer> chart = new XYChart.Series<>();
//                prepare = connect.prepareStatement(sql);
//                prepare.setString(1, String.valueOf(thongke_hdthang.getSelectionModel().getSelectedItem()));  // Month = 2
//                prepare.setString(2, String.valueOf(thongke_hdnam.getSelectionModel().getSelectedItem()));
//                result = prepare.executeQuery();
//
//                while(result.next()){
//                    chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
//                    //chart.getData().add(new XYChart.Data<>("PG02",50));
//                }
//
//                thongke_hoadonchart.getData().addAll(chart);
//
//            }catch(Exception e){e.printStackTrace();}
//            
//        });
//        } catch (NullPointerException e) {
//            // Xử lý lỗi tại đây
//            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
//            // Thực hiện các hành động xử lý thích hợp (ví dụ: ghi log, hiển thị thông báo cho người dùng)
//          }
//
//          try{
//        
//        thongke_hdnam.valueProperty().addListener((observable, oldValue, newValue) -> {
//            thongke_hoadonchart.getData().clear();
//            String sql = "SELECT MAPHONG, TONGTIEN FROM HOADON WHERE THANG = ? AND NAM = ?";
//        
//            connect = database.getConn();
//
//            try{
//                //XYChart.Series chart = new XYChart.Series();
//                XYChart.Series<String, Integer> chart = new XYChart.Series<>();
//                prepare = connect.prepareStatement(sql);
//                prepare.setString(1, String.valueOf(thongke_hdthang.getSelectionModel().getSelectedItem()));  // Month = 2
//                prepare.setString(2, String.valueOf(thongke_hdnam.getSelectionModel().getSelectedItem()));
//                result = prepare.executeQuery();
//
//                while(result.next()){
//                    chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
//                    //chart.getData().add(new XYChart.Data<>("PG02",50));
//                }
//
//                thongke_hoadonchart.getData().addAll(chart);
//
//            }catch(Exception e){e.printStackTrace();}
//            
//        });
//        
//        } catch (NullPointerException e) {
//            // Xử lý lỗi tại đây
//            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
//            // Thực hiện các hành động xử lý thích hợp (ví dụ: ghi log, hiển thị thông báo cho người dùng)
//          }
//                
//    }

//    public void PhongThem(ActionEvent event) {
//
//        /*String sql = "INSERT INTO PHONG (MAPHONG,TENPG,LOAI,SONGUOI,DIENTICH,GIA,TRANGTHAI) "
//                + "VALUES(?,?,?,?,?,?,?)";*/
//        String sql = "INSERT INTO PHONG (MAPHONG,TENPG,SONGUOI,DIENTICH,GIA) "
//                + "VALUES(?,?,?,?,?)";
//        
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (phong_id.getText().isEmpty()
//                    || phong_ten.getText().isEmpty()
//                    || phong_loaiphong.getSelectionModel().getSelectedItem() == null
//                    || phong_trt.getSelectionModel().getSelectedItem() == null
//                    || phong_giathue.getText().isEmpty()
//                    || phong_songuoi.getText().isEmpty()
//                    || phong_dientich.getText().isEmpty()) {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill all blank fields");
//                alert.showAndWait();
//
//            } else {
//                // CHECK IF THE FLOWER ID IS ALREADY EXIST
//                String checkData = "SELECT MAPHONG FROM PHONG WHERE MAPHONG = '"
//                        + phong_id.getText() + "'";
//
//                statement = connect.createStatement();
//                result = statement.executeQuery(checkData);
//
//                if (result.next()) {
//                    alert = new Alert(AlertType.ERROR);
//                    alert.setTitle("Error Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Ma phong: " + phong_id.getText() + " was already exist!");
//                    alert.showAndWait();
//                } else {
//                    prepare = connect.prepareStatement(sql);
//                    prepare.setString(1, phong_id.getText());
//                    prepare.setString(2, phong_ten.getText());
//                    prepare.setString(3, (String) phong_loaiphong.getSelectionModel().getSelectedItem());
//                    prepare.setString(3, phong_songuoi.getText());
//                    prepare.setString(4, phong_dientich.getText());
//                    prepare.setString(5, phong_giathue.getText());
//                    prepare.setString(7, (String) phong_trt.getSelectionModel().getSelectedItem());
//                  
//                    prepare.executeUpdate();
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Added!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    PhongShowListData();
//
//                    // CLEAR ALL FIELDS
//                    PhongClear();
//                }
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
//     public void PhongXoa(ActionEvent event) {
//
//        String sql = "DELETE FROM PHONG WHERE MAPHONG = '"
//                + phong_id.getText() + "'";
//
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (phong_id.getText().isEmpty())  {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill phong_id fields");
//                alert.showAndWait();
//
//            } else {
//                alert = new Alert(AlertType.CONFIRMATION);
//                alert.setTitle("Confirmation Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Are you sure you want to DELETE phong where maphong: " + phong_id.getText() + "?");
//                Optional<ButtonType> option = alert.showAndWait();
//
//                if (option.get().equals(ButtonType.OK)) {
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Deleted!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    PhongShowListData();
//
//                    // CLEAR ALL FIELDS
//                    PhongClear();
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
//    public void PhongClear() {
//
//        phong_id.setText("");
//        phong_ten.setText("");
//        phong_loaiphong.getSelectionModel().clearSelection();
//        phong_giathue.setText("");
//        phong_trt.getSelectionModel().clearSelection();
//        phong_songuoi.setText("");
//        phong_dientich.setText("");
//        
//
//    }
//    
//    public void PhongStatus() {
//        ObservableList listData = FXCollections.observableArrayList("Con trong", "Da cho thue");
//        phong_trt.setItems(listData);
//        
//    }
//    
//    public void PhongLoai() {
//        ObservableList listData = FXCollections.observableArrayList("Sinh vien", "Gia dinh");
//        phong_loaiphong.setItems(listData);
//        
//    }
//    
//    
//    public ObservableList<PhongData> PhongListData() {
//
//        ObservableList<PhongData> listData = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM PHONG";
//
//        connect = database.getConn();
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            result = prepare.executeQuery();
//
//            PhongData phong;
//
//            while (result.next()) { 
//                phong = new PhongData(result.getString("MAPHONG"),
//                         result.getString("TENPG"), result.getString("LOAI"),
//                         result.getInt("SONGUOI"), result.getInt("DIENTICH"),
//                          result.getInt("GIA"),result.getString("TRANGTHAI"));
//
//                listData.add(phong);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listData;
//    }
//
//    private ObservableList<PhongData> PhongList;
//
//    public void PhongShowListData() {
//        
//        PhongList = PhongListData();
//        try{    
//        phong_col_id.setCellValueFactory(cellData -> cellData.getValue().getPhongidProperty());
//        phong_col_ten.setCellValueFactory(cellData -> cellData.getValue().getTenphongProperty());
//        phong_col_loai.setCellValueFactory(cellData -> cellData.getValue().getLoaiProperty());
//        phong_col_songuoi.setCellValueFactory(cellData -> cellData.getValue().getSongdgoProperty().asString());
//        phong_col_dientich.setCellValueFactory(cellData -> cellData.getValue().getDientichProperty().asString());
//        phong_col_gia.setCellValueFactory(cellData -> cellData.getValue().getGiaProperty().asString());
//        phong_col_trangthai.setCellValueFactory(cellData -> cellData.getValue().getTrangthaiProperty());
//
//        phong_tableview.setItems(PhongList);
//        } catch (NullPointerException e) {
//            // Xử lý lỗi tại đây
//            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
//            // Thực hiện các hành động xử lý thích hợp (ví dụ: ghi log, hiển thị thông báo cho người dùng)
//          }
//    }
    
    //private String integerPattern = "^[-+]?[0-9]+$";
//    public void HoaDonThem(ActionEvent event) { //SỬA THÀNH NHẬP TRẠNG THÁI VÀ CONNO RỖNG VẪN ĐƯỢC
//
//        String sql = "INSERT INTO HOADON (MAHD,MAPHONG,THANG,NAM,TONGTIEN,TRANGTHAI,CONNO) "
//                + "VALUES(?,?,?,?,?,?,?)";
//
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (hoadon_id.getText().isEmpty()
//                    //|| hoadon_maphong.getText().isEmpty()
//                    || hoadon_maphong.getSelectionModel().getSelectedItem() == null
//                    //|| hoadon_trangthai.getSelectionModel().getSelectedItem() == null
//                    || hoadon_thang.getSelectionModel().getSelectedItem() == null
//                    || hoadon_nam.getSelectionModel().getSelectedItem() == null
//                    || hoadon_tongtien.getText().isEmpty()
//                    //|| hoadon_conno.getText().isEmpty()
//                    ) {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill all blank fields");
//                alert.showAndWait();
//
//            } else {
//                int flag = 0;
//                try {
//                    Integer.parseInt(hoadon_conno.getText());
//                   flag++;     
//                    
//                } catch (NumberFormatException e) {
//                    
//                }
////                if ((hoadon_conno.getText() instanceof String || !hoadon_conno.getText().matches(integerPattern)) && !hoadon_conno.getText().isEmpty()) {
////                    alert = new Alert(AlertType.ERROR);
////                alert.setTitle("Error Message");
////                alert.setHeaderText(null);
////                alert.setContentText("Tiền nợ phải là số nguyên.");
////                alert.showAndWait();
////                } else if (Integer.parseInt(hoadon_conno.getText()) <=0 && !hoadon_conno.getText().isEmpty()){
////                alert = new Alert(AlertType.ERROR);
////                alert.setTitle("Error Message");
////                alert.setHeaderText(null);
////                alert.setContentText("Tiền nợ phải bé hơn hoặc bằng tổng tiền.");
////                alert.showAndWait();
//                if (flag==0 && !hoadon_conno.getText().isEmpty()){
//                    alert = new Alert(AlertType.ERROR);
//                    alert.setTitle("Error Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Tiền nợ phải là số nguyên.");
//                    alert.showAndWait();
//                    
//                } else if (Integer.parseInt(hoadon_conno.getText()) > 0 && !hoadon_conno.getText().isEmpty()){
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Tiền nợ phải bé hơn hoặc bằng tổng tiền.");
//                alert.showAndWait();
//                }else {
//                    // CHECK IF THE FLOWER ID IS ALREADY EXIST
//                    String checkData = "SELECT MAHD FROM HOADON WHERE MAHD = '"
//                            + hoadon_id.getText() + "'";
//
//                    statement = connect.createStatement();
//                    result = statement.executeQuery(checkData);
//
//                    if (result.next()) {
//                        alert = new Alert(AlertType.ERROR);
//                        alert.setTitle("Error Message");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Ma hoa don: " + hoadon_id.getText() + " was already exist!");
//                        alert.showAndWait();
//                    } else {
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
//
//                        alert = new Alert(AlertType.INFORMATION);
//                        alert.setTitle("Information Message");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Successfully Added!");
//                        alert.showAndWait();
//
//                        // SHOW UPDATED TABLEVIEW
//                        //HoaDonShowListData();
//
//                        // CLEAR ALL FIELDS
//                        HoaDonClear();
//                    }
//
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
//    public void HoaDonUpdate(ActionEvent event) {
//
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
//
//        try {
//            Alert alert;
//
//            if (hoadon_id.getText().isEmpty()
//                    //|| hoadon_maphong.getText().isEmpty()
//                    || hoadon_maphong.getSelectionModel().getSelectedItem() == null
//                    || hoadon_trangthai.getSelectionModel().getSelectedItem() == null
//                    || hoadon_thang.getSelectionModel().getSelectedItem() == null
//                    || hoadon_nam.getSelectionModel().getSelectedItem() == null
//                    || hoadon_tongtien.getText().isEmpty()
//                    || hoadon_conno.getText().isEmpty()) {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill all blank fields");
//                alert.showAndWait();
//
//            } else {
//                alert = new Alert(AlertType.CONFIRMATION);
//                alert.setTitle("Confirmation Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Are you sure you want to UPDATE HOADON ID: " + hoadon_id.getText() + "?");
//                Optional<ButtonType> option = alert.showAndWait();
//
//                if (option.get().equals(ButtonType.OK)) {
////                    prepare = connect.prepareStatement(sql);
////                    prepare.setString(1, hoadon_tongtien.getText());
////                    prepare.setString(2, hoadon_maphong.getText());
////                    prepare.setString(3, String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()));
////                    prepare.setString(4, String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()));
////                    prepare.setString(5, (String) hoadon_trangthai.getSelectionModel().getSelectedItem());
////                    prepare.setString(6, hoadon_conno.getText());
////                    prepare.setString(7, hoadon_id.getText());
////                    
////                    prepare.executeUpdate();
//                    
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Updated!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    //HoaDonShowListData();
//
//                    // CLEAR ALL FIELDS
//                    HoaDonClear();
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
//    public void HoaDonSelect() {  //lam them khong cho sua mahd,bla
//        HoaDonData hoadon = hoadon_tableview.getSelectionModel().getSelectedItem();
//        int num = hoadon_tableview.getSelectionModel().getSelectedIndex();
//
//        if ((num - 1) < -1) {
//            return;
//        }
//
//        hoadon_id.setText(String.valueOf(hoadon.getHoaDonIdProperty().getValue()));
//        //hoadon_maphong.setText(String.valueOf(hoadon.getPhongIdProperty().getValue()));
//        hoadon_tongtien.setText(String.valueOf(hoadon.getTongTienProperty().getValue()));
//        hoadon_conno.setText(String.valueOf(hoadon.getConNoProperty().getValue()));
//        int index = hoadon_thang.getItems().indexOf(Integer.valueOf(hoadon.getThangProperty().getValue()));
//        if (index != -1) {
//            hoadon_thang.getSelectionModel().select(index);
//        }
//        int index2 = hoadon_nam.getItems().indexOf(Integer.valueOf(hoadon.getNamProperty().getValue()));
//        if (index2 != -1) {
//            hoadon_nam.getSelectionModel().select(index2);
//        }
//        int index1 = hoadon_trangthai.getItems().indexOf(String.valueOf(hoadon.getTrangThaiProperty().getValue()));
//        if (index1 != -1) {
//            hoadon_trangthai.getSelectionModel().select(index1);
//        }
//        int index3 = hoadon_maphong.getItems().indexOf(String.valueOf(hoadon.getPhongIdProperty().getValue()));
//        if (index3 != -1) {
//            hoadon_maphong.getSelectionModel().select(index3);
//        }
//        
//        //hoadon_tongtien.setDisable(false);
//        hoadon_xemchitietbtn.setDisable(false); 
//        hoadon_capnhatbtn.setDisable(false); 
//        hoadon_xoabtn.setDisable(false); 
//        hoadon_id.setDisable(true);
//        //hoadon_thang.setText(String.valueOf(hoadon.getThangProperty()));
//        String hdn = String.valueOf(hoadon.getNamProperty().getValue());
//        String hdmap = String.valueOf(hoadon.getPhongIdProperty().getValue());
//        String hdt = String.valueOf(hoadon.getThangProperty().getValue());
//        String hdcn = String.valueOf(hoadon.getConNoProperty().getValue());
//        String hdtt = String.valueOf(hoadon.getTrangThaiProperty().getValue());
//        
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
//            }
//        });       
//        //hoadon_maphong.textProperty().addListener((observable, oldValue, newValue) -> {
//        hoadon_maphong.valueProperty().addListener((observable, oldValue, newValue) -> {
//            hoadon_xemchitietbtn.setDisable(true);
//            hoadon_xoabtn.setDisable(true); 
//            if (newValue.equals(hdmap) 
//                    && ((String) hoadon_trangthai.getSelectionModel().getSelectedItem()).equals(hdtt)
//                    && hoadon_conno.getText().equals(hdcn)
//                    && String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()).equals(hdt)
//                    && String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()).equals(hdn)){
//                hoadon_xemchitietbtn.setDisable(false);
//                hoadon_xoabtn.setDisable(false);
//            }
//        });
//        hoadon_thang.valueProperty().addListener((observable, oldValue, newValue) -> {
//            hoadon_xemchitietbtn.setDisable(true);
//            hoadon_xoabtn.setDisable(true); 
//            if (newValue == Integer.valueOf(hdt)
//                    && hoadon_conno.getText().equals(hdcn)
//                    //&& hoadon_maphong.getText().equals(hdmap)
//                    && ((String)hoadon_maphong.getSelectionModel().getSelectedItem()).equals(hdmap)
//                    && ((String) hoadon_trangthai.getSelectionModel().getSelectedItem()).equals(hdtt)
//                    && String.valueOf(hoadon_nam.getSelectionModel().getSelectedItem()).equals(hdn)){
//                hoadon_xemchitietbtn.setDisable(false);
//                hoadon_xoabtn.setDisable(false);
//            }
//        }); 
//        hoadon_nam.valueProperty().addListener((observable, oldValue, newValue) -> {
//            hoadon_xemchitietbtn.setDisable(true);
//            hoadon_xoabtn.setDisable(true); 
//            if (newValue == Integer.valueOf(hdn) 
//                    && hoadon_conno.getText().equals(hdcn)
//                    //&& hoadon_maphong.getText().equals(hdmap)
//                    && ((String)hoadon_maphong.getSelectionModel().getSelectedItem()).equals(hdmap)
//                    && String.valueOf(hoadon_thang.getSelectionModel().getSelectedItem()).equals(hdt)
//                    && ((String) hoadon_trangthai.getSelectionModel().getSelectedItem()).equals(hdtt)) {
//                hoadon_xemchitietbtn.setDisable(false);
//                hoadon_xoabtn.setDisable(false);
//            }
//        });  
//        
//        HoaDonId = String.valueOf(hoadon.getHoaDonIdProperty().getValue());  
//        MaPhong = String.valueOf(hoadon.getPhongIdProperty().getValue());
//        KyDong= String.valueOf(hoadon.getKyDongProperty().getValue());  
//        TongTien = String.valueOf(hoadon.getTongTienProperty().getValue());
//        TenPhong = String.valueOf(hoadon_tenphong.getText());
//    }
//    
//    public void DoiMaPhong(){
//        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
//        hoadon_maphong.valueProperty().addListener((Observable, oldValue, newValue) -> {
//        String sql = "SELECT TENPG FROM PHONG WHERE MAPHONG = ?";
//
//        connect = database.getConn();
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            prepare.setString(1, (String)newValue);
//            result = prepare.executeQuery();
//            result = prepare.executeQuery();
//            
//            if(result.next()){
//                hoadon_tenphong.setText(result.getString(1));
//                //chart.getData().add(new XYChart.Data<>("PG02",50));
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        });
//    }
//    
//    private String HoaDonId;
//    private String MaPhong;
//    private String TenPhong;
//    private String KyDong;
//    private String TongTien;
//    
//     public void HoaDonXoa(ActionEvent event) {
//
//        String sql = "DELETE FROM HOADON WHERE MAHD = '"
//                + hoadon_id.getText() + "'";
//
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (hoadon_id.getText().isEmpty()
//                    //|| hoadon_maphong.getText().isEmpty()
//                    || hoadon_maphong.getSelectionModel().getSelectedItem() == null
//                    || hoadon_trangthai.getSelectionModel().getSelectedItem() == null
//                    || hoadon_thang.getSelectionModel().getSelectedItem() == null
//                    || hoadon_nam.getSelectionModel().getSelectedItem() == null
//                    || hoadon_tongtien.getText().isEmpty()
//                    || hoadon_conno.getText().isEmpty())   {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill HOADON_ID fields");
//                alert.showAndWait();
//
//            } else {
//                alert = new Alert(AlertType.CONFIRMATION);
//                alert.setTitle("Confirmation Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Are you sure you want to DELETE HOA DON where MAHD: " + hoadon_id.getText() + "?");
//                Optional<ButtonType> option = alert.showAndWait();
//
//                if (option.get().equals(ButtonType.OK)) {
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Deleted!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    //HoaDonShowListData();
//
//                    HoaDonClear();
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
//    public void HoaDonClear() { //sua luon setdisable cua may texfield
//
//        hoadon_id.setText("");
//        //hoadon_maphong.setText("");
//        hoadon_maphong.getSelectionModel().clearSelection();
//        hoadon_tenphong.setText("");
//        hoadon_thang.getSelectionModel().clearSelection();
//        hoadon_nam.getSelectionModel().clearSelection();
//        hoadon_trangthai.getSelectionModel().clearSelection();
//        //hoadon_tongtien.setText("");
//        hoadon_conno.setText("");
//        hoadon_search.setText("");
//        
//        HoaDonShowListData();
//        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
//        hoadon_xemchitietbtn.setDisable(true); 
//        hoadon_thembtn.setDisable(false); 
//        hoadon_xoabtn.setDisable(true); 
//        hoadon_capnhatbtn.setDisable(true); 
//        hoadon_id.setDisable(false);
//        hoadon_tongtien.setDisable(true); 
//        
//        hoadon_tongtien.setText(String.valueOf(0));
//        
//        
//    }
//    
//    public void HoaDonSearch() {
//        
//        FilteredList<HoaDonData> filter = new FilteredList<>(HoaDonList, e -> true);
//
//        hoadon_search.textProperty().addListener((Observable, oldValue, newValue) -> {
//
//            filter.setPredicate((HoaDonData PrediateHoaDonData) -> {
//
//                if (newValue.isEmpty() /*|| newValue == null*/) {
//                    return true;
//                }
//
//                String searchKey = newValue.toLowerCase();
//
//                if (String.valueOf(PrediateHoaDonData.getHoaDonIdProperty().getValue()).toLowerCase().contains(searchKey)) {
//                    return true;
//                } else if (String.valueOf(PrediateHoaDonData.getKyDongProperty().getValue()).toLowerCase().contains(searchKey)) {
//                    return true;
//                } else if (String.valueOf(PrediateHoaDonData.getTrangThaiProperty().getValue()).toLowerCase().contains(searchKey)) {
//                    return true;
//                } else if (String.valueOf(PrediateHoaDonData.getPhongIdProperty().getValue()).toLowerCase().contains(searchKey)) {
//                    return true;
//                } else if (String.valueOf(PrediateHoaDonData.getTongTienProperty().getValue()).toLowerCase().contains(searchKey)) {
//                    return true;
//                } else if (String.valueOf(PrediateHoaDonData.getConNoProperty().getValue()).toLowerCase().contains(searchKey)) {
//                    return true;
//                }else {
//                    return false;
//                }
//            });
//
//        SortedList<HoaDonData> sortList = new SortedList<>(filter);
//
//        sortList.comparatorProperty().bind(hoadon_tableview.comparatorProperty());
//
//        hoadon_tableview.setItems(sortList);
//        });
//    }
//    
//    public void HoaDonPhong() {
//        String sql = "SELECT MAPHONG FROM PHONG WHERE TRANGTHAI = 'Da cho thue'";
//        List<String> listS = new ArrayList<>();
//
//        connect = database.getConn();
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            result = prepare.executeQuery();
//
//            HoaDonData hoadon;
//            while (result.next()) { 
//                listS.add(result.getString("MAPHONG"));
//                
//            }
//        
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ObservableList listData = FXCollections.observableArrayList(listS);
//        hoadon_maphong.setItems(listData);
//        
//    }
//    
//    //String HoaDonStatus[] = {"Chua thanh toan", "Da thanh toan"};
//    public void HoaDonStatus() {
//        ObservableList listData = FXCollections.observableArrayList("Chua thanh toan", "Da thanh toan");
//        hoadon_trangthai.setItems(listData);
//        
//    }    
//    //int HoaDonThang[] = {1,2,3,4,5,6,7,8,9,10,11,12};
//    public void HoaDonThang() {
//        ObservableList listData = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
//        hoadon_thang.setItems(listData);
//    }   
//    //int HoaDonNam[] = {2023,2024};
//    public void HoaDonNam() {
//        List<Integer> listS = new ArrayList<>();
//        for (int year = currentYear; year >= 0; year--) {
//            listS.add(year);
//        }
//        ObservableList listData = FXCollections.observableArrayList(listS);
//        hoadon_nam.setItems(listData);
//    }
//    
//    
//    public ObservableList<HoaDonData> HoaDonListData() {
//
//        ObservableList<HoaDonData> listData = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM HOADON";
//
//        connect = database.getConn();
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            result = prepare.executeQuery();
//
//            HoaDonData hoadon;
//
//            while (result.next()) { 
//                hoadon = new HoaDonData(result.getString("MAHD"),
//                         result.getString("MAPHONG"), result.getInt("THANG"),
//                         result.getInt("NAM"), result.getInt("TONGTIEN"),
//                         result.getString("TRANGTHAI"), result.getInt("CONNO"));
//
//                listData.add(hoadon);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listData;
//    }
//
//    private ObservableList<HoaDonData> HoaDonList;
//
//    public void HoaDonShowListData() {
//        HoaDonList = HoaDonListData();
//        try{
//        hoadon_col_id.setCellValueFactory(cellData -> cellData.getValue().getHoaDonIdProperty());
//        hoadon_col_maphong.setCellValueFactory(cellData -> cellData.getValue().getPhongIdProperty());
//        hoadon_col_kydong.setCellValueFactory(cellData -> cellData.getValue().getKyDongProperty());
//        hoadon_col_tongtien.setCellValueFactory(cellData -> cellData.getValue().getTongTienProperty().asString());
//        hoadon_col_trangthai.setCellValueFactory(cellData -> cellData.getValue().getTrangThaiProperty());
//        hoadon_col_conno.setCellValueFactory(cellData -> cellData.getValue().getConNoProperty().asString());
//        
//        hoadon_tableview.setItems(HoaDonList);
//        }catch (NullPointerException e) {
//            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
//            //hoadonMaPhong = ""; // Gán giá trị mặc định
//          }
//    }
    
//    public void HopDongStatus() {
//        ObservableList listData = FXCollections.observableArrayList("Het han", "Con han");
//        hopdong_trangthai.setItems(listData);        
//    }
        
//    public void KhachGioiTinh() {
//        ObservableList listData = FXCollections.observableArrayList("Nam", "Nu");
//        khach_gioitinh.setItems(listData);
//        
//    }
    
    private double x = 0;
    private double y = 0;
    
//    public void backofCTHD(ActionEvent ev){
//            thongke_form.setVisible(false);
//            phong_form.setVisible(false);
//            hoadon_form.setVisible(true);
//            hopdong_form.setVisible(false);
//            khach_form.setVisible(false);
//            phieu_form.setVisible(false);
//            cthd_form.setVisible(false);
//            
//            thongke_btn.setStyle("-fx-background-color: transparent");
//            phong_btn.setStyle("-fx-background-color: transparent");
//            hoadon_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0,#2f6996)");
//            hopdong_btn.setStyle("-fx-background-color: transparent");
//            khach_btn.setStyle("-fx-background-color: transparent");
//            phieu_btn.setStyle("-fx-background-color: transparent");
//    }
//    
//    public void CTHDThem(ActionEvent event) { //khi them cthd mà loại phòng trọ thì tự cập nhật số lượng và đơn giá
//
//        String sql = "INSERT INTO CTHD (MAHD,LOAIHD,SL,DONGIA,THANHTIEN) "
//                + "VALUES(?,?,?,?,?)";
//
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (cthd_hdid.getText().isEmpty()
//                    || cthd_loaihd.getSelectionModel().getSelectedItem() == null
//                    || cthd_sl.getText().isEmpty()
//                    || cthd_dongia.getText().isEmpty()) {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill all blank fields");
//                alert.showAndWait();
//
//            } else {
//                int dongia = Integer.parseInt(cthd_dongia.getText());
//                int sl = Integer.parseInt(cthd_sl.getText());
//                int thanhtien = dongia * sl;
//                cthd_thanhtien.setText(String.valueOf(thanhtien));
//                // CHECK IF THE FLOWER ID IS ALREADY EXIST
//                String checkData = "SELECT LOAIHD FROM CTHD WHERE MAHD = '"
//                        + cthd_hdid.getText() + "'";
//
//                statement = connect.createStatement();
//                result = statement.executeQuery(checkData);
//
//                if (result.next()) {
//                    alert = new Alert(AlertType.ERROR);
//                    alert.setTitle("Error Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Loai hoa don: " + (String) cthd_loaihd.getSelectionModel().getSelectedItem() + " da ton tai!");
//                    alert.showAndWait();
//                } else {
//                    prepare = connect.prepareStatement(sql);
//                    prepare.setString(1, cthd_hdid.getText());
//                    prepare.setString(2, (String) cthd_loaihd.getSelectionModel().getSelectedItem());
//                    prepare.setString(3, cthd_sl.getText());
//                    prepare.setString(4, cthd_dongia.getText());
//                    prepare.setString(5, cthd_thanhtien.getText());
//                    
//                    prepare.executeUpdate();
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Added!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    //HoaDonShowListData();
//
//                    // CLEAR ALL FIELDS
//                    CTHDClear();
//                }
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
//     public void CTHDXoa(ActionEvent event) {
//
//        String sql = "DELETE FROM CTHD WHERE MAHD = '"
//                + cthd_hdid.getText() + "' and LOAIHD = '" + (String) cthd_loaihd.getSelectionModel().getSelectedItem() + "'";
//
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (cthd_hdid.getText().isEmpty()
//                    || cthd_loaihd.getSelectionModel().getSelectedItem() == null
//                    || cthd_sl.getText().isEmpty()
//                    || cthd_dongia.getText().isEmpty()) {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill all blank fields");
//                alert.showAndWait();
//
//            } else {
//                alert = new Alert(AlertType.CONFIRMATION);
//                alert.setTitle("Confirmation Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Bạn có chắc muốn xóa chi tiết hóa đơn này?");
//                Optional<ButtonType> option = alert.showAndWait();
//
//                if (option.get().equals(ButtonType.OK)) {
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Deleted!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    //HoaDonShowListData();
//
//                    CTHDClear();
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//     
//     public void CTHDUpdate(ActionEvent event) {
//
//        String sql = "UPDATE CTHD SET SL = '"
//                + cthd_sl.getText() + "' AND DONGIA = '"
//                + cthd_dongia.getText()+ "'AND THANHTIEN = '"
//                + cthd_thanhtien.getText()+  "' WHERE MAHD = '" 
//                + cthd_hdid.getText() + "' AND  LOAIHD = '" 
//                + String.valueOf(cthd_loaihd.getSelectionModel().getSelectedItem()) + "'";
//
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (cthd_hdid.getText().isEmpty()
//                    || cthd_loaihd.getSelectionModel().getSelectedItem() == null
//                    || cthd_sl.getText().isEmpty()
//                    || cthd_dongia.getText().isEmpty()) {
//
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill all blank fields");
//                alert.showAndWait();
//
//            } else {
//                alert = new Alert(AlertType.CONFIRMATION);
//                alert.setTitle("Confirmation Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Bạn có chắc muốn cập nhật CTHD này?");
//                Optional<ButtonType> option = alert.showAndWait();
//
//                if (option.get().equals(ButtonType.OK)) {
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Updated!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//
//                    // CLEAR ALL FIELDS
//                    CTHDClear();
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
//    public void CTHDClear() { //sua luon setdisable cua may texfield
//
//        cthd_loaihd.getSelectionModel().clearSelection();
//        cthd_thanhtien.setText("");
//        cthd_sl.setText("");
//        cthd_dongia.setText("");
//        
////        CTHDShowListData();
////        cthd_hdid.setText(HoaDonId);
////        cthd_kydong.setText(KyDong);
////        cthd_maphong.setText(MaPhong);
////        cthd_tenphong.setText(TenPhong);
////        cthd_tongtien.setText(TongTien);
//        
//        cthd_thanhtien.setDisable(true);
//        cthd_loaihd.setDisable(false);
//        
//        cthd_xoabtn.setDisable(true); 
//        cthd_capnhatbtn.setDisable(true); 
//
//    }
//    
//    public void CTHDSelect() {  //sau khi sửa bên textfiled thì không đc xóa
//        CTHDData cthd = cthd_tableview.getSelectionModel().getSelectedItem();
//        int num = cthd_tableview.getSelectionModel().getSelectedIndex();
//
//        if ((num - 1) < -1) {
//            return;
//        }
//        cthd_hdid.setText(String.valueOf(cthd.getHoaDonIdProperty().getValue()));
//        cthd_sl.setText(String.valueOf(cthd.getSoLuongProperty().getValue()));
//        cthd_dongia.setText(String.valueOf(cthd.getDonGiaProperty().getValue()));
//        cthd_thanhtien.setText(String.valueOf(cthd.getThanhTienProperty().getValue()));
//        int index = cthd_loaihd.getItems().indexOf(String.valueOf(cthd.getLoaiHDProperty().getValue()));
//        if (index != -1) {
//            cthd_loaihd.getSelectionModel().select(index);
//        }
//        
//        cthd_loaihd.setDisable(true);
//        cthd_xoabtn.setDisable(false); 
//        cthd_capnhatbtn.setDisable(false); 
//        
//        String cthdsl = String.valueOf(cthd.getSoLuongProperty().getValue());
//        String cthddg = String.valueOf(cthd.getDonGiaProperty().getValue());
//        
//        cthd_sl.textProperty().addListener((observable, oldValue, newValue) -> {
//            
//            if (newValue.equals(cthdsl) 
//                    && cthd_dongia.getText().equals(cthddg)){
//                cthd_xoabtn.setDisable(false); 
//            } else{
//                cthd_xoabtn.setDisable(true);
//            }
//        });
//        cthd_dongia.textProperty().addListener((observable, oldValue, newValue) -> {
//            
//            if (newValue.equals(cthddg) 
//               && cthd_sl.getText().equals(cthdsl)){
//                cthd_xoabtn.setDisable(false);
//            } else{
//                cthd_xoabtn.setDisable(true);
//            }
//        });
//
//        
//    }
//    
////    public ObservableList<CTHDData> CTHDListData() {
////
////        ObservableList<CTHDData> listData = FXCollections.observableArrayList();
////        String sql = "SELECT * FROM CTHD WHERE MAHD = '" + HoaDonId + "'";
////
////        connect = database.getConn();
////
////        try {
////            prepare = connect.prepareStatement(sql);
////            result = prepare.executeQuery();
////
////            CTHDData cthd;
////
////            while (result.next()) { 
////                cthd = new CTHDData(result.getString("MAHD"),
////                         result.getString("LOAIHD"), result.getInt("SL"),
////                         result.getInt("DONGIA"));
////
////                listData.add(cthd);
////            }
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return listData;
////    }
////
////    private ObservableList<CTHDData> CTHDList;
////
////    public void CTHDShowListData() {
////        CTHDList = CTHDListData();
////        cthd_col_hdid.setCellValueFactory(cellData -> cellData.getValue().getHoaDonIdProperty());
////        cthd_col_loaihd.setCellValueFactory(cellData -> cellData.getValue().getLoaiHDProperty());
////        cthd_col_sl.setCellValueFactory(cellData -> cellData.getValue().getSoLuongProperty().asString());
////        cthd_col_dongia.setCellValueFactory(cellData -> cellData.getValue().getDonGiaProperty().asString());
////        cthd_col_thanhtien.setCellValueFactory(cellData -> cellData.getValue().getThanhTienProperty().asString());
////        
////        cthd_tableview.setItems(CTHDList);
////    }
//    
//    public void CTHDLoaiHD() {
//        ObservableList listData = FXCollections.observableArrayList("Phong tro", "Dien nuoc");
//        cthd_loaihd.setItems(listData);        
//    }
//    
//    public void XemCTHD(ActionEvent ev){
//        
//            thongke_form.setVisible(false);
//            phong_form.setVisible(false);
//            hoadon_form.setVisible(false);
//            hopdong_form.setVisible(false);
//            khach_form.setVisible(false);
//            phieu_form.setVisible(false);
//            cthd_form.setVisible(true);
//            
//            thongke_btn.setStyle("-fx-background-color: transparent");
//            phong_btn.setStyle("-fx-background-color: transparent");
//            hoadon_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0,#2f6996)");
//            hopdong_btn.setStyle("-fx-background-color: transparent");
//            khach_btn.setStyle("-fx-background-color: transparent");
//            phieu_btn.setStyle("-fx-background-color: transparent");
//            
////            CTHDShowListData();
////            
////            cthd_hdid.setText(HoaDonId);
////            cthd_kydong.setText(KyDong);
////            cthd_maphong.setText(MaPhong);
////            cthd_tenphong.setText(TenPhong);
////            cthd_tongtien.setText(TongTien);
//            
//            cthd_thanhtien.setDisable(true);
//            cthd_loaihd.setDisable(false);
//            
//            cthd_xoabtn.setDisable(true); 
//            cthd_capnhatbtn.setDisable(true);
//            
//            CTHDLoaiHD();
//        
//    }
    
//    public void KhachNganGioiTinh() {
//        ObservableList listData = FXCollections.observableArrayList("Nam", "Nu");
//        khachngan_gioitinh.setItems(listData);
//        
//    }
//    
//    public void KhachNganTrangthai() {
//        ObservableList listData = FXCollections.observableArrayList("Duyet", "Chua duyet");
//        khachngan_trangthai.setItems(listData);
//        khachngan_searchtt.setItems(listData);
//    }
//    
//   public void KhachNganSelect() {  //sau khi sửa bên textfiled thì không đc xóa
//        KhachData khangnganhan = khachngan_tableview.getSelectionModel().getSelectedItem();
//        int num = khachngan_tableview.getSelectionModel().getSelectedIndex();
//
//        if ((num - 1) < -1) {
//            return;
//        }
//        khachngan_id.setText(String.valueOf(khangnganhan.getKhachidProperty().getValue()));
//        khachngan_ten.setText(String.valueOf(khangnganhan.getHotenProperty().getValue()));
//        khachngan_sdt.setText(String.valueOf(khangnganhan.getSdtProperty().getValue()));
//        khachngan_cccd.setText(String.valueOf(khangnganhan.getCccdProperty().getValue()));
//        khachngan_mail.setText(String.valueOf(khangnganhan.getEmailProperty().getValue()));
//        khachngan_mangdaidien.setText(String.valueOf(khangnganhan.getDaidienidProperty().getValue()));
//        int index = khachngan_trangthai.getItems().indexOf(String.valueOf(khangnganhan.getTrangthaiProperty().getValue()));
//        if (index != -1) {
//            khachngan_trangthai.getSelectionModel().select(index);
//        }
//        int index2 = khachngan_gioitinh.getItems().indexOf(String.valueOf(khangnganhan.getGioitinhProperty().getValue()));
//        if (index2 != -1) {
//            khachngan_gioitinh.getSelectionModel().select(index2);
//        }
//        LocalDate selectedDate = LocalDate.parse(String.valueOf(khangnganhan.getNgaysinhProperty().getValue()), formatter);
//        khachngan_ngs.setValue(selectedDate);
//        LocalDate selectedDate2 = LocalDate.parse(String.valueOf(khangnganhan.getNgaybatdauProperty().getValue()), formatter);
//        khachngan_ngbd.setValue(selectedDate2);
//        LocalDate selectedDate3 = LocalDate.parse(String.valueOf(khangnganhan.getNgayketthucProperty().getValue()), formatter);
//        khachngan_ngkt.setValue(selectedDate3);
//        
//        khachngan_duyetbtn.setDisable(false); 
//        khachngan_xoabtn.setDisable(false); 
//        khachngan_capnhatbtn.setDisable(false); 
//        
//        
//        
////        String gt = String.valueOf(khangnganhan.getSoLuongProperty().getValue());
////        String tt = String.valueOf(khangnganhan.getDonGiaProperty().getValue());
////        
////        khachngan_gioitinh.textProperty().addListener((observable, oldValue, newValue) -> {
////            
////            if (newValue.equals(gt) 
////                    && cthd_dongia.getText().equals(cthddg)){
////                cthd_xoabtn.setDisable(false); 
////            } else{
////                cthd_xoabtn.setDisable(true);
////            }
////        });
////        khachngan_trangthai.textProperty().addListener((observable, oldValue, newValue) -> {
////            
////            if (newValue.equals(cthddg) 
////               && cthd_sl.getText().equals(cthdsl)){
////                cthd_xoabtn.setDisable(false);
////            } else{
////                cthd_xoabtn.setDisable(true);
////            }
////        });
//
//        
//   }
//   
//   public void KhachNganSearch() {
//               
//        FilteredList<KhachData> filter = new FilteredList<>(KhachNganHanList, e -> true);
//
//        khachngan_search.textProperty().addListener((Observable, oldValue, newValue) -> {
//            
//            filter.setPredicate((KhachData PrediateKhachNganData) -> {
//                boolean tt = false;
//                if (khachngan_searchtt.getSelectionModel().getSelectedItem()==null) tt = true;
//
//                if (newValue.isEmpty() && tt) {
//                    return true;
//                }
//
//                String searchKey = newValue.toLowerCase();
//
//                if (String.valueOf(PrediateKhachNganData.getKhachidProperty().getValue()).toLowerCase().contains(searchKey) 
//                        && ( (String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem()))) || tt)) {
//                    return true;
//                } else if (String.valueOf(PrediateKhachNganData.getHotenProperty().getValue()).toLowerCase().contains(searchKey) 
//                        && ( (String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem()))) || tt)) {
//                    return true;
//                } else if (String.valueOf(PrediateKhachNganData.getGioitinhProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem()))) || tt)) {
//                    return true;
//                } else if (String.valueOf(PrediateKhachNganData.getNgaysinhProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))|| tt)) {
//                    return true;
//                } else if (String.valueOf(PrediateKhachNganData.getSdtProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))|| tt)) {
//                    return true;
//                } else if (String.valueOf(PrediateKhachNganData.getCccdProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))|| tt)) {
//                    return true;
//                }else if (String.valueOf(PrediateKhachNganData.getEmailProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))|| tt)) {
//                    return true;
//                }else if (String.valueOf(PrediateKhachNganData.getNgaybatdauProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))|| tt)) {
//                    return true;
//                }else if (String.valueOf(PrediateKhachNganData.getNgayketthucProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))|| tt)) {
//                    return true;
//                }else if (String.valueOf(PrediateKhachNganData.getDaidienidProperty().getValue()).toLowerCase().contains(searchKey)
//                        && ((String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))|| tt)) {
//                    return true;
//                }else {
//                    return false;
//                }
//            });
//
//        SortedList<KhachData> sortList = new SortedList<>(filter);
//
//        sortList.comparatorProperty().bind(khachngan_tableview.comparatorProperty());
//
//        khachngan_tableview.setItems(sortList);
//        });
//        //làm thêm thay đổi duyệt
//        
////        khachngan_searchtt.valueProperty().addListener((observable, oldValue, newValue) -> {
////            filter.setPredicate((KhachData PrediateKhachNganData) -> {
////                boolean s = false;
////                if (khachngan_search.getText().isEmpty()) s = true;
////                
////                if (newValue.isEmpty() && s) {
////                    return true;
////                }
////                
////            });
////            
////            SortedList<KhachData> sortList = new SortedList<>(filter);
////
////            sortList.comparatorProperty().bind(khachngan_tableview.comparatorProperty());
////
////            khachngan_tableview.setItems(sortList);
////        });
//        
//    }
//   
//   
//   
//   public void DoiMaDD(){//CẦN KHÔNG KHI MÃ NG DẠI DIỆN LÀ MẶC ĐỊNH KHI KHÁCH THUÊ MUỐN ĐK
//        khachngan_mangdaidien.textProperty().addListener((Observable, oldValue, newValue) -> {
//        String sql = "SELECT HOTEN FROM KHACHTHUE WHERE MAKT = ?";
//
//        connect = database.getConn();
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            prepare.setString(1, newValue);
//            result = prepare.executeQuery();
//            result = prepare.executeQuery();
//            
//            if(result.next()){
//                khachngan_tenngdaidien.setText(result.getString(1));
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        });
//    }
//    
//    public void KhachNganDuyet(ActionEvent event) {//update khach ngắn hạn đã duyệt
//        
//        String sql = "UPDATE KHACHNGANHAN SET TRANGTHAI = 'Duyet'";
//
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//            {
//                alert = new Alert(AlertType.CONFIRMATION);
//                alert.setTitle("Confirmation Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Bạn có chắc muốn duyệt khách này?");
//                Optional<ButtonType> option = alert.showAndWait();
//
//                if (option.get().equals(ButtonType.OK)) {
//                    statement = connect.createStatement();
//                    statement.executeUpdate(sql);
//
//                    alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Updated!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    
//
//                    // CLEAR ALL FIELDS
//                    KhachNganClear();
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//        
////         String sql = "INSERT INTO KHACHTHUE (MAKT,HOTEN,GIOITINH,NGAYSINH,SDT,CCCD,EMAIL,MADD,NGAYBATDAU,NGAYKETTHUC) "
////                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
////        
////        connect = database.getConn();
////
////        try {
////            Alert alert;
////
////
////
////                    prepare = connect.prepareStatement(sql);
////                    prepare.setString(1, khachngan_id.getText());
////                    prepare.setString(2, khachngan_ten.getText());
////                    prepare.setString(3, (String) khachngan_gioitinh.getSelectionModel().getSelectedItem());
////                    
////                    LocalDate ngaySinh=khachngan_ngs.getValue();
////                    java.sql.Date sqlNgaySinh = java.sql.Date.valueOf(ngaySinh);
////                    prepare.setDate(4, sqlNgaySinh);
////                    
////                    prepare.setString(5, khachngan_sdt.getText());
////                    prepare.setString(6, khachngan_cccd.getText());
////                    prepare.setString(7, khachngan_mail.getText());  
////                    prepare.setString(8, khachngan_mangdaidien.getText());
////                    
////                    LocalDate ngayBatdau=khachngan_ngbd.getValue();
////                    java.sql.Date sqlNgayBatdau = java.sql.Date.valueOf(ngayBatdau);
////                    prepare.setDate(9, sqlNgayBatdau);
////                    
////                    LocalDate ngayKetthuc=khachngan_ngkt.getValue();
////                    java.sql.Date sqlNgayKetthuc = java.sql.Date.valueOf(ngayKetthuc);
////                    prepare.setDate(10, sqlNgayKetthuc);
////                    //prepare.setString(11, "Chờ duyệt");
////                    
////                    prepare.executeUpdate();
////
////                    alert = new Alert(Alert.AlertType.INFORMATION);
////                    alert.setTitle("Thông báo");
////                    alert.setHeaderText(null);
////                    alert.setContentText("Thêm thành công!");
////                    alert.showAndWait();
////
////                    // SHOW UPDATED TABLEVIEW
////                    //KhachNganHanShowListData();
////
////                    // CLEAR ALL FIELDS
////                    KhachNganClear();
////                
////
////            
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////
////
////
////    }
//    
//    public void KhachNganClear() { //sua luon setdisable cua may texfield
//
//        khachngan_id.setText("");
//        khachngan_ten.setText("");
//        khachngan_gioitinh.getSelectionModel().clearSelection();
//        khachngan_trangthai.getSelectionModel().clearSelection();
//        khachngan_ngs.setValue(null);
//        khachngan_ngbd.setValue(null);
//        khachngan_ngkt.setValue(null);
//        khachngan_sdt.setText("");
//        khachngan_cccd.setText("");
//        khachngan_mail.setText("");
//        khachngan_mangdaidien.setText("");
//        khachngan_tenngdaidien.setText("");
//        khachngan_search.setText("");
//        
//        KhachNganHanShowListData();
//        DoiMaDD();
//        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
//        khachngan_duyetbtn.setDisable(true); 
//        khachngan_xoabtn.setDisable(true); 
//        khachngan_capnhatbtn.setDisable(true); 
//        khachngan_id.setDisable(true);
//        khachngan_tenngdaidien.setDisable(true);
//    }
//    
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
//    
//    public ObservableList<KhachData> KhachNganHanListData() {
//
//        ObservableList<KhachData> listData = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM KHACHNGANHAN";
//
//        connect = database.getConn();
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            result = prepare.executeQuery();
//
//            KhachData khachnh;
//            
//            // Định dạng cho ngày/tháng/năm
//
//            while (result.next()) {
//                LocalDate ngaySinh = result.getDate("NGAYSINH").toLocalDate();
//                LocalDate ngayBatDau = result.getDate("NGAYBATDAU").toLocalDate();
//                LocalDate ngayKetThuc = result.getDate("NGAYKETTHUC").toLocalDate();
//
//                // Format ngày/tháng/năm
//                String formattedNgaySinh = ngaySinh.format(formatter);
//                String formattedNgayBatDau = ngayBatDau.format(formatter);
//                String formattedNgayKetThuc = ngayKetThuc.format(formatter);
//
//                khachnh = new KhachData(result.getString("MAKT"),
//                        result.getString("HOTEN"), result.getString("GIOITINH"),
//                        formattedNgaySinh, result.getString("SDT"),
//                        result.getString("CCCD"), result.getString("EMAIL"),
//                        result.getString("MADD"), formattedNgayBatDau, 
//                        formattedNgayKetThuc,result.getString("TRANGTHAI"));
//                listData.add(khachnh);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listData;
//    }
//
//    private ObservableList<KhachData> KhachNganHanList;
//
//    public void KhachNganHanShowListData() {
//        KhachNganHanList = KhachNganHanListData();
//        
//        khachngan_col_id.setCellValueFactory(cellData -> cellData.getValue().getKhachidProperty());
//        khachngan_col_ten.setCellValueFactory(cellData -> cellData.getValue().getHotenProperty());
//        khachngan_col_gioitinh.setCellValueFactory(cellData -> cellData.getValue().getGioitinhProperty());
//        khachngan_col_ngs.setCellValueFactory(cellData -> cellData.getValue().getNgaysinhProperty());
//        khachngan_col_sdt.setCellValueFactory(cellData -> cellData.getValue().getSdtProperty());
//        khachngan_col_cccd.setCellValueFactory(cellData -> cellData.getValue().getCccdProperty());
//        khachngan_col_mail.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
//        khachngan_col_ngbd.setCellValueFactory(cellData -> cellData.getValue().getNgaybatdauProperty());
//        khachngan_col_ngkt.setCellValueFactory(cellData -> cellData.getValue().getNgayketthucProperty());
//        khachngan_col_ngdaidien.setCellValueFactory(cellData -> cellData.getValue().getDaidienidProperty());
//        khachngan_col_trangthai.setCellValueFactory(cellData -> cellData.getValue().getTrangthaiProperty());
//
//        
//        khachngan_tableview.setItems(KhachNganHanList);
//    }
    
    //private PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    
//    private static final Pattern PHONE_REGEX = Pattern.compile("^\\+(\\d{1,15})\\d+$");
//
//    public static boolean isValidPhoneNumberRegex(String phoneNumberString) {
//        if (phoneNumberString.length() != 12) return false;
//        return PHONE_REGEX.matcher(phoneNumberString).matches();
//    }
//    
//    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
//
//    public static boolean isValidEmail(String emailString) {
//        return EMAIL_REGEX.matcher(emailString).matches();
//    }
//    
//    private static final Pattern CCCD_REGEX = Pattern.compile("^([0-9]{10}|[0-9]{12}|[0-9]{13})$");
//
//    public static boolean isValidCCCD(String cccdString) {
//        if (cccdString.length() != 12) return false;
//        return CCCD_REGEX.matcher(cccdString).matches();
//    }
//    
////    private static final Pattern NAME_REGEX = Pattern.compile("^[a-zA-Zàáâäãåèéêëìíîïòóôöõùúûüỳýỹññ]{2,}( [a-zA-Zàáâäãåèéêëìíîïòóôöõùúûüỳýỹññ]{2,})+$");
////
////    public static boolean isValidName(String nameString) {
////        if (nameString == null || nameString.trim().isEmpty()) {
////            return false; // Check for empty or null input
////        }
////
////        String[] nameParts = nameString.trim().split(" ");
////        if (nameParts.length < 2) {
////            return false; // Name should have at least two parts (first and last name)
////        }
////
////        for (String part : nameParts) {
////            if (!NAME_REGEX.matcher(part).matches()) {
////                return false; // Each part should match the name pattern
////            }
////        }
////
////        return true;
////    }
//    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáảạâấầẩẫậãăắằặẳẵèéẻẹẽêếìíòóôõùúýềểễệỉĩịỏọốồổộơớờởỡợủụũưửừứữựỳỹỷỵ ]{2,}");
//    public static boolean isValidName(String name) { 
//      if (name == null || name.isEmpty()) {
//        return false;
//      }
//
//      return VALID_NAME_PATTERN.matcher(name).matches();
//    }
//    
//    public void KhachThueClear() { //sua luon setdisable cua may texfield
//
//        khach_id.setText("");
//        khach_ten.setText("");
//        khach_gioitinh.getSelectionModel().clearSelection();
//        //khachngan_trangthai.getSelectionModel().clearSelection();
//        khach_ngs.setValue(null);
//        khach_ngbd.setValue(null);
//        khach_ngkt.setValue(null);
//        khach_sdt.setText("+84");
//        khach_cccd.setText("");
//        khach_mail.setText("");
//        khach_mangdaidien.setText("");
//        khach_tenngdaidien.setText("");
//        khach_search.setText("");
//        
//        KhachThueShowListData();
//        KhachGioiTinh() ;
//        //DoiMaDD();
//        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
//        khach_thembtn.setDisable(false); 
//        khach_xoabtn.setDisable(true); 
//        khach_capnhatbtn.setDisable(true); 
//        khach_id.setDisable(false);
//        //khach_tenngdaidien.setDisable(true);
//    }
//    
//    public void KhachThueThem(ActionEvent event) {
//        
//         String sql = "INSERT INTO KHACHTHUE (MAKT,HOTEN,GIOITINH,NGAYSINH,SDT,CCCD,EMAIL,MADD,NGAYBATDAU,NGAYKETTHUC) "
//                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
//        
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//            if (khach_id.getText().isEmpty()
//                    || khach_ten.getText().isEmpty()
//                    || khach_gioitinh.getSelectionModel().getSelectedItem() == null
//                    || khach_ngs.getValue()==null
//                    || khach_ngbd.getValue()==null
//                    || khach_ngkt.getValue()==null
//                    
//                    ) {
//
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Thông báo lỗi");
//                alert.setHeaderText(null);
//                alert.setContentText("Vui lòng điền vào các ô có *");
//                alert.showAndWait();
//
//            } else if (!isValidName(khach_ten.getText())) {
//                    alert = new Alert(Alert.AlertType.ERROR);
//                                alert.setTitle("Thông báo lỗi");
//                                alert.setHeaderText(null);
//                                alert.setContentText("Họ tên không hợp lệ!");
//                                alert.showAndWait();
//            } else if (!isValidPhoneNumberRegex(khach_sdt.getText())) {
//                    alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Thông báo lỗi");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Số điện thoại không hợp lệ!");
//                        alert.showAndWait();
//            } else if (!isValidEmail(khach_mail.getText())) {
//                    alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Thông báo lỗi");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Email không hợp lệ!");
//                        alert.showAndWait();
//            } else if (!isValidCCCD(khach_cccd.getText())) {
//                    alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Thông báo lỗi");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Căn cước công dân không hợp lệ!");
//                        alert.showAndWait();
//            } else {
//                
//                
//                    // CHECK IF THE FLOWER ID IS ALREADY EXIST
//                    String checkData = "SELECT MAKT FROM KHACHTHUE WHERE MAKT = '"
//                            + khach_id.getText() + "'";
//
//                    statement = connect.createStatement();
//                    result = statement.executeQuery(checkData);
//
//                    if (result.next()) {
//                        alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Thông báo lỗi");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Mã khách: " + khach_id.getText() + " đã tồn tại!");
//                        alert.showAndWait();
//                    } else 
//                    {
//                        prepare = connect.prepareStatement(sql);
//                        prepare.setString(1, khach_id.getText());
//                        prepare.setString(2, khach_ten.getText());
//                        prepare.setString(3, (String) khach_gioitinh.getSelectionModel().getSelectedItem());
//
//                        LocalDate ngaySinh=khach_ngs.getValue();
//                        java.sql.Date sqlNgaySinh = java.sql.Date.valueOf(ngaySinh);
//                        prepare.setDate(4, sqlNgaySinh);
//
//                        prepare.setString(5, khach_sdt.getText());
//                        prepare.setString(6, khach_cccd.getText());
//                        prepare.setString(7, khach_mail.getText());  
//                        prepare.setString(8, khach_mangdaidien.getText());
//
//                        LocalDate ngayBatdau=khach_ngbd.getValue();
//                        java.sql.Date sqlNgayBatdau = java.sql.Date.valueOf(ngayBatdau);
//                        prepare.setDate(9, sqlNgayBatdau);
//
//                        LocalDate ngayKetthuc=khach_ngkt.getValue();
//                        java.sql.Date sqlNgayKetthuc = java.sql.Date.valueOf(ngayKetthuc);
//                        prepare.setDate(10, sqlNgayKetthuc);
//                        //prepare.setString(11, "Chờ duyệt");
//
//                        prepare.executeUpdate();
//
//                        alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Thông báo");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Thêm thành công!");
//                        alert.showAndWait();
//
//                        // SHOW UPDATED TABLEVIEW
//                        //KhachNganHanShowListData();
//
//                        // CLEAR ALL FIELDS
//                        KhachThueClear();
//                    }
//                
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//    }
//    
//    public ObservableList<KhachData> KhachThueListData() {
//
//        ObservableList<KhachData> listData = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM KHACHTHUE";
//
//        connect = database.getConn();
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            result = prepare.executeQuery();
//
//            KhachData khachthue;
//            
//            // Định dạng cho ngày/tháng/năm
//
//            while (result.next()) {
//                LocalDate ngaySinh = result.getDate("NGAYSINH").toLocalDate();
//                LocalDate ngayBatDau = result.getDate("NGAYBATDAU").toLocalDate();
//                LocalDate ngayKetThuc = result.getDate("NGAYKETTHUC").toLocalDate();
//
//                // Format ngày/tháng/năm
//                String formattedNgaySinh = ngaySinh.format(formatter);
//                String formattedNgayBatDau = ngayBatDau.format(formatter);
//                String formattedNgayKetThuc = ngayKetThuc.format(formatter);
//
//                khachthue = new KhachData(result.getString("MAKT"),
//                        result.getString("HOTEN"), result.getString("GIOITINH"),
//                        formattedNgaySinh, result.getString("SDT"),
//                        result.getString("CCCD"), result.getString("EMAIL"),
//                        result.getString("MADD"), formattedNgayBatDau, 
//                        formattedNgayKetThuc);
//                listData.add(khachthue);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listData;
//    }
//
//    private ObservableList<KhachData> KhachThueList;
//
//    public void KhachThueShowListData() {
//        KhachThueList = KhachThueListData();
//        
//        khach_col_id.setCellValueFactory(cellData -> cellData.getValue().getKhachidProperty());
//        khach_col_ten.setCellValueFactory(cellData -> cellData.getValue().getHotenProperty());
//        khach_col_gioitinh.setCellValueFactory(cellData -> cellData.getValue().getGioitinhProperty());
//        khach_col_ngs.setCellValueFactory(cellData -> cellData.getValue().getNgaysinhProperty());
//        khach_col_sdt.setCellValueFactory(cellData -> cellData.getValue().getSdtProperty());
//        khach_col_cccd.setCellValueFactory(cellData -> cellData.getValue().getCccdProperty());
//        khach_col_mail.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
//        khach_col_ngbd.setCellValueFactory(cellData -> cellData.getValue().getNgaybatdauProperty());
//        khach_col_ngkt.setCellValueFactory(cellData -> cellData.getValue().getNgayketthucProperty());
//        khach_col_ngdaidien.setCellValueFactory(cellData -> cellData.getValue().getDaidienidProperty());
//        
//        khach_tableview.setItems(KhachThueList);
//    }
    
    public void switchForm(ActionEvent event) {

        if (event.getSource() == thongke_btn) {
            thongke_form.setVisible(true);
            phong_form.setVisible(false);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(false);
            khach_form.setVisible(false);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);

            thongke_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0, #2f6996)");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color: transparent");
            
            
            //tk.initialize(null, null);
            
            //taikhoan_btn.setStyle("-fx-background-color: transparent");

            /*homeAF();
            homeTI();
            homeTC();*/   
//            ThongKeHoaDonThang() ;
//            ThongKeHoaDonNam() ;
//            int index = thongke_hdthang.getItems().indexOf(currentMonth);
//            if (index != -1) {
//                thongke_hdthang.getSelectionModel().select(index);
//            }
//            int index2 = thongke_hdnam.getItems().indexOf(currentYear);
//            if (index2 != -1) {
//                thongke_hdnam.getSelectionModel().select(index2);
//            }
//            homeChart();
            
        } else if (event.getSource() == phong_btn) {
            thongke_form.setVisible(false);
            phong_form.setVisible(true);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(false);
            khach_form.setVisible(false);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);
            
            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#4d95d0,#2f6996)");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color: transparent");
            
//            taikhoan_btn.setStyle("-fx-background-color: transparent");


            // TO SHOW THE UPDATED TABLEVIEW ONCE YOU CLICKED THE AVAILABLE FLOWERS BUTTON
//            PhongShowListData();
//            PhongStatus();
//            PhongLoai();
            

        } else if (event.getSource() == hoadon_btn) {
            thongke_form.setVisible(false);
            phong_form.setVisible(false);
            hoadon_form.setVisible(true);
            hopdong_form.setVisible(false);
            khach_form.setVisible(false);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);

            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#4d95d0,#2f6996)");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color: transparent");
            
            //taikhoan_btn.setStyle("-fx-background-color: transparent");
//            HoaDonShowListData();
//            
//            HoaDonPhong();
//            HoaDonStatus();
//            HoaDonThang();
//            HoaDonNam();
//            
//            HoaDonSearch();
//            
//            DoiMaPhong();
//            
//            hoadon_xemchitietbtn.setDisable(true); 
//            hoadon_thembtn.setDisable(false); 
//            hoadon_xoabtn.setDisable(true); 
//            hoadon_capnhatbtn.setDisable(true); 
//            hoadon_id.setDisable(false);
//            hoadon_tongtien.setDisable(true); 
//            hoadon_tenphong.setDisable(true);
//            hoadon_tongtien.setText(String.valueOf(0));
            
            

        } else if (event.getSource() == hopdong_btn){
            thongke_form.setVisible(false);
            phong_form.setVisible(false);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(true);
            khach_form.setVisible(false);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);
            
            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0,#2f6996)");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color: transparent");
            //taikhoan_btn.setStyle("-fx-background-color: transparent");
            
//            HopDongStatus();
            
        } else if (event.getSource() == khach_btn){
            thongke_form.setVisible(false);
            phong_form.setVisible(false);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(false);
            khach_form.setVisible(true);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);
            
            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#4d95d0,#2f6996)");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color: transparent");
            //taikhoan_btn.setStyle("-fx-background-color: transparent");
            
//            khach_xoabtn.setDisable(true); 
//            khach_capnhatbtn.setDisable(true); 
//            khach_id.setDisable(false);
//            KhachGioiTinh() ;
//            KhachThueShowListData();
//            KhachThueClear();
            
        } else if (event.getSource() == phieu_btn){
            thongke_form.setVisible(false);
            phong_form.setVisible(false);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(false);
            khach_form.setVisible(false);
            phieu_form.setVisible(true);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);
            
            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0,#2f6996)");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color: transparent");
            //taikhoan_btn.setStyle("-fx-background-color: transparent");
            
        } else if (event.getSource() == khachngan_btn){
            thongke_form.setVisible(false);
            phong_form.setVisible(false);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(false);
            khach_form.setVisible(false);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(true);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);
            
            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0,#2f6996)");
            dichvu_btn.setStyle("-fx-background-color: transparent");
            
//            KhachNganHanShowListData();
//            KhachNganSearch();
//            
//            KhachNganGioiTinh();
//            KhachNganTrangthai();
//            
//            DoiMaDD();
//            
//            khachngan_duyetbtn.setDisable(false); 
//            khachngan_xoabtn.setDisable(true); 
//            khachngan_capnhatbtn.setDisable(true); 
//            khachngan_id.setDisable(false);
//            khachngan_trangthai.setDisable(false);
//            khachngan_tenngdaidien.setDisable(true);
            
//            int index1 = khachngan_searchtt.getItems().indexOf("Duyet");
//            if (index1 != -1) {
//                khachngan_searchtt.getSelectionModel().select(index1);
//            }
            
        } else if (event.getSource() == dichvu_btn){
            thongke_form.setVisible(false);
            phong_form.setVisible(false);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(false);
            khach_form.setVisible(false);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(true);
            caidat_form.setVisible(false);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);
            
            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0,#2f6996)");            
        } else if (event.getSource() == caidat_btn){
            thongke_form.setVisible(false);
            phong_form.setVisible(false);
            hoadon_form.setVisible(false);
            hopdong_form.setVisible(false);
            khach_form.setVisible(false);
            phieu_form.setVisible(false);
            //cthd_form.setVisible(false);
            khachngan_form.setVisible(false);
            dichvu_form.setVisible(false);
            caidat_form.setVisible(true);
            //cthdg_form.setVisible(false);
            //ctpdv_form.setVisible(false);
            
            thongke_btn.setStyle("-fx-background-color: transparent");
            phong_btn.setStyle("-fx-background-color: transparent");
            hoadon_btn.setStyle("-fx-background-color: transparent");
            hopdong_btn.setStyle("-fx-background-color: transparent");
            khach_btn.setStyle("-fx-background-color: transparent");
            phieu_btn.setStyle("-fx-background-color: transparent");
            khachngan_btn.setStyle("-fx-background-color: transparent");
            dichvu_btn.setStyle("-fx-background-color: transparent");            
        }
        
        

    }
    
    
    public void logout() {

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                // HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void close(ActionEvent event){
        System.exit(0);
    }
    
    public void minimize(ActionEvent event) {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    /*@FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }*/
    @FXML
    public void initialize(URL location, ResourceBundle recources){
//        ThongKeHoaDonThang() ;
//        ThongKeHoaDonNam() ;
//        int index = thongke_hdthang.getItems().indexOf(currentMonth);
//        if (index != -1) {
//            thongke_hdthang.getSelectionModel().select(index);
//        }
//        int index2 = thongke_hdnam.getItems().indexOf(currentYear);
//        if (index2 != -1) {
//            thongke_hdnam.getSelectionModel().select(index2);
//        }
//        homeChart();
        //HoaDonShowListData();
//        PhongShowListData();
        thongke_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4d95d0, #2f6996)");
        
    }
}