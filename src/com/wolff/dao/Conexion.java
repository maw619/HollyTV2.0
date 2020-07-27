//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wolff.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conn;

    public Conexion() {
    }

    public void getConn() {
		/*
		 * String url = "jdbc:mysql://localhost:3306/holly"; String user = "root";
		 * String pass = "";
		 */

		  String user = "hollystv_marco"; String password = "Holly"; String dbHost =
		  "mysql3000.mochahost.com"; String dbName = "hollystv_db"; String url
		  ="jdbc:mysql://"+dbHost+":3306/"+dbName;
        
		  try { Class.forName("com.mysql.jdbc.Driver"); conn =
				  DriverManager.getConnection(url,user,password);
				  System.out.println("connected"); }catch(SQLException | ClassNotFoundException
				  e) { e.printStackTrace(); }
    }
}
