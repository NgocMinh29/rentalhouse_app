/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package runner;

import com.mycompany.userapp.Oracleconn;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author NGUYEN MY NGAN
 */
public class MainRunner {
    
    public static void main(String[] arg){
        Oracleconn oracleConn = new Oracleconn();
        Connection conn=oracleConn.getConn();
        System.out.print(conn);
    }
}
