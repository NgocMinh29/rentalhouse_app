/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class HoaDonDAO {
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    public void ThemHoaDon(String hdi, String pi, String t, String n, String tt, String trt, String cn){
        String sql = "INSERT INTO HOADON (MAHD,MAPHONG,THANG,NAM,TONGTIEN,TRANGTHAI,CONNO) "
                + "VALUES(?,?,?,?,?,?,?)";
        
        connect = database.getConn();
        try{
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, hdi);
        //prepare.setString(2, hoadon_maphong.getText());
        prepare.setString(2, pi);
        prepare.setString(3, t);
        prepare.setString(4, n);
        prepare.setString(5, tt);
        prepare.setString(6, trt);
        prepare.setString(7, cn);

        prepare.executeUpdate();
        } catch (SQLException e){}
    }
    
}
