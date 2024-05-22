package com.mycompany.userapp;

import model.LoginData;
import java.time.format.DateTimeFormatter;
import connection.database;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Pattern;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
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
import org.controlsfx.control.CheckComboBox;

public class SecondaryController implements Initializable {

//    private CallableStatement caSt;
    private double x, y;

    @FXML 
    private Button caidat_btn;
    
    @FXML 
    private AnchorPane caidat_form;
    
    @FXML
    private Label page_label;

    @FXML
    private Button minimize;

    @FXML
    private Button close;

    @FXML
    private Button Minimize;

    @FXML
    private Button dangxuat_btn;

    @FXML
    private AnchorPane yeucaudv_form;



//    @FXML
//    private TableView<?> dichvu_tableview;
    @FXML
    private Button dv_btn;

//    @FXML
//    private TableColumn<?, ?> dv_col_ngaydien;
//
//    @FXML
//    private TableColumn<?, ?> dv_col_tendv;
//
//    @FXML
//    private TableColumn<?, ?> dv_col_tinhtrang;
//
//    @FXML
//    private CheckBox dv_cua_checkbox;
//
//    @FXML
//    private ComboBox<?> yeucaudv_phong;
//
//    @FXML
//    private Button dv_guiyeucauBtn;
//
//    @FXML
//    private CheckBox dv_ongnuoc_checkbox;
//
//    @FXML
//    private CheckBox dv_toilet_checkbox;
//
//    @FXML
//    private CheckBox dv_voisen_checkbox;
    @FXML
    private Button hoadon_btn;

//    @FXML
//    private Label hoadon_cthd_dongia;
//
    @FXML
    private AnchorPane hoadon_form;
//
//    @FXML
//    private Label hoadon_hd_conno;
//
//    @FXML
//    private ComboBox<?> hoadon_hd_kidong;
//
//    @FXML
//    private ComboBox<?> hoadon_hd_tenphong;
//
//    @FXML
//    private Label hoadon_hd_tongtien;
//
//    @FXML
//    private Label hoadon_hd_trangthai;

    @FXML
    private Button khachnganhan_btn;
//
//    @FXML
//    private TextField khachnganhan_cccd;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_cccd;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_email;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_gioitinh;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_hoten;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_hotenDD;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_maDD;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_maKT;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_ngaysinh;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_sdt;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_ngaybatdau;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_ngayketthuc;
//
//    @FXML
//    private TableColumn<KhachData, String> khachnganhan_col_trangthai;
//
//    @FXML
//    private DatePicker khachnganhan_ngaybatdau;
//
//    @FXML
//    private DatePicker khachnganhan_ngayketthuc;
//
//    @FXML
//    private TextField khachnganhan_email;
//
    @FXML
    private AnchorPane khachnganhan_form;
//
//    @FXML
//    private ComboBox<?> khachnganhan_gioitinh;
//
//    @FXML
//    private Button khachnganhan_guiyeucauBtn;
//
//    @FXML
//    private TextField khachnganhan_hoten;
//
//    @FXML
//    private TextField khachnganhan_hotenDD;
//
//    @FXML
//    private TextField khachnganhan_maDD;
//
//    @FXML
//    private TextField khachnganhan_maKT;
//
//    @FXML
//    private DatePicker khachnganhan_ngaysinh;
//
//    @FXML
//    private TextField khachnganhan_sdt;
//
//    @FXML
//    private TableView<KhachData> khachnganhan_tableview;

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane trangchu_form;

    @FXML
    private Button trangchu_btn;

    @FXML
    private Label trangchu_cccd;

    @FXML
    private Label trangchu_diachi;

    @FXML
    private Label trangchu_email;

    @FXML
    private Label trangchu_gioitinh;

    @FXML
    private Label trangchu_hoten;

    @FXML
    private Label trangchu_maKT;

    @FXML
    private Label trangchu_hotenDD;

    @FXML
    private Label trangchu_ngaybd;

    @FXML
    private Label trangchu_ngaykt;

    @FXML
    private Label trangchu_ngaysinh;

    @FXML
    private Label trangchu_sdt;

    @FXML
    private Label trangchu_sldkkhachnganhan;

    @FXML
    private Label trangchu_slhdchuatt;

    @FXML
    private Label trangchu_slyeucaudv;

    @FXML
    private CheckComboBox checkComboBox;

