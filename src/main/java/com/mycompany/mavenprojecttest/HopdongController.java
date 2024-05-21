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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HopdongController implements Initializable {
    
    @FXML
    private Label cthdg_giathue;

    @FXML
    private Label cthdg_hdgid;
    
     @FXML
    private Label cthdg_mangdd;

    @FXML
    private Label cthdg_mapg;
    
     @FXML
    private Label cthdg_ngbd;

    @FXML
    private Label cthdg_ngkt;
    
    @FXML
    private Label cthdg_tenngdd;

    @FXML
    private Label cthdg_tenphong;

    @FXML
    private Label cthdg_tiencoc;

    @FXML
    private Label cthdg_trangthai;
    
    @FXML
    private Button hopdong_capnhatbtn;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_giathue;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_id;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_makt;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_maphong;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_ngbd;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_ngtraphong;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_tiencoc;

    @FXML
    private TableColumn<HopDongData, String> hopdong_col_tinhtrang;

    @FXML
    private AnchorPane hopdong_form;

    @FXML
    private Button hopdong_giahanbtn;

    @FXML
    private TextField hopdong_giathue;

    @FXML
    private Button hopdong_huybtn;

    @FXML
    private TextField hopdong_id;

    @FXML
    private Button hopdong_lammoibtn;

    @FXML
    private TextField hopdong_makt;

    @FXML
    private ComboBox<?> hopdong_maphong;

    @FXML
    private DatePicker hopdong_ngbd;

    @FXML
    private DatePicker hopdong_ngtraphong;

    @FXML
    private TextField hopdong_search;

    @FXML
    private TableView<HopDongData> hopdong_tableview;

    @FXML
    private TextField hopdong_tenkt;

    @FXML
    private TextField hopdong_tenphong;

    @FXML
    private Button hopdong_thembtn;

    @FXML
    private TextField hopdong_tiencoc;

    @FXML
    private TextField hopdong_trangthai;

    @FXML
    private Button hopdong_xemcthdbtn;

    @FXML
    private Button hopdong_xoabtn;

    @FXML
    private TextField cthdg_cccdkt;

    @FXML
    private AnchorPane cthdg_form;

    @FXML
    private Button cthdg_lammoibtn;

    @FXML
    private TextField cthdg_makt;

    @FXML
    private TextField cthdg_sdtkt;

    @FXML
    private TableView<KhachData> cthdg_tableview;
    
        @FXML
    private TableColumn<KhachData, String> cthdg_col_cccdkt;

    @FXML
    private TableColumn<KhachData, String> cthdg_col_makt;

    @FXML
    private TableColumn<KhachData, String> cthdg_col_sdtkt;

    @FXML
    private TableColumn<KhachData, String> cthdg_col_tenkt;

    @FXML
    private TextField cthdg_tenkt;
    
    @FXML
    private TextField themnguoi_cccdkt;

    @FXML
    private TableColumn<KhachData, String> themnguoi_col_cccdkt;

    @FXML
    private TableColumn<KhachData, String> themnguoi_col_makt;

    @FXML
    private TableColumn<KhachData, String> themnguoi_col_sdtkt;

    @FXML
    private TableColumn<KhachData, String> themnguoi_col_tenkt;

    @FXML
    private AnchorPane themnguoi_form;

    @FXML
    private Label themnguoi_hdgid;

    @FXML
    private Button themnguoi_hoanthanhbtn;

    @FXML
    private Button themnguoi_lammoibtn;
    
    @FXML
    private Button themnguoi_back;

    @FXML
    private TextField themnguoi_makt;

    @FXML
    private Label themnguoi_mapg;

    @FXML
    private TextField themnguoi_sdtkt;

    @FXML
    private TableView<KhachData> themnguoi_tableview;

    @FXML
    private TextField themnguoi_tenkt;

    @FXML
    private Button themnguoi_thembtn;

    @FXML
    private Button themnguoi_xoabtn;
    
    @FXML
    private Label themnguoi_giathue;

    @FXML
    private Label themnguoi_mangdd;
    
    @FXML
    private Label themnguoi_ngbd;

    @FXML
    private Label themnguoi_ngkt;
    
    @FXML
    private Label themnguoi_tenngdd;

    @FXML
    private Label themnguoi_tenphong;
    
     @FXML
    private Label themnguoi_tiencoc;

    @FXML
    private Label themnguoi_trangthai;
    
     @FXML
    private Button giahan_quaylai;

    @FXML
    private AnchorPane giahan_form;

    @FXML
    private Button giahan_giahanbtn;

    @FXML
    private TextField giahan_giathue;

    @FXML
    private TextField giahan_makt;

    @FXML
    private ComboBox<?> giahan_maphong;

//    @FXML
//    private Button giahan_minimize;

    @FXML
    private TextField giahan_ngbd;

    @FXML
    private DatePicker giahan_ngkt;

    @FXML
    private TextField giahan_tenkt;

    @FXML
    private TextField giahan_tenphong;

    @FXML
    private TextField giahan_tiencoc;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private CallableStatement caSt;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    

    
                                                                                //hopdong_form
    public void HopDongPhong() {
        String sql = "SELECT MAP FROM PHONG";
        List<String> listS = new ArrayList<>();

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) { 
                listS.add(result.getString("MAP"));
                
            }
        

        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        hopdong_maphong.setItems(listData);        
    }
    
    public void HopDongDoiMaPhong(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        hopdong_maphong.valueProperty().addListener((Observable, oldValue, newValue) -> {
        String sql = "SELECT TENPG,GIA FROM PHONG WHERE MAP = ?";

        connect = database.getConn();
        if (newValue==null) {
            hopdong_tenphong.setText("");
            hopdong_giathue.setText("");
                }

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, (String)newValue);
            result = prepare.executeQuery();
            
            if(result.next()){
                hopdong_tenphong.setText(result.getString(1));
                hopdong_giathue.setText(result.getString(2));
            } else {
                hopdong_tenphong.setText("");
                hopdong_giathue.setText("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
    }
    
    public void HopDongDoiMaDaiDien(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        hopdong_makt.textProperty().addListener((Observable, oldValue, newValue) -> {
        String sql = "SELECT HOTEN FROM KHACHTHUE WHERE MAKT = ?";
        if (newValue.isEmpty()){
            hopdong_tenkt.setText("");
        }
        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, (String)newValue);
            result = prepare.executeQuery();
            
            if(result.next()){
                hopdong_tenkt.setText(result.getString(1));
            }
            else {
                hopdong_tenkt.setText("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
    }
    
    public void DoiTinhTrang(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        hopdong_trangthai.textProperty().addListener((Observable, oldValue, newValue) -> {

            if ("Hiệu lực".equals(newValue)){
                hopdong_makt.setDisable(true); 
                hopdong_maphong.setDisable(true); 
                hopdong_ngbd.setDisable(true); 
                hopdong_ngtraphong.setDisable(true); 
                hopdong_tiencoc.setDisable(true);
                
                hopdong_capnhatbtn.setDisable(true); 
                hopdong_thembtn.setDisable(true); 
                hopdong_xoabtn.setDisable(true);
                hopdong_huybtn.setDisable(false); 
                //if (today == hopdong_ngtraphong.getValue())
                hopdong_giahanbtn.setDisable(false); 
                hopdong_xemcthdbtn.setDisable(false); 
                
            } else if ("Hết hiệu lực".equals(newValue)) {
                hopdong_makt.setDisable(true); 
                hopdong_maphong.setDisable(true); 
                hopdong_ngbd.setDisable(true); 
                hopdong_ngtraphong.setDisable(true); 
                hopdong_tiencoc.setDisable(true);
                
                hopdong_capnhatbtn.setDisable(true); 
                hopdong_thembtn.setDisable(true);
                hopdong_huybtn.setDisable(true); 
                hopdong_giahanbtn.setDisable(true); 
                hopdong_xoabtn.setDisable(false);
                hopdong_xemcthdbtn.setDisable(false); 
            }else {
                hopdong_makt.setDisable(false); 
                hopdong_maphong.setDisable(false); 
                hopdong_ngbd.setDisable(false); 
                hopdong_ngtraphong.setDisable(false); 
                hopdong_tiencoc.setDisable(false); 
                
                hopdong_capnhatbtn.setDisable(false); 
                hopdong_thembtn.setDisable(false); 
                hopdong_xoabtn.setDisable(false);
                hopdong_huybtn.setDisable(true); 
                hopdong_giahanbtn.setDisable(true); 
                hopdong_xemcthdbtn.setDisable(true); 
                
            }
        
        });
    }
    
    public void HopDongSearch() {
               
        FilteredList<HopDongData> filter = new FilteredList<>(HopDongList, e -> true);

        hopdong_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            
            filter.setPredicate((HopDongData PrediateHopDongData) -> {
                
                if (newValue.isEmpty() ) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (String.valueOf(PrediateHopDongData.getHopDongIdProperty().getValue()).toLowerCase().contains(searchKey) ) {
                    return true;
                } else if (String.valueOf(PrediateHopDongData.getNgayBatDauProperty().getValue()).toLowerCase().contains(searchKey) ) {
                    return true;
                } else if (String.valueOf(PrediateHopDongData.getNgayTraPhongProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHopDongData.getMaKhachThueProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHopDongData.getMaPhongProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(PrediateHopDongData.getGiaThueProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                }else if (String.valueOf(PrediateHopDongData.getTienCocProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                }else if (String.valueOf(PrediateHopDongData.getTrangThaiProperty().getValue()).toLowerCase().contains(searchKey)) {
                    return true;
                }else //return false;
                {
                    boolean flag = false;
                    String sql = "SELECT * FROM KHACHTHUE KT, CTHOPDONG CT, HOPDONG HD"
                            + " WHERE KT.MAKT = '" + newValue.toUpperCase() + "' AND HD.MHD = '" 
                            + String.valueOf(PrediateHopDongData.getHopDongIdProperty().getValue()) + "'"
                            + " AND KT.MAKT = CT.MAKT AND CT.MHD = HD.MHD";
                    connect = database.getConn();
                    try{
                        prepare = connect.prepareStatement(sql);
                        result = prepare.executeQuery();
                        if (result.next()){flag = true;}
                        else {flag = false;}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return flag;
                }
            });

        SortedList<HopDongData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(hopdong_tableview.comparatorProperty());

        hopdong_tableview.setItems(sortList);
        });
        
    }
    
    public void taohopdong(ActionEvent ev){
        String strCall = "{call proc_them_hop_dong(?,?,?,?,?)}";
        try{
            Alert alert;

            if (hopdong_ngbd.getValue()==null
                ||hopdong_ngtraphong.getValue()==null
                || hopdong_tiencoc.getText().isEmpty()
                || hopdong_maphong.getSelectionModel().getSelectedItem() == null                    
                || hopdong_makt.getText().isEmpty()
                ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }
            else { 
                String sql = "SELECT * FROM PHONG WHERE MAP = '" + hopdong_maphong.getSelectionModel().getSelectedItem()+ "' AND TRANGTHAI = 'Đã cho thuê'";
                connect = database.getConn();

                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                if (result.next()) { 
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Phòng này đã có người thuê.");
                    alert.showAndWait();

                }
                else {
                    sql = "SELECT * FROM KHACHTHUE WHERE MAKT = '" + hopdong_makt.getText() + "' AND NGAYKETTHUC < ?";
                    connect = database.getConn();

                    prepare = connect.prepareStatement(sql);
                    java.sql.Date Today = java.sql.Date.valueOf(today);
                    prepare.setDate(1, Today);
                    result = prepare.executeQuery();
                    if (result.next()){
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Người này đã ra khỏi phòng trọ.");
                        alert.showAndWait();
                        
                    }
                    else {String checkData = "SELECT MHD FROM HOPDONG WHERE MHD = '"
                                    + hopdong_id.getText() + "'";

                            statement = connect.createStatement();
                            result = statement.executeQuery(checkData);

                        if (result.next()) { // nếu đã có hợp đồng chưa hoàn tất trước đó thì không gọi proc tạo nữa mà qua thẳng thêm người form
                            LocalDate ngaybd=hopdong_ngbd.getValue();
                            String formattedNgayBatDau = ngaybd.format(formatter);
                            LocalDate ngaykt = hopdong_ngtraphong.getValue();
                            String formattedNgayKetThuc = ngaykt.format(formatter);

                            themnguoi_hdgid.setText(hopdong_id.getText());
                            themnguoi_ngbd.setText(formattedNgayBatDau);
                            themnguoi_ngkt.setText(formattedNgayKetThuc);
                            themnguoi_mangdd.setText(hopdong_makt.getText());
                            themnguoi_tiencoc.setText(hopdong_tiencoc.getText());
                            themnguoi_tenngdd.setText(hopdong_tenkt.getText());
                            themnguoi_mapg.setText((String)hopdong_maphong.getSelectionModel().getSelectedItem());
                            themnguoi_tenphong.setText(hopdong_tenphong.getText());
                            themnguoi_giathue.setText(hopdong_giathue.getText());
                            themnguoi_trangthai.setText(hopdong_trangthai.getText());

                            ThemNguoiDoiMaKhach();
                            ThemNguoiShowListData();
                            
                            themnguoi_xoabtn.setDisable(true);
                            
                            themnguoi_back.setVisible(true);

                            hopdong_form.setVisible(false);
                            giahan_form.setVisible(false);
                            cthdg_form.setVisible(false);
                            themnguoi_form.setVisible(true);


                        } else {
                            caSt = connect.prepareCall(strCall);
        //                    //caSt.setString(1, "user");
        //                    
                            LocalDate ngaybd=hopdong_ngbd.getValue();
                            String formattedNgayBatDau = ngaybd.format(formatter);
                            java.sql.Date sqlNgaybd = java.sql.Date.valueOf(ngaybd);
                            caSt.setDate(1, sqlNgaybd);
        //                    
                            LocalDate ngaykt = hopdong_ngtraphong.getValue();
                            String formattedNgayKetThuc = ngaykt.format(formatter);
                            java.sql.Date sqlNgaykt = java.sql.Date.valueOf(ngaykt);
                            caSt.setDate(2, sqlNgaykt);
        //                    
                            caSt.setString(3, hopdong_tiencoc.getText());
                            caSt.setString(4, hopdong_makt.getText());
                            caSt.setString(5, (String)hopdong_maphong.getSelectionModel().getSelectedItem());
                            caSt.execute();

                            HopDongShowListData();

                            themnguoi_ngbd.setText(formattedNgayBatDau);
                            themnguoi_ngkt.setText(formattedNgayKetThuc);
                            themnguoi_mangdd.setText(hopdong_makt.getText());
                            themnguoi_tiencoc.setText(hopdong_tiencoc.getText());
                            themnguoi_tenngdd.setText(hopdong_tenkt.getText());
                            themnguoi_mapg.setText((String)hopdong_maphong.getSelectionModel().getSelectedItem());
                            themnguoi_tenphong.setText(hopdong_tenphong.getText());
                            themnguoi_giathue.setText(hopdong_giathue.getText());
                            themnguoi_trangthai.setText(hopdong_trangthai.getText());

                            ThemNguoiDoiMaKhach();
                            ThemNguoiShowListData();


                            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Successfully Added!");
                            alert.showAndWait(); 
                            
                            themnguoi_xoabtn.setDisable(true);
                            
                            themnguoi_back.setVisible(true);

                            hopdong_form.setVisible(false);
                            giahan_form.setVisible(false);
                            cthdg_form.setVisible(false);
                            themnguoi_form.setVisible(true);                          
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<HopDongData> HopDongListData() {

        ObservableList<HopDongData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM HOPDONG";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            HopDongData hopdong;

            while (result.next()) {
                LocalDate ngayBatDau = result.getDate("NGAYBATDAU").toLocalDate();
                LocalDate ngayKetThuc = result.getDate("NGAYKETTHUC").toLocalDate();

                String formattedNgayBatDau = ngayBatDau.format(formatter);
                String formattedNgayKetThuc = ngayKetThuc.format(formatter);
                
                hopdong = new HopDongData(result.getString("MHD"),
                         formattedNgayBatDau,formattedNgayKetThuc, 
                        result.getString("MADD"), result.getString("MAP"),
                         result.getInt("GIATHUE"), result.getInt("TIENCOC"),
                         result.getString("TINHTRANG"));

                listData.add(hopdong);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<HopDongData> HopDongList;

    public void HopDongShowListData() {
        HopDongList = HopDongListData();
        
        hopdong_col_id.setCellValueFactory(cellData -> cellData.getValue().getHopDongIdProperty());
        hopdong_col_maphong.setCellValueFactory(cellData -> cellData.getValue().getMaPhongProperty());
        hopdong_col_ngbd.setCellValueFactory(cellData -> cellData.getValue().getNgayBatDauProperty());
        hopdong_col_ngtraphong.setCellValueFactory(cellData -> cellData.getValue().getNgayTraPhongProperty());
        hopdong_col_makt.setCellValueFactory(cellData -> cellData.getValue().getMaKhachThueProperty());
        hopdong_col_giathue.setCellValueFactory(cellData -> cellData.getValue().getGiaThueProperty().asString());
        hopdong_col_tinhtrang.setCellValueFactory(cellData -> cellData.getValue().getTrangThaiProperty());
        hopdong_col_tiencoc.setCellValueFactory(cellData -> cellData.getValue().getTienCocProperty().asString());
        
        hopdong_tableview.setItems(HopDongList);
    }
    
    public void ChuyenFormGiaHan(ActionEvent ev){        
        hopdong_form.setVisible(false);
        cthdg_form.setVisible(false);
        themnguoi_form.setVisible(false);
        giahan_form.setVisible(true);
        
        LocalDate ngaykt = hopdong_ngtraphong.getValue();
        String formattedNgayKetThuc = ngaykt.format(formatter);
        giahan_ngbd.setText(formattedNgayKetThuc);
        giahan_makt.setText(hopdong_makt.getText());
        int index = giahan_maphong.getItems().indexOf(String.valueOf(hopdong_maphong.getSelectionModel().getSelectedItem()));
        if (index != -1) {
            giahan_maphong.getSelectionModel().select(index);
        }
        giahan_tiencoc.setText(hopdong_tiencoc.getText());
        
        GiaHanPhong();
        
        GiaHanDoiMaPhong();
        GiaHanDoiMaDaiDien();
        
    }
    
    public void HopDongSelect() { 
        HopDongData hopdong = hopdong_tableview.getSelectionModel().getSelectedItem();
        int num = hopdong_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        hopdong_id.setText(String.valueOf(hopdong.getHopDongIdProperty().getValue()));
        LocalDate selectedDate2 = LocalDate.parse(String.valueOf(hopdong.getNgayBatDauProperty().getValue()), formatter);
        hopdong_ngbd.setValue(selectedDate2);
        LocalDate selectedDate3 = LocalDate.parse(String.valueOf(hopdong.getNgayTraPhongProperty().getValue()), formatter);
        hopdong_ngtraphong.setValue(selectedDate3);
        hopdong_makt.setText(String.valueOf(hopdong.getMaKhachThueProperty().getValue()));
        hopdong_trangthai.setText(String.valueOf(hopdong.getTrangThaiProperty().getValue()));
        hopdong_tiencoc.setText(String.valueOf(hopdong.getTienCocProperty().getValue()));
        int index = hopdong_maphong.getItems().indexOf(String.valueOf(hopdong.getMaPhongProperty().getValue()));
        if (index != -1) {
            hopdong_maphong.getSelectionModel().select(index);
        }
        //HD = hopdong_id.getText();
    }
    //String HD;
    
    public void Huyhopdong(ActionEvent ev){
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thông báo xác nhận");
            alert.setHeaderText(null);
            alert.setContentText("Bạn có chắc muốn hủy hợp đồng?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)){
                String strCall = "{call proc_huy_hop_dong(?)}";
                caSt = connect.prepareCall(strCall);
                caSt.setString(1, hopdong_id.getText());
                caSt.execute();

                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Information Message");
                alert1.setHeaderText(null);
                alert1.setContentText("Hủy hợp đồng thành công!");
                alert1.showAndWait();
                
                HopDongShowListData();
                LamMoihopdong();
                
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public void HopDongXoa(ActionEvent ev) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Bạn có chắc muốn xóa hợp đồng này?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(ButtonType.OK)) {
            String strCall = "{call  XOA_HOPDONG (?)}";
            
            try{
                caSt = connect.prepareCall(strCall);
                caSt.setString(1, hopdong_id.getText());
                //caSt.setString(2, themnguoi_makt.getText());
                caSt.execute();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Xóa hợp đồng thành công!");
                alert.showAndWait();

                LamMoihopdong();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void LamMoihopdong(){
        hopdong_id.setText("");
        hopdong_makt.setText("");
        hopdong_maphong.getSelectionModel().clearSelection();
        hopdong_tiencoc.setText("");
        hopdong_ngbd.setValue(null);
        hopdong_ngtraphong.setValue(null);
         hopdong_trangthai.setText("Chưa hoàn tất");
         
        hopdong_makt.setDisable(false); 
        hopdong_maphong.setDisable(false);
        hopdong_ngbd.setDisable(false);
        hopdong_ngtraphong.setDisable(false);
        hopdong_tiencoc.setDisable(false);
        
        hopdong_tenkt.setDisable(true); 
        hopdong_tenphong.setDisable(true); 
        hopdong_giathue.setDisable(true); 
        hopdong_trangthai.setDisable(true);
        
        HopDongShowListData();
       
    }
    
    public void xemCThopdong(ActionEvent ev){
            hopdong_form.setVisible(false);
            cthdg_form.setVisible(true);
            themnguoi_form.setVisible(false);
            
            LocalDate ngaybd=hopdong_ngbd.getValue();
            String formattedNgayBatDau = ngaybd.format(formatter);
            LocalDate ngaykt = hopdong_ngtraphong.getValue();
            String formattedNgayKetThuc = ngaykt.format(formatter);
                    
            cthdg_hdgid.setText(hopdong_id.getText());
            cthdg_ngbd.setText(formattedNgayBatDau);
            cthdg_ngkt.setText(formattedNgayKetThuc);
            cthdg_mangdd.setText(hopdong_makt.getText());
            cthdg_tiencoc.setText(hopdong_tiencoc.getText());
            cthdg_tenngdd.setText(hopdong_tenkt.getText());
            cthdg_mapg.setText((String)hopdong_maphong.getSelectionModel().getSelectedItem());
            cthdg_tenphong.setText(hopdong_tenphong.getText());
            cthdg_giathue.setText(hopdong_giathue.getText());
            cthdg_trangthai.setText(hopdong_trangthai.getText());
            
            //CTHDongShowListData(hopdong_id.getText());
            CTHDongShowListData();
    }
                                                                                           //CTHDong_form
    public ObservableList<KhachData> CTHDongListData() {

        ObservableList<KhachData> listData = FXCollections.observableArrayList();
        String sql = "SELECT KT.MAKT,KT.HOTEN,KT.SDT,KT.CCCD FROM CTHOPDONG CT, KHACHTHUE KT WHERE CT.MAKT = KT.MAKT AND CT.MHD = ?";
        //String sql = "SELECT MAKT FROM CTHOPDONG where MHD = '" + HD + "'";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, cthdg_hdgid.getText());
            result = prepare.executeQuery();

            KhachData themkhach;

            while (result.next()) { 
                themkhach = new KhachData(result.getString(1),
                         result.getString(2),result.getString(3), 
                        result.getString(4));
                //themkhach = new KhachData(result.getString(1));

                listData.add(themkhach);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<KhachData> CTHDongList;

    public void CTHDongShowListData() {
        CTHDongList = CTHDongListData();

        cthdg_col_makt.setCellValueFactory(cellData -> cellData.getValue().getKhachidProperty());
        cthdg_col_tenkt.setCellValueFactory(cellData -> cellData.getValue().getHotenProperty());
        cthdg_col_cccdkt.setCellValueFactory(cellData -> cellData.getValue().getCccdProperty());
        cthdg_col_sdtkt.setCellValueFactory(cellData -> cellData.getValue().getSdtProperty());
        
        cthdg_tableview.setItems(CTHDongList);
    }
    
    
                                                                                          //themnguoi_form
    public void ThemNguoiDoiMaKhach(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        themnguoi_makt.textProperty().addListener((Observable, oldValue, newValue) -> {
        String sql = "SELECT HOTEN,CCCD,SDT FROM KHACHTHUE WHERE MAKT = ?";
        if (newValue.isEmpty()){
            themnguoi_tenkt.setText("");
            themnguoi_cccdkt.setText("");
            themnguoi_sdtkt.setText("");
        }
        connect = database.getConn();
        
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, (String)newValue);
            result = prepare.executeQuery();
            
            if(result.next()){
                themnguoi_tenkt.setText(result.getString(1));
                themnguoi_cccdkt.setText(result.getString(2));
                themnguoi_sdtkt.setText(result.getString(3));                
            }
            else{
                themnguoi_tenkt.setText("");
                themnguoi_cccdkt.setText("");
                themnguoi_sdtkt.setText("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
    }
    
    public void ThemNguoiThem(ActionEvent ev) {
        String sql = "SELECT * FROM CTHOPDONG WHERE MAKT = '" + themnguoi_makt.getText() + "' AND MHD = '" + themnguoi_hdgid.getText() + "'";
        connect = database.getConn();
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Người này đã được thêm vào hợp đồng!");
                alert.showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String strCall = "{call proc_them_chi_tiet_hop_dong(?,?)}";
        try{
            caSt = connect.prepareCall(strCall);
            caSt.setString(1, themnguoi_hdgid.getText());
            caSt.setString(2, themnguoi_makt.getText());
            caSt.execute();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Thêm người thành công!");
            alert.showAndWait();
            
            
            ThemNguoiClear();
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void ThemNguoiSelect() {  //sau khi sửa bên textfiled thì không đc xóa
        KhachData khang = themnguoi_tableview.getSelectionModel().getSelectedItem();
        int num = themnguoi_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        themnguoi_makt.setText(String.valueOf(khang.getKhachidProperty().getValue()));
//        khach_ten.setText(String.valueOf(khang.getHotenProperty().getValue()));
//        khach_sdt.setText(String.valueOf(khang.getSdtProperty().getValue()));
//        khach_cccd.setText(String.valueOf(khang.getCccdProperty().getValue()));
//        khach_mail.setText(String.valueOf(khang.getEmailProperty().getValue()));
//        int index2 = khach_gioitinh.getItems().indexOf(String.valueOf(khang.getGioitinhProperty().getValue()));
//        if (index2 != -1) {
//            khach_gioitinh.getSelectionModel().select(index2);
//        }
//        LocalDate selectedDate = LocalDate.parse(String.valueOf(khang.getNgaysinhProperty().getValue()), formatter);
//        khach_ngs.setValue(selectedDate);
//        LocalDate selectedDate2 = LocalDate.parse(String.valueOf(khang.getNgaybatdauProperty().getValue()), formatter);
//        khach_ngbd.setValue(selectedDate2);
//        LocalDate selectedDate3 = LocalDate.parse(String.valueOf(khang.getNgayketthucProperty().getValue()), formatter);
//        khach_ngkt.setValue(selectedDate3);
        
        
        themnguoi_xoabtn.setDisable(false); 
       
   }
    
    public void ThemNguoiXoa(ActionEvent ev) {
        
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thông báo xác nhận");
            alert.setHeaderText(null);
            alert.setContentText("Bạn có chắc muốn xóa người này?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)){
                String sql = "DELETE CTHOPDONG"
                        + "WHERE MHD = ? AND MAKT = ?";
                connect = database.getConn();

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, themnguoi_hdgid.getText());
                prepare.setString(2, themnguoi_makt.getText());
                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Xóa người thành công!");
                alert.showAndWait();


                ThemNguoiClear();
            }                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void ThemNguoiClear(){
        themnguoi_makt.setText("");
        themnguoi_xoabtn.setDisable(true);
        ThemNguoiShowListData();
       
    }
    
    
    
    public void ThemNguoiHoanTat(ActionEvent ev) {
        String strCall = "{call proc_hoan_tat_hop_dong(?)}";
        try{
            caSt = connect.prepareCall(strCall);
            caSt.setString(1, themnguoi_hdgid.getText());
            caSt.execute();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Đã hoàn tất hợp đồng!");
            alert.showAndWait();
            
            hopdong_form.setVisible(true);
            cthdg_form.setVisible(false);
            themnguoi_form.setVisible(false);
            giahan_form.setVisible(false);
            HopDongShowListData();
            LamMoihopdong();
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
   
    
    public void back(ActionEvent ev){
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thông báo xác nhận");
            alert.setHeaderText(null);
            alert.setContentText("Bạn có chắc muốn quay lại");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)){
                hopdong_form.setVisible(true);
                cthdg_form.setVisible(false);
                themnguoi_form.setVisible(false);
                giahan_form.setVisible(false);
                
                HopDongDoiMaDaiDien();
                HopDongDoiMaPhong();
                HopDongPhong();
                HopDongShowListData();
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }    
        

    }
    
    public ObservableList<KhachData> ThemNguoiListData() {
        //LocalDate ngaybd=hopdong_ngbd.getValue();
        LocalDate ngaybd = LocalDate.parse(themnguoi_ngbd.getText(), formatter);
        java.sql.Date sqlNgaybd = java.sql.Date.valueOf(ngaybd);
        //LocalDate ngaykt = hopdong_ngtraphong.getValue();
        LocalDate ngaykt = LocalDate.parse(themnguoi_ngkt.getText(), formatter);

        java.sql.Date sqlNgaykt = java.sql.Date.valueOf(ngaykt);

        String sql = "SELECT MHD FROM HOPDONG WHERE NGAYBATDAU = ? AND NGAYKETTHUC = ? AND MADD = ? AND MAP = ?";
        try{
                    prepare = connect.prepareStatement(sql);
                    prepare.setDate(1, sqlNgaybd);
                    prepare.setDate(2, sqlNgaykt);
                    prepare.setString(3, themnguoi_mangdd.getText());
                    prepare.setString(4, themnguoi_mapg.getText());
                    result = prepare.executeQuery();
                    if (result.next())
                    themnguoi_hdgid.setText(result.getString(1)); else themnguoi_hdgid.setText("1");
        }catch (SQLException e){}
        ObservableList<KhachData> listData = FXCollections.observableArrayList();
         sql = "SELECT KT.MAKT,KT.HOTEN,KT.SDT,KT.CCCD FROM CTHOPDONG CT, KHACHTHUE KT WHERE CT.MAKT = KT.MAKT AND CT.MHD = ?";
        //String sql = "SELECT MAKT FROM CTHOPDONG where MHD = '" + HD + "'";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, themnguoi_hdgid.getText());
            result = prepare.executeQuery();

            KhachData themkhach;

            while (result.next()) { 
                themkhach = new KhachData(result.getString(1),
                         result.getString(2),result.getString(3), 
                        result.getString(4));
                //themkhach = new KhachData(result.getString(1));

                listData.add(themkhach);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<KhachData> ThemNguoiList;

    public void ThemNguoiShowListData() {
        ThemNguoiList = ThemNguoiListData();
        try{
        themnguoi_col_makt.setCellValueFactory(cellData -> cellData.getValue().getKhachidProperty());
        themnguoi_col_tenkt.setCellValueFactory(cellData -> cellData.getValue().getHotenProperty());
        themnguoi_col_cccdkt.setCellValueFactory(cellData -> cellData.getValue().getCccdProperty());
        themnguoi_col_sdtkt.setCellValueFactory(cellData -> cellData.getValue().getSdtProperty());
        
        themnguoi_tableview.setItems(ThemNguoiList);
        }catch (NullPointerException e) {
            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
            //hoadonMaPhong = ""; // Gán giá trị mặc định
          }
    }
    
    private double x = 0;
    private double y = 0;
    
                                                                                 //Giahan_form
    
    public void GiaHanPhong() {
        String sql = "SELECT MAP FROM PHONG WHERE TRANGTHAI = 'Còn trống' or MAP = '" + hopdong_maphong.getSelectionModel().getSelectedItem()+ "'";
        List<String> listS = new ArrayList<>();

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while (result.next()) { 
                listS.add(result.getString("MAP"));
                
            }
        

        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        giahan_maphong.setItems(listData);        
    }
    
    public void GiaHanDoiMaPhong(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        giahan_maphong.valueProperty().addListener((Observable, oldValue, newValue) -> {
        String sql = "SELECT TENPG,GIA FROM PHONG WHERE MAP = ?";

        connect = database.getConn();
        if (newValue==null) {
            giahan_tenphong.setText("");
            giahan_giathue.setText("");
                }

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, (String)newValue);
            result = prepare.executeQuery();
            
            if(result.next()){
                giahan_tenphong.setText(result.getString(1));
                giahan_giathue.setText(result.getString(2));
            } else {
                giahan_tenphong.setText("");
                giahan_giathue.setText("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
    }
    
    public void GiaHanDoiMaDaiDien(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        giahan_makt.textProperty().addListener((Observable, oldValue, newValue) -> {
        String sql = "SELECT HOTEN FROM KHACHTHUE WHERE MAKT = ?";
        if (newValue.isEmpty()){
            giahan_tenkt.setText("");
        }
        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, (String)newValue);
            result = prepare.executeQuery();
            
            if(result.next()){
                giahan_tenkt.setText(result.getString(1));
            }
            else {
                giahan_tenkt.setText("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
    }
    
    public void QuayLaiofCTHDong(ActionEvent ev){
        
        hopdong_form.setVisible(true);
        cthdg_form.setVisible(false);
        themnguoi_form.setVisible(false);
        giahan_form.setVisible(false);

        HopDongDoiMaDaiDien();
        HopDongDoiMaPhong();
        HopDongPhong();
        HopDongShowListData();
    } 
    
    public void giahanhopdong(ActionEvent ev){
        String strCall = "{call proc_gia_han_hop_dong(?,?,?,?,?)}";
        try{
            Alert alert;

            if (
                giahan_ngkt.getValue()==null
                || giahan_tiencoc.getText().isEmpty()
                || giahan_maphong.getSelectionModel().getSelectedItem() == null                    
                || giahan_makt.getText().isEmpty()
                ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }
             else {
                    caSt = connect.prepareCall(strCall);
                    //caSt.setString(1, "user");
                    
//                    LocalDate ngaybd=giahan_ngbd.getText();
//                    String formattedNgayBatDau = ngaybd.format(formatter);
//                    java.sql.Date sqlNgaybd = java.sql.Date.valueOf(ngaybd);
                    caSt.setString(1, hopdong_id.getText());
//                    
                    LocalDate ngaykt = giahan_ngkt.getValue();
                    String formattedNgayKetThuc = ngaykt.format(formatter);
                    java.sql.Date sqlNgaykt = java.sql.Date.valueOf(ngaykt);
                    caSt.setDate(2, sqlNgaykt);
                    
                    caSt.setString(3, hopdong_makt.getText());
                    caSt.setString(4, (String)hopdong_maphong.getSelectionModel().getSelectedItem());
                    caSt.setString(5, hopdong_tiencoc.getText());
                    caSt.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    //themnguoi_hdgid.setText(hopdong_id.getText());
                    themnguoi_ngbd.setText(giahan_ngbd.getText());
                    themnguoi_ngkt.setText(formattedNgayKetThuc);
                    themnguoi_mangdd.setText(giahan_makt.getText());
                    themnguoi_tiencoc.setText(giahan_tiencoc.getText());
                    themnguoi_tenngdd.setText(giahan_tenkt.getText());
                    themnguoi_mapg.setText((String)giahan_maphong.getSelectionModel().getSelectedItem());
                    themnguoi_tenphong.setText(giahan_tenphong.getText());
                    themnguoi_giathue.setText(giahan_giathue.getText());
                    themnguoi_trangthai.setText("Chưa hoàn tất");

//                    themnguoi_tenkt.setDisable(true); 
//                    themnguoi_cccdkt.setDisable(true); 
//                    themnguoi_sdtkt.setDisable(true);

                    ThemNguoiShowListData();
                    themnguoi_back.setVisible(false);
                    hopdong_form.setVisible(false);
                    cthdg_form.setVisible(false);
                    themnguoi_form.setVisible(true);
                    giahan_form.setVisible(false);

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
        HopDongShowListData();
        
        hopdong_form.setVisible(true);
        cthdg_form.setVisible(false);
        themnguoi_form.setVisible(false);
        giahan_form.setVisible(false);
        
        HopDongDoiMaDaiDien();
        HopDongDoiMaPhong();
        GiaHanDoiMaDaiDien();
        GiaHanDoiMaPhong();
        
        DoiTinhTrang();
        
        HopDongPhong();
                                
        hopdong_tenkt.setDisable(true); 
        hopdong_tenphong.setDisable(true); 
        hopdong_giathue.setDisable(true); 
        hopdong_trangthai.setDisable(true);
        hopdong_trangthai.setText("Chưa hoàn tất");
        
        HopDongSearch();
        // TODO
    }    

    
    
}
