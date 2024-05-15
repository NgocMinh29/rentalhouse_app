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
    
    private static Connection connect;
    private static PreparedStatement prepare;
    private static Statement statement;
    private static ResultSet result;
    
    public static void ThemHoaDon(String hdi, String pi, String t, String n, String tt, String trt, String cn){
        String sql = "INSERT INTO HOADON (MAHD,MAP,THANG,NAM,TONGTIEN,TRANGTHAI,CONNO) "
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
    
    public static void SuaHoaDon(String hdi, String pi, int t, int n, int tt, String trt, int cn){
        String sql = "UPDATE HOADON SET TONGTIEN = "
                + tt + ", MAP = '"
                //+ hoadon_maphong.getText() + "', THANG = "
                + pi+ "', THANG = "
                + t + ", NAM = "
                + n + ", TRANGTHAI = '"
                + trt + "', CONNO = "
                + cn + " WHERE MAHD = '" 
                + hdi + "'";
        
//        String sql = "UPDATE HOADON "
//                + "SET TONGTIEN = ?, MAPHONG = ?, THANG = ?, NAM = ?, TRANGTHAI = ?, CONNO = ?" +
//                    " WHERE MAHD = ?;";

        connect = database.getConn();
        try {
        statement = connect.createStatement();
        statement.executeUpdate(sql);
        } catch (SQLException e){}
    }
    
    
    
}