    private Connection connect = database.getConn();
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void close(ActionEvent event) {
        System.exit(0);
    }

    public void minimize(ActionEvent event) {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void swithForm(ActionEvent event) {

        if (event.getSource() == trangchu_btn) {
            trangchu_form.setVisible(true);
            yeucaudv_form.setVisible(false);
            khachnganhan_form.setVisible(false);
            hoadon_form.setVisible(false);
            caidat_form.setVisible(false);

            trangchu_hoten();

            page_label.setText("TRANG CHỦ");
        } else if (event.getSource() == dv_btn) {
            trangchu_form.setVisible(false);
            yeucaudv_form.setVisible(true);
            khachnganhan_form.setVisible(false);
            hoadon_form.setVisible(false);
            caidat_form.setVisible(false);

            trangchu_slyeucaudv();

            page_label.setText("YÊU CẦU DỊCH VỤ");
        } else if (event.getSource() == khachnganhan_btn) {
            trangchu_form.setVisible(false);
            yeucaudv_form.setVisible(false);
            khachnganhan_form.setVisible(true);
            hoadon_form.setVisible(false);
            caidat_form.setVisible(false);

//            khachnganhan_sdt.setText("+84");
//
//            khachnganhan_hotenDD.setDisable(true);
//            KhachNganHanShowListData();
//            KhachNganHanGioiTinh();
//            khachnganhan_hotenDD();
//            khachnganhan_maDD();
            page_label.setText("ĐĂNG KÍ KHÁCH NGẮN HẠN");
        } else if (event.getSource() == hoadon_btn) {
            trangchu_form.setVisible(false);
            yeucaudv_form.setVisible(false);
            khachnganhan_form.setVisible(false);
            hoadon_form.setVisible(true);
            caidat_form.setVisible(false);

            page_label.setText("HÓA ĐƠN");
        } else if(event.getSource() == caidat_btn){
            trangchu_form.setVisible(false);
            yeucaudv_form.setVisible(false);
            khachnganhan_form.setVisible(false);
            hoadon_form.setVisible(false);
            caidat_form.setVisible(true);
            
            trangchu_slhdchuatt();
        }

    }

    public void trangchu_hotenDD() {
        String hotenDD = "select KT1.HOTEN\n"
                + "FROM KHACHTHUE KT1, HOPDONG HD, KHACHTHUE KT2, CTHOPDONG CTHD, TAIKHOAN TK\n"
                + "WHERE HD.MADD = KT1.MAKT AND KT2.MAKT = CTHD.MAKT AND CTHD.MHD=HD.MHD AND KT2.MAKT= TK.MAKT AND TENTAIKHOAN = ?";

        try {
            prepare = connect.prepareStatement(hotenDD);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                trangchu_hotenDD.setText(result.getString("HOTEN"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_hoten() {
        String hoten = "SELECT HOTEN FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        try {
            prepare = connect.prepareStatement(hoten);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                trangchu_hoten.setText(result.getString("HOTEN"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_cccd() {
        String cccd = "SELECT CCCD FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        try {
            prepare = connect.prepareStatement(cccd);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                trangchu_cccd.setText(result.getString("CCCD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_sdt() {
        String sdt = "SELECT SDT FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        try {
            prepare = connect.prepareStatement(sdt);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                trangchu_sdt.setText(result.getString("SDT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_email() {
        String email = "SELECT EMAIL FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        try {
            prepare = connect.prepareStatement(email);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                trangchu_email.setText(result.getString("EMAIL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_ngaysinh() {
        String ngaysinh = "SELECT NGAYSINH FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            prepare = connect.prepareStatement(ngaysinh);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                LocalDate ngaySinh = result.getDate("NGAYSINH").toLocalDate();
                String formattedNgaySinh = ngaySinh.format(formatter);
                trangchu_ngaysinh.setText(formattedNgaySinh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_ngaybatdau() {
        String ngaybatdau = "SELECT NGAYBATDAU FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            prepare = connect.prepareStatement(ngaybatdau);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                LocalDate ngayBatDau = result.getDate("NGAYBATDAU").toLocalDate();
                String formattedNgayBatDau = ngayBatDau.format(formatter);
                trangchu_ngaybd.setText(formattedNgayBatDau);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_ngayketthuc() {
        String ngayketthuc = "SELECT NGAYKETTHUC FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            prepare = connect.prepareStatement(ngayketthuc);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                LocalDate ngayKetThuc = result.getDate("NGAYKETTHUC").toLocalDate();
                String formattedNgayKetThuc = ngayKetThuc.format(formatter);
                trangchu_ngaykt.setText(formattedNgayKetThuc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_gioitinh() {
        String gioitinh = "SELECT GIOITINH FROM KHACHTHUE, TAIKHOAN WHERE KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN = ?";

        try {
            prepare = connect.prepareStatement(gioitinh);
            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
            result = prepare.executeQuery();

            if (result.next()) {
                trangchu_gioitinh.setText(result.getString("GIOITINH"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_slyeucaudv() {
        String demDv = "SELECT COUNT(*) AS SLYCDV FROM PHIEUDICHVU PDV, CTPDV, KHACHTHUE, TAIKHOAN, PHONG, CTHOPDONG CTHD, HOPDONG HD "
                + "WHERE CTHD.MAKT=KHACHTHUE.MAKT AND HD.MHD=CTHD.MHD AND HD.MAP=PHONG.MAP AND PDV.MAP=PHONG.MAP AND PDV.MPDV=CTPDV.MPDV AND CTPDV.TINHTRANG='Chưa hoàn thành' "
                + "AND KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN=? ";

        try {
            prepare = connect.prepareStatement(demDv);
            prepare.setString(1, LoginData.taikhoan);
            result = prepare.executeQuery();

            if (result.next()) {
                // Chuyển đổi giá trị int sang chuỗi trước khi gán vào setText()
                String soLuongYeuCauDV = String.valueOf(result.getInt("SLYCDV"));
                trangchu_slyeucaudv.setText(soLuongYeuCauDV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trangchu_slhdchuatt() {
        String demHd = "SELECT COUNT(*) AS SLHD FROM HOADON HD, KHACHTHUE, TAIKHOAN, PHONG, CTHOPDONG CTHD, HOPDONG  "
                + "WHERE CTHD.MAKT=KHACHTHUE.MAKT AND HOPDONG.MHD=CTHD.MHD AND HOPDONG.MAP=PHONG.MAP AND HD.TRANGTHAI='Chưa thanh toán' "
                + " AND HD.MAP=PHONG.MAP"
                + " AND KHACHTHUE.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN=?";

        try {
            prepare = connect.prepareStatement(demHd);
            prepare.setString(1, LoginData.taikhoan);
            result = prepare.executeQuery();

            if (result.next()) {
                // Chuyển đổi giá trị int sang chuỗi trước khi gán vào setText()
                String soLuongHd = String.valueOf(result.getInt("SLHD"));
                trangchu_slhdchuatt.setText(soLuongHd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void khachnganhan_hotenDD() {
//        String hotenDD = "select KHACHTHUE.HOTEN\n"
//                + "FROM KHACHTHUE, TAIKHOAN TK\n"
//                + "WHERE KHACHTHUE.MAKT = TK.MAKT AND TENTAIKHOAN = ?";
//
//
//        try {
//            prepare = connect.prepareStatement(hotenDD);
//            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
//            result = prepare.executeQuery();
//
//            if (result.next()) {
//                khachnganhan_hotenDD.setText(result.getString("HOTEN"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void khachnganhan_maDD() {
//        String maDD = "select KHACHTHUE.MAKT\n"
//                + "FROM KHACHTHUE, TAIKHOAN TK\n"
//                + "WHERE KHACHTHUE.MAKT = TK.MAKT AND TENTAIKHOAN = ?";
//
//
//        try {
//            prepare = connect.prepareStatement(maDD);
//            prepare.setString(1, LoginData.taikhoan); // Sử dụng giá trị từ LoginData.taikhoan
//            result = prepare.executeQuery();
//
//            if (result.next()) {
//                khachnganhan_maDD.setText(result.getString("MAKT"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static final Pattern PHONE_REGEX = Pattern.compile("^\\+(\\d{1,15})\\d+$");
//
//    public static boolean isValidPhoneNumberRegex(String phoneNumberString) {
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
//        return CCCD_REGEX.matcher(cccdString).matches();
//    }
//
//    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáảạâấầẩẫậãăắằặẳẵèéẻẹẽêếìíòóôõùúýềểễệỉĩịỏọốồổộơớờởỡợủụũưửừứữựỳỹỷỵ ]{2,}");
//
//    public static boolean isValidName(String name) {
//        if (name == null || name.isEmpty()) {
//            return false;
//        }
//
//        return VALID_NAME_PATTERN.matcher(name).matches();
//    }
//
//    public void KhachNganHan_Guiyeucau(ActionEvent event) {
//
////        String sql = "INSERT INTO KHACHNGANHAN (MAKT,HOTEN,GIOITINH,NGAYSINH,SDT,CCCD,EMAIL,NGAYBATDAU,NGAYKETTHUC,MADD,TRANGTHAI) "
////                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//        String sql = "{call proc_them_khach_ngan_han(?,?,?,?,?,?,?,?,?)}";
//
//        try {
//            Alert alert;
//
//            if (khachnganhan_hoten.getText().isEmpty()
//                    || khachnganhan_gioitinh.getSelectionModel().getSelectedItem() == null
//                    || khachnganhan_ngaysinh.getValue() == null
//                    || khachnganhan_ngaybatdau.getValue() == null
//                    || khachnganhan_ngayketthuc.getValue() == null) {
//
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Thông báo lỗi");
//                alert.setHeaderText(null);
//                alert.setContentText("Vui lòng điền vào các ô có *");
//                alert.showAndWait();
//            
//            } else if (!isValidName(khachnganhan_hoten.getText())) {
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Thông báo lỗi");
//                alert.setHeaderText(null);
//                alert.setContentText("Họ tên không hợp lệ!");
//                alert.showAndWait();
//            } else if (!isValidPhoneNumberRegex(khachnganhan_sdt.getText())) {
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Thông báo lỗi");
//                alert.setHeaderText(null);
//                alert.setContentText("Số điện thoại không hợp lệ!");
//                alert.showAndWait();
//            } else if (!isValidCCCD(khachnganhan_cccd.getText())) {
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Thông báo lỗi");
//                alert.setHeaderText(null);
//                alert.setContentText("Căn cước công dân không hợp lệ!");
//                alert.showAndWait();
//            } else if (!isValidEmail(khachnganhan_email.getText())) {
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Thông báo lỗi");
//                alert.setHeaderText(null);
//                alert.setContentText("Email không hợp lệ!");
//                alert.showAndWait();
//            } 
//else {
//                // Lấy mã khách hàng mới
////                String newKhachID = generateKhachID();
//                caSt = connect.prepareCall(sql);
//                
//                
////                prepare.setString(1, newKhachID);
//                caSt.setString(1, khachnganhan_hoten.getText());
//                caSt.setString(2, (String) khachnganhan_gioitinh.getSelectionModel().getSelectedItem());
//
//                LocalDate ngaySinh = khachnganhan_ngaysinh.getValue();
//                java.sql.Date sqlNgaySinh = java.sql.Date.valueOf(ngaySinh);
//                caSt.setDate(3, sqlNgaySinh);
//
//                caSt.setString(4, khachnganhan_sdt.getText());
//                caSt.setString(5, khachnganhan_cccd.getText());
//                caSt.setString(6, khachnganhan_email.getText());
//                
//                caSt.setString(7, khachnganhan_maDD.getText());
//                
//                LocalDate ngayBatdau = khachnganhan_ngaybatdau.getValue();
//                java.sql.Date sqlNgayBatdau = java.sql.Date.valueOf(ngayBatdau);
//                caSt.setDate(8, sqlNgayBatdau);
//
//                LocalDate ngayKetthuc = khachnganhan_ngayketthuc.getValue();
//                java.sql.Date sqlNgayKetthuc = java.sql.Date.valueOf(ngayKetthuc);
//                caSt.setDate(9, sqlNgayKetthuc);
//
//                
////                prepare.setString(11, String.valueOf("Chờ duyệt"));
//
//                caSt.execute();
//
//                alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Thông báo");
//                alert.setHeaderText(null);
//                alert.setContentText("Thêm thành công!");
//                alert.showAndWait();
//
//                // SHOW UPDATED TABLEVIEW
//                KhachNganHanShowListData();
//
//                // CLEAR ALL FIELDS
//                KhachNganHanClear();
//            }
//
//        } catch (SQLException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//        String[] errorMessageParts = e.getMessage().split("ORA-\\d{5}:\\s");
//        String userMessage = errorMessageParts.length > 1 ? errorMessageParts[1].trim() : "Lỗi không xác định.";
//        alert.setTitle("Thông báo lỗi");
//        alert.setHeaderText(null);
//        alert.setContentText(userMessage);
//        alert.showAndWait();
//        
//        if (e.getErrorCode() != 20007 && e.getErrorCode() != 20008) {
//            e.printStackTrace();
//        }
//    }
//    }
////    public String generateKhachID() {
////        // Tạo biến đếm tạm thời để tăng dần mã khách hàng
////        int khachCounter = KhachNganHanList.size() + 1;
////        return "K" + String.format("%03d", khachCounter);
////    }
//
//    public void KhachNganHanClear() {
//
//        khachnganhan_hoten.setText("");
//        khachnganhan_gioitinh.getSelectionModel().clearSelection();
//        khachnganhan_ngaysinh.setValue(null);
//        khachnganhan_sdt.setText("+84");
//        khachnganhan_cccd.setText("");
//        khachnganhan_email.setText("");
//        khachnganhan_ngaybatdau.setValue(null);
//        khachnganhan_ngayketthuc.setValue(null);
//    }
//
//    public void KhachNganHanGioiTinh() {
//        ObservableList listData = FXCollections.observableArrayList("Nam", "Nữ", "Khác");
//        khachnganhan_gioitinh.setItems(listData);
//    }
//
//    public ObservableList<KhachData> KhachNganHanListData() {
//
//        ObservableList<KhachData> listData = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM KHACHNGANHAN KNH, KHACHTHUE, TAIKHOAN"
//                + " WHERE KNH.MADD=KHACHTHUE.MAKT AND KHACHTHUE.MAKT=TAIKHOAN.MAKT "
//                + "AND TENTAIKHOAN=?";
//
//
//        try {
//            prepare = connect.prepareStatement(sql);
//            prepare.setString(1, LoginData.taikhoan);
//            result = prepare.executeQuery();
//
//            KhachData khachnh;
//
//            // Định dạng cho ngày/tháng/năm
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
//                        result.getString("MADD"), result.getString("TRANGTHAI"),
//                        formattedNgayBatDau, formattedNgayKetThuc);
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
//        khachnganhan_col_maKT.setCellValueFactory(cellData -> cellData.getValue().getKhachidProperty());
//        khachnganhan_col_hoten.setCellValueFactory(cellData -> cellData.getValue().getHotenProperty());
//        khachnganhan_col_gioitinh.setCellValueFactory(cellData -> cellData.getValue().getGioitinhProperty());
//        khachnganhan_col_ngaysinh.setCellValueFactory(cellData -> cellData.getValue().getNgaysinhProperty());
//        khachnganhan_col_sdt.setCellValueFactory(cellData -> cellData.getValue().getSdtProperty());
//        khachnganhan_col_cccd.setCellValueFactory(cellData -> cellData.getValue().getCccdProperty());
//        khachnganhan_col_email.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
//        khachnganhan_col_ngaybatdau.setCellValueFactory(cellData -> cellData.getValue().getNgaybatdauProperty());
//        khachnganhan_col_ngayketthuc.setCellValueFactory(cellData -> cellData.getValue().getNgayketthucProperty());
//        khachnganhan_col_maDD.setCellValueFactory(cellData -> cellData.getValue().getDaidienidProperty());
//        khachnganhan_col_trangthai.setCellValueFactory(cellData -> cellData.getValue().getTrangthaiProperty());
//
//        khachnganhan_tableview.setItems(KhachNganHanList);
//    }
    @FXML
    public void logout(ActionEvent event) throws SQLException {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Bạn có chắc muốn đăng xuất?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get() == ButtonType.OK) {
                // Đóng cửa sổ hiện tại
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();

                // Mở cửa sổ đăng nhập
                FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
                Parent root = loader.load();
                Stage loginStage = new Stage();
                loginStage.setResizable(false);
                loginStage.initStyle(StageStyle.UNDECORATED);
                Scene scene = new Scene(root);
                loginStage.setScene(scene);
                loginStage.show();

                connect.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        KhachNganHanShowListData();
//        KhachNganHanGioiTinh();
//
//        khachnganhan_hotenDD.setDisable(true);
//        khachnganhan_maDD.setDisable(true);

        trangchu_hoten();
        trangchu_ngaysinh();
        trangchu_gioitinh();
        trangchu_cccd();
        trangchu_sdt();
        trangchu_email();
        trangchu_ngaybatdau();
        trangchu_ngayketthuc();
        trangchu_hotenDD();

        trangchu_slyeucaudv();

        trangchu_slhdchuatt();
    }
}
