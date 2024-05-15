/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenprojecttest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CTHDController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button close;

    @FXML
    private Button cthd_capnhatbtn;

    @FXML
    private Button cthd_lammoibtn;

    @FXML
    private Button cthd_quaylaibtn;

    @FXML
    private Button cthd_thembtn;

    @FXML
    private Button cthd_xoabtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    private double x = 0;
    private double y = 0;
    
    public void QuayLai(ActionEvent ev){
        
        try{
                    
                    // TO HIDE LOGIN FORM
                    cthd_quaylaibtn.getScene().getWindow().hide();
                    
                    // LINK YOUR DASHBOARD FORM
                    Parent root = FXMLLoader.load(getClass().getResource("hopdong.fxml"));
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
                  
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void close(ActionEvent event){
        System.exit(0);
    }
    
    public void minimize(ActionEvent event) {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
