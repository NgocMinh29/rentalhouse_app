/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import model.KhachData;
import connection.database;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * FXML Controller class
 *
 * @author user
 */
public class KhachthueController implements Initializable {
    
    @FXML
    private Label khach_cccd_sai;
     
    @FXML
    private Label khach_ten_sai;

    @FXML
    private Label khach_sdt_sai;

    @FXML
    private Label khach_mail_sai;

    
    @FXML
    private Button khach_capnhatbtn;

    @FXML
    private TextField khach_cccd;

    @FXML
    private TableColumn<KhachData, String> khach_col_cccd;

//    @FXML
//    private TableColumn<KhachData, String> khach_col_ngdaidien;
    
    @FXML
    private TableColumn<KhachData, String> khach_col_ngbd;

    @FXML
    private TableColumn<KhachData, String> khach_col_ngkt;


    @FXML
    private TableColumn<KhachData, String> khach_col_gioitinh;

    @FXML
    private TableColumn<KhachData, String> khach_col_id;

    @FXML
    private TableColumn<KhachData, String> khach_col_mail;

    @FXML
    private TableColumn<KhachData, String> khach_col_ngs;

    @FXML
    private TableColumn<KhachData, String> khach_col_sdt;

    @FXML
    private TableColumn<KhachData, String> khach_col_ten;

//    @FXML
//    private TextField khach_mangdaidien;
//    @FXML
//    private TextField khach_tenngdaidien;

    @FXML
    private AnchorPane khach_form;

    @FXML
    private ComboBox<?> khach_gioitinh;

    @FXML
    private TextField khach_id;

    @FXML
    private Button khach_lammoibtn;

    @FXML
    private TextField khach_mail;

    @FXML
    private DatePicker khach_ngs;
    
    @FXML
    private DatePicker khach_ngbd;
    
    @FXML
    private DatePicker khach_ngkt;

    @FXML
    private TextField khach_sdt;

    @FXML
    private TextField khach_search;

    @FXML
    private TableView<KhachData> khach_tableview;

    @FXML
    private TextField khach_ten;

    @FXML
    private Button khach_thembtn;
    
    @FXML
    private DatePicker khach_searchngayo;
    
     @FXML
    private Button khach_xuatbtn;
     
      @FXML
    private Button khach_timbtn;

    @FXML
    private Button khach_xoabtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private CallableStatement caSt;
    
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    public void KhachGioiTinh() {
        ObservableList listData = FXCollections.observableArrayList("Nam", "Nữ");
        khach_gioitinh.setItems(listData);
        
    }
    
    
    
    private static final Pattern PHONE_REGEX = Pattern.compile("^\\+(\\d{1,15})\\d+$");

    public static boolean isValidPhoneNumberRegex(String phoneNumberString) {
        if (phoneNumberString.length() != 12) return false;
        return PHONE_REGEX.matcher(phoneNumberString).matches();
    }
    
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

    public static boolean isValidEmail(String emailString) {
        return EMAIL_REGEX.matcher(emailString).matches();
    }
    
    private static final Pattern CCCD_REGEX = Pattern.compile("^([0-9]{10}|[0-9]{12}|[0-9]{13})$");

