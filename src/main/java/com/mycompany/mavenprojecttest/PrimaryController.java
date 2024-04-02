package com.mycompany.mavenprojecttest;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrimaryController {

    //@FXML
    //private Button close;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    private double x = 0;
    private double y = 0;
    
    public void login(ActionEvent ev){
        //String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        //connect = database.connectDb();
        
        try{
            //prepare = connect.prepareStatement(sql);
            //prepare.setString(1, username.getText());
            //prepare.setString(2, password.getText());
            
            //result = prepare.executeQuery();
            
            Alert alert;
            
            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if("user".equals(username.getText()) || "1234".equals(password.getText())){
                    // IF CORRECT USERNAME AND PASSWORD THEN PROCEED TO DASHBOARD 
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();
                    
                    //getData.username = username.getText();
                    
                    // TO HIDE LOGIN FORM
                    loginBtn.getScene().getWindow().hide();
                    
                    // LINK YOUR DASHBOARD FORM
                    Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    // IF NOT THEN ERROR MESSAGE WILL APPEAR
                    
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                    
                }
            }
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    public void close(ActionEvent event){
        System.exit(0);
    }
    
}
