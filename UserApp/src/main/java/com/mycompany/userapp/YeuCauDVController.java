/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userapp;

/**
 *
 * @author NGUYEN MY NGAN
 */
import connection.database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.control.CheckComboBox;

public class YeuCauDVController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private CheckComboBox<String> checkComboBox;

    @FXML
    private Button dv_guiyeucauBtn;

    @FXML
    private TableView<YCDVData> dichvu_tableview;

    @FXML
    private TableColumn<YCDVData, String> dv_col_ngaydien;

    @FXML
    private TableColumn<YCDVData, String> dv_col_tendv;

    @FXML
    private TableColumn<YCDVData, String> dv_col_tinhtrang;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Kết nối đến cơ sở dữ liệu
        connect = database.getConn();

        //       YeuCauDVList = FXCollections.observableArrayList();
        // Lấy danh sách tên dịch vụ từ cơ sở dữ liệu và thêm vào CheckComboBox
        loadDichVuNames();
        loadTenPhong();
        LayTenPGMacDinh();
        DoiMaPhong();

        YeuCauDVShowListData();
    }

    private void loadTenPhong() {
        try {
            // Truy vấn để lấy tên phòng từ cơ sở dữ liệu
            String query = "SELECT PHONG.TENPG FROM PHONG, HOPDONG, CTHOPDONG, TAIKHOAN WHERE PHONG.MAP=HOPDONG.MAP "
                    + "AND HOPDONG.MHD=CTHOPDONG.MHD AND CTHOPDONG.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN=?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, LoginData.taikhoan); // Đặt giá trị cho tham số USERNAME
            ResultSet resultSet = preparedStatement.executeQuery();

            // Thêm các tên phòng vào ComboBox
            while (resultSet.next()) {
                String tenPhong = resultSet.getString("TENPG");
                comboBox.getItems().add(tenPhong);

            }
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra khi truy vấn cơ sở dữ liệu
            e.printStackTrace();
        }

    }

    public void LayTenPGMacDinh() {
        try {
            // Truy vấn để lấy tên phòng từ cơ sở dữ liệu
            String query = "SELECT PHONG.TENPG FROM PHONG, HOPDONG, CTHOPDONG, TAIKHOAN WHERE PHONG.MAP=HOPDONG.MAP "
                    + "AND HOPDONG.MHD=CTHOPDONG.MHD AND CTHOPDONG.MAKT=TAIKHOAN.MAKT AND TENTAIKHOAN=? AND ROWNUM=1";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, LoginData.taikhoan); // Đặt giá trị cho tham số USERNAME
            ResultSet resultSet = preparedStatement.executeQuery();

            // Thêm các tên phòng vào ComboBox
            if (resultSet.next()) {
                String tenPhong = resultSet.getString("TENPG");
                int index1 = comboBox.getItems().indexOf(tenPhong);
                if (index1 != -1) {
                    comboBox.getSelectionModel().select(index1);
                }

            }
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra khi truy vấn cơ sở dữ liệu
            e.printStackTrace();
        }
    }

    public void DoiMaPhong() {
        comboBox.valueProperty().addListener((Observable, oldValue, newValue) -> {
            YeuCauDVShowListData();
        });
    }

    private void loadDichVuNames() {
        try {
            // Truy vấn để lấy tên dịch vụ từ cơ sở dữ liệu
            String query = "SELECT TENDICHVU FROM DICHVU";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Tạo một danh sách để lưu trữ các tên dịch vụ
            List<String> dichVuNames = new ArrayList<>();

            // Thêm tên dịch vụ vào danh sách
            while (resultSet.next()) {
                dichVuNames.add(resultSet.getString("TENDICHVU"));
            }

            // Thêm các tên dịch vụ vào CheckComboBox
            checkComboBox.getItems().addAll(dichVuNames);
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra khi truy vấn cơ sở dữ liệu
            e.printStackTrace();
        }
    }

    private ObservableList<YCDVData> YeuCauDVList;

    private String generateMPDV() {
        String newMPDV = "";
        try {
            // Tạo truy vấn SQL để lấy mã MPDV lớn nhất
            String maxQuery = "SELECT MAX(MPDV) AS MAX_MPDV FROM PHIEUDICHVU";
            PreparedStatement maxStatement = connect.prepareStatement(maxQuery);
            ResultSet maxResult = maxStatement.executeQuery();

            // Kiểm tra xem có kết quả trả về không
            if (maxResult.next()) {
                // Lấy giá trị của mã MPDV lớn nhất hiện tại
                String maxMPDV = maxResult.getString("MAX_MPDV");
                if (maxMPDV != null) {
                    // Tạo mã MPDV mới bằng cách tăng giá trị của mã lớn nhất lên một
                    int newMPDVCounter = Integer.parseInt(maxMPDV.substring(3)) + 1;
                    newMPDV = "PDV" + String.format("%03d", newMPDVCounter);
                } else {
                    // Nếu không có bản ghi nào trong bảng, bắt đầu với PDV001
                    newMPDV = "PDV001";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newMPDV;
    }

//    public void YeuCauDV_Guiyeucau(ActionEvent event) throws SQLException {
//
//        String sqlKtraTonTai = "SELECT TENDICHVU AS TENDVDACHON FROM DICHVU DV, CTPDV, PHIEUDICHVU PDV WHERE CTPDV.TINHTRANG='Chưa hoàn thành' AND DV.MADV=CTPDV.MADV AND CTPDV.MPDV=PDV.MPDV";
//
//        String sqlInsertPHIEUDICHVU = "INSERT INTO PHIEUDICHVU (MPDV, MAP, SOLUONGDV, NGAYDIEN) VALUES (?, ?, ?, ?)";
//        String sqlInsertCTPDV = "INSERT INTO CTPDV (MADV, MPDV, TINHTRANG) VALUES (?, ?, ?)";
//
//        // Lấy MADV từ tên dịch vụ đã chọn
//        String MADV = null;
//        String MPDV = generateMPDV();
//
//        // Lấy danh sách các dịch vụ đã được chọn
//        ObservableList<String> selectedServices = checkComboBox.getCheckModel().getCheckedItems();
//
//        // Đếm số lượng dịch vụ đã chọn
//        int selectedServiceCount = selectedServices.size();
//
//        LocalDate ngayDien = LocalDate.now();
//        java.sql.Date ngayDienSQL = java.sql.Date.valueOf(ngayDien);
//
//        String tenPhong = comboBox.getSelectionModel().getSelectedItem();
//        String sqlLayMP = "SELECT MAP FROM PHONG WHERE TENPG=?";
//
//        try {
//            if (checkComboBox.getCheckModel().getCheckedItems().isEmpty() || comboBox.getSelectionModel().isEmpty()) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Thông báo lỗi");
//                alert.setHeaderText(null);
//                alert.setContentText("Vui lòng chọn dịch vụ và phòng!");
//                alert.showAndWait();
//            } else {
//                PreparedStatement layMPStatement = connect.prepareStatement(sqlLayMP);
//                layMPStatement.setString(1, tenPhong);
//                ResultSet rsMP = layMPStatement.executeQuery();
//
//                String MAP = null;
//                if (rsMP.next()) {
//                    MAP = rsMP.getString("MAP");
//                }
//
//                PreparedStatement ktraStatement = connect.prepareStatement(sqlKtraTonTai);
//                ResultSet ktraResult = ktraStatement.executeQuery();
//                while (ktraResult.next()) {
//                    // Lặp qua kết quả kiểm tra để xem dịch vụ đã chọn đã tồn tại và hoàn thành chưa
//                    for (String serviceName : selectedServices) {
//                        if (MAP.equals(ktraResult.getString("MAP")) && serviceName.equals(ktraResult.getString("TENDVDACHON"))){ 
//                            // Nếu dịch vụ đã tồn tại và hoàn thành, hiển thị cảnh báo và không thêm vào danh sách yêu cầu
//                            Alert alert = new Alert(Alert.AlertType.ERROR);
//                            alert.setTitle("Thông báo lỗi");
//                            alert.setHeaderText(null);
//                            alert.setContentText("Dịch vụ chọn đang chờ xử lý!");
//                            alert.showAndWait();
//                            return; // Thoát khỏi phương thức để không thêm dịch vụ vào danh sách yêu cầu
//                        }
//                    }
//                }
//
//                PreparedStatement prepareInsertPHIEUDICHVU = connect.prepareStatement(sqlInsertPHIEUDICHVU);
//                PreparedStatement prepareInsertCTPDV = connect.prepareStatement(sqlInsertCTPDV);
//
//                // Insert vào bảng PHIEUDICHVU
//                prepareInsertPHIEUDICHVU.setString(1, MPDV);
//                prepareInsertPHIEUDICHVU.setString(2, MAP);
//                prepareInsertPHIEUDICHVU.setInt(3, selectedServiceCount);
//                prepareInsertPHIEUDICHVU.setDate(4, ngayDienSQL);
//                prepareInsertPHIEUDICHVU.executeUpdate();
//
//                // Lấy MADV từ tên dịch vụ đã chọn và insert vào bảng CTPDV
//                for (String serviceName : selectedServices) {
//                    String sqlGetMADV = "SELECT MADV FROM DICHVU WHERE TENDICHVU = ?";
//                    PreparedStatement prepareGetMADV = connect.prepareStatement(sqlGetMADV);
//                    prepareGetMADV.setString(1, serviceName);
//                    ResultSet rsMADV = prepareGetMADV.executeQuery();
//
//                    if (rsMADV.next()) {
//                        MADV = rsMADV.getString("MADV");
//                    }
//
//                    // Insert vào bảng CTPDV
//                    prepareInsertCTPDV.setString(1, MADV);
//                    prepareInsertCTPDV.setString(2, MPDV);
//                    prepareInsertCTPDV.setString(3, "Chưa hoàn thành");
//                    prepareInsertCTPDV.executeUpdate();
//                }
//
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Thông báo");
//                alert.setHeaderText(null);
//                alert.setContentText("Đã gửi yêu cầu dịch vụ thành công");
//                alert.showAndWait();
//
//                // SHOW UPDATED TABLEVIEW
//                YeuCauDVShowListData();
//
//                // CLEAR ALL FIELDS
//                YeuCauDVClear();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public void YeuCauDV_Guiyeucau(ActionEvent event) throws SQLException {

        String sqlKtraTonTai = "SELECT * "
                + "FROM DICHVU DV, CTPDV, PHIEUDICHVU PDV "
                + "WHERE DV.MADV=CTPDV.MADV AND CTPDV.MPDV=PDV.MPDV";

        String sqlInsertPHIEUDICHVU = "INSERT INTO PHIEUDICHVU (MPDV, MAP, SOLUONGDV, NGAYDIEN) VALUES (?, ?, ?, ?)";
        String sqlInsertCTPDV = "INSERT INTO CTPDV (MADV, MPDV, TINHTRANG) VALUES (?, ?, ?)";

        // Lấy danh sách các dịch vụ đã được chọn
        ObservableList<String> selectedServices = checkComboBox.getCheckModel().getCheckedItems();

        // Đếm số lượng dịch vụ đã chọn
        int selectedServiceCount = selectedServices.size();

        LocalDate ngayDien = LocalDate.now();
        java.sql.Date ngayDienSQL = java.sql.Date.valueOf(ngayDien);

        String tenPhong = comboBox.getSelectionModel().getSelectedItem();
        String sqlLayMP = "SELECT MAP FROM PHONG WHERE TENPG=?";

        try {
            if (checkComboBox.getCheckModel().getCheckedItems().isEmpty() || comboBox.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng chọn dịch vụ và phòng!");
                alert.showAndWait();
            } else {
                PreparedStatement layMPStatement = connect.prepareStatement(sqlLayMP);
                layMPStatement.setString(1, tenPhong);
                ResultSet rsMP = layMPStatement.executeQuery();

                String MAP = null;
                if (rsMP.next()) {
                    MAP = rsMP.getString("MAP");
                }

                PreparedStatement ktraStatement = connect.prepareStatement(sqlKtraTonTai);
                ResultSet ktraResult = ktraStatement.executeQuery();

                // Lặp qua kết quả kiểm tra để xem dịch vụ đã chọn đã tồn tại và chưa hoàn thành cho một phòng cụ thể
                while (ktraResult.next()) {
                    for (String serviceName : selectedServices) {
                        if (MAP.equals(ktraResult.getString("MAP")) && serviceName.equals(ktraResult.getString("TENDICHVU")) && ktraResult.getString("TINHTRANG").equalsIgnoreCase("Chưa hoàn thành")) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Thông báo lỗi");
                            alert.setHeaderText(null);
                            alert.setContentText("Dịch vụ chọn đang chờ xử lý!");
                            alert.showAndWait();
                            return; // Thoát khỏi phương thức để không thêm dịch vụ vào danh sách yêu cầu
                        }
                    }
                }

                String MPDV = generateMPDV();
                PreparedStatement prepareInsertPHIEUDICHVU = connect.prepareStatement(sqlInsertPHIEUDICHVU);
                PreparedStatement prepareInsertCTPDV = connect.prepareStatement(sqlInsertCTPDV);

                // Insert vào bảng PHIEUDICHVU
                prepareInsertPHIEUDICHVU.setString(1, MPDV);
                prepareInsertPHIEUDICHVU.setString(2, MAP);
                prepareInsertPHIEUDICHVU.setInt(3, selectedServiceCount);
                prepareInsertPHIEUDICHVU.setDate(4, ngayDienSQL);
                prepareInsertPHIEUDICHVU.executeUpdate();

                // Lấy MADV từ tên dịch vụ đã chọn và insert vào bảng CTPDV
                for (String serviceName : selectedServices) {
                    String sqlGetMADV = "SELECT MADV FROM DICHVU WHERE TENDICHVU = ?";
                    PreparedStatement prepareGetMADV = connect.prepareStatement(sqlGetMADV);
                    prepareGetMADV.setString(1, serviceName);
                    ResultSet rsMADV = prepareGetMADV.executeQuery();

                    if (rsMADV.next()) {
                        String MADV = rsMADV.getString("MADV");

                        // Insert vào bảng CTPDV
                        prepareInsertCTPDV.setString(1, MADV);
                        prepareInsertCTPDV.setString(2, MPDV);
                        prepareInsertCTPDV.setString(3, "Chưa hoàn thành");
                        prepareInsertCTPDV.executeUpdate();
                    }
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Đã gửi yêu cầu dịch vụ thành công");
                alert.showAndWait();

                // SHOW UPDATED TABLEVIEW
                YeuCauDVShowListData();

                YeuCauDVClear();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void YeuCauDVClear() {
        // Xóa toàn bộ các lựa chọn của checkComboBox
        checkComboBox.getCheckModel().clearChecks();

    }

    private ObservableList<YCDVData> YeuCauDVListData() {
        String tenPhong = comboBox.getSelectionModel().getSelectedItem();
        ObservableList<YCDVData> listData = FXCollections.observableArrayList();
        String sql = "SELECT PD.NGAYDIEN, DV.TENDICHVU, CTPDV.TINHTRANG "
                + "FROM PHIEUDICHVU PD "
                + "JOIN PHONG ON PD.MAP=PHONG.MAP "
                + "JOIN CTPDV ON PD.MPDV = CTPDV.MPDV "
                + "JOIN DICHVU DV ON CTPDV.MADV = DV.MADV "
                + "WHERE PHONG.TENPG = ?";

        try {
            connect = database.getConn();
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, tenPhong);
            result = prepare.executeQuery();

            // Đọc dữ liệu từ kết quả truy vấn và thêm vào danh sách
            while (result.next()) {
                // Đọc các trường từ kết quả
                String ngaydien = result.getDate("NGAYDIEN").toString();
                String tendv = result.getString("TENDICHVU");
                String tinhtrang = result.getString("TINHTRANG");

                // Tạo đối tượng DVData từ các giá trị đọc được
                YCDVData dvData = new YCDVData(tendv, ngaydien, tinhtrang);

                // Thêm đối tượng vào danh sách
                listData.add(dvData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void YeuCauDVShowListData() {
        YeuCauDVList = YeuCauDVListData();

        // Đặt giá trị cho các cột trong TableView
        dv_col_tendv.setCellValueFactory(cellData -> cellData.getValue().getTenDVProperty());
        dv_col_ngaydien.setCellValueFactory(cellData -> cellData.getValue().getNgayDienProperty());
        dv_col_tinhtrang.setCellValueFactory(cellData -> cellData.getValue().getTrangThaiProperty());

        // Đặt dữ liệu cho TableView
        dichvu_tableview.setItems(YeuCauDVList);
    }

}