    public static boolean isValidCCCD(String cccdString) {
        //if (cccdString.length() != 12) return false;
        return CCCD_REGEX.matcher(cccdString).matches();
    }
    
//    private static final Pattern NAME_REGEX = Pattern.compile("^[a-zA-Zàáâäãåèéêëìíîïòóôöõùúûüỳýỹññ]{2,}( [a-zA-Zàáâäãåèéêëìíîïòóôöõùúûüỳýỹññ]{2,})+$");
//
//    public static boolean isValidName(String nameString) {
//        if (nameString == null || nameString.trim().isEmpty()) {
//            return false; // Check for empty or null input
//        }
//
//        String[] nameParts = nameString.trim().split(" ");
//        if (nameParts.length < 2) {
//            return false; // Name should have at least two parts (first and last name)
//        }
//
//        for (String part : nameParts) {
//            if (!NAME_REGEX.matcher(part).matches()) {
//                return false; // Each part should match the name pattern
//            }
//        }
//
//        return true;
//    }
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáảạâấầẩẫậãăắằặẳẵèéẻẹẽêếìíòóôõùúýềểễệỉĩịỏọốồổộơớờởỡợủụũưửừứữựỳỹỷỵ ]{2,}");
    public static boolean isValidName(String name) { 
      if (name == null || name.isEmpty()) {
        return false;
      }

      return VALID_NAME_PATTERN.matcher(name).matches();
    }
    
    public void KhachThueDoiSdt(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        khach_sdt.textProperty().addListener((Observable, oldValue, newValue) -> {
        if (!isValidPhoneNumberRegex(newValue)) {
                khach_sdt.setStyle("-fx-border-color: linear-gradient(to bottom right, #ff0000, #d20c0c)");
                khach_sdt_sai.setVisible(true);
            }
        else {
            khach_sdt.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
            khach_sdt_sai.setVisible(false);
        }
        });
    }
    
    public void KhachThueDoiTen(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        khach_ten.textProperty().addListener((Observable, oldValue, newValue) -> {
        if (!isValidName(newValue)) {
                khach_ten.setStyle("-fx-border-color: linear-gradient(to bottom right, #ff0000, #d20c0c)");
                khach_ten_sai.setVisible(true);
            }
        else {
            khach_ten.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
            khach_ten_sai.setVisible(false);
        }
        });
    }
    
    public void KhachThueDoiCccd(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        khach_cccd.textProperty().addListener((Observable, oldValue, newValue) -> {
        if (!isValidCCCD(newValue)) {
                khach_cccd.setStyle("-fx-border-color: linear-gradient(to bottom right, #ff0000, #d20c0c)");
                khach_cccd_sai.setVisible(true);
            }
        else {
            khach_cccd.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
            khach_cccd_sai.setVisible(false);
        }
        });
    }
    
    public void KhachThueDoiMail(){
        //hoadon_maphong.textProperty().addListener((Observable, oldValue, newValue) -> {
        khach_mail.textProperty().addListener((Observable, oldValue, newValue) -> {
        if (!isValidEmail(newValue)) {
                khach_mail.setStyle("-fx-border-color: linear-gradient(to bottom right, #ff0000, #d20c0c)");
                khach_mail_sai.setVisible(true);
            }
        else {
            khach_mail.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
            khach_mail_sai.setVisible(false);
        }
        });
    }
    
    public void TimKhach(ActionEvent event){
       FilteredList<KhachData> filter = new FilteredList<>(KhachThueList, e -> true);
       filter.setPredicate((KhachData PrediateKhachData) -> {
           boolean ng = false, search = false;
           String searchKey = khach_search.getText().toLowerCase();
           
            
            
           LocalDate ngaytim = khach_searchngayo.getValue();
           LocalDate ngbd = LocalDate.parse(String.valueOf(PrediateKhachData.getNgaybatdauProperty().getValue()), formatter);
           LocalDate ngkt = LocalDate.parse(String.valueOf(PrediateKhachData.getNgayketthucProperty().getValue()), formatter);
           if ( khach_searchngayo.getValue() == null || (ngaytim.isAfter(ngbd) && ngaytim.isBefore(ngkt)) || ngaytim.equals(ngbd) ) 
                    ng = true;
           if (khach_search.getText().isEmpty()) {
                    search = true;
                }
           
           if ( (String.valueOf(PrediateKhachData.getKhachidProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachData.getHotenProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachData.getGioitinhProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachData.getNgaysinhProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            } else if ((String.valueOf(PrediateKhachData.getSdtProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            } else if ( (String.valueOf(PrediateKhachData.getCccdProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            }else if ( (String.valueOf(PrediateKhachData.getEmailProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            }else if ((String.valueOf(PrediateKhachData.getNgaybatdauProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            }else if ((String.valueOf(PrediateKhachData.getNgayketthucProperty().getValue()).toLowerCase().contains(searchKey) || search )
                    && ng) {
                return true;
            }else {
                return false;
            }
           
       });
       SortedList<KhachData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(khach_tableview.comparatorProperty());

        khach_tableview.setItems(sortList);
       
   }
    
    public void KhachThueClear() { //sua luon setdisable cua may texfield

        khach_id.setText("");
        khach_ten.setText("");
        khach_gioitinh.getSelectionModel().clearSelection();
        //khachngan_trangthai.getSelectionModel().clearSelection();
        khach_ngs.setValue(null);
        khach_ngbd.setValue(null);
        khach_ngkt.setValue(null);
        khach_sdt.setText("+84");
        khach_cccd.setText("");
        khach_mail.setText("");
        khach_ngbd.setDisable(true);
        khach_ngkt.setDisable(true);
//        khach_mangdaidien.setText("");
//        khach_tenngdaidien.setText("");
        khach_search.setText("");
        
        KhachThueShowListData();
        KhachGioiTinh() ;
        //DoiMaDD();
        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
        khach_thembtn.setDisable(false); 
        khach_xoabtn.setDisable(true); 
        khach_capnhatbtn.setDisable(true); 
        
        khach_ten.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
        khach_ten_sai.setVisible(false);
        khach_mail.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
        khach_mail_sai.setVisible(false);
        khach_cccd.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
        khach_cccd_sai.setVisible(false);
        khach_sdt.setStyle("-fx-border-color: linear-gradient(to bottom right, #17526b, #4397cc)");
        khach_sdt_sai.setVisible(false);
        //khach_tenngdaidien.setDisable(true);
    }
    
    public void KhachThueThem(ActionEvent event) {
        
//         String sql = "INSERT INTO KHACHTHUE (MAKT,HOTEN,GIOITINH,NGAYSINH,SDT,CCCD,EMAIL,NGAYBATDAU,NGAYKETTHUC) "
//                + "VALUES(?,?,?,?,?,?,?,?,?)";
//         String sql = "INSERT INTO KHACHTHUE (MAKT,HOTEN,GIOITINH,NGAYSINH,SDT,CCCD,EMAIL) "
//                + "VALUES(?,?,?,?,?,?,?)";
//        connect = database.getConn();

        try {
            Alert alert;

            if (khach_ten.getText().isEmpty()
                    || khach_gioitinh.getSelectionModel().getSelectedItem() == null
                    || khach_ngs.getValue()==null
                    
                    ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền vào các ô (*)");
                alert.showAndWait();

            } else if (!isValidName(khach_ten.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Thông báo lỗi");
                                alert.setHeaderText(null);
                                alert.setContentText("Họ tên không hợp lệ!");
                                alert.showAndWait();
            } else if (!"+84".equals(khach_sdt.getText()) && !isValidPhoneNumberRegex(khach_sdt.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Thông báo lỗi");
                        alert.setHeaderText(null);
                        alert.setContentText("Số điện thoại không hợp lệ!");
                        alert.showAndWait();
            } else if (!"".equals(khach_mail.getText()) && !isValidEmail(khach_mail.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Thông báo lỗi");
                        alert.setHeaderText(null);
                        alert.setContentText("Email không hợp lệ!");
                        alert.showAndWait();
            } else if (!"".equals(khach_cccd.getText()) && !isValidCCCD(khach_cccd.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Thông báo lỗi");
                        alert.setHeaderText(null);
                        alert.setContentText("Căn cước công dân không hợp lệ!");
                        alert.showAndWait();
            } else {
                
                
                    // CHECK IF THE FLOWER ID IS ALREADY EXIST
                    String checkData = "SELECT MAKT FROM KHACHTHUE WHERE MAKT = '"
                            + khach_id.getText() + "'";

                    statement = connect.createStatement();
                    result = statement.executeQuery(checkData);

                    if (result.next()) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Thông báo lỗi");
                        alert.setHeaderText(null);
                        alert.setContentText("Mã khách: " + khach_id.getText() + " đã tồn tại!");
                        alert.showAndWait();
                    } else 
                    {
//                        prepare = connect.prepareStatement(sql);
//                        prepare.setString(1, khach_id.getText());
//                        prepare.setString(2, khach_ten.getText());
//                        prepare.setString(3, (String) khach_gioitinh.getSelectionModel().getSelectedItem());
//
                        LocalDate ngaySinh=khach_ngs.getValue();
                        java.sql.Date sqlNgaySinh = java.sql.Date.valueOf(ngaySinh);
//                        prepare.setDate(4, sqlNgaySinh);
//
//                        prepare.setString(5, khach_sdt.getText());
//                        prepare.setString(6, khach_cccd.getText());
//                        prepare.setString(7, khach_mail.getText());  
//                        
//
//                        prepare.executeUpdate();
                        
                        String strCall = "{call ThemKhachThue(?,?,?,?,?,?)}";
                        caSt = connect.prepareCall(strCall);
                 
                        caSt.setString(1, khach_ten.getText());
  
                        caSt.setString(2, (String) khach_gioitinh.getSelectionModel().getSelectedItem());
    //                    
                        caSt.setDate(3, sqlNgaySinh);
                        if ("+84".equals(khach_sdt.getText())) khach_sdt.setText("");
                        caSt.setString(4, khach_sdt.getText());
                        if ("".equals(khach_cccd.getText())) khach_cccd.setText("");
                        caSt.setString(5, khach_cccd.getText());
                        if ("".equals(khach_mail.getText())) khach_mail.setText("");
                        caSt.setString(6, khach_mail.getText());
                        
                        caSt.execute();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText(null);
                        alert.setContentText("Thêm thành công!");
                        alert.showAndWait();

                        // SHOW UPDATED TABLEVIEW
                        //KhachNganHanShowListData();

                        // CLEAR ALL FIELDS
                        KhachThueClear();
                    }
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    public void KhachSelect() {  //sau khi sửa bên textfiled thì không đc xóa
        KhachData khang = khach_tableview.getSelectionModel().getSelectedItem();
        int num = khach_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        khach_id.setText(String.valueOf(khang.getKhachidProperty().getValue()));
        khach_ten.setText(String.valueOf(khang.getHotenProperty().getValue()));
        khach_sdt.setText(String.valueOf(khang.getSdtProperty().getValue()));
        khach_cccd.setText(String.valueOf(khang.getCccdProperty().getValue()));
        khach_mail.setText(String.valueOf(khang.getEmailProperty().getValue()));
        int index2 = khach_gioitinh.getItems().indexOf(String.valueOf(khang.getGioitinhProperty().getValue()));
        if (index2 != -1) {
            khach_gioitinh.getSelectionModel().select(index2);
        }
        LocalDate selectedDate = LocalDate.parse(String.valueOf(khang.getNgaysinhProperty().getValue()), formatter);
        khach_ngs.setValue(selectedDate);
        LocalDate selectedDate2 = LocalDate.parse(String.valueOf(khang.getNgaybatdauProperty().getValue()), formatter);
        khach_ngbd.setValue(selectedDate2);
        LocalDate selectedDate3 = LocalDate.parse(String.valueOf(khang.getNgayketthucProperty().getValue()), formatter);
        khach_ngkt.setValue(selectedDate3);
        khach_ngbd.setDisable(false);
        khach_ngkt.setDisable(false);
        khach_capnhatbtn.setDisable(false); 
        khach_xoabtn.setDisable(false); 
       
   }
    
    public void KhachThueXoa(ActionEvent ev) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Thông báo xác nhận");
        alert.setHeaderText(null);
        alert.setContentText("Bạn có chắc muốn xóa khách thuê này?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(ButtonType.OK)) {
            String strCall = "{call  XOA_KHACH (?)}";
            
            try{
                caSt = connect.prepareCall(strCall);
                caSt.setString(1, khach_id.getText());
                //caSt.setString(2, themnguoi_makt.getText());
                caSt.execute();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Xóa khách thuê thành công!");
                alert.showAndWait();

                KhachThueClear();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
    }
    
    public void KhachCapNhat(ActionEvent event) {
        
        String sql = "UPDATE KHACHTHUE"
                + " SET HOTEN = '" + khach_ten.getText() 
                + "', GIOITINH = '" + khach_gioitinh.getSelectionModel().getSelectedItem() 
                + "', NGAYSINH = ?"
                + ", SDT = '" + khach_sdt.getText() 
                + "', CCCD = '" + khach_cccd.getText() 
                + "', EMAIL = '" + khach_mail.getText() 
                + "', NGAYBATDAU = ?"  
                + ", NGAYKETTHUC = ?" 
                + " where MAKT = '" + khach_id.getText() + "'";

        connect = database.getConn();

        try {
            Alert alert;
            {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Thông báo xác nhận");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc muốn cập nhật khách này?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    LocalDate ngaySinh=khach_ngs.getValue();
                    java.sql.Date sqlNgaySinh = java.sql.Date.valueOf(ngaySinh);
                    LocalDate ngaybd=khach_ngbd.getValue();
                    java.sql.Date sqlNgaybd = java.sql.Date.valueOf(ngaybd);
                    LocalDate ngaykt=khach_ngkt.getValue();
                    java.sql.Date sqlNgaykt = java.sql.Date.valueOf(ngaykt);
                    prepare = connect.prepareStatement(sql);
                    prepare.setDate(1, sqlNgaySinh);
                    prepare.setDate(2, sqlNgaybd);
                    prepare.setDate(3, sqlNgaykt);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("Cập nhật khách thuê thành công!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    

                    // CLEAR ALL FIELDS
                    KhachThueClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public ObservableList<KhachData> KhachThueListData() {

        ObservableList<KhachData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM KHACHTHUE";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            KhachData khachthue;
            
            // Định dạng cho ngày/tháng/năm

            while (result.next()) {
                String formattedNgayBatDau;
                String formattedNgayKetThuc;
                LocalDate ngaySinh = result.getDate("NGAYSINH").toLocalDate();
                String formattedNgaySinh = ngaySinh.format(formatter);
                if(result.getDate("NGAYBATDAU")!=null){
                    LocalDate ngayBatDau = result.getDate("NGAYBATDAU").toLocalDate();
                    formattedNgayBatDau = ngayBatDau.format(formatter);
                } else{
                    formattedNgayBatDau = "";
                }
                if( result.getDate("NGAYKETTHUC")!=null){
                    
                    LocalDate ngayKetThuc = result.getDate("NGAYKETTHUC").toLocalDate();
                    formattedNgayKetThuc = ngayKetThuc.format(formatter);
                }else {
                    formattedNgayKetThuc = "";

                }
                 
                

                khachthue = new KhachData(result.getString("MAKT"),
                        result.getString("HOTEN"), result.getString("GIOITINH"),
                        formattedNgaySinh, result.getString("SDT"),
                        result.getString("CCCD"), result.getString("EMAIL"),
                         formattedNgayBatDau,formattedNgayKetThuc);
                listData.add(khachthue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<KhachData> KhachThueList;

    public void KhachThueShowListData() {
        KhachThueList = KhachThueListData();
        
        khach_col_id.setCellValueFactory(cellData -> cellData.getValue().getKhachidProperty());
        khach_col_ten.setCellValueFactory(cellData -> cellData.getValue().getHotenProperty());
        khach_col_gioitinh.setCellValueFactory(cellData -> cellData.getValue().getGioitinhProperty());
        khach_col_ngs.setCellValueFactory(cellData -> cellData.getValue().getNgaysinhProperty());
        khach_col_sdt.setCellValueFactory(cellData -> cellData.getValue().getSdtProperty());
        khach_col_cccd.setCellValueFactory(cellData -> cellData.getValue().getCccdProperty());
        khach_col_mail.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
        khach_col_ngbd.setCellValueFactory(cellData -> cellData.getValue().getNgaybatdauProperty());
        khach_col_ngkt.setCellValueFactory(cellData -> cellData.getValue().getNgayketthucProperty());
        //khach_col_ngdaidien.setCellValueFactory(cellData -> cellData.getValue().getDaidienidProperty());
        
        khach_tableview.setItems(KhachThueList);
    }
    
            private ObservableList<KhachData> KhachList;

    public void KhachXuat(ActionEvent event) {
        KhachList = khach_tableview.getItems();
        
        try {
            // Kiểm tra nếu danh sách rỗng
            if (KhachList == null || KhachList.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Không có dữ liệu để xuất");
                alert.showAndWait();
                return;
            }
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Khách thuê");
            XSSFRow row = sheet.createRow(1);
            Cell cell;

            String[] headers = {"MAKT", "Họ tên", "Giới tính", "Ngày sinh", "SĐT", "CCCD", "Email", "Ngày bắt đầu", "Ngày kết thúc"};

            for (int i = 0; i < headers.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(headers[i]);
            }

            for (int i = 0; i < KhachList.size(); i++) {
                KhachData khach = KhachList.get(i);
                row = sheet.createRow(i + 2);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(khach.getKhachidProperty().get());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(khach.getHotenProperty().get());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(khach.getGioitinhProperty().get());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(khach.getNgaysinhProperty().get());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(khach.getSdtProperty().get());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(khach.getCccdProperty().get());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(khach.getEmailProperty().get());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(khach.getNgaybatdauProperty().get());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(khach.getNgayketthucProperty().get());

            }

            File file = new File("Danh sách khách.xlsx");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Xuất file thành công");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        khach_capnhatbtn.setDisable(true); 
        khach_xoabtn.setDisable(true);
        khach_ngbd.setDisable(true);
        khach_ngkt.setDisable(true);
        KhachThueShowListData();
        // TODO
        KhachThueClear();
        KhachThueDoiTen();
        KhachThueDoiSdt();
        KhachThueDoiCccd();
        KhachThueDoiMail();     
    }    
    
}
