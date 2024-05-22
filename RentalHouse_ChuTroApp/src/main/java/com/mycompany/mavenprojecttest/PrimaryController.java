package com.mycompany.mavenprojecttest;

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
//import javafx.scene.image.ImageView;
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

public class PrimaryController {

    //@FXML
    //private Button close;
    //@FXML
    //private ImageView image;
    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    @FXML
    private TextField showpassword;

    @FXML
    private TextField login_email;

    @FXML
    private Hyperlink login_forgotpassword;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button login_guimail;

    @FXML
    private TextField login_maxn;

    @FXML
    private PasswordField login_mkmoi;

    @FXML
    private Button login_quaylaiemail;

    @FXML
    private Button login_quaylaimaxn;

    @FXML
    private CheckBox login_showpassword;

    @FXML
    private Button login_xacnhanma;

    @FXML
    private PasswordField login_xacnhanmkmoi;

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

    private Connection connect = database.getConn();
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private int randomCode;

    private double x = 0;
    private double y = 0;

    public void initialize() {
        // GĂ¡n sá»± kiá»‡n KeyPressed cho cĂ¡c trÆ°á»ng nháº­p liá»‡u
        username.setOnKeyPressed(this::handleEnterKey);
        password.setOnKeyPressed(this::handleEnterKey);
    }

    private void handleEnterKey(KeyEvent event) {
        // Kiá»ƒm tra náº¿u phĂ­m Ä‘Æ°á»£c nháº¥n lĂ  phĂ­m Enter
        if (event.getCode() == KeyCode.ENTER) {
            // Gá»i phÆ°Æ¡ng thá»©c Ä‘Äƒng nháº­p khi nháº¥n Enter
            login(null);
        }
    }

    public void login(ActionEvent ev) {
        String sql = "SELECT * FROM TAIKHOAN WHERE VAITRO ='Chủ trọ' AND TENTAIKHOAN = ? and MATKHAU = ?";
        connect = database.getConn();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());

            result = prepare.executeQuery();
            Alert alert;

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo lỗi");
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
                    loginBtn.getScene().getWindow().hide();

                    // LINK YOUR DASHBOARD FORM
                    Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
                    Stage stage = new Stage();
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
                    alert.setTitle("Thông báo lỗi");
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

        String to = login_email.getText();
        if (to == null || to.isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Mail không được để trống");
            alert.showAndWait();
            return;
        }
        if (!isValidEmail(to)) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo lỗi");
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
        String user = "22520932@gm.uit.edu.vn";  // Sá»­ dá»¥ng biáº¿n mĂ´i trÆ°á»ng
        String pass = "5hx7mt6l";  // Sá»­ dá»¥ng biáº¿n mĂ´i trÆ°á»ng
//        String to = login_email.getText();
        String subject = "Gửi mã xác nhận";
        String messageText = "Mã xác nhận của bạn là  " + randomCode;
        
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
            alert.setTitle("Thông báo lỗi");
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
        //viáº¿t thĂªm
        Alert alert;
        try {
            if (login_maxn.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Các ô không được để trống");
                alert.showAndWait();
            } else if (Integer.parseInt(login_maxn.getText()) == randomCode) {
                loginmaxnform.setVisible(false);
                loginxacnhanmkform.setVisible(true);

            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo lỗi");
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
                alert.setTitle("Thông báo lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Các ô không được để trống");
                alert.showAndWait();
            } else if (!login_mkmoi.getText().equals(login_xacnhanmkmoi.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo lỗi");
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

    public void backofverifypasword(ActionEvent event) { //khĂ´ng cáº§n thiáº¿t??
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Thông báo xác nhận");
        alert.setHeaderText(null);
        alert.setContentText("Bạn có chắc muốn quay lại?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get().equals(ButtonType.OK)) {
            loginemailform.setVisible(false);
            login_form.setVisible(true);
            loginmaxnform.setVisible(false);
            loginxacnhanmkform.setVisible(false);
        }
    }

    public void close(ActionEvent event) {
        System.exit(0);
    }

}
