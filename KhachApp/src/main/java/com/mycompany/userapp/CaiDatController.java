/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.userapp;

import model.LoginData;
import connection.database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author NGUYEN MY NGAN
 */
public class CaiDatController implements Initializable {

    private Connection connect = database.getConn();
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    @FXML
    private Button caidat_capnhat_btn;

    @FXML
    private PasswordField confirm_pass;

    @FXML
    private Label label_doimk;

    @FXML
    private PasswordField new_pass;

    @FXML
    private PasswordField old_pass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void capnhat_mk(ActionEvent ev) {
        String sqlCapNhat = "UPDATE TAIKHOAN SET MATKHAU = ? WHERE TENTAIKHOAN = ?";
        String sqlKtra = "SELECT MATKHAU FROM TAIKHOAN WHERE TENTAIKHOAN = ?";

        PreparedStatement prepare = null;
        ResultSet result = null;
        Alert alert;

        try {
            prepare = connect.prepareStatement(sqlKtra);
            prepare.setString(1, LoginData.taikhoan);

            result = prepare.executeQuery();

            // Kiểm tra nếu các ô nhập liệu bị trống
            if (old_pass.getText().isEmpty() || new_pass.getText().isEmpty() || confirm_pass.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Các ô không được để trống");
                alert.showAndWait();
            } else if (result.next()) { // Kiểm tra nếu có kết quả trả về
                String currentPassword = result.getString("MATKHAU");

                // Kiểm tra mật khẩu cũ có đúng không
                if (!old_pass.getText().equals(currentPassword)) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("Mật khẩu cũ không chính xác!");
                    alert.showAndWait();
                } else if (!new_pass.getText().equals(confirm_pass.getText())) { // Kiểm tra mật khẩu mới và xác nhận mật khẩu có khớp không
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("Mật khẩu mới và mật khẩu nhập lại không trùng khớp!");
                    alert.showAndWait();
                } else {

                    PreparedStatement psCapNhat = connect.prepareStatement(sqlCapNhat);
                    psCapNhat.setString(1, new_pass.getText());
                    psCapNhat.setString(2, LoginData.taikhoan);

                    psCapNhat.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("Đổi mật khẩu thành công!");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
