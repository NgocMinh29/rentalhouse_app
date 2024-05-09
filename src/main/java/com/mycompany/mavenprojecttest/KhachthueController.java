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
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class KhachthueController implements Initializable {
    @FXML
    private Button khach_capnhatbtn;

    @FXML
    private TextField khach_cccd;

    @FXML
    private TableColumn<KhachData, String> khach_col_cccd;

    @FXML
    private TableColumn<KhachData, String> khach_col_ngdaidien;
    
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

    @FXML
    private TextField khach_mangdaidien;
    @FXML
    private TextField khach_tenngdaidien;

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
    private Button khach_xoabtn;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();
    
    public void KhachGioiTinh() {
        ObservableList listData = FXCollections.observableArrayList("Nam", "Nu");
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
        if (cccdString.length() != 12) return false;
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
        khach_mangdaidien.setText("");
        khach_tenngdaidien.setText("");
        khach_search.setText("");
        
        KhachThueShowListData();
        KhachGioiTinh() ;
        //DoiMaDD();
        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
        khach_thembtn.setDisable(false); 
        khach_xoabtn.setDisable(true); 
        khach_capnhatbtn.setDisable(true); 
        khach_id.setDisable(false);
        //khach_tenngdaidien.setDisable(true);
    }
    
    public void KhachThueThem(ActionEvent event) {
        
         String sql = "INSERT INTO KHACHTHUE (MAKT,HOTEN,GIOITINH,NGAYSINH,SDT,CCCD,EMAIL,MADD,NGAYBATDAU,NGAYKETTHUC) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        connect = database.getConn();

        try {
            Alert alert;

            if (khach_id.getText().isEmpty()
                    || khach_ten.getText().isEmpty()
                    || khach_gioitinh.getSelectionModel().getSelectedItem() == null
                    || khach_ngs.getValue()==null
                    || khach_ngbd.getValue()==null
                    || khach_ngkt.getValue()==null
                    
                    ) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền vào các ô có *");
                alert.showAndWait();

            } else if (!isValidName(khach_ten.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Thông báo lỗi");
                                alert.setHeaderText(null);
                                alert.setContentText("Họ tên không hợp lệ!");
                                alert.showAndWait();
            } else if (!isValidPhoneNumberRegex(khach_sdt.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Thông báo lỗi");
                        alert.setHeaderText(null);
                        alert.setContentText("Số điện thoại không hợp lệ!");
                        alert.showAndWait();
            } else if (!isValidEmail(khach_mail.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Thông báo lỗi");
                        alert.setHeaderText(null);
                        alert.setContentText("Email không hợp lệ!");
                        alert.showAndWait();
            } else if (!isValidCCCD(khach_cccd.getText())) {
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
                        prepare = connect.prepareStatement(sql);
                        prepare.setString(1, khach_id.getText());
                        prepare.setString(2, khach_ten.getText());
                        prepare.setString(3, (String) khach_gioitinh.getSelectionModel().getSelectedItem());

                        LocalDate ngaySinh=khach_ngs.getValue();
                        java.sql.Date sqlNgaySinh = java.sql.Date.valueOf(ngaySinh);
                        prepare.setDate(4, sqlNgaySinh);

                        prepare.setString(5, khach_sdt.getText());
                        prepare.setString(6, khach_cccd.getText());
                        prepare.setString(7, khach_mail.getText());  
                        prepare.setString(8, khach_mangdaidien.getText());

                        LocalDate ngayBatdau=khach_ngbd.getValue();
                        java.sql.Date sqlNgayBatdau = java.sql.Date.valueOf(ngayBatdau);
                        prepare.setDate(9, sqlNgayBatdau);

                        LocalDate ngayKetthuc=khach_ngkt.getValue();
                        java.sql.Date sqlNgayKetthuc = java.sql.Date.valueOf(ngayKetthuc);
                        prepare.setDate(10, sqlNgayKetthuc);
                        //prepare.setString(11, "Chờ duyệt");

                        prepare.executeUpdate();

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
                LocalDate ngaySinh = result.getDate("NGAYSINH").toLocalDate();
                LocalDate ngayBatDau = result.getDate("NGAYBATDAU").toLocalDate();
                LocalDate ngayKetThuc = result.getDate("NGAYKETTHUC").toLocalDate();

                // Format ngày/tháng/năm
                String formattedNgaySinh = ngaySinh.format(formatter);
                String formattedNgayBatDau = ngayBatDau.format(formatter);
                String formattedNgayKetThuc = ngayKetThuc.format(formatter);

                khachthue = new KhachData(result.getString("MAKT"),
                        result.getString("HOTEN"), result.getString("GIOITINH"),
                        formattedNgaySinh, result.getString("SDT"),
                        result.getString("CCCD"), result.getString("EMAIL"),
                        result.getString("MADD"), formattedNgayBatDau, 
                        formattedNgayKetThuc);
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
        khach_col_ngdaidien.setCellValueFactory(cellData -> cellData.getValue().getDaidienidProperty());
        
        khach_tableview.setItems(KhachThueList);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        KhachThueClear();
    }    
    
}
