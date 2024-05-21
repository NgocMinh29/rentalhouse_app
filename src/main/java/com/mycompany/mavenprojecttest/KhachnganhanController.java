/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenprojecttest;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class KhachnganhanController implements Initializable {
    
//    @FXML
//    private Button khachngan_capnhatbtn;

    @FXML
    private TextField khachngan_cccd;

    @FXML
    private Button khachngan_duyetbtn;

    @FXML
    private ComboBox<?> khachngan_gioitinh;
    
    @FXML
    private ComboBox<?> khachngan_searchtt;

    @FXML
    private TextField khachngan_id;

    @FXML
    private Button khachngan_lammoibtn;

    @FXML
    private TextField khachngan_mail;

    @FXML
    private DatePicker khachngan_ngbd;

    @FXML
    private TextField khachngan_mangdaidien;
    
    @FXML
    private TextField khachngan_tenngdaidien;

    @FXML
    private DatePicker khachngan_ngkt;

    @FXML
    private DatePicker khachngan_ngs;

    @FXML
    private TextField khachngan_sdt;

    @FXML
    private TextField khachngan_search;
    
    @FXML
    private DatePicker khachngan_searchngay;
    
    @FXML
    private Button khachngan_tim;

    @FXML
    private TableView<KhachData> khachngan_tableview;
    
     @FXML
    private TableColumn<KhachData, String> khachngan_col_cccd;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_mail;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_gioitinh;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_id;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_ngbd;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_ngdaidien;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_ngkt;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_ngs;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_sdt;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_ten;

    @FXML
    private TableColumn<KhachData, String> khachngan_col_trangthai;

    @FXML
    private TextField khachngan_ten;

    @FXML
    private ComboBox<?> khachngan_trangthai;

    @FXML
    private Button khachngan_xoabtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    public void KhachNganGioiTinh() {
        ObservableList listData = FXCollections.observableArrayList("Nam", "Nữ");
        khachngan_gioitinh.setItems(listData);
        
    }
    
    public void KhachNganTrangthai() {
        ObservableList listData = FXCollections.observableArrayList("Đã duyệt", "Chờ duyệt");
        khachngan_trangthai.setItems(listData);
        khachngan_searchtt.setItems(listData);
    }
    
   public void KhachNganSelect() {  //sau khi sửa bên textfiled thì không đc xóa
        KhachData khangnganhan = khachngan_tableview.getSelectionModel().getSelectedItem();
        int num = khachngan_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        khachngan_id.setText(String.valueOf(khangnganhan.getKhachidProperty().getValue()));
        khachngan_ten.setText(String.valueOf(khangnganhan.getHotenProperty().getValue()));
        khachngan_sdt.setText(String.valueOf(khangnganhan.getSdtProperty().getValue()));
        khachngan_cccd.setText(String.valueOf(khangnganhan.getCccdProperty().getValue()));
        khachngan_mail.setText(String.valueOf(khangnganhan.getEmailProperty().getValue()));
        khachngan_mangdaidien.setText(String.valueOf(khangnganhan.getDaidienidProperty().getValue()));
        int index = khachngan_trangthai.getItems().indexOf(String.valueOf(khangnganhan.getTrangthaiProperty().getValue()));
        if (index != -1) {
            khachngan_trangthai.getSelectionModel().select(index);
        }
        int index2 = khachngan_gioitinh.getItems().indexOf(String.valueOf(khangnganhan.getGioitinhProperty().getValue()));
        if (index2 != -1) {
            khachngan_gioitinh.getSelectionModel().select(index2);
        }
        LocalDate selectedDate = LocalDate.parse(String.valueOf(khangnganhan.getNgaysinhProperty().getValue()), formatter);
        khachngan_ngs.setValue(selectedDate);
        LocalDate selectedDate2 = LocalDate.parse(String.valueOf(khangnganhan.getNgaybatdauProperty().getValue()), formatter);
        khachngan_ngbd.setValue(selectedDate2);
        LocalDate selectedDate3 = LocalDate.parse(String.valueOf(khangnganhan.getNgayketthucProperty().getValue()), formatter);
        khachngan_ngkt.setValue(selectedDate3);
        
        khachngan_duyetbtn.setDisable(false); 
        khachngan_xoabtn.setDisable(false); 
        //khachngan_capnhatbtn.setDisable(false); 
       
   }
   
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
//        
//    }
   
   public void TimKhachNgan(ActionEvent event){
       FilteredList<KhachData> filter = new FilteredList<>(KhachNganHanList, e -> true);
       filter.setPredicate((KhachData PrediateKhachNganData) -> {
           boolean tt = false, ng = false, search = false;
           String searchKey = khachngan_search.getText().toLowerCase();
           
            if  (khachngan_searchtt.getSelectionModel().getSelectedItem()==null || 
                    (String.valueOf(PrediateKhachNganData.getTrangthaiProperty().getValue()).equals(String.valueOf(khachngan_searchtt.getSelectionModel().getSelectedItem())))
                        ) tt = true;
            
           LocalDate ngaytim = khachngan_searchngay.getValue();
           LocalDate ngbd = LocalDate.parse(String.valueOf(PrediateKhachNganData.getNgaybatdauProperty().getValue()), formatter);
           LocalDate ngkt = LocalDate.parse(String.valueOf(PrediateKhachNganData.getNgayketthucProperty().getValue()), formatter);
           if ( khachngan_searchngay.getValue() == null || (ngaytim.isAfter(ngbd) && ngaytim.isBefore(ngkt)) || ngaytim.equals(ngbd) ) 
                    ng = true;
           if (khachngan_search.getText().isEmpty()) {
                    search = true;
                }
           
           if ( (String.valueOf(PrediateKhachNganData.getKhachidProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachNganData.getHotenProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachNganData.getGioitinhProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachNganData.getNgaysinhProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachNganData.getSdtProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            } else if ( (String.valueOf(PrediateKhachNganData.getCccdProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            }else if ( (String.valueOf(PrediateKhachNganData.getEmailProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            }else if ((String.valueOf(PrediateKhachNganData.getNgaybatdauProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            }else if ((String.valueOf(PrediateKhachNganData.getNgayketthucProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            }else if ( (String.valueOf(PrediateKhachNganData.getDaidienidProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    &&  tt && ng) {
                return true;
            }else {
                return false;
            }
           
       });
       SortedList<KhachData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(khachngan_tableview.comparatorProperty());

        khachngan_tableview.setItems(sortList);
       
   }
   
   
   
   public void DoiMaDD(){//CẦN KHÔNG KHI MÃ NG DẠI DIỆN LÀ MẶC ĐỊNH KHI KHÁCH THUÊ MUỐN ĐK
        khachngan_mangdaidien.textProperty().addListener((Observable, oldValue, newValue) -> {
        String sql = "SELECT HOTEN FROM KHACHTHUE WHERE MAKT = ?";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, newValue);
            result = prepare.executeQuery();
            result = prepare.executeQuery();
            
            if(result.next()){
                khachngan_tenngdaidien.setText(result.getString(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
    }
    
    public void KhachNganDuyet(ActionEvent event) {//update khach ngắn hạn đã duyệt
        
        String sql = "UPDATE KHACHNGANHAN SET TRANGTHAI = 'Đã duyệt' where MAKT = '" + khachngan_id.getText() + "'";

        connect = database.getConn();

        try {
            Alert alert;
            {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc muốn duyệt khách này?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    

                    // CLEAR ALL FIELDS
                    KhachNganClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void KhachNganXoa(ActionEvent event) {//update khach ngắn hạn đã duyệt
        
        String sql = "DELETE KHACHNGANHAN where MAKT = '" + khachngan_id.getText() + "'";

        connect = database.getConn();

        try {
            Alert alert;
            {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc muốn xóa khách này?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    

                    // CLEAR ALL FIELDS
                    KhachNganClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
//         String sql = "INSERT INTO KHACHTHUE (MAKT,HOTEN,GIOITINH,NGAYSINH,SDT,CCCD,EMAIL,MADD,NGAYBATDAU,NGAYKETTHUC) "
//                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
//        
//        connect = database.getConn();
//
//        try {
//            Alert alert;
//
//
//
//                    prepare = connect.prepareStatement(sql);
//                    prepare.setString(1, khachngan_id.getText());
//                    prepare.setString(2, khachngan_ten.getText());
//                    prepare.setString(3, (String) khachngan_gioitinh.getSelectionModel().getSelectedItem());
//                    
//                    LocalDate ngaySinh=khachngan_ngs.getValue();
//                    java.sql.Date sqlNgaySinh = java.sql.Date.valueOf(ngaySinh);
//                    prepare.setDate(4, sqlNgaySinh);
//                    
//                    prepare.setString(5, khachngan_sdt.getText());
//                    prepare.setString(6, khachngan_cccd.getText());
//                    prepare.setString(7, khachngan_mail.getText());  
//                    prepare.setString(8, khachngan_mangdaidien.getText());
//                    
//                    LocalDate ngayBatdau=khachngan_ngbd.getValue();
//                    java.sql.Date sqlNgayBatdau = java.sql.Date.valueOf(ngayBatdau);
//                    prepare.setDate(9, sqlNgayBatdau);
//                    
//                    LocalDate ngayKetthuc=khachngan_ngkt.getValue();
//                    java.sql.Date sqlNgayKetthuc = java.sql.Date.valueOf(ngayKetthuc);
//                    prepare.setDate(10, sqlNgayKetthuc);
//                    //prepare.setString(11, "Chờ duyệt");
//                    
//                    prepare.executeUpdate();
//
//                    alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Thông báo");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Thêm thành công!");
//                    alert.showAndWait();
//
//                    // SHOW UPDATED TABLEVIEW
//                    //KhachNganHanShowListData();
//
//                    // CLEAR ALL FIELDS
//                    KhachNganClear();
//                
//
//            
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//    }
    
    public void KhachNganClear() { //sua luon setdisable cua may texfield

        khachngan_id.setText("");
        khachngan_ten.setText("");
        khachngan_gioitinh.getSelectionModel().clearSelection();
        khachngan_trangthai.getSelectionModel().clearSelection();
        khachngan_ngs.setValue(null);
        khachngan_ngbd.setValue(null);
        khachngan_ngkt.setValue(null);
        khachngan_sdt.setText("");
        khachngan_cccd.setText("");
        khachngan_mail.setText("");
        khachngan_mangdaidien.setText("");
        khachngan_tenngdaidien.setText("");
        khachngan_search.setText("");
        khachngan_searchtt.getSelectionModel().clearSelection();
        khachngan_searchngay.setValue(null);
        
        KhachNganHanShowListData();
        DoiMaDD();
        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
        khachngan_duyetbtn.setDisable(true); 
        khachngan_xoabtn.setDisable(true); 
        //khachngan_capnhatbtn.setDisable(true); 
        khachngan_id.setDisable(true);
        khachngan_tenngdaidien.setDisable(true);
    }
    
    public void KhachNganXuat(ActionEvent event) {
        try {
            File file = new File("KhachNgan.txt");
            FileWriter writer = new FileWriter(file);

            // Extract data from TableView
            // ... (Implement logic to extract and format data)

            // Write data to text file
            for (KhachData khach : khachngan_tableview.getItems()) {
                String formattedRow = String.valueOf(khach.getKhachidProperty().getValue()) 
                        + ", " + String.valueOf(khach.getHotenProperty().getValue())
                        + ", " + String.valueOf(khach.getGioitinhProperty().getValue())
                        + ", " + String.valueOf(khach.getNgaysinhProperty().getValue())
                        + ", " + String.valueOf(khach.getSdtProperty().getValue())
                        + ", " + String.valueOf(khach.getCccdProperty().getValue())
                        ;
                writer.write(formattedRow);
                writer.write("\n");
            }

            writer.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText(null);
                        alert.setContentText("Đã xuất sang file 'KhachNgan.txt'");
                        alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public ObservableList<KhachData> KhachNganHanListData() {

        ObservableList<KhachData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM KHACHNGANHAN";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            KhachData khachnh;
            
            // Định dạng cho ngày/tháng/năm

            while (result.next()) {
                LocalDate ngaySinh = result.getDate("NGAYSINH").toLocalDate();
                LocalDate ngayBatDau = result.getDate("NGAYBATDAU").toLocalDate();
                LocalDate ngayKetThuc = result.getDate("NGAYKETTHUC").toLocalDate();

                // Format ngày/tháng/năm
                String formattedNgaySinh = ngaySinh.format(formatter);
                String formattedNgayBatDau = ngayBatDau.format(formatter);
                String formattedNgayKetThuc = ngayKetThuc.format(formatter);

                khachnh = new KhachData(result.getString("MAKT"),
                        result.getString("HOTEN"), result.getString("GIOITINH"),
                        formattedNgaySinh, result.getString("SDT"),
                        result.getString("CCCD"), result.getString("EMAIL"),
                        result.getString("MADD"), formattedNgayBatDau, 
                        formattedNgayKetThuc,result.getString("TRANGTHAI"));
                listData.add(khachnh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<KhachData> KhachNganHanList;

    public void KhachNganHanShowListData() {
        KhachNganHanList = KhachNganHanListData();
        
        khachngan_col_id.setCellValueFactory(cellData -> cellData.getValue().getKhachidProperty());
        khachngan_col_ten.setCellValueFactory(cellData -> cellData.getValue().getHotenProperty());
        khachngan_col_gioitinh.setCellValueFactory(cellData -> cellData.getValue().getGioitinhProperty());
        khachngan_col_ngs.setCellValueFactory(cellData -> cellData.getValue().getNgaysinhProperty());
        khachngan_col_sdt.setCellValueFactory(cellData -> cellData.getValue().getSdtProperty());
        khachngan_col_cccd.setCellValueFactory(cellData -> cellData.getValue().getCccdProperty());
        khachngan_col_mail.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
        khachngan_col_ngbd.setCellValueFactory(cellData -> cellData.getValue().getNgaybatdauProperty());
        khachngan_col_ngkt.setCellValueFactory(cellData -> cellData.getValue().getNgayketthucProperty());
        khachngan_col_ngdaidien.setCellValueFactory(cellData -> cellData.getValue().getDaidienidProperty());
        khachngan_col_trangthai.setCellValueFactory(cellData -> cellData.getValue().getTrangthaiProperty());

        
        khachngan_tableview.setItems(KhachNganHanList);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        KhachNganHanShowListData();
            //KhachNganSearch();
            
            KhachNganGioiTinh();
            KhachNganTrangthai();
            
            DoiMaDD();
            
            khachngan_duyetbtn.setDisable(true); 
            khachngan_xoabtn.setDisable(true); 
            //khachngan_capnhatbtn.setDisable(true); 
            //khachngan_id.setDisable(false);
            //khachngan_trangthai.setDisable(false);
            khachngan_tenngdaidien.setDisable(true);
        // TODO
    }    
    
}
