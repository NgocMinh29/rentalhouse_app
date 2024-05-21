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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PhieudichvuController implements Initializable {
    
    @FXML                                                                       //phieudv
    private Button phieu_capnhatbtn;

    @FXML
    private TextField phieu_maphong;

    @FXML
    private TableColumn<PhieudichvuData, String> phieu_col_maphong;

    @FXML
    private TableColumn<PhieudichvuData, String> phieu_col_id;

    @FXML
    private TableColumn<PhieudichvuData, String> phieu_col_ngdien;

    @FXML
    private TableColumn<PhieudichvuData, String> phieu_col_sl;

    @FXML
    private AnchorPane phieu_form;

    @FXML
    private TextField phieu_id;

    @FXML
    private Button phieu_lammoibtn;

    @FXML
    private DatePicker phieu_ngdien;

    @FXML
    private TextField phieu_search;

    @FXML
    private TableView<PhieudichvuData> phieu_tableview;

    @FXML
    private TextField phieu_sl;

    @FXML
    private Button phieu_xoabtn;
    
    @FXML
    private Button phieu_xemctpbtn;
    
    @FXML
    private Button ctpdv_capnhatbtn;

    @FXML
    private TableColumn<CTPDVData, String> ctpdv_col_madv;

    @FXML
    private TableColumn<CTPDVData, String> ctpdv_col_tendv;

    @FXML
    private TableColumn<CTPDVData, String> ctpdv_col_tinhtrang;

    @FXML
    private AnchorPane ctpdv_form;


    @FXML
    private TextField ctpdv_madv;

    @FXML
    private Label ctpdv_map;

    @FXML
    private Label ctpdv_mapg;

    @FXML
    private Label ctpdv_ngdien;

    @FXML
    private Button ctpdv_quaylaibtn;
    
    @FXML
    private ComboBox<?> phieu_trangthai;

    @FXML
    private Label ctpdv_sl;

    @FXML
    private TableView<CTPDVData> ctpdv_tableview;

    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private CallableStatement caSt;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDate today = LocalDate.now();
    private int currentMonth = today.getMonthValue();
    private int currentYear = today.getYear();

    private String PdvId;
    private String MaPhong;
    private String NgayDien;
    private String SoLuong;
    
    public void PhieuTrangThai() {
        ObservableList listData = FXCollections.observableArrayList("Chưa hoàn thành", "Hoàn thành");
        phieu_trangthai.setItems(listData);
        
    }
    
    public void PhieuDoiTrangThai(){
        FilteredList<PhieudichvuData> filter = new FilteredList<>(PhieuList, e -> true);
        phieu_trangthai.valueProperty().addListener((Observable, oldValue, newValue) -> {

        filter.setPredicate((PhieudichvuData PrediatePhieuData) -> {
            boolean flag = false;
            if (newValue == null ) {
                    return true;
                }
            String tt = (String)newValue ;
            String mpdv =String.valueOf(PrediatePhieuData.getPDVIdProperty().getValue());
            String sql = "SELECT * FROM PHIEUDICHVU P, CTPDV CT WHERE TINHTRANG = '" + tt + "' AND P.MPDV = '" + mpdv + "'"
                + " AND P.MPDV = CT.MPDV";

            connect = database.getConn();

            try {
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                if(result.next()){
                    flag = true;
                } 

            } catch (Exception e) {
                e.printStackTrace();
            }
            return flag;
        });
        
        SortedList<PhieudichvuData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(phieu_tableview.comparatorProperty());

        phieu_tableview.setItems(sortList);
        });
    }
    
    public void PhieuSelect() {  //lam them khong cho sua mahd,bla
        PhieudichvuData pdv = phieu_tableview.getSelectionModel().getSelectedItem();
        int num = phieu_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        phieu_id.setText(String.valueOf(pdv.getPDVIdProperty().getValue()));
        phieu_maphong.setText(String.valueOf(pdv.getPhongIdProperty().getValue()));
        phieu_sl.setText(String.valueOf(pdv.getSoLuongProperty().getValue()));
        LocalDate selectedDate2 = LocalDate.parse(String.valueOf(pdv.getNgayDienProperty().getValue()), formatter);
        phieu_ngdien.setValue(selectedDate2);
        phieu_xemctpbtn.setDisable(false); 
        phieu_xoabtn.setDisable(false);
        
        PdvId = phieu_id.getText();
        MaPhong = phieu_maphong.getText();
        NgayDien = phieu_ngdien.getValue().format(formatter);
        SoLuong = phieu_sl.getText();
        
    }
    

        public void PhieuXoa(ActionEvent event) {

//        String sql = "DELETE PHIEUDICHVU WHERE MPDV = '"
//                + phieu_id.getText() + "'";
//
//        connect = database.getConn();

        try {
            Alert alert;

            
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Bạn có chắc muốn xóa phiếu có mã phiếu: " + phieu_id.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                String strCall = "{call  XOA_PHIEU_DICH_VU(?)}";
            
           
                caSt = connect.prepareCall(strCall);
                caSt.setString(1, phieu_id.getText());
                //caSt.setString(2, themnguoi_makt.getText());
                caSt.execute();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Xóa phiếu thành công!");
                alert.showAndWait();

                // SHOW UPDATED TABLEVIEW
                //HoaDonShowListData();

                PhieuClear();
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
    public void PhieuXemCTPDV(ActionEvent ev) { 
        ctpdv_map.setText(PdvId); //= phieu_id.getText();
        ctpdv_mapg.setText(MaPhong);//MaPhong = phieu_maphong.getText();
        ctpdv_ngdien.setText(NgayDien);//NgayDien = phieu_ngdien.getValue().format(formatter);
        ctpdv_sl.setText(SoLuong);//SoLuong = phieu_sl.getText();
        
      
        CTPDVShowListData();
        phieu_form.setVisible(false);

        ctpdv_form.setVisible(true);
        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
        
        phieu_capnhatbtn.setDisable(true);
        
        //phieu_id.setDisable(false);  
        
    } 
    
    public void CTPDVSelect() {  //lam them khong cho sua mahd,bla
        CTPDVData pdv = ctpdv_tableview.getSelectionModel().getSelectedItem();
        int num = ctpdv_tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        ctpdv_madv.setText(String.valueOf(pdv.getDichVuIdProperty().getValue()).trim());     
    }
    
    public void CTPDVHoanThanh(ActionEvent event) {
        
        String sql = "UPDATE CTPDV"
                + " SET TINHTRANG = 'Hoàn thành' " 
                + " WHERE MADV = '" + ctpdv_madv.getText() + "' AND MPDV = '" + ctpdv_map.getText() + "'";

        connect = database.getConn();

        try {
            Alert alert;
            {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc dịch vụ này đã hoàn thành?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    
                    statement = connect.createStatement();
//                    prepare.setDate(1, sqlNgaySinh);
//                    prepare.setDate(2, sqlNgaybd);
//                    prepare.setDate(3, sqlNgaykt);
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cập nhật thành công!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    

                    // CLEAR ALL FIELDS
                    CTPDVShowListData();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public ObservableList<CTPDVData> CTPDVListData() {

        ObservableList<CTPDVData> listData = FXCollections.observableArrayList();
        String sql = "SELECT CTPDV.MADV, TENDICHVU, TINHTRANG FROM CTPDV,DICHVU WHERE MPDV = '" + ctpdv_map.getText() + "' AND CTPDV.MADV = DICHVU.MADV";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            CTPDVData phieudichvu;

            while (result.next()) { 
                
                    phieudichvu = new CTPDVData(result.getString(1),
                         result.getString(2), result.getString(3));

                listData.add(phieudichvu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    private ObservableList<CTPDVData> CTPDVList;
    
    public void CTPDVShowListData() {
        CTPDVList = CTPDVListData();
        try{
           
        ctpdv_col_madv.setCellValueFactory(cellData -> cellData.getValue().getDichVuIdProperty());
        ctpdv_col_tendv.setCellValueFactory(cellData -> cellData.getValue().getDichVuTenProperty());
        ctpdv_col_tinhtrang.setCellValueFactory(cellData -> cellData.getValue().getTrangThaiProperty());
        
        ctpdv_tableview.setItems(CTPDVList);
        }catch (NullPointerException e) {
            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
            //hoadonMaPhong = ""; // Gán giá trị mặc định
          }
    }
    
    
    public void PhieuClear() { //sua luon setdisable cua may texfield

        phieu_id.setText("");
        //hoadon_maphong.setText("");
        phieu_maphong.setText("");
        phieu_sl.setText("");
        phieu_ngdien.setValue(null);
        phieu_trangthai.getSelectionModel().clearSelection();
        PhieuShowListData();
        //moi bam vao thi khong the xoa hay sua, phai chon moi xoa sua duoc
        phieu_xemctpbtn.setDisable(true); 
        phieu_xoabtn.setDisable(true); 
        
    }
    
    public ObservableList<PhieudichvuData> PhieuListData() {

        ObservableList<PhieudichvuData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM PHIEUDICHVU";

        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            PhieudichvuData phieudichvu;

            while (result.next()) { 
                LocalDate ngaydien = result.getDate("NGAYDIEN").toLocalDate();
                String formattedNgaydien = ngaydien.format(formatter);
                
//                phieudichvu = new PhieudichvuData(result.getString("MPDV"),
//                         result.getString("MAP"), result.getInt("SOLUONGDV"),
//                         result.getString("NGAYDIEN"));
                    phieudichvu = new PhieudichvuData(result.getString("MPDV"),
                         result.getString("MAP"), result.getInt("SOLUONGDV"),
                         formattedNgaydien);

                listData.add(phieudichvu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    private ObservableList<PhieudichvuData> PhieuList;
    
    public void PhieuShowListData() {
        PhieuList = PhieuListData();
        try{
        phieu_col_id.setCellValueFactory(cellData -> cellData.getValue().getPDVIdProperty());
        phieu_col_maphong.setCellValueFactory(cellData -> cellData.getValue().getPhongIdProperty());
        phieu_col_sl.setCellValueFactory(cellData -> cellData.getValue().getSoLuongProperty().asString());
        phieu_col_ngdien.setCellValueFactory(cellData -> cellData.getValue().getNgayDienProperty());
        
        phieu_tableview.setItems(PhieuList);
        }catch (NullPointerException e) {
            System.out.println("Lỗi NullPointerException xảy ra: " + e.getMessage());
            //hoadonMaPhong = ""; // Gán giá trị mặc định
          }
    }
    
    
    public void QuayLai(ActionEvent ev){
        
            phieu_form.setVisible(true);

            ctpdv_form.setVisible(false);
            PhieuClear();
            
//            CTHDShowListData();
//            
//            cthd_hdid.setText(HoaDonId);
//            cthd_kydong.setText(KyDong);
//            cthd_maphong.setText(MaPhong);
//            cthd_tenphong.setText(TenPhong);
//            cthd_tongtien.setText(TongTien);
//            
//            cthd_thanhtien.setDisable(true);
//            cthd_loaihd.setDisable(false);
//            
//            cthd_xoabtn.setDisable(true); 
//            cthd_capnhatbtn.setDisable(true);
//            
//            CTHDLoaiHD();
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PhieuShowListData();
        phieu_xemctpbtn.setDisable(true); 
        phieu_xoabtn.setDisable(true);
        PhieuTrangThai();
        PhieuDoiTrangThai();
        // TODO
    }    
    
}
