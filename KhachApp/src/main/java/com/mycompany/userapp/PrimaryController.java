package com.mycompany.userapp;

import model.LoginData;
import connection.database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class PrimaryController {

    @FXML
    private Button btn;

    @FXML
    private Button close;

    @FXML
    private Button close1;

    @FXML
    private Button close11;

    @FXML
    private Button close111;

    @FXML
    private AnchorPane login_form;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private TextField login_email;

    @FXML
    private Hyperlink login_forgotpassword;

    @FXML
    private Button login_guimail;

    @FXML
    private TextField login_maxn;

    @FXML
    private TextField login_mkmoi;

    @FXML
    private Button login_quaylaiemail;

    @FXML
    private Button login_quaylaimaxn;

    @FXML
    private CheckBox login_showpassword;

    @FXML
    private Button login_xacnhanma;

    @FXML
    private TextField login_xacnhanmkmoi;

    @FXML
    private AnchorPane loginemailform;

    @FXML
    private AnchorPane loginmaxnform;

    @FXML
    private Button loginquyalaimkmoi;

    @FXML
    private AnchorPane loginxacnhanmkform;

    @FXML
    private Button loginxacnhanmkmoibtn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField showpassword;

    @FXML
    private TextField username;

    private double x = 0;
    private double y = 0;

    private Connection connect = database.getConn();
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private int randomCode;

    public void initialize() {
        // Gán sự kiện KeyPressed cho các trường nhập liệu
        username.setOnKeyPressed(this::handleEnterKey);
        password.setOnKeyPressed(this::handleEnterKey);
    }

    private void handleEnterKey(KeyEvent event) {
        // Kiểm tra nếu phím được nhấn là phím Enter
        if (event.getCode() == KeyCode.ENTER) {
            // Gọi phương thức đăng nhập khi nhấn Enter
            login(null);
        }
    }

    public void login(ActionEvent ev) {
        String sql = "SELECT * FROM TAIKHOAN WHERE VAITRO ='Khách thuê' AND TENTAIKHOAN = ? and MATKHAU = ?";
        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());

            result = prepare.executeQuery();

            Alert alert;

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Các ô không được để trống");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    // IF CORRECT USERNAME AND PASSWORD THEN PROCEED TO DASHBOARD 

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng nhập thành công!");
                    alert.showAndWait();

                    LoginData.taikhoan = username.getText();
                    LoginData.matkhau = password.getText();
                    //getData.username = username.getText();

                    // TO HIDE LOGIN FORM
                    btn.getScene().getWindow().hide();

                    // LINK YOUR DASHBOARD FORM
                    Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("BCODE APP");
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();

                } else {
                    // IF NOT THEN ERROR MESSAGE WILL APPEAR

                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText(null);
                    alert.setContentText("Tài khoản hoặc mật khẩu không đúng");
                    alert.showAndWait();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showpassword(ActionEvent event) {
        //image.setVisible(true);
        if (login_showpassword.isSelected()) {
            showpassword.setText(password.getText());
            showpassword.setVisible(true);
            password.setVisible(false);
        } else {
            password.setText(showpassword.getText());
            showpassword.setVisible(false);
            password.setVisible(true);
        }
    }

    public void forgotpassword(ActionEvent event) {

        loginemailform.setVisible(true);
        login_form.setVisible(false);
        loginmaxnform.setVisible(false);
        loginxacnhanmkform.setVisible(false);

    }

    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

    public static boolean isValidEmail(String emailString) {
        return EMAIL_REGEX.matcher(emailString).matches();
    }
    
    private String email;

    public void sendmail(ActionEvent event) {
        Alert alert;
//        if (login_email.getText() == null || login_email.getText().isEmpty()) {
//            alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Thông báo");
//            alert.setHeaderText(null);
//            alert.setContentText("Các ô không được để trống");
//            alert.showAndWait();
//            return;
//        }

        String to = login_email.getText();
        if (to == null || to.isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Mail không được để trống");
            alert.showAndWait();
            return;
        }
        if (!isValidEmail(to)) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Mail không hợp lệ");
            alert.showAndWait();
            return;
        }
        
        email = login_email.getText();
        
        loginemailform.setVisible(false);
        login_form.setVisible(false);
        loginmaxnform.setVisible(true);
        loginxacnhanmkform.setVisible(false);

        Random rand = new Random();
        randomCode = rand.nextInt(999999);
        String host = "smtp.gmail.com";
        String user = "22520932@gm.uit.edu.vn";  // Sử dụng biến môi trường
        String pass = "5hx7mt6l";  // Sử dụng biến môi trường
//        String to = login_email.getText();
        String subject = "Gửi mã xác nhận";
        String messageText = "Mã xác nhận của bạn là " + randomCode;

        Properties pros = new Properties();
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.host", host);
        pros.put("mail.smtp.port", "587");

        Session session = Session.getInstance(pros, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Đã gửi mã thành công!");
            alert.showAndWait();
        } catch (MessagingException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Có lỗi xảy ra khi gửi email: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void backofmail(ActionEvent event) {
        loginemailform.setVisible(false);
        login_form.setVisible(true);
        loginmaxnform.setVisible(false);
        loginxacnhanmkform.setVisible(false);
    }

    public void verifycode(ActionEvent event) {
        //viết thêm
        Alert alert;
        try {
            if (login_maxn.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Các ô không được để trống");
                alert.showAndWait();
            } else if (Integer.parseInt(login_maxn.getText()) == randomCode) {
                loginmaxnform.setVisible(false);
                loginxacnhanmkform.setVisible(true);

            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Mã xác nhận không đúng!");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void backofverifycode(ActionEvent event) {
        loginemailform.setVisible(true);
        login_form.setVisible(false);
        loginmaxnform.setVisible(false);
        loginxacnhanmkform.setVisible(false);
    }

    public void verifypasword(ActionEvent event) {
        Alert alert;

        try {
            if (login_mkmoi.getText().isEmpty() || login_xacnhanmkmoi.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Các ô không được để trống");
                alert.showAndWait();
            } else if (!login_mkmoi.getText().equals(login_xacnhanmkmoi.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Mật khẩu xác nhận chưa trùng khớp");
                alert.showAndWait();
            } else {
                System.out.println("Inside else block");
                String sql = "UPDATE TAIKHOAN SET MATKHAU=? WHERE TENTAIKHOAN=?";

                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, login_mkmoi.getText());
                ps.setString(2, email);

                ps.executeUpdate();


                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Đổi mật khẩu thành công!");
                alert.showAndWait();

                loginemailform.setVisible(false);
                login_form.setVisible(true);
                loginmaxnform.setVisible(false);
                loginxacnhanmkform.setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void backofverifypasword(ActionEvent event) { //không cần thiết??
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Thông báo xác nhận");
        alert.setHeaderText(null);
        alert.setContentText("Bạn có chắc muốn quay lại?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            backofmail(event);
        }

    }

    public void close(ActionEvent event) {
        System.exit(0);
    }

}
